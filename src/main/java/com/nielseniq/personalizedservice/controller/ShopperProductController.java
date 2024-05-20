package com.nielseniq.personalizedservice.controller;

import com.nielseniq.personalizedservice.model.ShopperProductCollection;
import com.nielseniq.personalizedservice.service.ProductMetadataService;
import com.nielseniq.personalizedservice.service.ShopperProductService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ShopperProductController {
    @Autowired
    private ShopperProductService shopperProductService;
    @Autowired
    private ProductMetadataService productMetadataService;

    @PostMapping("/internal/v1/shopper/product")
    public ResponseEntity<String> saveShopperProducts(@RequestBody ShopperProductCollection shopperProductCollection) {
        try {
            shopperProductService.saveShopperProduct(shopperProductCollection);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body("Try Again Later");

        }
        return ResponseEntity.ok("Shopper Product saved successfully");
    }

    @RateLimiter(name = "shopperproductmetadata", fallbackMethod = "tooManyRequest")
    @GetMapping("/external/v1/{shopperId}/product")
    public ResponseEntity getShopperProductMetadata(
            @PathVariable String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        if (limit < 0 || limit > 100) {
            return ResponseEntity.badRequest().body("Limit Should Between 1 to 100 only");
        }
        //    List<ShopperProductCollection> shopperProducts = shopperProductService.getProductsByShopperId(shopperId);

            List<Map<String, Object>> filteredProducts = shopperProductService.getShopperProductMetadata(shopperId, category, brand, offset, limit);
            return ResponseEntity.ok().body(filteredProducts);
    }
    public ResponseEntity tooManyRequest( String shopperId,String category,String brand, int limit,int offset,Exception ex){
        return new ResponseEntity<>("You Exceeded The User Limit, Kindly Try After Some Time", HttpStatusCode.valueOf(429));

    }
}

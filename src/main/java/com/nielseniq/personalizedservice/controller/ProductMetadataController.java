package com.nielseniq.personalizedservice.controller;

import com.nielseniq.personalizedservice.entity.ProductMetadata;
import com.nielseniq.personalizedservice.entity.ShopperProduct;
import com.nielseniq.personalizedservice.service.ProductMetadataService;
import com.nielseniq.personalizedservice.service.ShopperProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal")
public class ProductMetadataController {
    @Autowired
    private ShopperProductService shopperProductService;
    @Autowired
    private ProductMetadataService productMetadataService;



    @PostMapping("/v1/product/metadata")
    public ResponseEntity<String> saveProductMetadata(@RequestBody ProductMetadata productMetadata) {
        try{
            productMetadataService.saveProductMetadata(productMetadata);
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body("Try Again Later");

        }
        return ResponseEntity.ok("Product Metadata saved successfully");
    }
    }
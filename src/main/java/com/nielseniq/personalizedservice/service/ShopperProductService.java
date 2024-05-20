package com.nielseniq.personalizedservice.service;

import com.nielseniq.personalizedservice.entity.ShopperProduct;
import com.nielseniq.personalizedservice.model.Product;
import com.nielseniq.personalizedservice.model.ShopperProductCollection;
import com.nielseniq.personalizedservice.repo.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopperProductService {
    @Autowired
    private ShopperProductRepository shopperProductRepository;

    public List<ShopperProductCollection> getProductsByShopperId(String shopperId) {
        return shopperProductRepository.findByShopperId(shopperId);
    }

    public void saveShopperProduct(ShopperProductCollection shopperProductCollection) {
        for(Product product:shopperProductCollection.getShelf())
        {
            ShopperProduct shopperProduct=new ShopperProduct(shopperProductCollection.getShopperId(),product.getProductId(),product.getRelevancyScore());
            shopperProductRepository.save(shopperProduct);

        }
    }

    public List<Map<String, Object>> getShopperProductMetadata(String shopperId, String category, String brand, int offset, int limit) {
        List<Map<String, Object>> resultSet =null;
        if(category==null && brand==null){
            resultSet=shopperProductRepository.findProductByShopperId(shopperId,offset,limit);
        }
        if(category != null && brand !=null){
            resultSet=    shopperProductRepository.findShopperByIdAndBrandAndCategory(shopperId,category,brand,offset,limit);
        }else if(category != null){
            resultSet=    shopperProductRepository.findShopperByIdAndCategory(shopperId,category,offset,limit);
        }else if(brand != null){
            resultSet=   shopperProductRepository.findShopperByIdAndBrand(shopperId,brand,offset,limit);
        }
        return resultSet;
    }

}

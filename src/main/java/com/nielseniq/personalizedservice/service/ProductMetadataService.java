package com.nielseniq.personalizedservice.service;

import com.nielseniq.personalizedservice.entity.ProductMetadata;
import com.nielseniq.personalizedservice.repo.ProductMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMetadataService {
    @Autowired
    private ProductMetadataRepository productMetadataRepository;

    public List<ProductMetadata> getProducts(String category, String brand) {
        if (category != null && brand != null) {
            return productMetadataRepository.findByCategoryAndBrand(category, brand);
        } else if (category != null) {
            return productMetadataRepository.findByCategory(category);
        } else if (brand != null) {
            return productMetadataRepository.findByBrand(brand);
        } else {
            return productMetadataRepository.findAll();
        }
    }

    public void saveProductMetadata(ProductMetadata productMetadata) {
        productMetadataRepository.save(productMetadata);
    }
}

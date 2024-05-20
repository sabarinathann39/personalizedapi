package com.nielseniq.personalizedservice.repo;

import com.nielseniq.personalizedservice.entity.ProductMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMetadataRepository extends CrudRepository<ProductMetadata, String> {
    List<ProductMetadata> findByCategoryAndBrand(String category, String brand);
    List<ProductMetadata> findByCategory(String category);
    List<ProductMetadata> findByBrand(String brand);
    List<ProductMetadata> findAll();



}

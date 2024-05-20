package com.nielseniq.personalizedservice.repo;

import com.nielseniq.personalizedservice.entity.ShopperProduct;
import com.nielseniq.personalizedservice.model.ShopperProductCollection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShopperProductRepository extends CrudRepository<ShopperProduct, Long> {
    List<ShopperProductCollection> findByShopperId(String shopperId);

    @Query(value = "SELECT sp.shopper_id, pm.category, pm.brand "
            + " from txn_shopper_product sp Inner Join cfg_product_metadata pm"
            + " on sp.product_id=pm.product_id where sp.shopper_id=?1  offset ?2 limit ?3"
            , nativeQuery = true)
    List<Map<String, Object>> findProductByShopperId(String id, int offset, int limit);

    @Query(value = "SELECT sp.shopper_id, pm.category, pm.brand "
            + " from txn_shopper_product sp Inner Join cfg_product_metadata pm"
            + " on sp.product_id=pm.product_id where sp.shopper_id=?1 and  pm.brand=?2 offset ?3 limit ?4"
            , nativeQuery = true)
    List<Map<String, Object>> findShopperByIdAndBrand(String id,String brand, int offset, int limit);

    @Query(value = "SELECT sp.shopper_id, pm.category, pm.brand "
            + " from txn_shopper_product sp Inner Join cfg_product_metadata pm"
            + " on sp.product_id=pm.product_id where sp.shopper_id=?1 and  pm.category=?2 offset ?3 limit ?4"
            , nativeQuery = true)
    List<Map<String, Object>> findShopperByIdAndCategory(String id,String category, int offset, int limit);

    @Query(value = "SELECT sp.shopper_id, pm.category, pm.brand "
            + " from txn_shopper_product sp Inner Join cfg_product_metadata pm"
            + " on sp.product_id=pm.product_id where sp.shopper_id=?1 and pm.category=?2 and  pm.brand=?3 offset ?4 limit ?5"
            , nativeQuery = true)
    List<Map<String, Object>> findShopperByIdAndBrandAndCategory(String id,String category, String brand, int offset, int limit);
}

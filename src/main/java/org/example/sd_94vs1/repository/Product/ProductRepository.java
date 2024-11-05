package org.example.sd_94vs1.repository.Product;

import org.example.sd_94vs1.entity.product.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE p.productCode LIKE :productCodePrefix% AND p.productType.productTypeCode = :productTypeCode")
    List<Product> findProductsByCodeAndType(@Param("productCodePrefix") String productCodePrefix, @Param("productTypeCode") String productTypeCode);
}

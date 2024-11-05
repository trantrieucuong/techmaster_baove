package org.example.sd_94vs1.repository.Product;

import org.example.sd_94vs1.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
    // Bạn có thể định nghĩa các phương thức truy vấn tùy chỉnh tại đây
}

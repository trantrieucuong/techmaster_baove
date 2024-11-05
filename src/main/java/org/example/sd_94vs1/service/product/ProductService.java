package org.example.sd_94vs1.service.product;

import org.example.sd_94vs1.entity.product.Product;
import org.example.sd_94vs1.repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findProductsByCodeAndType(String codePrefix, String productTypeCode) {
        return productRepository.findProductsByCodeAndType(codePrefix, productTypeCode);
    }

}

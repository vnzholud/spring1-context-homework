package ru.zholud.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {

        return productRepository.findById(id).getTitle();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public boolean isProductIdExist(Long id) {
        return productRepository.findAll().stream().anyMatch(p -> p.getId().equals(id));
    }


}

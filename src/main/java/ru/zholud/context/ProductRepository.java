package ru.zholud.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milch", 32L),
                new Product(2L, "Brot", 25L),
                new Product(3L, "Buter", 120L),
                new Product(4L, "Fleich", 420L),
                new Product(5L, "Wein", 1250L),
                new Product(6L, "Case", 330L),
                new Product(7L, "Wasser", 150L)
        ));
    }


    public List<Product> findAll() {

        products.forEach(System.out::println);

        return null;
    }


    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }
}

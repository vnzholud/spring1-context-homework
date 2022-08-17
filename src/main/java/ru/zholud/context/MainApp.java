package ru.zholud.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        System.out.println(productService.findById(2L));
        System.out.println("___________________________");
        ProductRepository ProductRepository = context.getBean(ProductRepository.class);
        System.out.println(ProductRepository.findAll());
        System.out.println("___________________________");


        CartService cartService = context.getBean(CartService.class);
        System.out.println(cartService.getCurrentCart());
        cartService.addToCartByProductId(1L);
        cartService.addToCartByProductId(2L);
        cartService.addToCartByProductId(4L);
        cartService.addToCartByProductId(5L);
        System.out.println(cartService.getCurrentCart());

        System.out.println("___________________________");


        cartService.removeFromCart("Brot");
        System.out.println("___________________________");
        System.out.println(cartService.getCurrentCart());

        context.close();
    }
}

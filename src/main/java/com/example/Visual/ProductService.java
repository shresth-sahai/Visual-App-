package com.example.Visual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addProductToCache(String key,Product product){
        // api -> data pipeline ->
        // id -> 1, 8 ,9



        redisTemplate.opsForValue().set(key,product);

    }
    public Product getProductFromCache(String key){
        return (Product) redisTemplate.opsForValue().get(key);
    }

    @Autowired
    public ProductService (ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}

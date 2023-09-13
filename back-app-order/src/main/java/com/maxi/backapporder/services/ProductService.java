package com.maxi.backapporder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.ProductDTO;
import com.maxi.backapporder.entities.Product;
import com.maxi.backapporder.repositories.ProductRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

     public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado: " +Product.class.getSimpleName()));
    }

    public Page<Product> findAll() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("name").ascending());
        return productRepository.findAll(pageable);
    }

    public Product create(ProductDTO obj) {
        Product newProduct = new Product(null, obj.getName(),obj.getStock(), obj.getPrice());
        newProduct.setId(null);
        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    /*public int findTotalStock(Long id){
        return productRepository.findTotalStock(id);
    }*/

     public Product update(Long id, ProductDTO obj) {
        Product product = findById(id);
        product.setName(obj.getName());
        product.setPrice(obj.getPrice());
        return productRepository.saveAndFlush(product);
    }
    

    public Integer findProductStock(Long productId){
        Integer stock = productRepository.findProductStock(productId);
        return stock;
    }

    public void  stockUpdate(Integer val, Long productId){
        productRepository.stockUpdate(val, productId);
    }
}

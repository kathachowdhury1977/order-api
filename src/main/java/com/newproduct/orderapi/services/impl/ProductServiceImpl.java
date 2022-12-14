package com.newproduct.orderapi.services.impl;

import com.newproduct.orderapi.dto.ProductDTO;
import com.newproduct.orderapi.entities.Product;
import com.newproduct.orderapi.exceptions.ProductNotFoundException;
import com.newproduct.orderapi.repositories.ProductRepository;
import com.newproduct.orderapi.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository repository;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> prod = repository.findAll();
        return prod.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) throws ProductNotFoundException {
        return new ProductDTO(repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public void insert(ProductDTO dto) {
        Product product = repository.save(new Product(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

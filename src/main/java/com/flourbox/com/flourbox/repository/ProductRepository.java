package com.flourbox.com.flourbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flourbox.com.flourbox.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

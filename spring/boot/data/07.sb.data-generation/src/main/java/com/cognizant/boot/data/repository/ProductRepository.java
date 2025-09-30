package com.cognizant.boot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.boot.data.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

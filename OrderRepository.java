package com.lara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lara.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}

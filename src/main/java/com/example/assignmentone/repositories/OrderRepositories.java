package com.example.assignmentone.repositories;


import com.example.assignmentone.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositories extends JpaRepository<Order,Long> {
}

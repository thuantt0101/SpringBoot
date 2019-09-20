package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CustomerEntity;

//Ke tu phien ban Spring 2.1.2.RELEASE thi moi ke thua duoc JpaRepository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}

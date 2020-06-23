package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entities.PaymentEntity;



@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, String>{

	
}

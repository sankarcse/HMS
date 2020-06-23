package com.hms.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.entities.CustomersEntity;

@Repository
public interface CustomersRepo extends JpaRepository<CustomersEntity, String>{

	@Query("select l  from CustomersEntity l where l.sno=:sno")
	CustomersEntity findBySno(@Param("sno") Integer sno);

	 /*@Transactional
	 @Modifying
	@Query("update CustomersEntity c where c.sno=:sno")
	CustomersEntity deleteCustomer(@Param("sno") Integer sno);*/

}

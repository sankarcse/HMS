package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.entities.UserVerification;
@Repository
public interface UserVerificationRepo extends JpaRepository<UserVerification, String>{


	@Query("select verificationCode from UserVerification u where u.userName=:userName")
	public String findVerificationCodeByUserName(@Param("userName") String userName);
	
	
}

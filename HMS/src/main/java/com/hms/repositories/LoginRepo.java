package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entities.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, String> {

	public LoginEntity findByUserNameAndUserPassword(String userName,String userPassword);

}

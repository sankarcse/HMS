package com.hms.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.entities.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, String> {

	public LoginEntity findByUserNameAndUserPassword(String userName,String userPassword);
	
	public LoginEntity findByUserName(String userName);
	
	@Query("select l.email from LoginEntity l where l.userName=:userName")
	public String findEmailByUserName(@Param("userName") String userName);

	@Transactional
    @Modifying
	@Query("update LoginEntity l set l.userPassword=:password where l.userName=:userName")
	public int updatePassword(@Param("userName") String userName, @Param("password") String password);
}

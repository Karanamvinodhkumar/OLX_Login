package com.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.dto.User;
import com.user.entity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	@Query("Select u from UserEntity u where u.userName like (:username)")
	List<UserEntity> findByUserName(@Param("username") String username);

	

}

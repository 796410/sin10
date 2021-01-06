package com.talentica.talenticaproduct.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.talentica.talenticaproduct.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

	public Users findByUserId(Long userId);
	
	public Users findByUserName(String userName);

}

package com.pramithas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pramithas.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findAll();

	public User save(User user);

	public User findById(String id);

	public Long removeById(String id);
}
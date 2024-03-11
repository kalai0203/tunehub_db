package com.example.Student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);

}

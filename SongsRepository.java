package com.example.Student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer> {

	public Songs findByName(String name);

}

package com.example.Student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.entities.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}

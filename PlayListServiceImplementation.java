package com.example.Student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.entities.PlayList;
import com.example.Student.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlaylistService {
	@Autowired

	PlayListRepository prepo;

	@Override
	public void addPlayList(PlayList playlist) {
		prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchPlaylists() {

		return prepo.findAll();
	}
}

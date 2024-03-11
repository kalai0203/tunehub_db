package com.example.Student.services;

import java.util.List;

import com.example.Student.entities.Songs;

public interface SongsService {

	public String addSongs(Songs song);

	public boolean songExists(String name);

	public List<Songs> fetchAllSongs();

	public void updateSong(Songs song);

}

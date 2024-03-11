package com.example.Student.services;

import java.util.List;

import com.example.Student.entities.PlayList;

public interface PlaylistService {

	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchPlaylists();

}

package com.example.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Student.entities.PlayList;
import com.example.Student.entities.Songs;
import com.example.Student.services.PlaylistService;
import com.example.Student.services.SongsService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pserv;

	@Autowired
	SongsService sserv;

	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {

		// fetching the songs using song service
		List<Songs> songslist = sserv.fetchAllSongs();

		// Adding the songs in the model
		model.addAttribute("songslist", songslist);

		// sending createplaylist
		return "createplaylist";

	}

	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		pserv.addPlayList(playlist);

		List<Songs> songsList = playlist.getSongs();
		for (Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playlistsuccess";
	}

	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<PlayList> plist = pserv.fetchPlaylists();
		// System.out.println(plist);
		model.addAttribute("Plist", plist);
		return "viewPlaylists";
	}

}

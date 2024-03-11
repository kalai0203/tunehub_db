package com.example.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Student.entities.Songs;
import com.example.Student.entities.Users;
import com.example.Student.services.SongsService;
import com.example.Student.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)	
	{
		boolean userststus = userv.emailExists(user.getEmail());
		if(userststus == false) 
		{	
			userv.addUser(user);
			return "registerSuccess";
		}
		else
		{
			return "registerfail";
		}
	}
		
		@PostMapping("/login")
		public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session)
		{
			if(userv.validateUser(email, password) == true)
			{
				session.setAttribute("email", email);
				if(userv.getRole(email).equals("admin"))
				{
					return "adminhome";
				}
				else
				{
					return "customerhome";
				}
			}
			else
			{
				return "loginfail";
			}
	}
		
		@GetMapping("/exploreSongs")
		public String exploreSongs(HttpSession session, Model model) {
			
			String email = (String) session.getAttribute("email");
			
			Users user = userv.getUser(email);
			boolean userStatus = user.isPremium();
			if(userStatus == true) {
				List<Songs> songslist = songserv.fetchAllSongs();
				model.addAttribute("songlist" ,songslist);
				return "displaysongs";
			}
			else {
				return "payment";
			}
		}

}

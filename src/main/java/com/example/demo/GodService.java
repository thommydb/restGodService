package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GodService {

	public List<String> getGod(String nationality){
		return Arrays.asList("Zeus", "Afrodita", "Apolo");
	}
}

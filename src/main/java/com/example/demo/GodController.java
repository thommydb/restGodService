package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GodController {
	
	private final GodService godService;
	
	public GodController(GodService godService) {
		this.godService = godService;
	}

	@GetMapping("/greeting")
	public List<String> getGod(@RequestParam(value = "nationality", defaultValue = "World") String nationality) {
		return godService.getGod(nationality);
	}
}

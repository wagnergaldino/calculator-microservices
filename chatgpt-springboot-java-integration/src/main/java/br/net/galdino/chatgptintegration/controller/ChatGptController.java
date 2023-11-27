package br.net.galdino.chatgptintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.galdino.chatgptintegration.service.ChatGptService;

@RestController
@RequestMapping("/bot")
public class ChatGptController {
	
	@Autowired
	private ChatGptService chatGptService;
	
	@GetMapping("/chat")
	public String Chat(@RequestParam("prompt") String prompt) {
		return chatGptService.chat(prompt);
	}

}

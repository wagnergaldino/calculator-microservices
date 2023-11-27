package br.net.galdino.chatgptintegration.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.net.galdino.chatgptintegration.vo.ChatGptRequest;
import br.net.galdino.chatgptintegration.vo.ChatGptResponse;


@Service
public class ChatGptService {
	
	private Logger logger = Logger.getLogger(ChatGptService.class.getName());
	
	@Autowired
	private RestTemplate template;
	
	@Value("${openai.model")
	private String model;
	
	@Value("${openai.api.url}")
	private String url;
	
	public String chat(String prompt) {
		logger.info("Starting Prompt");
		
		ChatGptRequest request = new ChatGptRequest(model, prompt);
		
		logger.info("Processing Prompt");
		
		ChatGptResponse response = template.postForObject(url, request, ChatGptResponse.class);
		
		logger.info("Finishing Prompt");
		
		return response.getChoices().get(0).getMessage().getContent();
	}
	
}

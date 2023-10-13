package br.net.galdino.bookservice.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.net.galdino.bookservice.model.Book;
import br.net.galdino.bookservice.proxy.CambioProxy;
import br.net.galdino.bookservice.repository.BookRepository;
import br.net.galdino.bookservice.response.Cambio;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy;
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/{id}/{currency}")
	public Book getBookById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		var book = repository.getById(id);
		if(book == null) throw new RuntimeException("Currency not supported");
		
		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port + " Feign");
		book.setPrice(cambio.getConvertedValue());
		return book;
	}
	
	/*@SuppressWarnings("deprecation")
	@GetMapping(value = "/{id}/{currency}")
	public Book getBookById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		var book = repository.getById(id);
		if(book == null) throw new RuntimeException("Currency not supported");
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		
		var response = new RestTemplate().getForEntity(
				"http://localhost:8000/cambio-service/{amount}/{from}/{to}", 
				Cambio.class, params);
		
		var cambio = response.getBody();
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port);
		book.setPrice(cambio.getConvertedValue());
		return book;
	}*/

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.News;
import com.example.demo.repository.NewsRepository;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/productos")
public class NewsController {
	
	@Autowired
	NewsRepository productoRepository;
	
	@GetMapping
	public List<News> getProductoAll() {

		return productoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public News getProductosbyId(@PathVariable Integer id) {
		
		Optional<News> producto = productoRepository.findById(id);
		
		if (producto.isPresent()) {
			return producto.get();
		}
		
		return null;

	}
	
	@PostMapping
	public News postProductos(@RequestBody News news) {
		
		productoRepository.save(news);
		
		return news;
		

	}
	
	
	@PutMapping("/{id}")
	public News putProductosbyId(@PathVariable Integer id, @RequestBody News news) {
		
		Optional<News> newsCurrent = productoRepository.findById(id);
		
		if (newsCurrent.isPresent()) {
			
			News newsReturn = newsCurrent.get();
			
			
			newsReturn.setDescripcion(news.getDescripcion());
			newsReturn.setNombre(news.getNombre());
			
			
			productoRepository.save(newsReturn);
			
			return newsReturn;
		}
		
		return null;

	}
	
	@DeleteMapping("/{id}")
	public News deleteProductosbyId(@PathVariable Integer id) {
		
		Optional<News> producto = productoRepository.findById(id);
		
		if (producto.isPresent()) {
			
			News productoReturn = producto.get();
			
			productoRepository.deleteById(id);
			
			return productoReturn;
		}
		
		return null;

	}
	
	
	
}

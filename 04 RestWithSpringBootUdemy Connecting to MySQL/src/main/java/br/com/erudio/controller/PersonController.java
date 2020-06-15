package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	public List<Person> findAll() {

		return personService.findAll();
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") String id) {

		return personService.findById(id);
	}
	
	//@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public Person create(@RequestBody Person person) {

		return personService.create(person);
	}
	
	//@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@PutMapping
	public Person update(@RequestBody Person person) {

		return personService.update(person);
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
	//public void delete(@PathVariable("id") String id) {

		personService.delete(Long.parseLong(id));
		return ResponseEntity.ok().build();
	}
}

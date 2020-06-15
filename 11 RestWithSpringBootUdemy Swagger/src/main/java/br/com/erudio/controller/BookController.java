package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Book Endpoint", description="Description for Book", tags= {"Book Endpoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@ApiOperation(value="find all book recorded")
	@GetMapping(produces={"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {

		List<BookVO> books = bookService.findAll();
		
		books.stream().forEach(p -> p.add((linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel())));
		
		return books;
	}

	@ApiOperation(value="find by id recorded")
	@GetMapping(value="/{id}", produces={"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) {

		BookVO bookVO = bookService.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

	@ApiOperation(value="create recorded")
	@PostMapping(produces={"application/json", "application/xml", "application/x-yaml"}, consumes={"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book) {
		
		BookVO bookVO = bookService.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value="update recorded")
	@PutMapping(produces={"application/json", "application/xml", "application/x-yaml"}, consumes={"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book) {

		BookVO bookVO = bookService.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value="delete recorded")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return ResponseEntity.ok().build();
	}
}

package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.BookVO;
import br.com.erudio.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {
		Book entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}

	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	public BookVO findById(Long id) {
		var entity = DozerConverter.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), BookVO.class);
		return entity;
	}

	public List<BookVO> findAll() {
		System.out.println("aqui");
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}

}

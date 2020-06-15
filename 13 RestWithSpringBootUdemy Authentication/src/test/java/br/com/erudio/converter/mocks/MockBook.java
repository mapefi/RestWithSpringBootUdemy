package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.BookVO;

public class MockBook {


    public Book mockEntity() {
    	return mockEntity(0);
    }
    
    public BookVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> Books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Books.add(mockVO(i));
        }
        return Books;
    }
    
    private Book mockEntity(Integer number) {
    	Book book = new Book();
    	book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date());
        book.setPrice((double) number);
        book.setId(number.longValue());
        book.setTitle("Title Test" + number);
        return book;
    }

    private BookVO mockVO(Integer number) {
    	BookVO book = new BookVO();
    	book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date());
        book.setPrice((double) number);
        book.setKey(number.longValue());
        book.setTitle("Title Test" + number);
        return book;
    }

}
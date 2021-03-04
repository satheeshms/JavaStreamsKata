package com.satz.kata;

import static com.satz.kata.BookUtil.*;

import java.util.List;

import com.satz.kata.pojo.Book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BookUtilTest {
    Book b1 = new Book("Java Complete Reference", "Herb Schildt", 499);
    Book b2 = new Book("Design Patterns", "Eric Gamma", 399);
    Book b3 = new Book("Effective Java", "Joshua Bloch", 299);
    
    Book b4 = new Book("Java Concurrency in Practice", "Joshua Bloch", 199);

    @Test
    public void getAllBookNamesTest(){
       
        List<Book> books = List.of(b1, b2, b3);
        List<String> names = getAllBookNames(books);

        List<String> bookNames = List.of("Java Complete Reference", "Design Patterns", "Effective Java");
        Assertions.assertTrue(bookNames.stream().allMatch( s -> names.contains(s)));
    }

    @Test
    public void getAllBooksCostsMoreThanAValue(){
        List<Book> books = List.of(b1, b2, b3);
        List<Book> costly = getAllBooksCostsMoreThan(books, 300);

        List<Book> expected = List.of(b1,b2);
        Assertions.assertTrue(expected.stream().allMatch(s -> costly.contains(s)));
    }

}

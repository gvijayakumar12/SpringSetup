package com.vijay.security;

import com.vijay.security.model.Book;
import com.vijay.security.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.ok(bookRepository.findById(id).orElseThrow());
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book request) {
        return ResponseEntity.ok(bookRepository.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book request) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setBook_name(request.getBook_name());
        book.setAuthor_name(request.getAuthor_name());
        book.setNo_of_pages(request.getNo_of_pages());

        return ResponseEntity.ok(bookRepository.save(book));
    }

}

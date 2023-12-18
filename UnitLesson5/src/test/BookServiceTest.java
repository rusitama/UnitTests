import org.example.Book;
import org.example.BookRepository;
import org.example.BookService;

import org.example.InMemoryBookRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

class BookServiceTest {
    // Юнит-тесты:
    // 1. Тест на создание экземпляра Book:
    @Test
    void testCreateBookInstance() {
        Book book = new Book("1", "TestBook", "TestAuthor");
        assertNotNull(book);
        assertEquals("1", book.getId());
        assertEquals("TestBook", book.getTitle());
        assertEquals("TestAuthor", book.getAuthor());
    }
    // 2. Тест на установку и получение данных в Book:
    @Test
    void testSetAndGetBookData() {
        Book book = new Book("1");
        book.setTitle("UpdatedTitle");
        book.setAuthor("UpdatedAuthor");
        assertEquals("UpdatedTitle", book.getTitle());
        assertEquals("UpdatedAuthor", book.getAuthor());
    }

    // 3. Тест на создание экземпляра InMemoryBookRepository:
    @Test
    void testCreateInMemoryBookRepository() {
        InMemoryBookRepository repository = new InMemoryBookRepository();
        assertNotNull(repository);
        assertTrue(repository.findAll().isEmpty());
    }

    // 4. Тест на добавление книги в InMemoryBookRepository:
    @Test
    void testAddBookToRepository() {
        InMemoryBookRepository repository = new InMemoryBookRepository();
        Book book = new Book("3", "NewBook", "NewAuthor");
        repository.addBook(book);
        assertEquals(book, repository.findById("3"));
    }

    // 5. Тест на поиск книги по id в InMemoryBookRepository:
    @Test
    void testFindBookByIdInRepository() {
        InMemoryBookRepository repository = new InMemoryBookRepository();
        Book book = repository.findById("1");
        assertNotNull(book);
        assertEquals("Book1", book.getTitle());
    }

    //___________________________________________________________________________________________
    // Интеграционные тесты:
    // 1. Тест интеграции BookService с InMemoryBookRepository:
    @Test
    void testBookServiceIntegrationWithRepository() {
        BookRepository mockRepository = mock(InMemoryBookRepository.class);
        when(mockRepository.findById("1")).thenReturn(new Book("1", "MockBook", "MockAuthor"));

        BookService bookService = new BookService(mockRepository);
        Book result = bookService.findBookById("1");

        assertNotNull(result);
        assertEquals("MockBook", result.getTitle());
        assertEquals("MockAuthor", result.getAuthor());
    }

    //____________________________________________________________________________________________
    //Сквозные тесты:
    // 1. Тест на добавление, редактирование и удаление контакта:
    @Test
    void testAddEditDeleteBook() {
        BookService bookService = new BookService(new InMemoryBookRepository());
        Book newBook = new Book("3", "NewBook", "NewAuthor");

        // Add
        bookService.addBook(newBook);
        assertEquals(newBook, bookService.findBookById("3"));

        // Edit
        newBook.setTitle("UpdatedTitle");
        bookService.updateBook(newBook);
        assertEquals("UpdatedTitle", bookService.findBookById("3").getTitle());

        // Delete
        bookService.deleteBook("3");
        assertNull(bookService.findBookById("3"));
    }

    // 2. Тест на поиск несуществующей книги:
    @Test
    void testFindNonExistingBook() {
        BookService bookService = new BookService(new InMemoryBookRepository());
        assertNull(bookService.findBookById("NonExistingId"));
    }

    // 3. Тест на получение списка всех книг:
    @Test
    void testGetAllBooks() {
        BookService bookService = new BookService(new InMemoryBookRepository());
        List<Book> allBooks = bookService.getAllBooks();
        assertEquals(2, allBooks.size());
    }

    // 4. Тест на обновление данных книги:
    @Test
    void testUpdateBookData() {
        BookService bookService = new BookService(new InMemoryBookRepository());
        Book book = new Book("1", "UpdatedBook", "UpdatedAuthor");

        // Update
        bookService.updateBook(book);
        assertEquals("UpdatedBook", bookService.findBookById("1").getTitle());
        assertEquals("UpdatedAuthor", bookService.findBookById("1").getAuthor());
    }
}

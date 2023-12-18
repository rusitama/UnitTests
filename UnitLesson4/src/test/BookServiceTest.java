import org.example.Book;
import org.example.BookRepository;
import org.example.BookService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

class BookServiceTest {

    @Test
    void testFindBookById() {
        // Arrange
        String bookId = "1";
        BookRepository mockRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockRepository);

        // Stubbing: указываем, как должен вести себя мок при вызове метода findById
        when(mockRepository.findById(bookId)).thenReturn(new Book(bookId, "MockBook", "MockAuthor"));

        // Act
        Book result = bookService.findBookById(bookId);

        // Assert
        assertNotNull(result);
        assertEquals("MockBook", result.getTitle());
        assertEquals("MockAuthor", result.getAuthor());

        // Verify: проверяем, что метод findById был вызван ровно один раз с переданным аргументом
        verify(mockRepository, times(1)).findById(bookId);
    }

    @Test
    void testFindAllBooks() {
        // Arrange
        BookRepository mockRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockRepository);

        // Stubbing: указываем, как должен вести себя мок при вызове метода findAll
        List<Book> expectedBooks = Arrays.asList(new Book("1", "MockBook1", "MockAuthor1"),
                new Book("2", "MockBook2", "MockAuthor2"));
        when(mockRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertNotNull(result);
        assertEquals(expectedBooks.size(), result.size());
        assertEquals(expectedBooks.get(0).getTitle(), result.get(0).getTitle());
        assertEquals(expectedBooks.get(1).getAuthor(), result.get(1).getAuthor());

        // Verify: проверяем, что метод findAll был вызван ровно один раз
        verify(mockRepository, times(1)).findAll();
    }
}

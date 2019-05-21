package sk.pattern.cqrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.List;

import sk.pattern.cqrs.commands.CommandServiceImpl;
import sk.pattern.cqrs.commands.ICommandService;
import sk.pattern.cqrs.dto.Author;
import sk.pattern.cqrs.dto.Book;
import sk.pattern.cqrs.queries.IQueryService;
import sk.pattern.cqrs.queries.QueryServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * Integration test of IQueryService and ICommandService with h2 data
 *
 */
public class IntegrationTest {

  private static IQueryService queryService;
  private static ICommandService commandService;

  @BeforeAll
  public static void initializeAndPopulateDatabase() {
    commandService = new CommandServiceImpl();
    queryService = new QueryServiceImpl();

    // create first author1
    commandService.authorCreated("username1", "name1", "email1");

    // create author1 and update all its data
    commandService.authorCreated("username2", "name2", "email2");
    commandService.authorEmailUpdated("username2", "new_email2");
    commandService.authorNameUpdated("username2", "new_name2");
    commandService.authorUsernameUpdated("username2", "new_username2");

    // add book1 to author1
    commandService.bookAddedToAuthor("title1", 10, "username1");

    // add book2 to author1 and update all its data
    commandService.bookAddedToAuthor("title2", 20, "username1");
    commandService.bookPriceUpdated("title2", 30);
    commandService.bookTitleUpdated("title2", "new_title2");

  }

  @Test
  public void testGetAuthorByUsername() {
    Author author = queryService.getAuthorByUsername("username1");
    assertEquals("username1", author.getUsername());
    assertEquals("name1", author.getName());
    assertEquals("email1", author.getEmail());
  }

  @Test
  public void testGetUpdatedAuthorByUsername() {
    Author author = queryService.getAuthorByUsername("new_username2");
    Author expectedAuthor = new Author("new_name2", "new_email2", "new_username2");
    assertEquals(expectedAuthor, author);

  }

  @Test
  public void testGetBook() {
    Book book = queryService.getBook("title1");
    assertEquals("title1", book.getTitle());
    assertEquals(10, book.getPrice(), 0.01);
  }

  @Test
  public void testGetAuthorBooks() {
    List<Book> books = queryService.getAuthorBooks("username1");
    assertEquals(2, books.size());
    assertTrue(books.contains(new Book("title1", 10)));
    assertTrue(books.contains(new Book("new_title2", 30)));
  }

  @Test
  public void testGetAuthorBooksCount() {
    BigInteger bookCount = queryService.getAuthorBooksCount("username1");
    assertEquals(new BigInteger("2"), bookCount);
  }

  @Test
  public void testGetAuthorsCount() {
    BigInteger authorCount = queryService.getAuthorsCount();
    assertEquals(new BigInteger("2"), authorCount);
  }

}
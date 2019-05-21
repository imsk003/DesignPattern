package sk.pattern.cqrs.queries;

import java.math.BigInteger;
import java.util.List;

import sk.pattern.cqrs.dto.Author;
import sk.pattern.cqrs.dto.Book;



/**
 * 
 * This interface represents the query methods of the CQRS pattern
 *
 */
public interface IQueryService {

  Author getAuthorByUsername(String username);

  Book getBook(String title);

  List<Book> getAuthorBooks(String username);

  BigInteger getAuthorBooksCount(String username);

  BigInteger getAuthorsCount();

}

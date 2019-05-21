package sk.pattern.cqrs.app;

import java.math.BigInteger;
import java.util.List;

import sk.pattern.cqrs.commands.CommandServiceImpl;
import sk.pattern.cqrs.commands.ICommandService;
import sk.pattern.cqrs.dto.Author;
import sk.pattern.cqrs.dto.Book;
import sk.pattern.cqrs.queries.IQueryService;
import sk.pattern.cqrs.queries.QueryServiceImpl;
import sk.pattern.cqrs.util.HibernateUtil;

public class App {


  public static void main(String[] args) {
    ICommandService commands = new CommandServiceImpl();

    // Create Authors and Books using CommandService
    commands.authorCreated("ak", "Arun", "ak@gmail.com");
    commands.authorCreated("sk", "Selva", "sk@gmail.com");
    commands.authorCreated("akr", "Karthi", "akr@gmail.com");

    commands.bookAddedToAuthor("Domain-Driven Design", 60.08, "ak");
    commands.bookAddedToAuthor("Effective Java", 40.54, "sk");
    commands.bookAddedToAuthor("Java Puzzlers", 39.99, "sk");
    commands.bookAddedToAuthor("Java Concurrency in Practice", 29.40, "sk");
    commands.bookAddedToAuthor("Patterns of Enterprise Application Architecture", 54.01, "akr");
    commands.bookAddedToAuthor("Domain Specific Languages", 48.89, "akr");
    commands.authorNameUpdated("sk", "SK");

    IQueryService queries = new QueryServiceImpl();

    // Query the database using QueryService
    Author author = queries.getAuthorByUsername("sk");
    BigInteger BooksCount = queries.getAuthorBooksCount("sk");
    BigInteger authorsCount = queries.getAuthorsCount();
    Book dddBook = queries.getBook("Domain-Driven Design");
    List<Book> Books = queries.getAuthorBooks("sk");
    
    System.out.println("Author : " + author);
    System.out.println("number of books : " + BooksCount);
    System.out.println("Number of authors : " + authorsCount);
    System.out.println("DDD book : " + dddBook);
    System.out.println("Books : " + Books);

    HibernateUtil.getSessionFactory().close();
  }

}

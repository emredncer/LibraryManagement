import jakarta.persistence.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); //entity manager created!
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        Author author = new Author();
        author.setName("Recaizade Mahmut EKREM");
        author.setBirthDate(LocalDate.of(1912,06,17));
        author.setCountry("Uganda");
        entityManager.persist(author);

        Publisher publisher = new Publisher();
        publisher.setName("Zambak Yayınları");
        publisher.setAddress("Rüzgarlı Ulus Ankara");
        publisher.setEstablishmentYear(1990);
        entityManager.persist(publisher);

        Book book = new Book();
        book.setName("Araba Sevdası");
        book.setStock(20);
        book.setPublicationYear(1970);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        Category category = new Category();
        category.setDescription("Roman");
        category.setName("Tarih");
        entityManager.persist(category);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Ankaralı Namık");
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowingDate(null);
        entityManager.persist(bookBorrowing);


        transaction.commit();

    }
}

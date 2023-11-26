import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<BookBorrowing> bookBorrowings;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

}


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial", unique = true, nullable = false)
    private Long id;

    @Column(name = "name",nullable = false,length = 255)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name = "country", nullable = false,length = 50)  //nullable false verdim vatansızlar kitap yazmasın
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)     //bookta tanımladığım nesneye mapliyorum.
    private List<Book> bookList;


}

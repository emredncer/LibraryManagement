import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false,columnDefinition = "serial")
    private Long id;

    @Column(name = "name",unique = true,nullable = false,length = 100)
    private String name;

    @Column(name = "establishment_year")
    private int establishmentYear;
    @Column(name= "address")
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;


}

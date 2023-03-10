package rts_qa_spring.quotes;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Person")
@Table(
        name = "person",
        uniqueConstraints = {
            @UniqueConstraint(name = "person_id_unique", columnNames = "id"),
            @UniqueConstraint(name = "unique_data_constraint", columnNames={"first_name", "last_name", "birth_date"})
        }
)
public class Person {

    @NotNull(message = "Id cannot be null")
    @Column(
            name = "id",
            columnDefinition = "SMALLINT"
    )
    @Id
    private Long id;

    @NotNull(message = "First name cannot be null")
    @Column(
            name = "first_name",
            columnDefinition = "TEXT"
    )
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Column(
            name = "last_name",
            columnDefinition = "TEXT"
    )
    private String lastName;

    @NotNull(message = "Birth date cannot be null")
    @Column(
            name = "birth_date",
            columnDefinition = "TEXT"
    )
    private String birthDate;

    @Column(
            name = "death_date",
            columnDefinition = "TEXT"
    )
    private String deathDate;

    @Column(
            name = "person_note",
            columnDefinition = "TEXT"
    )
    private String personNote;

    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "person",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Quote> quote = new ArrayList<>();

    public void addQuote(Quote quote) {
        if (!this.quote.contains(quote)) {
            this.quote.add(quote);
            quote.setPerson(this);
        }
    }

    public void removeQuote(Quote quote) {
        if (this.quote.contains(quote)) {
            this.quote.remove(quote);
            quote.setPerson(null);
        }
    }
}

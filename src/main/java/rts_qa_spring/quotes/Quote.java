package rts_qa_spring.quotes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Quote")
@Table(
        name = "quote",
        uniqueConstraints = {
                @UniqueConstraint(name = "quote_unique", columnNames = "quote")
        })
public class Quote {
    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "quote_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @NotNull(message = "Quote cannot be null")
    @Column(
            name = "quote"
    )
    private String quote;

    @Column(
            name = "quote_note"
    )
    private String quoteNote;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "person_quote_fk"
            )
    )
    private Person person;
}

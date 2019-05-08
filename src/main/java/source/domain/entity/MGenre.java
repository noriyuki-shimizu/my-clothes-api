package source.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "m_genre")
@Data
public class MGenre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "genre_name", unique = true)
    @NotNull
    private String name;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;
}

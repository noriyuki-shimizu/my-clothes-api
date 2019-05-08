package source.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "m_image")
@Data
public class MImage {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image_name")
    @NotNull
    private String name;

    @Column(name = "image_path")
    @NotNull
    private String path;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;

}

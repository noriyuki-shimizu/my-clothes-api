package source.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "b_user")
@Data
@Builder
public class BUser extends TimestampEntity {

    @Tolerate
    public BUser() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0l;

    @Column(name = "uid")
    @NotNull
    private String uid = "";

    @Column(name = "name")
    private String name = "";

    @Column(name = "e_mail")
    @NotNull
    private String eMail = "";
}

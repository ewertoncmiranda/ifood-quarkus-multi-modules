package miranda.quarkus.ifood.cadastro.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Restaurante extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CreationTimestamp
    private Date dataCriacao;
    @UpdateTimestamp
    private Date dataAtualizacao;
    @OneToOne
    private Localizacao localizacao;
    @OneToMany
    private List<Prato> pratos;

    private Long id ;
    private String proprietario;
    private String nome ;
    private String cnpj;

}

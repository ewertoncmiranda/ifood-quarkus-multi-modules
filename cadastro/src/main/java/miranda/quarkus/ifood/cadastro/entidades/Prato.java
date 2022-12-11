package miranda.quarkus.ifood.cadastro.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Prato  extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nome ;
    private String descricao;
    private BigDecimal valor;

    @ManyToOne
    private Restaurante restaurante ;
}

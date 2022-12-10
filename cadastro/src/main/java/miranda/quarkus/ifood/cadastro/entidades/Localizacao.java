package miranda.quarkus.ifood.cadastro.entidades;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "localizacao")
public class Localizacao  extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Double latitude ;
    private Double longitude ;

}

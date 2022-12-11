package miranda.quarkus.ifood.cadastro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PratoDTO {

    private String nome ;
    private String descricao;
    private BigDecimal valor;

}

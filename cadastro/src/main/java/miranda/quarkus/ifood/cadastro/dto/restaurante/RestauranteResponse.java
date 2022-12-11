package miranda.quarkus.ifood.cadastro.dto.restaurante;

import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.quarkus.ifood.cadastro.dto.localizacao.LocalizacaoDTO;

@Data
@NoArgsConstructor
public class RestauranteResponse {

    private Long id ;
    private String nome ;
    private String cnpj;
    private LocalizacaoDTO localizacao;
}

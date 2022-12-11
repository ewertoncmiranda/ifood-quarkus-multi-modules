package miranda.quarkus.ifood.cadastro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestauranteResponse {

    private Long id ;
    private String nome ;
    private String cnpj;

    private LocalizacaoDTO localizacao;
}

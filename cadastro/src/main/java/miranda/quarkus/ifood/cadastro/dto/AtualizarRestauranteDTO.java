package miranda.quarkus.ifood.cadastro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarRestauranteDTO {
    private String nome ;
    private String cnpj;
    private LocalizacaoDTO localizacao;
}

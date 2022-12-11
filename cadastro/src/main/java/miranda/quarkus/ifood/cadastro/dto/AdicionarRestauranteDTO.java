package miranda.quarkus.ifood.cadastro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdicionarRestauranteDTO {
    private String proprietario;
    private String nomeFantasia ;
    private String cnpj;
    private LocalizacaoDTO localizacao;

}

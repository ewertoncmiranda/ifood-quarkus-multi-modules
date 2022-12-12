package miranda.quarkus.ifood.cadastro.dto.restaurante;

import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.quarkus.ifood.cadastro.dto.localizacao.LocalizacaoDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AdicionarRestauranteDTO {

    @NotEmpty
    private String proprietario;

    @Size(min = 3 , max = 10)
    private String nomeFantasia ;
    private String cnpj;
    private LocalizacaoDTO localizacao;

}

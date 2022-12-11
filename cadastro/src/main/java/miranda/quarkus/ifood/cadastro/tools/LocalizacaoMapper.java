package miranda.quarkus.ifood.cadastro.tools;

import miranda.quarkus.ifood.cadastro.dto.LocalizacaoDTO;
import miranda.quarkus.ifood.cadastro.entidades.Localizacao;
import org.mapstruct.Mapper;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface LocalizacaoMapper {

    LocalizacaoDTO toLocalizacaoDTO(Localizacao localizacao);
    Localizacao toLocalizacao(LocalizacaoDTO dto);
}

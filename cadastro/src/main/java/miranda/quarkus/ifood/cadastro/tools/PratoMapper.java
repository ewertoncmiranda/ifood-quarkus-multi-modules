package miranda.quarkus.ifood.cadastro.tools;

import miranda.quarkus.ifood.cadastro.dto.PratoDTO;
import miranda.quarkus.ifood.cadastro.entidades.Prato;
import org.mapstruct.Mapper;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface PratoMapper {

    Prato toPrato (PratoDTO dto);
    PratoDTO toPratoDTP (Prato prato);

}

package miranda.quarkus.ifood.cadastro.tools;

import miranda.quarkus.ifood.cadastro.dto.prato.PratoDTO;
import miranda.quarkus.ifood.cadastro.entidades.Prato;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import javax.enterprise.context.ApplicationScoped;
@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface PratoMapper {

    Prato toPrato (PratoDTO dto);
    PratoDTO toPratoDTO(Prato prato);
    void toPrato (PratoDTO dto , @MappingTarget Prato prato);

}

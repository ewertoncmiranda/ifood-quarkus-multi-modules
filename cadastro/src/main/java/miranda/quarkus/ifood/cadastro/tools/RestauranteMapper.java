package miranda.quarkus.ifood.cadastro.tools;

import miranda.quarkus.ifood.cadastro.dto.restaurante.AdicionarRestauranteDTO;
import miranda.quarkus.ifood.cadastro.dto.restaurante.AtualizarRestauranteDTO;
import miranda.quarkus.ifood.cadastro.dto.restaurante.RestauranteResponse;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface RestauranteMapper {
    @Mapping(target = "nome" ,source = "nomeFantasia")
    Restaurante toRestaurante(AdicionarRestauranteDTO dto);
    void toRestaurante(AtualizarRestauranteDTO dto, @MappingTarget Restaurante restaurante);
    RestauranteResponse toRestauranteResponse(Restaurante restaurante);
}

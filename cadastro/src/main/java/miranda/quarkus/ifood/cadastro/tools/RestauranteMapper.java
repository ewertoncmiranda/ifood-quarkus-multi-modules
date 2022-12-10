package miranda.quarkus.ifood.cadastro.tools;

import miranda.quarkus.ifood.cadastro.dto.AdicionarRestauranteDTO;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestauranteMapper {

    Restaurante toRestaurante(AdicionarRestauranteDTO dto);
}

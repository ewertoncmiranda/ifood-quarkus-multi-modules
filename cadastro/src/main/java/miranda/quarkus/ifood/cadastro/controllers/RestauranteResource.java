package miranda.quarkus.ifood.cadastro.controllers;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteResource {


    @GET
    public List<Restaurante> buscarRestaurante(){
        return Restaurante.listAll();
    }

    @POST
    @Path("/{id}")
    public void adicionarRestaurante(Restaurante dto){
        dto.persist();
    }

    @PUT
    @Path("/{ID}")
    public boolean atualizar(@PathParam("id") Long id, Restaurante dto){
        Optional<Restaurante> restauranteOpt = Restaurante.findByIdOptional(id);
        if(restauranteOpt.isEmpty()) throw new NotFoundException();
        PanacheEntityBase restaurante = restauranteOpt.get();
        return  true;
    }





}

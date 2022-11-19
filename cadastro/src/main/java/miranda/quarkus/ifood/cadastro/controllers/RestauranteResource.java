package miranda.quarkus.ifood.cadastro.controllers;

import miranda.quarkus.ifood.cadastro.entidades.Restaurante;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteResource {


    @GET
    public List<Restaurante> buscarRestaurante(){
        return Restaurante.listAll();
    }



}

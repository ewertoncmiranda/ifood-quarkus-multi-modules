package miranda.quarkus.ifood.cadastro.controllers;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import miranda.quarkus.ifood.cadastro.dto.AdicionarRestauranteDTO;
import miranda.quarkus.ifood.cadastro.dto.AtualizarRestauranteDTO;
import miranda.quarkus.ifood.cadastro.dto.RestauranteResponse;
import miranda.quarkus.ifood.cadastro.entidades.Prato;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;
import miranda.quarkus.ifood.cadastro.tools.PratoMapper;
import miranda.quarkus.ifood.cadastro.tools.RestauranteMapper;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "restaurante")
public class RestauranteResource {

    @Inject
    RestauranteMapper  restauranteMapper;

    @Inject
    PratoMapper pratoMapper ;

    @GET
    @Tag(name = "restaurante")
    public List<RestauranteResponse> buscarRestaurante(){
        Stream<Restaurante> restaurantes = Restaurante.streamAll();

        return restaurantes
                .map(it -> restauranteMapper.toRestauranteResponse(it))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    @Tag(name = "restaurante")
    public Response adicionarRestaurante(AdicionarRestauranteDTO dto){
        Restaurante restaurante = restauranteMapper.toRestaurante(dto);
        restaurante.persistAndFlush();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Tag(name = "restaurante")
    @Transactional
    public Response atualizarRestaurante(@PathParam("id") Long id, AtualizarRestauranteDTO dto){
        Optional<Restaurante> restauranteOpt = Restaurante.findByIdOptional(id);
        if(restauranteOpt.isEmpty()) throw new NotFoundException();
        Restaurante restaurante = restauranteOpt.get();
        restauranteMapper.toRestaurante(dto,restaurante);
        restaurante.persistAndFlush();
        return  Response.status(204).build();
    }
    @DELETE
    @Path("/{id}")
    @Tag(name = "restaurante")
    public Response deletar(@PathParam("/{id}") Long id){
        if( !Restaurante.findByIdOptional(id).isEmpty()) Restaurante.deleteById(id);
        throw new NotFoundException();
    }

    @GET
    @Path("/{idRestaurante}/pratos")
    @Tag(name = "prato")
    public List<Prato> buscarPratos(@PathParam("idRestaurante") Long idRestaurante){
        Optional<Restaurante> restauranteOpt = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOpt.isEmpty()) throw new NotFoundException();
        return  Prato.list("restaurante", restauranteOpt.get());
    }

    @POST
    @Path("{idRestaurante}/pratos")
    @Transactional
    @Tag(name = "prato")
    public Response adicionarPrato(@PathParam("idRestaurante") Long idRestaurante ,Prato dto){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()) throw new NotFoundException();

        Prato prato = new Prato();
        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setValor(dto.getValor());
        prato.setRestaurante(restauranteOp.get());

        prato.persistAndFlush();
        return  Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("{/idRestaurante}/pratos/{id}")
    @Transactional
    @Tag(name = "prato")
    public void atualizarPratos(@PathParam("idRestaurante") Long idRestaurante ,@PathParam("id") Long id, Prato dto){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()) throw new NotFoundException("Restaurante não existe.");
        Optional<Prato> pratoOpt = Prato.findByIdOptional(id);

        if(pratoOpt.isEmpty())  throw new NotFoundException("Prato não existe.");
        Prato prato = pratoOpt.get();
        prato.setDescricao(dto.getDescricao());
        prato.setNome(dto.getNome());
        prato.setValor(dto.getValor());

        prato.persistAndFlush();
    }

    @DELETE
    @Path("/{idRestaurante}/pratos/{idPrato}")
    @Tag(name = "prato")
    public boolean deletarPrato(@PathParam("idRestaurante") Long idRestaurante , @PathParam("idPrato") Long idPrato){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()) throw new NotFoundException("Restaurante não existe.");
        Optional<Prato> pratoOpt = Prato.findByIdOptional(idPrato);
        if(pratoOpt.isEmpty())  throw new NotFoundException("Prato não existe.");
        pratoOpt.get().delete();
        return true;
    }

}

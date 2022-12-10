package org.acme;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import miranda.quarkus.ifood.cadastro.entidades.Restaurante;
import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

@DBRider
@QuarkusTest
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestauranteResourceTest {

    @Test
    @DataSet("restaurante-cenario-1.yml")
    public void deveBuscarRestaurantes(){
        String result = RestAssured.given().when()
                .get("/restaurante")
                .then().statusCode(200).extract().asString();
        Approvals.verifyJson(result);
    }
    @Test
    @DataSet("restaurante-cenario-1.yml")
    public void deveAlterarRestaurante(){
        Restaurante dto = new Restaurante();
        dto.setNome("novoNome");;
        Long parameterValue = 123L;
        RestAssured.given().with().pathParam("id",parameterValue)
                .body(dto)
                .when().put("/restaurante/{id}")
                .then().statusCode(Response.Status.NO_CONTENT.getStatusCode()).extract().asString();

       Restaurante byId = Restaurante.findById(parameterValue);



        Assert.assertEquals(dto.getNome(),byId.getNome());
    }




}

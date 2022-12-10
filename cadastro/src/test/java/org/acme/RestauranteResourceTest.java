package org.acme;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

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


}
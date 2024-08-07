package steps;

import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import static org.hamcrest.Matchers.*;

public class CreateOrderSteps {

    private static final String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden {0} en PetStore")
    public void createOrder(String quantity, String shipDate, String status, String complete) {

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 2,\n" +
                        "  \"quantity\": \"" + quantity + "\",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": \"" + complete + "\"" +
                        "}"
                )
                .log().all()
                .post(CREATE_ORDER);
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarTipo(String expectedType) {
        Object tipo = SerenityRest.lastResponse().body().path("type");
        if (tipo != null) {
            System.out.println("Type: " + tipo.toString());
        } else {
            System.out.println("El valor de type es null");
        }
        restAssuredThat(response -> response.body("type", anyOf(equalTo(expectedType), is(nullValue()))));
        System.out.println(SerenityRest.lastResponse().print());
    }

}
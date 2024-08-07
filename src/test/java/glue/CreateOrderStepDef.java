package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.CreateOrderSteps;

public class CreateOrderStepDef {
    @Steps
    private CreateOrderSteps createOrderSteps;

    @When("creo un pedido con quantity {string}, shipDate {string}, status {string}, complete {string}")
    public void creoUnPedidoConQuantityShipDateStatusComplete(String quantity, String shipDate, String status, String complete) {
        createOrderSteps.createOrder( quantity, shipDate, status, complete);
    }

    @Then("^la respuesta debe tener un código de estado (\\d+)$")
    public void la_respuesta_debe_tener_un_codigo_de_estado(int statusCode) {
        createOrderSteps.validarCodigoRespuesta(statusCode);
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
        createOrderSteps.validarTipo(type);
    }
}
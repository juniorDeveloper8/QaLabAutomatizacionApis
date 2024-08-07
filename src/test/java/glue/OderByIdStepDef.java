package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.OrderByIdStep;

public class OderByIdStepDef {

@Steps
private OrderByIdStep orderByIdStep;

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        orderByIdStep.definirurl(url);
    }

    @When("hago la consulta una orden con ID {int}")
    public void hagoLaConsultaUnaOrdenConID(int id) {
        orderByIdStep.consultarById(id);
    }

    @Then("imprimo la orden")
    public void imprimoLaOrden() {
        orderByIdStep.imprimirOrderById();
    }
}

package steps;

import io.restassured.response.Response;
import model.Order;

import static io.restassured.RestAssured.given;

public class OrderByIdStep {

    private static String URL = null;
    Response response;

    public void definirurl(String url) {
        URL = url;
    }

    public void consultarById(int id) {
        response = given()
                .contentType("application/json")
                .log().all()
                .get(URL + "/" + id);
    }

    public void imprimirOrderById() {
        if (response != null) {// para validar la respuesta en objeto
            Order order = response.jsonPath().getObject("", Order.class);
            System.out.println("ID: " + order.getId());
            System.out.println("Pet ID: " + order.getPetId());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Ship Date: " + order.getShipDate());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Complete: " + order.getComplete());
        } else {
            System.out.println("No response available. Please ensure a request has been made.");
        }
    }
}

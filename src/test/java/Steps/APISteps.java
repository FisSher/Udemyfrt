package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class APISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^a GET request is sent to the (.+) endpoint$")
    public void sendGETRequest(String URI) {
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);
    }

    @Then("^a (\\d+) status code is received$")
    public void validateListOfUsers(int expecteStatusCode) {
        response = request
                .when()
                .get("users/FisSher/repos");
        json = response.then().statusCode(expecteStatusCode);
    }

    @Then("^(\\d+) items are present in the (.+) endpoint$")
    public void itemsArePresentInTheEndpoint(int expectedSize, String endpoint) {
        response = request
                .when()
                .get(endpoint);
        Assertions.assertEquals(response.getStatusCode(),200);

        List<String> jsonResponse = response.jsonPath().getList("$");
        int actualSize = jsonResponse.size();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedSize, actualSize),
                () -> Assertions.assertEquals("b", "a"),
                () -> Assertions.assertEquals("a", "a")
        );
    }
}

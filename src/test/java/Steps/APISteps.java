package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class APISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^a GET request is sent to the endpoint$")
    public void sendGETRequest(){
        request = given()
                .baseUri("https://api.github.com")
                .contentType(ContentType.JSON);


    }


    @Then("^a (\\d+) status code is received$")
    public void validateListOfUsers(int expecteStatusCode) {
        response = request
                    .when()
                    .get("users/FisSher/repos");
        json = response.then().statusCode(expecteStatusCode);
    }
}

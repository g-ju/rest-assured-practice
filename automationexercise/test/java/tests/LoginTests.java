package tests;

import api.LoginController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests
{
    private static LoginController loginController;

    @BeforeAll
    static void init()
    {
        loginController = new LoginController();
    }

    @Test
    void api_7_can_verify_valid_details()
    {
        // Created some test accounts outside of these tests. Site doesn't seem to provide any existing data.
        given()
                .spec(loginController.getRequestSpecification())
                .formParam("email", "email100")
                .formParam("password", "test")
        .when()
                .post()
        .then()
                .assertThat()
                .body("responseCode", equalTo(200))
                .body("message", equalTo("User exists!"));
    }

    @Test
    void api_8_cannot_verify_without_email_parameter()
    {
        given()
                .spec(loginController.getRequestSpecification())
                .formParam("password", "test")
        .when()
                .post()
        .then()
                .assertThat()
                .body("responseCode", equalTo(400))
                .body("message", equalTo("Bad request, email or password parameter is missing in POST request."));
    }

    @Test
    void api_9_cannot_delete_using_login_endpoint()
    {
        given()
                .spec(loginController.getRequestSpecification())
        .when()
                .delete()
        .then()
                .assertThat()
                .body("responseCode", equalTo(405))
                .body("message", equalTo("This request method is not supported."));
    }

    @Test
    void api_10_cannot_verify_with_invalid_details()
    {
        given()
                .spec(loginController.getRequestSpecification())
                .formParam("email", "aiodsnfa")
                .formParam("password", "2898eunung")
        .when()
                .post()
        .then()
                .assertThat()
                .body("responseCode", equalTo(404))
                .body("message", equalTo("User not found!"));
    }
}

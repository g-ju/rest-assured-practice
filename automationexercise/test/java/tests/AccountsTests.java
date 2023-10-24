package tests;

import api.AccountController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountsTests
{
    private static AccountController accountController;

    @BeforeAll
    static void init()
    {
        accountController = new AccountController();
    }

    @Test
    void api_11_can_create_new_account()
    {
        // Think it would be better to have a Java object here with these fields instead, and using that as the body of the request in
        // JSON format, but the site does not seem happy accepting that. I think it's a bug on their end.
        given()
                .spec(accountController.getRequestSpecification())
                .formParam("name", "John Doe")
                .formParam("email", "email" + (int) (Math.random() * 1000))
                .formParam("password", "test")
                .formParam("title", "Mr.")
                .formParam("birth_date", 1)
                .formParam("birth_month", 1)
                .formParam("birth_year", 2000)
                .formParam("firstname", "John")
                .formParam("lastname", "Doe")
                .formParam("company", "Microsoft")
                .formParam("address1", "number")
                .formParam("address2", "street")
                .formParam("country", "UK")
                .formParam("zipcode", 12345)
                .formParam("state", "county")
                .formParam("city", "London")
                .formParam("mobile_number", 1234567)
                .log().params()
        .when()
                .post(AccountController.CREATE_ENDPOINT)
        .then()
                .assertThat()
                .body("responseCode", equalTo(201))
                .body("message", equalTo("User created!"));
    }

    @Test
    void api_12_can_delete_account()
    {
        given()
                .spec(accountController.getRequestSpecification())
                .formParam("email", "email666")
                .formParam("password", "test")
        .when()
                .delete(AccountController.DELETE_ENDPOINT)
        .then()
                .assertThat()
                .body("responseCode", equalTo(200))
                .body("message", equalTo("Account deleted!"));
    }

    @Test
    void api_13_can_update_account()
    {
        given()
                .spec(accountController.getRequestSpecification())
                .formParam("email", "email435")
                .formParam("password", "test")
                .formParam("name", "new name")
        .when()
                .put(AccountController.UPDATE_ENDPOINT)
        .then()
                .assertThat()
                .body("responseCode", equalTo(200))
                .body("message", equalTo("User updated!"));
    }

    @Test
    void api_14_can_get_account_details_by_email()
    {
        given()
                .spec(accountController.getRequestSpecification())
                .queryParam("email", "email435")
        .when()
                .get(AccountController.READ_ENDPOINT)
        .then()
                .log().body()
                .assertThat()
                .body("responseCode", equalTo(200))
                .body("user.name", equalTo("new name"));
    }
}

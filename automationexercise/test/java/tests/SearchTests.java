package tests;

import api.SearchController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchTests
{
    private static SearchController searchController;

    @BeforeAll
    static void init()
    {
        searchController = new SearchController();
    }

    @Test
    void api_5_can_search_for_jeans()
    {
        given()
                .spec(searchController.getRequestSpecification())
                .formParam("search_product", "jean")
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(200)
                .body("responseCode", equalTo(200))
                .body("products", not(empty()));
    }

    @Test
    void api_6_error_when_searching_without_parameter()
    {
        given()
                .spec(searchController.getRequestSpecification())
        .when()
                .post()
        .then()
                .assertThat()
                .body("responseCode", equalTo(400))
                .body("message", equalTo("Bad request, search_product parameter is missing in POST request."));
    }
}

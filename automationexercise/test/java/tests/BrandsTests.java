package tests;

import api.BrandsController;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class BrandsTests
{
    private static BrandsController brandsController;

    @BeforeAll
    static void init()
    {
        brandsController = new BrandsController();
    }

    @Test
    void api_3_can_get_brands_list()
    {
        given()
                .spec(brandsController.getRequestSpecification())
        .when()
                .get()
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("responseCode", equalTo(200))
                .body("brands", hasSize(34));
    }

    @Test
    void api_3_second_brand_is_h_and_m()
    {
        given()
                .spec(brandsController.getRequestSpecification())
        .when()
                .get()
        .then()
                .assertThat()
                .body("brands[1].brand", equalTo("H&M"));
    }

    @Test
    void api_4_put_method_not_supported()
    {
        given()
                .spec(brandsController.getRequestSpecification())
        .when()
                .put()
        .then()
                .assertThat()
                // Again the status code isn't actually 405, they've just set this in the response body
                .body("responseCode", equalTo(405))
                .body("message", equalTo("This request method is not supported."));
    }
}

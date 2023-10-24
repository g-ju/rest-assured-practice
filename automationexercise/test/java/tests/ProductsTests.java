package tests;

import api.ProductsController;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ProductsTests
{
    private static ProductsController productsController;

    @BeforeAll
    static void init()
    {
        productsController = new ProductsController();
    }

    @Test
    void api_1_can_get_products_list()
    {
        given()
                .spec(productsController.getRequestSpecification())
        .when()
                .get()
        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("responseCode", equalTo(200))
                .body("products", hasSize(34));
    }

    @Test
    void api_1_first_product_has_an_id_of_1()
    {
        given()
                .spec(productsController.getRequestSpecification())
        .when()
                .get()
        .then()
                .assertThat()
                .body("products[0].id", equalTo(1));
    }

    @Test
    void api_2_post_method_not_supported()
    {
        given()
                .spec(productsController.getRequestSpecification())
        .when()
                .post()
        .then()
                .assertThat()
                // The status code isn't actually 405, they've just set this in the response
                .body("responseCode", equalTo(405))
                .body("message", equalTo("This request method is not supported."));
    }
}

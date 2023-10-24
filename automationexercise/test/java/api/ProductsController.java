package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductsController
{
    private static final String PRODUCTS_ENDPOINT = "https://automationexercise.com/api/productsList";
    private final RequestSpecification requestSpecification;

    // Filter to force json response as site seems to think it is giving a text/html response despite not doing so.
    static final Filter FORCE_JSON_RESPONSE_BODY = (reqSpec, respSpec, ctx) ->
    {
        Response response = ctx.next(reqSpec, respSpec);
        ((RestAssuredResponseOptionsImpl<?>) response).setContentType("application/json");
        return response;
    };

    public ProductsController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(PRODUCTS_ENDPOINT)
                                                       .setContentType(ContentType.JSON)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }

    public RequestSpecification getRequestSpecification()
    {
        return requestSpecification;
    }
}

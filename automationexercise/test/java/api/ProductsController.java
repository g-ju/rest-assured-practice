package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class ProductsController extends AbstractController
{
    private static final String PRODUCTS_ENDPOINT = API_ENDPOINT + "productsList";

    public ProductsController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(PRODUCTS_ENDPOINT)
                                                       .setContentType(ContentType.JSON)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }
}

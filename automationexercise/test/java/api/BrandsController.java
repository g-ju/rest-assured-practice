package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class BrandsController extends AbstractController
{
    private static final String BRANDS_ENDPOINT = API_ENDPOINT + "brandsList";

    public BrandsController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(BRANDS_ENDPOINT)
                                                       .setContentType(ContentType.JSON)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }
}

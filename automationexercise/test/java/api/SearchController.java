package api;

import io.restassured.builder.RequestSpecBuilder;

public class SearchController extends AbstractController
{
    private static final String SEARCH_ENDPOINT = API_ENDPOINT + "searchProduct";

    public SearchController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(SEARCH_ENDPOINT)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }
}

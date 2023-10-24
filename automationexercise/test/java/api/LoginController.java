package api;

import io.restassured.builder.RequestSpecBuilder;

public class LoginController extends AbstractController
{
    private static final String LOGIN_ENDPOINT = API_ENDPOINT + "verifyLogin";

    public LoginController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(LOGIN_ENDPOINT)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }
}

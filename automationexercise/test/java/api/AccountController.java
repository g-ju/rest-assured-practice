package api;

import io.restassured.builder.RequestSpecBuilder;

public class AccountController extends AbstractController
{
    public static final String CREATE_ENDPOINT = "createAccount";
    public static final String DELETE_ENDPOINT = "deleteAccount";
    public static final String UPDATE_ENDPOINT = "updateAccount";
    public static final String READ_ENDPOINT = "getUserDetailByEmail";

    public AccountController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(API_ENDPOINT)
                                                       .addFilter(FORCE_JSON_RESPONSE_BODY)
                                                       .build();
    }


}

package api;

import io.restassured.filter.Filter;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractController
{
    static final String API_ENDPOINT = "https://automationexercise.com/api/";
    protected RequestSpecification requestSpecification;

    // Filter to force json response as site seems to think it is giving a text/html response despite not doing so.
    static final Filter FORCE_JSON_RESPONSE_BODY = (reqSpec, respSpec, ctx) ->
    {
        Response response = ctx.next(reqSpec, respSpec);
        ((RestAssuredResponseOptionsImpl<?>) response).setContentType("application/json");
        return response;
    };

    public RequestSpecification getRequestSpecification()
    {
        return requestSpecification;
    }
}

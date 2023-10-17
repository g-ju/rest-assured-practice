package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BoredController
{
    private static final String ACTIVITY_ENDPOINT = "http://www.boredapi.com/api/activity/";
    private final RequestSpecification requestSpecification;

    public BoredController()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(ACTIVITY_ENDPOINT)
                                                       .setContentType(ContentType.JSON)
                                                       .build();
    }

    public Activity getRandomActivity()
    {
        return given()
                .spec(requestSpecification)
                .get()
               .then()
                .extract()
                .as(Activity.class);
    }
}

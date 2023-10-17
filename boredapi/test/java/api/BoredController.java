package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BoredController
{
    private static final String ACTIVITY_ENDPOINT = "http://www.boredapi.com/api/activity";
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

    public Activity getActivityByKey(int key)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("key", key)
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }

    public Activity getActivityByType(Type type)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("type", type.toString())
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }

    // Note price is a factor in the range [0, 1]
    public Activity getActivityByPrice(double price)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("price", price)
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }

    public Activity getActivityWithinPriceRange(double minPrice, double maxPrice)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("minprice", minPrice)
                    .queryParam("maxprice", maxPrice)
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }

    public Activity getActivityWithAccessibility(double accessibility)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("accessibility", accessibility)
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }

    public Activity getActivityWithinAccessibilityRange(double minAccessibility, double maxAccessibility)
    {
        return given()
                    .spec(requestSpecification)
                    .queryParam("minaccessibility", minAccessibility)
                    .queryParam("maxaccessibility", maxAccessibility)
                    .get()
               .then()
                    .extract()
                    .as(Activity.class);
    }
}

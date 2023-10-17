package tests;

import api.Activity;
import api.BoredController;
import api.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoredTests
{
    @Test
    void can_get_random_activity()
    {
        BoredController controller = new BoredController();
        Activity activity = controller.getRandomActivity();

        assertThat(activity, not(equalTo(new Activity())));
    }

    @Test
    void get_activity_by_key_returns_the_same_activity()
    {
        BoredController controller = new BoredController();
        Activity randomActivity = controller.getRandomActivity();

        Activity keyedActivity = controller.getActivityByKey(randomActivity.getKey());
        assertEquals(randomActivity, keyedActivity);
    }

    @ParameterizedTest
    @EnumSource(Type.class)
    void get_activity_by_type_returns_activity_with_correct_type(Type type)
    {
        BoredController controller = new BoredController();
        Activity activity = controller.getActivityByType(type);

        assertThat(activity.getType(), is(type));
    }

    @Test
    void get_activity_by_price_returns_activity_with_correct_price()
    {
        BoredController controller = new BoredController();
        double price = 0.5;
        Activity activity = controller.getActivityByPrice(price);

        assertThat(activity.getPrice(), is(price));
    }

    @Test
    void get_activity_within_price_range_returns_activity_with_price_in_range()
    {
        BoredController controller = new BoredController();
        double minPrice = 0.5;
        double maxPrice = 0.8;
        Activity activity = controller.getActivityWithinPriceRange(minPrice, maxPrice);

        assertTrue(activity.getPrice() >= minPrice && activity.getPrice() <= maxPrice);
    }

    @Test
    void get_activity_by_accessibility_returns_activity_with_correct_accessibility()
    {
        BoredController controller = new BoredController();
        double accessibility = 0.5;
        Activity activity = controller.getActivityWithAccessibility(accessibility);

        assertThat(activity.getAccessibility(), is(accessibility));
    }

    @Test
    void get_activity_within_accessibility_range_returns_activity_with_accessibility_in_range()
    {
        BoredController controller = new BoredController();
        double minAccessibility = 0.4;
        double maxAccessibility = 0.9;
        Activity activity = controller.getActivityWithinAccessibilityRange(minAccessibility, maxAccessibility);

        assertTrue(activity.getAccessibility() >= minAccessibility && activity.getAccessibility() <= maxAccessibility);
    }
}

package tests;

import api.Activity;
import api.BoredController;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class BoredTests
{
    @Test
    void can_get_random_activity()
    {
        BoredController controller = new BoredController();
        Activity activity = controller.getRandomActivity();

        assertThat(activity, not(equalTo(new Activity())));
    }
}

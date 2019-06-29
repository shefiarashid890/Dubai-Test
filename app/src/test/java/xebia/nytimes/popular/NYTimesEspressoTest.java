package xebia.nytimes.popular;

import org.junit.Test;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class NYTimesEspressoTest {

    private String nyTitleName="NYTimes Most Popular";
    private String nyDescription ="NYTimes Most Popular";
    private String nyDate = "12-5-2016";
    @Test
    public void testRecycleViewData(){

        Espresso.onView((withId(R.id.title)))
                .perform(ViewActions.typeText(nyTitleName));

        Espresso.onView(withId(R.id.title))
                .perform(ViewActions.typeText(nyDescription));
        Espresso.onView(withId(R.id.date))
                .perform(ViewActions.typeText(nyDate));
        Espresso.onView(withId(R.id.ny_times_recycler_view))
                .perform(ViewActions.click());

    }
    }


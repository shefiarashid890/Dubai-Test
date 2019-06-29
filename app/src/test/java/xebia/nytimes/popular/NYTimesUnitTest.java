package xebia.nytimes.popular;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import xebia.nytimes.popular.activity.MainActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class NYTimesUnitTest {
    private static final String INVALID_API_KEY = "BAPXQfnmYonqD2gtcnyJgGIAH43H2OwZ";

    @Mock
    Context mockContext;

    @Test
    public void testAPIKeyValidOrNot() {
        when(mockContext.getString(R.string.unit_test_api_key))
                .thenReturn(INVALID_API_KEY);
        MainActivity objectUnderTest = new MainActivity();
        // when the string is returned from the object under test
        String result = objectUnderTest.getAPIKey();
        // The result should be the expected one.
        assertThat(result, is(INVALID_API_KEY));
    }
}
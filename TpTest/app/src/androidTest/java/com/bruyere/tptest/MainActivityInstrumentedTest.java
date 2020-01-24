package com.bruyere.tptest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEditTextAreEquals() {
        onView(withId(R.id.editText1))
                .perform(typeText("TOTO"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.editText2))
                .perform(typeText("TOTO"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("OK")));
    }

    @Test
    public void testEditTextAreNotEquals() {
        onView(withId(R.id.editText1))
                .perform(typeText("TOTO"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.editText2))
                .perform(typeText("TITI"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("NOT OK")));
    }
}

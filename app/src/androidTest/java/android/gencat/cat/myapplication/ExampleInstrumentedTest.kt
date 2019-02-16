package android.gencat.cat.myapplication



import android.support.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase.assertEquals

import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//import android.support.test.espresso.intent.Intents.intended
//import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    /*
    * JUnit allows to provide rules through a test class field or a getter method.
    *
    * What you annotated is in Kotlin a property though, which JUnit won't recognize.
    * */
    @get:Rule
    val activityRule1 = ActivityTestRule(MainActivity::class.java)

    @Rule @JvmField
    val activityRule2 = IntentsTestRule(WelcomeActivity::class.java)

    @Test
    @Ignore
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getTargetContext()
        assertEquals("android.gencat.cat.myapplication", appContext.packageName)
    }

    @Test
    fun gotoWelcomeActivity() {
        onView(withId(R.id.button1)).perform(click())
        intended(hasComponent(WelcomeActivity::class.java.name))
        //onView(withText("Welcome Activity!")).check(matches(isDisplayed()))
    }

    @Test fun listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()))
    }
}

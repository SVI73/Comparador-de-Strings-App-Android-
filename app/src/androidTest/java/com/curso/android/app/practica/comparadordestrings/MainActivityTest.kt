import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.comparadordestrings.MainActivity
import com.curso.android.app.practica.comparadordestrings.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testUIElements() {
        onView(withId(R.id.editText1)).check(matches(isDisplayed()))
        onView(withId(R.id.editText2)).check(matches(isDisplayed()))
        onView(withId(R.id.compareButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testTextComparison() {
        onView(withId(R.id.editText1)).perform(typeText("hello"), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText("world"), closeSoftKeyboard())
        onView(withId(R.id.compareButton)).perform(click())

        // Verificar el resultado aquí usando onView(...)
    }
}

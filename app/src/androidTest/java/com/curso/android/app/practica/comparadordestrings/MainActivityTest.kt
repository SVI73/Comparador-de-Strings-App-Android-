import androidx.lifecycle.Observer
import androidx.test.ext.junit.rules.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TextComparisonViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TextComparisonViewModel

    private lateinit var comparisonResultObserver: Observer<Boolean>

    @Before
    fun setup() {
        viewModel = TextComparisonViewModel()
        comparisonResultObserver = Observer {}
        viewModel.comparisonResult.observeForever(comparisonResultObserver)
    }

    @Test
    fun testCompareTextsEqual() {
        val text1 = "hello"
        val text2 = "hello"

        viewModel.compareTexts(text1, text2)

        assertEquals(true, viewModel.comparisonResult.value)
    }

    @Test
    fun testCompareTextsNotEqual() {
        val text1 = "hello"
        val text2 = "world"

        viewModel.compareTexts(text1, text2)

        assertEquals(false, viewModel.comparisonResult.value)
    }
}

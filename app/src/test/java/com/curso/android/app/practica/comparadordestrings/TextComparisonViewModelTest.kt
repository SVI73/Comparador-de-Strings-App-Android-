import com.curso.android.app.practica.comparadordestrings.TextComparisonViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TextComparisonViewModelTest {

    private lateinit var viewModel: TextComparisonViewModel

    @Before
    fun setup() {
        viewModel = TextComparisonViewModel()
    }

    @Test
    fun testTextComparison() {
        viewModel.compareTexts("hello", "world")
        assertEquals(false, viewModel.comparisonResult.value)
    }
}

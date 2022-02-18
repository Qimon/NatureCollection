package fr.sber.naturecollection.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

class PlantItemDecorationTest {

    /**
     * Build Rect Object with wanted parameters
     *
     * @param bottomValue is the bottom parameter value to affect to Rect Object
     * @param topValue is the top, left and right parameters value to affect to Rect Object
     * @return a Rect Object with parameters defined
     */
    fun buildRect(bottomValue: Int, topValue: Int): Rect {
        var rectObject: Rect = Rect(0, 0, 0, 0)
        rectObject.bottom = bottomValue
        rectObject.top = topValue
        return rectObject
    }

    /**
     * Test if "bottom" parameter "inputRectObject" is well change to 20, calling getItemOffsets method
     * Assert if top, left and right parameters are unchanged
     *
     */
    @Test
    fun getItemOffsetsTest() {

        // Prepare Input
        val inputRectObject: Rect = buildRect(2, 2)

        // Prepare Expected
        val expectedRectObject: Rect = buildRect(20, 2)

        // Run function
        PlantItemDecoration().getItemOffsets(
            inputRectObject,
            mock(View::class.java),
            mock(RecyclerView::class.java),
            mock(RecyclerView.State::class.java)
        )

        // Assert Results
        Assert.assertEquals(expectedRectObject.bottom, inputRectObject.bottom)
        Assert.assertEquals(expectedRectObject.top, inputRectObject.top)
        Assert.assertEquals(expectedRectObject.left, inputRectObject.left)
        Assert.assertEquals(expectedRectObject.right, inputRectObject.right)
    }
}
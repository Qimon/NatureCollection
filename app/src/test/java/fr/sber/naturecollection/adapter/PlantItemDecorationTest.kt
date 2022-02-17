package fr.sber.naturecollection.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PlantItemDecorationTest {

    fun buildRect(bottomValue: Int, topValue: Int): Rect {
        var rectObject: Rect = Rect(0, 0,0,0)
        rectObject.bottom = bottomValue
        rectObject.top = topValue
        return rectObject
    }

    @Test
    fun getItemOffsetsTest() {

        val anyView: View = mock(View::class.java)
        val anyRecyclerView: RecyclerView = mock(RecyclerView::class.java)
        val anyRecyclerViewState: RecyclerView.State = mock(RecyclerView.State::class.java)
        val inputRectObject: Rect = buildRect(2, 2)

        // Prepare Expected
        val expectedRectObject: Rect = buildRect(20, 2)

        // Run function
        PlantItemDecoration().getItemOffsets(inputRectObject, anyView, anyRecyclerView, anyRecyclerViewState)

        // Assert Results
        Assert.assertEquals(expectedRectObject.bottom, inputRectObject.bottom)
        Assert.assertEquals(expectedRectObject.top, inputRectObject.top)
    }
}
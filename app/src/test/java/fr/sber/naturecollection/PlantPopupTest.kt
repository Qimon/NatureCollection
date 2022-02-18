package fr.sber.naturecollection

import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import fr.sber.naturecollection.adapter.PlantAdapter
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.*

class PlantPopupTest {

    private val MOCK_CONTEXT: MainActivity = mock(MainActivity::class.java)

    @Test
    @Ignore
    fun onCreateTest(){
        // TO DO
    }

    @Test fun `updateLike method result if isLiked is false`(){

        // Mock
        val mockPlantModel: PlantModel = PlantModel("1", "", "", "", "", "", false)
        val mockPlantAdapter: PlantAdapter = PlantAdapter(
            MOCK_CONTEXT,
            listOf(mockPlantModel),
            1
        )

        val plantPopupInstance: PlantPopup = PlantPopup(
            mockPlantAdapter,
            mockPlantModel
        )

        val mockImageView: ImageView = mock(ImageView::class.java)

        // Act
        plantPopupInstance.updateLike(mockImageView)

        // Assert
        verify(mockImageView, times(1)).setImageResource(R.drawable.ic_unlike)
        verify(mockImageView, times(0)).setImageResource(R.drawable.ic_like)
    }

    @Test fun `updateLike method result if isLiked is true`(){

        // Mock
        val mockPlantModel: PlantModel = PlantModel("1", "", "", "", "", "", true)
        val mockPlantAdapter: PlantAdapter = PlantAdapter(
            MOCK_CONTEXT,
            listOf(mockPlantModel),
            1
        )

        val plantPopupInstance: PlantPopup = PlantPopup(
            mockPlantAdapter,
            mockPlantModel
        )

        val mockImageView: ImageView = mock(ImageView::class.java)

        // Act
        plantPopupInstance.updateLike(mockImageView)

        // Assert
        verify(mockImageView, times(1)).setImageResource(R.drawable.ic_like)
        verify(mockImageView, times(0)).setImageResource(R.drawable.ic_unlike)
    }


    @Test
    @Ignore
    fun setupLikeButtonTest(){
        // TO DO
    }

    @Test
    @Ignore
    fun setupDeleteButtonTest(){
        // TO DO
    }

    @Test
    @Ignore
    fun setupCloseButtonTest(){

        // Mock
        val plantPopupInstance: PlantPopup = PlantPopup(
            mock(PlantAdapter::class.java),
            mock(PlantModel::class.java)
        )

        // Act
        plantPopupInstance.setupCloseButton()

        // Verify
        verify(plantPopupInstance, times(1)).dismiss()
    }

    @Test
    @Ignore
    fun setupComponentsTest(){
        // TO DO
    }
}
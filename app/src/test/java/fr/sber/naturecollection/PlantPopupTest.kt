package fr.sber.naturecollection

import android.widget.ImageView
import fr.sber.naturecollection.adapter.PlantAdapter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.lang.reflect.Method

class PlantPopupTest {

    private val MOCK_CONTEXT: MainActivity = mock(MainActivity::class.java)
    private val UPDATE_LIKE: String = "updateLike"
    private val SETUP_CLOSE_BUTTON: String = "setupCloseButton"

    private val mockPlantModel: PlantModel = PlantModel("1", "", "", "", "", "", false)
    private val mockPlantAdapter: PlantAdapter = PlantAdapter(
        MOCK_CONTEXT,
        listOf(mockPlantModel),
        1
    )

    private val plantPopupInstance: PlantPopup = PlantPopup(
        mockPlantAdapter,
        mockPlantModel
    )

    private val mapMethod: Map<String, Method?> = mapOf(
        UPDATE_LIKE to (plantPopupInstance::class.java).getDeclaredMethod(UPDATE_LIKE, (ImageView::class.java)),
        SETUP_CLOSE_BUTTON to (plantPopupInstance::class.java).getDeclaredMethod(SETUP_CLOSE_BUTTON),
    )

    @Before fun setUp(){
        for (methodName in mapMethod) {
            methodName.value?.isAccessible = true
        }
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
        mapMethod[UPDATE_LIKE]?.invoke(plantPopupInstance, mockImageView)

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
        mapMethod[UPDATE_LIKE]?.invoke(plantPopupInstance, mockImageView)

        // Assert
        verify(mockImageView, times(1)).setImageResource(R.drawable.ic_like)
        verify(mockImageView, times(0)).setImageResource(R.drawable.ic_unlike)
    }

    @Test fun `setupCloseButton method calls dismiss method on ClickListener`(){

        // Mock
        val plantPopupInstance: PlantPopup = mock(PlantPopup::class.java)

        // Act
        mapMethod[SETUP_CLOSE_BUTTON]?.invoke(plantPopupInstance)

        // Assert
        verify(plantPopupInstance, times(1)).findViewById<ImageView>(anyInt())
    }
}
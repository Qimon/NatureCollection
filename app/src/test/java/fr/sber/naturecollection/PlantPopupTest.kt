package fr.sber.naturecollection

import android.widget.ImageView
import fr.sber.naturecollection.adapter.PlantAdapter
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.*
import java.lang.reflect.Method
import java.util.stream.Stream

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

    @BeforeEach fun setUp(){
        for (methodName in mapMethod) {
            methodName.value?.isAccessible = true
        }
    }

    private companion object {
        @JvmStatic
        fun isLikedArguments() = Stream.of(
            Arguments.of(true, 0, 1),
            Arguments.of(false, 1, 0)
        )
    }

    @ParameterizedTest(name = "IsLiked = {0}, ic_unlike = {1}, ic_like = {2}")
    @MethodSource("isLikedArguments")
    fun testUpdateLike(isLiked: Boolean, ic_unlike: Int, ic_like: Int){
        // Mock
        val mockPlantModel: PlantModel = PlantModel("1", "", "", "", "", "", isLiked)
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
        verify(mockImageView, times(ic_unlike)).setImageResource(R.drawable.ic_unlike)
        verify(mockImageView, times(ic_like)).setImageResource(R.drawable.ic_like)
    }

    @Test
    fun `updateLike method result if isLiked is false`(){

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
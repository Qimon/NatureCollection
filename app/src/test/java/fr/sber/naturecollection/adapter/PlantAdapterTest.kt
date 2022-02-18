package fr.sber.naturecollection.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.sber.naturecollection.MainActivity
import fr.sber.naturecollection.PlantModel
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PlantAdapterTest {


    /**
     * Generate some distinct PlantModel only on "id" attribute
     *
     * @param id is the "id" attribute of a PlantModel object
     * @return the PlantModel object
     */
    fun generatePlantModel(id: String): PlantModel {
        return PlantModel(id, "", "", "", "", "", false)
    }

    /**
     * Test if
     *
     */
    @Test
    @Ignore
    fun onCreateViewHolderTest() {

        // Prepare Input
        val mockPlantModel: PlantModel = generatePlantModel("1")
        val plantModelList: List<PlantModel> = listOf<PlantModel>(mockPlantModel)
        val inputViewGroup = mock(ViewGroup::class.java)
        val inputViewType: Int = 0

        // Prepare Expected
        // val expectedViewHolder: RecyclerView.ViewHolder =

        // Run function
        val outputViewHolder: RecyclerView.ViewHolder = PlantAdapter(
            MainActivity(),
            plantModelList,
            0
        ).onCreateViewHolder(
            inputViewGroup,
            inputViewType
        )

        // Assert results
        // Assert.assertEquals(expectedViewHolder, outputViewHolder)
    }

    /**
     * Test if
     *
     */
    @Test
    @Ignore
    fun onBindViewHolderTest() {
    }

    /**
     * Test if list of PlantModelSize is conformed to expected Value
     *
     */
    @Test
    fun getItemCountTest() {

        // Prepare Input
        val firstPlantModel: PlantModel = generatePlantModel("1")
        val secondPlantModel: PlantModel = generatePlantModel("2")
        val plantModelList: List<PlantModel> = listOf<PlantModel>(firstPlantModel, secondPlantModel)

        // Run function
        val inputSize: Int = PlantAdapter(
            MainActivity(),
            plantModelList,
            0
        ).itemCount

        // Assert Results
        Assert.assertEquals(2, inputSize)
    }

}
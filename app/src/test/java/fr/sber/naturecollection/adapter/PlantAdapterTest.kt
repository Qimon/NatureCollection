package fr.sber.naturecollection.adapter

import fr.sber.naturecollection.MainActivity
import fr.sber.naturecollection.PlantModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class PlantAdapterTest {

    private val MOCK_CONTEXT: MainActivity = Mockito.mock(MainActivity::class.java)

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
            MOCK_CONTEXT,
            plantModelList,
            0
        ).itemCount

        // Assert Results
        Assertions.assertEquals(2, inputSize)
    }

}
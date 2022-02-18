package fr.sber.naturecollection

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlantModelTest {

    /**
     * Test if PlantModel Object default attributes toString are well defined
     *
     */
    @Test
    fun toStringWithDefaultAttributesTest() {

        // Prepare Expected
        val expectedString: String = "PlantModel(id='plant0', name='Tulipe', description='Petite description', imageUrl='http://graven.yt/plante.jpg', grow='Faible', water='Moyenne', isLiked=false)"

        // Run function
        val outputString: String = PlantModel().toString()

        // Assert Results
        Assertions.assertEquals(expectedString, outputString)
    }

    /**
     * Test if PlantModel Object with overwrite attributes toString are well defined
     *
     */
    @Test
    fun toStringWithOverwriteAttributesTest() {

        // Prepare Input
        val inputPlantModel: PlantModel = PlantModel(
            "id",
            "name",
            "description",
            "imageUrl",
            "grow",
            "water",
            true
        )

        // Prepare Expected
        val expectedString: String = "PlantModel(id='id', name='name', description='description', imageUrl='imageUrl', grow='grow', water='water', isLiked=true)"

        // Run function
        val outputString: String = inputPlantModel.toString()

        // Assert Results
        Assertions.assertEquals(expectedString, outputString)
    }
}
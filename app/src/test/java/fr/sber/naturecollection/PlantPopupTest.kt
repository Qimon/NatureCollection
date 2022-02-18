package fr.sber.naturecollection

import android.app.Dialog
import android.content.Context
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import fr.sber.naturecollection.adapter.PlantAdapter
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PlantPopupTest {

    @Test
    @Ignore
    fun onCreateTest(){
        // TO DO
    }

    @Test
    @Ignore
    fun updateLikeTest(){
        // TO DO
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
        Mockito.verify(plantPopupInstance, times(1)).dismiss()
    }

    @Test
    @Ignore
    fun setupComponentsTest(){
        // TO DO
    }
}
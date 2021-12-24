package fr.sber.naturecollection

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.ContentValues.TAG
import android.util.Log

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val titi: String = appContext.packageResourcePath
        Log.d(TAG,"###########################################")
        Log.d(TAG,titi)
        Log.d(TAG,"###########################################")
        assertEquals("fr.sber.naturecollection", appContext.packageName)
    }
}
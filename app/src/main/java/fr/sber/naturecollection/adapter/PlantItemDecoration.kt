package fr.sber.naturecollection.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Hérite de la class ItemDecoration()
class PlantItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        // 1000 : Décalage permettant la séparation entre toutes les petites image de la RecyclerView
        outRect.bottom = 20
    }
}
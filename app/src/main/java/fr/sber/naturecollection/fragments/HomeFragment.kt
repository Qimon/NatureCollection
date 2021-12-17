package fr.sber.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.sber.naturecollection.MainActivity
import fr.sber.naturecollection.PlantRepository.Singleton.plantList
import fr.sber.naturecollection.R
import fr.sber.naturecollection.adapter.PlantAdapter
import fr.sber.naturecollection.adapter.PlantItemDecoration

class HomeFragment(
    private val context: MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater?.inflate(R.layout.fragment_home, container, false)

        // Créer une liste de "PlantModel" qui va stocker ces plantes :
        // val plantList: ArrayList<PlantModel> = arrayListOf<PlantModel>()

        // Ajouter un élément dans la liste :
        // En manuel:
        // plantList.add(PlantModel("Rose", "C'est rose", "https://cdn.pixabay.com/photo/2015/04/19/08/32/rose-729509__340.jpg", false))
        // plantList.add(PlantModel("Rododenderon", "C'est beau", "https://cdn.pixabay.com/photo/2016/04/03/19/23/rododendron-1305318__340.jpg", false))
        // plantList.add(PlantModel("Tournesol", "C'est jaune", "https://cdn.pixabay.com/photo/2018/07/20/13/52/sunflower-3550693__340.jpg", true))
        // plantList.add(PlantModel("Coquelicot", "C'est rouge", "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__340.jpg", true))

        // Le Horizontal RecyclerView en haut de la page:
        val horizontalRecyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        // Edition de l'adapteur de l'horizontalRecyclerView
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        // Le vertical RecyclerView en bas de page:
        val verticalRecyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        // Edition de l'adapteur de la verticalRecyclerView
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        // 1000 : Décalage permettant la séparation entre toutes les petites image de la RecyclerView
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}
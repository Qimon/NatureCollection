package fr.sber.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.sber.naturecollection.MainActivity
import fr.sber.naturecollection.PlantRepository.Singleton.plantList
import fr.sber.naturecollection.R
import fr.sber.naturecollection.adapter.PlantAdapter
import fr.sber.naturecollection.adapter.PlantItemDecoration

// Cette classe est reliée à un LinearLayout. (un seul élément est présent sur la vue)
class CollectionFragment(
    private val context: MainActivity
): Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater?.inflate(R.layout.fragment_collection, container, false)
        val collectionRecyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.collection_recycler_list)
        /* On fait appel à l'adapter vertical déjà développé dans HomeFragment.
        C'est parce que plantList est un singleton qu'on peut le récupérer ici.
        la méthode filter() permet de filtrer les plantes de la liste suivant ses attributs (ici like/unlike)
        */
        collectionRecyclerView.adapter = PlantAdapter(context, plantList.filter { it.isLiked }, R.layout.item_vertical_plant)
        // On précise le type de layout ici
        collectionRecyclerView.layoutManager = LinearLayoutManager(context)
        // 1000 : Rajout de l'espacement entre les éléments :
        collectionRecyclerView.addItemDecoration(PlantItemDecoration())
        return view
    }
}
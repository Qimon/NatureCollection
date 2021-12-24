package fr.sber.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.sber.naturecollection.*

class PlantAdapter(
    val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
    ): RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    // Boite pour ranger tous les composants à contrôler
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        // Image de la plante
        val plantImage: ImageView = view.findViewById<ImageView>(R.id.image_item)
        // le ? à la fin du type permet de prendre en compte un composant null (Spécifique Kotlin)
        val plantName: TextView? = view.findViewById(R.id.name_item)
        val plantDescription: TextView? = view.findViewById(R.id.description_item)
        // Pour le like/unlike, il est présent dans les 2 viewHolder donc pas besoin de gérer les null
        val starIcon: ImageView? = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupérer les Informations de la plante suivant son id dans la liste
        val currentPlant: PlantModel = plantList[position]

        // Instance du repo de la liste de plantes
        val repo: PlantRepository = PlantRepository()

        // Getter des attributs de la liste (Glide permet de récupérer l'image de la plante depuis son url) :
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        // Mettre à jour le nom et la description de la plante:
        holder.plantName?.text = currentPlant.name
        holder.plantDescription?.text = currentPlant.description

        // Gestion du like/unlike en fonction de l'attribut isLiked de la plante
        if (currentPlant.isLiked) holder.starIcon?.setImageResource(R.drawable.ic_like)
        else holder.starIcon?.setImageResource(R.drawable.ic_unlike)

        // Rajouter une interaction sur l'étoile
        holder.starIcon?.setOnClickListener {
            // Si le bouton est like, il passe en unlike et vice-versa
            currentPlant.isLiked = !currentPlant.isLiked
            // Mise à jour de l'objet plante avec cette nouvelle valeur
            repo.updatePlant(currentPlant)
        }

        // Lors du clic sur une plante
        holder.itemView.setOnClickListener {

            // Afficher la popup
            PlantPopup(this, currentPlant).show()
        }
    }

    override fun getItemCount(): Int = plantList.size
}
package fr.sber.naturecollection

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import fr.sber.naturecollection.PlantRepository.Singleton.databaseref
import fr.sber.naturecollection.PlantRepository.Singleton.plantList

// Repository = DAO en Firebase (json lu au lieu de tables)
class PlantRepository {

    // L'objet Singleton permet d'éviter une réinitialisation de la liste à chaque appel de la classe PlantRepository
    object Singleton {

        // Se connecter à la ref "plants" de Firebase
        var databaseref: DatabaseReference = FirebaseDatabase.getInstance().getReference("plants")

        // Créer une liste qui récupère les éléments en BDD
        val plantList: ArrayList<PlantModel> = arrayListOf<PlantModel>()
    }

    // 1001 : Le callback permet de laisser la requête se faire avant d'autres instrucion
    fun updateData(callback: () -> Unit) {
        // Absorption des données récupérées depuis la BDD pour modifications:
        databaseref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Nettoyage de la liste précédente:
                plantList.clear()

                // Récupération de la nouvelle liste des plantes déjà en BDD
                for (ds in snapshot.children) {
                    val plant: PlantModel? = ds.getValue(PlantModel::class.java)

                    // Vérification sur la bonne récupération en BDD
                    if (plant != null) {
                        Log.d(TAG,"La liste n'est pas vide")
                        plantList.add(plant)
                        Log.d(TAG, plant.toString())

                    } else {
                        Log.d(TAG,"La liste est vide")
                    }
                }
                // 1001 : Actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG,"Erreur")
            }
        })
    }

    // Mettre à jour un objet plante en BDD
    // .child pour récupérer l'enfant de la db plants
    fun updatePlant(plant: PlantModel) = databaseref.child(plant.id).setValue(plant)


    // Supprimer une plante de la bas
    fun deletePlant(plant: PlantModel) = databaseref.child(plant.id).removeValue()

}
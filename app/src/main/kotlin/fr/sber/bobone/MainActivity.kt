package fr.sber.bobone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import fr.sber.bobone.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Charger le plantRepository (lié à la BDD). Une instance de la classe est créée (en singleton)
        val repo: PlantRepository = PlantRepository()
        // Mettre à jour la liste de plantes: Celà met un certains temps, d'où l'implémentation du callBack
        // 1001 : Le bloc d'instruction à réaliser après le callback
        repo.updateData {
            // Injecter le fragment dans notre boite (fragment_container)
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            /* Remplace le contenu de la boite vide par le contenu de la classe HomeFragment
             this en paramètre pour utiliser Glide qui a besoin du contexte */
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            // Pas de retour sur le composant (on lui donne un nom null)
            transaction.addToBackStack(null)
            // Valider la transaction
            transaction.commit()
        }
    }
}
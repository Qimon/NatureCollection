package fr.sber.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import fr.sber.naturecollection.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Injecter le fragment dans notre boite (fragment_container)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        // Remplace le contenu de la boite vide par le contenu de la classe HomeFragment
        transaction.replace(R.id.fragment_container, HomeFragment())
        // Pas de retour sur le composant (on lui donne un nom null)
        transaction.addToBackStack(null)
        // Valider la transaction
        transaction.commit()
    }
}
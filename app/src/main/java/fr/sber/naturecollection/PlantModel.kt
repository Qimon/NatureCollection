package fr.sber.naturecollection

// Classe Objet Plante
class PlantModel(
    val id: String = "plant0",
    val name: String = "Tulipe",
    val description: String = "Petite description",
    val imageUrl: String = "http://graven.yt/plante.jpg",
    val grow: String = "Faible",
    val water: String = "Moyenne",
    var isLiked: Boolean = false
) {
    override fun toString(): String {
        return "PlantModel(id='$id', name='$name', description='$description', imageUrl='$imageUrl', grow='$grow', water='$water', isLiked=$isLiked)"
    }
}
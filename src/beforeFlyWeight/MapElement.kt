package beforeFlyWeight;

import common.Position

data class MapElement(
    val position: Position,
    val name: String,
    val description: String,
    val color: String,
    val sprite: String,
) {
    fun render() {
        println("Renderizando Elemento de Mapa: Posição: ${position}, Nome: $name, Descrição: $description, Cor: $color, Sprite: $sprite")
    }
}
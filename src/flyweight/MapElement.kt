package flyweight

import flyweight.models.MapElementInfo
import flyweight.models.MapElementVisual

data class MapElement(
    val info: MapElementInfo,
    val type: MapElementVisual
): MapElementContract {

    override fun render() {
        println("Renderizando Elemento de Mapa: Posição: ${info.position}, Nome: ${info.name}, " +
                "Descrição: ${info.description}, Cor: ${type.color}, Sprite: ${type.sprite}")
    }

}

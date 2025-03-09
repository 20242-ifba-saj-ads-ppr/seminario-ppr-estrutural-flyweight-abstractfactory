package flyweight

import common.Position
import flyweight.models.MapElementInfo
import flyweight.models.MapElementVisual

class MapElementFactory {
    companion object{
        private val elementVisuals = mutableMapOf<String, MapElementVisual>()

        fun createMapElement(position: Position, name: String, description: String, color: String, sprite: String): MapElement {
            val elementVisual = getElementVisual(MapElementVisual(color, sprite))
            val mapInfo = MapElementInfo(position, name, description)
            return MapElement(mapInfo, elementVisual)
        }

        private fun getElementVisual(elementVisual: MapElementVisual): MapElementVisual {
            return elementVisuals.computeIfAbsent( "${elementVisual.color}-${elementVisual.sprite}") {
                elementVisual
            }
        }
    }
}
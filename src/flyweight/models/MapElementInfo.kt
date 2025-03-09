package flyweight.models

import common.Position

data class MapElementInfo(
    val position: Position,
    val name: String,
    val description: String,
)

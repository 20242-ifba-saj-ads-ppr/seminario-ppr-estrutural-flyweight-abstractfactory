package common

data class Position(val x: Int, val y: Int){
    override fun toString(): String {
       return "common.Position [x=$x, y=$y]"
    }
}
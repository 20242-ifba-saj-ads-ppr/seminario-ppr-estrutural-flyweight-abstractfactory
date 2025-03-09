package beforeFlyWeight

import common.Position
import kotlin.random.Random

class BeforeFlyWeightApp {
    companion object {
        private const val INTERACOES = 10_000_000

        @JvmStatic
        fun run(){
            println("Teste com $INTERACOES elementos no mapa (Sem Flyweight)")
            val cores = listOf("Verde", "Marrom", "Cinza", "Amarelo")
            val sprites = listOf("🌳", "🏠", "⛰️", "🛣️")

            var elementos: MutableList<MapElement>? = mutableListOf()

            System.gc()

            imprimirMemoria("Início (antes de criar elementos)")

            for (i in 0 until INTERACOES) {
                val pos = Position(
                    Random.nextInt(1000),
                    Random.nextInt(1000)
                )

                val element = MapElement(
                    pos, 
                    "Elemento$i", 
                    "Descrição detalhada do elemento $i",
                    String(cores[i % cores.size].toCharArray()),
                    String(sprites[i % sprites.size].toCharArray())
                )

                elementos!!.add(element)
            }

            imprimirMemoria("Depois de criar elementos (Sem Flyweight)")

            elementos = null
            System.gc()

            imprimirMemoria("Após limpeza de memória")
        }

        private fun imprimirMemoria(mensagem: String) {
            val runtime = Runtime.getRuntime()
            val memoriaUsada = runtime.totalMemory() - runtime.freeMemory()

            println(mensagem)
            println("Memória total: ${runtime.totalMemory() / (1024 * 1024)} MB")
            println("Memória livre: ${runtime.freeMemory() / (1024 * 1024)} MB")
            println("Memória usada: ${memoriaUsada / (1024 * 1024)} MB")
            println()
        }
    }
}
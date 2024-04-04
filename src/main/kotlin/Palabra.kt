import com.google.gson.Gson
import java.io.File

class Palabra {
    companion object{

        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        data class Palabras(val palabras: List<String>)

        fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }

        fun obtenerPalabraAleatoria(palabras:List<String>): String {
            return palabras.random()
        }

    }

}
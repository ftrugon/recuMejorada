interface IEntradaSalida {
    fun <T> mostrar (mensaje:T)
    fun <T> mostrarParaPedir (mensaje:T)
    fun leerNumero(num: String): Int
    fun leertexto():String
}
interface IAhorcado {
    fun jugar()
    fun mostrarCorrectoIncorrecto()
    fun mostrarAdivinarPalabra()
    fun pedirLetra():String
    fun cifrarPalabra():String
    fun juegoActivo():Boolean
}
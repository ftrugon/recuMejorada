class EntradaSalida:IEntradaSalida {
    override fun <T> mostrar(mensaje: T) {
        println(mensaje)
    }

    override fun <T> mostrarParaPedir(mensaje: T) {
        print(mensaje)
    }

    override fun leerNumero(num: String): Int {
        var numero = num.toIntOrNull()
        while (numero == null){
            mostrar("Eso no es un numero, pon otro: ")
            numero = readln().toIntOrNull()
        }
        return numero
    }

    override fun leertexto():String{
        return readln()
    }
}
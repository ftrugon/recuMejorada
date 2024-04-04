class Menu(
    private val consola:IEntradaSalida,
):IMenu {
    override fun mostrarMenu() {
        consola.mostrar("1. Generar Serie")
        consola.mostrar("2. Jugar al ahorcado")
        consola.mostrar("3. Salir")
        consola.mostrarParaPedir("Por favor, selecciona una opcion: ")
    }

    override fun generarSerie() {

        val rangos = GeneradorSeries.generarRangoAleatorio()
        val menor = rangos[0]
        val mayor = rangos[1]

        consola.mostrarParaPedir("Inserte un numero[$menor-$mayor] -> ")

        var numUsuario = consola.leerNumero(consola.leertexto())

        if (numUsuario !in menor..mayor){
            consola.mostrarParaPedir("El numero esta fuera del rango dado, por favor introduce uno nuevo: ")
            numUsuario = consola.leerNumero(consola.leertexto())
        }

        GeneradorSeries.generarSerie(menor,mayor,numUsuario)

    }

    override fun jugarAhorcado() {
        Ahorcado(consola).jugar()
    }

    private fun pedirNumero():Int{
        return consola.leerNumero(consola.leertexto())
    }

    private fun opcionElegida(numero:Int) = when(numero){
        1 -> generarSerie()
        2 -> jugarAhorcado()
        else -> {
            consola.mostrar("Opcion no valida")
        }
    }

    fun iniciarMenu(){
        mostrarMenu()
        var opcion = pedirNumero()
        while (opcion != 3){
            opcionElegida(opcion)
            mostrarMenu()
            opcion = pedirNumero()
            if (opcion == 3) consola.mostrar("Saliendo ._.")
        }
    }

}
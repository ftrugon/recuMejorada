class Ahorcado(
    private val consola:IEntradaSalida,
    private var intentos:Int = 5
):IAhorcado {

    private val letrasDichas = mutableListOf<String>()
    private val palabra = Palabra.obtenerPalabraAleatoria(Palabra.leerFicheroJSON(Palabra.RUTA_JSON))

    override fun jugar(){

        while (intentos > 0 && juegoActivo()) {

            mostrarAdivinarPalabra()
            pedirLetra()
            mostrarCorrectoIncorrecto()
        }
    }

    override fun mostrarCorrectoIncorrecto(){
        if (letrasDichas.last() in palabra){
            consola.mostrar("Correcto")
        }else {
            intentos--
            consola.mostrar("Incorrecto, quedan $intentos intentos")
            if (intentos == 0){
                consola.mostrar("Lo siento, la palabra era $palabra")
            }
        }
    }

    override fun mostrarAdivinarPalabra(){
        consola.mostrar("Adivina la palabra: ${cifrarPalabra()}")
    }

    override fun pedirLetra():String{
        consola.mostrar("Intenta con una letra: ")
        var letra = readln()
        while (letra.length != 1){
            consola.mostrarParaPedir("Tiene que ser 1 letra: ")
            letra = readln()
        }
        letrasDichas.add(letra)
        return letra
    }


    override fun cifrarPalabra():String{

        var linea = ""

        for (letra in palabra){
            if (letra.toString() in letrasDichas){
                linea += letra
            }else {
                linea += "_"
            }
        }

        return linea

    }

    override fun juegoActivo():Boolean{
        return if ("_" in cifrarPalabra()) true else false
    }

}
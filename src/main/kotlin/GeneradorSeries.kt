import kotlin.random.Random

object GeneradorSeries:IGeneradorSeries {

    private val consola:IEntradaSalida = EntradaSalida()
    private const val minimo = 1
    private const val maximo = 101

    override fun generarRangoAleatorio():List<Int>{

        var num1 = generarAleatorio()
        var num2 = generarAleatorio()

        while (num1 == num2){
            num1 = generarAleatorio()
            num2 = generarAleatorio()
        }

        val menor = minOf(num1,num2)
        val mayor = maxOf(num1,num2)

        return listOf(menor,mayor)

    }

    override fun generarAleatorio():Int{
        return Random.nextInt(minimo,maximo)
    }

    override fun generarSerie(menor:Int, mayor:Int, numUsuario:Int){

        val mitadMenorMayor = ((mayor-menor) / 2) + menor

        if (numUsuario >= mitadMenorMayor){

            serieCreciente(mayor,numUsuario)

        }else serieDecreciente(menor,numUsuario)

    }

    override fun serieCreciente(mayor: Int, numUsuario: Int){

        var linea: String
        val numAnteeriores = mutableListOf<Int>()
        for (i in numUsuario..mayor){

            numAnteeriores.add(i)
            linea = numAnteeriores.joinToString("+")

            linea += " (${numAnteeriores.size - 1})"

            consola.mostrar(linea)

        }
        val total = numAnteeriores.sumOf { it }
        consola.mostrar("Suma => $total")
    }

    override fun serieDecreciente(menor: Int, numUsuario: Int){
        var linea :String
        val todosLosNumeros = mutableListOf<Int>()

        for (i in menor..numUsuario){
            todosLosNumeros.add(i)
        }

        val total = todosLosNumeros.sumOf { it }

        val numerosReversos:MutableList<Int> = todosLosNumeros.reversed().toMutableList()

        var contador = 0
        for (i in menor until numUsuario){

            numerosReversos.remove(i)
            linea = "${contador+1} -> "
            linea += numerosReversos.joinToString("+")

            val totalMomento = numerosReversos.sumOf { it }

            linea += " = $totalMomento"

            consola.mostrar(linea)
            contador++
        }
        consola.mostrar("Suma => $total")
    }

}
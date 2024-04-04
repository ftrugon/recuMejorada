interface IGeneradorSeries {
    fun generarRangoAleatorio():List<Int>
    fun generarAleatorio():Int
    fun generarSerie(menor:Int,mayor:Int,numUsuario:Int)
    fun serieCreciente(mayor: Int,numUsuario: Int)
    fun serieDecreciente(menor: Int,numUsuario: Int)
}
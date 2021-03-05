import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejemplo6 {

  def llenarListaNumeros(lista:ListBuffer[Int]) : Unit = {
    println("¿Cuantas numeros va a ingresar?")
    val n = readInt()

    for (i <- 1 to n) {
      println("Ingrese el numero " + i +":")
      lista += readInt()
    }
  }
  def mostrarNumeros(lista:ListBuffer[Int]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }
  
  def SumaAcumulada(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val sumaAcumulada = new ListBuffer[Int]()

    for (e <- lista.indices) if(e == 0) sumaAcumulada += lista(e) else sumaAcumulada += sumaAcumulada(e-1) + lista(e)

    sumaAcumulada
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarListaNumeros(numeros)

    println("Lista de numeros original")
    mostrarNumeros(numeros)
    println("Lista con la suma acumulada")
    mostrarNumeros(SumaAcumulada(numeros))
  }
}
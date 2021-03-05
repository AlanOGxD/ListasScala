import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejemplo1 {
def numRepDePalabrasEnLista(palabra:String, lista: => ListBuffer[String]): Unit ={
    var cont=0
    for (elemento<- lista){
      if(elemento == palabra){
        cont+=1
      }
    }
    println("La palabra '"+palabra+"' aparece "+cont+" veces en la lista")
  }
  
def main(args: Array[String]): Unit = {
    var listaPalabras = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista?")
    var n=readInt()
    
    for(i <- 0 until n){
      println("Ingresa palabra "+(i+1)+": ")
      listaPalabras+=readLine()
    }
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    println("Ingresa la palabra a contar: ")
    val palabra=readLine()
    
    numRepDePalabrasEnLista(palabra, listaPalabras)
    
  }
}
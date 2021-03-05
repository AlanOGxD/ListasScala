import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejemplo3 {
  def eliminarPalabra(palabra:String,lista: => ListBuffer[String]): ListBuffer[String] ={
    var sum=0
    for(i <- 0 until lista.size){
      if(lista(i)== palabra){
        sum+=1
      }
    }
    for(e <- 0 until sum){
      lista-=palabra
    }
    lista
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
    println("Ingresa la palabra a eliminar: ")
    val palabra1=readLine()
    
    
    print(eliminarPalabra(palabra1, listaPalabras))
 }
  
}
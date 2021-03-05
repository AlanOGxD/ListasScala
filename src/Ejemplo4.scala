import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejemplo4 {
  def eliminar(palabra:String,lista: => ListBuffer[String]): ListBuffer[String] ={
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
  
  def eliminarPalabras(lista1: => ListBuffer[String], lista2: => ListBuffer[String]): ListBuffer[String] ={
    var list=lista1
    for(i <- 0 until lista2.size){
      list=eliminar(lista2(i),lista1)
    }
    list
  }
  
  def main(args: Array[String]): Unit = {
   var listaPalabras = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista 1?")
    var n=readInt()
    
    for(i <- 0 until n){
      println("Ingresa palabra "+(i+1)+": ")
      listaPalabras+=readLine()
    }
    var listaPalabras2 = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista 2?")
    var no=readInt()
    
    for(i <- 0 until no){
      println("Ingresa palabra "+(i+1)+": ")
      listaPalabras2+=readLine()
    }
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    
    print(eliminarPalabras(listaPalabras, listaPalabras2))
 }
}
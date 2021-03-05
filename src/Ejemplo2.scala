import scala.collection.mutable.ListBuffer
import scala.io.StdIn._


object Ejemplo2 {
  
  def sustitucionEnLaLista(palabra1:String, palabra2:String,lista: => ListBuffer[String]): ListBuffer[String] ={
    var sum=0
    for(i <- 0 until lista.size){
      if(lista(i)== palabra1){
        sum+=1
        lista.remove(i)
        lista.insert(i,palabra2)
      }
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
    println("Ingresa la palabra a reemplazar: ")
    val palabra1=readLine()
    
    println("Ingresa la palabra de reemplazo: ")
    val palabra2=readLine()
    
    print(sustitucionEnLaLista(palabra1, palabra2, listaPalabras))
  }
  
}
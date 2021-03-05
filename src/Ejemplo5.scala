import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejemplo5 {
  def eliminarRep(palabra:String,lista: => ListBuffer[String]): ListBuffer[String] ={
    var sum=0
    for(i <- 0 until lista.size){
      if(lista(i)== palabra){
        sum+=1
      }
    }
    if(sum>=2){
    for(e <- 0 until sum-1){
      lista-=palabra
    }}
    lista
  }
  
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
  
  def union(lista1: => ListBuffer[String], lista2: => ListBuffer[String]): Unit ={
    var listaPalabrasUnidas = lista1
    for(e <- 0 until lista2.size) {
      listaPalabrasUnidas+=lista2(e)
    }
    println(listaPalabrasUnidas)
  }
  
  def unionDeListasSinRep(lista1: => ListBuffer[String], lista2: => ListBuffer[String]): Unit ={
    var listax=lista1
    var listax2=lista2
    var listaN1=eliminarPalabras(listax,lista2)
    var listaN2=eliminarPalabras(listax2,lista1)
    var listaPalabrasSinRep = ListBuffer[String]()
    listaPalabrasSinRep=listaN1
    for(e <- 0 until listaN2.size) {
      listaPalabrasSinRep+=listaN2(e)
    }
    println(listaPalabrasSinRep)
  }
  
  def main(args: Array[String]): Unit = {
   var listaPalabras1 = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista 1?")
    var n=readInt()
    
    for(i <- 0 until n){
      println("Ingresa palabra "+(i+1)+": ")
      listaPalabras1+=readLine()
    }
    var listaPalabras2 = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista 2?")
    var no=readInt()
    
    for(i <- 0 until no){
      println("Ingresa palabra "+(i+1)+": ")
      listaPalabras2+=readLine()
    }
    
    var list1=listaPalabras1
    println(listaPalabras1.size)
    for(i <- 0 until list1.size-1){
      print(i)
      list1=eliminarRep(listaPalabras1(i),listaPalabras1)
    }
    println(list1)
    var list=listaPalabras2
    for(i <- 0 until listaPalabras2.size-1){
      list=eliminarRep(listaPalabras2(i),listaPalabras2)
    }
    println(list)
    
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        print("listas originales: ")
        println("Lista 1: "+listaPalabras1)
        println("Lista 2: "+listaPalabras2)
        
        var listaP1 = new ListBuffer[String]()
        listaP1=listaPalabras1.clone()
        var listaP2 = new ListBuffer[String]()
        listaP2= listaPalabras2.clone()
        
        println()
        println("Lista de palabras que aparecen en las dos listas: ")
        union(listaPalabras1,listaPalabras2)
        
        println()
        listaPalabras1=listaP1.clone()
        println("Lista de palabras que aparecen en la primera lista, pero no en la segunda: ")
        println(eliminarPalabras(listaPalabras1,listaP2))
        
        println()
        println("Lista de palabras que aparecen en la segunda lista, pero no en la primera")
        println(eliminarPalabras(listaP2,listaP1))
        
        println()
        println("Lista de palabras que aparecen en ambas listas sin repeticiones")
        unionDeListasSinRep(listaPalabras1,listaPalabras2)
 }
}
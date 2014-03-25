package org.test.pran.scala

/**
 * Created by pramodh on 3/19/2014.
 */
object HelloWorld {
  def printLetterCount(input: String){
    val inputList = input.toList;
    val charList = for(i <- inputList; if i != ' ') yield i -> 1
    val numberMap = Map(1 -> "once", 2 -> "twice", 3 -> "thrice")
    val charMap = charList.foldLeft(Map[Char, Int]())((result, current) => result + (current._1 -> (result.getOrElse(current._1, 0)+1)))
    charMap.foreach(x => println("'" + x._1 + "' used " + numberMap.get(x._2).get))
  }
  def main(args:Array[String]){
    val hello = "Hello World"
    println(hello)
    printLetterCount(hello)
  }
}

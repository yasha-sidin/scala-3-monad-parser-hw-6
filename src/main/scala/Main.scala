package ru.otus

import scala.util._

object Main {
  implicit val character: Char = ';'
  @main def app(): Unit = {
    val userParser = UserParser()
    val source = getSourceFromFile(System.getProperty("user.dir") + "\\users.csv")
    val users = userParser.parse(source)
    users.foreach(println)
  }

  private def getSourceFromFile(path: String): String =
    val source = scala.io.Source.fromFile(path)
    val trying = Using(source) { source => source.mkString }
    trying match
      case Success(string) => string
      case Failure(exception) =>
        exception.printStackTrace()
        ""
}



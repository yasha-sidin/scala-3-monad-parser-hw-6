package ru.otus

abstract class ParserWithGivenParam[T](using splitter: Char) {
  def parse(source: String): Seq[T]

  protected def StringField: MonadParser[String, String] = MonadParser[String, String] {
    str =>
      val idx = str.indexOf(splitter)
      if idx > -1 then
        (str.substring(0, idx), str.substring(idx + 1))
      else
        (str, "")
  }

  protected def IntField: MonadParser[Int, String] = StringField.map(_.toInt)

  protected def BooleanField: MonadParser[Boolean, String] = StringField.map(_.toBoolean)

  protected def LongField: MonadParser[Long, String] = StringField.map(_.toLong)
}


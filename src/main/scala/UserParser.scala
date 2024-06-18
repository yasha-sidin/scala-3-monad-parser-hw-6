package ru.otus

case class UserParser()(using splitter: Char) extends ParserWithGivenParam[User] {
  override def parse(source: String): List[User] = {
    val parser = for
      id <- LongField
      username <- StringField
      password <- StringField
      role <- StringField
    yield
      User(id, username, password, role)
    source.split('\n').map(parser.parse).toList
  }
}

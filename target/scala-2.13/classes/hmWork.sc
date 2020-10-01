import scala.collection.mutable.ListBuffer

val a = "word"
val b = "w"
a.toList.foreach(println)
val aList = a.toList
println(aList)
aList(1).getClass

a.contains(b)

var guessedLetters = new ListBuffer[Char]()
val guess = b
guessedLetters :+ guess
guessedLetters :+ "e"
guessedLetters :+ "s"

guessedLetters.append('a')
guessedLetters.append('b')
guessedLetters.append('c')

guessedLetters.foreach(println)
println(guessedLetters)
guessedLetters.foreach(print)

//Sidequest 2 metodes 1) offer - prompt + parāda mesidžus - piedāvā SQ - atgriež true vai false un
//HM - ja 1) true tad izauc otru "begin" - sāk SQ - atgriež T/F vai SQ bija veiksmīgs - un tad ko darīt
//SQ izsauks Guessinggame - ka viņam ir interface no tā vai ir pareizi
//Tajā kas uzsāk, atgirež to to GG kad nostartē
//līdzīgi kā game - kas atgriež true vai false
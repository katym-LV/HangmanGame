import ListOfWords.words
import scala.util.Random
import HangedMan.drawHangman
import scala.collection.mutable.ListBuffer
import SideQuest.runSQ

object HangmanGame extends App {
  /** A method that gets random word from the List of Words
   */
  def getWord: String = {
    val randomWord = new Random
    val word = words(randomWord.nextInt(words.length))
    word.toLowerCase
  }

  /** The main HangMan game "engine"
   */
  def game(word: String): Boolean = {
    var guessed = false
    val guessedLetters = new ListBuffer[Char]()
    val guessedWords = new ListBuffer[String]()
    var tries = 7
    println("Let the Hangman game begin!")
    println(drawHangman(tries))
    println(s"You have $tries tries, be careful, if you try to guess the entire word, you will lose 2 tries!")
    println(s"The word contains ${word.length} letters")

    def formatGuessedLetters: String = {
      s"Letters guessed: ${guessedLetters.mkString(", ").toUpperCase}"
    }

    /** This method "maps" the main information that is displayed to the player
     * Namely, the progress of the word to be guessed
     * it maps the word keeping letters it contains from lettersGuessed and replacing the rest of the characters with blanks
     */
    def formatOutcome: String = {
      word.map(char =>
        if (guessedLetters.contains(char)) {
          char.toUpper
        } else {
          '_'
        }).toSeq.mkString(" ")
    }

    def formatTries: String = {
      drawHangman(tries) + "\n" + s"Only $tries tries left"
    }

    /** Offers Side Quest and rewards or penalizes the player based on the result of the Side Quest
     */
    def sideQuest(tries: Int): Int = {
      var newTries: Int = tries
      if (SideQuest.prompt(tries)) {
        if (runSQ()) {
          println("You have earned an additional try!")
          newTries += 1
        } else {
          println("You lose one try!")
          newTries -= 1
        }
      }
      newTries
    }

    /** The SideQuest is initialized here
     * However, as can be seen in the SideQuest object,
     * at this stage the init method only draws the random try at which the Side Quest will be prompted
     */
    SideQuest.init()

    /** The main game loop starts here
     */
    while (!guessed && tries > 0) {
      if (guessedLetters.nonEmpty) {
        println(formatGuessedLetters)
      }
      println(formatOutcome)
      val guess = scala.io.StdIn.readLine("Enter your guess (letter or word): ")
      if (guess.length == 1) {
        val guessChar = guess.charAt(0).toLower
        if (guessedLetters.contains(guessChar)) {
          println(s"You already guessed the letter ${guessChar.toUpper}.")
        } else {
          guessedLetters.append(guessChar)
          if (!word.contains(guessChar)) {
            tries -= 1
            println(s"${guessChar.toUpper} is not in the word.\n$formatTries")
            //Offers the Player the SideQuest based on the tries left for the player in the HangMan Game
            tries = sideQuest(tries)
          } else {
            guessed = word.forall(char => guessedLetters.contains(char))
            println(s"Congratulations!! ${guessChar.toUpper} is in the word")
          }
        }
      } else if (guess.length == word.length) {
        if (guessedWords.contains(guess)) {
          println(s"You already guessed the word $guess")
        } else if (guess != word) {
          tries -= 2
          guessedWords.append(guess)
          println(s"$guess is not the word! You lose 2 tries for that!\n$formatTries")
          println(s"Words guessed: ${guessedWords.mkString(", ").toUpperCase}")
        } else {
          guessed = true
        }
      } else {
        println("Not a valid guess!")
      }
    }
    guessed
  }

  var goAgain: Boolean = true
  while (goAgain) {
    val word: String = getWord
    if (game(word)) {
      println(s"${word.toUpperCase} is the correct word, congrats!")
    } else {
      println(s"How sad, you lost! The word was ${word.toUpperCase}")
    }
    goAgain = !scala.io.StdIn.readLine("Play again? [Y/n] ").toLowerCase.startsWith("n")
  }
}



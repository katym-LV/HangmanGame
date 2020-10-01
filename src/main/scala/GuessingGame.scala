import scala.io.StdIn.readInt
import scala.util.Random

/** Our "good-old" number guessing game
 *
 * This game is used as the Side Quest for the HangMan
 */
object GuessingGame {
  def main(args: Array[String]): Unit = {
    game()
  }

  def game(): Boolean = {
    var guessed = false
    val nmin = 1
    val nmax = 50
    val maxTries = 5
    val trueNum = Random.between(nmin, nmax)
    var userGuess: Int = 0
    var gCount = 1

    print(s"Guess a number between $nmin and $nmax: ")
    while (!guessed && gCount <= maxTries) {
      userGuess = readInt()
      if (userGuess == trueNum) {
        guessed = true
      } else {
        if (userGuess > trueNum) {
          println(s"Guess No. $gCount: $userGuess TOO BIG! Try again ")
        } else {
          println(s"Guess No. $gCount: $userGuess TOO SMALL! Try again ")
        }
        gCount += 1
      }
    }
    if (guessed) {
      println(s"Side Quest completed in $gCount tries! the number was $trueNum.")
    } else {
      println(s"Side Quest failed! The number was  $trueNum.")
    }
    guessed
  }
}
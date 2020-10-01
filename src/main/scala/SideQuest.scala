import scala.util.Random
import GuessingGame.game

/** A Sidequest that provides an additional challenge to the seasoned Hangman'er
 */

object SideQuest extends App {
  var sqAccepted: Boolean = false
  var triggerAttempt: Int = 0

  /** Method for initializing the Side Quest game
   * It selects a random number of tries left in the main-game
   * If the selected number of tries is reached - the Side Quest is offered
   */
  def init(): Unit = {
    sqAccepted = false
    triggerAttempt = Random.between(1, 6)
  }

  /** Method that offers the Side Quest to the Player
   *
   * Player is prompted to choose to participate or decline
   */
  def prompt(attempt: Int): Boolean = {
    if (!sqAccepted && attempt == triggerAttempt) {
      val gnome =
        """
          |       __
          |    .-'  |
          |   /   <\|
          |  /     \'
          |  |_.- o-o
          |  / C  -._)\
          | /',        |
          ||   `-,_,__,'
          |(,,)====[_]=|
          |  '.   ____/
          |   | -|-|_
          |   |____)_)
          |""".stripMargin
      println(s"***SIDE QUEST***\n$gnome")
      sqAccepted = !scala.io.StdIn.readLine(
        """A friendly gnome offers you a Side Quest.
          |Choose wisely, as the SideQuest result will have an impact on the main game!
          |Do you accept? [Y/n] """.stripMargin).toLowerCase.startsWith("n")
      return sqAccepted
    }
    false
  }

  def runSQ(): Boolean = {
    game()
  }


}

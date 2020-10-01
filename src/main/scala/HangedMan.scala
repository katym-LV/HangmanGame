//Holds the illustrations for drawing the hanged man
/** An object that holds some additional stuff needed for the Hangman
 *
 * Namely: the Hanged-man ilustration and method for drawing the illustration
 */
object HangedMan {
  private val stages = Seq(
    """
      |   _________
      |      |    |
      |      O    |
      |     \|/   |
      |      |    |
      |     / \   |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |     \|/   |
      |      |    |
      |     /     |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |     \|/   |
      |      |    |
      |           |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |     \|/   |
      |           |
      |           |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |     \|    |
      |           |
      |           |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |      |    |
      |           |
      |           |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |      O    |
      |           |
      |           |
      |           |
      |          --
      |""".stripMargin,
    """
      |   _________
      |      |    |
      |           |
      |           |
      |           |
      |           |
      |          --
      |""".stripMargin
  )

  /** Ilustrates that Hanged-man based on tries left in the game
   */
  def drawHangman(tries: Int): String = {
    stages(tries)
  }

}

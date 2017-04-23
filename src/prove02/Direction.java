package prove02;

/**
 * Enumerates the different directions Creatures may move
 *
 * @author Matthew Burr
 * @version 1.0
 * @since 2017-04-22
 */
public enum Direction {
  RIGHT, LEFT, ABOVE, BELOW, UNKNOWN;

  /**
   * Derives a Direction from an integer
   *
   * @param i an integer representing a direction
   * @return the matching Direction
   */
  public static Direction fromInt(int i) {
    switch (i) {
      case 0:
        return Direction.RIGHT;
      case 1:
        return Direction.LEFT;
      case 2:
        return Direction.ABOVE;
      case 3:
        return Direction.BELOW;
      default:
        return Direction.UNKNOWN;
    }
  }
}

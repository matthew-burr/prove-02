package prove02;

import java.awt.Color;
import java.util.Random;

/**
 * Wolves are aggressive and chase after other creatures they detect nearby.
 * <p />
 *
 * @author Matthew Burr
 * @version 1.0
 * @since 2017-04-22
 */
public class Wolf extends Creature implements Movable, Aware, Aggressor {

  private int _preferredDirection;

  /**
   * Creates a new Wolf that will move in a random preferred direction
   */
  public Wolf() {
    _preferredDirection = new Random().nextInt(4);
  }

  /**
   * A Wolf moves in its preferred direction, which is towards the first
   * (@link Animal) it sees.
   * <p />
   */
  @Override
  public void move() {

    switch (_preferredDirection) {
      case 0:
        _location.x++;
        break;
      case 1:
        _location.x--;
        break;
      case 2:
        _location.y++;
        break;
      case 3:
        _location.y--;
        break;
      default:
        break;
    }
  }

  @Override
  public void attack(Creature target) {

  }

  @Override
  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

  }

  @Override
  Shape getShape() {
    return null;
  }

  @Override
  Color getColor() {
    return null;
  }

  @Override
  Boolean isAlive() {
    return null;
  }
}

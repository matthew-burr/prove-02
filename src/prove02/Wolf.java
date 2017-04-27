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
public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

  private Direction _preferredDirection;
  private Boolean _canSpawn = false;

  /**
   * Creates a new Wolf that will move in a random preferred direction
   */
  public Wolf() {
    _preferredDirection = Direction.fromInt(new Random().nextInt(4));
    _health = 1;
  }

  /**
   * A Wolf moves in its preferred direction, which is towards the first
   * (@link Animal) it sees.
   * <p />
   */
  @Override
  public void move() {

    switch (_preferredDirection) {
      case RIGHT:
        _location.x++;
        break;
      case LEFT:
        _location.x--;
        break;
      case BELOW:
        _location.y++;
        break;
      case ABOVE:
        _location.y--;
        break;
      default:
        break;
    }
  }

  /**
   * A Wolf attacks what it lands on unless it's a Zombie or a Plant. Wolves deal 5 points
   * of damage.
   *
   * @param target The {@link Creature} we've encounterd.
   */
  @Override
  public void attack(Creature target) {

    // Ignore Zombies and Plants (and null targets)
    if (target == null || target instanceof Plant || target instanceof Zombie) {
      return;
    }

    target.takeDamage(5);
    _canSpawn = true;
  }

  /**
   * A Wolf chases any nearby animals. It will prefer to chase an Animal in the
   * direction it is already heading, but if there is none, it will check the other
   * directions in a clockwise order, starting from the top.
   * @param above The {@link Creature} directly above us.
   * @param below The {@link Creature} directly below us.
   * @param left The {@link Creature} directly to the left of us.
   * @param right The {@link Creature} directly to the right of us.
   */
  @Override
  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

    // If all the Creatures are null, we can just skip out of here
    if (above == null && below == null && left == null && right == null) {
      return;
    }

    // First, we check to see if there's a Creature in our preferred direction
    switch (_preferredDirection) {
      case RIGHT:
        if (right instanceof Animal) {
          return;
        }
        break;
      case LEFT:
        if (left instanceof Animal) {
          return;
        }
        break;
      case ABOVE:
        if (above instanceof Animal) {
          return;
        }
        break;
      case BELOW:
        if (below instanceof Animal) {
          return;
        }
        break;
      default:
        break;
    }

    // If we're here, there wasn't an animal in our preferred location,
    // so, now we check each location in turn until we find one; there is a chance of a redundant
    // check of our preferred location, but the cost is low and this makes for less code.
    if (above instanceof Animal) {
      _preferredDirection = Direction.ABOVE;
    } else if (right instanceof Animal) {
      _preferredDirection = Direction.RIGHT;
    } else if (below instanceof Animal) {
      _preferredDirection = Direction.BELOW;
    } else if (left instanceof Animal) {
      _preferredDirection = Direction.LEFT;
    }
    // If there are no animals nearby, we just keep going
    // in our current direction.
 
  }

  @Override
  Shape getShape() {
    return Shape.Square;
  }

  @Override
  Color getColor() {
    return new Color(128, 128, 128);
  }

  @Override
  Boolean isAlive() {
    return _health > 0;
  }

  /***
   * If the Wolf has recently eaten, spawns a new Wolf.
   * @return a new Wolf
   */
  @Override
  public Creature spawnNewCreature() {
    // If we can spawn, do so, but just this once
    if (_canSpawn) {
      _canSpawn = false;
      return new Wolf();
    }

    // If we reach this point, we can't spawn, so we just return null

    return null;
  }
}

package prove02;

import java.awt.Color;

/**
 * Zombies are powerful Creatures that attack everything but Plants.
 * <p />
 * They are represented as blue squares.
 * <p />
 *
 * @author Matthew Burr
 * @version 1.0
 * @see Creature
 * @since 2017-04-22
 */
public class Zombie extends Creature implements Movable, Aggressor {

  public Zombie() {
    _health = 1;
  }

  /**
   * Moves a Zombie. Zombies always move left to right.
   */
  @Override
  public void move() {
    _location.x++;
  }

  /**
   * Zombies attach anything they land on except Plants.
   * <p />
   * Zombies cause 10 points of Damage
   *
   * @param target The {@link Creature} we've encounterd.
   */
  @Override
  public void attack(Creature target) {
    if (target == null || target instanceof Plant) {
      return;
    }

    target.takeDamage(10);
  }

  @Override
  Shape getShape() {
    return Shape.Square;
  }

  @Override
  Color getColor() {
    return new Color(0, 0, 255);
  }

  @Override
  Boolean isAlive() {
    return _health > 0;
  }
}

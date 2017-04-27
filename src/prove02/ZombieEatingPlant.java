package prove02;

import java.awt.Color;
import java.util.Random;

/**
 * A Zombie-eating Plant. They only eat Zombies and the Move, but slowly and in an upward direction
 * always.
 *
 * @author Matthew Burr
 * @version 1.0
 * @since 2017-04-26
 */
public class ZombieEatingPlant extends Plant implements Aggressor, Movable {

  private int _moveCounter;
  private Random _rand;

  ZombieEatingPlant() {
    super();
    _moveCounter = 0;
    _rand = new Random();
  }

  @Override
  public void attack(Creature target) {
    if (target instanceof Zombie) {
      target.takeDamage(1);
      _health++;
    }
  }

  @Override
  public Color getColor() {
    return new Color(0, 64, 128);
  }

  @Override
  public void move() {
    _moveCounter++;
    if (_moveCounter % (_rand.nextInt(10) + 5) == 0) {
      _location.y--;
    }
  }
}

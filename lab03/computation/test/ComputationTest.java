import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputationTest {

  Computation computation = new Computation();

  @Test
  public void add() {
    assertEquals(2, computation.add(1, 1));
    assertEquals(Integer.MIN_VALUE + 5, computation.add(Integer.MIN_VALUE, 5));
  }

  @Test
  public void substract() {
    assertEquals(3, computation.substract(10, 7));
    assertEquals(-3, computation.substract(7, 10));
  }

  @Test
  public void divide() {
    assertEquals(0.5d, computation.divide(1, 2), 0.0d);
    assertEquals(Double.POSITIVE_INFINITY, computation.divide(1, 0), 0.0d);
  }

  @Test
  public void catchesException() {
    assertDoesNotThrow(() -> computation.catchesException());
  }

  @Test
  public void multiply() {
    assertEquals(10, computation.multiply(5, 2));
    assertEquals(0, computation.multiply(100, 0));
  }

  @Test
  public void justALoop() {
    assertEquals(2, computation.justALoop());
  }
}

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {

  private int annee;
  private int mois;
  private int jour;

  public DateNextDateExceptionTest(int annee, int mois, int jour) {
    this.annee = annee;
    this.mois  = mois;
    this.jour  = jour;
  }

  @Parameters
  public static List<Integer[]> data() {
    List<Integer[]> params = new LinkedList<Integer[]>();
    params.add(new Integer[] { 1500,  2,  31 }); // TC16
    params.add(new Integer[] { 1500,  2,  29 }); // TC17
    params.add(new Integer[] {   -1, 10,  20 }); // TC18
    params.add(new Integer[] { 1458, 15,  12 }); // TC19
    params.add(new Integer[] { 1975,  6, -50 }); // TC20
    return params;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException() {
    new Date(annee, mois, jour);
  }
}

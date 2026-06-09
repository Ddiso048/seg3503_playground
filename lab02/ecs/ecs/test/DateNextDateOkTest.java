import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {

  private int anneeIn;
  private int moisIn;
  private int jourIn;
  private int anneeOut;
  private int moisOut;
  private int jourOut;

  public DateNextDateOkTest(int anneeIn, int moisIn, int jourIn,
                             int anneeOut, int moisOut, int jourOut) {
    this.anneeIn  = anneeIn;
    this.moisIn   = moisIn;
    this.jourIn   = jourIn;
    this.anneeOut = anneeOut;
    this.moisOut  = moisOut;
    this.jourOut  = jourOut;
  }

  @Parameters
  public static List<Integer[]> data() {
    List<Integer[]> params = new LinkedList<Integer[]>();
    params.add(new Integer[] { 1700, 6,  20,  1700, 6,  21 }); // TC1
    params.add(new Integer[] { 2005, 4,  15,  2005, 4,  16 }); // TC2
    params.add(new Integer[] { 1901, 7,  20,  1901, 7,  21 }); // TC3
    params.add(new Integer[] { 3456, 3,  27,  3456, 3,  28 }); // TC4
    params.add(new Integer[] { 1500, 2,  17,  1500, 2,  18 }); // TC5
    params.add(new Integer[] { 1700, 6,  29,  1700, 6,  30 }); // TC6
    params.add(new Integer[] { 1800, 11, 29,  1800, 11, 30 }); // TC7
    params.add(new Integer[] { 3453, 1,  29,  3453, 1,  30 }); // TC8
    params.add(new Integer[] { 444,  2,  29,  444,  3,  1  }); // TC9
    params.add(new Integer[] { 2005, 4,  30,  2005, 5,  1  }); // TC10
    params.add(new Integer[] { 3453, 1,  30,  3453, 1,  31 }); // TC11
    params.add(new Integer[] { 3456, 3,  30,  3456, 3,  31 }); // TC12
    params.add(new Integer[] { 1901, 7,  31,  1901, 8,  1  }); // TC13
    params.add(new Integer[] { 3453, 1,  31,  3453, 2,  1  }); // TC14
    params.add(new Integer[] { 3456, 12, 31,  3457, 1,  1  }); // TC15
    return params;
  }

  @Test
  public void testNextDateOk() {
    Date d = new Date(anneeIn, moisIn, jourIn);
    Assert.assertEquals(new Date(anneeOut, moisOut, jourOut), d.nextDate());
  }
}

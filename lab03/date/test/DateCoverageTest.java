import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateCoverageTest {

  @Test
  void constructorAcceptsBoundaryValidDates() {
    assertEquals("2024/February/29", new Date(2024, 2, 29).toString());
    assertEquals("2023/February/28", new Date(2023, 2, 28).toString());
    assertEquals("2023/April/30", new Date(2023, 4, 30).toString());
    assertEquals("2023/June/30", new Date(2023, 6, 30).toString());
    assertEquals("2023/September/30", new Date(2023, 9, 30).toString());
    assertEquals("2023/November/30", new Date(2023, 11, 30).toString());
    assertEquals("2023/January/31", new Date(2023, 1, 31).toString());
    assertEquals("0/January/1", new Date(0, 1, 1).toString());
  }

  @Test
  void constructorRejectsInvalidDaysMonthsAndYears() {
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 1, 0));
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 1, 32));
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 4, 31));
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 2, 29));
    assertThrows(IllegalArgumentException.class, () -> new Date(2024, 2, 30));
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 0, 1));
    assertThrows(IllegalArgumentException.class, () -> new Date(2023, 13, 1));
    assertThrows(IllegalArgumentException.class, () -> new Date(-1, 1, 1));
  }

  @Test
  void nextDateCoversNormalEndOfMonthLeapAndYearChange() {
    assertEquals(new Date(2023, 1, 16), new Date(2023, 1, 15).nextDate());
    assertEquals(new Date(2023, 5, 1), new Date(2023, 4, 30).nextDate());
    assertEquals(new Date(2024, 3, 1), new Date(2024, 2, 29).nextDate());
    assertEquals(new Date(2023, 3, 1), new Date(2023, 2, 28).nextDate());
    assertEquals(new Date(2024, 1, 1), new Date(2023, 12, 31).nextDate());
  }

  @Test
  void leapYearRulesCoverCenturyCases() {
    assertTrue(new Date(2024, 1, 1).isLeapYear());
    assertFalse(new Date(2023, 1, 1).isLeapYear());
    assertFalse(new Date(1900, 1, 1).isLeapYear());
    assertTrue(new Date(2000, 1, 1).isLeapYear());
  }

  @Test
  void equalsCoversAllOutcomes() {
    Date base = new Date(2023, 6, 15);
    assertEquals(base, new Date(2023, 6, 15));
    assertNotEquals(base, "2023/June/15");
    assertNotEquals(base, new Date(2024, 6, 15));
    assertNotEquals(base, new Date(2023, 7, 15));
    assertNotEquals(base, new Date(2023, 6, 16));
  }
}

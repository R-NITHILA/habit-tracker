package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exceptions.InvalidHabitException;
import java.util.List;

public class HabitTrackerBackendTest {

  private HabitTrackerBackend backend;

  @BeforeEach
  void setUp() {
    backend = new HabitTrackerBackend(false);
  }

  @Test
  void testAddHabitToBackend() throws InvalidHabitException {
  
    backend.addHabit("Meditate", "Daily", "General", 2);

    List<Habit> habits = backend.getAllHabits();
    assertEquals(1, habits.size());
    Habit habit = habits.get(0);
    assertEquals("Meditate", habit.getName());
    assertEquals("Daily", habit.getFrequency());
    assertEquals("General", habit.getCategory());
    assertEquals(2, habit.getPriority());
  }

  @Test
  void testMarkCompleteBackend() throws InvalidHabitException {
    backend.addHabit("Meditate", "Daily", "General", 2);
    Habit habit = backend.getAllHabits().get(0);

    backend.markComplete(habit.getId());

    Habit updatedHabit = backend.getHabitById(habit.getId());

    assertEquals(1, updatedHabit.getStreak());
    assertEquals(1, updatedHabit.getTotalCompletions());
    assertTrue(updatedHabit.isCompletedToday());
  }
}
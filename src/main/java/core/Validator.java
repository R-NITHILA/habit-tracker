package core;

import exceptions.InvalidHabitException;

public interface Validator {
  boolean validate(String name, String frequency) throws InvalidHabitException;

  static boolean isValidName(String name) {
    return name != null && !name.trim().isEmpty();
  }
}

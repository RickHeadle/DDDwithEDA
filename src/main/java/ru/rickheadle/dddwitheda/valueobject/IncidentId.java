package ru.rickheadle.dddwitheda.valueobject;

import java.util.UUID;

public class IncidentId extends BaseId<UUID>{

  public IncidentId(UUID value) {
    super(value);
  }
}

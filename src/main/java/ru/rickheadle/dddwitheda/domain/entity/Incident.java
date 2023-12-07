package ru.rickheadle.dddwitheda.domain.entity;

import ru.rickheadle.dddwitheda.entity.AggregateRoot;
import ru.rickheadle.dddwitheda.entity.UserInfo;
import ru.rickheadle.dddwitheda.valueobject.IncidentId;
import ru.rickheadle.dddwitheda.valueobject.IncidentStatus;

public class Incident extends AggregateRoot<IncidentId> {

  private IncidentStatus requestStatus;
  private UserInfo userInfo;
}

package ru.rickheadle.dddwitheda;

/**
 * Обозначает класс для указания объекта события с типом сущности, который отправит это событие из
 * домена.
 * Например, IncidentCreatedEvent будет иметь общий тип Incident, который является классом сущности,
 * от которого изначально происходит событие.
 * @param <T>
 */
public interface DomainEvent<T> {

}

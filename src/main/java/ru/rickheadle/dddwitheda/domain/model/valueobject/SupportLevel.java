package ru.rickheadle.dddwitheda.domain.model.valueobject;

public enum SupportLevel {

  /**
   * Специалисты первой линии принимают обращения, классифицируют, регистрируют
   * и выполняют дальнейшие действия по приоритезации, диагностике и так далее. <br><br>
   *
   * Задача первой линии — оперативно реагировать на поступающие обращения
   * и устранять их в кратчайшие сроки, если для решения есть подготовленная инструкция -
   * либо оперативно принять решение об эскалации на следующий уровень поддержки,
   * если инструкции для решения нет.
   */
  L1,

  /**
   * Это специалисты более высокой квалификации, которые имеют более глубокие знания.
   * В отличии от специалистов первой линии поддержки, понимают сеть.
   */
  L2,

  /**
   * Третья линия подключается, если вторая линия не может решить вопрос клиента
   * на своем уровне доступа и знаний. <br>
   * Это узкопрофильные квалифицированные системные администраторы.
   */
  L3
}
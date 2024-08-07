@todo

Feature: Crear un pedido en la tienda de mascotas

  @createOrder
  Scenario Outline: Crear un pedido exitoso
    When creo un pedido con quantity "<quantity>", shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then la respuesta debe tener un código de estado <statusCode>
    And el type es "<type>"

    Examples:
      | quantity | shipDate                 | status | complete | statusCode | type    |
      | 2        | 2024-08-07T20:26:26.312Z | placed | true     | 200        | unknown |
      | 5        | 2024-08-07T20:26:26.312Z | placed | true     | 200        | unknown |
@todo

Feature: Constular Por Id

  @consultarById
  Scenario: Consulta un servicio
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When hago la consulta una orden con ID 9
    Then imprimo la orden
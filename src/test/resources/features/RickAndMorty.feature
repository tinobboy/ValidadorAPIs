#language: es
Característica: Rick and Morty Test

  @test
  Escenario: Se prueba el funcionamiento de una API del personaje Morty
  Dado una url completa del personaje Morty
  Cuando se ejecuta el request
  Entonces el resultado fue exitoso

  @test
  Escenario: Se prueba el funcionamiento de una API del personaje Rick
    Dado una url completa del personaje Rick
    Cuando se ejecuta el request
    Entonces el resultado fue exitoso
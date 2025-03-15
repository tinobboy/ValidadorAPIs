#language: es
Característica: Rick and Morty Test

  @test
  Esquema del escenario: Se prueba el funcionamiento de una API del personaje <personaje>
    Dado una url completa del personaje <personaje>
    Cuando se ejecuta el request
    Entonces el resultado fue exitoso

    Ejemplos:
    |personaje   |
    |Rick Sanchez|
    |Morty Smith |
    |Summer Smith|
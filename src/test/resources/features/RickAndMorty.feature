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
    |Beth Smith  |
    |Jerry Smith |

    @test
    Escenario: Se obtiene los personajes segun el episodio
      Dado la api el episodio 1
      Cuando se ejecuta el request
      Entonces se obtiene los personajes que aparecieron en el episodio 1 y se imprime el nombre
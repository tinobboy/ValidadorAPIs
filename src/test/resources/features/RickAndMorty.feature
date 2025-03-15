#language: es
Característica: Rick and Morty Test

  @test
  Esquema del escenario: Se prueba el funcionamiento de una API del personaje <personaje>
    Dado una url completa del personaje <personaje>
    Cuando se ejecuta el request
    Entonces el resultado fue exitoso

    Ejemplos:
      | personaje    |
      | Rick Sanchez |
      | Morty Smith  |
      | Summer Smith |
      | Beth Smith   |
      | Jerry Smith  |

  @test
  Escenario: Se obtiene los personajes del episodio 1
    Dado la api del episodio 1
    Cuando se ejecuta el request
    Entonces se obtiene los personajes que aparecieron en el episodio 1 y se imprime el nombre

  @test
  Esquema del escenario: Se imprime el nombre de cada personaje para el episodio <nroEpisodio>
    Dado la ejecucion de la api de personajes y comparando contra la del episodio <nroEpisodio>
    Cuando se ejecuta el request
    Entonces se obtiene los nombres de personajes que aparecieron
    Ejemplos:
    |nroEpisodio|
    | 1         |
    | 3         |
    | 7         |


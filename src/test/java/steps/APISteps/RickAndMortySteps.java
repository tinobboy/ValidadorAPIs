package steps.APISteps;

import constants.RequestMethods;
import core.RequestSpecification;
import core.ResponseSpecification;
import enums.DatosPersonajes;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import steps.BaseSteps;
import steps.RequestSteps;

import java.util.ArrayList;
import java.util.List;

public class RickAndMortySteps {

    private static BaseSteps step = new BaseSteps();
    private ResponseSpecification respuestaActual;
    private RequestSpecification requestSpecification;
    private int id;

    @Before("@test")
    public void beforeScenario() {
        requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
    }

    @Dado("^una url completa del personaje (.*)$")
    public void unaUrlCompletaDelPersonajeMorty(String personaje) {

        switch (personaje) {
            case "Rick Sanchez":
                id = DatosPersonajes.Personajes.Rick_Sanchez.getId();
                requestSpecification.setPaths("/character/" + id + "");
                break;
            case "Morty Smith":
                id = DatosPersonajes.Personajes.Morty_Smith.getId();
                requestSpecification.setPaths("/character/" + id + "");
                break;
            case "Summer Smith":
                id = DatosPersonajes.Personajes.Summer_Smith.getId();
                requestSpecification.setPaths("/character/" + id + "");
                break;
            case "Beth Smith":
                id = DatosPersonajes.Personajes.Beth_Smith.getId();
                requestSpecification.setPaths("/character/" + id + "");
                break;
            case "Jerry Smith":
                id = DatosPersonajes.Personajes.Jerry_Smith.getId();
                requestSpecification.setPaths("/character/" + id + "");
                break;
        }

    }

    @Dado("^la api el episodio 1$")
    public void laApiElEpisodio1() {
        requestSpecification.setPaths("/episode/1");
    }

    @Cuando("^se ejecuta el request$")
    public void seEjecutaElRequest() {
        respuestaActual = new RequestSteps().executeRequest(requestSpecification);
    }

    @Entonces("^el resultado fue exitoso$")
    public void elResultadoFueExitoso() {
        step.validateResponseCodeyContentType(respuestaActual, 200, ContentType.JSON);
        new ValidarCaracteres().validar(respuestaActual.getBody(), id);
    }

    @Entonces("^se obtiene los personajes que aparecieron en el episodio 1 y se imprime el nombre$")
    public void seObtieneLosPersonajesQueAparecieronEnElEpisodio1YSeImprimeElNombre() {
        int cantidadDeEpisodios = respuestaActual.getBody().get("characters").size();
        List<Integer> idPersonaje = new ArrayList<>();
        List<String> nombresDePersonajes = new ArrayList<>();

        for (int i = 0; i < cantidadDeEpisodios; i++) {
            String urlPersonaje = String.valueOf(respuestaActual.getBody().get("characters").get(i));
            int ultimoNumero = extraerUltimoNumero(urlPersonaje);
            idPersonaje.add(ultimoNumero);
        }

        for (int x = 0; x < idPersonaje.size(); x++) {
            if (DatosPersonajes.Personajes.Rick_Sanchez.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Rick_Sanchez.getName());
            } else if (DatosPersonajes.Personajes.Morty_Smith.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Morty_Smith.getName());
            } else if (DatosPersonajes.Personajes.Beth_Smith.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Beth_Smith.getName());
            } else if (DatosPersonajes.Personajes.Jerry_Smith.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Jerry_Smith.getName());
            } else if (DatosPersonajes.Personajes.Bepisian.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Bepisian.getName());
            } else if (DatosPersonajes.Personajes.Canklanker_Thom.getId() == idPersonaje.get(x)) {
                nombresDePersonajes.add(DatosPersonajes.Personajes.Canklanker_Thom.getName());
            }
        }
        Allure.addAttachment("Los Personajes que se encuentran en el episodio 1 son :", String.valueOf(nombresDePersonajes));
        System.out.println(nombresDePersonajes);
    }

    /**
     * Método para extraer el último número de una URL
     **/
    private static int extraerUltimoNumero(String url) {
        String[] partes = url.split("/");
        String ultimaParte = partes[partes.length - 1].replace("\"", "");
        return Integer.parseInt(ultimaParte);
    }
}

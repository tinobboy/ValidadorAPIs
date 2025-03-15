package steps.APISteps;

import constants.RequestMethods;
import core.RequestSpecification;
import core.ResponseSpecification;
import enums.DatosPersonajes;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.sl.In;
import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import org.junit.Assume;
import steps.BaseSteps;
import steps.RequestSteps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RickAndMortySteps {

    private static BaseSteps step = new BaseSteps();
    private ResponseSpecification respuestaActual,respuestaActualCaracteres;
    private RequestSpecification requestSpecification;
    private int id;
    List<HashMap<String, Object>> personajes = new ArrayList<>();

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

    @Dado("^la api del episodio 1$")
    public void laApiElEpisodio1() {
        requestSpecification.setPaths("/episode/1");
    }

    @Dado("^la ejecucion de la api de personajes y comparando contra la del episodio (.*)$")
    public void laEjecucionDeLaApiDePersonajesYComparandoContraLaDelEpisodioNroEpisodio(String nroEpisodio) {
        personajes = ejecutarApiCaracteres();
        requestSpecification.setPaths("/episode/"+nroEpisodio+"");
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
        step.validateResponseCodeyContentType(respuestaActual, 200, ContentType.JSON);
        int cantidadDeCaracteres = respuestaActual.getBody().get("characters").size();
        List<Integer> idPersonaje = new ArrayList<>();
        List<String> nombresDePersonajes = new ArrayList<>();

        for (int i = 0; i < cantidadDeCaracteres; i++) {
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

    @Entonces("se obtiene los nombres de personajes que aparecieron")
    public void seObtieneLosNombresDePersonajesQueAparecieron() {
        step.validateResponseCodeyContentType(respuestaActual, 200, ContentType.JSON);
        int cantidadDeCaracteres = respuestaActual.getBody().get("characters").size();
        List<Integer> idPersonajesEpisodio = new ArrayList<>();
        List<String> nombresDePersonajes = new ArrayList<>();

        for (int i = 0; i < cantidadDeCaracteres; i++) {
            String urlPersonaje = String.valueOf(respuestaActual.getBody().get("characters").get(i));
            int ultimoNumero = extraerUltimoNumero(urlPersonaje);
            idPersonajesEpisodio.add(ultimoNumero);
        }

        for (HashMap<String, Object> personaje : personajes) {
            int idPersonaje = Integer.parseInt(String.valueOf(personaje.get("id")));
            if (idPersonajesEpisodio.contains(idPersonaje)) {
                nombresDePersonajes.add(String.valueOf(personaje.get("name")));
            }
        }
        System.out.println("Personajes que aparecieron en el episodio:");
        for (String nombre : nombresDePersonajes) {
            System.out.println(nombre);
            Allure.addAttachment("Los Personajes que se encuentran en el episodio 1 son :", String.valueOf(nombre));
        }

        Assume.assumeFalse("No se encontraron personajes en el episodio",nombresDePersonajes.isEmpty());
    }

    /**
     * Metodo que ejecuta api de los caracteres y devuelve una lista de hashmap string object
     */
    public List<HashMap<String, Object>> ejecutarApiCaracteres(){

        requestSpecification.setPaths("/character");
        respuestaActualCaracteres = new RequestSteps().executeRequest(requestSpecification);
        step.validateResponseCodeyContentType(respuestaActualCaracteres, 200, ContentType.JSON);

        int cantidadDeCaracteres = respuestaActualCaracteres.getBody().get("results").size();

        for (int i = 0; i < cantidadDeCaracteres; i++) {
            int idPersonaje = Integer.parseInt(respuestaActualCaracteres.getBody().get("results").get(i).get("id").asText());
            String nombrePersonaje = String.valueOf(respuestaActualCaracteres.getBody().get("results").get(i).get("name"));
            HashMap<String, Object> personaje = new HashMap<>();
            personaje.put("id", idPersonaje);
            personaje.put("name", nombrePersonaje);

            personajes.add(personaje);
        }
        return personajes;
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

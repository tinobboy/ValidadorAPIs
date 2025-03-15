package steps.APISteps;

import constants.RequestMethods;
import core.RequestSpecification;
import core.ResponseSpecification;
import enums.DatosPersonajes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.http.ContentType;
import steps.BaseSteps;
import steps.RequestSteps;

public class RickAndMortySteps {

    private static BaseSteps step = new BaseSteps();
    private ResponseSpecification respuestaActual;
    private RequestSpecification requestSpecification;
    private int id;

    @Dado("^una url completa del personaje (.*)$")
    public void unaUrlCompletaDelPersonajeMorty(String personaje) {

        switch (personaje){
            case "Rick Sanchez":
                id = DatosPersonajes.Personajes.Rick_Sanchez.getId();
                requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
                requestSpecification.setPaths("/character/"+id+"");
                break;
            case "Morty Smith":
                id = DatosPersonajes.Personajes.Morty_Smith.getId();
                requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
                requestSpecification.setPaths("/character/"+id+"");
                break;
            case "Summer Smith":
                id = DatosPersonajes.Personajes.Summer_Smith.getId();
                requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
                requestSpecification.setPaths("/character/"+id+"");
                break;
        }

    }

    @Cuando("^se ejecuta el request$")
    public void seEjecutaElRequest() {
        respuestaActual = new RequestSteps().executeRequest(requestSpecification);
    }

    @Entonces("^el resultado fue exitoso$")
    public void elResultadoFueExitoso() {
        step.validateResponseCodeyContentType(respuestaActual, 200, ContentType.JSON);
        new ValidarCaracteres().validar(respuestaActual.getBody(),id);
    }
}

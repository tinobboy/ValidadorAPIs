package steps.APISteps;

import constants.RequestMethods;
import core.RequestSpecification;
import core.ResponseSpecification;
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

    @Dado("^una url completa del personaje Morty$")
    public void unaUrlCompletaDelPersonajeMorty() {
        id=2;
        requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
        requestSpecification.setPaths("/character/"+id+"");
    }

    @Dado("^una url completa del personaje Rick$")
    public void unaUrlCompletaDelPersonajeRick() {
        id=1;
        requestSpecification = new RequestSpecification("https://rickandmortyapi.com/api", RequestMethods.GET);
        requestSpecification.setPaths("/character/"+id+"");
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

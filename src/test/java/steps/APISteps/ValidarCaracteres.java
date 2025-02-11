package steps.APISteps;

import com.fasterxml.jackson.databind.JsonNode;
import utils.ValidadorPostcondicion;

public class ValidarCaracteres {

    public void validar(JsonNode body, int id) {
        new ValidadorPostcondicion(body).compararCampoNumber("id",id);
    }
}

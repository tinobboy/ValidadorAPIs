package steps.APISteps;

import com.fasterxml.jackson.databind.JsonNode;
import enums.DatosPersonajes;
import utils.ValidadorPostcondicion;

public class ValidarCaracteres {

    public void validar(JsonNode body, int id) {
        ValidadorPostcondicion validadorPostcondicion = new ValidadorPostcondicion(body);

        switch (id) {
            case 1:
                validadorPostcondicion.compararCampoNumber("id", id)
                        .compararCampoString("name", DatosPersonajes.Personajes.Rick_Sanchez.getName())
                        .compararCampoString("status", DatosPersonajes.Personajes.Rick_Sanchez.getStatus())
                        .compararCampoString("species", DatosPersonajes.Personajes.Rick_Sanchez.getSpecies())
                        .compararCampoString("type", DatosPersonajes.Personajes.Rick_Sanchez.getType())
                        .compararCampoString("gender", DatosPersonajes.Personajes.Rick_Sanchez.getGender());
                new ValidadorPostcondicion(body.get("origin"))
                        .compararCampoString("name", DatosPersonajes.Personajes.Rick_Sanchez.getOrigin_name())
                        .compararCampoString("url", DatosPersonajes.Personajes.Rick_Sanchez.getOrigin_url());
                break;
            case 2:
                validadorPostcondicion.compararCampoNumber("id", id)
                        .compararCampoString("name", DatosPersonajes.Personajes.Morty_Smith.getName())
                        .compararCampoString("status", DatosPersonajes.Personajes.Morty_Smith.getStatus())
                        .compararCampoString("species", DatosPersonajes.Personajes.Morty_Smith.getSpecies())
                        .compararCampoString("type", DatosPersonajes.Personajes.Morty_Smith.getType())
                        .compararCampoString("gender", DatosPersonajes.Personajes.Morty_Smith.getGender());
                new ValidadorPostcondicion(body.get("origin"))
                        .compararCampoString("name", DatosPersonajes.Personajes.Morty_Smith.getOrigin_name())
                        .compararCampoString("url", DatosPersonajes.Personajes.Morty_Smith.getOrigin_url());
                break;
            case 3:
                validadorPostcondicion.compararCampoNumber("id", id)
                        .compararCampoString("name", DatosPersonajes.Personajes.Summer_Smith.getName())
                        .compararCampoString("status", DatosPersonajes.Personajes.Summer_Smith.getStatus())
                        .compararCampoString("species", DatosPersonajes.Personajes.Summer_Smith.getSpecies())
                        .compararCampoString("type", DatosPersonajes.Personajes.Summer_Smith.getType())
                        .compararCampoString("gender", DatosPersonajes.Personajes.Summer_Smith.getGender());
                new ValidadorPostcondicion(body.get("origin"))
                        .compararCampoString("name", DatosPersonajes.Personajes.Summer_Smith.getOrigin_name())
                        .compararCampoString("url", DatosPersonajes.Personajes.Summer_Smith.getOrigin_url());
                break;
        }
    }
}

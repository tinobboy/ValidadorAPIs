package utils;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.qameta.allure.Allure;

public class ReportesHTML {

    public ReportesHTML imprimirResultadoAllure(List<String> nombresDePersonajes) {
        List<HashMap<String, Object>> lista = crearLista(nombresDePersonajes);
        String html = Attatchments.convertirAHTML(lista);
        Allure.addAttachment("Resultado", "text/html", new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)), ".html");
        return this;
    }

    public List<HashMap<String, Object>> crearLista(List<String> nombresDePersonajes){
        List<String> listaDeNombres = nombresDePersonajes;

        List<HashMap<String, Object>> listaDeMapas = new ArrayList<>();

        for (String nombre : listaDeNombres) {
            HashMap<String, Object> mapa = new HashMap<>();
            mapa.put("Personajes:", nombre);
            listaDeMapas.add(mapa);
        }
        return listaDeMapas;
    }

}

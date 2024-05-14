package com.alura.conversorChallenge.util;

import java.util.ArrayList;
import java.util.List;

public class Filtrar {
    List<String> divisas;

    public Filtrar() {
        this.divisas = new ArrayList<>();

        this.divisas.add("USD");
        this.divisas.add("PEN");
        this.divisas.add("BRL");
        this.divisas.add("COP");
        this.divisas.add("ARS");
    }

    public String filtrarMoneda(int monedaBase) {
        int indice = monedaBase - 1;
        return divisas.get(indice);
    }

    public String filtrarMoneda(int monedaBase, int tipoDeCambio){
        List<String> divisasCp = new ArrayList<>(divisas);
        int indiceMonedaBase = monedaBase - 1;
        int indiceTipoDeCambio = tipoDeCambio - 1;
        divisasCp.remove(indiceMonedaBase);

        return divisasCp.get(indiceTipoDeCambio);
    }
}

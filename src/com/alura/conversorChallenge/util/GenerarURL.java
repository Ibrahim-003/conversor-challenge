package com.alura.conversorChallenge.util;

public class GenerarURL {
    private String abreviaturaMonedaBase;
    private String abreviaturaTipoDeCambio;
    private double montoAConvertir;
    public GenerarURL(String abreviaturaMonedaBase, String abreviaturaTipoDeCambio, double montoAConvertir) {
        this.abreviaturaMonedaBase = abreviaturaMonedaBase;
        this.abreviaturaTipoDeCambio = abreviaturaTipoDeCambio;
        this.montoAConvertir = montoAConvertir;
    }

    public String getUrl() {
        String url = "https://v6.exchangerate-api.com/v6/ab101a4065f4fc8ee0e71309/pair/%s/%s/%.2f"
                .formatted(this.abreviaturaMonedaBase, this.abreviaturaTipoDeCambio, this.montoAConvertir);

        return url;
    }
}

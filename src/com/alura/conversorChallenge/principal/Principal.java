package com.alura.conversorChallenge.principal;

import com.alura.conversorChallenge.modelo.ConversionDivisaExAPI;
import com.alura.conversorChallenge.service.APIConnection;
import com.alura.conversorChallenge.util.Filtrar;
import com.alura.conversorChallenge.util.GenerarURL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    Scanner userInput = new Scanner(System.in);
    Filtrar filtrarDivisa = new Filtrar();
    int monedaBase = 1;
    double montoAConvertir;
    int tipoDeCambio;
    String abreviaturaMonedaBase;
    String abreviaturaTipoDeCambio=null;
    public void mostrarMenu() {

        while(monedaBase != 6) {

            try{
                System.out.println("*******************************");
                System.out.println("Bienvenido/a al Conversor de Moneda =]");
                System.out.println("Elija su Moneda Base: \n");
                System.out.println("1) Dolar - (USD)");
                System.out.println("2) Sol Peruano - (PEN)");
                System.out.println("3) Real Brasileño - (BRL)");
                System.out.println("4) Peso Colombiano - (COP)");
                System.out.println("5) Peso Argentino - (ARS)");
                System.out.println("6) Salir del programa!");
                System.out.println("Elija una opcion valida:");
                System.out.println("*******************************");

                monedaBase = userInput.nextInt();
                if (monedaBase == 6) {
                    break;
                }
                abreviaturaMonedaBase = filtrarDivisa.filtrarMoneda(monedaBase);

                System.out.println("Ingrese el monto que desear convertir: ");
                montoAConvertir = userInput.nextDouble();

                System.out.println("Ingrese el tipo de cambio!");

                switch (monedaBase) {
                    case 1:
                        System.out.println("1) Sol Peruano - (PEN)");
                        System.out.println("2) Real Brasileño - (BRL)");
                        System.out.println("3) Peso Colombiano - (COP)");
                        System.out.println("4) Peso Argentino - (ARS)");
                        tipoDeCambio = userInput.nextInt();
                        abreviaturaTipoDeCambio = filtrarDivisa.filtrarMoneda(monedaBase, tipoDeCambio);
                        break;
                    case 2:
                        System.out.println("1) Dolar - (USD)");
                        System.out.println("2) Real Brasileño - (BRL)");
                        System.out.println("3) Peso Colombiano - (COP)");
                        System.out.println("4) Peso Argentino - (ARS)");
                        tipoDeCambio = userInput.nextInt();
                        abreviaturaTipoDeCambio = filtrarDivisa.filtrarMoneda(monedaBase, tipoDeCambio);
                        break;
                    case 3:
                        System.out.println("1) Dolar - (USD)");
                        System.out.println("2) Sol Peruano - (PEN)");
                        System.out.println("3) Peso Colombiano - (COP)");
                        System.out.println("4) Peso Argentino - (ARS)");
                        tipoDeCambio = userInput.nextInt();
                        abreviaturaTipoDeCambio = filtrarDivisa.filtrarMoneda(monedaBase, tipoDeCambio);
                        break;
                    case 4:
                        System.out.println("1) Dolar - (USD)");
                        System.out.println("2) Sol Peruano - (PEN)");
                        System.out.println("3) Real Brasileño - (BRL)");
                        System.out.println("4) Peso Argentino - (ARS)");
                        tipoDeCambio = userInput.nextInt();
                        abreviaturaTipoDeCambio = filtrarDivisa.filtrarMoneda(monedaBase, tipoDeCambio);
                        break;
                    case 5:
                        System.out.println("1) Dolar - (USD)");
                        System.out.println("2) Sol Peruano - (PEN)");
                        System.out.println("3) Real Brasileño - (BRL)");
                        System.out.println("4) Peso Colombiano - (COP)");
                        tipoDeCambio = userInput.nextInt();
                        abreviaturaTipoDeCambio = filtrarDivisa.filtrarMoneda(monedaBase, tipoDeCambio);
                        break;
                }

                GenerarURL url = new GenerarURL(abreviaturaMonedaBase, abreviaturaTipoDeCambio, montoAConvertir);
                APIConnection apiConnection = new APIConnection(url.getUrl());
                ConversionDivisaExAPI divisaData = apiConnection.getData();

                System.out.println("""
                        *******************
                        El monto de %.2f %s
                        equivalen a %.2f %s
                        *******************
                        """.formatted(montoAConvertir, divisaData.base_code(),
                        divisaData.conversion_result(), divisaData.target_code()));

            } catch(InputMismatchException e) {
                System.out.println("Porfavor limitece a escoger solo las opciones permitidas.");
                userInput.next();
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Seleccione correctamente una de las opciones.");
            }

        }

        System.out.println("Salida Exitosa!");
    }
}

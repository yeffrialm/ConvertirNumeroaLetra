package com.company;/*
 * Programa que convierte un numero a su homologo en letra
 * Hecho por Yeffri Javier Almengot
 * Fecha: 13-10-15
 */
//probar si se puede usar la programacion funcional(lambdas) en el codigo
//probar usar interface para definir las funciones
//agregar booleano con condicional if para reducir los procesos y hacer mas leible el codigo
//ejemplo si es unidad o si es decena o si es centena o si es caracter especial

import java.util.Scanner;

public class NumeroaLetra {

    Scanner scanner = new Scanner(System.in);

    public int num = 0;
    public int Unidad = 0;
    public int Decena = 0;

    String unidades[]
            = {"cero", "uno", "dos", "tres", "cuatro", "cinco",
                "seis", "siete", "ocho", "nueve"};
    String especiales[]
            = {"diez", "once", "doce", "trece", "catorce", "quince",
                "diezciseis", "diecisiete", "dieciocho", "diecinueve"};
    String decenas[]
            = {"veinte", "treinta", "cuarenta", "cincuenta", "sesenta",
                "setenta", "ochenta", "noventa"};

    String centenas[]
            = {"ciento", "dosciento", "trescientos", "cuatrocientos", "quinientos", "seiscientos",
                "setecientos", "ochocientos", "novecientos"};


	String millares[]
            = {"Mil", "Dos Mil", "Tres Mil", "Cuatro Mil", "Cinco Mil", "Seis Mil",
                "Siete Mil", "Ocho Mil", "Mueve Mil"};

    public static void presentacionInicio() {

        System.out.println("======================================================");
        System.out.println("  =================JAVA BASICO=======================");
        System.out.println("======================================================");
        System.out.println("");

    }

    public void EntradaDatos() {

        System.out.println("----------------------------------------");
        System.out.print("Ingrese un numero entre 0-100,000: ");

        num = scanner.nextInt();

    }

    public void MostrarEnLetra() {

        /*
         * -Decenatrescifras: en numeros con 3 cifras calcula las decenas.
         *    en numeros de 3 cifras calcula las decenas cuando estas son mayor o igual a 10 y menor o igual a 19.
         *    en numeros de 3 cifras calcula las decenas y unidades cuando estas son iguales a 0.
         * -Unidad:  en numeros de 3 cifras calcula las unidades.
         *    en numeros de 3 cifras calcula las unidades dentro de las decenas cuando estas son igual a 0 y viceversa.
         * -Decenaunidad: en numeros de 3 cifras, calcula las unidades dentro de las decenas con un valor 0
         y las decenas tengan un valor mayor o igual a 10.
         */
        int Centena = num / 100;
        int Decenatrescifras = (num % 100) / 10;
        int Decena = (num % 100) % 10;
        int Dencenaunidad = num % 100;

        System.out.println("----------------------------------------");

        // [elemento - numero]: determina la posicion correspondiente entre el arreglo y el numero digitado
        if (num >= 0 && num <= 9) {
            System.out.println(unidades[num]);
        } else if (num > 9 && num < 20) {
            System.out.println(especiales[num - 10]);
        } else if (num < 100) {
            Unidad = num % 10; //valor de la unidad en numeros de dos cifras
            Decena = num / 10;  //valor de la decena en numeros de dos cifras
            if (Unidad == 0) {
                System.out.println(decenas[Decena - 2]);
            } else {
                System.out.println(decenas[Decena - 2] + " y " + unidades[Unidad]);
            }
        } else if (num == 100) {
            System.out.println("cien");
        } else if (num > 100 && num < 1000) {

            if (Centena > 0 && Decenatrescifras == 1 && Dencenaunidad > 9) {

                System.out.println(centenas[Centena - 1] + " " + especiales[Dencenaunidad - 10]);

            } else if (Centena != 0 && Decenatrescifras != 0 && Decena != 0) {

                System.out.println(centenas[Centena - 1] + " " + decenas[Decenatrescifras - 2]
                        + " y " + unidades[Decena]);

            } else if (Decenatrescifras == 0 && Dencenaunidad != 0) {
                System.out.println(centenas[Centena - 1] + " " + unidades[Dencenaunidad]);
            } else if (Decenatrescifras > 0 && Decena == 0) {
                System.out.println(centenas[Centena - 1] + " " + decenas[Decenatrescifras - 2]);
            } else {
                System.out.println(centenas[Centena - 1]);
            }
        } else if (num == 1000) {
            System.out.println("Mil");
        } else {
            System.out.print("El numero debe ser menor o igual a 100,000");

        }
        System.out.println("----------------------------------------");
    }

}

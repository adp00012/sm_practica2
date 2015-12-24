package com.adelgado_cmaier.practica1;


/**
 * Clase que contiene una excepcion realizada para la comprobación de la cantidad
 * de digitos del número de bastidor.
 * @author Antonio Delgado Pamos
 * @author Cristian Maier
 */
public class ExcepcionBastidor extends RuntimeException {
    
    /**
     * Constructor por defecto. No recibe argumentos.
     */
    public ExcepcionBastidor(){
        this("ERROR. ");
    }
    
   
    /**
     * Constructor que recoje el mensaje del constructor anterior. Concatena el
     * mensaje anterior, añadiendo "Numero de bastidor no valido". Con esta forma,
     * usando el constructor por defecto conseguimos que nos devuelva el mensaje
     * completo. Lo hacemos de esta forma porque este tipo de expceciones,
     * obliga a la creación de un constructor por defecto y otro con parametro.
     * @param str Mensaje de la cadena del constructor por defecto.
     */
    public ExcepcionBastidor(String str){
        super(str+" Número de bástidor no válido!!");
    }
}

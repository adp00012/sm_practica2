package com.adelgado_cmaier.practica1;



import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Clase que almacena los datos que se enviarán a través del protocolo.
 * @author Antonio Delgado Pamos
 * @author Cristian Maier
 */
public class Coche {
    //Atributos
    protected String num_bastidor;
    protected String matricula;
    protected String propietario;
    protected String marca;
    protected String modelo;
    protected String combustible;
    protected String motorizacion;
    protected String direccion_ip;
    protected String puerto;
    
    /**
     * Método constructor que crea un objeto Coche
     * @param nb Número de bastidor. Comprueba que este numero es de 17 digitos.
     * @param mat Matrícula
     * @param pro Propietario del Vehiculo
     * @param mar Marca
     * @param mod Modelo
     * @param comb Combustible
     * @param mot Motorización (Opcional, incluir cc y cv)
     * @throws ExcepcionBastidor Excepcion que comprueba si el num_bastidor contiene 17 digitos.
     */
    public Coche(String nb, String mat, String pro, String mar, String mod, String comb, String mot, String IP, String puerto) throws ExcepcionBastidor{
       /*Con "lenght" estamos contando cuantos caracteres tiene nuestra cadena, lo que equivale al numero de digitos de nuestro
       número de bastidor
       */
       int digitos_bast=nb.length();
       //Comprobamos que tiene 17 digitos, si tiene un numero distinto de digitos, salta la excepcion, Si tiene 17, construye
       //el objeto indicado.
       try{
           if(digitos_bast!=17){
                throw new ExcepcionBastidor();
           }else{
                num_bastidor=nb;
                matricula=mat;
                propietario=pro;
                marca=mar;
                modelo=mod;
                combustible=comb;
                motorizacion=mot;
                direccion_ip=IP;
                this.puerto=puerto;
           }
       }catch(ExcepcionBastidor e){
           System.out.println(e.getMessage());
       } 
    }
    
 
    /**
     * Método constructor que permite introducir los atributos del objeto a través del teclado.
     * @param teclado Se le pasa un DataInputStream que hace de "lector" del teclado.
     */
    public Coche(DataInputStream teclado){
        //Este bloque try/catch es para el metodo DataInputStream
        try{
            //Este bloque try/catch es para la comprobacion de los digitos del bastidor
            try{
                this.num_bastidor=teclado.readUTF();
                if(this.num_bastidor.length()!=17){
                    throw new ExcepcionBastidor();
                }else{
                    this.matricula=teclado.readUTF();
                    this.propietario=teclado.readUTF();
                    this.marca=teclado.readUTF();
                    this.modelo=teclado.readUTF();
                    this.combustible=teclado.readUTF();
                    this.motorizacion=teclado.readUTF();
                }
            }catch(ExcepcionBastidor e){
                System.out.println(e.getMessage());
            }    
        }catch(IOException e){
            this.num_bastidor="";
            this.matricula="";
            this.propietario="";
            this.marca="";
            this.modelo="";
            this.combustible="";
            this.motorizacion="";
            e.printStackTrace();
        }
    }
    
    
    /**
     * Método que introduce los atributos del coche en un array de bytes.
     * @param d DataOutputStream necesario para escribir en el array
     */
    public void toByteArray (DataOutputStream d){
        try{
            d.writeUTF(num_bastidor);
            d.writeUTF(matricula);
            d.writeUTF(propietario);
            d.writeUTF(marca);
            d.writeUTF(modelo);
            d.writeUTF(combustible);
            d.writeUTF(motorizacion);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
    /**
     * Método GET
     * @return Devuelve el número del bastidor
     */
    public String getNum_bastidor() {
        return num_bastidor;
    }

     /**
     * Método GET
     * @return Devuelve la matrícula del coche
     */
    public String getMatricula() {
        return matricula;
    }

     /**
     * Método GET
     * @return Devuelve el nombre del propietario del vehiculo
     */
    public String getPropietario() {
        return propietario;
    }
    
    /**
     * Método GET
     * @return Devuelve la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método GET
     * @return Devuelve el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Método GET
     * @return Devuelve el tipo de combustible que usa el vehiculo
     */
    public String getCombustible() {
        return combustible;
    }
    
    /**
     * Método GET
     * @return Devuelve el motor que lleva el vehiculo
     */
    public String getMotorizacion() {
        return motorizacion;
    }
    
    
    public String getIP(){
    	return this.direccion_ip;
    }
    
    public String getPuerto(){
    	return this.puerto;
    }
    
    
    
    /**
     * Método SET que modifica el numero de bastidor
     * @param num_bastidor Numero de Bastidor nuevo
     */
    public void setNum_bastidor(String num_bastidor) {
        this.num_bastidor = num_bastidor;
    }
    
    /**
     * Método SET que modifica la matricula del vehiculo
     * @param matricula Numero de matricula nueva
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método SET que modifica el propietario del vehiculo
     * @param propietario Nombre de nuevo propietario
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * Método SET que modifica la marca del vehiculo
     * @param marca nueva marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método SET que modifica el modelo del vehiculo
     * @param modelo nuevo modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Método SET que modifica el tipo combustible del vehiculo
     * @param combustible nuevo tipo combustible para el vehiculo
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
    
    /**
     * Método SET que modifica el motor que lleva el vehiculo
     * @param motorizacion nuevo motor para el vehiculo
     */
    public void setMotorizacion(String motorizacion) {
        this.motorizacion = motorizacion;
    }
    
   
    /**
     * Método que convierte todos los atributos de la clase a una cadena de caracteres
     * @return Devuelve la cadena de caracteres con todos los atributos
     */
    public String toString(){
        return num_bastidor+" "+matricula+" "+propietario+" "+marca+" "+modelo+" "+combustible+" "+motorizacion;
    }
    
    
}

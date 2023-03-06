package com.mercadolibre.demo.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuperHeroe {
    @NonNull
    private int id;
    private String nombre;
    private String descripcion;
    private boolean capa;


    /*
    public SuperHeroe(String nombre) {
        //para instanciar un objeto con estos valores
        this.nombre = nombre;
        this.descripcion = "";
        this.capa = false;
    }
*/
/*
    public String toString() {
        String capaResponse;
        if (this.capa){
            capaResponse = "uso capa";
        } else {
            capaResponse = "no uso capa";
        }
        return  "Mi nombre de SuperHeroe es " +  this.nombre + "," + this.descripcion + "," + capaResponse ;
    }
*/
}

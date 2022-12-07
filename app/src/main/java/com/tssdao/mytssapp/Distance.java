package com.tssdao.mytssapp;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distance{
    private LatLng myPosition;
    private LatLng selectDestiny;
    AgenciesInformationActivity agen = new AgenciesInformationActivity();
    public Distance(LatLng myPosition, LatLng selectDestiny){
        this.myPosition = myPosition;
        this.selectDestiny = selectDestiny;
    }

    public List<Double> listDistance(){
        List<Double> distancias = new ArrayList<>();
        //Usuario
        double LatUsuario = myPosition.latitude;
        double LngUsuario = myPosition.longitude;

        /**for(int i=0; i<agen.agencies.size(); i++){
         double latAgencie = agen.agencies.get(i).latitude;
         double lngAgencie = agen.agencies.get(i).longitude;
         double dist = calDistance(LatUsuario,LngUsuario,latAgencie,lngAgencie);
         distancias.add(dist);
         System.out.println("distancias "+dist);
         }**/

        //agencia1
        double Latagencia1 = -17.399504;
        double Lngagencia1 = -66.157771;
        double dist = calDistance(LatUsuario,LngUsuario,Latagencia1,Lngagencia1);
        distancias.add(dist);
        //agencia2
        double Latagencia2 = -17.386864;
        double Lngagencia2 = -66.162262;
        double dist2 = calDistance(LatUsuario,LngUsuario,Latagencia2,Lngagencia2);
        distancias.add(dist2);
        //agencia3
        double Latagencia3 = -17.397961;
        double Lngagencia3 = -66.168682;
        double dist3 = calDistance(LatUsuario,LngUsuario,Latagencia3,Lngagencia3);
        distancias.add(dist3);
        //agencia4
        double Latagencia4 = -17.383069;
        double Lngagencia4 = -66.164982;
        double dist4 = calDistance(LatUsuario,LngUsuario,Latagencia4,Lngagencia4);
        distancias.add(dist4);

        return distancias;
    }

    //Metodo para calcular distancia entre dos puntos
    private Double calDistance(double latUbication, double lngUbication, double latAgencies,double lngAgencies){

        double radioTierraKm = 6371.0; //Radio de la tierra
        //Latitud agencia
        double lat1rad = Math.toRadians(latUbication);
        //Latitud Ubicacion actual
        double lon1rad = Math.toRadians(lngUbication);
        //Longitud agencia
        double lat2rad = Math.toRadians(latAgencies);
        //Longitud Ubicacion actual
        double lon2rad = Math.toRadians(lngAgencies);

        double difLatitud = lat1rad-lat2rad;
        double difLongitud = lon1rad-lon2rad;

        double a = Math.pow(Math.sin(difLatitud/2),2)+Math.cos(lat1rad)*Math.cos(lat2rad)*Math.pow(Math.sin(difLongitud/2),2);

        //Distancia en km desde la agencia hasta la ubicacion actual
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double distancia = formatearDecimales(radioTierraKm*c);

        return distancia;
    }

    public double distanciaMenor(){
        return distanciaMenor(listDistance());
    }

    private double distanciaMenor(List<Double> list){
        return Collections.min(list);
    }

    //Metodo para mostrar con 4 decimales
    private Double formatearDecimales(Double distancia){
        Integer numDecimales = 2;
        return Math.round(distancia*Math.pow(10,numDecimales))/Math.pow(10,numDecimales);
    }

    public double calDistanceUserAndSelectDestiny(){
        //Ubicacion actual del usuario
        double LatUsuario = myPosition.latitude;
        double LngUsuario = myPosition.longitude;

        //Ubicacion seleccionado por usuario o destino a llegar)
        double Latagencia4 = selectDestiny.latitude;
        double Lngagencia4 = selectDestiny.longitude;
        double dist = calDistance(LatUsuario,LngUsuario,Latagencia4,Lngagencia4);

        return dist;
    }

    public LatLng getMyPosition() {
        return myPosition;
    }

    public void setMyPosition(LatLng myPosition) {
        this.myPosition = myPosition;
    }
}

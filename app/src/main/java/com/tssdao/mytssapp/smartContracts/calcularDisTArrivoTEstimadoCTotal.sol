pragma solidity ^0.8.0;

contract calcularDistancia_TiempoArrivo_TiempoEstimadoDesitno_CostoTotal {

    int public price = 2;  // poner el precio por defecto
    int public cantAutos= 0;
    // int public tipoCambioBolEther= 0.00012;
    int public distanciaKmDestino= 0;
    int public distanciaKmAgencia= 0;
    int public tiempoAproxTardanzaXkm= 2;
    int public costoTotal= 0;

    constructor(int priceAct, int distanciaKmDestinoAct, int cantAutosAct, int costoTotalAct, int distanciaKmAgenciaAct){
        price = priceAct;
        distanciaKmDestino = distanciaKmDestinoAct;
        cantAutos = cantAutosAct;
        costoTotal = costoTotalAct;
        tiempoAproxTardanzaXkm = 2;
        distanciaKmAgencia = distanciaKmAgenciaAct;
    }

    /// Getters
    function getCantAutos() public view returns (int ) {
        return cantAutos;
    }

    function getPrice() public view returns (int ) {
        return price;
    }

    /* function getTipoCambioBolAEther() public view returns (int ) {
         return tipoCambioBolEther;
     }*/

    function getDintanciaDestinoKm() public view returns (int ) {
        return distanciaKmDestino;
    }

    function getCostoTotal() public view returns (int ) {
        return costoTotal;
    }
    function getDintanciaAgenciaKm() public view returns (int ) {
        return distanciaKmAgencia;
    }


    //Setters
    function setPrice(int newPrice) public{
        price = newPrice;
    }

    function setCantAutos(int newCantAutos) public{
        cantAutos = newCantAutos;
    }

    /*function setTipoCambioBolEther(int newTipoCambioBolEther) public{
        tipoCambioBolEther = newTipoCambioBolEther;
    }*/

    function setDistanciaDestinoKm(int  newDistanciaKmDestino) public{
        distanciaKmDestino = newDistanciaKmDestino;
    }
    function setDistanciaKmAgencia(int newDistanciaKmAgencia) public{
        distanciaKmAgencia = newDistanciaKmAgencia;
    }

    // Funciones de calculo
    function calcaularCostoTotal() public returns (int)  {  //Calcula Costo Total
        costoTotal = price * distanciaKmDestino *cantAutos;
        return costoTotal;
    }

    /*function calcularTipodeCambio() public view returns (int) { //Calcula el tipo de cambio del Costo Total, Ether a Bol
        return costoTotal*tipoCambioBolEther;
    }*/

    function calcularTiempoArribo() public view returns (int) { // Calcula el tiempo de arribo
        return distanciaKmAgencia*tiempoAproxTardanzaXkm;
    }

    function calcularTiempoEstimadoADestino() public view returns (int) { // Calcula el tiempo de estimado de llegada hacia destino
        return distanciaKmDestino*tiempoAproxTardanzaXkm;
    }

}

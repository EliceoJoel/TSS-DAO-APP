pragma solidity ^0.8.0;

contract calcularSalidaVehiculosAgencias {
    int distanciaEntreUsuarioyDestino = 0;
    int distanciaEntreUsuarioyAgencia1 = 0;
    int distanciaEntreUsuarioyAgencia2 = 0;
    int distanciaEntreUsuarioyAgencia3 = 0;
    int distanciaEntreUsuarioyAgencia4 = 0;
    int acenciaMasCerca = 0;

    constructor(int  distanciaEntreUsuarioyDestinoAct, int distanciaEntreUsuarioyAgencia1Act, int distanciaEntreUsuarioyAgencia2Act, int distanciaEntreUsuarioyAgencia3Act, int distanciaEntreUsuarioyAgencia4Act, int acenciaMasCercaAct){
        distanciaEntreUsuarioyDestino = distanciaEntreUsuarioyDestinoAct;
        distanciaEntreUsuarioyAgencia1 = distanciaEntreUsuarioyAgencia1Act;
        distanciaEntreUsuarioyAgencia2 = distanciaEntreUsuarioyAgencia2Act;
        distanciaEntreUsuarioyAgencia3 = distanciaEntreUsuarioyAgencia3Act;
        distanciaEntreUsuarioyAgencia4 = distanciaEntreUsuarioyAgencia4Act;
        acenciaMasCerca = acenciaMasCercaAct;
    }

    //Getters
    function getDistanciaEntreUsuarioyDestino() public view returns (int) {
        return distanciaEntreUsuarioyDestino;
    }

    function getDistanciaEntreUsuarioyAgencia1() public view returns (int) {
        return distanciaEntreUsuarioyAgencia1;
    }

    function getDistanciaEntreUsuarioyAgencia2() public view returns (int) {
        return distanciaEntreUsuarioyAgencia2;
    }

    function getDistanciaEntreUsuarioyAgencia3() public view returns (int) {
        return distanciaEntreUsuarioyAgencia3;
    }
    function getDistanciaEntreUsuarioyAgencia4() public view returns (int) {
        return distanciaEntreUsuarioyAgencia3;
    }

    function getAcenciaMasCerca() public view returns (int) {
        return acenciaMasCerca;
    }


    //Setters
    function setDistanciaEntreUsuarioyDestino(int newDist) public{
        distanciaEntreUsuarioyDestino = newDist;
    }

    function setDistanciaEntreUsuarioyAgencia1(int newDist) public{
        distanciaEntreUsuarioyAgencia1 = newDist;
    }

    function setDistanciaEntreUsuarioyAgencia2(int newDist) public{
        distanciaEntreUsuarioyAgencia2 = newDist;
    }

    function setDistanciaEntreUsuarioyAgencia3(int newDist) public{
        distanciaEntreUsuarioyAgencia3 = newDist;
    }

    function setDistanciaEntreUsuarioyAgencia4(int newDist) public{
        distanciaEntreUsuarioyAgencia4 = newDist;
    }

    function setAcenciaMasCerca(int agenciaCerca) public{
        acenciaMasCerca = agenciaCerca;
    }

    //Funciones

    function calcularAgenciaMasCercaAUsuario () public{
        if(distanciaEntreUsuarioyAgencia1 <= distanciaEntreUsuarioyDestino && distanciaEntreUsuarioyAgencia1<distanciaEntreUsuarioyAgencia2 && distanciaEntreUsuarioyAgencia1<distanciaEntreUsuarioyAgencia3 && distanciaEntreUsuarioyAgencia1<distanciaEntreUsuarioyAgencia4){
            setAcenciaMasCerca(1);
        }else if(distanciaEntreUsuarioyAgencia2 <= distanciaEntreUsuarioyDestino && distanciaEntreUsuarioyAgencia2<distanciaEntreUsuarioyAgencia1 && distanciaEntreUsuarioyAgencia2<distanciaEntreUsuarioyAgencia3 && distanciaEntreUsuarioyAgencia2<distanciaEntreUsuarioyAgencia4){
            setAcenciaMasCerca(2);
        }else if(distanciaEntreUsuarioyAgencia3 <= distanciaEntreUsuarioyDestino && distanciaEntreUsuarioyAgencia3<distanciaEntreUsuarioyAgencia1 && distanciaEntreUsuarioyAgencia2<distanciaEntreUsuarioyAgencia2 && distanciaEntreUsuarioyAgencia3<distanciaEntreUsuarioyAgencia4){
            setAcenciaMasCerca(3);
        }else{
            setAcenciaMasCerca(4);
        }

    }
}

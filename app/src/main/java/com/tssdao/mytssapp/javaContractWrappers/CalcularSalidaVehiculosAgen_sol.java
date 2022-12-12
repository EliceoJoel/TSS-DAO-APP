package javaContractWrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class CalcularSalidaVehiculosAgen_sol extends Contract {
    private static final String BINARY = "6080604052600080556000600155600060025560006003556000600455600060055534801561002d57600080fd5b5060405161036d38038061036d83398101604081905261004c9161006c565b6000959095556001939093556002919091556003556004556005556100b6565b60008060008060008060c0878903121561008557600080fd5b865195506020870151945060408701519350606087015192506080870151915060a087015190509295509295509295565b6102a8806100c56000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c806399526d9a1161008c578063cd1c5c7211610066578063cd1c5c7214610145578063d59f3bc314610158578063e55887d614610160578063eccca6091461017357600080fd5b806399526d9a146100e9578063a5095a701461012a578063b6d631db1461013d57600080fd5b806302baf390146100d45780631ebbac37146100e957806341aab5af146100ff578063690c338d146101075780636c1b625c1461011a578063955dacce14610122575b600080fd5b6100e76100e2366004610259565b600555565b005b6003545b60405190815260200160405180910390f35b6005546100ed565b6100e7610115366004610259565b600155565b6002546100ed565b6100e7610186565b6100e7610138366004610259565b600455565b6001546100ed565b6100e7610153366004610259565b600355565b6000546100ed565b6100e761016e366004610259565b600055565b6100e7610181366004610259565b600255565b6000546001541315801561019d5750600254600154125b80156101ac5750600354600154125b80156101bb5750600454600154125b156101cc576101ca6001600555565b565b600054600254131580156101e35750600154600254125b80156101f25750600354600254125b80156102015750600454600254125b15610210576101ca6002600555565b600054600354131580156102275750600154600354125b8015610231575060005b80156102405750600454600354125b1561024f576101ca6003600555565b6101ca6004600555565b60006020828403121561026b57600080fd5b503591905056fea2646970667358221220e4273d256fa676ec680b43e263f437f85c15506b494f352377b7636814652e9064736f6c63430008110033";

    public static final String FUNC_CALCULARAGENCIAMASCERCAAUSUARIO = "calcularAgenciaMasCercaAUsuario";

    public static final String FUNC_GETACENCIAMASCERCA = "getAcenciaMasCerca";

    public static final String FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA1 = "getDistanciaEntreUsuarioyAgencia1";

    public static final String FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA2 = "getDistanciaEntreUsuarioyAgencia2";

    public static final String FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA3 = "getDistanciaEntreUsuarioyAgencia3";

    public static final String FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA4 = "getDistanciaEntreUsuarioyAgencia4";

    public static final String FUNC_GETDISTANCIAENTREUSUARIOYDESTINO = "getDistanciaEntreUsuarioyDestino";

    public static final String FUNC_SETACENCIAMASCERCA = "setAcenciaMasCerca";

    public static final String FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA1 = "setDistanciaEntreUsuarioyAgencia1";

    public static final String FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA2 = "setDistanciaEntreUsuarioyAgencia2";

    public static final String FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA3 = "setDistanciaEntreUsuarioyAgencia3";

    public static final String FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA4 = "setDistanciaEntreUsuarioyAgencia4";

    public static final String FUNC_SETDISTANCIAENTREUSUARIOYDESTINO = "setDistanciaEntreUsuarioyDestino";

    @Deprecated
    protected CalcularSalidaVehiculosAgen_sol(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CalcularSalidaVehiculosAgen_sol(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CalcularSalidaVehiculosAgen_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CalcularSalidaVehiculosAgen_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> calcularAgenciaMasCercaAUsuario() {
        final Function function = new Function(
                FUNC_CALCULARAGENCIAMASCERCAAUSUARIO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getAcenciaMasCerca() {
        final Function function = new Function(
                FUNC_GETACENCIAMASCERCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDistanciaEntreUsuarioyAgencia1() {
        final Function function = new Function(
                FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA1, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDistanciaEntreUsuarioyAgencia2() {
        final Function function = new Function(
                FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA2, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDistanciaEntreUsuarioyAgencia3() {
        final Function function = new Function(
                FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA3, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDistanciaEntreUsuarioyAgencia4() {
        final Function function = new Function(
                FUNC_GETDISTANCIAENTREUSUARIOYAGENCIA4, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDistanciaEntreUsuarioyDestino() {
        final Function function = new Function(
                FUNC_GETDISTANCIAENTREUSUARIOYDESTINO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setAcenciaMasCerca(BigInteger agenciaCerca) {
        final Function function = new Function(
                FUNC_SETACENCIAMASCERCA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(agenciaCerca)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaEntreUsuarioyAgencia1(BigInteger newDist) {
        final Function function = new Function(
                FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA1, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDist)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaEntreUsuarioyAgencia2(BigInteger newDist) {
        final Function function = new Function(
                FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA2, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDist)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaEntreUsuarioyAgencia3(BigInteger newDist) {
        final Function function = new Function(
                FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA3, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDist)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaEntreUsuarioyAgencia4(BigInteger newDist) {
        final Function function = new Function(
                FUNC_SETDISTANCIAENTREUSUARIOYAGENCIA4, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDist)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaEntreUsuarioyDestino(BigInteger newDist) {
        final Function function = new Function(
                FUNC_SETDISTANCIAENTREUSUARIOYDESTINO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDist)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static javaContractWrappers.CalcularSalidaVehiculosAgen_sol load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularSalidaVehiculosAgen_sol(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static javaContractWrappers.CalcularSalidaVehiculosAgen_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularSalidaVehiculosAgen_sol(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static javaContractWrappers.CalcularSalidaVehiculosAgen_sol load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularSalidaVehiculosAgen_sol(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static javaContractWrappers.CalcularSalidaVehiculosAgen_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularSalidaVehiculosAgen_sol(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<javaContractWrappers.CalcularSalidaVehiculosAgen_sol> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger distanciaEntreUsuarioyDestinoAct, BigInteger distanciaEntreUsuarioyAgencia1Act, BigInteger distanciaEntreUsuarioyAgencia2Act, BigInteger distanciaEntreUsuarioyAgencia3Act, BigInteger distanciaEntreUsuarioyAgencia4Act, BigInteger acenciaMasCercaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia1Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia2Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia3Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia4Act), 
                new org.web3j.abi.datatypes.generated.Int256(acenciaMasCercaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularSalidaVehiculosAgen_sol.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<javaContractWrappers.CalcularSalidaVehiculosAgen_sol> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger distanciaEntreUsuarioyDestinoAct, BigInteger distanciaEntreUsuarioyAgencia1Act, BigInteger distanciaEntreUsuarioyAgencia2Act, BigInteger distanciaEntreUsuarioyAgencia3Act, BigInteger distanciaEntreUsuarioyAgencia4Act, BigInteger acenciaMasCercaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia1Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia2Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia3Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia4Act), 
                new org.web3j.abi.datatypes.generated.Int256(acenciaMasCercaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularSalidaVehiculosAgen_sol.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularSalidaVehiculosAgen_sol> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger distanciaEntreUsuarioyDestinoAct, BigInteger distanciaEntreUsuarioyAgencia1Act, BigInteger distanciaEntreUsuarioyAgencia2Act, BigInteger distanciaEntreUsuarioyAgencia3Act, BigInteger distanciaEntreUsuarioyAgencia4Act, BigInteger acenciaMasCercaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia1Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia2Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia3Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia4Act), 
                new org.web3j.abi.datatypes.generated.Int256(acenciaMasCercaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularSalidaVehiculosAgen_sol.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularSalidaVehiculosAgen_sol> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger distanciaEntreUsuarioyDestinoAct, BigInteger distanciaEntreUsuarioyAgencia1Act, BigInteger distanciaEntreUsuarioyAgencia2Act, BigInteger distanciaEntreUsuarioyAgencia3Act, BigInteger distanciaEntreUsuarioyAgencia4Act, BigInteger acenciaMasCercaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia1Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia2Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia3Act), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaEntreUsuarioyAgencia4Act), 
                new org.web3j.abi.datatypes.generated.Int256(acenciaMasCercaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularSalidaVehiculosAgen_sol.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}

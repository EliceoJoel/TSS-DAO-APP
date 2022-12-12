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
public class CalcularDisTArrivoTEstimadoCTotal_sol extends Contract {
    private static final String BINARY = "608060405260026000556000600155600060025560006003556002600455600060055534801561002e57600080fd5b5060405161039538038061039583398101604081905261004d9161006c565b60009490945560029283556001919091556005556004556003556100ac565b600080600080600060a0868803121561008457600080fd5b5050835160208501516040860151606087015160809097015192989197509594509092509050565b6102da806100bb6000396000f3fe608060405234801561001057600080fd5b50600436106101165760003560e01c806398d5fdca116100a2578063d068babb11610071578063d068babb146101a3578063d6ae232f146101b6578063e1db14b4146101c9578063f7a30806146101d2578063fa0505ed146101e557600080fd5b806398d5fdca14610182578063a035b1fe1461018a578063a6f0fa9314610193578063c05d9daa1461019b57600080fd5b80635b3f3fcd116100e95780635b3f3fcd1461014b5780636922bd20146101545780636e9e3e261461015d5780638d0745ed146101725780638e469b841461017a57600080fd5b8063266528971461011b5780633f73488e14610131578063428062de1461013a57806357819c9d14610142575b600080fd5b6002545b60405190815260200160405180910390f35b61011f60055481565b61011f6101ed565b61011f60045481565b61011f60035481565b61011f60015481565b61017061016b36600461023f565b600255565b005b60015461011f565b60055461011f565b60005461011f565b61011f60005481565b61011f610204565b61011f61022d565b6101706101b136600461023f565b600155565b6101706101c436600461023f565b600355565b61011f60025481565b6101706101e036600461023f565b600055565b60035461011f565b60006004546002546101ff919061026e565b905090565b6000600154600254600054610219919061026e565b610223919061026e565b6005819055919050565b60006004546003546101ff919061026e565b60006020828403121561025157600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b80820260008212600160ff1b8414161561028a5761028a610258565b818105831482151761029e5761029e610258565b9291505056fea2646970667358221220cd360af697ec7a2c079d13ae0df60b19e24ecf669be8ab324fe04ed06c3ae6eb64736f6c63430008110033";

    public static final String FUNC_CALCAULARCOSTOTOTAL = "calcaularCostoTotal";

    public static final String FUNC_CALCULARTIEMPOARRIBO = "calcularTiempoArribo";

    public static final String FUNC_CALCULARTIEMPOESTIMADOADESTINO = "calcularTiempoEstimadoADestino";

    public static final String FUNC_CANTAUTOS = "cantAutos";

    public static final String FUNC_COSTOTOTAL = "costoTotal";

    public static final String FUNC_DISTANCIAKMAGENCIA = "distanciaKmAgencia";

    public static final String FUNC_DISTANCIAKMDESTINO = "distanciaKmDestino";

    public static final String FUNC_GETCANTAUTOS = "getCantAutos";

    public static final String FUNC_GETCOSTOTOTAL = "getCostoTotal";

    public static final String FUNC_GETDINTANCIAAGENCIAKM = "getDintanciaAgenciaKm";

    public static final String FUNC_GETDINTANCIADESTINOKM = "getDintanciaDestinoKm";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_PRICE = "price";

    public static final String FUNC_SETCANTAUTOS = "setCantAutos";

    public static final String FUNC_SETDISTANCIADESTINOKM = "setDistanciaDestinoKm";

    public static final String FUNC_SETDISTANCIAKMAGENCIA = "setDistanciaKmAgencia";

    public static final String FUNC_SETPRICE = "setPrice";

    public static final String FUNC_TIEMPOAPROXTARDANZAXKM = "tiempoAproxTardanzaXkm";

    @Deprecated
    protected CalcularDisTArrivoTEstimadoCTotal_sol(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CalcularDisTArrivoTEstimadoCTotal_sol(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CalcularDisTArrivoTEstimadoCTotal_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CalcularDisTArrivoTEstimadoCTotal_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> calcaularCostoTotal() {
        final Function function = new Function(
                FUNC_CALCAULARCOSTOTOTAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> calcularTiempoArribo() {
        final Function function = new Function(
                FUNC_CALCULARTIEMPOARRIBO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> calcularTiempoEstimadoADestino() {
        final Function function = new Function(
                FUNC_CALCULARTIEMPOESTIMADOADESTINO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> cantAutos() {
        final Function function = new Function(
                FUNC_CANTAUTOS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> costoTotal() {
        final Function function = new Function(
                FUNC_COSTOTOTAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> distanciaKmAgencia() {
        final Function function = new Function(
                FUNC_DISTANCIAKMAGENCIA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> distanciaKmDestino() {
        final Function function = new Function(
                FUNC_DISTANCIAKMDESTINO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getCantAutos() {
        final Function function = new Function(
                FUNC_GETCANTAUTOS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getCostoTotal() {
        final Function function = new Function(
                FUNC_GETCOSTOTOTAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDintanciaAgenciaKm() {
        final Function function = new Function(
                FUNC_GETDINTANCIAAGENCIAKM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDintanciaDestinoKm() {
        final Function function = new Function(
                FUNC_GETDINTANCIADESTINOKM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getPrice() {
        final Function function = new Function(
                FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> price() {
        final Function function = new Function(
                FUNC_PRICE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setCantAutos(BigInteger newCantAutos) {
        final Function function = new Function(
                FUNC_SETCANTAUTOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newCantAutos)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaDestinoKm(BigInteger newDistanciaKmDestino) {
        final Function function = new Function(
                FUNC_SETDISTANCIADESTINOKM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDistanciaKmDestino)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDistanciaKmAgencia(BigInteger newDistanciaKmAgencia) {
        final Function function = new Function(
                FUNC_SETDISTANCIAKMAGENCIA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newDistanciaKmAgencia)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPrice(BigInteger newPrice) {
        final Function function = new Function(
                FUNC_SETPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> tiempoAproxTardanzaXkm() {
        final Function function = new Function(
                FUNC_TIEMPOAPROXTARDANZAXKM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger priceAct, BigInteger distanciaKmDestinoAct, BigInteger cantAutosAct, BigInteger costoTotalAct, BigInteger distanciaKmAgenciaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(priceAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(cantAutosAct), 
                new org.web3j.abi.datatypes.generated.Int256(costoTotalAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmAgenciaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger priceAct, BigInteger distanciaKmDestinoAct, BigInteger cantAutosAct, BigInteger costoTotalAct, BigInteger distanciaKmAgenciaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(priceAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(cantAutosAct), 
                new org.web3j.abi.datatypes.generated.Int256(costoTotalAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmAgenciaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger priceAct, BigInteger distanciaKmDestinoAct, BigInteger cantAutosAct, BigInteger costoTotalAct, BigInteger distanciaKmAgenciaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(priceAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(cantAutosAct), 
                new org.web3j.abi.datatypes.generated.Int256(costoTotalAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmAgenciaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger priceAct, BigInteger distanciaKmDestinoAct, BigInteger cantAutosAct, BigInteger costoTotalAct, BigInteger distanciaKmAgenciaAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(priceAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmDestinoAct), 
                new org.web3j.abi.datatypes.generated.Int256(cantAutosAct), 
                new org.web3j.abi.datatypes.generated.Int256(costoTotalAct), 
                new org.web3j.abi.datatypes.generated.Int256(distanciaKmAgenciaAct)));
        return deployRemoteCall(javaContractWrappers.CalcularDisTArrivoTEstimadoCTotal_sol.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}

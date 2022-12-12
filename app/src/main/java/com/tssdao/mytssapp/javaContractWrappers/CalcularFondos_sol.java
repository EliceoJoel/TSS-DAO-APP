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
public class CalcularFondos_sol extends Contract {
    private static final String BINARY = "6080604052600080556000600155600060025534801561001e57600080fd5b506040516101dd3803806101dd83398101604081905261003d9161004e565b60009290925560015560025561007c565b60008060006060848603121561006357600080fd5b8351925060208401519150604084015190509250925092565b6101528061008b6000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063d55828181161005b578063d5582818146100c8578063d652c44a146100c0578063dfe7dd36146100db578063fbf46081146100ee57600080fd5b80630ccaca751461008d57806360c73609146100a25780637e6e3660146100b85780638cc8edf1146100c0575b600080fd5b6100a061009b366004610103565b600255565b005b6000545b60405190815260200160405180910390f35b6002546100a6565b6100a06100f6565b6100a06100d6366004610103565b600155565b6100a06100e9366004610103565b600055565b6001546100a6565b610101600054600155565b565b60006020828403121561011557600080fd5b503591905056fea26469706673582212205c47a29be2595e018dd74bba97f1edd37e3f4eba70f5269eeee9dce4b8a213be64736f6c63430008110033";

    public static final String FUNC_CALCULARFONDOSGANANCIA = "calcularFondosGanancia";

    public static final String FUNC_CALCULARFONDOSREPARACION = "calcularFondosReparacion";

    public static final String FUNC_GETCOSTOCOBRADO = "getCostoCobrado";

    public static final String FUNC_GETFONDOSGANANCIA = "getFondosGanancia";

    public static final String FUNC_GETFONDOSREPARACION = "getfondosReparacion";

    public static final String FUNC_SETCOSTOCOBRADO = "setCostoCobrado";

    public static final String FUNC_SETFONDOSGANANCIA = "setFondosGanancia";

    public static final String FUNC_SETFONDOSREPARACION = "setFondosReparacion";

    @Deprecated
    protected CalcularFondos_sol(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CalcularFondos_sol(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CalcularFondos_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CalcularFondos_sol(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> calcularFondosGanancia() {
        final Function function = new Function(
                FUNC_CALCULARFONDOSGANANCIA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> calcularFondosReparacion() {
        final Function function = new Function(
                FUNC_CALCULARFONDOSREPARACION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getCostoCobrado() {
        final Function function = new Function(
                FUNC_GETCOSTOCOBRADO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getFondosGanancia() {
        final Function function = new Function(
                FUNC_GETFONDOSGANANCIA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getfondosReparacion() {
        final Function function = new Function(
                FUNC_GETFONDOSREPARACION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setCostoCobrado(BigInteger newVal) {
        final Function function = new Function(
                FUNC_SETCOSTOCOBRADO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newVal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setFondosGanancia(BigInteger newVal) {
        final Function function = new Function(
                FUNC_SETFONDOSGANANCIA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newVal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setFondosReparacion(BigInteger newVal) {
        final Function function = new Function(
                FUNC_SETFONDOSREPARACION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(newVal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static javaContractWrappers.CalcularFondos_sol load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularFondos_sol(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static javaContractWrappers.CalcularFondos_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new javaContractWrappers.CalcularFondos_sol(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static javaContractWrappers.CalcularFondos_sol load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularFondos_sol(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static javaContractWrappers.CalcularFondos_sol load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new javaContractWrappers.CalcularFondos_sol(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<javaContractWrappers.CalcularFondos_sol> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger costoCobradoAct, BigInteger fondosGananciaAct, BigInteger fondosReparacionAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(costoCobradoAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosGananciaAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosReparacionAct)));
        return deployRemoteCall(javaContractWrappers.CalcularFondos_sol.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<javaContractWrappers.CalcularFondos_sol> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger costoCobradoAct, BigInteger fondosGananciaAct, BigInteger fondosReparacionAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(costoCobradoAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosGananciaAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosReparacionAct)));
        return deployRemoteCall(javaContractWrappers.CalcularFondos_sol.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularFondos_sol> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger costoCobradoAct, BigInteger fondosGananciaAct, BigInteger fondosReparacionAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(costoCobradoAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosGananciaAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosReparacionAct)));
        return deployRemoteCall(javaContractWrappers.CalcularFondos_sol.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<javaContractWrappers.CalcularFondos_sol> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger costoCobradoAct, BigInteger fondosGananciaAct, BigInteger fondosReparacionAct) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(costoCobradoAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosGananciaAct), 
                new org.web3j.abi.datatypes.generated.Int256(fondosReparacionAct)));
        return deployRemoteCall(javaContractWrappers.CalcularFondos_sol.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}

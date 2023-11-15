package zerobibim.flory.domain.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.ens.EnsResolver;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class NFT extends Contract {
  public static final String BINARY = "Bin file was not provided";

  public static final String FUNC_CANNOT_TRANSFER_TO_ZERO_ADDRESS = "CANNOT_TRANSFER_TO_ZERO_ADDRESS";

  public static final String FUNC_NOT_CURRENT_OWNER = "NOT_CURRENT_OWNER";

  public static final String FUNC_APPROVE = "approve";

  public static final String FUNC_BALANCEOF = "balanceOf";

  public static final String FUNC_GETAPPROVED = "getApproved";

  public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

  public static final String FUNC_MINT = "mint";

  public static final String FUNC_NAME = "name";

  public static final String FUNC_OWNER = "owner";

  public static final String FUNC_OWNEROF = "ownerOf";

  public static final String FUNC_safeTransferFrom = "safeTransferFrom";

  public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

  public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

  public static final String FUNC_SYMBOL = "symbol";

  public static final String FUNC_TOKENURI = "tokenURI";

  public static final String FUNC_TRANSFERFROM = "transferFrom";

  public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

  public static final Event APPROVAL_EVENT = new Event("Approval",
      Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
  ;

  public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll",
      Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
  ;

  public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
      Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
  ;

  public static final Event TRANSFER_EVENT = new Event("Transfer",
      Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
  ;

  @Deprecated
  protected NFT(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
  }

  @Deprecated
  protected NFT(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }



  public static List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
    List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
    ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
    for (Contract.EventValuesWithLog eventValues : valueList) {
      ApprovalEventResponse typedResponse = new ApprovalEventResponse();
      typedResponse.log = eventValues.getLog();
      typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
      typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
      typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
      responses.add(typedResponse);
    }
    return responses;
  }

  public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
    Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
    ApprovalEventResponse typedResponse = new ApprovalEventResponse();
    typedResponse.log = log;
    typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
    typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
    typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
    return typedResponse;
  }



  public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
    return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
  }

  public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
    EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
    filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
    return approvalEventFlowable(filter);
  }

  public static List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
    List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
    ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
    for (Contract.EventValuesWithLog eventValues : valueList) {
      ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
      typedResponse.log = eventValues.getLog();
      typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
      typedResponse._operator = (String) eventValues.getIndexedValues().get(1).getValue();
      typedResponse._approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
      responses.add(typedResponse);
    }
    return responses;
  }

  public static ApprovalForAllEventResponse getApprovalForAllEventFromLog(Log log) {
    Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, log);
    ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
    typedResponse.log = log;
    typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
    typedResponse._operator = (String) eventValues.getIndexedValues().get(1).getValue();
    typedResponse._approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
    return typedResponse;
  }

  public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
    return web3j.ethLogFlowable(filter).map(log -> getApprovalForAllEventFromLog(log));
  }

  public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
    EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
    filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
    return approvalForAllEventFlowable(filter);
  }

  public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
    List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
    ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
    for (Contract.EventValuesWithLog eventValues : valueList) {
      OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
      typedResponse.log = eventValues.getLog();
      typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
      typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
      responses.add(typedResponse);
    }
    return responses;
  }

  public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
    Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
    OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
    typedResponse.log = log;
    typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
    typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
    return typedResponse;
  }

  public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
    return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
  }

  public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
    EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
    filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
    return ownershipTransferredEventFlowable(filter);
  }

  public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
    List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
    ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
    for (Contract.EventValuesWithLog eventValues : valueList) {
      TransferEventResponse typedResponse = new TransferEventResponse();
      typedResponse.log = eventValues.getLog();
      typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
      typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
      typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
      responses.add(typedResponse);
    }
    return responses;
  }

  public static TransferEventResponse getTransferEventFromLog(Log log) {
    Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
    TransferEventResponse typedResponse = new TransferEventResponse();
    typedResponse.log = log;
    typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
    typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
    typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
    return typedResponse;
  }

  public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
    return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
  }

  public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
    EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
    filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
    return transferEventFlowable(filter);
  }

  public RemoteFunctionCall<String> CANNOT_TRANSFER_TO_ZERO_ADDRESS() {
    final Function function = new Function(FUNC_CANNOT_TRANSFER_TO_ZERO_ADDRESS,
        Arrays.<Type>asList(),
        Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<String> NOT_CURRENT_OWNER() {
    final Function function = new Function(FUNC_NOT_CURRENT_OWNER,
        Arrays.<Type>asList(),
        Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<TransactionReceipt> approve(String _approved, BigInteger _tokenId) {
    final Function function = new Function(
        FUNC_APPROVE,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _approved),
            new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<BigInteger> balanceOf(String _owner) {
    final Function function = new Function(FUNC_BALANCEOF,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    return executeRemoteCallSingleValueReturn(function, BigInteger.class);
  }

  public RemoteFunctionCall<String> getApproved(BigInteger _tokenId) {
    final Function function = new Function(FUNC_GETAPPROVED,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<Boolean> isApprovedForAll(String _owner, String _operator) {
    final Function function = new Function(FUNC_ISAPPROVEDFORALL,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner),
            new org.web3j.abi.datatypes.Address(160, _operator)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    return executeRemoteCallSingleValueReturn(function, Boolean.class);
  }

  public RemoteFunctionCall<TransactionReceipt> mint(String _to, BigInteger _tokenId, String _uri) {
    final Function function = new Function(
        FUNC_MINT,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to),
            new org.web3j.abi.datatypes.generated.Uint256(_tokenId),
            new org.web3j.abi.datatypes.Utf8String(_uri)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<String> name() {
    final Function function = new Function(FUNC_NAME,
        Arrays.<Type>asList(),
        Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<String> owner() {
    final Function function = new Function(FUNC_OWNER,
        Arrays.<Type>asList(),
        Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<String> ownerOf(BigInteger _tokenId) {
    final Function function = new Function(FUNC_OWNEROF,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String _from, String _to, BigInteger _tokenId) {
    final Function function = new Function(
        FUNC_safeTransferFrom,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _from),
            new org.web3j.abi.datatypes.Address(160, _to),
            new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String _from, String _to, BigInteger _tokenId, byte[] _data) {
    final Function function = new Function(
        FUNC_safeTransferFrom,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _from),
            new org.web3j.abi.datatypes.Address(160, _to),
            new org.web3j.abi.datatypes.generated.Uint256(_tokenId),
            new org.web3j.abi.datatypes.DynamicBytes(_data)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String _operator, Boolean _approved) {
    final Function function = new Function(
        FUNC_SETAPPROVALFORALL,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _operator),
            new org.web3j.abi.datatypes.Bool(_approved)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<Boolean> supportsInterface(byte[] _interfaceID) {
    final Function function = new Function(FUNC_SUPPORTSINTERFACE,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(_interfaceID)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    return executeRemoteCallSingleValueReturn(function, Boolean.class);
  }

  public RemoteFunctionCall<String> symbol() {
    final Function function = new Function(FUNC_SYMBOL,
        Arrays.<Type>asList(),
        Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<String> tokenURI(BigInteger _tokenId) {
    final Function function = new Function(FUNC_TOKENURI,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    return executeRemoteCallSingleValueReturn(function, String.class);
  }

  public RemoteFunctionCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _tokenId) {
    final Function function = new Function(
        FUNC_TRANSFERFROM,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _from),
            new org.web3j.abi.datatypes.Address(160, _to),
            new org.web3j.abi.datatypes.generated.Uint256(_tokenId)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
    final Function function = new Function(
        FUNC_TRANSFEROWNERSHIP,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  @Deprecated
  public static NFT load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
    return new NFT(contractAddress, web3j, credentials, gasPrice, gasLimit);
  }
  @Deprecated
  public static NFT load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
    return new NFT(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }


  public static class ApprovalEventResponse extends BaseEventResponse {
    public String _owner;

    public String _approved;

    public BigInteger _tokenId;
  }

  public static class ApprovalForAllEventResponse extends BaseEventResponse {
    public String _owner;

    public String _operator;

    public Boolean _approved;
  }

  public static class OwnershipTransferredEventResponse extends BaseEventResponse {
    public String previousOwner;

    public String newOwner;
  }

  public static class TransferEventResponse extends BaseEventResponse {
    public String _from;

    public String _to;

    public BigInteger _tokenId;
  }
}
package zerobibim.flory.domain.contract.service;

import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import zerobibim.flory.domain.contract.NFT;
import zerobibim.flory.domain.contract.dto.NFTRequestDto;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service("web3jService")
public class Web3jService {

  private final NFT nft;

  public TransactionReceipt nftCreate(NFTRequestDto.MemberNFTInfo memberNFTInfo) throws Exception {

    return nft.create(memberNFTInfo.getWalletAddress(), memberNFTInfo.getIpfsUrl())
        .sendAsync()
        .get();
  }

}
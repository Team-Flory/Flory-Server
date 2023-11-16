package zerobibim.flory.domain.contract.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.*;
import zerobibim.flory.domain.contract.NFT;
import zerobibim.flory.domain.contract.dto.NFTRequestDto;


@Slf4j
@RequiredArgsConstructor
@Service
public class Web3jService {

  private final NFT nft;

  public TransactionReceipt nftCreate(NFTRequestDto.MemberNFTInfo memberNFTInfo) throws Exception {

    return nft.create(memberNFTInfo.getWalletAddress(), memberNFTInfo.getIpfsUrl())
        .sendAsync()
        .get();
  }

}
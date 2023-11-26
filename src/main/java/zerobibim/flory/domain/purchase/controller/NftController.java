package zerobibim.flory.domain.purchase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import zerobibim.flory.domain.purchase.dto.request.NFTRequestDto;
import zerobibim.flory.domain.purchase.service.Web3jService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nft")
public class NftController {
    private final Web3jService web3jService;
    // Define your API endpoints here
    @PostMapping("/mint")
    public TransactionReceipt mintToken() throws Exception {
        return web3jService.nftCreate(new NFTRequestDto.MemberNFTInfo("0x06f5ad6ca1fdbba1ac90b64472a36ca58a83b8af", "ipfs://QmVumYTYwP4F1DVLmaE527g7JDfB6Z1tzYFm8VE3zGPo1M"));
    }
}

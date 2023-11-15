package zerobibim.flory.domain.contract.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zerobibim.flory.domain.contract.NFT;
import zerobibim.flory.domain.contract.NFT.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/nft")
public class NftController {
  private final NFT nft;

  @Autowired
  public NftController(NFT nft) {
    this.nft = nft;
  }

  // Define your API endpoints here
  @PostMapping("/mint")
  public String mintToken(@RequestParam String to, @RequestParam BigInteger tokenId, @RequestParam String uri) {
    try {
      // Mint a new token
      return "Token minted successfully";
    } catch (Exception e) {
      // Handle exceptions appropriately (e.g., log the error)
      return "Error minting token: " + e.getMessage();
    }
  }
}

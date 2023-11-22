package zerobibim.flory.domain.purchase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NFTRequestDto {
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MemberNFTInfo {
      private String walletAddress;
      private String ipfsUrl;
  }

}

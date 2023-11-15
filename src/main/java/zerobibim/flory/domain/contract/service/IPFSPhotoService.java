package zerobibim.flory.domain.contract.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class IPFSPhotoService {
  public String insertIpfs(Long memberPhotoId) throws IOException {
    MemberPhoto memberPhoto = memberPhotoRepository.findById(memberPhotoId).orElseThrow();

    OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\"pinataContent\":{\"name\": \"" +memberPhoto.getName() + "\""
        + ",\"description\":\"" + memberPhoto.getDescription() + "\",\"image\":\"" + memberPhoto.getImageUrl() + "\"}}");

    Request request = new Request.Builder()
        .url("https://api.pinata.cloud/pinning/pinJSONToIPFS")
        .post(body)
        .addHeader("Authorization", PINATA_JWT)
        .addHeader("accept", "application/json")
        .addHeader("content-type", "application/json")
        .build();

    ResponseBody responsebody = client.newCall(request).execute().body();
    ObjectMapper mapper = new ObjectMapper();
    assert responsebody != null;
    JsonNode jsonNode = mapper.readTree(responsebody.byteStream());
    return jsonNode.get("IpfsHash").asText();
  }
}

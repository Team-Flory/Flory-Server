package zerobibim.flory.domain.Image.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import zerobibim.flory.global.common.BaseTime;

@Entity
@Getter
@Where(clause = "deleted_at is null")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Image extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    private Long senderId;

    private Long receiverId;

    private Boolean isNFT;

    @Builder
    public Image(String url) {
        this.url = url;
        this.senderId = null;
        this.receiverId = null;
        this.isNFT = Boolean.FALSE;
    }

    public void updateImage(Long senderId, Long receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isNFT = Boolean.TRUE;
    }
}

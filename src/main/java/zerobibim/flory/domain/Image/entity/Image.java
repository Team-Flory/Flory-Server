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

    private Boolean isNFT;

    @Builder
    public Image(String url) {
        this.url = url;
        this.isNFT = Boolean.FALSE;
    }
}

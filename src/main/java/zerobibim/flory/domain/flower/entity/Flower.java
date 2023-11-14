package zerobibim.flory.domain.flower.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import zerobibim.flory.domain.Image.entity.Image;
import zerobibim.flory.global.common.BaseTime;

@Entity
@Getter
@Where(clause = "deleted_at is null")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Flower extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Long price;

    @OneToOne
    @JoinColumn
    private Image image;

    @Builder
    public Flower(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void update(String description, Long price) {
        this.description = description;
        this.price = price;
    }
}

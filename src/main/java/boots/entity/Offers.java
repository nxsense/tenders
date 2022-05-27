package boots.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "tender_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Tender tender;
    @Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
}

package boots.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tenders")
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(name = "date")
    private Date date;
    @Column(name = "offer_id")
    @OneToMany(mappedBy = "tender", cascade = CascadeType.DETACH)
    private Set<Offers> offers;
    @Transient
    List<Tender> stoppedTenders;

}

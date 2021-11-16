package seldi.seldi.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
@ToString(exclude = {"userId", "collegeSectorId"})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private LocalDateTime time;

    private String latitude;

    private String longitude;

    @ManyToOne
    private User userId;

    @ManyToOne
    private CollegeSector collegeSectorId;
}

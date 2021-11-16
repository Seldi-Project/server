package seldi.seldi.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import java.util.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
@ToString(exclude = {"collegeId", "collegeSectorId"})
public class CollegeSector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeSectorId;

    private String leftCoordinate;

    private String rightCoordinate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collegeSectorId")
    private List<Location> locationList = new ArrayList<>();

    @ManyToOne
    private College collegeId;
}

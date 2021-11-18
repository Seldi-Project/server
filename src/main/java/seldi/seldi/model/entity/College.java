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
@ToString(exclude = {"collegeId"})
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    private String collegeName;

    private String latitude;

    private String longitude;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collegeId")
    private List<User> userList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collegeId")
    private List<CollegeSector> collegeSectorList = new ArrayList<>();


}

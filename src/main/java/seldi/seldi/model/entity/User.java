package seldi.seldi.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
@ToString(exclude = {"userId", "collegeId"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String studentNum;

    private String phoneNum;

    private String email;

    private String password;

    private String image;

    private boolean firstVaccination;

    private boolean secondVaccination;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<Location> locationList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<SelfDiagnosis> selfDiagnosisList = new ArrayList<>();

    @ManyToOne
    private College collegeId;
}

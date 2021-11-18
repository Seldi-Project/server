package seldi.seldi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponse {

    private String email;

    private String name;

    private String nickName;

    private String collegeName;

    private String studentNum;

    private String image;

    private String phoneNum;

    private boolean firstVaccination;

    private boolean secondVaccination;

}

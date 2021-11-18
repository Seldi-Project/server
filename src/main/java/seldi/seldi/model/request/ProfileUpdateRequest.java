package seldi.seldi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileUpdateRequest {

    private String email;

    private String image;

    private String phoneNum;

    private String nickName;

    private Boolean firstVaccination;

    private Boolean secondVaccination;

}

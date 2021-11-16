package seldi.seldi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterApiRequest {

    private String name;

    private String email;

    private String password;

    private String confirmPw;

    private String studentNum;

    private String phoneNum;

    private Long collegeId;

}

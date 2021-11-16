package seldi.seldi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoRequest {

    private String name;

    private String studentNum;

    private String phoneNum;

    private String email;

    private String password;

    private String verificationCode;

    private boolean checkEmail;
}

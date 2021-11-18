package seldi.seldi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String jwtToken;

    private String name;

    private String email;

    private String nickName;

    private String studentNum;

    private String image;

}

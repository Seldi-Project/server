package seldi.seldi.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {

    @ApiModelProperty(example = "wlrhkd49@cau.ac.kr")
    private String email;

    private String password;

}

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
public class LocationRequest {
    private Long collegeId;

    @ApiModelProperty(example = "2021-11-23-14")
    private String time;
}

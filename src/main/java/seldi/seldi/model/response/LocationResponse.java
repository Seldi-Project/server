package seldi.seldi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {
    private String latitude;

    private String longitude;

    private String content;

    private int level;
}
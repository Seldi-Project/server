package seldi.seldi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVaccineCheckResponse {

    private String email;

    private boolean firstVaccination;

    private boolean secondVaccination;

}

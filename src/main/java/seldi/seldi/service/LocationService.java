package seldi.seldi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seldi.seldi.model.Header;
import seldi.seldi.model.entity.Location;
import seldi.seldi.model.entity.SelfDiagnosis;
import seldi.seldi.model.entity.User;
import seldi.seldi.model.repository.LocationRepository;
import seldi.seldi.model.repository.SelfDiagnosisRepository;
import seldi.seldi.model.repository.UserRepository;
import seldi.seldi.model.request.LocationRequest;
import seldi.seldi.model.response.LocationResponse;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SelfDiagnosisRepository selfDiagnosisRepository;


    public List<LocationResponse> read(Long collegeId, String time) {
        List<Location> locationList = locationRepository.findByLocationList(collegeId, time);
        return locationList.stream().map(location -> response(location, time.substring(0, 10)+"%"))
                .collect(Collectors.toList());

    }

    private LocationResponse response(Location location,String time) {
        User user = userRepository.findByEmail(location.getUserId().getEmail());
        SelfDiagnosis selfDiagnosis = selfDiagnosisRepository.findByUserIdAndDiagnosisDateLike(user, time);

        return LocationResponse.builder()
                .content(selfDiagnosis.getContent())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .level(selfDiagnosis.getLevel())
                .build();

    }
}

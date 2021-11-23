package seldi.seldi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import seldi.seldi.model.Header;
import seldi.seldi.model.request.LocationRequest;
import seldi.seldi.service.LocationService;

@RestController
@Api(tags = "시간별로 유저 위치 불러오기")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    @ApiOperation(value = "시간대별로 사용자 위치 부름")
    public Header read(@RequestParam Long collegeId,
                       @RequestParam String time) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = ((User) auth.getPrincipal()).getUsername();

            return Header.OK(locationService.read(collegeId, time),"");

        }
        catch(Exception e) {
            return Header.ERROR("로그인이 필요합니다.");
        }
    }

}

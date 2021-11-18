package seldi.seldi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seldi.seldi.model.Header;
import seldi.seldi.model.request.ProfileUpdateRequest;
import seldi.seldi.service.UserService;

@RestController
@Api(tags = "유저 백신여부 api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "유저 백신여부 조회 api")
    @GetMapping("/userProfile")
    public Header getProfile() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = ((User) auth.getPrincipal()).getUsername();
            return Header.OK(userService.getProfile(email), "유저 프로필 조회");
        }
        catch(Exception e) {
            return Header.ERROR("로그인이 필요합니다.");
        }
    }

    @ApiOperation(value = "유저 백신여부 등록 api")
    @PutMapping("/userProfile/update")
    public Header updateProfile(@RequestBody ProfileUpdateRequest profileUpdateRequest) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = ((User) auth.getPrincipal()).getUsername();
            if (email.equals(profileUpdateRequest.getEmail())) {
                return Header.OK(userService.updateProfile(profileUpdateRequest), "유저 프로필 수정");
            }
            else {
                return Header.ERROR("잘못된 접근입니다.");
            }
        }
        catch(Exception e) {
            return Header.ERROR("로그인이 필요합니다.");
        }
    }
}

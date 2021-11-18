package seldi.seldi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seldi.seldi.model.Header;
import seldi.seldi.model.entity.User;
import seldi.seldi.service.UserService;

@RestController
@Api(tags = "유저 프로필 조회 & 수정 & ...")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "유저 프로필 조회 api")
    @GetMapping("/userProfile")
    public void getProfile() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = ((User) auth.getPrincipal()).getUsername();
            System.out.println(email);
        }
        catch(Exception e) {
//            return Header.ERROR("로그인이 필요합니다.");
            System.out.println("error");
        }
    }
}

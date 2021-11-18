package seldi.seldi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seldi.seldi.model.Header;
import seldi.seldi.model.request.LoginRequest;
import seldi.seldi.security.entity.JwtUtil;
import seldi.seldi.service.UserService;

@RestController
@Api(tags = "로그인 ")
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @ApiOperation("로그인 페이지")
    @PostMapping("/login")
    public Header generateToken(
            @ApiParam(value = "!!이메일 주소, 비밀번호 필수!!", required = true, example = "email:test@naver.com, password:****")
            @RequestBody LoginRequest loginRequest
    ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            return Header.OK(userService.login(jwtUtil.generateToken(loginRequest.getEmail()), loginRequest.getEmail()), "로그인 성공");
        } catch (Exception e) {
            return Header.ERROR("Wrong id or password.");
        }
    }

}

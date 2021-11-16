package seldi.seldi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seldi.seldi.model.Header;
import seldi.seldi.model.entity.User;
import seldi.seldi.model.request.RegisterApiRequest;
import seldi.seldi.model.request.UserInfoRequest;
import seldi.seldi.service.MailService;
import seldi.seldi.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@RestController
@Api(tags = "이메일 인증과 가입")
public class RegisterController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "이메일 코드 전송",notes = "이메일 코드 전송")
    @GetMapping("/email")
    public Header email(@ApiParam(value = "이메일주소", required = true, example = "test") @RequestParam String email,
                        @ApiIgnore() HttpSession httpSession)
            throws UnsupportedEncodingException, MessagingException {

        UserInfoRequest body = new UserInfoRequest();

        if(!userService.emailCheck(email)){
            return Header.ERROR("이미 존재하는 Email 입니다.");
        }

        body.setEmail(email);


        //메일보내고 인증코드 받아서
        String randomCode = mailService.sendVerificationEmail(email);

        //인증코드는 받은 UserDto에 저장하고
        body.setVerificationCode(randomCode);

        //세션에 받은 이메일을 key로 UserDTO 객체 Session의 저장
        //세션 만료 시간 3600
        httpSession.setAttribute(body.getEmail(),body);


        return Header.OK("인증 코드가 발송 되었습니다.");

    }

    @ApiOperation(value = "이메일 코드 인증",notes = "이메일 코드 인증")
    @GetMapping("/verify")
    public Header verify(@ApiParam(value = "이메일주소" ,required = true, example = "test") @RequestParam String email,
                         @ApiParam(value = "이메일 인증코드",required = true) @RequestParam String code,
                         @ApiIgnore() HttpSession httpSession){


        UserInfoRequest newBody = new UserInfoRequest();
        newBody.setEmail(email);
        newBody.setVerificationCode(code);

        //쿠키의 맞는 세션을 받아 해당 세션에서 파라미터로 받은 이메일의 해당하는 ACCOUNT객체 꺼내고
        //해당 객체의 코드와 파라미터로 받은 accountDto의 code를 비교
        UserInfoRequest originBody = (UserInfoRequest) httpSession.getAttribute(newBody.getEmail());


        if(originBody == null){ //쿠키가 없는경우
            return Header.ERROR("이메일 인증을 해주세요"+ " description : "+ newBody.getEmail() + " code : "+newBody.getVerificationCode());

        }

        //파라미터로 받은 newAccount와 기존에있던 originAcountDto code가 같으면
        if(newBody.getVerificationCode().contains(originBody.getVerificationCode())){
            originBody.setCheckEmail(true);
            httpSession.setAttribute(originBody.getEmail(),originBody);

            return Header.OK("이메일 인증 되었습니다.");

        } else{ // 다르면

            return Header.ERROR("인증번호가 틀렸습니다.");

        }
    }

    @ApiOperation(value = "인증 후 회원가입")
    @PostMapping("/register")
    public Header create(@RequestBody RegisterApiRequest request,
                         @ApiIgnore() HttpSession httpSession) {

        //입력받은 객체에 대한 값을 세션에서 꺼내서
        UserInfoRequest origiBody = (UserInfoRequest) httpSession.getAttribute(request.getEmail());

        if(origiBody==null)
            return Header.ERROR("이메일 인증을 진행하세요");
        //세션에서 꺼낸 originBody가 인증된 사용자인지 검토
        if(origiBody.isCheckEmail()){

            // 가입완료
            User user = userService.create(request);

            // 세션만료
            httpSession.removeAttribute(origiBody.getEmail());


            return Header.OK("회원가입이 성공적으로 완료되었습니다.");

        } else{

            return Header.ERROR("인증이 안된 사용자입니다.");
        }
    }
}

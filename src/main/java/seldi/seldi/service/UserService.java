package seldi.seldi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seldi.seldi.model.entity.College;
import seldi.seldi.model.entity.User;
import seldi.seldi.model.repository.CollegeRepository;
import seldi.seldi.model.repository.UserRepository;
import seldi.seldi.model.request.RegisterApiRequest;
import seldi.seldi.model.response.LoginResponse;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean emailCheck(String email){
        User findUser = userRepository.findByEmail(email);

        if(findUser != null){ // 이미존재하는 email
            return false;
        }
        return true;
    }

    public User create(RegisterApiRequest request) {
        College college = collegeRepository.findById(request.getCollegeId()).orElse(null);

        User user=User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .collegeId(college)
                .phoneNum(request.getPhoneNum())
                .studentNum(request.getStudentNum())
                .build();

        return userRepository.save(user);
    }

    public LoginResponse login(String generateToken, String email) {
        User user = userRepository.findByEmail(email);
        return LoginResponse.builder()
                .jwtToken(generateToken)
                .email(user.getEmail())
                .name(user.getName())
                .image(user.getImage())
                .studentNum(user.getStudentNum())
                .build();

    }
}

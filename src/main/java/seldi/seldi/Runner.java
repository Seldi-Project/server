package seldi.seldi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import seldi.seldi.model.entity.College;
import seldi.seldi.model.entity.User;
import seldi.seldi.model.repository.CollegeRepository;
import seldi.seldi.model.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class Runner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CollegeRepository collegeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection())
        {
//            College college = College.builder()
//                    .collegeId(1L)
//                    .collegeName("중앙대학교")
//                    .latitude("37.50482873810884")
//                    .longitude("126.95505529128035").build();
//
//            collegeRepository.save(college);
//
//            User user1 = User.builder()
//                    .email("wlrhkd49@cau.ac.kr")
//                    .name("string")
//                    .image("string")
//                    .password(passwordEncoder.encode("string"))
//                    .collegeId(college)
//                    .build();
//
//            userRepository.save(user1);
        }
    }
}


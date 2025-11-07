package vn.edu.hust.taika.miniclassroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hust.taika.miniclassroom.model.Teacher;
import vn.edu.hust.taika.miniclassroom.model.User;
import vn.edu.hust.taika.miniclassroom.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> creatUserWithRole(){
        Teacher teacher = new Teacher();
        return Optional.empty();
    }

}

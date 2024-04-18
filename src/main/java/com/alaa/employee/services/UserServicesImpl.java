package com.alaa.employee.services;

import com.alaa.employee.entity.User;
import com.alaa.employee.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices {
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User>optionalUser=userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser=userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setFirstName(user.getListName());
        existingUser.setEmail(user.getEmail());
        User updateUser=userRepository.save(existingUser);
        return updateUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}

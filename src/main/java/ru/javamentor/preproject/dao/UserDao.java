package ru.javamentor.preproject.dao;

import ru.javamentor.preproject.model.User;
import ru.javamentor.preproject.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDao {
    
    List<UserDto> getUsers();
    boolean saveUser(User user);
    boolean updateUser(User user);
    void deleteUser(long id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

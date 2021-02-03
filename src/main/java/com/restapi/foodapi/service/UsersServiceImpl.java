package com.restapi.foodapi.service;

import com.restapi.foodapi.dao.UsersRepository;
import com.restapi.foodapi.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long theId) {
        return usersRepository.findById(theId);
    }

    @Override
    public Users save(Users users) {
        if (usersRepository.findByEmail(users.getEmail()).isPresent()) {
            throw new RuntimeException("The Email is already Present, Failed to Create new User") ;
        }else {
        usersRepository.save(users);
        }
        return users;
    }

    @Override
    public void deleteById(Long theId) {
        usersRepository.deleteById(theId);
    }


}

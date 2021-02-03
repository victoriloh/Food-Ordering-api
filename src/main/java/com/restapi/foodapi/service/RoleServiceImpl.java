package com.restapi.foodapi.service;

import com.restapi.foodapi.dao.RolesRepository;
import com.restapi.foodapi.dao.UsersRepository;
import com.restapi.foodapi.entity.Roles;
import com.restapi.foodapi.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleServiceImpl  {
    private UsersRepository usersRepository;
    private RolesRepository rolesRepository;

    public RoleServiceImpl(UsersRepository usersService, RolesRepository rolesRepository) {
        this.usersRepository = usersService;
        this.rolesRepository = rolesRepository;
    }

//    @Override
//    public List<Roles> findAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<Roles> findById(Long theId) {
//        return Optional.empty();
//    }

//    @Override
    public String save(Roles role) {
        Roles newRole = new Roles();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        List<Roles> roleList = new ArrayList<>();
        roleList.add(newRole);

        for (int i = 0; i < role.getUsers().size(); i++) {
            if (!usersRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent()) {
                Users newUser = role.getUsers().get(i);
                assert roleList instanceof Roles;
                newUser.setRoles((Roles) roleList);
                Users savedUser = usersRepository.save(newUser);
                if (!usersRepository.findById(savedUser.getId()).isPresent()) {
                    throw new RuntimeException("Role Creation Failed");
                } else {
                    return "User with email Id is already Present";
                }
            }
        }
        return "Successfully created Role";
    }

 //   @Override
    public String deleteById(Long theId) {
        if(rolesRepository.findById(theId).isPresent()){
            if(rolesRepository.getOne(theId).getUsers().size() == 0) {
                rolesRepository.deleteById(theId);
                if (rolesRepository.findById(theId).isPresent()) {
                    throw  new RuntimeException("Failed to delete the specified record");
                } else return ("Successfully deleted specified record");
            } else return ("Failed to delete,  Please delete the users associated with this role");
        } else
            return "No Records Found";
    }

    public ResponseEntity<Object> updateRole(Long id, Roles role) {
        if(rolesRepository.findById(id).isPresent()){
            Roles newRole = rolesRepository.findById(id).get();
            newRole.setName(role.getName());
            newRole.setDescription(role.getDescription());
            Roles savedRole = rolesRepository.save(newRole);
            if(rolesRepository.findById((long) savedRole.getId()).isPresent())
                return ResponseEntity.accepted().body("Role saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Role");

        } else return ResponseEntity.unprocessableEntity().body("Specified Role not found");
    }

//    @Override
//    public Optional<Object> findByEmail(String email) {
//        return Optional.empty();
//    }
}


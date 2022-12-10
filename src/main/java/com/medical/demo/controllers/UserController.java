package com.medical.demo.controllers;
import com.medical.demo.models.*;
import com.medical.demo.utils.UserList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    UserList users = new UserList();

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(users.getUsers());
    }
    @PostMapping("/create_user")
    public ResponseEntity<Object> createUser(@RequestBody HashMap<String, Object> user){
        try {
          User newUser;
          if (user.get("role").toString().equals(Role.ADMIN.name())){
              newUser = new Admin(user);
          } else if (user.get("role").toString().equals(Role.PATIENT.name())) {
              newUser = new Patient(user);

          } else if (user.get("role").toString().equals(Role.PHARMACIST.name())) {
              newUser = new Pharmacist(user);

          }else {
              newUser = new Physician(user);
          }
            users.addUser(newUser.signup());
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest userLogin){
        
    }
}

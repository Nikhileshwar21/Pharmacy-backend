package com.code.userservice.controller;

import com.code.userservice.entity.Drugs;
import com.code.userservice.entity.Order;
import com.code.userservice.entity.User;
import com.code.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User _user = userService.addUser(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User could not be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    @GetMapping("/getdrugs/{id}")
    public Drugs getdrugs(@PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        Drugs drugs=restTemplate.getForObject("http://localhost:9092/drugs/list/"+id,Drugs.class);
        return drugs;
    }

    @PostMapping("/AddOrder")
    public String insertOrder(@RequestBody Order order) {

        //   public Order createOrder(@RequestBody Order order) throws RestClientException, JsonProcessingException {
        return restTemplate.postForObject("http://localhost:9093/order/register",order, String.class);

    }








    @GetMapping("/findAllUser")
    public List<User> getUser() {

        return userService.getAllUsers();
    }

    @GetMapping("list/{id}")
    public ResponseEntity <Object> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(id));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id,HttpStatus.NOT_FOUND);
        }
    }




    @PutMapping("/update/{id}")
    public ResponseEntity < Object > updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            user.setId(id);
            return ResponseEntity.ok().body(userService.updateUser(user));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable String id)  {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
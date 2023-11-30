package com.ust.spring.sample_crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ust.spring.sample_crud.Entity.User;
import com.ust.spring.sample_crud.Repository.userRepository;
import com.ust.spring.sample_crud.Repository.vehicleRepositorty;

import lombok.Delegate;

@RestController
@RequestMapping("/api/v1")
public class controller {

     @Autowired
    private userRepository ur;

    @Autowired
    private vehicleRepositorty vr;


         @PostMapping("/add")
         public ResponseEntity <User> addUser( @RequestBody User user){


        return ResponseEntity.ok(ur.save(user));


           }



         @GetMapping("/getAllUser")
        public ResponseEntity<List<User>> getAll(){

            return ResponseEntity.ok(ur.findAll());

        }


        @GetMapping("/getUser/{ID}")
        public ResponseEntity<User> fimdUser(   @PathVariable Integer id){


            Optional<User> temp = ur.findById(id);


            User us = null;

            if(temp.isPresent()){

                us = temp.get();
                return ResponseEntity.ok(us);
                
            }else{
                return ResponseEntity.noContent().build();
            }


        }

         @PutMapping("/updateUser/{ID}")
        public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User user){


            Optional<User> temp = ur.findById(id);

            User us = null;

            if(temp.isPresent()){
              us=  ur.save(user);
              return ResponseEntity.ok(us);

            }else{
                return ResponseEntity.noContent().build();
            }


        }


         @DeleteMapping("/delete/{ID}")
        public ResponseEntity<User> deleteUser(@PathVariable Integer id){


            Optional<User> temp = ur.findById(id);

            User us = null;
            if(temp.isPresent()){

                us = temp.get();
                ur.delete(us);
                return ResponseEntity.ok(us);
            }else{
                return ResponseEntity.noContent().build();
            }


        }

         

        @DeleteMapping("/deleteAll")
        public  void deleteAll(){

            ur.deleteAll();
           
        }






    





    
}
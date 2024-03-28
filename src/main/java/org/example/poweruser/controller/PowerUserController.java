package org.example.poweruser.controller;

import lombok.RequiredArgsConstructor;
import org.example.poweruser.model.PowerUser;
import org.example.poweruser.service.PowerUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class PowerUserController {
    private final PowerUserService powerUserService;

    @PostMapping("/user")
   public ResponseEntity<PowerUser> postPowerUser(@RequestBody PowerUser powerUser){
        return powerUserService.postPowerUser(powerUser);
    }
    @PutMapping("{id}/update-user")
    public ResponseEntity<PowerUser> updatePowerUser(@PathVariable int id, @RequestBody PowerUser powerUser){
        return powerUserService.updatePowerUser(id,powerUser);
    }
    @GetMapping("user")
    public ResponseEntity<PowerUser> getPowerUserById(@RequestParam int id){
        return powerUserService.getPowerUserById(id);
    }
    @GetMapping("user/name")
    public ResponseEntity<PowerUser> getPowerUserByFirstName(@RequestParam String firstNames){
        return powerUserService.getPowerUserByFirstName(firstNames);
    }
    @GetMapping("user/number")
    public ResponseEntity<PowerUser> getPowerUserByPhoneNumber(@RequestParam String phoneNumber){
        return powerUserService.getPowerUserByPhoneNumber(phoneNumber);
    }
    @GetMapping("get-all-user")
    public ResponseEntity<List<PowerUser>> getAllPowerUser(){
        return powerUserService.getAllPowerUser();
    }
    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<PowerUser> deletePowerUser(@PathVariable int id){
        return powerUserService.deletePowerUser(id);

    }

}

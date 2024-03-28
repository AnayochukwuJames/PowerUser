package org.example.poweruser.service;

import org.example.poweruser.model.PowerUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PowerUserService {
    ResponseEntity<PowerUser> postPowerUser(PowerUser powerUser);

    ResponseEntity<PowerUser> updatePowerUser(int id, PowerUser powerUser);

    ResponseEntity<PowerUser> getPowerUserById(int id);
    ResponseEntity<PowerUser> getPowerUserByFirstName(String firstName);
    ResponseEntity<PowerUser> getPowerUserByPhoneNumber(String phoneNumber);

    ResponseEntity<List<PowerUser>> getAllPowerUser();


    ResponseEntity<PowerUser> deletePowerUser(int id);

}

package org.example.poweruser.service.serviceImp;

import lombok.RequiredArgsConstructor;
import org.example.poweruser.model.PowerUser;
import org.example.poweruser.repository.PowerUserRepository;
import org.example.poweruser.service.PowerUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class PowerUserServiceImp implements PowerUserService {
    private final PowerUserRepository powerUserRepository;
    public ResponseEntity<PowerUser> postPowerUser( PowerUser powerUser ){
        return new ResponseEntity<>(powerUserRepository.save(powerUser), HttpStatus.CREATED);
    }
    public ResponseEntity<PowerUser> updatePowerUser(int id, PowerUser powerUser){
        PowerUser user = powerUserRepository.findById(id).get();
        user.setFirstName(powerUser.getFirstName());
        user.setLastName(powerUser.getLastName());
        user.setAddress(powerUser.getAddress());
        user.setPhoneNumber(powerUser.getPhoneNumber());

        return new ResponseEntity<>(powerUserRepository.save(user), HttpStatus.OK);
    }
    public ResponseEntity<PowerUser> getPowerUserById(int id){
        try{
            return new ResponseEntity<>(powerUserRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<PowerUser> getPowerUserByFirstName(String firstNames){
        try{
            return new ResponseEntity<>(powerUserRepository.findByFirstName(firstNames).get(), HttpStatus.OK);
        } catch (NoSuchElementException exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<PowerUser> getPowerUserByPhoneNumber(String phoneNumber){
        try{
            return new ResponseEntity<>(powerUserRepository.findByPhoneNumber(phoneNumber).get(), HttpStatus.OK);
        } catch (NoSuchElementException exception){System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<PowerUser>> getAllPowerUser(){
        return new ResponseEntity<>(powerUserRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<PowerUser> deletePowerUser(int id){PowerUser user = powerUserRepository
            .findById(id).get();powerUserRepository.deleteById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

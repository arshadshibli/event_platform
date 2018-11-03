package com.stackroute.distributor.controller;

import com.stackroute.distributor.domain.City;
import com.stackroute.distributor.domain.Distributor;
import com.stackroute.distributor.domain.Movie;
import com.stackroute.distributor.exceptions.DistributorAlreadyExistException;
import com.stackroute.distributor.exceptions.DistributorNotFoundException;
import com.stackroute.distributor.service.DistributorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/distributor")
@Api(value="movieapplication", description="Operations pertaining to a movie application")
public class DistributorController {
    private DistributorService distributorService;

    @Autowired
    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @PostMapping()
    public ResponseEntity<?> saveDistributor(@Valid @RequestBody Distributor distributor)  {
        ResponseEntity responseEntity;
        try {
            Distributor savedDistributor = distributorService.addDistributor(distributor);
            responseEntity = new ResponseEntity<Distributor>(savedDistributor, HttpStatus.OK);
        }
        catch (DistributorAlreadyExistException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }
    @GetMapping()
    public ResponseEntity<?> getAllDistributors(){
        List<Distributor> distributorsList;
        distributorsList = distributorService.getAllDistributors();
        ResponseEntity responseEntity = new ResponseEntity<List<Distributor>>(distributorsList,HttpStatus.OK);
        return  responseEntity;
    }

    @GetMapping(value="/{email}")
    public ResponseEntity<?> searchDistributor(@PathVariable String email){
        ResponseEntity responseEntity;
        try {
            Distributor distributor = distributorService.getDistributorByEmail(email);
            responseEntity = new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        }
        catch ( DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }
    @DeleteMapping(value ="/{email}")
    public ResponseEntity<?> deleteDistributor(@PathVariable String email){
        ResponseEntity responseEntity;
        try {
            Boolean bool = distributorService.deleteDistributor(email);
            responseEntity = new ResponseEntity<Boolean>(bool, HttpStatus.OK);
        }
        catch (DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return responseEntity;
    }
    @PutMapping(value = "{email}")
    public ResponseEntity<?> addNewCity(@PathVariable String email, @RequestBody City city)
    {
        ResponseEntity responseEntity;
        try {
            Distributor distributor=distributorService.addNewCity(email,city);
            responseEntity = new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        }catch(DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return responseEntity;

    }
    @PutMapping(value = "deleteCity/{email}/{cityName}")
    public ResponseEntity<?> DeleteCity(@PathVariable String email, @PathVariable String cityName)
    {
        ResponseEntity responseEntity;
        try {
            Distributor distributor=distributorService.DeleteCity(email,cityName);
            responseEntity = new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        }catch(DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return responseEntity;

    }
    @PutMapping(value = "addNewMovie/{email}/{cityName}")
    public ResponseEntity<?> addNewMovie(@PathVariable String email, @PathVariable String cityName, @RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            Distributor distributor=distributorService.addNewMovie(email,cityName,movie);
            responseEntity = new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        }catch(DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return responseEntity;

    }
    @PutMapping(value = "deleteMovie/{email}/{cityName}/{movieId}")
    public ResponseEntity<?> DeleteMovie(@PathVariable String email, @PathVariable String cityName,@PathVariable int movieId)
    {
        ResponseEntity responseEntity;
        try {
            Distributor distributor=distributorService.DeleteMovie(email,cityName,movieId);
            responseEntity = new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        }catch(DistributorNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return responseEntity;

    }

}

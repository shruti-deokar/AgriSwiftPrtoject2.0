package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Farmer;
import com.example.Service.FarmerService;

@RestController
public class FarmerController {

    @Autowired
    FarmerService service;
    
    @GetMapping("getfarmerdetails")
    public List<Farmer> getFarmerDetails(){
        return service.getFarmerDetails();
    }
    
    @PostMapping("addanother")
    public Farmer addAnotherDetail(@RequestBody Farmer farmer){
        return service.addAnotherDetail(farmer);
    }
    
    @PutMapping("update")
    public Farmer updateDetails(@RequestBody Farmer farmer) {
        return service.updateDetails(farmer);
    }
    
    @DeleteMapping("deletedata")
    public Farmer deleteData(@RequestBody Farmer farmer) {
        return service.deleteData(farmer);
    }
    
    @GetMapping("getfarmerdetailsbyid/{id}")
    public Farmer getDataById(@PathVariable("id") int id) {
        return service.getDataById(id);
    }
    
    @GetMapping("getfarmerdetails/{name}")
    public Farmer getAllDataByName(@PathVariable("name") String name) {
        return service.getDataByName(name);
    }
    
    // JDBC Code
    @GetMapping("jdbcdata")
    public ArrayList<Farmer> getDataByUsingJdbc() throws Exception{
        return service.getDataByJdbc();
    }
}

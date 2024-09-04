package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.FarmerDao;
import com.example.Entity.Farmer;

@Service
public class FarmerService {
    
    @Autowired
    FarmerDao dao;

    public List<Farmer> getFarmerDetails(){
        return dao.getFarmerDetails();
    }
    
    public Farmer addAnotherDetail(Farmer farmer){
        return dao.addAnotherFarmer(farmer);
    }
    
    public Farmer updateDetails(Farmer farmer) {
        return dao.updateDetails(farmer);
    }
    
    public Farmer deleteData(Farmer farmer) {
        return dao.deleteDetailsInTable(farmer);
    }
    
    public Farmer getDataById(int id) {
        return dao.getDataByUsingId(id);
    }
    
    public Farmer getDataByName(String name) {
        return dao.getDataByName(name);
    }
    
    // JDBC Code
    public ArrayList<Farmer> getDataByJdbc() throws Exception{
        return dao.getDataByUsingJdbc();
    }
}

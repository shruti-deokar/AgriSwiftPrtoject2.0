package com.example.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Repository;

import com.example.Entity.Farmer;

@Repository
public class FarmerDao {

    List<Farmer> list;

    public FarmerDao() {
        list = new ArrayList<>();
        list.add(new Farmer(1, "John", "Texas"));
        list.add(new Farmer(2, "Alex", "California"));
        list.add(new Farmer(3, "Emma", "Florida"));
        list.add(new Farmer(4, "Olivia", "New York"));
    }

    public Farmer addAnotherFarmer(Farmer farmer) {
        list.add(farmer);
        return farmer;
    }

    public List<Farmer> getFarmerDetails() {
        return list;
    }

    public Farmer updateDetails(Farmer farmer) {
        list.add(farmer);
        return farmer;
    }

    public Farmer deleteDetailsInTable(Farmer farmer) {
        list.add(farmer);
        return farmer;
    }

    public Farmer getDataByUsingId(int id) {
        Farmer farmer = null;
        for (Farmer f : list) {
            if (f.getId() == id) {
                farmer = f;
            }
        }
        return farmer;
    }

    public Farmer getDataByName(String name) {
        Farmer farmer = null;
        for (Farmer f : list) {
            if (f.getName().equals(name)) {
                farmer = f;
            }
        }
        return farmer;
    }

    // JDBC Code
    public ArrayList<Farmer> getDataByUsingJdbc() throws Exception {
        ArrayList<Farmer> list = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_management", "root", "root");
        String query = "select * from farmer";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String location = rs.getString(3);

            Farmer farmer = new Farmer(id, name, location);
            list.add(farmer);
        }
        return list;
    }
}

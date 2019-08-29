package tws.entity;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String age;
    private List<ParkingLot> lotList;
    public Employee() {

    }

    public Employee(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<ParkingLot> getLotList() {
        return lotList;
    }

    public void setLotList(List<ParkingLot> lotList) {
        this.lotList = lotList;
    }
}

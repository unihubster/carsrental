package net.demo.carsrental.model;

import net.demo.carsrental.dao.table.CarStatusTable;

import java.math.BigDecimal;

public class Car implements Entity {
    private Long id;
    private String producer;
    private String model;
    private String registrationNumber;
    private String carType;
    private String carClass;
    private int seats;
    private int doors;
    private BigDecimal rentCost;
    private Status status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public void setRentCost(BigDecimal rentCost) {
        this.rentCost = rentCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        FREE(CarStatusTable.STATUS_FREE_ID),
        RESERVED(CarStatusTable.STATUS_RESERVED_ID),
        RENTED(CarStatusTable.STATUS_RENTED_ID),
        BROKEN(CarStatusTable.STATUS_BROKEN_ID),
        UNDER_REPAIR(CarStatusTable.STATUS_UNDER_REPAIR_ID),
        WRITTEN_OFF(CarStatusTable.STATUS_WRITTEN_OFF_ID);

        public final int statusId;

        Status(int statusId) {
            this.statusId = statusId;
        }
    }
}

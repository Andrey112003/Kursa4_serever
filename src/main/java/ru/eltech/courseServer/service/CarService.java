package ru.eltech.courseServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.courseServer.entity.CarEntity;
import ru.eltech.courseServer.repository.CarRepo;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<CarEntity> getCars() throws SQLException {
        return carRepo.findAll();
    }

    public CarEntity createCar(String brand, int year, int price) throws SQLException {
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(brand);
        carEntity.setYear(year);
        carEntity.setPrice(price);
        return carRepo.save(carEntity);
    }

    public void updateCar(int id, String brand, int year, int price) throws SQLException {
        carRepo.update(brand, year, price, id);
    }

    public void deleteCar(int id) throws SQLException {
        carRepo.delete(id);
    }
}

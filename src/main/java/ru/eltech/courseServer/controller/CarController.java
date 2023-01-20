package ru.eltech.courseServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eltech.courseServer.entity.CarEntity;
import ru.eltech.courseServer.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity getCars() {
        try {
            List<CarEntity> cars = carService.getCars();
            return ResponseEntity.ok(cars);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createCar(@RequestParam String brand, @RequestParam int year, @RequestParam int price) {
        try {
            CarEntity car = carService.createCar(brand, year, price);
            return ResponseEntity.ok(car);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestParam String brand, @RequestParam int year, @RequestParam int price) {
        try {
            carService.updateCar(id, brand, year, price);
            CarEntity updatedCar = new CarEntity(id, brand, year, price);
            return ResponseEntity.ok(updatedCar);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable int id) {
        try {
            carService.deleteCar(id);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

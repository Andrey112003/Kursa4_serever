package ru.eltech.courseServer.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.eltech.courseServer.entity.CarEntity;

public interface CarRepo extends JpaRepository<CarEntity, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE car SET brand = ?1, year = ?2, price = ?3 WHERE id = ?4")
    void update(String brand, int year,  int price, int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM car WHERE id = ?1")
    void delete(int id);
}

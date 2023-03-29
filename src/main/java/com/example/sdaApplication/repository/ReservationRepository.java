package com.example.sdaApplication.repository;

import com.example.sdaApplication.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}

package com.example.event_management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.event_management.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByEvent_Id(int eventId);
    List<Booking> findByUser_Id(int userId);
    boolean existsByUser_IdAndEvent_Id(int userId, int eventId);

}
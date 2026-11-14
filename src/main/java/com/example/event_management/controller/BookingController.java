
package com.example.event_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.event_management.entity.Booking;
import com.example.event_management.entity.Event;
import com.example.event_management.entity.User;
import com.example.event_management.repository.BookingRepository;
import com.example.event_management.repository.EventRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    // Book an event
    @GetMapping("/book-event/{eventId}")
    public String bookEvent(@PathVariable int eventId,
                            HttpSession session) {

        // 1. Get logged-in user
        User user = (User) session.getAttribute("user");

        // 2. Check whether user is logged in
        if (user == null || !"USER".equals(user.getRole())) {
            return "redirect:/";
        }

        // 3. Find event using event ID
        Event event = eventRepository.findById(eventId).orElse(null);

        if (event == null) {
            return "redirect:/user-dashboard";
        }

        // 4. Check whether user has already booked this event
        boolean alreadyBooked =
                bookingRepository.existsByUser_IdAndEvent_Id(
                        user.getId(), eventId);

        // 5. Save booking if not already booked
        if (!alreadyBooked) {

            Booking booking = new Booking();

            booking.setUser(user);
            booking.setEvent(event);

            bookingRepository.save(booking);
        }

        // 6. Return to user dashboard
        return "redirect:/user-dashboard";
    }
}

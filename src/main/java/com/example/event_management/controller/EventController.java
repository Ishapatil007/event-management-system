package com.example.event_management.controller;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.event_management.entity.Event;
import com.example.event_management.entity.User;
import com.example.event_management.repository.EventRepository;
import com.example.event_management.repository.BookingRepository;
import jakarta.servlet.http.HttpSession;
@Controller 
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;
    // User Dashboard
    @GetMapping("/user-dashboard")
    public String userDashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null || !"USER".equals(user.getRole())) {
            return "redirect:/";
        }
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("bookings",
                bookingRepository.findByUser_Id(user.getId()));
        return "user-dashboard";
    }
    // Admin Dashboard
    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/";
        }

        model.addAttribute("events", eventRepository.findAll());

        model.addAttribute("selectedEvent", null);

        model.addAttribute("bookings", Collections.emptyList());

        return "admin-dashboard";
    }
    // Open Create Event Page
    @GetMapping("/create-event")
    public String createEventPage(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/";
        }
        return "create-event";
    }
    // Save New Event
    @PostMapping("/create-event")
    public String createEvent(@ModelAttribute Event event,
                              HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/";
        }
        eventRepository.save(event);
        return "redirect:/admin-dashboard";
    }
    //registered users
    @GetMapping("/event-registrations/{eventId}")
    public String viewRegistrations(@PathVariable int eventId,
                                    Model model,
                                    HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/";
        }

        Event event = eventRepository.findById(eventId).orElse(null);

        if (event == null) {
            return "redirect:/admin-dashboard";
        }
        // Display all events
        model.addAttribute("events", eventRepository.findAll());
        // Display selected event
        model.addAttribute("selectedEvent", event);
        // Display users registered for selected event
        model.addAttribute("bookings",
                bookingRepository.findByEvent_Id(eventId));
        return "admin-dashboard";
    }
}

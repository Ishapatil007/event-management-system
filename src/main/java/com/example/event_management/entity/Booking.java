package com.example.event_management.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @ManyToOne // Many bookings can belong to one user.
	    @JoinColumn(name = "user_id") // Creates a foreign key column named user_id.
	    private User user;
	    @ManyToOne
	    @JoinColumn(name = "event_id")
	    private Event event;
	    //  getter and Setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Event getEvent() {
			return event;
		}
		public void setEvent(Event event) {
			this.event = event;
		}
	    
	}


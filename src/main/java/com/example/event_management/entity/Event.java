package com.example.event_management.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "events")
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private int id;
	    private String eventName;
	    private String description;
	    private String date;
	    private String location;
        // getter and setter
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEventName() {
			return eventName;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	}


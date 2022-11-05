package trip_scheduling.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trip_scheduling.project.entities.Trip;
import trip_scheduling.project.services.TripService;

import java.util.List;

@RestController
@RequestMapping(path = "api/tripScheduling")
public class AdminController {
	@Autowired
	private final TripService tripService;

	public AdminController(TripService tripS) {
		this.tripService = tripS;
	}

	@PostMapping("/tripA")
	public void addTrip(@RequestBody Trip trip) {
		tripService.addNewTrip(trip);
	}

	@GetMapping("/tripG")
	public List<Trip> getTrips() {
		return tripService.getTrips();

	}

	@PutMapping("/tripU/{tripId}")
	public void updateTrip(@PathVariable("tripId") Long trip_id,@RequestBody Trip trip) {
		tripService.updateTrip(trip_id,trip);
	}
	

	@DeleteMapping("/tripD/{tripId}")
	public void deleteTrip(@PathVariable("tripId") Long trip_id) {
		tripService.deleteTrip(trip_id);
	}

}
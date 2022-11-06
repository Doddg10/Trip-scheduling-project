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
import trip_scheduling.project.entities.Station;
import trip_scheduling.project.services.StationService;
import trip_scheduling.project.entities.Trip;
import trip_scheduling.project.services.TripService;


import java.util.List;

@RestController
@RequestMapping(path = "api/tripScheduling")
public class AdminController {
	@Autowired
	private final TripService tripService;
	private final StationService stationService;
        private final AdminService adminService;

	public AdminController(StationService stations,TripService tripS,AdminService adminS) {
                this.tripService = tripS;
		this.stationService = stations;
                this.adminService = adminS;
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
    
    @PostMapping("/stationA")
	public void addTrip(@RequestBody Station station) {
		stationService.addNewStation(station);
	}

	@GetMapping("/stationG")
	public List<Station> getStations() {
		return stationService.getStations();

	}

	@PutMapping("/stationU/{stationId}")
	public void updateStation(@PathVariable("stationId") Long station_id,@RequestBody Station station) {
		stationService.updateStation(station_id,station);
	}
	

	@DeleteMapping("/stationD/{stationId}")
	public void deleteTrip(@PathVariable("stationId") Long station_id) {
		stationService.deleteStation(station_id);

	}
        @PostMapping("/signUp")
	public void addAdmin(@RequestBody Admin admin) {
		adminService.addNewAdmin(admin);
	}

	@PostMapping("/signIn")
	public String SignInAdmin(@RequestBody Admin admin) {
		return adminService.SignInAdmin(admin);
	}


}
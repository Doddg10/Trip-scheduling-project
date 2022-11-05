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

import java.util.List;

@RestController
@RequestMapping(path = "api/tripScheduling")
public class AdminController {
	@Autowired
	private final StationService stationService;

	public AdminController(StationService stations) {
		this.stationService = stations;
	}

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

}
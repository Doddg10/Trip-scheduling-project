package trip_scheduling.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trip_scheduling.project.entities.Trip;
import trip_scheduling.project.repositories.TripRepository;

import java.util.List;

@Service
public class TripService {
	private final TripRepository tripRepository;

	@Autowired
	public TripService(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}

	public List<Trip> getTrips() {
		return tripRepository.findAll();

	}

	public void addNewTrip(Trip trip) {
		tripRepository.save(trip);

	}

	public void deleteTrip(Long id) {
		boolean yes = tripRepository.existsById(id);
		if (!yes) {
			throw new IllegalStateException("Trip with id " + id + " does not exist");
		}
		tripRepository.deleteById(id);

	}

	public void  updateTrip(Long trip_id,Trip trip) {          
		boolean yes = tripRepository.existsById(trip_id);
		if (!yes) {
			throw new IllegalStateException("Trip with id " + trip_id + " does not exist");
		}
		for(int i=0;i<tripRepository.findAll().size();i++) {
			if	(tripRepository.findAll().get(i).getId().equals(trip_id)) {
				Trip updateTrip=tripRepository.findAll().get(i);
				updateTrip.setStart_time(trip.getStart_time());
				updateTrip.setEnd_time(trip.getEnd_time());
				updateTrip.setFrom_station(trip.getFrom_station());
				updateTrip.setTo_station(trip.getTo_station());
				 tripRepository.save(updateTrip);
			}

		
		}
			
		
	}
}

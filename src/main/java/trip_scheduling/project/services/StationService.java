package trip_scheduling.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trip_scheduling.project.entities.Station;
import trip_scheduling.project.repositories.StationRepository;

import java.util.List;

@Service
public class StationService {
	private final StationRepository stationRepository;

	@Autowired
	public StationService(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}

	public List<Station> getStations() {
		return stationRepository.findAll();

	}

	public void addNewStation(Station station) {
		stationRepository.save(station);

	}

	public void deleteStation(Long id) {
		boolean yes = stationRepository.existsById(id);
		if (!yes) {
			throw new IllegalStateException("Station with id " + id + " does not exist");
		}
		stationRepository.deleteById(id);

	}

	public void  updateStation(Long station_id,Station station) {          
		boolean yes = stationRepository.existsById(station_id);
		if (!yes) {
			throw new IllegalStateException("Station with id " + station_id + " does not exist");
		}
		for(int i=0;i<stationRepository.findAll().size();i++) {
			if	(stationRepository.findAll().get(i).getId().equals(station_id)) {
				Station updateStation=stationRepository.findAll().get(i);
				updateStation.setName(station.getName());				
				stationRepository.save(updateStation);
			}

		
		}
			
		
	}
}

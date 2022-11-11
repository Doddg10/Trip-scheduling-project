package trip_scheduling.project.repositories;
import trip_scheduling.project.entities.Station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository
        extends JpaRepository<Station, Long> {

}
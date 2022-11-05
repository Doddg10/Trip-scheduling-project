package trip_scheduling.project.entities;

import javax.persistence.*;

@Entity
@Table
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String start_time;
	private String end_time;
	private String to_station;
	private String from_station;

	public Trip() {
	}

	public Trip(String start_time, String end_time, String to_station, String from_station) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.to_station = to_station;
		this.from_station = from_station;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getTo_station() {
		return to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}

	public String getFrom_station() {
		return from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}

	@Override
	public String toString() {
		return "Trip{" + "id=" + id + ", start_time='" + start_time + '\'' + ", end_time='" + end_time + '\''
				+ ", to_station='" + to_station + '\'' + ", from_station='" + from_station + '\'' + '}';
	}

}

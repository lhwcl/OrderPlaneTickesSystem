package cn.edu.hcxy.bll;

import cn.edu.hcxy.dto.Flight;

import java.sql.SQLException;
import java.util.Set;

public interface IFlightService {

    void insertFlight(Flight flight) throws SQLException;
    Set<Flight> getAllFlights() throws SQLException;
    Flight getFlightByDepartureTime(String departureTime);
    Flight getFlightByDepartureAirport(String departureAirport);
    Flight getFlightByDestinationAirport(String destinationAirport);
    void updateFlight(Flight flight);

}

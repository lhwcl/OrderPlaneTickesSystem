package cn.edu.hcxy.dao;

import cn.edu.hcxy.dto.Flight;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FlightImpl implements IFlightDao {

    @Override
    public void insetFlight(Flight flight) throws SQLException {
        System.out.println("进入Dao");
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="opts";
        String password="opts1234";

        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println("数据库"+con);
        String sql="INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,flight.getId());
        ps.setString(2,flight.getFlightid());
        ps.setString(3,flight.getPlaneType());
        ps.setInt(4,flight.getCurrentSeatsNum());
        ps.setString(5,flight.getDepartureAirport());
        ps.setString(6,flight.getDestinationAirport());
        ps.setString(7,flight.getDepartureTime());

        ps.executeUpdate();

    }

    @Override
    public Set<Flight> getAllFlights() throws SQLException {
        Set<Flight> flightSet=new HashSet<Flight>();
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="opts";
        String password="opts1234";

            Connection con= DriverManager.getConnection(url,username,password);
            String sql="select * from flight";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                String id=rs.getString("ID");
                String flightid=rs.getString("FLIGHT_ID");
                String planeType=rs.getString("PLANE_TYPE");
                int currentSeatsNum=rs.getInt("TOTAL_SEATS_NUM");
                String departureAirport=rs.getString("DEPARTURE_AIRPORT");
                String destinationAirport=rs.getString("DESTINATION_AIRPORT");
                String departureTime=rs.getString("DEPARTURE_TIME");
                Flight flight = new Flight(id, flightid, planeType, currentSeatsNum, departureAirport, destinationAirport, departureTime);
                flightSet.add(flight);
            }

        return flightSet;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) {
        return null;
    }

    @Override
    public Flight getFlightByDepartureAirport(String departureAirport) {
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirport(String destinationAirport) {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}

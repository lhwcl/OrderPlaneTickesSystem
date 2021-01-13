package cn.edu.hcxy.bll.impl;

import cn.edu.hcxy.bll.IFlightService;
import cn.edu.hcxy.dao.FlightImpl;
import cn.edu.hcxy.dao.IFlightDao;
import cn.edu.hcxy.dto.Flight;

import java.sql.SQLException;
import java.util.Set;

public class FlightServiceImpl implements IFlightService {

    IFlightDao iFlightDao;//因为要给FlightImpl传值，然而两层之间要用接口进行通信需要通过接口，所以需要创建接口这个成员变量

    public FlightServiceImpl() {
        this.iFlightDao=new FlightImpl();//构造方法就是给成员变量赋值
    }

    @Override
    public void insertFlight(Flight flight) throws SQLException {
        iFlightDao.insetFlight(flight);
    }

    @Override
    public Set<Flight> getAllFlights() throws SQLException {
        return iFlightDao.getAllFlights();
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

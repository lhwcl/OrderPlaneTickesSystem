package cn.edu.hcxy.dto;

public class Flight {
    private String id;
    private String flightid;//航班编号
    private String planeType;//飞机机型
    private int currentSeatsNum;//座位数
    private String departureAirport;//出发机场
    private String destinationAirport;//目的机场
    private String departureTime;//出发时间


    //构造方法

    public Flight(String id, String flightid, String planeType, int currentSeatsNum, String departureAirport, String destinationAirport, String departureTime) {
        this.id = id;
        this.flightid = flightid;
        this.planeType = planeType;
        this.currentSeatsNum = currentSeatsNum;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
    }


    //toString方法


    @Override
    public String toString() {
        return "Flight{" +
                "航班编号='" + flightid + '\'' +
                ", 飞机机型='" + planeType + '\'' +
                ", 座位数=" + currentSeatsNum +
                ", 出发机场='" + departureAirport + '\'' +
                ", 目的机场='" + destinationAirport + '\'' +
                ", 出发时间='" + departureTime + '\'' +
                '}';
    }

    public String getFlightid() {
        return flightid;
    }

    public void setFlightid(String flightid) {
        this.flightid = flightid;
    }

    public int getCurrentSeatsNum() {
        return currentSeatsNum;
    }

    public void setCurrentSeatsNum(int currentSeatsNum) {
        this.currentSeatsNum = currentSeatsNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }


    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }


}

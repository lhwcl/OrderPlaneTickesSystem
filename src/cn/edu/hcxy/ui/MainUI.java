package cn.edu.hcxy.ui;

import cn.edu.hcxy.bll.IFlightService;
import cn.edu.hcxy.bll.impl.FlightServiceImpl;
import cn.edu.hcxy.dto.Flight;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入相应的数字进行操作：");
            System.out.println("按1：录入航班信息");
            System.out.println("按2：显示所有航班信息");
            System.out.println("按3：查询航班信息");
            System.out.println("按4：机票预订");
            System.out.println("按5：机票退订");

            System.out.println("按6：退出系统");

            int thing = scanner.nextInt();
            switch (thing) {
                case 1: {
                    String id = UUID.randomUUID().toString();
//                    String id= UUID.randomUUID().toString().replace("-","");
                    System.out.println(id);
                    System.out.print("请输入航班编号：");
                    String flightid = scanner.next();
                    System.out.print("请输入航班机型：");
                    String planeType = scanner.next();
                    System.out.print("请输入座位数：");
                    int currentSeatsNum = scanner.nextInt();
                    System.out.print("请输入出发机场：");
                    String departureAirport = scanner.next();
                    System.out.print("请输入目的机场：");
                    String destinationAirport = scanner.next();
                    System.out.print("请输入出发时间：");
                    String departureTime = scanner.next();


                    Flight flight = new Flight(id, flightid, planeType, currentSeatsNum, departureAirport, destinationAirport, departureTime);
//                    设置值的位置与构造函数的设值顺序一样
                    IFlightService iFlightService = new FlightServiceImpl();
                    try {
                        iFlightService.insertFlight(flight);
                    } catch (SQLException e) {
//                        System.out.println("出错了，请检查");
//                        String error=e.getMessage().substring(0,9);
//                        System.out.println(error);
//                        e.printStackTrace();
                        String errorMessage = e.getMessage();
                        if (errorMessage.startsWith("ORA-12899")) {
                            //ORA-12899: value too large for column "OPTS"."FLIGHT"."ID" (actual: 32, maximum: 30)
                            // 按指定模式在字符串查找
                            String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                            // 创建 Pattern 对象
                            Pattern r = Pattern.compile(pattern);
                            // 现在创建 matcher 对象
                            Matcher m = r.matcher(errorMessage);
                            if (m.find()) {
                                String tableName = m.group(4);
                                String columnName = m.group(5);
                                System.out.println(tableName + "表的" + columnName + "这一列的值过大，请仔细检查");
                            } else {
                                System.out.println("NO MATCH");
                            }
                        }

                    }
                }
                break;
                case 2:{
                    IFlightService iFlightService = new FlightServiceImpl();
                    try {
                        Set<Flight> flightSet=iFlightService.getAllFlights();
                        for (Flight f:flightSet){
                            System.out.println(f);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                    ;
                case 3:
                    ;
                case 4:
                    ;
                case 5:
                    ;
                case 6:
                    ;
                default:
                    ;
            }
        }
    }

}

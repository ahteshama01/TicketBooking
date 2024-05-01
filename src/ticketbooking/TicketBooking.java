/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketbooking;

import java.util.Scanner;
import java.sql.*;
import utility.MyDao;

/**
 *
 * @author frikky
 */
public class TicketBooking {

    /**
     *
     * @param sc
     * @return
     */
    public int welcome(Scanner sc) {
        System.out.println("Welcome To Ticket Booking");
        System.out.println();
        System.out.println("1.Show Multiplexes");
        System.out.println("2.Show Movies");
        System.out.println("Choose Option: ");
        return sc.nextInt();
    }

    public int movies() {
        return 0;
    }

    public int multiplexes(Scanner sc) {
        String url = "jdbc:mysql://localhost:3306/MoviesTickets?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "frikky";
        String password = "123456789";
        MyDao md = MyDao.getInstance();
        try {
            Statement st = md.getConnection(url, username, password);
            String query = "SELECT Multiplex_ID,Multiplex_Name FROM Multiplex_info";
            ResultSet rs = md.fetchData(st, query);
            int cc = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cc; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        System.out.println("Choose Multiplex: ");
        return sc.nextInt();
    }

    public int multiplex(int multiplex_ID, Scanner sc) {
        String url = "jdbc:mysql://localhost:3306/MoviesTickets?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "frikky";
        String password = "123456789";
        MyDao md = MyDao.getInstance();
        try {
            Statement st = md.getConnection(url, username, password);
            String Multiplex_ID = null;
            String query = "SELECT b.sch_ID '#',a.Movie_Name,b.Show_timing FROM Movie_schedule b INNER JOIN Audi_info c ON(b.Audi_ID=c.Audi_ID) INNER JOIN Movie_info a ON(a.Movie_ID=b.Movie_ID) WHERE(c.Multiplex_ID='"+Multiplex_ID+"') ORDER BY b.sch_ID";
            ResultSet rs = st.executeQuery(query);
            int cc = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cc; i++) {
                    System.out.print(rs.getString(i) + "    ");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Choose Movies Name: ");
        return sc.nextInt();
    }

    public int movietickets(int sch_ID, int Movie_ID,Scanner sc) {
        return 0;
    }

    public void ticketbooked() {

    }

    public int movieInMultiplex(int Movie_ID) {
        return 0;
    }
}

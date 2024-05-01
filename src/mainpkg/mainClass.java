/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import ticketbooking.TicketBooking;
import java.util.Scanner;

/**
 *
 * @author frikky
 */
public class mainClass {

    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        TicketBooking tb = new TicketBooking();
        while (true) {
            option = tb.welcome(sc);
            switch (option) {
                case 1:
                    option=tb.multiplexes(sc);
                    tb.multiplex(option, sc);
                    break;

                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("wrong option");
            }
        }
    }

}

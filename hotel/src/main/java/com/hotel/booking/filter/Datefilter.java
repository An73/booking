package com.hotel.booking.filter;

import com.hotel.booking.domain.Room;
import com.hotel.booking.repos.RoomRepo;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Datefilter {
    private Date today = new Date();
    private RoomRepo roomRepo;

    public Datefilter(){}
    public Datefilter(RoomRepo roomRepo){
        this.roomRepo = roomRepo;
    }

    public List<Room> filtrate(Date check_in, Date check_out) {
        Iterable<Room> roomsBooked;
        List<Room> rooms = null;

        if (roomRepo == null)
            return null;

        if (check_in != null && check_out != null &&
                check_in.after(today) && check_out.after(today) &&
                (check_out.after(check_in) || check_in.equals(check_out))) {
            System.out.println(check_in.toString());
            roomsBooked = roomRepo.findC(check_in, check_out);
            rooms = (List<Room>) roomRepo.findAll();

            Iterator<Room> roomB = roomsBooked.iterator();
            while (roomB.hasNext()){
                rooms.removeIf(room1 -> roomB.next().getNumb() == room1.getNumb());
            }
            /*for (Room roomB : roomsBooked) {
                for (Room room : rooms) {
                    if (roomB.getNumb() == room.getNumb())
                        rooms.remove(room);
                }
            }*/
        }
        return rooms;
    }
}

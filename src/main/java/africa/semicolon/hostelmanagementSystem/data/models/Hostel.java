package africa.semicolon.hostelmanagementSystem.data.models;

import lombok.Data;

@Data
public class Hostel {
    private String name;
    private String id;
    private Room[] rooms;
    public Hostel(String hostelName, String hostelid, int numberOfRoom){
        name = hostelName;
        id = hostelid;
        rooms = new Room[numberOfRoom];

    }
}

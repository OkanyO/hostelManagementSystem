package africa.semicolon.hostelmanagementSystem.data.models;

import lombok.Data;

@Data
public class Room {
    private String hostelid;
    private String id;
    private String name;
    private BedSpace[] bedSpace;

    public Room(String hostelid, String roomId, String roomName, int numberOfBeds){
        this.hostelid = hostelid;
        id = roomId;
        name = roomName;
        bedSpace = new BedSpace[numberOfBeds];
    }
}

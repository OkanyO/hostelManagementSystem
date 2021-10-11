package africa.semicolon.hostelmanagementSystem.data.models;

import lombok.Data;

@Data
public class BedSpace {
    private String roomId;
    private String id;
    private boolean isEmpty;
}

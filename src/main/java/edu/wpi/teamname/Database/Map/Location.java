package edu.wpi.teamname.Database.Map;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class Location {
    @Getter
    @Setter
    private NodeType nodeType;
    @Getter @Setter private String longName;
    @Getter @Setter private String shortName;
    @Getter @Setter private List<Date> dates;

    @Getter @Setter private Node building;


    public Location(
        NodeType nodeType,
        String longName,
        String shortName){
        this.nodeType = nodeType;
        this.longName = longName;
        this.shortName = shortName;
    }
}

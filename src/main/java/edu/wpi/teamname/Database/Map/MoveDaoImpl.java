package edu.wpi.teamname.Database.Map;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoveDaoImpl implements MoveDAO_I{
    List<Move> moves;
    LocationDoaImpl locationDoa = LocationDoaImpl.getInstance();
    NodeDaoImpl nodeDao = NodeDaoImpl.getInstance();
    @Override
    public List<Move> getAllMoves() {
        return moves;
    }

    @Override
    public List<Move> getLocationMove(String location) {
        List<Move> previousMoves = new ArrayList<>();

        for(Move thisMove: moves){
            if (thisMove.location.equals(location)) previousMoves.add(thisMove);
        }
        return previousMoves;

    }
    @Override
    public Move getMove(String location, Date moveDate) throws Exception {
        for(Move thisMove: moves){
            if (thisMove.location.equals(location) && thisMove.date.equals(moveDate)) return thisMove;

        }
        throw new NullPointerException();
    }

    public void processMoveRequest(int nodeID, String location, Date date) throws Exception{
        Node newNode = nodeDao.getNode(nodeID);


        if (!checkDate(location, date)){
            Location thisLocation = locationDoa.getLocation(location);
            newNode.addLocation(thisLocation);
            thisLocation.setNode(newNode);
            moves.add(new Move(nodeID, location, date));
        }

        else throw new Exception("Moved Today already");


    }

    public boolean checkDate(String location, Date date){

        return  (locationDoa.getLocation(location).getDates().contains(date));
    }
}

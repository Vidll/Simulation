package Main;

import Creature.Entity;

public class MapPlace extends Entity {

    private final Position position;
    protected boolean _makeMove = true;
    protected PlaceType _currentPlaceType = PlaceType.NONE;

    public MapPlace(){
        position = new Position();
    }

    public Position GetPosition(){ return position;}

    @Override
    protected void Destroy() {
        _mapSymbol = '.';
        _makeMove = true;
        _currentPlaceType = PlaceType.NONE;
        super.Destroy();
    }

    public boolean GetMakeMoveToPosition(){
        return _makeMove;
    }

    public PlaceType GetCurrentPlaceType() {return _currentPlaceType;}

    public enum PlaceType{
        NONE,
        Rock,
        Grass,
        Herbivore,
        Predator,
    }
}
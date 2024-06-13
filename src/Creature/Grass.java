package Creature;

public class Grass extends StaticObject{

    public Grass(){
        super();
        _mapSymbol ='g';
        _currentPlaceType = PlaceType.Grass;
        HP = 10;
    }

}
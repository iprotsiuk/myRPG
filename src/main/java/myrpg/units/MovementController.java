package myrpg.units;

import myrpg.map.IMap;
import myrpg.map.PathFinder;
import myrpg.map.Point;

import java.util.List;

public class MovementController {
    IMap map;

    public MovementController(IMap map){
        this.map = map;
    }

    public List<Point> move(IMove self, Point destination, int distance) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), destination);

        map.removeUnit(self.getCurrentPosition());

        int travelledDistance = distance < path.size() ? distance : path.size()-1;
        map.addUnit(self.getUnit(), path.get(travelledDistance));

        return path.subList(0, travelledDistance);
    }

    public Point getUnitPosition(IUnit unit){
        return map.getUnitPosition(unit);
    }

    public List<Point> follow(IMove self, IMove target, int distance) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), target.getCurrentPosition());
        path = path.subList(0, path.size()-1);

        if(path.size() == 0)
            return null;

        map.removeUnit(self.getCurrentPosition());
        int travelledDistance = distance < path.size() ? distance : path.size()-1;
        map.addUnit(self.getUnit(), path.get(travelledDistance));

        return path.subList(0, travelledDistance);
    }

    public List<Point> moveToAttackRange(IMove self, IMove target, int moveSpeed, int attackRange){
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), target.getCurrentPosition());

        double absoluteDistanceToTarget = getDistanceToMovable(self, target);
        int travelledDistance = 0;

        if(absoluteDistanceToTarget <= attackRange){
            return null;
        }
        else if(absoluteDistanceToTarget <= moveSpeed+attackRange){
            travelledDistance = (int)(Math.ceil(absoluteDistanceToTarget)) - attackRange;
        }
        else{
            travelledDistance = moveSpeed;
        }
        travelledDistance = travelledDistance > path.size() ? path.size()-1 : travelledDistance;
        map.removeUnit(self.getUnit());
        map.addUnit(self.getUnit(), path.get(travelledDistance));
        return path.subList(0, travelledDistance);
    }

    public double getDistanceToMovable(IMove self, IMove movable){
        return getDistanceToDestination(self, movable.getCurrentPosition());
    }

    public double getDistanceToDestination(IMove self, Point destination){
        return Point.getDistanceBetweenPoints(self.getCurrentPosition(), destination);
    }

}

package myrpg.units;

import myrpg.map.IMap;
import myrpg.map.PathFinder;
import myrpg.map.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<Point> getReachableLocations(IMove self, int range, int speed){
        PathFinder pf = new PathFinder(this.map);
        List<List<Point>> reachableLocationsPaths = new ArrayList<>();
        for(int i = self.getCurrentPosition().getRowPosition() - range/2; i <= self.getCurrentPosition().getRowPosition() + range/2; i++){
            for(int j = self.getCurrentPosition().getColPosition() - range/2; j <= self.getCurrentPosition().getColPosition() + range/2; j++){
                Point destination = new Point (i, j);
                if(getDistanceToDestination(self, destination) <= range){
                    List<Point> path = pf.buildPath(self.getCurrentPosition(), destination);
                    if(path.size() < speed && !reachableLocationsPaths.contains(path)){
                        reachableLocationsPaths.add(path);
                    }
                }
            }
        }
        List<Point> reachableLocations = new ArrayList<>();
        for(List<Point> paths : reachableLocationsPaths){
            reachableLocations.add(paths.get(paths.size()-1));
        }
        return reachableLocations;
    }

    public List<Point> roam(IMove self, List<Point> reachableLocations){
        PathFinder pf = new PathFinder(this.map);
        if(reachableLocations.size() != 0) {
            Random random = new Random();
            List<Point> randomPath = pf.buildPath(self.getCurrentPosition(), reachableLocations.get(random.nextInt(reachableLocations.size()-1)));
            map.removeUnit(self.getCurrentPosition());
            map.addUnit(self.getUnit(), randomPath.get(randomPath.size()-1));
            return randomPath;
        }
        return null;
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

    public Point getUnitPosition(IUnit unit){
        return map.getUnitPosition(unit);
    }

    public double getDistanceToMovable(IMove self, IMove movable){
        return getDistanceToDestination(self, movable.getCurrentPosition());
    }

    public double getDistanceToDestination(IMove self, Point destination){
        return Point.getDistanceBetweenPoints(self.getCurrentPosition(), destination);
    }

    public IMap getMap() {
        return map;
    }

}

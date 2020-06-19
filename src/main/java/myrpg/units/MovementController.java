package myrpg.units;

import javafx.util.Pair;
import myrpg.map.IMap;
import myrpg.map.PathFinder;
import myrpg.map.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MovementController {
    IMap map;

    public MovementController(IMap map) {
        this.map = map;
    }

    public List<Point> move(IMove self, Point destination, int distance) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), destination);

        map.removeUnit(self.getCurrentPosition());

        int travelledDistance = distance < path.size() ? distance : path.size() - 1;
        map.addUnit(self.getUnit(), path.get(travelledDistance));

        return path.subList(0, travelledDistance);
    }

    public List<Point> follow(IMove self, IMove target, int distance) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), target.getCurrentPosition());
        path = path.subList(0, path.size() - 1);

        if (path.size() == 0)
            return null;

        map.removeUnit(self.getCurrentPosition());
        int travelledDistance = distance < path.size() ? distance : path.size() - 1;
        map.addUnit(self.getUnit(), path.get(travelledDistance));

        return path.subList(0, travelledDistance);
    }

    public List<Point> getReachableLocations(IMove self, int range, int speed) {
        Point currentPosition = self.getCurrentPosition();
        return getReachableLocations(currentPosition, range, speed);
    }

    public List<Point> getReachableLocations(Point center, int range, int speed) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> reachableLocations = new ArrayList<>();
        reachableLocations.add(center);
        for (int i = center.getRowPosition() - range; i <= center.getRowPosition() + range; i++) {
            for (int j = center.getColPosition() - range; j <= center.getColPosition() + range; j++) {
                Point destination = new Point(i, j);
                if (Point.getDistanceBetweenPoints(center, destination) <= range) {
                    List<Point> path = pf.buildPath(center, destination);
                    if (path.size() > 0 && path.size() < speed) {
                        reachableLocations.add(path.get(path.size() - 1));
                    }
                }
            }
        }
        return reachableLocations;
    }

    public List<Point> roam(IMove self, List<Point> reachableLocations) {
        PathFinder pf = new PathFinder(this.map);
        if (reachableLocations.size() != 0) {
            Random random = new Random();
            List<Point> randomPath = pf.buildPath(self.getCurrentPosition(), reachableLocations.get(random.nextInt(reachableLocations.size() - 1)));
            map.removeUnit(self.getCurrentPosition());
            map.addUnit(self.getUnit(), randomPath.get(randomPath.size() - 1));
            return randomPath;
        }
        return null;
    }

    public IUnit getNearestUnit(IMove self, int range, int speed) {
        return getNearestUnit(self.getCurrentPosition(), range, speed);
    }

    public IUnit getNearestUnit(Point point, int range, int speed) {

        List<Point> reachableLocations = getReachableLocations(point, range, speed);
        List<Pair<IUnit, Point>> locationsWithUnits = getIUnitsOnListPoints(reachableLocations);
        return getNearestUnit(locationsWithUnits, point);
    }

    private List<Pair<IUnit, Point>> getIUnitsOnListPoints(List<Point> list) {
        List<Pair<IUnit, Point>> reachableUnits = new LinkedList<>();
        for (Point p : list) {
            IUnit unit = map.getUnitOnPoint(p);
            if (unit != null)
                reachableUnits.add(new Pair(unit, p));
        }
        return reachableUnits;
    }

    private IUnit getNearestUnit(List<Pair<IUnit, Point>> pairList, Point currentPosition) {
        IUnit unit = null;
        double min = Double.POSITIVE_INFINITY;
        for (Pair<IUnit, Point> p : pairList) {
            IUnit u = p.getKey();
            Point point = p.getValue();
            double distance = Point.getDistanceBetweenPoints(point, currentPosition);
            if (distance < min) {
                min = distance;
                unit = u;
            }
        }
        return unit;
    }

    public List<Point> moveToAttackRange(IMove self, IMove target, int moveSpeed, int attackRange) {
        PathFinder pf = new PathFinder(this.map);
        List<Point> path = pf.buildPath(self.getCurrentPosition(), target.getCurrentPosition());

        double absoluteDistanceToTarget = getDistanceToMovable(self, target);
        int travelledDistance = 0;

        if (absoluteDistanceToTarget <= attackRange) {
            return null;
        } else if (absoluteDistanceToTarget <= moveSpeed + attackRange) {
            travelledDistance = (int) (Math.ceil(absoluteDistanceToTarget)) - attackRange;
        } else {
            travelledDistance = moveSpeed;
        }
        travelledDistance = travelledDistance > path.size() ? path.size() - 1 : travelledDistance;
        map.removeUnit(self.getUnit());
        map.addUnit(self.getUnit(), path.get(travelledDistance));
        return path.subList(0, travelledDistance);
    }

    public Point getUnitPosition(IUnit unit) {
        return map.getUnitPosition(unit);
    }

    public double getDistanceToMovable(IMove self, IMove movable) {
        return getDistanceToDestination(self, movable.getCurrentPosition());
    }

    public double getDistanceToDestination(IMove self, Point destination) {
        return Point.getDistanceBetweenPoints(self.getCurrentPosition(), destination);
    }

    public IMap getMap() {
        return map;
    }

}

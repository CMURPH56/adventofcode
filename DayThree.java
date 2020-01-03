import java.util.*;
import java.io.*;
import java.lang.*;

class DayThree {

    private static List<Point> calculatePoints(String input){
        System.out.println("calculate points");
        List<Point> points = new ArrayList<Point>();
        Point startPoint = new Point();
        startPoint.x = 0;
        startPoint.y = 0;
        points.add(startPoint);
        
        String[] directions = input.split(",");
        startPoint.distanceTravelled = 0;

        for(int i = 0 ; i < directions.length; i++) {
            String direction = directions[i];
            points = addNewPoints(direction, points);
        }
        return points;
    }

    public static List<Point> addNewPoints(String directionAmount, List<Point> previousPoints){
        System.out.println("add new points");
        Point lastPoint = previousPoints.get(previousPoints.size() -1 );
        int startX = lastPoint.x;
        int startY = lastPoint.y;
        char direction = directionAmount.charAt(0);
        int amount = Integer.parseInt(directionAmount.replaceAll("\\D", ""));
        List<Point> newPoints = new ArrayList<Point>();
        
        if(direction == 'R') {
            int number = 0;
            for(int i = startX + 1; i <= startX + amount; i++){
                Point newPoint = new Point();
                number++;
                newPoint.distanceTravelled = lastPoint.distanceTravelled + number;
                newPoint.x = i;
                newPoint.y = startY;
                newPoints.add(newPoint);
            }
        }
        if(direction == 'L') {
            int number = 0;
            for(int i = startX - 1; i >= startX - amount; i--){
                Point newPoint = new Point();
                number++;
                newPoint.distanceTravelled = lastPoint.distanceTravelled + number;
                newPoint.x = i;
                newPoint.y = startY;
                newPoints.add(newPoint);
            }
        }
        if(direction == 'U') {
            int number = 0;
            for(int i = startY + 1; i <= startY + amount; i++){
                Point newPoint = new Point();
                number++;
                newPoint.distanceTravelled = lastPoint.distanceTravelled + number;
                newPoint.x = startX;
                newPoint.y = i;
                newPoints.add(newPoint);
            }
        }
        if(direction == 'D') {
            int number = 0;
            for(int i = startY - 1; i >= startY - amount; i--){
                Point newPoint = new Point();
                number++;
                newPoint.distanceTravelled = lastPoint.distanceTravelled + number;
                newPoint.x = startX;
                newPoint.y = i;
                newPoints.add(newPoint);
            }
        }
        previousPoints.addAll(newPoints);
        return previousPoints;
    }

    public static List<Point> findIntersections(List<Point> one, List<Point> two){
        System.out.println("find intersection");
        List<Point> intersectionPoints = new ArrayList<Point>();
        for(int i = 0; i < one.size(); i++){
            for(int j = 0; j< two.size(); j++){
                if( one.get(i).equalsPoint(two.get(j))){
                    one.get(i).distanceTravelled = one.get(i).distanceTravelled + two.get(j).distanceTravelled;
                    intersectionPoints.add(one.get(i));
                }
            }
        }
        System.out.println("intersection points size: " + intersectionPoints.size());
        for(int k = 0; k < intersectionPoints.size(); k++){
            System.out.println("(" + intersectionPoints.get(k).x + ", " +intersectionPoints.get(k).y +")" + "Distance Travelled: " + intersectionPoints.get(k).distanceTravelled);
        }
        return intersectionPoints;
    }

    public static void findShortestDistance(List<Point> input){
        System.out.println("find shortest distance");
        int manhattanDistance = Integer.MAX_VALUE;
        int zeroPointX = input.get(0).x;
        int zeroPointY = input.get(0).y;

        for(int i = 1; i < input.size(); i++){
            int x = input.get(i).x;
            int y = input.get(i).y;
            int answer =  input.get(i).distanceTravelled;//Math.abs(x  - zeroPointX) + Math.abs(y + zeroPointY);
            if(answer < manhattanDistance){
                manhattanDistance = answer;
            }             
        }
        System.out.println("Manhattan Distance: " + manhattanDistance);
    }
    public static void main(String args[]) throws Exception {
        File input = new File("DayThreeInput.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String st;
        List<String> wires = new ArrayList<String>();

        while ((st = br.readLine()) != null){
            wires.add(st);
        }
        List<Point> wireOnePoints = calculatePoints(wires.get(0));
        List<Point> wireTwoPoints = calculatePoints(wires.get(1));
        List<Point> answers = findIntersections(wireOnePoints, wireTwoPoints);
        findShortestDistance(answers);
        
    }
}

class Point{
    int x;
    int y;
    int distanceTravelled;

    public Boolean equalsPoint(Point point){
        if(this.x == point.x && this.y == point.y){
            return true;
        }
        return false;
    }
}
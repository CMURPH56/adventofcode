import java.util.*;
import java.io.*;
import java.util.ArrayList; 

class DayThreeBad {

    public static List<List<Point>> listOfPoints(List<String> input){
        String wireOne =  input.get(0);
        String wireTwo = input.get(1);
        System.out.println("wire two input " +wireTwo);
        Point startingPoint = new Point();
        startingPoint.x = 0;
        startingPoint.y = 0;
        List<Point>  wireOnePoints = new ArrayList<Point>();
        List<Point> wireTwoPoints = new ArrayList<Point>();
        wireOnePoints.add(startingPoint);
        wireTwoPoints.add(startingPoint);
        wireOnePoints = calculatePoints(wireOnePoints, wireOne);
        wireTwoPoints = calculatePoints(wireTwoPoints, wireTwo);
        List<List<Point>> wire = new ArrayList<List<Point>>();
        wire.add(wireOnePoints);
        wire.add(wireTwoPoints);
        return wire;
    }

    public static List<Point> calculatePoints(List<Point> starter, String wire){
        List<Point> points = new ArrayList<Point>(starter);
        String[] directions = wire.split(",");
        for(int i = 0 ; i < directions.length; i++) {
            String direction = directions[i];
            Point lastPoint = points.get(points.size() - 1);
            int change = getChange(direction);
            int x = 0;
            int y = 0;
            if(direction.charAt(0) == 'R') {
                x = lastPoint.x + change;
                y = lastPoint.y;
            }
            if(direction.charAt(0) == 'L') {
                x = lastPoint.x - change;
                y = lastPoint.y;
            }
            if(direction.charAt(0) == 'U'){
                y = lastPoint.y + change;
                x = lastPoint.x;
            }
            if(direction.charAt(0) == 'D') {
                y = lastPoint.y - change;
                x = lastPoint.x;
            }
            Point nextPoint = new Point();
            nextPoint.x = x;
            nextPoint.y = y;
            points.add(nextPoint);
        }
        return points;
    }


    public static int getChange(String direction){
        int change = Integer.parseInt(direction.replaceAll("\\D", ""));
        return change;
    }

    public static void main(String args[]) throws Exception{
        File input = new File("DayThreeInput.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String st;
        List<String> wires = new ArrayList<String>();

        while ((st = br.readLine()) != null){
            wires.add(st);
        }
        List<String> testWire = new ArrayList<String>();
        testWire.add("R8,U5,L5,D3");
        testWire.add("U7,R6,D4,L4");
        List<List<Point>> wirePoints =  listOfPoints(testWire);
    }
}
class Point{
    int x;
    int y;
}
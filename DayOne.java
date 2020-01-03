import java.io.*;
class DayOne {

    public static double findFuel(int mass){
        double fuelComputation = mass;
        double fuel = 0;

        while(fuelComputation >= 6){
            fuelComputation = Math.floor(fuelComputation / 3) - 2;
            fuel  = fuelComputation + fuel;
        }
        return fuel;
    }

    public static void main(String[] args) throws Exception {

        File input =  new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String st;
        double totalFuel = 0;
        while ((st = br.readLine()) != null){
            int mass = Integer.parseInt(st);
            totalFuel = findFuel(mass) + totalFuel;
        }
        
        System.out.println(totalFuel);
    }
}   
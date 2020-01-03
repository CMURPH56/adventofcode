import java.util.*;
import java.io.*;
import java.util.ArrayList; 


/*
    An Intcode program is a list of integers seperated by commas.

    Start by looking at the first integer (called at position 0)
    - This is the OPCODE either 1, 2, or 99. It indicates what to do 

    Option 1:
        Adds together numbers read from two positions and stores the 
        result in a third position. The three integers immediately after
        the opcode tell you these three positions. 
            - the first two indicate the positions from which you should
              read the input values
            - the third indicates the positions at which the output should
              be stored
            - [1, 10, 20, 30] adds 10 and 20 and overwrites position 30
              with that value

    Option 2:
        Same as option one but multiplies the numbers

    
    Once your done processing the opcode, move to the next one by steeping 
    forward 4 posisitionstgy
*/

class DayTwo implements Cloneable {


    public static int nextMethod(List<Integer> listOfInts){
        int OPCODE = 0;
        int i = 0;
        List<Integer> input = new ArrayList<Integer>(listOfInts);

        while ( i < input.size() ){
            OPCODE = input.get(i);
            int positionOne = input.get(i + 1);
            int positionTwo = input.get(i + 2);
            int positionThree = input.get(i + 3);
            System.out.println("index:  " + i + " opcode: "+  OPCODE);
            if(OPCODE == 1){
                int additionAnswer = input.get(positionOne) + input.get(positionTwo);
                input.set(positionThree, additionAnswer);
            }
            else if(OPCODE == 2){
                int multiplicationAnswer = input.get(positionOne)* input.get(positionTwo);
                input.set(positionThree, multiplicationAnswer);

            }
            else if (OPCODE == 99){
                return input.get(0);
            }
            else {
                System.out.println("First Error cam");
                input.set(0, -1);
                return input.get(0);
            }
            i =  i+4;
        }

        return 0;
            
    }
    public static List<Integer> convertToIntegerList(String input){

        List listOfInts = new ArrayList();
        String[] listOfStringNumbers;
        listOfStringNumbers = input.split(",");
        for(int i = 0; i < listOfStringNumbers.length; i++){
            listOfInts.add(Integer.parseInt(listOfStringNumbers[i]));
        }
        return listOfInts;
    }

    public static List<Integer> setSecondThirdNumbers(List<Integer> input){
        int firstNumber = input.get(1);
        int secondNumber = input.get(2);
        
        if(secondNumber <= 99) {
            secondNumber = secondNumber +1;
        }
        else if(firstNumber <= 99){
            firstNumber = firstNumber +1;
            secondNumber = 0;
        }
        else {
            System.out.println("ran out of numbers cam");
            input.set(0, -1);
        }
        System.out.println("first number: " + firstNumber);
        System.out.println("second number: " + secondNumber);
        input.set(1, firstNumber);
        input.set(2, secondNumber);
        return input;
    }

    public static void main(String args[]) throws Exception{

        File input =  new File("inputDayTwo.txt");


        BufferedReader br = new BufferedReader(new FileReader(input));
        String st;
        List<Integer> inputNumbers = new ArrayList<Integer>();
        while ((st = br.readLine()) != null){
            inputNumbers = convertToIntegerList(st);
        }
        inputNumbers.set(1, 1);
        inputNumbers.set(2, 2);
        int answer = nextMethod(inputNumbers);
        while (answer != 19690720 && answer > 0 ){
            answer = nextMethod(inputNumbers);
            inputNumbers = setSecondThirdNumbers(inputNumbers);
            System.out.println("answer: " + answer);
        } 

    }
}
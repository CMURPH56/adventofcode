class DayFour {




    public static int numberOfOptions(int start, int end) {
        int possibilities = 0;
        for(int i = start; i < end; i++){
            if(adjancentNumbers(i) && neverDecrease(i)){
                possibilities++;
            }
        }
        return possibilities;
    }

    public static Boolean neverDecrease(int input){
        String inputString = String.valueOf(input);

        for(int i = 0; i < inputString.length() - 1; i++){
            int number = inputString.charAt(i);
            int nextNumber = inputString.charAt(i+1);
            if( number > nextNumber){
                return false;
            }
        }
        return true;
    }
    

    public static Boolean adjancentNumbers(int input){
        String inputString = String.valueOf(input);
        String test = "";
        if(input == 666000){
            test = inputString;
            System.out.println("inputString "+ inputString);
        }
        if(inputString.charAt(0) == inputString.charAt(1) && inputString.charAt(1) != inputString.charAt(2)){
            if(!test.equals("")){
                System.out.println("1 " + test);
            }
            return true;
        }
        if(inputString.charAt(0) != inputString.charAt(1) && inputString.charAt(1) == inputString.charAt(2) && inputString.charAt(2) != inputString.charAt(3)){
            if(!test.equals("")){
                System.out.println("2 " +test);
            }
            return true;
        }
        if(inputString.charAt(1) != inputString.charAt(2) && inputString.charAt(2) == inputString.charAt(3) && inputString.charAt(3) != inputString.charAt(4)){
            if(!test.equals("")){
                System.out.println("3 " + test);
            }
            return true;
        }
        if(inputString.charAt(2) != inputString.charAt(3) && inputString.charAt(3) == inputString.charAt(4) && inputString.charAt(4) != inputString.charAt(5)){
            return true;
        }
        if(inputString.charAt(3) != inputString.charAt(4) && inputString.charAt(4) == inputString.charAt(5)){
            if(!test.equals("")){
                System.out.println("5 " +test);
            }
            return true;
        }
        if(inputString.charAt(0) == inputString.charAt(1) && inputString.charAt(1) == inputString.charAt(2)){
            if(!test.equals("")){
                System.out.println("6 " +test);
            }
            return false;
        }
        if(!test.equals("")){
            System.out.println("7 " +test);
        }

        return false;
    }

    public static void main(String args[]){
        int answer = numberOfOptions(235741,706948);
        System.out.println("answer: " + answer);
    }
}
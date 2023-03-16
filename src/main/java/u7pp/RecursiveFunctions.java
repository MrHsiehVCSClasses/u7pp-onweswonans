package u7pp;


public class RecursiveFunctions {
    
    //finds the factoral of i.
    public static double factorial(double i){
        
        if (i <= 1){
            return 1;
        }else{
            return i * factorial( i -1);
        }
    }

    //finds the nth fibonacci number. if you don't knwow what it is, look it up bozo
    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }else if( n <= 2){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    //takes in double for base and int for power. returns base to the power of exp
    public static double pow(double base, int exp){
        if(exp == 0){
            return 1;
        }else if (exp == 1){
            return base;
        }else{
            return pow(base, exp -1) * base;
        }
    }

    //checks if recursive
    public static boolean isPalindrome(String str){
        if(str.length() == 0){
            return true;
        }
        if(str.length()%2 ==1){
            if(str.length() == 1 ){
                return true;
            }else{
                if(str.substring(0, 1).equals(str.substring(str.length()-1))){
                    return isPalindrome(str.substring( 1, str.length()-1));
                }
                return false;
            }
        }else if(str.length()%2 == 0){
            if(str.substring(0, 1).equals(str.substring(str.length()-1))){
                return isPalindrome(str.substring( 0 + 1, str.length()-1));
            }
            return false;
        }else{
            return isPalindrome(str.substring( 0 + 1, str.length()-1));
        }
    }

    //checks if the next num in array is double the previous
    public static int nextIsDouble(int[] ar, int start){
        if(start == ar.length-1 || ar.length == 0){
            return 0;
        }else{
            if(ar[start] == ar[start + 1]/2){
                return nextIsDouble(ar, start+1) +1;
            }
            return nextIsDouble(ar, start +1);
        }
    }

    //Takes in an `int`, and returns a `String` of its binary representation.
    //Precondition: the argument is a positive integer
    public static String getBinary(int dec){
        String retun = "";
        if(dec / 2 == 0){
            if(dec % 2 == 1){
                return "1";
            }else{
                return "0";
            }
        }else{
            if(dec%2 == 1){
                retun = "1";
            }else{
                retun = "0";
            }
            return getBinary(dec/2) + retun ;
        }
    }

    //Takes in an array and a value to search for. If the value is in the array, 
    //it returns the index of the value. Otherwise, return `-1`.
    public static int binarySearch(int[] arr, int value, int bound, int bound2){
        if(bound > bound2){
            return -1;
        }else{
            int middle = (bound + bound2)/2;
            if(arr[middle] < value){
                return binarySearch(arr, value, (bound+bound2)/2 +1, bound2);
            }else if(arr[middle] > value){
                return binarySearch(arr, value, bound, (bound+bound2)/2 -1);
            }else{
                return middle;
            }
        }
    }

    //an area of land is represented as a two dimensional `int` array.
    //The array element represents the elevation of that point on land. 
    //The higher the elevation, the higher the number.
    // has a parameter that represents a map of elevations as 2D `int` array. 
    //It also has parameters that represent the starting location of a drop of water on the map.
    public static boolean canFlowOffMap(int[][] map, int row, int col){
        if(row == map.length-1 || row == 0 || col == 0 || col == map[0].length-1){
            return true;
        }else if (map[row +1][col] < map[row][col] ){
            if(canFlowOffMap(map, row+1, col) == true){
                return true;
            }else{
                if ( map[row -1][col] < map[row][col] ){
                    return canFlowOffMap(map, row -1, col);
                }else if (map[row][col +1] < map[row][col]){
                    return canFlowOffMap(map, row, col +1);
                }else if (map[row][col -1] < map[row][col] ){
                    return canFlowOffMap(map, row, col -1);
                }
            }
        }else if (map[row -1][col] < map[row][col] ){
            if(canFlowOffMap(map, row-1, col) == true){
                return true;
            }else{
                if ( map[row +1][col] < map[row][col] ){
                    return canFlowOffMap(map, row +1, col);
                }else if (map[row][col +1] < map[row][col] ){
                    return canFlowOffMap(map, row, col +1);
                }else if (map[row][col -1] < map[row][col] ){
                    return canFlowOffMap(map, row, col -1);
                }
            }
        }else if (map[row][col +1] < map[row][col] ){
            if(canFlowOffMap(map, row, col +1) == true){
                return true;
            }else{
                if ( map[row -1][col] < map[row][col] ){
                    return canFlowOffMap(map, row -1, col);
                }else if (map[row+1][col] < map[row][col] ){
                    return canFlowOffMap(map, row+1, col);
                }else if (map[row][col -1] < map[row][col] ){
                    return canFlowOffMap(map, row, col -1);
                }
            }
        }else if (map[row][col -1] < map[row][col] ){
            if(canFlowOffMap(map, row, col -1) == true){
                return true;
            }else{
                if ( map[row -1][col] < map[row][col] ){
                    return canFlowOffMap(map, row -1, col);
                }else if (map[row][col +1] < map[row][col] ){
                    return canFlowOffMap(map, row, col +1);
                }else if (map[row +1][col] < map[row][col] ){
                    return canFlowOffMap(map, row +1, col);
                }
            }
        }
        return false;
    }
}

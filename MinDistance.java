public class MinDistance{

    public static int distance(byte target, byte[] numbers) {
        /* purpose: determine the minimal distance between any
         *          two instances of target in the numbers array
         * input  : target is the number we are looking for
         *          numbers is an array of numbers
         * output : the method returns
         *           o) the minimal distance between any two instances
         *              of target in the numbers array, if there are
         *              at least two instances of target present, or
         *           o) -2 if target is not in the numbers array, or
         *           o) -1 if target appears only once in the numbers array
         */

        int minimum_distance = numbers.length;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((target == numbers[i] && target == numbers[j]) && minimum_distance > (j - i)) {
                    minimum_distance = (j - i);
                }
            }
            if (target == numbers[i]) {
                count++;
            }
        }
        if (count == 0) {
            return -2;
        }
        if (count == 1) {
            return -1;
        }
        return minimum_distance - 1;
    }

    /*
      main method can be used for basic test cases. Modify the method to add
    more test cases. Your main method will NOT be graded. But, be sure it does
    cause your class to not compile.
    */
    public static void main(String[] args){
        byte[] N = {5 , 3 , 7 , 2 , 3 , 4 , 4 , 7 , 3 , -1 , 3 , 4 , 7 , 5};
        System.out.println( distance((byte)5, N));
        System.out.println( distance((byte)4, N));
        System.out.println( distance((byte)7, N));
        System.out.println( distance((byte)3, N));
        System.out.println( distance((byte)2, N));
        System.out.println( distance((byte)13, N));
    }
}
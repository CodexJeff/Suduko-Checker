public class SudokuChecker {
    /** sample valid game */
    public static byte[][] example1 = new byte[][]{
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}};

    /** sample invalid game */
    public static byte[][] example2 = new byte[][]{
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,3},
            {2,8,7,4,1,9,6,2,6},
            {3,4,5,2,8,6,1,8,8}};

    /** checks if row 'row' is OK in the grid */
    public static boolean checkRow(int row, byte[][] grid) {
        for (int i = 0; i < grid[row].length; i++) {
            for(int j = i + 1; j < grid[row].length; j++) {
                if (grid[row][i] == grid[row][j])
                    return false;
            }
        }
        return true;
    }

    /** checks if column 'col' is OK in the grid */
    public static boolean checkColumn(int col, byte[][] grid){
        for (int i = 0; i < grid[col].length; i++) {
            for(int j = i + 1; j < grid[col].length; j++) {
                if (grid[i][col] == grid[j][col])
                    return false;
            }
        }
        return true;
    }

    /** checks if the subregion 'region' is OK in the grid */
    public static boolean checkSubregion(int region, byte[][] grid) {
        for (int num = 1; num <= 9; num++) {
            boolean error = true;
            while (!error){
                for (int row = region; row < region + 3; row++) {
                    for (int col = region; col < region + 3; col++) {
                        if(grid[row][col] == num){
                            error = true;
                            break;

                        }

                    }

                }
            }
        }
        return true;
    }

    public static boolean check(byte[][] grid){
        for(int row=0; row<9; row+=1){                    // check the rows
            if( !checkRow(row, grid) ){
                return false;
            }
        }
        for(int col=0; col<9; col+=1){                    // check the rows
            if( !checkColumn(col, grid) ){
                return false;
            }
        }
        for(int subregion=0; subregion<9; subregion+=1){  // check the subregions
            if( !checkSubregion(subregion, grid) ){
                return false;
            }
        }

        // if we get this far then we conclude that the grid
        // must be valid (because if it was not, we would have
        // returned false somewhere above)
        return true;
    }


    public static void main(String[] args){

        System.out.print("exmample1 | expected output is true  | actual output is ");
        System.out.println(check(example1));

        System.out.print("exmample2 | expected output is false | actual output is ");
        System.out.println(check(example2));

    }
}
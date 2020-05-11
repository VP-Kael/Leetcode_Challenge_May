/*
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 Check if these points make a straight line in the XY plane.

 Example 1:
    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

 Example 2:
    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false
 */

public class Day8_CheckIfItIsaStraightLine {
    public static void main(String[] args){
        int[][] coordinates = new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        Day8_CheckIfItIsaStraightLine test = new Day8_CheckIfItIsaStraightLine();
        System.out.println(test.checkStraightLine(coordinates));
    }


    public boolean checkStraightLine(int[][] coordinates) {
        double slope = Math.abs(
                ((double)coordinates[0][0] - (double)coordinates[1][0]) /
                        ((double)coordinates[0][1] - (double)coordinates[1][1]));
        for(int i=2; i<coordinates.length; i++){
            if( slope != Math.abs(
                    ((double)coordinates[0][0] - (double)coordinates[i][0]) /
                            ((double)coordinates[0][1] - (double)coordinates[i][1]))){
                return false;
            }
        }
        return true;
    }
}

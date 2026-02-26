package data_structure_2026.recursion.bt;

import java.util.ArrayList;
import java.util.List;

class Pair{
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
public class RatInMaze {

    private static final int[] dRow = {1, 0, -1, 0};
    private static final int[] dCol = {0, 1, 0, -1};
    private static final char[] move = {'D', 'R', 'U', 'L'};

    public static void main(String[] args) {
         int[][]maze=new int[][]{
                 {1,0,0,0},
                 {1,1,0,1},
                 {1,1,0,0},
                 {0,1,1,1}
         };
         boolean[][]visited = new boolean[maze.length][maze[0].length+1];
        List<String> path = new ArrayList<>();
//        path.add(new Pair(0, 0));
         maze(maze,0,0,visited,path,new StringBuilder("Start->"));
        System.out.println(path);
    }

    private static void solve(int[][]maze, int row, int col, List<Pair>res,boolean[][]visited,StringBuilder path){
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(res);
            System.out.println(path);
            return;
        }

        if(isSafe(maze, row, col, visited)){
            if(row<maze.length-1 && maze[row+1][col]!=0){
                Pair pair = new Pair(row+1,col);
                res.add(pair);
                visited[row][col]=true;
                path.append("D");
                solve(maze,row+1,col,res,visited,path);
                res.remove(res.size()-1);
                visited[row][col]=false;
                path.setLength(path.length()-1);
            }

            if(col<maze[0].length-1 && maze[row][col+1]!=0){
                Pair pair = new Pair(row,col+1);
                res.add(pair);
                visited[row][col]=true;
                path.append("R");
                solve(maze,row,col+1,res,visited,path);
                res.remove(res.size()-1);
                visited[row][col]=false;
                path.setLength(path.length()-1);
            }

            if(row>0 && maze[row-1][col]!=0){
                Pair pair = new Pair(row-1,col);
                res.add(pair);
                visited[row][col]=true;
                path.append("U");
                solve(maze,row-1,col,res,visited,path);
                res.remove(res.size()-1);
                visited[row][col]=false;
                path.setLength(path.length()-1);
            }
            if(col>0 && maze[row][col-1]!=0){
                Pair pair = new Pair(row,col-1);
                res.add(pair);
                visited[row][col]=true;
                path.append("L");
                solve(maze,row,col-1,res,visited,path);
                res.remove(res.size()-1);
                visited[row][col]=false;
                path.setLength(path.length()-1);

            }
        }
    }

    private static void maze(int[][]maze, int row, int col, boolean[][]visited,List<String> res,StringBuilder directions){
        if(row==maze.length-1 && col==maze[0].length-1){
            res.add(directions.toString());
            return;
        }

        visited[row][col]=true;

        for(int i=0;i<4;i++){
            int newRow = row+ dRow[i];
            int newCol = col+ dCol[i];

            if(isSafe(maze,newRow,newCol,visited)){
                directions.append(move[i]);
                maze(maze,newRow,newCol,visited,res,directions);
                //backtrack
                directions.deleteCharAt(directions.length()-1);
            }

        }
        visited[row][col]=false;
    }

    private static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && !visited[row][col] && maze[row][col]!=0;
    }
}

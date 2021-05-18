package Day1;

public class Sol {
    public static void main(String[] args) {
      int [][]  stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
      MostStoneRemoved s=new MostStoneRemoved();
      MostStoneRemovedDFS dfs = new MostStoneRemovedDFS();
     // int x=s.removeStones(stones);
      int y=dfs.removeStones(stones);
     // System.out.println(x);
      System.out.println(y);
    }
}

class Solution {
  public static ArrayList<Integer> getSimplePath (List<ArrayList<Integer>> adjList, int node1, int node2) {
      // iterate through the adj list
      Set <Integer> visited = new HashSet<>();
      Map <Integer, Integer> prevMap = new HashMap<>();
      
  }

  public static void main(String[] args) {
    List<ArrayList<Integer>> adjList = new ArrayList <>();
    adjList.add(new ArrayList<>(Arrays.asList(1)));
    adjList.add(new ArrayList<>(Arrays.asList(0,2,5,4)));
    adjList.add(new ArrayList<>(Arrays.asList(1,4,5)));
    adjList.add(new ArrayList<>());
    adjList.add(new ArrayList<>(Arrays.asList(5,2,1)));
    adjList.add(new ArrayList<>(Arrays.asList(1,2,4)));

    for (ArrayList <Integer> l : adjList){
      System.out.println("========");
      for (Integer e : l) {
        System.out.println(e);
      }
    }
    
    int node1 = 0;
    int node2 = 0;

    ArrayList<Integer> path = getSimplePath (adjList, node1, node2);
    for (Integer p : path) {
      System.out.println(p);
    }
  }
}

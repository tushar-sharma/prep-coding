/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent
 * 
 * Test Cases : 
 *
 * 
 5
 [[4,5],[4,3],[2,3],[3,5],[2,4]]

 4
 [[1,2],[3,4]]

 5
 [[4,1],[4,2],[4,3],[2,5],[1,2],[1,5]]

 8
 [[7,4],[3,7],[1,5],[5,4],[7,1],[3,1],[4,3],[6,5]]
 
 8
 [[1,7],[5,4],[2,8],[7,5],[2,4],[2,7],[4,3],[5,1],[3,1]]
 */
class Solution {
    
    //adjacenyList 
    //it maps vertex to the list of connected vertices
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    
    public  void addEdges(int[][] paths) {
        
        for (int i = 0; i < paths.length; i++) {
            
            if (adjacencyList.containsKey(paths[i][0])) {
                
                List<Integer> updatedEdges = adjacencyList.get(paths[i][0]);
                updatedEdges.add(paths[i][1]); //returns true
                adjacencyList.put(paths[i][0], 
                                  updatedEdges);
                
            } else {
                List<Integer> updatedEdges = new ArrayList<>();
                updatedEdges.add(paths[i][1]);
                adjacencyList.put(paths[i][0],
                                 updatedEdges);
            }
                        
            if (adjacencyList.containsKey(paths[i][1])) {
                
                List<Integer> updatedEdges = adjacencyList.get(paths[i][1]);
                updatedEdges.add(paths[i][0]); //returns true
                adjacencyList.put(paths[i][1], 
                                  updatedEdges);
                
            } else {
                List<Integer> updatedEdges = new ArrayList<>();
                updatedEdges.add(paths[i][0]);
                adjacencyList.put(paths[i][1],
                                 updatedEdges);
            }
        }  

    }
    
    /*
    Since it's bidirectional
    outEdges = inEdges
    */
    public List<Integer> outEdges(int n) {
        return adjacencyList.get(n);
    }

    
    public int[] gardenNoAdj(int N, int[][] paths) {
        
        if (N <= 0) {
            return new int[]{};
        } else if (N == 1) {
            return new int[]{1};
        }
        
        if (paths.length == 0) {
            int[] ret = new int[N];
            Arrays.fill(ret, 1);
            return ret;
        }
        
        
        addEdges(paths);
        int[] output = new int[N];
        int gardenType = 1;
        
        //find the minimum vertex
        int startPos = Integer.MAX_VALUE, index = 0;
        
        for(Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()){
            int key = entry.getKey();
            if (startPos > key){
                startPos = key;
            }
        }
        
        for (int garden = 1; garden <= N; garden++) {
        
            List<Integer> edges = outEdges(garden);
            
            if (edges == null){
                output[index++] = 1;
                continue;
            }
            
            boolean startOver = true; 
            int maxValue = Integer.MIN_VALUE;
            
            
            Set<Integer> possibleType = new HashSet<>();
            
            for (Integer edge : edges) {
                possibleType.add(output[edge - 1]);

                if (edge == startPos || output[edge - 1] == 1) {
                    startOver = false;
                }
                
            }

            if (startOver) {
                gardenType = 1;
            }
            
            else {

                for (int i = 1; i <= 4; i++){
                    if (!possibleType.contains(i)) {
                        gardenType = i;
                        break;
                    }
                }
             
            }
            
            output[index++] = gardenType;
                        
        }
        
        return output;
        
    }
}

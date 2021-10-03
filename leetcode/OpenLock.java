/**
  Remember : 
  1. increment a character in string
     e.g. char a = 'a';
          char b = (char) (a + 1);

    Alternatively

          char a = 'a'; 
          String b  = "" + (a - '0' + 1); 
       
     
  2. ASCII values for 0 is 48 and 9 is 57 
                      a is 97 and z is 122
                      A is 65 and Z is 90
  
  3. Modifiy a character in a string at location i
     e.g. String newText = text.substring(0, i) + modifiedChar + text.substring(i + 1);
     
  4. think BFS when calculating *minimum*
  
  5. Offer and poll with Queue using ArrayDeque

  6. Simple BFS template 

      queue = queue() 

      queue.offer(value)

      while (! queue is not empty): 

          size = queue.size

          while (size > 0 ) 

              value = queue.poll()


              if not visited 
                  queue.offer(value)

              size--

       

          
 */
class Solution {
    
    public int openLock(String[] deadends, String target) {

        int minimumTurns = -1;
        
        String start = "0000";
        
        Set<String> visited = new HashSet<>();
        
        for (String deadend : deadends){
            visited.add(deadend);
        }
        
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
                
        int countWays = 0;
        
        while (!queue.isEmpty()){
            
            int size = queue.size();
            
            while (size > 0 ) {
                
                String currentStart = queue.poll();
                
                
                if (visited.contains(currentStart)){
                    size--;
                    continue;
                }
                
                
                if (target.equals(currentStart)){
                    return countWays;
                }
                
                StringBuilder sb = new StringBuilder(currentStart);
                
                for (int i = 0; i < 4; i++){
                    
                    char currentStartChar =  sb.charAt(i);
                    
                    String upCurrentStart = currentStart.substring(0, i) + (currentStartChar == '9' ? 0 :(currentStartChar - '0' + 1) ) + currentStart.substring(i + 1);
                    
                    String downCurrentStart = currentStart.substring(0, i) + (currentStartChar == '0' ? 9 : (currentStartChar - '0' - 1) ) + currentStart.substring(i + 1);
                    
                    if (!visited.contains(upCurrentStart)) {
                        queue.offer(upCurrentStart);
                    }
                    
                    if (!visited.contains(downCurrentStart)){
                        queue.offer(downCurrentStart);
                    }
                }
                
                visited.add(currentStart);
                
                size --;
                
            }
            
            countWays++;
            
        }
        
        
        return minimumTurns;
        
    }
}
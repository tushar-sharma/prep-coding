class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int numberOfMatchings = 0;
        
        int i = 0, j = 0;
        
        while (i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                numberOfMatchings++;
                i++;
                j++;
            } else{
                j++;
            }           
        }
        
        return numberOfMatchings;
    }
}

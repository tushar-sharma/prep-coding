impl Solution {
    pub fn match_players_and_trainers(mut players: Vec<i32>, mut trainers: Vec<i32>) -> i32 {
        
        players.sort();
        
        trainers.sort();
    
        let (mut i, mut j, mut number_of_matching) = (0, 0, 0);
        
        while i < players.len() && j < trainers.len() {
            if (&players[i] <= &trainers[j]){
                i += 1;
                number_of_matching += 1;
            } 
            j += 1; 
        }
        return number_of_matching;
    }
}

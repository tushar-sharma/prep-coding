var matchPlayersAndTrainers = function(players, trainers) {
    
    players.sort((a, b) => {
       return a - b; 
    });
    
    trainers.sort( (a, b) => {
       return a - b; 
    });
    
    let i = 0, j = 0; 
    let numberOfMatching = 0;
    
    while (i < players.length && j < trainers.length){
        if(players[i] <= trainers[j]){
            numberOfMatching += 1;
            i++;
        }
        j++;
    }
    return numberOfMatching;
};

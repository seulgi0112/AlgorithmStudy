/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
var groupThePeople = function(groupSizes) {

    var output = [], group = [];
    
    groupSizes.forEach(function(v, i){
        if(group[v]){
            group[v].push(i);
        } else {
            group[v] = [i];
        }

        if(group[v].length == v){
            output.push(group[v]);
            group[v] = [];
        }
        
    });
    return output;
};

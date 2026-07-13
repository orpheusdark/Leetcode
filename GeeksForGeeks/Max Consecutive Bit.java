//         // code here
//         int count = 1;
//         for(int i = 1; i <arr.length; i++){
//             int a = arr[0];
//             if (a == arr[i]){
//                 count ++;
//                 a = arr[i+1];
//             }
//             else
//             count 
//         }
//         return count;
//     }
// }

class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int count = 1;
        int max = 1;
        int test = arr[0];
        for(int i = 1; i < arr.length ; i++){
            if(test == arr[i]){
                count++;
                if(max < count){
                    max = count;
                }
            }
            else{
                count = 1;
                test = arr[i];
            }
        }
        return max;
    }
}
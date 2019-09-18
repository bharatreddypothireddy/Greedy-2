//Time: O(n)
//Space: O(n)
//LeetCode : Yes

//Approach:
//1.Have an array of length ratings and all values 1 since each child has to get atleast 1 candy.
//2.Now go from left to right of array . Start from 2nd position and check if current rating is higher than previous child's rating
// 3. If greater , add 1 more to previous child's value and store it as the current child's rating .Do this for all elements till the right most element.
// 4.Now start from last before element and go from right to left.If current rating is greater than next rating store current rating as maximum of 
// already present rating and 1+next child's value as the current child should have more candies than neighbours if he has a higher rating.
class Solution {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        for(int i = 0;i<result.length;i++)  result[i] = 1;
        for(int i = 1;i<result.length;i++){
            if(ratings[i]>ratings[i-1])   result[i] = result[i-1]+1;
        }
        for(int i = result.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                result[i] = Math.max(result[i],result[i+1]+1);
        }
        int count = 0;
        for(int i = 0;i<result.length;i++)
            count+=result[i];
        return count;
    }
}

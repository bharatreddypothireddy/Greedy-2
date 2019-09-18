//Time : O(n)
//Space : o(1)
//leetcode : Yes

//Approach:
//1.Traverse through tasks array and find maximum frequency any task can have and number of such tasks.
//2.Now for task that has max frequency it needs to have n ideal states between same task can occur again.If only one task with max frequency
//  then there needs to n ideal states between 2 same tasks and totally there will be n times (maxfrequency-1) empty ideal states.
//3.If there are multiple tasks with same max frequency then they can be combined together and now empty slots will be 
//(maxfrequency-1) times (n-(tasks with same max frequency - 1).Now these remaining empty slots can be filled by task with less frequency
// 4. No2 ideal states can be maximum of(0,total empty slots - slots occupied by less frequency tasks)
// 5. Finally return total tasks+ideal states.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] result = new int[26];
        int max = 0;
        int maxcount = 0;
        for(char task:tasks){
            result[task-'A']++;
            if(result[task-'A'] == max)  {
                maxcount++;
            }  
            if(result[task-'A']>max){
                max = result[task-'A'];
                maxcount = 1;
            }
        }
        int partcount = max-1;
        int emptySlots = partcount*(n-(maxcount-1));
        int availableslots = tasks.length - maxcount*max;
        int idleslots = Math.max(0,emptySlots-availableslots);
        return idleslots+tasks.length;
    }
}

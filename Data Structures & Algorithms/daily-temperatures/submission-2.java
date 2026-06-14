class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] pair = stack.pop();
                warmer[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return warmer;
    }
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int[] warmer = new int[temperatures.length];
    //     for (int i = 0; i < temperatures.length; i++) {
    //         for (int j = i+1; j < temperatures.length; j++) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 warmer[i] = j-i;
    //                 break;
    //             }
    //             warmer[i] = 0;
    //         }
            
    //     }

    //     return warmer;
    // }
}

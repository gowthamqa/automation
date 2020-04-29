package interview;

import java.util.HashMap;

public class TotalNoSubArraysWhoseSumEqualsToK {

    public static void main(String []args){

        //int arr[] = { 10, 2, -2, -20, 10 };
        //int sum = -10;
        //int arr[] = { 3, 7, 2, 1, 20 };
        //int sum = 10;
        int arr[] = {9, 4, 20, 3, 10, 5};
        int sum = 33;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
        System.out.println(subarraySumBruteForce(arr,sum));
    }

    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum = sum + nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // Function to find number of subarrays
    // with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int sum)
    {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count+1);
        }

        return res;
    }


}

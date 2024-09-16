//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param A
     * @param N
     * @param K
     * @return
     */
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int size = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1);
        for (int i = 0; i < N; i++) { // TC: O(N)
            sum += A[i];
            int diff = sum - K;
            if (hm.containsKey(diff)) {
                size = Math.max(size, i - hm.get(diff));
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return size;
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param A
     * @param N
     * @param K
     * @return
     */
    public static int lenOfLongSubarrBruteForce(int A[], int N, int K) {
        int size = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                if (sum == K) {
                    size = Math.max(size, j - i + 1);
                }
            }
        }
        return size;
    }
}

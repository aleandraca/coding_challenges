

### **Problem: Golden Leader**

You are given a non-empty array A consisting of N integers.

The **leader** of this array is the value that occurs in **more than half** of the elements of 

Your task is to write an efficient function that, given the array A, returns the value of the leader. If the array does not have a leader, your function should return \-1.

**Example 1:**

* **Input:** ```A = [6, 8, 4, 6, 8, 6, 6]```  
* **Output:** 6  
* **Explanation:** The array has 7 elements. The value 6 appears 4 times, which is more than ```7 / 2 = 3.5```. Therefore, 6 is the leader.

**Example 2:**

* **Input:** ```A = [1, 1, 2, 2, 3]```  
* **Output:** ```-1```  
* **Explanation:** The array has 5 elements. No value appears more than ```5 / 2 = 2.5``` times. The array has no leader.

**Example 3:**

* **Input:** ```A = [1, 1, 2, 2]```  
* **Output:** ```-1```  
* **Explanation:** The value 1 appears 2 times, and the value 2 appears 2 times. Neither count is strictly greater than ```4 / 2 = 2```. There is no leader.

**Constraints:**

* N is an integer within the range ```[1..100,000]```.  
* Each element of array A is an integer within the range ```[0..1,000,000,000]```.
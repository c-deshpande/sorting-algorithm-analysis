# Sorting Algorithms Analysis
Analyzing efficiency of different sorting algorithm in terms of their time complexities.

The algorithms covered are as follows,  
•	Merge Sort  
•	Heap Sort  
•	Quick Sort (Using 3 median method)  
•	Insertion Sort  
•	Bubble Sort 

Each of these algorithm's worst case time complexities are as follows,  

| Algorithm  | Worst Case Time Complexity |
| ------------- | ------------- |
| Merge Sort  | O(n log(n))  |
| Heap Sort  | O(n log(n))  |
| Quick Sort  | O(n^2)  |
| Insertion Sort  | O(n^2)  |
| Bubble Sort  | O(n^2) |

Algorithm runtimes with respect to array size with n random numbers,  

![Efficiency Graph](https://github.com/c-deshpande/sorting-algorithm-analysis/blob/master/images/efficiency_graph.png)  
*The time is in nano seconds*

Running the program,  
  
A menu driven interface will open when the code is executed.  
For example,  

	Enter number of elements:   
	25  
    
	What do you want to do?  
	1. Generate 25 random numbers for sorting  
	2. Enter 25 numbers for sorting  
	1  
    
	=>If the user selects 2, elements have to be inserted manually.  
	  
	The data is: [2199, 2782, 1183, 2917, 4566, 1962, 2974, 91, 2428, 1409, 2941, 2049, 4893, 3731, 633, 1446, 1582, 2224, 99, 3683, 4981, 2518, 3652, 1904, 1126]  
	Select a sorting algorithm to use:  
	1. Merge Sort  
	2. Heap Sort  
	3. Quick Sort (Median of 3 method)  
	4. Insertion Sort  
	5. Bubble Sort  
	6. Exit  
  
Here according to the algorithm selected we would get the sorted array.  
For example,  
  
	Sorting using Insertion Sort:  
	Original Array: [2199, 2782, 1183, 2917, 4566, 1962, 2974, 91, 2428, 1409, 2941, 2049, 4893, 3731, 633, 1446, 1582, 2224, 99, 3683, 4981, 2518, 3652, 1904, 1126]  
	Sorted Array: [91, 99, 633, 1126, 1183, 1409, 1446, 1582, 1904, 1962, 2049, 2199, 2224, 2428, 2518, 2782, 2917, 2941, 2974, 3652, 3683, 3731, 4566, 4893, 4981]    
	Execution time: 4000ns.  

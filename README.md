# Mini-Project 6: Sorting-Mini-Project
Due: Thursday, April 4th, 2024

Acknowledgements: The online resources I used for this project were the insertion sort reading, the merge sort reading, and the quicksort reading.
I also used the Javadoc Oracle about arrays.I also referenced the MergeSort lab which I worked on with Rommin Adl and the QuickSort lab which I worked on with Medhashree Adhkilari. I also worked with Medhashree to talk about ideas for the mini-project. I got help from the tutors: Peter, Ishitha, Boston, Simon, Diogo, Peter, Audrey, and Jayson. I also recieved help from Professor Rebelsky.

Short Description: The program implements four different types of sorts: InsertionSort, MergeSort, QuickSort, and our own personal sort. 
Insertion Sort compares the value at the previous index and the current index. If the previous index is greater than the current index, then they will swap having the value at the current index become the value at the previous index and the value at the previous index become the value at the current index. MergeSort recursively divides the array into halves, and recursively merges the halves back together in the order of the values. 
QuickSort picks a pivot to compare the lower bound and the upper bound to. It uses these sorting algorithms along with the sorting method from the sorting interface to sort the values in the array in ascending order. My own personal sort, TrappAlyssaSort is inspiried by merge sort. It's inspired by merge sort because it creates a copy of the original array to store it in the new array. Instead of comparing the left, middle, and right like in mergesort, it compares the value at the current index to the value stored at the midpoint to determine if the value should be sorted in the front or the back of the array. 


Instructions for Running the Program: Go to the SortTester.java to run the tests to see if the tests pass. 
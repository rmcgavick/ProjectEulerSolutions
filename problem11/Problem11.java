package problem11;
// this prog successfully solves problem11 on ProjectEuler in ~0.04 seconds
// It finds the largest product of four adjacent numbers in a grid, in this
// case, adjacent can mean up, down, left, right, or diagonally
// 
// I wrote the GridObj.java class to solve this problem, which stores each object in the below "grid"
// as a GridObj object. Each GridObj knows its value and its X and Y position in the grid.
// 
// two methods that help convert grid to and from a string: one (fillArrayFromGrid()) takes a string grid 
// (like "grid" below) and puts it into a 2d array of GridObj's (must be n X n square matrix) 
// another method (printArrayIntoGrid()) takes that 2d array of GridObj's (must be n X n) and prints it out into a grid
//
// copy() is just a quick method I wrote to do a deep copy of one GridObj array to another
//
// the solve() method runs through each item in this 2d gridObj array, and calls the findAdjProduct()
// method on each GridObj. The findAdjProduct() method runs a check with the next 3 numbers in all 8 directions 
// (up, down, left, right, and diagonally) and multiplies those 4 numbers together. This method also accounts for 
// hitting the edge of the grid and for multiplying by 0's. solve() keeps track of the largest sum of 4 numbers
// and their corresponding positions in the grid, and when it is done, returns the 4 GridObj's with the largest product



import java.util.Scanner;


public class Problem11 {
	static long startTime = System.nanoTime();
	static GridObj[][] gridArray;
	static int n = 20; // This is the value for the n X n grid
	
	static String grid = 	"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " +
							"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " +
							"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " +
							"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " +
							"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " +
							"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " +
							"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " +
							"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " +
							"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " +
							"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " +
							"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " +
							"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " +
							"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " +
							"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " +
							"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " +
							"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " +
							"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " +
							"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " +
							"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " +
							"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 ";

	// value of n assumes it is a n X n grid
	public static GridObj[][] fillArrayFromGrid(String gridStr, int n) {
		Scanner in = new Scanner(gridStr);
		GridObj sol[][] = new GridObj[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = new GridObj((int)in.nextInt(), i, j);
			}
		}
		return sol;
	}
	
	// again, n assumes n X n grid
	public static String printArrayIntoGrid(GridObj[][] arr, int n) {
		String newGrid = "";
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%02d  ", arr[i][j].getVal());
			}
			System.out.println();
		}
		return newGrid;
	}
	
	// here is the method that takes a number x and a 2d array of GridObj's
	// it starts at x, then checks all adjacent numbers in the grid in a straight 
	// line of 4 in all directions from x. It check in 8 directions, (provided it
	// doesn't run into the edge of the "grid," and return the string of 4 grid objects
	// that have the largest product when multiplied
	public static GridObj[] findAdjProduct(GridObj[][] gridObjArr, GridObj go) {
		GridObj[] adjNums = new GridObj[4];
		GridObj[] tempNums = new GridObj[4];
		int min = 0;
		int max = n-1;
		tempNums[0] = go;
		int currentX = go.getxPos();
		int currentY = go.getyPos();
		int sum = 0;
		int temp = 0;
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check down from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX + i > max)
				break;
			else {
				tempNums[i] = gridObjArr[currentX+i][currentY];
				temp *= gridObjArr[currentX+i][currentY].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check up from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX - i < min)
				break;
			else {
				tempNums[i] = gridObjArr[currentX-i][currentY];
				temp *= gridObjArr[currentX-i][currentY].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check right from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentY + i > max)
				break;
			else {
				tempNums[i] = gridObjArr[currentX][currentY+i];
				temp *= gridObjArr[currentX][currentY+i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check left from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentY - i < min)
				break;
			else {
				tempNums[i] = gridObjArr[currentX][currentY-i];
				temp *= gridObjArr[currentX][currentY-i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}		
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check down-right diagonal from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX + i > max || currentY + i > max)
				break;
			else {
				tempNums[i] = gridObjArr[currentX+i][currentY+i];
				temp *= gridObjArr[currentX+i][currentY+i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}		
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check up-left diagonal from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX - i < min || currentY - i < min)
				break;
			else {
				tempNums[i] = gridObjArr[currentX-i][currentY-i];
				temp *= gridObjArr[currentX-i][currentY-i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}	
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check down-left diagonal from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX + i > max || currentY - i < min)
				break;
			else {
				tempNums[i] = gridObjArr[currentX+i][currentY-i];
				temp *= gridObjArr[currentX+i][currentY-i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}	
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Check up-right diagonal from x //
		for(int i = 1; i <= 3; i++) {
			temp = go.getVal();
			if(currentX - i < min || currentY + i > max)
				break;
			else {
				tempNums[i] = gridObjArr[currentX-i][currentY+i];
				temp *= gridObjArr[currentX-i][currentY+i].getVal();
			}
		}
		if(temp > sum) {
			sum = temp;
			adjNums = copy(tempNums);
		}	
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
		// Final check to handle case when product of adjacent numbers == 0
		if(sum == 0) {
			for(int i = 0; i < 4; i++) {
				adjNums[i] = new GridObj(0);
			}
		}			
		return adjNums;
	}
	
	public static String solve() {
		GridObj[] test = new GridObj[4];
		GridObj[] real = new GridObj[4];
		int testSum = 0;
		int realSum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
					test = findAdjProduct(gridArray, gridArray[i][j]);
					testSum = ((test[0].getVal()) * (test[1].getVal()) * (test[2].getVal()) * (test[3].getVal()));
				if (testSum > realSum) {
					realSum = testSum;
					real = copy(test);
				}
			}
		}
		return ("" + real[0] + ", " + real[1] + ", " + real[2] + ", " + real[3] + "\nSum = " + realSum);
	}
	
	public static GridObj[] copy(GridObj[] n) {
		int len = n.length;
		GridObj[] ret = new GridObj[len];
		for(int i = 0; i < len; i++) {
			ret[i] = n[i];
		}
		return ret;
	}
	
	public static void main(String[] args) {
		gridArray = fillArrayFromGrid(grid, n);
		System.out.print(printArrayIntoGrid(gridArray, n));
		System.out.println(solve());
		
		// print how long the program took to finish
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}

}

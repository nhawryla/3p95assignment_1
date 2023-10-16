// Nathan Hawrylak, 7268774

import java.util.Random;

public class Bubble {

	
	Bubble(){
		
		Random r = new Random(); // creates object of random class
		
		int size = r.nextInt(20); // generates size within rang 0..20 without range can generate to large number or negative numb
		
		int[] arr = new int[size]; // creates array with new random size
		
		for (int z = 0; z < size; z++){ // goes through array and randomly sets all values
			
			int rand = r.nextInt();
			
			arr[z] = rand;
		}
		
		for (int z = 0; z < size; z++){ // prints array values
			
			System.out.print(arr[z] + " ");
		}
		
		System.out.println();
		
		int[] newArray = sort(size, arr); // sorts the array and stores into new array
		
		for (int z = 0; z < size; z++){ // prints new array values
			
			System.out.print(newArray[z] + " ");
		}
		
		System.out.println();
		
		boolean check = true; // check variable if sorted wrong will be false otherwise true 
		
		for (int z = 0; z < size-1; z++){ // runs through new array making sure values fall in correct order
			
			if (newArray[z] > newArray[z+1]){
				
				check = false; // if value doesnt then check will becoe false
			}
		}
		
		System.out.println(check);
	}
	
	int[] sort(int size, int[] arr){ // sort method
		
		for (int z = 0; z < size; z++){ // runs n^2 time for each value must run n times therefore n*n
			for (int x = 0; x < size-1; x++){
				
				if (arr[x] > arr[x+1]){ // checks if p1 is greater then p2 if so switches positions
					
					int temp = arr[x];
					arr[x] = arr[x+1];
					arr[x+1] = temp;
				}
			}	
		}
		
		return arr; // returns sorted array
	}
	
	public static void main(String[] args){
		
		Bubble b = new Bubble();
	}
}

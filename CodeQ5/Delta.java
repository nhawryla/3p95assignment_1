// Nathan Hawrylak, 7268774

public class Delta {

	
	Delta(){
		
		DeltaDebugging("8665");
	}
	
	void DeltaDebugging(String in){ // takes in input 
		
		if (proc(in)){ // checks if there is an error in the input if not does not continue
			
			int len = in.length()/2; // gets a number representing half the length of the input
			
			if (len != 0){ // checks to see if this is a leaf or branch (leafs will no longer continue meaning half there length when rounded down will be 0
				
				String InL = ""; // left half
				String InR = ""; // right half
				
				for (int z = 0; z < in.length(); z++){
					
					if (z >= len){ // adds half the chars to the left and the other half to the right splitting the string in half
						
						InL += in.charAt(z);
					} else {
						
						InR += in.charAt(z);
					}
				}
				
				DeltaDebugging(InL); // runs the method again on the left and right halves
				DeltaDebugging(InR);
				
			} else { // when a leaf is reached we already know this input contains an error so we can assume that this last char is the error in the code
				
				System.out.println("Bug in code is " + in);
			}
		}
		
	}
	
	Boolean proc(String in){ // the main function we are testing on
		
		String out = "";
		
		for (int z = 0; z < in.length(); z++){
			
			if (Character.isUpperCase(in.charAt(z))){
				
				out += Character.toLowerCase(in.charAt(z));
				
			} else if (Character.isDigit(in.charAt(z))){ // we know that the error will lie in this part of the code so it is modified
				
				String t = "";
				t += in.charAt(z)*2; // sets t to the char value (or ASCII )multiplied by 2
				
				int v = in.charAt(z) - '0'; // this will give the actual numerical value represented by the char '3'-'0' = 3
				
				if (v*2 != Integer.parseInt(t)){ // when found incorrect will return true meaning an error was found
					
					return true;
				} else {
					
					out += in.charAt(z)*2;
				}
			} else {
				
				out += Character.toUpperCase(in.charAt(z));
			}
		}
		
		return false; // if no error is found false is returned
	}
	
	
	
	public static void main(String[] args){
		
		Delta d = new Delta();
	}
}

package QuadRes;
import java.util.*;

public class Driver {

	public static void main(String [] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Enter a positive integer");
		int num = kbd.nextInt();
		System.out.println("Enter a prime number greater than 2");
		int prime = kbd.nextInt();
		while(!(isPrime(prime)) || prime == 2){
			System.out.println("Try again");
			prime = kbd.nextInt();
		}
		kbd.close();
		if(num%prime == 0) {
			System.out.println("Legendre Symbol is 0");
			System.exit(0);
		}
		ArrayList<Integer> primeFact = primeFact(num);
		ArrayList<Integer> outputs = new ArrayList<Integer>();
		int leg = 1;
		for(int i = 0; i < primeFact.size(); i++) {
			primeFact.set(i, primeFact.get(i)%prime);
		}
		for(int i = 0; i < primeFact.size(); i++) {
			if(primeFact.get(i) != 1) {
				if(!isPrime(primeFact.get(i))) {
					primeFact.addAll(primeFact(primeFact.get(i)));
					primeFact.remove(i);
				}
			}
			outputs.add(legendre(primeFact.get(i), prime));
		}

		for(int i = 0; i < outputs.size(); i++) {
			leg = leg*outputs.get(i);
		}
		System.out.println("Legendre Symbol is " + leg);
	}

	public static boolean isPrime(int n) {
		if(n <= 1)
			return false;
		else {
			for(int i = 2; i < (n/2)+1; i++) {
				if(n%i ==0 )
					return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> primeFact(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if(isPrime(n)) {
			arr.add(n);
			return arr;
		}
		int m = n;
		for(int i = 1; i < (n/2)+1; i++) {
			if(isPrime(i) && m%i == 0) {
				while(m%i == 0) {
					arr.add(i);
					m = m/i;
				}
			}
		}
		return arr;
	}

	public static int euler(int n, int p) {
		int power = (p-1)/2;
		long pow = (long) Math.pow(n, power);
		pow = pow%p;
		if(pow == 1)
			return 1;
		else 
			return -1;
	}

	public static Integer legendre(int p, int q) {
		if(p == 2) {
			if(q%8 == 1 || q%8 == 7)
				return 1;
			if(q%8 == 3 || q%8 == 5)
				return -1;
			else {
				System.out.println("Error");
				System.exit(0);
			}
		}
		else {
			int quad = (int) Math.pow((-1), ((p-1)/2)*((q-1)/2));
			int leg1 = 1;
			ArrayList<Integer> primeFact = primeFact(q%p);
			ArrayList<Integer> outputs = new ArrayList<Integer>();
			if((q%p) == 1)
				outputs.add(1);
			for(int i = 0; i < primeFact.size(); i++) {
				outputs.add(euler(primeFact.get(i), p));
			}
			for(int i = 0; i < outputs.size(); i++) {
				if(outputs.get(i) != 1)
					outputs.set(i, -1);
			}
			for(int i = 0; i < outputs.size(); i++) {
				leg1 = leg1*outputs.get(i);
			}
			if(leg1 != 1)
				leg1 = -1;
			if(quad == 1) {
				if(leg1 == 1)
					return 1;
				else 
					return -1;
			}
			if(quad == -1) {
				if(leg1 == 1)
					return -1;
				else
					return 1;
			}
		}
		System.out.println("Error");
		System.exit(0);
		return 0;
	}
}
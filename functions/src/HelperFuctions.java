import java.lang.Math;

public class HelperFuctions {

	public static void fastPowering(int a, int A, int m, int b) {
		while (A != 0) {
	        if (A % 2 == 0) {
	            a = (a * a) % m;
	            A /= 2;
	        }else {
	            b = (b * a) % m;
	            a = (a * a) % m;
	            A = (A-1)/2;
	        }
	        System.out.println("a=" + a + ", A=" + A + ", b=" + b);
	    }
		if(b != 1) {
			System.out.println("Not a prime");
		}else {
			System.out.println("Is a prime");
		}
	}
	
	public static int gcd(long a, long b) {
		long x = a > b ? a : b;
		long y = a < b ? a : b;
		while(y != 0) {
			long temp = x;
			x = y;
			y = temp % y;
		}
		System.out.println("GCD: " + x);
		return (int) x;
	}
	
	public static int gcd2(int a, int b) {
		int gcd = 0;
        for (int i = 1; i <= a || i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
	}
	
	public static int lcm(int a, int b) {
		int lcm = (a*b)/gcd(a,b);
		System.out.println("LCM: " + lcm);
		return lcm; 
	}
	
	public static int inverse(int a, int n) {
		a = a % n;
		int x;
        for (x = 1; x < n; x++) {
           if ((a * x) % n == 1) {
        	  System.out.println("Inverse of " + a + ": " + x);
              return x; 
           }
        }
        System.out.println("There is no inverse for " + a);
        return 1; 
	}
	
	public static void millerRabin(int m, int a) {
	    int q, k;
	    
	    q = m - 1;
	    k = 0;
	    while (q % 2 == 0) {
	        q >>= 1;
	        k++;
	        System.out.println("q: " + q + ", k: " + k);
	    }
	    
	    if (Math.pow(a, q) % m == 1) {
	    	System.out.println(m + " is a prime!");
	    }
	    
	    for (int i = 1; i < k; i++) {
	        if (Math.pow(a, Math.pow(2, i) * q) % m == (m - 1)) {
	        	System.out.println(m + " is a prime!");
	        }
	    }

	    System.out.println(m + " is not a prime!");
	}
	
	public static void pollardRho(int n) {
		int slo = 2, fast = 2, d = 1;
		while(d == 1) {
			slo = helper(slo, n);
			fast = helper(helper(fast, n), n);
			d = gcd2(fast-slo, n);
		}
		if(d == n) {
			System.out.println("One factor is " + d);
		}else {
			System.out.println("One factor is " + d);
			pollardRho(n/d);
		}
	}
	
	public static long pollard2(long n, int m, long a) {
		long d;
		long i = a;
		while(i < 1000) {
			for(int j = 2; j <= m; j++) {
				a = (a << j) % n;
				System.out.println("a: " + a);
				d = gcd(a-1, n);
				System.out.println("d: " + d);
				if(d != 1) {
					System.out.println("One factor is: " + d);
					return d;
				}
			}
			System.out.println("There are no factors for a = " + i + "\n");
			a = ++i;
		}
		return -1;
	}
	
	public static int helper(int x, int m) {
		return ((x*x)+1) % m;
	}
	
	public static void main(String[] args) {
		//fastPowering(7, 158, 159, 1);
		//gcd(1029, 56);
		//millerRabin(161, 2);
		//pollardRho(11413);
		lcm(102, 112);
		//inverse(7467, 11200);
		//pollard2(48356747, 20, 2);
	}

}

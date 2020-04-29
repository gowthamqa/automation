package interview;

class Psolution {
	
	public static void rightAngledTriangle(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        
        if(s.length()%2 != 0)
            return false;
        
        int length;
        
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while(length != s.length());
    
        return s.length() == 0;   
    }
    
    public static boolean isPrime(int n) {
    	//int count = 0;
    	for(int i = 2;i<=Math.sqrt(n);i++) {
    		if(n%i == 0) {
    			//count = 1;
    			return false;
    		}
    	}
    	return true;
    }
    
    public static int[] sort(int arr[]) {
    	//int temp =0;
    	for(int i = 0;i<arr.length;i++) {
    		for(int j = i+1;j<arr.length;j++) {
    			if(arr[i] > arr[j]) {
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
    	return arr;
    }
    
    public static void main(String[] args) {
    	Psolution p = new Psolution();
    	//System.out.println(p.isValid("[({)]}"));
    	//rightAngledTriangle(4);
    	for(int i = 2;i<=100;i++) {
    		if(isPrime(i)) {
    			//System.out.println(i+" is a prime Number");
    		}
    	}
    	int[] ar = {1,3,2,6,34,6,7};
    	//System.out.println();
    	//int[] result = sort(ar);
    	for(int e : sort(ar)) {
    		System.out.print(e+", ");
    	}
    	
	}
}

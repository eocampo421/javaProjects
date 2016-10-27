public class LonelyInteger {
    
    public static int lonelyInteger(int[] a) {
        int result = 0;
	int[] counts = new int[101];
	if (a.length == 1){
	    result = a[0];
	}
	else{			
	    for (int i = 0; i < a.length; i++) {
	        counts[a[i]] += 1;
	    }
            int i = 0;
            while (i < counts.length && !(counts[i] == 1)){			
                i++;
            }

            if (counts[i] == 1)
              result = i;
	}
	return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}

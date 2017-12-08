package recursion;
import java.util.Arrays;

public class MergeArray {
	
	public static int[] merge(int[] numsA, int[] numsB, int[] numsC){
		int a = 0;
		int b = 0;
		int c = 0;
		for(; c < numsC.length && a < numsA.length && b < numsB.length; c++){
			if(numsA[a] < numsB[b]){
				numsC[c] = numsA[a];
				a++;
			}else if(numsA[a] > numsB[b]){
				numsC[c] = numsB[b];
			    b++;
			}
		}	
		if(a < numsA.length){
			for(; c < numsC.length && a < numsA.length; c++){
		    	numsC[c] = numsA[a];
		    	a++;
		    }
		}	
		if(b < numsB.length){
			for(; c < numsC.length && b < numsB.length; c++){
				numsC[c] = numsB[b];
				b++;
		    }	
		}
		return numsC;
	}	
	public static void main(String[] args) {
		int[] numsA = new int[]{0,1,3,5,7,9};
		int[] numsB = new int[]{2,4,6,8};
		int[] numsC = new int[10];
		
		numsC = merge(numsA,numsB,numsC);
		System.out.print(Arrays.toString(numsC));
		
	}

}

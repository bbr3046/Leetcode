package prefMin_prefMax_sufMin_sufMax;

import java.util.TreeMap;

public class _132_Pattern {
	
	public boolean find132Pattern(int[] nums) {
		//In this solution we have used little higher value than prefMin[i]
		int n = nums.length;
		int[] prefMin = new int[n];
		prefMin[0] = Integer.MAX_VALUE;
		TreeMap<Integer,Integer> freqs = new TreeMap<>();
		for(int i=1;i<=n-1;i++) {
			prefMin[i] = Math.min(prefMin[i-1], nums[i-1]);
			freqs.put(nums[i], freqs.getOrDefault(nums[i],0)+1);
		}
		
		for(int i=1;i<n-1;i++) {
			freqs.put(nums[i],freqs.get(nums[i])-1);
			if(freqs.get(nums[i]) == 0) freqs.remove(nums[i]);
			if(prefMin[i] < nums[i]) {
				Integer justHigher = freqs.higherKey(prefMin[i]);
				if (justHigher != null && justHigher < nums[i]) return true;
			}
		}
		
		return false;
	}
	
	public boolean find132PatternV1(int[] nums) {
		//In this solution we have used lil lower value than middle value so that
		// we can use that as nums[k].
		int n = nums.length;
	      int[] prefMin = new int[n];
	      prefMin[0] = Integer.MAX_VALUE;
	 
	      TreeMap<Integer,Integer> freqs = new TreeMap<>();
	      for(int i= 1;i<n;i++){
	          prefMin[i] = Math.min(prefMin[i-1],nums[i-1]);
	          freqs.put(nums[i],freqs.getOrDefault(nums[i],0)+1);
	      }


	      for(int i=1; i<n-1;i++){
	           freqs.put(nums[i],freqs.get(nums[i])-1);
	           if (freqs.get(nums[i]) == 0) freqs.remove(nums[i]);
	           Integer justLess = freqs.lowerKey(nums[i]);
	           if (justLess != null){
	               if(prefMin[i] < nums[i] && justLess > prefMin[i])
	                   return true;
	        }
	           
	      }
	      return false;
	}

}

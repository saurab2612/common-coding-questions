package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SubstringNonRepeatingCharacter {
	
	public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j)))
                   break;
               else{
                   set.add(s.charAt(j));
                   if(set.size()>max)
                       max = set.size();
               }
            }
        }
        return max;
   }
	
	public static int totalFruit(int[] fruits) {
        if(fruits.length == 0)
            return 0;
        int i=0;
        int j=0;
        int count=0;
        int max=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j!=fruits.length){
            map.put(fruits[j], j);
            if(map.keySet().size()<=2){
                count++;
                j++;
            }else{
                if(fruits[j-1]==fruits[i]){
                	int kt=0;
                    for(int p:map.keySet()){
                        if(p!=fruits[j]&&p!=fruits[i]){
                            int k = map.get(p);
                            count = j-k;
                            i=k+1;j++;
                            kt=p;
                            break;
                        }
                    }
                    map.remove(kt);
                }else{
                    int k =map.get(fruits[i]);
                    map.remove(fruits[i]);
                    count = j-k;
                    i=k+1;
                    j++;
                }
            }
            if(count>max)
                max = count;
        }
        return max;
    }
	
	
	public static int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int count=0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j!=s.length()) {
        	if(map.containsKey(s.charAt(j)))
        		map.put(s.charAt(j), map.get(s.charAt(j))+1);
        	else
        		map.put(s.charAt(j), 1);
        	
        	if(stableWindow(map,k,j-i+1)) {
        		count++;
        		if(count > max)
        			max = count;
        		j++;
        	}else {
        		while(!stableWindow(map,k,j-i+1)) {
        			map.put(s.charAt(i), map.get(s.charAt(i))-1);
        			if(map.get(s.charAt(i))==0)
        				map.remove(s.charAt(i));
        			i++;
        		}
        		count = j-i+1;
        		j++;
        	}
        }
        return max;
    }

	private static boolean stableWindow(Map<Character, Integer> map, int k, int window) {
		for(char i : map.keySet()) {
			if(map.get(i) >= window-k)
				return true;
		}
		return false;
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i=nums2.length-1;
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        while(i>=0){
            if(stack.isEmpty())
                map.put(nums2[i],-1);
            else{
                while(!stack.isEmpty()&&stack.peek()<=nums2[i]) {
                	stack.pop();
                }
                if(stack.isEmpty())
                	map.put(nums2[i], -1);
                else
                	map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
            i--;
        }
        for(int j=0;j<nums1.length;j++) {
        	nums1[j] = map.get(nums1[j]);
        }
        return nums1;
    }
	
	public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
        	ans[i] = nums[i];
            for(int j=i+1;j<i+nums.length;j++){
                int index = j;
                if(j>=nums.length)
                    index = j%nums.length;
                if(nums[index]>nums[i]) {
                    ans[i] = nums[index];
                    break;
                }
            }
            if(ans[i]==nums[i])
                ans[i] = -1;
        }
        return ans;
    }
	
	public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(i!=j && isConnected[i][j]==1){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        int vis[] = new int[isConnected.length];
        int count = 0; 
        for(int i=0;i<isConnected.length;i++) {
        	if(vis[i]==0) {
        		bfs(vis,g,i);
        		count ++;
        	}
        }
        return count;
    }

	private void bfs(int[] vis, ArrayList<ArrayList<Integer>> g, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		vis[i] =1;
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int p:g.get(k)) {
				if(vis[p] == 0) {
					vis[p] = 1;
					q.add(p);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(nextGreaterElements(nums));
	}

}

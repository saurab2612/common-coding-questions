package DP;

public class KnapsackDuplicateItem {
	
	static int knapSack(int N, int W, int val[], int wt[])
    {
		int[][] t = new int[N+1][W+1];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<W+1;j++) {
				if(i==0 || j==0) {
					t[i][j] =0;
					continue;
				}
				
				if(wt[i-1] <= j) {
					t[i][j] = Math.max((val[i-1] + t[i][j-wt[i-1]]), t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
					
			}
		}
		return t[N][W];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

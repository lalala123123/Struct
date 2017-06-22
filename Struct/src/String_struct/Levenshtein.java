package String_struct;

public class Levenshtein {

	public static int Edit_Distance(String st1,String st2){
		int n = st1.length();
		int m = st2.length();
		
		int [][]dp = new int[n][m];
		for(int i = 0;i<n;i++){
			dp[i][0] = i;
		}
		for(int i = 0;i<m;i++){
			dp[0][i] = i;
		}
		for(int i = 1;i<n;i++){
			for(int j = 1;j<m;j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+(st1.charAt(i)==st2.charAt(j)?0:1));
			}
		}
		return dp[n-1][m-1];
	}
}

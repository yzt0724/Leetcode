public class EditDistance {
	public int minDistance(String word1, String word2) {
		// dp[i][j]=dp[i-1][j]+1 dp[i][j-1]+1 dp[i-1][j-1]
		int[][] dp=new int[word1.length()+1][word2.length()+1];
		for(int i=0; i<dp.length; i++){
			dp[i][0]=i;
		}
		for(int j=0; j<dp[0].length; j++){
			dp[0][j]=j;
		}
		for(int i=0; i<word1.length(); i++){
			for(int j=0; j<word2.length(); j++){
				if(word1.charAt(i)==word2.charAt(j)){
					dp[i+1][j+1]=dp[i][j];
				}else{
					dp[i+1][j+1]=1+Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]));
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}

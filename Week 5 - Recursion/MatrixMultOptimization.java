public class MatrixMultOptimization {
	
    public static int f(int[][] mm) {
        return f(mm, 0, mm.length - 1);
    }

    public static int f(int[][] mm, int i, int j) {
        // TODO
    	
    	int[] score = new int[j];
    	
    	int start = i;
    	int x = start + 1;
    	
    	for(int count = 0; count < score.length; count++) {
        	score[count] = mm[start][0]*mm[x][0]*mm[x][1];
        	System.out.println("Zwischenscore: " + score[count]);
        	score[count] = score[count] + mm[start][0]*mm[x][1]*mm[x + 1][1];
        	System.out.println("Score: " + score[count]);
        	start++;
        	x++;
        	System.out.println("start: " + start + "\tx: " + x);
    	}
    	
    	for(int u = 0; u < score.length; u++) {
    		System.out.println("Eintrag " + u + ": " + score[u]);
    	}
    	return 0;
    }

}
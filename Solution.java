import java.io.*;
public class Solution {
	private static HashMap<String, int>() cache = new HashMap<String, int>();
	private static int[] range;
	private static int N; //dimentions
	private static int M; //steps

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
    }

    public static int solutionCount(int[] curPosition, int moveLeft){
    	StringBuffer str = new StringBuffer();
    	for( int i = 0; i < N; i++ ){
			str.add(curPosition[i]);
			str.add(",");
			str.add(moveLeft);
		}

		if( cache.hasKey(str.toString()) ){
			return ((Integer)cache.get(str.toString())).intValue();
		}

    	int result = 0;

    	if( moveLeft == 1 ){
    		for( int i = 0; i < N; i++ ){
    			str.add(curPosition[i]);
    			str.add(",");
    			if( curPosition[i] > 1 ){
	    			result ++;
    			}

    			if( curPosition[i] < range[i] ){
	    			result ++;	
    			}
    		}
    	}else{
    		for( int i = 0; i < N; i++ ){
    			str.add(curPosition[i]);
    			str.add(",");
    			if( curPosition[i] > 1 ){
	    			curPosition[i] -= 1;
	    			result += solutionCount(curPosition, moveLeft-1);
    			}

    			if( curPosition[i] < range[i]-1 ){
	    			curPosition[i] += 2;
	    			result += solutionCount(curPosition, moveLeft-1);	
    			}
    		}
    	}
    	str.add(moveLeft);
    	cache.set(str.toString(), result);

    	return result;
    }
}
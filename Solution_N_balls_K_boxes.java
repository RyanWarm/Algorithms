/**
 * Amazon Interview:N个相同的球放到K个相同的盒子中,输出所有可能的放法(各个盒子没有区别)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_N_balls_K_boxes {
	public static int n;
	public static int k;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	        String line = br.readLine();
	        
	        String[] input = line.split(" ");
	        n = Integer.parseInt(input[0]);
	        k = Integer.parseInt(input[1]);
	        
	        int[] value = new int[k];
	        value[0] = n;
	        for( int i = 1; i < k; i++ ){
	        	value[i] = 0;
	        }
	        
	        doProcess(value, 1);
	}
	
	public static void doProcess(int[] value, int index){
		if( value[0] >= value[1] && value[index] <= value[index-1] ){
			//validate
			printResult(value);
		}else{
			return;
		}
		
		//iterations
		for( int i = index; i < k; i++ ){
			--value[0];
			++value[i];
			doProcess(value, i);
			++value[0];
			--value[i];
		}
	}
	
	public static void printResult(int[] value){
		for( int i = 0; i < value.length-1; i++ ){
			System.out.print(value[i]);
			System.out.print(" ");
		}
		System.out.println(value[value.length-1]);
	}

}

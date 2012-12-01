import java.io.*;
public class Solution {
    private static HashMap<String, Integer> cache = new HashMap<String, Integer>();
    private static int[] range;
    private static int N; //dimensions
    private static int M; //steps

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        String[] values, values_range;
        for (int i = 0; i < T; i++) {
            line = br.readLine();
            values = line.split(" ");
            N = Integer.parseInt(values[0]);
            M = Integer.parseInt(values[1]);

            line = br.readLine();
            values = line.split(",");
            line = br.readLine();
            values_range = line.split(",");
            range = new int[N];
            int[] positions = new int[N];
            for( int j = 0; j < N; j++ ){
                positions[j] = Integer.parseInt(values[j]);
                range[j] = Integer.parseInt(values_range[j]);
            }

            System.out.println( solutionCount(positions, M) % 1000000007 );
        }
    }

    public static int solutionCount(int[] curPosition, int moveLeft){
        System.out.println("Current position: " + curPosition[0] + "; Move left: " + moveLeft);
        StringBuffer str = new StringBuffer();
        for( int i = 0; i < N; i++ ){
            str.append(String.valueOf(curPosition[i]));
            str.append(",");
            str.append(String.valueOf(moveLeft));
        }

        if( cache.containsKey(str.toString()) ){
            System.out.println("hit: " + ((Integer)cache.get(str.toString())).intValue());
            return ((Integer)cache.get(str.toString())).intValue();
        }
        
        int result = 0;
        
        str = new StringBuffer();
        if( moveLeft == 1 ){
            for( int i = 0; i < N; i++ ){
                str.append(String.valueOf(curPosition[i]));
                str.append(",");
                if( curPosition[i] > 1 ){
                    result ++;
                }

                if( curPosition[i] < range[i] ){
                    result ++;  
                }
            }
        }else{
            for( int i = 0; i < N; i++ ){
                str.append(String.valueOf(curPosition[i]));
                str.append(",");
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
        str.append(String.valueOf(moveLeft));
        cache.put(str.toString(), new Integer(result));
        
        System.out.println("Output: " + str.toString() + "|" + result);

        return result;
    }
}
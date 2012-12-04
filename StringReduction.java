import java.util.*;
import java.io.*;

public class StringReduction{
	public static char[][] R;
	public static int[][] result;
	
	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();

		int T = Integer.parseInt( line );

		for( int i = 0; i < T; i++ ){
			line = br.readLine();
			processString( line );
		}
	}

	public static void processString( String input ){
		int length = input.length();
		R = new char[length][length];
		result = new int[length][length];
		
		int k;
		char tail;
		for( int i = 0; i < length; i++ ){
			for( int j = 0; j < length; j++ ){
				result[i][j] = -1;
			}
		}
		
		for( int i = 0; i < length; i++ ){
			result[i][i] = 1;
			R[i][i] = input.charAt(i);
		}
		
		for( int i = 1; i < length; i++ ){
			for( int j = 0; j < length - i; j++ ){
				k = j + i;
				doProcess( input, j, k );
			}
		}
		
		doProcess( input, 0, length-1 );
		System.out.println( result[0][length-1] );
	}

	public static void doProcess( String input, int start, int end ){
		if( result[start][end] != -1 ){
			return;
		}
		
		if( start == end - 1 ){
			if( input.charAt(start) == input.charAt(end) ){
				result[start][end] = 2;
				R[start][end] = input.charAt(start);
			}else{
				result[start][end] = 1;
				R[start][end] = getNextChar( input.charAt(start), input.charAt(end) );
			}
		}
		
		int min = end - start + 1;
		int tmp;
		for( int i = start; i < end; i++ ){
			doProcess( input, start, i );
			doProcess( input, i+1, end );
			if( R[start][i] == R[i+1][end] ){
				tmp = result[start][i] + result[i+1][end];
			}else{
				
			}
		}
	}

	public static char getNextChar( char c1, char c2 ){
		if( c1 == 'a' ){
			if( c2 == 'b' ){
				return 'c';
			}else{
				return 'b';
			}
		}else if( c1 == 'b' ){
			if( c2 == 'a' ){
				return 'c';
			}else{
				return 'a';
			}
		}else{
			if( c2 == 'a' ){
				return 'b';
			}else{
				return 'a';
			}
		}
	}
}
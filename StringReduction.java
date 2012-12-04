import java.util.*;
import java.io.*;

public class StringReduction{
	public static void main( String[] args ){
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();

		int T = Integer.parseInt( line );

		char[] R;
		int[] result;
		for( int i = 0; i < T; i++ ){
			line = br.readLine();
			processString( line );
		}
	}

	public static void processString( String input ){
		int length = input.length;
		R = new char[length];
		result = new int[length];
		result[0] = 1;

		R[0] = input.charAt(0);
		doProcess( input, new StringBuffer(input), length-1 );
		System.out.println( result[length-1] );
	}

	public static char doProcess( String rawString, StringBuffer input, int index ){
		if( index == 0 ){
			return R[0];
		}

		char tail = doProcess( rawString, input, index-- );

		if( rawString.charAt(index) == tail ){
			result[index] = result[index-1] + 1;
			return tail;
		}else{
			result[index] = 1;
			return getNextChar( tail, rawString.charAt(index) );
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
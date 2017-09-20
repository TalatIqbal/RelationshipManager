package ca.allyengine.io.utilities;

import java.io.OutputStream;
import java.io.PrintStream;

public class StreamRedirect {	
	
	
	/**
	 * Hides the Console Output by redirecting the System.out.println to a dummy stream
	 * 
	 * @author Talat
	 * @since 2017-09-19
	 */
	public static void hideConsoleOutput() {
		
		try {
			PrintStream outDummyStream    = new PrintStream(new OutputStream(){
			    public void write(int b) {
			        //NO-OP
			    }
			});			
			System.setOut(outDummyStream);
		} catch (Exception ex) {
			System.out.println("EXCEPTION in StreamRedirect.hideConsoleOutput");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Shows the Console Output by redirecting the System.out.println to the original stream
	 * 
	 * @author Talat
	 * @since 2017-09-19
	 */
	public static void showConsoleOutput() {
		
		try {
			PrintStream outOriginalStream = System.out;			
			System.setOut(outOriginalStream);
		} catch (Exception ex) {
			System.out.println("EXCEPTION in StreamRedirect.showConsoleOutput");
			ex.printStackTrace();
		}
	}

}

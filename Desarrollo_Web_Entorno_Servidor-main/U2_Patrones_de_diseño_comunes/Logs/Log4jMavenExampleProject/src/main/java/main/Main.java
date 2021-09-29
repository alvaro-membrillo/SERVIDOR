package main;

import org.apache.log4j.Logger;

import util.Misc;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		
		// this is the main body where you can place your business code
		// keep in mind about different log levels in order to understand 
		// behaviour correctly
		
		logger.info("Before methods invokation [Main.class]");
		
		int result = Misc.addition(5,7);
		result = Misc.subtraction(result,3);
		
		logger.info("After methods invokation [Main.class]");
		

	}

	

}

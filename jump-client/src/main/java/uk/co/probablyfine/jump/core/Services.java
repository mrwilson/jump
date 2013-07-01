package uk.co.probablyfine.jump.core;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class Services {

	private static final String CHECK_STATUS = "status";
	
	public static boolean isRunning(String serviceName) {
		final CommandLine isRunningCmd = new CommandLine(CHECK_STATUS);
		final DefaultExecutor executor = new DefaultExecutor();
		
		isRunningCmd.addArgument(serviceName);
		
		try {
			return (0 == executor.execute(isRunningCmd));
		} catch (IOException e) {
			return false;
		}
		
	}
	
}

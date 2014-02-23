package uk.co.probablyfine.jump.core;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class Services {

	private static final String CHECK_STATUS  = "status";
	private static final String START_SERVICE = "service %s start";
    private static final String STOP_SERVICE = "service %s stop";
    private static final String RESTART_SERVICE = "service %s restart";

    /**
     * Check if a particular service is running
     * @param serviceName
     * @return
     */
	public static boolean isRunning(String serviceName) {
		final CommandLine isRunningCmd = new CommandLine(CHECK_STATUS);
		final DefaultExecutor executor = new DefaultExecutor();
		
		isRunningCmd.addArgument(serviceName);
		executor.setStreamHandler(new NullReporter());
		
		try {
			return (0 == executor.execute(isRunningCmd));
		} catch (IOException e) {
			return false;
		}
	}

    public static boolean serviceQuery(String op, String serviceName) {
        final CommandLine cmd = new CommandLine(String.format(op, serviceName));
        final DefaultExecutor executor = new DefaultExecutor();

        cmd.addArgument(serviceName);
        executor.setStreamHandler(new NullReporter());

        try {
            return (0 == executor.execute(cmd));
        } catch (IOException e) {
            return false;
        }
    }
	
}

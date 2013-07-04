package uk.co.probablyfine.jump.core;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class Packages {

	public static boolean isInstalled(String name) {
		final CommandLine isRunningCmd = new CommandLine("dpkg");
		final DefaultExecutor executor = new DefaultExecutor();

		executor.setStreamHandler(new NullReporter());

		isRunningCmd.addArgument("-s");
		isRunningCmd.addArgument(name);

		try {
			return (0 == executor.execute(isRunningCmd));
		} catch (IOException e) {
			return false;
		}
	}
}

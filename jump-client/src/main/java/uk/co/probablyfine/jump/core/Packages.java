package uk.co.probablyfine.jump.core;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class Packages {

	private static final String DPKG 	= "dpkg";
	private static final String APT_GET	= "apt-get";

	public static boolean isInstalled(String name) {
		final CommandLine isRunningCmd = new CommandLine(DPKG);
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

	public static boolean installPackage(String name) {
		final CommandLine isRunningCmd = new CommandLine(APT_GET);
		final DefaultExecutor executor = new DefaultExecutor();

		executor.setStreamHandler(new NullReporter());

		isRunningCmd.addArgument("install");
		isRunningCmd.addArgument("-y");
		isRunningCmd.addArgument(name);

		try {
			return (0 == executor.execute(isRunningCmd));
		} catch (IOException e) {
			return false;
		}

	}
}

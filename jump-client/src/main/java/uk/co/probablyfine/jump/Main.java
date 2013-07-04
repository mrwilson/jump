package uk.co.probablyfine.jump;

import uk.co.probablyfine.jump.core.Packages;
import uk.co.probablyfine.jump.core.Services;

public class Main {

	public static void main(String[] args) {
		System.out.println("MySQL is running? " + Services.isRunning("mysql"));
		System.out.println("Madeupname is running? " + Services.isRunning("madeupname"));
		System.out.println("Awesome is installed? " + Packages.isInstalled("awesome"));
		Packages.installPackage("awesome");
	}
}

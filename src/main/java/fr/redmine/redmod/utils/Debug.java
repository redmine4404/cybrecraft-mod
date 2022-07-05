package fr.redmine.redmod.utils;

public class Debug {
	public static void debug(String msg) {
		if(Reference.OnDebug) {
			System.out.println(msg);
		}
			
	}
}

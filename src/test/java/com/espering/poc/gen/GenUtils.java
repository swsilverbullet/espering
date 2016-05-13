package com.espering.poc.gen;

import java.util.List;
import java.util.Random;

public class GenUtils {
	public static <T> T oneOf(List<T> l) {
		int index = new Random().nextInt(l.size());
		return l.get(index);
	}
	
	public static String oneOf(String... args) {
		int index = new Random().nextInt(args.length);
		return args[index];
	}
}

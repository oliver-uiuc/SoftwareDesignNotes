package chapter5;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class MyTestRunner {
	public static void main(String [] args) {
		for (Method method: AbsTest.class.getDeclaredMethods()) {
			System.out.println(method+" :: "+method.getAnnotation(Test.class));
		}
	}
}

package chapter5;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class AbsTest {
	public static void main(String [] args){
		for(Method method : AbsTest.class.getDeclaredMethods()) {
			String result = method.toString();
			if(Modifier.isPublic(method.getModifiers())&&
					!Modifier.isStatic(method.getModifiers())&&
					method.getReturnType()==void.class) {
				result = "==> " + result; 
			}
			System.out.println(result);
		}
	}
	@Test
	public void testAbs_Zero() {
		assertEquals(0, Math.abs(0));
	}
	@Test
	public void testAbs_Positive() {
		assertEquals(1, Math.abs(1));
	}
	@Test
	public void testAbs_Negative() {
		assertEquals(1, Math.abs(-1));
	}
//	private void foo() {
//		System.out.println("foo");
//	}
}


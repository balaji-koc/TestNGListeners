package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		System.out.println("### IAnnotationTransformer invoked....for "+testMethod.getName());
		if(testMethod.getName().equals("method_03"))
		{
			annotation.setPriority(1);
		}
				
	}

}

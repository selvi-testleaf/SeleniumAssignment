package sprint1;

import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer {


public void transform(ITestAnnotation annotation, Hooks testClass,  Method testMethod) {
	        annotation.setRetryAnalyzer(RetryClass.class);
	    }
	}

	



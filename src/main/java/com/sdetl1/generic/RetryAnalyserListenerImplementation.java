package com.sdetl1.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyserListenerImplementation implements IAnnotationTransformer {

@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	annotation.setRetryAnalyzer(com.sdetl1.generic.RetryAnalyserImplementationClass.class);
	
}
}
package com.magento.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.magento.listeners.Retry;

public class AnnotationTransformer implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testContructor, Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
}

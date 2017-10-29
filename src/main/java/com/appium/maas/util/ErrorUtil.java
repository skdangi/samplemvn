package com.appium.maas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorUtil {
	
	static Map<ITestResult,List<Throwable>>  verificationFailuresMap = new HashMap();
	
    public static void addVerificationFailure(Throwable e) {
		System.out.println("*************addVerificationFailure******************");
			List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
			if(verificationFailures == null){
				verificationFailures = new ArrayList();
				verificationFailuresMap.put(Reporter.getCurrentTestResult(),verificationFailures);
			}
			verificationFailures.add(e);
		}
    
    public static List getVerificationFailures(){
    	List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		if(verificationFailures == null){
			verificationFailures = new ArrayList();
		}
		return verificationFailures;
    }
	 
}

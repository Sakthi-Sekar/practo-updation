package com.atmecs.practo.reports;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.atmecs.practo.constants.ConstantPaths;




public class LogReports {
Logger logger = null;

public LogReports() {

getlogger();
logger = Logger.getLogger(LogReports.class.getName());
}

public void getlogger() {
PropertyConfigurator.configure(ConstantPaths.LOG4J_FILE);
}

public void info(String message){
logger.info(message);
}


public void debug(String message){

}

}
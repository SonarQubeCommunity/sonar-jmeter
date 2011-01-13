#!/bin/bash
BASEDIR=`dirname $0`
JAR=jmeter-report-server-0.1-jar-with-dependencies.jar
CLASSPATH=$BASEDIR/properties:$BASEDIR/lib/$JAR

java -classpath $CLASSPATH es.excentia.jmeter.report.server.JMeterReportServer

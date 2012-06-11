#!/bin/bash
BASEDIR=`dirname $0`
JAR=jmeter-report-server-${project.version}-jar-with-dependencies.jar
CLASSPATH=$BASEDIR/properties:$BASEDIR/lib/$JAR

java -classpath "$CLASSPATH" es.excentia.jmeter.report.server.JMeterReportServer

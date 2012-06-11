set BASEDIR=%~dp0
set JAR=jmeter-report-server-${project.version}-jar-with-dependencies.jar
set CLASSPATH=%BASEDIR%properties;%BASEDIR%lib\%JAR%

java -classpath "%CLASSPATH%" es.excentia.jmeter.report.server.JMeterReportServer

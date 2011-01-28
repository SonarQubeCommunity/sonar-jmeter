/*
 * JMeter Report Client
 * Copyright (C) 2010 eXcentia
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package es.excentia.jmeter.report.client.data;

import java.util.List;
import java.util.Map;

public class GlobalSummary {
	
	//////////////////////////
	// Métricas que describen el test
	
	String testDesc; 	// Descripción del test: Distribución de los usuarios en el tiempo, objetivo del test, ...
	long usersLogged;	// Num. medio de usuarios participando en el test (entendidos los usuarios como hilos paralelos de ejecución del test).
	long testDuration;	// Duración del test en milisegundos

	
	//////////////////////////
	// Métricas globales requests http
	
	long requestsTotal;
	long requestsOkTotal;
	long requestsErrorTotal;
	double requestsErrorPercent;
	
	double requestsOkPerMinute;
	double requestsOkPerMinuteAndUser;
	
	double requestsResponseTimeOkAvg;
	double requestsResponseTimeOkAvgDev;
	double requestsResponseTimeOkAvgDevPercent;
	
	double requestsBytesOkAvg;
	double requestsBytesOkAvgDev;
	double requestsBytesOkAvgDevPercent;
	
	
	//////////////////////////
	// Métricas globales de transacciones
		
	long transTotal;				// Num. total de transacciones
	long transOkTotal;				// Num. total de transacciones ok
	long transErrorTotal;			// Num. total de transacciones con error	
	double transErrorPercent;		// % de transacciones con error
	
	double transOkPerMinute;				// Transacciones ok por minuto
	double transOkPerMinuteAndUser;			// Transacciones ok por minuto y por usuario
	
	double transResponseTimeOkAvg;			// Tiempo de respuesta medio de una transacción
	double transResponseTimeOkAvgDev;		// Desviación absoluta del tiempo de respuesta de una transacción
	double transResponseTimeOkAvgDevPercent;// Desviación relativa del tiempo de respuesta de una transacción (detección de anomalías o interferencias)
	
	double transBytesOkAvg;					// Tamanyo (en bytes) medio de una transacción
	double transBytesOkAvgDev;				// Desviación absoluta del tamanyo (en bytes) de una transacción
	double transBytesOkAvgDevPercent;		// Desviación relativa del tamanyo (en bytes) de una transacción (detección de anomalías o interferencias)
	
	String slowestTransName;				// Tipo de transacción con el peor tiempo de respuesta medio
	double slowestTransResponseTimeOkAvg;	// Peor tiempo de respuesta medio
	double slowestTransBytesOkAvgDevPercent;// Peor tiempo de respuesta medio
	
	String mostUnstableTransName;			// Tipo de transacción más inestable. Tipo de transacción con la máxima desviación relativa del tiempo de respuesta. Este valor es un indicativo de la estabilidad global de la aplicación, puesto que es una cota máxima de la desviación relativa de todos los tipos de transacción
	double mostUnstableTransResponseTimeOkAvgDevPercent;	// Máx. desviación relativa del tiempo de respuesta para un único tipo de transacción (detección de anomalías o interferencias)
	double mostUnstableTransBytesOkAvgDevPercent;	
	
	
	//////////////////////////
	// Métricas concretas de cada tipos de transacción
	
	List<String> transOrder;
	Map<String,Long> transMapOkTotal;
	Map<String,Long> transMapErrorTotal;
	
	Map<String,Double> transMapResponseTimeOkAvg;
	Map<String,Double> transMapResponseTimeOkAvgDev;
	Map<String,Double> transMapResponseTimeOkAvgDevPercent;
	
	Map<String,Double> transMapBytesOkAvg;
	Map<String,Double> transMapBytesOkAvgDev;
	Map<String,Double> transMapBytesOkAvgDevPercent;
	
	
	
	public String getTestDesc() {
		return testDesc;
	}
	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}
	public long getUsersLogged() {
		return usersLogged;
	}
	public void setUsersLogged(long usersLogged) {
		this.usersLogged = usersLogged;
	}
	public long getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(long testDuration) {
		this.testDuration = testDuration;
	}
	public long getRequestsTotal() {
		return requestsTotal;
	}
	public void setRequestsTotal(long requestsTotal) {
		this.requestsTotal = requestsTotal;
	}
	public long getRequestsOkTotal() {
		return requestsOkTotal;
	}
	public void setRequestsOkTotal(long requestsOkTotal) {
		this.requestsOkTotal = requestsOkTotal;
	}
	public long getRequestsErrorTotal() {
		return requestsErrorTotal;
	}
	public void setRequestsErrorTotal(long requestsErrorTotal) {
		this.requestsErrorTotal = requestsErrorTotal;
	}
	public double getRequestsErrorPercent() {
		return requestsErrorPercent;
	}
	public void setRequestsErrorPercent(double requestsErrorPercent) {
		this.requestsErrorPercent = requestsErrorPercent;
	}
	public double getRequestsOkPerMinute() {
		return requestsOkPerMinute;
	}
	public void setRequestsOkPerMinute(double requestsOkPerMinute) {
		this.requestsOkPerMinute = requestsOkPerMinute;
	}
	public double getRequestsOkPerMinuteAndUser() {
		return requestsOkPerMinuteAndUser;
	}
	public void setRequestsOkPerMinuteAndUser(double requestsOkPerMinuteAndUser) {
		this.requestsOkPerMinuteAndUser = requestsOkPerMinuteAndUser;
	}
	public double getRequestsResponseTimeOkAvg() {
		return requestsResponseTimeOkAvg;
	}
	public void setRequestsResponseTimeOkAvg(double requestsResponseTimeOkAvg) {
		this.requestsResponseTimeOkAvg = requestsResponseTimeOkAvg;
	}
	public double getRequestsResponseTimeOkAvgDev() {
		return requestsResponseTimeOkAvgDev;
	}
	public void setRequestsResponseTimeOkAvgDev(double requestsResponseTimeOkAvgDev) {
		this.requestsResponseTimeOkAvgDev = requestsResponseTimeOkAvgDev;
	}
	public double getRequestsResponseTimeOkAvgDevPercent() {
		return requestsResponseTimeOkAvgDevPercent;
	}
	public void setRequestsResponseTimeOkAvgDevPercent(
			double requestsResponseTimeOkAvgDevPercent) {
		this.requestsResponseTimeOkAvgDevPercent = requestsResponseTimeOkAvgDevPercent;
	}
	public double getRequestsBytesOkAvg() {
		return requestsBytesOkAvg;
	}
	public void setRequestsBytesOkAvg(double requestsBytesOkAvg) {
		this.requestsBytesOkAvg = requestsBytesOkAvg;
	}
	public double getRequestsBytesOkAvgDev() {
		return requestsBytesOkAvgDev;
	}
	public void setRequestsBytesOkAvgDev(double requestsBytesOkAvgDev) {
		this.requestsBytesOkAvgDev = requestsBytesOkAvgDev;
	}
	public double getRequestsBytesOkAvgDevPercent() {
		return requestsBytesOkAvgDevPercent;
	}
	public void setRequestsBytesOkAvgDevPercent(double requestsBytesOkAvgDevPercent) {
		this.requestsBytesOkAvgDevPercent = requestsBytesOkAvgDevPercent;
	}
	public long getTransTotal() {
		return transTotal;
	}
	public void setTransTotal(long transTotal) {
		this.transTotal = transTotal;
	}
	public long getTransOkTotal() {
		return transOkTotal;
	}
	public void setTransOkTotal(long transOkTotal) {
		this.transOkTotal = transOkTotal;
	}
	public long getTransErrorTotal() {
		return transErrorTotal;
	}
	public void setTransErrorTotal(long transErrorTotal) {
		this.transErrorTotal = transErrorTotal;
	}
	public double getTransErrorPercent() {
		return transErrorPercent;
	}
	public void setTransErrorPercent(double transErrorPercent) {
		this.transErrorPercent = transErrorPercent;
	}
	public double getTransOkPerMinute() {
		return transOkPerMinute;
	}
	public void setTransOkPerMinute(double transOkPerMinute) {
		this.transOkPerMinute = transOkPerMinute;
	}
	public double getTransOkPerMinuteAndUser() {
		return transOkPerMinuteAndUser;
	}
	public void setTransOkPerMinuteAndUser(double transOkPerMinuteAndUser) {
		this.transOkPerMinuteAndUser = transOkPerMinuteAndUser;
	}
	public double getTransResponseTimeOkAvg() {
		return transResponseTimeOkAvg;
	}
	public void setTransResponseTimeOkAvg(double transResponseTimeOkAvg) {
		this.transResponseTimeOkAvg = transResponseTimeOkAvg;
	}
	public double getTransResponseTimeOkAvgDev() {
		return transResponseTimeOkAvgDev;
	}
	public void setTransResponseTimeOkAvgDev(double transResponseTimeOkAvgDev) {
		this.transResponseTimeOkAvgDev = transResponseTimeOkAvgDev;
	}
	public double getTransResponseTimeOkAvgDevPercent() {
		return transResponseTimeOkAvgDevPercent;
	}
	public void setTransResponseTimeOkAvgDevPercent(
			double transResponseTimeOkAvgDevPercent) {
		this.transResponseTimeOkAvgDevPercent = transResponseTimeOkAvgDevPercent;
	}
	public double getTransBytesOkAvg() {
		return transBytesOkAvg;
	}
	public void setTransBytesOkAvg(double transBytesOkAvg) {
		this.transBytesOkAvg = transBytesOkAvg;
	}
	public double getTransBytesOkAvgDev() {
		return transBytesOkAvgDev;
	}
	public void setTransBytesOkAvgDev(double transBytesOkAvgDev) {
		this.transBytesOkAvgDev = transBytesOkAvgDev;
	}
	public double getTransBytesOkAvgDevPercent() {
		return transBytesOkAvgDevPercent;
	}
	public void setTransBytesOkAvgDevPercent(double transBytesOkAvgDevPercent) {
		this.transBytesOkAvgDevPercent = transBytesOkAvgDevPercent;
	}
	public String getSlowestTransName() {
		return slowestTransName;
	}
	public void setSlowestTransName(String slowestTransName) {
		this.slowestTransName = slowestTransName;
	}
	public double getSlowestTransResponseTimeOkAvg() {
		return slowestTransResponseTimeOkAvg;
	}
	public void setSlowestTransResponseTimeOkAvg(
			double slowestTransResponseTimeOkAvg) {
		this.slowestTransResponseTimeOkAvg = slowestTransResponseTimeOkAvg;
	}
	public double getSlowestTransBytesOkAvgDevPercent() {
		return slowestTransBytesOkAvgDevPercent;
	}
	public void setSlowestTransBytesOkAvgDevPercent(
			double slowestTransBytesOkAvgDevPercent) {
		this.slowestTransBytesOkAvgDevPercent = slowestTransBytesOkAvgDevPercent;
	}
	public String getMostUnstableTransName() {
		return mostUnstableTransName;
	}
	public void setMostUnstableTransName(String mostUnstableTransName) {
		this.mostUnstableTransName = mostUnstableTransName;
	}
	public double getMostUnstableTransResponseTimeOkAvgDevPercent() {
		return mostUnstableTransResponseTimeOkAvgDevPercent;
	}
	public void setMostUnstableTransResponseTimeOkAvgDevPercent(
			double mostUnstableTransResponseTimeOkAvgDevPercent) {
		this.mostUnstableTransResponseTimeOkAvgDevPercent = mostUnstableTransResponseTimeOkAvgDevPercent;
	}
	public double getMostUnstableTransBytesOkAvgDevPercent() {
		return mostUnstableTransBytesOkAvgDevPercent;
	}
	public void setMostUnstableTransBytesOkAvgDevPercent(
			double mostUnstableTransBytesOkAvgDevPercent) {
		this.mostUnstableTransBytesOkAvgDevPercent = mostUnstableTransBytesOkAvgDevPercent;
	}
	public List<String> getTransOrder() {
		return transOrder;
	}
	public void setTransOrder(List<String> transOrder) {
		this.transOrder = transOrder;
	}
	public Map<String, Long> getTransMapOkTotal() {
		return transMapOkTotal;
	}
	public void setTransMapOkTotal(Map<String, Long> transMapOkTotal) {
		this.transMapOkTotal = transMapOkTotal;
	}
	public Map<String, Long> getTransMapErrorTotal() {
		return transMapErrorTotal;
	}
	public void setTransMapErrorTotal(Map<String, Long> transMapErrorTotal) {
		this.transMapErrorTotal = transMapErrorTotal;
	}
	public Map<String, Double> getTransMapResponseTimeOkAvg() {
		return transMapResponseTimeOkAvg;
	}
	public void setTransMapResponseTimeOkAvg(
			Map<String, Double> transMapResponseTimeOkAvg) {
		this.transMapResponseTimeOkAvg = transMapResponseTimeOkAvg;
	}
	public Map<String, Double> getTransMapResponseTimeOkAvgDev() {
		return transMapResponseTimeOkAvgDev;
	}
	public void setTransMapResponseTimeOkAvgDev(
			Map<String, Double> transMapResponseTimeOkAvgDev) {
		this.transMapResponseTimeOkAvgDev = transMapResponseTimeOkAvgDev;
	}
	public Map<String, Double> getTransMapResponseTimeOkAvgDevPercent() {
		return transMapResponseTimeOkAvgDevPercent;
	}
	public void setTransMapResponseTimeOkAvgDevPercent(
			Map<String, Double> transMapResponseTimeOkAvgDevPercent) {
		this.transMapResponseTimeOkAvgDevPercent = transMapResponseTimeOkAvgDevPercent;
	}
	public Map<String, Double> getTransMapBytesOkAvg() {
		return transMapBytesOkAvg;
	}
	public void setTransMapBytesOkAvg(Map<String, Double> transMapBytesOkAvg) {
		this.transMapBytesOkAvg = transMapBytesOkAvg;
	}
	public Map<String, Double> getTransMapBytesOkAvgDev() {
		return transMapBytesOkAvgDev;
	}
	public void setTransMapBytesOkAvgDev(Map<String, Double> transMapBytesOkAvgDev) {
		this.transMapBytesOkAvgDev = transMapBytesOkAvgDev;
	}
	public Map<String, Double> getTransMapBytesOkAvgDevPercent() {
		return transMapBytesOkAvgDevPercent;
	}
	public void setTransMapBytesOkAvgDevPercent(
			Map<String, Double> transMapBytesOkAvgDevPercent) {
		this.transMapBytesOkAvgDevPercent = transMapBytesOkAvgDevPercent;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("mostUnstableTransBytesOkAvgDevPercent=");
		builder.append(mostUnstableTransBytesOkAvgDevPercent);
		builder.append("\nmostUnstableTransName=");
		builder.append(mostUnstableTransName);
		builder.append("\nmostUnstableTransResponseTimeOkAvgDevPercent=");
		builder.append(mostUnstableTransResponseTimeOkAvgDevPercent);
		builder.append("\nrequestsBytesOkAvg=");
		builder.append(requestsBytesOkAvg);
		builder.append("\nrequestsBytesOkAvgDev=");
		builder.append(requestsBytesOkAvgDev);
		builder.append("\nrequestsBytesOkAvgDevPercent=");
		builder.append(requestsBytesOkAvgDevPercent);
		builder.append("\nrequestsErrorPercent=");
		builder.append(requestsErrorPercent);
		builder.append("\nrequestsErrorTotal=");
		builder.append(requestsErrorTotal);
		builder.append("\nrequestsOkPerMinute=");
		builder.append(requestsOkPerMinute);
		builder.append("\nrequestsOkPerMinuteAndUser=");
		builder.append(requestsOkPerMinuteAndUser);
		builder.append("\nrequestsOkTotal=");
		builder.append(requestsOkTotal);
		builder.append("\nrequestsResponseTimeOkAvg=");
		builder.append(requestsResponseTimeOkAvg);
		builder.append("\nrequestsResponseTimeOkAvgDev=");
		builder.append(requestsResponseTimeOkAvgDev);
		builder.append("\nrequestsResponseTimeOkAvgDevPercent=");
		builder.append(requestsResponseTimeOkAvgDevPercent);
		builder.append("\nrequestsTotal=");
		builder.append(requestsTotal);
		builder.append("\nslowestTransBytesOkAvgDevPercent=");
		builder.append(slowestTransBytesOkAvgDevPercent);
		builder.append("\nslowestTransName=");
		builder.append(slowestTransName);
		builder.append("\nslowestTransResponseTimeOkAvg=");
		builder.append(slowestTransResponseTimeOkAvg);
		builder.append("\ntestDesc=");
		builder.append(testDesc);
		builder.append("\ntestDuration=");
		builder.append(testDuration);
		builder.append("\ntransBytesOkAvg=");
		builder.append(transBytesOkAvg);
		builder.append("\ntransBytesOkAvgDev=");
		builder.append(transBytesOkAvgDev);
		builder.append("\ntransBytesOkAvgDevPercent=");
		builder.append(transBytesOkAvgDevPercent);
		builder.append("\ntransErrorPercent=");
		builder.append(transErrorPercent);
		builder.append("\ntransErrorTotal=");
		builder.append(transErrorTotal);
		builder.append("\ntransMapBytesOkAvg=");
		builder.append(transMapBytesOkAvg);
		builder.append("\ntransMapBytesOkAvgDev=");
		builder.append(transMapBytesOkAvgDev);
		builder.append("\ntransMapBytesOkAvgDevPercent=");
		builder.append(transMapBytesOkAvgDevPercent);
		builder.append("\ntransMapErrorTotal=");
		builder.append(transMapErrorTotal);
		builder.append("\ntransMapOkTotal=");
		builder.append(transMapOkTotal);
		builder.append("\ntransMapResponseTimeOkAvg=");
		builder.append(transMapResponseTimeOkAvg);
		builder.append("\ntransMapResponseTimeOkAvgDev=");
		builder.append(transMapResponseTimeOkAvgDev);
		builder.append("\ntransMapResponseTimeOkAvgDevPercent=");
		builder.append(transMapResponseTimeOkAvgDevPercent);
		builder.append("\ntransOkPerMinute=");
		builder.append(transOkPerMinute);
		builder.append("\ntransOkPerMinuteAndUser=");
		builder.append(transOkPerMinuteAndUser);
		builder.append("\ntransOkTotal=");
		builder.append(transOkTotal);
		builder.append("\ntransOrder=");
		builder.append(transOrder);
		builder.append("\ntransResponseTimeOkAvg=");
		builder.append(transResponseTimeOkAvg);
		builder.append("\ntransResponseTimeOkAvgDev=");
		builder.append(transResponseTimeOkAvgDev);
		builder.append("\ntransResponseTimeOkAvgDevPercent=");
		builder.append(transResponseTimeOkAvgDevPercent);
		builder.append("\ntransTotal=");
		builder.append(transTotal);
		builder.append("\nusersLogged=");
		builder.append(usersLogged);
		return builder.toString();
	}
	
	
}

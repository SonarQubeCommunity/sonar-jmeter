/*
 * Sonar JMeter Plugin
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

package org.sonar.plugins.jmeter;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.measures.Metrics;

public class JMeterMetrics implements Metrics {

  public static final String JMETER_DOMAIN = "Performance tests";
  
  private static Metric newMetric(String key, String name, String descrip, ValueType valueType, int direction) {
  	return new Metric.Builder(key, name, valueType)
			.setDescription(descrip==null? name : descrip)
			.setQualitative(false)
			.setDirection(direction)
			.setDomain(JMETER_DOMAIN)
			.create();
  }
  
  private static Metric newMetric(String key, String name, ValueType valueType, int direction) {
  	return newMetric(key, name, null, valueType, direction);
  }

  public static final Metric requestErrorPercent = newMetric(
  		"requestErrorPercent", "Errors", 
  		ValueType.PERCENT, Metric.DIRECTION_WORST);

  public static final Metric testDesc = newMetric(
  		"testDesc", "Test description", 
  		ValueType.STRING, Metric.DIRECTION_NONE);
		  
  public static final Metric duration = newMetric(
  		"duration", "Duration", 
  		ValueType.MILLISEC, Metric.DIRECTION_NONE);
  
  public static final Metric usersLogged = newMetric(
  		"usersLogged", "Users", 
  		ValueType.INT, Metric.DIRECTION_NONE);
  
  public static final Metric requestTotal = newMetric(
  		"requestTotal", "Requests", "Total requests", 
  		ValueType.INT, Metric.DIRECTION_NONE);
  
  public static final Metric transTotal = newMetric(
  		"transTotal", "Transactions", "Total transactions", 
  		ValueType.INT, Metric.DIRECTION_NONE);
  
  public static final Metric requestResponseTimeOkAvg = newMetric(
  		"requestResponseTimeOkAvg", "Response time per request", 
  		"Average response time per request", 
  		ValueType.MILLISEC, Metric.DIRECTION_WORST);

  public static final Metric requestResponseTimeOkDevPercent = newMetric(
  		"requestResponseTimeOkDevPercent", "Deviation per request", 
  		"Response time deviation", 
  		ValueType.PERCENT, Metric.DIRECTION_WORST);
  
  public static final Metric requestOkPerMinute = newMetric(
  		"requestOkPerMinute", "Requests per minute", 
  		ValueType.FLOAT, Metric.DIRECTION_BETTER);
  
  public static final Metric requestOkPerMinuteAndUser = newMetric(
  		"requestOkPerMinuteAndUser", "Requests per minute and user", 
  		ValueType.FLOAT, Metric.DIRECTION_BETTER);
  
  public static final Metric transResponseTimeOkAvg = newMetric(
  		"transResponseTimeOkAvg", "Response time per transaction", 
  		"Average response time per transaction",
  		ValueType.MILLISEC, Metric.DIRECTION_WORST);
  
  public static final Metric transResponseTimeOkDevPercent = newMetric(
  		"transResponseTimeOkDevPercent", "Deviation per transaction", 
  		"Response time deviation", 
  		ValueType.PERCENT, Metric.DIRECTION_WORST);
  
  public static final Metric transOkPerMinute = newMetric(
  		"transOkPerMinute", "Transactions per minute", 
  		ValueType.FLOAT, Metric.DIRECTION_BETTER);
  
  public static final Metric transOkPerMinuteAndUser = newMetric(
  		"transOkPerMinuteAndUser", "Transactions per minute and user", 
  		ValueType.FLOAT, Metric.DIRECTION_BETTER);
  
  public static final Metric transMapResponseTimeOkAvg = newMetric(
  		"transMapResponseTimeOkAvg", "Response time average", 
  		"Average response time per transaction type",
  		ValueType.DISTRIB, Metric.DIRECTION_WORST);
  
  public static final Metric transMapResponseTimeOkDevPercent = newMetric(
  		"transMapResponseTimeOkDevPercent", "Response time deviation", 
  		"Response time deviation per transaction type",
  		ValueType.DISTRIB, Metric.DIRECTION_WORST);
  
  // Used by Sonar to retrieve the list of metrics
  public List<Metric> getMetrics() {
    return Arrays.asList(requestErrorPercent, testDesc, duration, usersLogged,
        requestTotal, transTotal, requestResponseTimeOkAvg,
        requestResponseTimeOkDevPercent, requestOkPerMinute,
        requestOkPerMinuteAndUser, transResponseTimeOkAvg,
        transResponseTimeOkDevPercent, transOkPerMinute,
        transOkPerMinuteAndUser, transMapResponseTimeOkAvg,
        transMapResponseTimeOkDevPercent);
  }

}

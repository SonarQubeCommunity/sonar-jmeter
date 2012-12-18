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
import org.sonar.api.measures.Metrics;

public class JMeterMetrics implements Metrics {

  public static final String JMETER_DOMAIN = "Performance tests";

  public static final Metric requestErrorPercent = new Metric.Builder(
	"requestErrorPercent", "Errors", Metric.ValueType.PERCENT)
	.setDescription("Errors")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();

  public static final Metric testDesc = new Metric.Builder(
	"testDesc", "Test description", Metric.ValueType.STRING)
	.setDescription("Test description")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_NONE)
	.setDomain(JMETER_DOMAIN)
	.create();
		  
  public static final Metric duration = new Metric.Builder(
	"duration", "Duration", Metric.ValueType.MILLISEC)
	.setDescription("Duration")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_NONE)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric usersLogged = new Metric.Builder(
	"usersLogged", "Users", Metric.ValueType.INT)
	.setDescription("Users")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_NONE)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric requestTotal = new Metric.Builder(
	"requestTotal", "Requests", Metric.ValueType.INT)
	.setDescription("Total requests")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_NONE)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transTotal = new Metric.Builder(
	"transTotal", "Transactions", Metric.ValueType.INT)
	.setDescription("Total transactions")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_NONE)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric requestResponseTimeOkAvg = new Metric.Builder(
	"requestResponseTimeOkAvg", "Response time per request", Metric.ValueType.MILLISEC)
	.setDescription("Average response time per request")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();

  public static final Metric requestResponseTimeOkDevPercent = new Metric.Builder(
	"requestResponseTimeOkDevPercent", "Deviation per request", Metric.ValueType.PERCENT)
	.setDescription("Response time deviation")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();

  public static final Metric requestOkPerMinute = new Metric.Builder(
	"requestOkPerMinute", "Requests per minute", Metric.ValueType.FLOAT)
	.setDescription("Requests per minute")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_BETTER)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric requestOkPerMinuteAndUser = new Metric.Builder(
	"requestOkPerMinuteAndUser", "Requests per minute and user", Metric.ValueType.FLOAT)
	.setDescription("Requests per minute")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_BETTER)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transResponseTimeOkAvg = new Metric.Builder(
	"transResponseTimeOkAvg", "Response time per transaction", Metric.ValueType.MILLISEC)
	.setDescription("Average response time per transaction")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transResponseTimeOkDevPercent = new Metric.Builder(
	"transResponseTimeOkDevPercent", "Deviation per transaction", Metric.ValueType.PERCENT)
	.setDescription("Response time deviation")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transOkPerMinute = new Metric.Builder(
	"transOkPerMinute", "Transactions per minute", Metric.ValueType.FLOAT)
	.setDescription("Transactions per minute")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_BETTER)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transOkPerMinuteAndUser = new Metric.Builder(
	"transOkPerMinuteAndUser", "Transactions per minute and user", Metric.ValueType.FLOAT)
	.setDescription("Transactions per minute and user")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_BETTER)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transMapResponseTimeOkAvg = new Metric.Builder(
	"transMapResponseTimeOkAvg", "Response time average", Metric.ValueType.DISTRIB)
	.setDescription("Average response time per transaction type")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();
  
  public static final Metric transMapResponseTimeOkDevPercent = new Metric.Builder(
	"transMapResponseTimeOkDevPercent", "Response time deviation", Metric.ValueType.DISTRIB)
	.setDescription("Response time deviation per transaction type")
	.setQualitative(false)
	.setDirection(Metric.DIRECTION_WORST)
	.setDomain(JMETER_DOMAIN)
	.create();
  
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

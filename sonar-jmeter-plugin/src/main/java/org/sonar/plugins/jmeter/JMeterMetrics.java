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

  public static final Metric requestErrorPercent = new Metric(
      "requestErrorPercent", "Errors", "Errors", Metric.ValueType.PERCENT,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric testDesc = new Metric("testDesc",
      "Test description", "Test description", Metric.ValueType.STRING,
      Metric.DIRECTION_NONE, false, JMETER_DOMAIN);

  public static final Metric duration = new Metric("duration", "Duration",
      "Duration", Metric.ValueType.MILLISEC, Metric.DIRECTION_NONE, false,
      JMETER_DOMAIN);

  public static final Metric usersLogged = new Metric("usersLogged", "Users",
      "Users", Metric.ValueType.INT, Metric.DIRECTION_NONE, false,
      JMETER_DOMAIN);

  public static final Metric requestTotal = new Metric("requestTotal",
      "Requests", "Total requests", Metric.ValueType.INT,
      Metric.DIRECTION_NONE, false, JMETER_DOMAIN);

  public static final Metric transTotal = new Metric("transTotal",
      "Transactions", "Total transactions", Metric.ValueType.INT,
      Metric.DIRECTION_NONE, false, JMETER_DOMAIN);

  public static final Metric requestResponseTimeOkAvg = new Metric(
      "requestResponseTimeOkAvg", "Response time per request",
      "Average response time per request", Metric.ValueType.MILLISEC,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric requestResponseTimeOkDevPercent = new Metric(
      "requestResponseTimeOkDevPercent", "Deviation per request",
      "Response time deviation", Metric.ValueType.PERCENT,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric requestOkPerMinute = new Metric(
      "requestOkPerMinute", "Requests per minute", "Requests per minute",
      Metric.ValueType.FLOAT, Metric.DIRECTION_BETTER, false, JMETER_DOMAIN);

  public static final Metric requestOkPerMinuteAndUser = new Metric(
      "requestOkPerMinuteAndUser", "Requests per minute and user",
      "Requests per minute and user", Metric.ValueType.FLOAT,
      Metric.DIRECTION_NONE, false, JMETER_DOMAIN);

  public static final Metric transResponseTimeOkAvg = new Metric(
      "transResponseTimeOkAvg", "Response time per transaction",
      "Average response time per transaction", Metric.ValueType.MILLISEC,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric transResponseTimeOkDevPercent = new Metric(
      "transResponseTimeOkDevPercent", "Deviation per transaction",
      "Response time deviation", Metric.ValueType.PERCENT,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric transOkPerMinute = new Metric("transOkPerMinute",
      "Transactions per minute", "Transactions per minute",
      Metric.ValueType.FLOAT, Metric.DIRECTION_BETTER, false, JMETER_DOMAIN);

  public static final Metric transOkPerMinuteAndUser = new Metric(
      "transOkPerMinuteAndUser", "Transactions per minute and user",
      "Transactions per minute and user", Metric.ValueType.FLOAT,
      Metric.DIRECTION_NONE, false, JMETER_DOMAIN);

  public static final Metric transMapResponseTimeOkAvg = new Metric(
      "transMapResponseTimeOkAvg", "Response time average",
      "Average response time per transaction type", Metric.ValueType.DISTRIB,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  public static final Metric transMapResponseTimeOkDevPercent = new Metric(
      "transMapResponseTimeOkDevPercent", "Response time deviation",
      "Response time deviation per transaction type", Metric.ValueType.DISTRIB,
      Metric.DIRECTION_WORST, false, JMETER_DOMAIN);

  // getMetrics() method is defined in the Metrics interface and is used by
  // Sonar to retrieve the list of new Metric
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

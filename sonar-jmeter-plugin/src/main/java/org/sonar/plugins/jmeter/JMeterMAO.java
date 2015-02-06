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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.PropertiesBuilder;

import es.excentia.jmeter.report.client.data.GlobalSummary;

/**
 * JMeterMAO
 * JMeter Metrics Access Object
 * 
 * This class abstracts how JMeter data is saved as Metrics
 *  
 * @author cfillol
 */
public class JMeterMAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(JMeterPostJob.class);
	
	private JMeterMAO() {}

  /**
   * Save GlobalSummary as sonar metrics
   */
  public static void saveSummaryAsMetrics(GlobalSummary summary, SensorContext context) {

      if (LOG.isDebugEnabled()) {
  		  LOG.debug(summary.toString());
      }
  		
      context.saveMeasure(JMeterMetrics.requestErrorPercent, summary.getRequestsErrorPercent());
      context.saveMeasure(new Measure(JMeterMetrics.testDesc, summary.getTestDesc()));
      context.saveMeasure(JMeterMetrics.duration, Double.valueOf(summary.getTestDuration()));
      context.saveMeasure(JMeterMetrics.usersLogged, Double.valueOf(summary.getUsersLogged()));
      context.saveMeasure(JMeterMetrics.requestTotal, Double.valueOf(summary.getRequestsTotal()));
      context.saveMeasure(JMeterMetrics.transTotal, Double.valueOf(summary.getTransTotal()));

      if (summary.getRequestsOkTotal() > 0) {
        context.saveMeasure(JMeterMetrics.requestResponseTimeOkAvg, Double.valueOf(summary.getRequestsResponseTimeOkAvg()));
        if (summary.getRequestsOkTotal() > 1) {
          // Need at least 2 measures to compute dev and total time
          context.saveMeasure(JMeterMetrics.requestResponseTimeOkDevPercent, Double.valueOf(summary.getRequestsResponseTimeOkAvgDevPercent()));
          context.saveMeasure(JMeterMetrics.requestOkPerMinute, Double.valueOf(summary.getRequestsOkPerMinute()));
          context.saveMeasure(JMeterMetrics.requestOkPerMinuteAndUser, Double.valueOf(summary.getRequestsOkPerMinuteAndUser()));
        }
      }
      
      if (summary.getTransOkTotal() > 0) {
        context.saveMeasure(JMeterMetrics.transResponseTimeOkAvg, Double.valueOf(summary.getTransResponseTimeOkAvg()));
        if (summary.getTransOkTotal() > 1) {
          // Need at least 2 measures to compute dev and total time
          context.saveMeasure(JMeterMetrics.transResponseTimeOkDevPercent, Double.valueOf(summary.getTransBytesOkAvgDevPercent()));
          context.saveMeasure(JMeterMetrics.transOkPerMinute, Double.valueOf(summary.getTransOkPerMinute()));
          context.saveMeasure(JMeterMetrics.transOkPerMinuteAndUser, Double.valueOf(summary.getTransOkPerMinuteAndUser()));
        }
        
        // transMapResponseTimeOkAvg
        PropertiesBuilder<String, Double> transMapResponseTimeOkAvgPropBuild = new PropertiesBuilder<String, Double>(
            JMeterMetrics.transMapResponseTimeOkAvg, summary.getTransMapResponseTimeOkAvg());
        context.saveMeasure(new Measure(JMeterMetrics.transMapResponseTimeOkAvg, transMapResponseTimeOkAvgPropBuild.buildData()));

        // transMapResponseTimeOkDevPercent
        if (summary.getTransOkTotal() > 1) {
          PropertiesBuilder<String, Double> transMapResponseTimeOkDevPropBuild = new PropertiesBuilder<String, Double>(
              JMeterMetrics.transMapResponseTimeOkDevPercent, summary.getTransMapResponseTimeOkAvgDevPercent());
          context.saveMeasure(new Measure(JMeterMetrics.transMapResponseTimeOkDevPercent, transMapResponseTimeOkDevPropBuild.buildData()));
        }
      }
      
  }
  
}

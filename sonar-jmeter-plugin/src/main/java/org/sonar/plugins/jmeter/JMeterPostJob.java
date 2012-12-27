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

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.CheckProject;
import org.sonar.api.batch.PostJob;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import es.excentia.jmeter.report.client.data.GlobalSummary;
import es.excentia.jmeter.report.server.data.ConfigInfo;
import es.excentia.jmeter.report.server.service.ConfigService;
import es.excentia.jmeter.report.server.service.OperationService;
import es.excentia.jmeter.report.server.service.ServiceFactory;

public class JMeterPostJob implements PostJob, CheckProject {

  public static final Logger LOG = LoggerFactory.getLogger(JMeterPostJob.class);

  // Local JMeterReportServer services we will use to analize jtl files
  static final ConfigService configService = ServiceFactory.get(ConfigService.class);
  static final OperationService metricService = ServiceFactory.get(OperationService.class);

  public boolean shouldExecuteOnProject(Project project) {
    return true;
  }

  public void executeOn(Project project, SensorContext context) {

    // this sensor is executed if no config defined on sonar server
    String jtlPath = (String) project.getProperty(JMeterPluginConst.LOCAL_JTL_PATH_PROPERTY);
    String config = (String) project.getProperty(JMeterPluginConst.CONFIG_PROPERTY);
    if (StringUtils.isNotBlank(jtlPath) || StringUtils.isNotBlank(config)) {
      return;
    }
    
    LOG.debug("START JMeterPostJob");

    try {

      GlobalSummary summary = getGlobalSummaryFromLocalJTL(project);
      if(summary!=null) {
        JMeterMAO.saveSummaryAsMetrics(summary, context);
      }

    } catch (Exception e) {
      LOG.error("Cannot analyse project '" + project.getName() + "'", e);
    }

    LOG.debug("END JMeterPostJob");
  }

  /**
   * Gets the generated jtl file path, if it was any generated
   */
  protected String getJtlFilePath(Project project, String innerProjectJMeterReportsPath) {
    String baseDirPath = project.getFileSystem().getBasedir().getAbsolutePath();
    File reportDir = new File(baseDirPath + innerProjectJMeterReportsPath);
    
    if (reportDir.exists()) {
      for (File file : (Collection<File>) FileUtils.listFiles(reportDir, new String[] { "jtl" }, true)) {
        return file.getAbsolutePath();
      }
  
      for (File file : (Collection<File>) FileUtils.listFiles(reportDir, new String[] { "xml" }, true)) {
        return file.getAbsolutePath();
      }
    }
    return null;
  }

  /**
   * Gets the GlobalSummary from jtl file in target/jmeter-reports
   */
  protected GlobalSummary getGlobalSummaryFromLocalJTL(Project project) {
    GlobalSummary globalSummary = null;
    String projectName = project.getName();
    
    final String jtlPaths[] = new String[] { "/target/jmeter/results", "/target/jmeter-reports" };
    for (String innerPath : jtlPaths) {
      String jtlPath = getJtlFilePath(project, innerPath);
      if (jtlPath == null) {
        LOG.info("No JTL files found in "+innerPath);
      } else {
        // Get report parsing jtl file
        LOG.info("Getting JMeter results from "+jtlPath);
        ConfigInfo configInfo = new ConfigInfo(jtlPath);
        configService.setTestConfigInfo(projectName, configInfo);
        globalSummary = metricService.getGlobalSummary(projectName);
        LOG.debug("JMeter GlobalSummary:\n"+globalSummary);
        return globalSummary;
      }
    }
    
    return globalSummary;
  }

}

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

import org.sonar.api.Plugin;
import org.sonar.api.Properties;
import org.sonar.api.Property;

@Properties( {
  @Property(key = JMeterPluginConst.LOCAL_JTL_PATH_PROPERTY, name = "Local jtl file", description = "Local jtl file path. If specified no remote config is used.", project = true, global = false),
  @Property(key = JMeterPluginConst.HOST_PROPERTY, name = "Remote server host", description = "Remote jmeter report server host, used for getting remote results if no local jtl file is defined.", project = true, global = true),
  @Property(key = JMeterPluginConst.PORT_PROPERTY, name = "Remote server port", description = "Remote jmeter report server port, used for getting remote results if no local jtl file is defined.", defaultValue = "4444", project = true, global = true),
  @Property(key = JMeterPluginConst.CONFIG_PROPERTY, name = "Remote config name", description = "Remote jmeter report server config name, used for getting remote results if no local jtl file is defined.", project = true, global = false) })
/**
 * This class is the entry point for all extensions
 */
public class JMeterPlugin implements Plugin {

  public String getKey() {
    return "jmeter";
  }

  public String getName() {
    return "JMeter";
  }

  public String getDescription() {
    return "This plugin will show you the summary of jmeter performance test";
  }

  /**
   * This is where we declare all our Sonar extensions
   */
  @SuppressWarnings("unchecked")
  public List getExtensions() {
    return Arrays.asList(JMeterMetrics.class, JMeterSensor.class,
        JMeterDashboardWidget.class
    // , GwtJMeterPage.class
        );
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}

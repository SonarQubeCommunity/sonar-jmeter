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

import org.junit.Test;
import org.sonar.api.resources.Project;
import org.sonar.plugins.ResourceProjectFileSystem;
import org.sonar.plugins.MockSensorContext;


public class JMeterPostJobTest {

  JMeterPostJob job = new JMeterPostJob();
  
  @Test
  public void test() {

    Project project = new Project("JMeterPostJobTest","","JMeterPostJobTest"); // Force "test-http" as config name
    project.setFileSystem(new ResourceProjectFileSystem("mproj"));
    
    job.executeOn(project, new MockSensorContext());
    //Assert.assertNotNull(job.getGlobalSummary(project));
  }
  
}

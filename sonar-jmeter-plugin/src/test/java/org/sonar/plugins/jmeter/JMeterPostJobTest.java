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

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.ProjectFileSystem;
import org.sonar.plugins.MockSensorContext;

import es.excentia.jmeter.report.client.data.GlobalSummary;


public class JMeterPostJobTest {
  
  // Extend original class to save globalSummary reference
  class JMeterPostJobForTesting extends JMeterPostJob {
    private GlobalSummary globalSumary;
    public GlobalSummary getGlobalSummary() { 
      return globalSumary; 
    }
    
    protected GlobalSummary getGlobalSummaryFromLocalJTL(Project project) {
      this.globalSumary = super.getGlobalSummaryFromLocalJTL(project);
      return this.globalSumary;
    };
  };
  
  JMeterPostJobForTesting job = new JMeterPostJobForTesting();
  
  @Test
  public void test() {
    
    ProjectFileSystem projectFileSystem = mock(ProjectFileSystem.class);
    File testProjectFolder = new File("src/test/resources/test-project");
    doReturn(testProjectFolder).when(projectFileSystem).getBasedir();
    
    Project project = spy(new Project("JMeterPostJobTest","","JMeterPostJobTest"));
    doReturn(projectFileSystem).when(project).getFileSystem();
    
    job.executeOn(project, new MockSensorContext());
    Assert.assertNotNull(job.getGlobalSummary());
  }
  
}

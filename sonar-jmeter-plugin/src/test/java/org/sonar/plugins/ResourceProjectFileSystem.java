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

package org.sonar.plugins;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.sonar.api.resources.InputFile;
import org.sonar.api.resources.Language;
import org.sonar.api.resources.ProjectFileSystem;
import org.sonar.api.resources.Resource;


public class ResourceProjectFileSystem implements ProjectFileSystem {

  String resourcePath;
  public ResourceProjectFileSystem(String resourcePath) {
    this.resourcePath = resourcePath;
  }
  
  public ProjectFileSystem addSourceDir(File arg0) {
    throw new NotImplementedException();
  }

  public ProjectFileSystem addTestDir(File arg0) {
    throw new NotImplementedException();
  }

  public File getBasedir() {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(resourcePath).getFile());
  }

  public File getBuildDir() {
    throw new NotImplementedException();
  }

  public File getBuildOutputDir() {
    throw new NotImplementedException();
  }

  public File getFileFromBuildDirectory(String arg0) {
    throw new NotImplementedException();
  }

  public List<File> getJavaSourceFiles() {
    throw new NotImplementedException();
  }

  public File getReportOutputDir() {
    throw new NotImplementedException();
  }

  public File getSonarWorkingDirectory() {
    throw new NotImplementedException();
  }

  public Charset getSourceCharset() {
    throw new NotImplementedException();
  }

  public List<File> getSourceDirs() {
    throw new NotImplementedException();
  }

  public List<File> getSourceFiles(Language... arg0) {
    throw new NotImplementedException();
  }

  public List<File> getTestDirs() {
    throw new NotImplementedException();
  }

  public List<File> getTestFiles(Language... arg0) {
    throw new NotImplementedException();
  }

  public boolean hasJavaSourceFiles() {
    throw new NotImplementedException();
  }

  public boolean hasTestFiles(Language arg0) {
    throw new NotImplementedException();
  }

  public File resolvePath(String arg0) {
    throw new NotImplementedException();
  }

  @SuppressWarnings("rawtypes")
  public Resource toResource(File arg0) {
    throw new NotImplementedException();
  }

  public File writeToWorkingDirectory(String arg0, String arg1) throws IOException {
    throw new NotImplementedException();
  }

  public List<InputFile> mainFiles(String... langs) {
    throw new NotImplementedException();
  }

  public List<InputFile> testFiles(String... langs) {
    throw new NotImplementedException();
  }

}

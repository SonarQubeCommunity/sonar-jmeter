/*
 * JMeter Report Server
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

package es.excentia.jmeter.report.server.report;

import java.util.HashMap;
import java.util.Map;

import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;

public class OkUserAccessCounter extends ReportData {
  protected Map<String, Long> accessByUserCount = new HashMap<String, Long>();
  protected long distictUsersCount;

  public Map<String, Long> getAccessByUserCount() {
    return accessByUserCount;
  }

  public long getDistictUsersCount() {
    return distictUsersCount;
  }

  @Override
  public void addMeasure(AbstractSample sample) {
    if (sample.getS()) {
      String tn = sample.getTn();
      Long accessCount = accessByUserCount.get(tn);
      if (accessCount == null) {
        distictUsersCount++;
        accessByUserCount.put(tn, (long) 1);
      } else {
        accessByUserCount.put(tn, accessCount++);
      }
    }
  }

  @Override
  public String toString() {
    return Long.toString(distictUsersCount) + " " + accessByUserCount;
  }

}

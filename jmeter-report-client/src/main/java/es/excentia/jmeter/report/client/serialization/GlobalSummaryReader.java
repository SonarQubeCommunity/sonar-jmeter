/*
 * JMeter Report Client
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

package es.excentia.jmeter.report.client.serialization;

import java.io.IOException;
import java.io.InputStream;

import es.excentia.jmeter.report.client.data.GlobalSummary;

public class GlobalSummaryReader extends BasicReader<GlobalSummary> {

  public GlobalSummaryReader(InputStream is) {
    super(is);
  }

  @Override
  public GlobalSummary getObjectFromStream() throws IOException {
    GlobalSummary summary = new GlobalSummary();

    summary.setTestDesc(readString());

    summary.setUsersLogged(dis.readLong());
    summary.setTestDuration(dis.readLong());

    summary.setRequestsTotal(dis.readLong());
    summary.setRequestsOkTotal(dis.readLong());
    summary.setRequestsErrorTotal(dis.readLong());
    summary.setRequestsErrorPercent(dis.readDouble());

    summary.setRequestsOkPerMinute(dis.readDouble());
    summary.setRequestsOkPerMinuteAndUser(dis.readDouble());

    summary.setRequestsResponseTimeOkAvg(dis.readDouble());
    summary.setRequestsResponseTimeOkAvgDev(dis.readDouble());
    summary.setRequestsResponseTimeOkAvgDevPercent(dis.readDouble());

    summary.setRequestsBytesOkAvg(dis.readDouble());
    summary.setRequestsBytesOkAvgDev(dis.readDouble());
    summary.setRequestsBytesOkAvgDevPercent(dis.readDouble());

    summary.setTransTotal(dis.readLong());
    summary.setTransOkTotal(dis.readLong());
    summary.setTransErrorTotal(dis.readLong());
    summary.setTransErrorPercent(dis.readDouble());

    summary.setTransOkPerMinute(dis.readDouble());
    summary.setTransOkPerMinuteAndUser(dis.readDouble());

    summary.setTransResponseTimeOkAvg(dis.readDouble());
    summary.setTransResponseTimeOkAvgDev(dis.readDouble());
    summary.setTransResponseTimeOkAvgDevPercent(dis.readDouble());

    summary.setTransBytesOkAvg(dis.readDouble());
    summary.setTransBytesOkAvgDev(dis.readDouble());
    summary.setTransBytesOkAvgDevPercent(dis.readDouble());

    summary.setSlowestTransName(readString());
    summary.setSlowestTransResponseTimeOkAvg(dis.readDouble());
    summary.setSlowestTransBytesOkAvgDevPercent(dis.readDouble());

    summary.setMostUnstableTransName(readString());
    summary.setMostUnstableTransResponseTimeOkAvgDevPercent(dis.readDouble());
    summary.setMostUnstableTransBytesOkAvgDevPercent(dis.readDouble());

    summary.setTransOrder(readStringList());
    summary.setTransMapOkTotal(readMapLong());
    summary.setTransMapErrorTotal(readMapLong());

    summary.setTransMapResponseTimeOkAvg(readMapDouble());
    summary.setTransMapResponseTimeOkAvgDev(readMapDouble());
    summary.setTransMapResponseTimeOkAvgDevPercent(readMapDouble());

    summary.setTransMapBytesOkAvg(readMapDouble());
    summary.setTransMapBytesOkAvgDev(readMapDouble());
    summary.setTransMapBytesOkAvgDevPercent(readMapDouble());

    return summary;
  }

}

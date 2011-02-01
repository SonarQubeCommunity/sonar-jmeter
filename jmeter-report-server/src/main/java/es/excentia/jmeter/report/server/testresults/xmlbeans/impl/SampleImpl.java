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

package es.excentia.jmeter.report.server.testresults.xmlbeans.impl;

public class SampleImpl extends es.excentia.jmeter.report.server.testresults.xmlbeans.impl.AbstractSampleImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.Sample
{
    private static final long serialVersionUID = 1L;
    
    public SampleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HTTPSAMPLE$0 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "httpSample");
    private static final javax.xml.namespace.QName SAMPLE$2 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "sample");
    
    
    /**
     * Gets array of all "httpSample" elements
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[] getHttpSampleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(HTTPSAMPLE$0, targetList);
            es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[] result = new es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "httpSample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample getHttpSampleArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample)get_store().find_element_user(HTTPSAMPLE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "httpSample" element
     */
    public int sizeOfHttpSampleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HTTPSAMPLE$0);
        }
    }
    
    /**
     * Sets array of all "httpSample" element
     */
    public void setHttpSampleArray(es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[] httpSampleArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(httpSampleArray, HTTPSAMPLE$0);
        }
    }
    
    /**
     * Sets ith "httpSample" element
     */
    public void setHttpSampleArray(int i, es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample httpSample)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample)get_store().find_element_user(HTTPSAMPLE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(httpSample);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "httpSample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample insertNewHttpSample(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample)get_store().insert_element_user(HTTPSAMPLE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "httpSample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample addNewHttpSample()
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample)get_store().add_element_user(HTTPSAMPLE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "httpSample" element
     */
    public void removeHttpSample(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HTTPSAMPLE$0, i);
        }
    }
    
    /**
     * Gets array of all "sample" elements
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[] getSampleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SAMPLE$2, targetList);
            es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[] result = new es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "sample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.Sample getSampleArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.Sample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.Sample)get_store().find_element_user(SAMPLE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "sample" element
     */
    public int sizeOfSampleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SAMPLE$2);
        }
    }
    
    /**
     * Sets array of all "sample" element
     */
    public void setSampleArray(es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[] sampleArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(sampleArray, SAMPLE$2);
        }
    }
    
    /**
     * Sets ith "sample" element
     */
    public void setSampleArray(int i, es.excentia.jmeter.report.server.testresults.xmlbeans.Sample sample)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.Sample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.Sample)get_store().find_element_user(SAMPLE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(sample);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "sample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.Sample insertNewSample(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.Sample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.Sample)get_store().insert_element_user(SAMPLE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "sample" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.Sample addNewSample()
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.Sample target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.Sample)get_store().add_element_user(SAMPLE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "sample" element
     */
    public void removeSample(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SAMPLE$2, i);
        }
    }
}

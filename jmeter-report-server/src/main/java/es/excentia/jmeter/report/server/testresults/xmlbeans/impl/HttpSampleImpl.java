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

public class HttpSampleImpl extends es.excentia.jmeter.report.server.testresults.xmlbeans.impl.AbstractSampleImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample
{
    private static final long serialVersionUID = 1L;
    
    public HttpSampleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HTTPSAMPLE$0 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "httpSample");
    private static final javax.xml.namespace.QName ASSERTIONRESULT$2 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "assertionResult");
    
    
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
     * Gets array of all "assertionResult" elements
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult[] getAssertionResultArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ASSERTIONRESULT$2, targetList);
            es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult[] result = new es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "assertionResult" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult getAssertionResultArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult)get_store().find_element_user(ASSERTIONRESULT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "assertionResult" element
     */
    public int sizeOfAssertionResultArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSERTIONRESULT$2);
        }
    }
    
    /**
     * Sets array of all "assertionResult" element
     */
    public void setAssertionResultArray(es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult[] assertionResultArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(assertionResultArray, ASSERTIONRESULT$2);
        }
    }
    
    /**
     * Sets ith "assertionResult" element
     */
    public void setAssertionResultArray(int i, es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult assertionResult)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult)get_store().find_element_user(ASSERTIONRESULT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(assertionResult);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "assertionResult" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult insertNewAssertionResult(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult)get_store().insert_element_user(ASSERTIONRESULT$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "assertionResult" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult addNewAssertionResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult)get_store().add_element_user(ASSERTIONRESULT$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "assertionResult" element
     */
    public void removeAssertionResult(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSERTIONRESULT$2, i);
        }
    }
}

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

/*
 * XML Type:  AssertionResult
 * Namespace: http://xmlbeans.testresults.server.report.jmeter.excentia.es
 * Java type: es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult
 *
 * Automatically generated - do not modify.
 */
package es.excentia.jmeter.report.server.testresults.xmlbeans.impl;
/**
 * An XML AssertionResult(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
 *
 * This is a complex type.
 */
public class AssertionResultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult
{
    private static final long serialVersionUID = 1L;
    
    public AssertionResultImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NAME$0 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "name");
    private static final javax.xml.namespace.QName FAILURE$2 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "failure");
    private static final javax.xml.namespace.QName ERROR$4 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "error");
    private static final javax.xml.namespace.QName FAILUREMESSAGE$6 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "failureMessage");
    
    
    /**
     * Gets the "name" element
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" element
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "name" element
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NAME$0) != 0;
        }
    }
    
    /**
     * Sets the "name" element
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" element
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" element
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NAME$0, 0);
        }
    }
    
    /**
     * Gets the "failure" element
     */
    public boolean getFailure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILURE$2, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "failure" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetFailure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(FAILURE$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "failure" element
     */
    public boolean isSetFailure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FAILURE$2) != 0;
        }
    }
    
    /**
     * Sets the "failure" element
     */
    public void setFailure(boolean failure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILURE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAILURE$2);
            }
            target.setBooleanValue(failure);
        }
    }
    
    /**
     * Sets (as xml) the "failure" element
     */
    public void xsetFailure(org.apache.xmlbeans.XmlBoolean failure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(FAILURE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(FAILURE$2);
            }
            target.set(failure);
        }
    }
    
    /**
     * Unsets the "failure" element
     */
    public void unsetFailure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FAILURE$2, 0);
        }
    }
    
    /**
     * Gets the "error" element
     */
    public boolean getError()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERROR$4, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "error" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetError()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ERROR$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "error" element
     */
    public boolean isSetError()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ERROR$4) != 0;
        }
    }
    
    /**
     * Sets the "error" element
     */
    public void setError(boolean error)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERROR$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERROR$4);
            }
            target.setBooleanValue(error);
        }
    }
    
    /**
     * Sets (as xml) the "error" element
     */
    public void xsetError(org.apache.xmlbeans.XmlBoolean error)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ERROR$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ERROR$4);
            }
            target.set(error);
        }
    }
    
    /**
     * Unsets the "error" element
     */
    public void unsetError()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ERROR$4, 0);
        }
    }
    
    /**
     * Gets the "failureMessage" element
     */
    public java.lang.String getFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILUREMESSAGE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "failureMessage" element
     */
    public org.apache.xmlbeans.XmlString xgetFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAILUREMESSAGE$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "failureMessage" element
     */
    public boolean isSetFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FAILUREMESSAGE$6) != 0;
        }
    }
    
    /**
     * Sets the "failureMessage" element
     */
    public void setFailureMessage(java.lang.String failureMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILUREMESSAGE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAILUREMESSAGE$6);
            }
            target.setStringValue(failureMessage);
        }
    }
    
    /**
     * Sets (as xml) the "failureMessage" element
     */
    public void xsetFailureMessage(org.apache.xmlbeans.XmlString failureMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAILUREMESSAGE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAILUREMESSAGE$6);
            }
            target.set(failureMessage);
        }
    }
    
    /**
     * Unsets the "failureMessage" element
     */
    public void unsetFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FAILUREMESSAGE$6, 0);
        }
    }
}

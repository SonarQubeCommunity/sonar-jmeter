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
/**
 * An XML AbstractSample(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
 *
 * This is a complex type.
 */
public class AbstractSampleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample
{
    private static final long serialVersionUID = 1L;
    
    public AbstractSampleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName T$0 = 
        new javax.xml.namespace.QName("", "t");
    private static final javax.xml.namespace.QName LT$2 = 
        new javax.xml.namespace.QName("", "lt");
    private static final javax.xml.namespace.QName TS$4 = 
        new javax.xml.namespace.QName("", "ts");
    private static final javax.xml.namespace.QName S$6 = 
        new javax.xml.namespace.QName("", "s");
    private static final javax.xml.namespace.QName LB$8 = 
        new javax.xml.namespace.QName("", "lb");
    private static final javax.xml.namespace.QName RC$10 = 
        new javax.xml.namespace.QName("", "rc");
    private static final javax.xml.namespace.QName RM$12 = 
        new javax.xml.namespace.QName("", "rm");
    private static final javax.xml.namespace.QName TN$14 = 
        new javax.xml.namespace.QName("", "tn");
    private static final javax.xml.namespace.QName DT$16 = 
        new javax.xml.namespace.QName("", "dt");
    private static final javax.xml.namespace.QName BY$18 = 
        new javax.xml.namespace.QName("", "by");
    
    
    /**
     * Gets the "t" attribute
     */
    public long getT()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(T$0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "t" attribute
     */
    public org.apache.xmlbeans.XmlLong xgetT()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(T$0);
            return target;
        }
    }
    
    /**
     * Sets the "t" attribute
     */
    public void setT(long t)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(T$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(T$0);
            }
            target.setLongValue(t);
        }
    }
    
    /**
     * Sets (as xml) the "t" attribute
     */
    public void xsetT(org.apache.xmlbeans.XmlLong t)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(T$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(T$0);
            }
            target.set(t);
        }
    }
    
    /**
     * Gets the "lt" attribute
     */
    public long getLt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LT$2);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "lt" attribute
     */
    public org.apache.xmlbeans.XmlLong xgetLt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(LT$2);
            return target;
        }
    }
    
    /**
     * True if has "lt" attribute
     */
    public boolean isSetLt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LT$2) != null;
        }
    }
    
    /**
     * Sets the "lt" attribute
     */
    public void setLt(long lt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LT$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LT$2);
            }
            target.setLongValue(lt);
        }
    }
    
    /**
     * Sets (as xml) the "lt" attribute
     */
    public void xsetLt(org.apache.xmlbeans.XmlLong lt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(LT$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(LT$2);
            }
            target.set(lt);
        }
    }
    
    /**
     * Unsets the "lt" attribute
     */
    public void unsetLt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LT$2);
        }
    }
    
    /**
     * Gets the "ts" attribute
     */
    public long getTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TS$4);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "ts" attribute
     */
    public org.apache.xmlbeans.XmlLong xgetTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TS$4);
            return target;
        }
    }
    
    /**
     * True if has "ts" attribute
     */
    public boolean isSetTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(TS$4) != null;
        }
    }
    
    /**
     * Sets the "ts" attribute
     */
    public void setTs(long ts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TS$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TS$4);
            }
            target.setLongValue(ts);
        }
    }
    
    /**
     * Sets (as xml) the "ts" attribute
     */
    public void xsetTs(org.apache.xmlbeans.XmlLong ts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(TS$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(TS$4);
            }
            target.set(ts);
        }
    }
    
    /**
     * Unsets the "ts" attribute
     */
    public void unsetTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(TS$4);
        }
    }
    
    /**
     * Gets the "s" attribute
     */
    public boolean getS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(S$6);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "s" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(S$6);
            return target;
        }
    }
    
    /**
     * True if has "s" attribute
     */
    public boolean isSetS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(S$6) != null;
        }
    }
    
    /**
     * Sets the "s" attribute
     */
    public void setS(boolean s)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(S$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(S$6);
            }
            target.setBooleanValue(s);
        }
    }
    
    /**
     * Sets (as xml) the "s" attribute
     */
    public void xsetS(org.apache.xmlbeans.XmlBoolean s)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(S$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(S$6);
            }
            target.set(s);
        }
    }
    
    /**
     * Unsets the "s" attribute
     */
    public void unsetS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(S$6);
        }
    }
    
    /**
     * Gets the "lb" attribute
     */
    public java.lang.String getLb()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LB$8);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "lb" attribute
     */
    public org.apache.xmlbeans.XmlString xgetLb()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LB$8);
            return target;
        }
    }
    
    /**
     * True if has "lb" attribute
     */
    public boolean isSetLb()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LB$8) != null;
        }
    }
    
    /**
     * Sets the "lb" attribute
     */
    public void setLb(java.lang.String lb)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LB$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LB$8);
            }
            target.setStringValue(lb);
        }
    }
    
    /**
     * Sets (as xml) the "lb" attribute
     */
    public void xsetLb(org.apache.xmlbeans.XmlString lb)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LB$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LB$8);
            }
            target.set(lb);
        }
    }
    
    /**
     * Unsets the "lb" attribute
     */
    public void unsetLb()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LB$8);
        }
    }
    
    /**
     * Gets the "rc" attribute
     */
    public java.lang.String getRc()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RC$10);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "rc" attribute
     */
    public org.apache.xmlbeans.XmlString xgetRc()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RC$10);
            return target;
        }
    }
    
    /**
     * True if has "rc" attribute
     */
    public boolean isSetRc()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RC$10) != null;
        }
    }
    
    /**
     * Sets the "rc" attribute
     */
    public void setRc(java.lang.String rc)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RC$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RC$10);
            }
            target.setStringValue(rc);
        }
    }
    
    /**
     * Sets (as xml) the "rc" attribute
     */
    public void xsetRc(org.apache.xmlbeans.XmlString rc)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RC$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RC$10);
            }
            target.set(rc);
        }
    }
    
    /**
     * Unsets the "rc" attribute
     */
    public void unsetRc()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RC$10);
        }
    }
    
    /**
     * Gets the "rm" attribute
     */
    public java.lang.String getRm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RM$12);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "rm" attribute
     */
    public org.apache.xmlbeans.XmlString xgetRm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RM$12);
            return target;
        }
    }
    
    /**
     * True if has "rm" attribute
     */
    public boolean isSetRm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RM$12) != null;
        }
    }
    
    /**
     * Sets the "rm" attribute
     */
    public void setRm(java.lang.String rm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RM$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RM$12);
            }
            target.setStringValue(rm);
        }
    }
    
    /**
     * Sets (as xml) the "rm" attribute
     */
    public void xsetRm(org.apache.xmlbeans.XmlString rm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RM$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RM$12);
            }
            target.set(rm);
        }
    }
    
    /**
     * Unsets the "rm" attribute
     */
    public void unsetRm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RM$12);
        }
    }
    
    /**
     * Gets the "tn" attribute
     */
    public java.lang.String getTn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TN$14);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "tn" attribute
     */
    public org.apache.xmlbeans.XmlString xgetTn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TN$14);
            return target;
        }
    }
    
    /**
     * True if has "tn" attribute
     */
    public boolean isSetTn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(TN$14) != null;
        }
    }
    
    /**
     * Sets the "tn" attribute
     */
    public void setTn(java.lang.String tn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TN$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TN$14);
            }
            target.setStringValue(tn);
        }
    }
    
    /**
     * Sets (as xml) the "tn" attribute
     */
    public void xsetTn(org.apache.xmlbeans.XmlString tn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TN$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TN$14);
            }
            target.set(tn);
        }
    }
    
    /**
     * Unsets the "tn" attribute
     */
    public void unsetTn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(TN$14);
        }
    }
    
    /**
     * Gets the "dt" attribute
     */
    public java.lang.String getDt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DT$16);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "dt" attribute
     */
    public org.apache.xmlbeans.XmlString xgetDt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DT$16);
            return target;
        }
    }
    
    /**
     * True if has "dt" attribute
     */
    public boolean isSetDt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DT$16) != null;
        }
    }
    
    /**
     * Sets the "dt" attribute
     */
    public void setDt(java.lang.String dt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DT$16);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DT$16);
            }
            target.setStringValue(dt);
        }
    }
    
    /**
     * Sets (as xml) the "dt" attribute
     */
    public void xsetDt(org.apache.xmlbeans.XmlString dt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DT$16);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DT$16);
            }
            target.set(dt);
        }
    }
    
    /**
     * Unsets the "dt" attribute
     */
    public void unsetDt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DT$16);
        }
    }
    
    /**
     * Gets the "by" attribute
     */
    public long getBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BY$18);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "by" attribute
     */
    public org.apache.xmlbeans.XmlLong xgetBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(BY$18);
            return target;
        }
    }
    
    /**
     * True if has "by" attribute
     */
    public boolean isSetBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(BY$18) != null;
        }
    }
    
    /**
     * Sets the "by" attribute
     */
    public void setBy(long by)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BY$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BY$18);
            }
            target.setLongValue(by);
        }
    }
    
    /**
     * Sets (as xml) the "by" attribute
     */
    public void xsetBy(org.apache.xmlbeans.XmlLong by)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(BY$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(BY$18);
            }
            target.set(by);
        }
    }
    
    /**
     * Unsets the "by" attribute
     */
    public void unsetBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(BY$18);
        }
    }
}

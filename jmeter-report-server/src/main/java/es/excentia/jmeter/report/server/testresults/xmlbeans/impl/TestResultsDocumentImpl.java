/*
 * An XML document type.
 * Localname: testResults
 * Namespace: http://xmlbeans.testresults.server.report.jmeter.excentia.es
 * Java type: es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument
 *
 * Automatically generated - do not modify.
 */
package es.excentia.jmeter.report.server.testresults.xmlbeans.impl;
/**
 * A document containing one testResults(@http://xmlbeans.testresults.server.report.jmeter.excentia.es) element.
 *
 * This is a complex type.
 */
public class TestResultsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument
{
    private static final long serialVersionUID = 1L;
    
    public TestResultsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TESTRESULTS$0 = 
        new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "testResults");
    
    
    /**
     * Gets the "testResults" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults getTestResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults)get_store().find_element_user(TESTRESULTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "testResults" element
     */
    public void setTestResults(es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults testResults)
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults)get_store().find_element_user(TESTRESULTS$0, 0);
            if (target == null)
            {
                target = (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults)get_store().add_element_user(TESTRESULTS$0);
            }
            target.set(testResults);
        }
    }
    
    /**
     * Appends and returns a new empty "testResults" element
     */
    public es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults addNewTestResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults target = null;
            target = (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults)get_store().add_element_user(TESTRESULTS$0);
            return target;
        }
    }
    /**
     * An XML testResults(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
     *
     * This is a complex type.
     */
    public static class TestResultsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults
    {
        private static final long serialVersionUID = 1L;
        
        public TestResultsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName HTTPSAMPLE$0 = 
            new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "httpSample");
        private static final javax.xml.namespace.QName SAMPLE$2 = 
            new javax.xml.namespace.QName("http://xmlbeans.testresults.server.report.jmeter.excentia.es", "sample");
        private static final javax.xml.namespace.QName VERSION$4 = 
            new javax.xml.namespace.QName("", "version");
        
        
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
        
        /**
         * Gets the "version" attribute
         */
        public java.lang.String getVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "version" attribute
         */
        public org.apache.xmlbeans.XmlString xgetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$4);
                return target;
            }
        }
        
        /**
         * True if has "version" attribute
         */
        public boolean isSetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VERSION$4) != null;
            }
        }
        
        /**
         * Sets the "version" attribute
         */
        public void setVersion(java.lang.String version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$4);
                }
                target.setStringValue(version);
            }
        }
        
        /**
         * Sets (as xml) the "version" attribute
         */
        public void xsetVersion(org.apache.xmlbeans.XmlString version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VERSION$4);
                }
                target.set(version);
            }
        }
        
        /**
         * Unsets the "version" attribute
         */
        public void unsetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VERSION$4);
            }
        }
    }
}

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

package es.excentia.jmeter.report.server.testresults.xmlbeans;


/**
 * A document containing one testResults(@http://xmlbeans.testresults.server.report.jmeter.excentia.es) element.
 *
 * This is a complex type.
 */
public interface TestResultsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TestResultsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s778605888A309E5BD3ECE7423A8B538B").resolveHandle("testresults4ed8doctype");
    
    /**
     * Gets the "testResults" element
     */
    es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults getTestResults();
    
    /**
     * Sets the "testResults" element
     */
    void setTestResults(es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults testResults);
    
    /**
     * Appends and returns a new empty "testResults" element
     */
    es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults addNewTestResults();
    
    /**
     * An XML testResults(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
     *
     * This is a complex type.
     */
    public interface TestResults extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TestResults.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s778605888A309E5BD3ECE7423A8B538B").resolveHandle("testresultsf968elemtype");
        
        /**
         * Gets array of all "httpSample" elements
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[] getHttpSampleArray();
        
        /**
         * Gets ith "httpSample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample getHttpSampleArray(int i);
        
        /**
         * Returns number of "httpSample" element
         */
        int sizeOfHttpSampleArray();
        
        /**
         * Sets array of all "httpSample" element
         */
        void setHttpSampleArray(es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample[] httpSampleArray);
        
        /**
         * Sets ith "httpSample" element
         */
        void setHttpSampleArray(int i, es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample httpSample);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "httpSample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample insertNewHttpSample(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "httpSample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample addNewHttpSample();
        
        /**
         * Removes the ith "httpSample" element
         */
        void removeHttpSample(int i);
        
        /**
         * Gets array of all "sample" elements
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[] getSampleArray();
        
        /**
         * Gets ith "sample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.Sample getSampleArray(int i);
        
        /**
         * Returns number of "sample" element
         */
        int sizeOfSampleArray();
        
        /**
         * Sets array of all "sample" element
         */
        void setSampleArray(es.excentia.jmeter.report.server.testresults.xmlbeans.Sample[] sampleArray);
        
        /**
         * Sets ith "sample" element
         */
        void setSampleArray(int i, es.excentia.jmeter.report.server.testresults.xmlbeans.Sample sample);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "sample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.Sample insertNewSample(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "sample" element
         */
        es.excentia.jmeter.report.server.testresults.xmlbeans.Sample addNewSample();
        
        /**
         * Removes the ith "sample" element
         */
        void removeSample(int i);
        
        /**
         * Gets the "version" attribute
         */
        java.lang.String getVersion();
        
        /**
         * Gets (as xml) the "version" attribute
         */
        org.apache.xmlbeans.XmlString xgetVersion();
        
        /**
         * True if has "version" attribute
         */
        boolean isSetVersion();
        
        /**
         * Sets the "version" attribute
         */
        void setVersion(java.lang.String version);
        
        /**
         * Sets (as xml) the "version" attribute
         */
        void xsetVersion(org.apache.xmlbeans.XmlString version);
        
        /**
         * Unsets the "version" attribute
         */
        void unsetVersion();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults newInstance() {
              return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument newInstance() {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

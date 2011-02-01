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
 * An XML AssertionResult(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
 *
 * This is a complex type.
 */
public interface AssertionResult extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AssertionResult.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s778605888A309E5BD3ECE7423A8B538B").resolveHandle("assertionresultc78dtype");
    
    /**
     * Gets the "name" element
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" element
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * True if has "name" element
     */
    boolean isSetName();
    
    /**
     * Sets the "name" element
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" element
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Unsets the "name" element
     */
    void unsetName();
    
    /**
     * Gets the "failure" element
     */
    boolean getFailure();
    
    /**
     * Gets (as xml) the "failure" element
     */
    org.apache.xmlbeans.XmlBoolean xgetFailure();
    
    /**
     * True if has "failure" element
     */
    boolean isSetFailure();
    
    /**
     * Sets the "failure" element
     */
    void setFailure(boolean failure);
    
    /**
     * Sets (as xml) the "failure" element
     */
    void xsetFailure(org.apache.xmlbeans.XmlBoolean failure);
    
    /**
     * Unsets the "failure" element
     */
    void unsetFailure();
    
    /**
     * Gets the "error" element
     */
    boolean getError();
    
    /**
     * Gets (as xml) the "error" element
     */
    org.apache.xmlbeans.XmlBoolean xgetError();
    
    /**
     * True if has "error" element
     */
    boolean isSetError();
    
    /**
     * Sets the "error" element
     */
    void setError(boolean error);
    
    /**
     * Sets (as xml) the "error" element
     */
    void xsetError(org.apache.xmlbeans.XmlBoolean error);
    
    /**
     * Unsets the "error" element
     */
    void unsetError();
    
    /**
     * Gets the "failureMessage" element
     */
    java.lang.String getFailureMessage();
    
    /**
     * Gets (as xml) the "failureMessage" element
     */
    org.apache.xmlbeans.XmlString xgetFailureMessage();
    
    /**
     * True if has "failureMessage" element
     */
    boolean isSetFailureMessage();
    
    /**
     * Sets the "failureMessage" element
     */
    void setFailureMessage(java.lang.String failureMessage);
    
    /**
     * Sets (as xml) the "failureMessage" element
     */
    void xsetFailureMessage(org.apache.xmlbeans.XmlString failureMessage);
    
    /**
     * Unsets the "failureMessage" element
     */
    void unsetFailureMessage();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult newInstance() {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AssertionResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

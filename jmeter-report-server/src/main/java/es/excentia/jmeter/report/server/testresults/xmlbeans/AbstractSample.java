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
 * An XML AbstractSample(@http://xmlbeans.testresults.server.report.jmeter.excentia.es).
 *
 * This is a complex type.
 */
public interface AbstractSample extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AbstractSample.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s778605888A309E5BD3ECE7423A8B538B").resolveHandle("abstractsample80cetype");
    
    /**
     * Gets the "t" attribute
     */
    long getT();
    
    /**
     * Gets (as xml) the "t" attribute
     */
    org.apache.xmlbeans.XmlLong xgetT();
    
    /**
     * Sets the "t" attribute
     */
    void setT(long t);
    
    /**
     * Sets (as xml) the "t" attribute
     */
    void xsetT(org.apache.xmlbeans.XmlLong t);
    
    /**
     * Gets the "lt" attribute
     */
    long getLt();
    
    /**
     * Gets (as xml) the "lt" attribute
     */
    org.apache.xmlbeans.XmlLong xgetLt();
    
    /**
     * True if has "lt" attribute
     */
    boolean isSetLt();
    
    /**
     * Sets the "lt" attribute
     */
    void setLt(long lt);
    
    /**
     * Sets (as xml) the "lt" attribute
     */
    void xsetLt(org.apache.xmlbeans.XmlLong lt);
    
    /**
     * Unsets the "lt" attribute
     */
    void unsetLt();
    
    /**
     * Gets the "ts" attribute
     */
    long getTs();
    
    /**
     * Gets (as xml) the "ts" attribute
     */
    org.apache.xmlbeans.XmlLong xgetTs();
    
    /**
     * True if has "ts" attribute
     */
    boolean isSetTs();
    
    /**
     * Sets the "ts" attribute
     */
    void setTs(long ts);
    
    /**
     * Sets (as xml) the "ts" attribute
     */
    void xsetTs(org.apache.xmlbeans.XmlLong ts);
    
    /**
     * Unsets the "ts" attribute
     */
    void unsetTs();
    
    /**
     * Gets the "s" attribute
     */
    boolean getS();
    
    /**
     * Gets (as xml) the "s" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetS();
    
    /**
     * True if has "s" attribute
     */
    boolean isSetS();
    
    /**
     * Sets the "s" attribute
     */
    void setS(boolean s);
    
    /**
     * Sets (as xml) the "s" attribute
     */
    void xsetS(org.apache.xmlbeans.XmlBoolean s);
    
    /**
     * Unsets the "s" attribute
     */
    void unsetS();
    
    /**
     * Gets the "lb" attribute
     */
    java.lang.String getLb();
    
    /**
     * Gets (as xml) the "lb" attribute
     */
    org.apache.xmlbeans.XmlString xgetLb();
    
    /**
     * True if has "lb" attribute
     */
    boolean isSetLb();
    
    /**
     * Sets the "lb" attribute
     */
    void setLb(java.lang.String lb);
    
    /**
     * Sets (as xml) the "lb" attribute
     */
    void xsetLb(org.apache.xmlbeans.XmlString lb);
    
    /**
     * Unsets the "lb" attribute
     */
    void unsetLb();
    
    /**
     * Gets the "rc" attribute
     */
    java.lang.String getRc();
    
    /**
     * Gets (as xml) the "rc" attribute
     */
    org.apache.xmlbeans.XmlString xgetRc();
    
    /**
     * True if has "rc" attribute
     */
    boolean isSetRc();
    
    /**
     * Sets the "rc" attribute
     */
    void setRc(java.lang.String rc);
    
    /**
     * Sets (as xml) the "rc" attribute
     */
    void xsetRc(org.apache.xmlbeans.XmlString rc);
    
    /**
     * Unsets the "rc" attribute
     */
    void unsetRc();
    
    /**
     * Gets the "rm" attribute
     */
    java.lang.String getRm();
    
    /**
     * Gets (as xml) the "rm" attribute
     */
    org.apache.xmlbeans.XmlString xgetRm();
    
    /**
     * True if has "rm" attribute
     */
    boolean isSetRm();
    
    /**
     * Sets the "rm" attribute
     */
    void setRm(java.lang.String rm);
    
    /**
     * Sets (as xml) the "rm" attribute
     */
    void xsetRm(org.apache.xmlbeans.XmlString rm);
    
    /**
     * Unsets the "rm" attribute
     */
    void unsetRm();
    
    /**
     * Gets the "tn" attribute
     */
    java.lang.String getTn();
    
    /**
     * Gets (as xml) the "tn" attribute
     */
    org.apache.xmlbeans.XmlString xgetTn();
    
    /**
     * True if has "tn" attribute
     */
    boolean isSetTn();
    
    /**
     * Sets the "tn" attribute
     */
    void setTn(java.lang.String tn);
    
    /**
     * Sets (as xml) the "tn" attribute
     */
    void xsetTn(org.apache.xmlbeans.XmlString tn);
    
    /**
     * Unsets the "tn" attribute
     */
    void unsetTn();
    
    /**
     * Gets the "dt" attribute
     */
    java.lang.String getDt();
    
    /**
     * Gets (as xml) the "dt" attribute
     */
    org.apache.xmlbeans.XmlString xgetDt();
    
    /**
     * True if has "dt" attribute
     */
    boolean isSetDt();
    
    /**
     * Sets the "dt" attribute
     */
    void setDt(java.lang.String dt);
    
    /**
     * Sets (as xml) the "dt" attribute
     */
    void xsetDt(org.apache.xmlbeans.XmlString dt);
    
    /**
     * Unsets the "dt" attribute
     */
    void unsetDt();
    
    /**
     * Gets the "by" attribute
     */
    long getBy();
    
    /**
     * Gets (as xml) the "by" attribute
     */
    org.apache.xmlbeans.XmlLong xgetBy();
    
    /**
     * True if has "by" attribute
     */
    boolean isSetBy();
    
    /**
     * Sets the "by" attribute
     */
    void setBy(long by);
    
    /**
     * Sets (as xml) the "by" attribute
     */
    void xsetBy(org.apache.xmlbeans.XmlLong by);
    
    /**
     * Unsets the "by" attribute
     */
    void unsetBy();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample newInstance() {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

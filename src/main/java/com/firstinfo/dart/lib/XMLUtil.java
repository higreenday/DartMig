package com.firstinfo.dart.lib;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.xml.sax.InputSource;

import com.firstinfo.dart.entity.DartUnzipEntity;


public class XMLUtil {

    public static Document loadXmlDocument(String xmlPath) throws Exception {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        String xml = FileUtils.readFileToString(new File(xmlPath), "utf-8");
//        return builder.build(xmlPath); 
        return builder.build(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
//        InputSource inputSource = new InputSource(new StringReader(xmlPath));
//        inputSource.setEncoding("UTF-8"); 
//        return builder.build(inputSource);
    }   

    public static String getXmlString(Document doc) throws Exception {
        XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
        return xmlout.outputString(doc);
    }

    public static String getXmlString(Element elm) throws Exception {
        XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
        return xmlout.outputString(elm);
    }

    public static String getContentsFromElem(Element elm, String removeChildNode) throws Exception {
        Element cloneElem = elm.clone();
        cloneElem.removeChildren(removeChildNode);
        cloneElem.removeChildren("FILENAME");
        cloneElem.removeChildren("PART");
        cloneElem.removeChildren("SECTION-1");
        cloneElem.removeChildren("SECTION-2");
        cloneElem.removeChildren("SECTION-3");
        cloneElem.removeChildren("SECTION-4");
        cloneElem.removeChildren("SECTION-5");
        cloneElem.removeChildren("SECTION-6");
        cloneElem.removeChildren("CORRECTION"); 
        cloneElem.removeChildren("INSERTION"); 
        cloneElem.removeChildren("COVER"); 
        cloneElem.removeChildren("TOC");
        cloneElem.removeChildren("PART");
        cloneElem.removeChildren("TITLE");
        cloneElem.removeChildren("SUBTITLE");
        cloneElem.removeChildren("CAUTION");
        cloneElem.removeChildren("WARNING");
        cloneElem.removeChildren("LIBRARY");
        XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
        return xmlout.outputString(cloneElem.getChildren());
    }
    
    public static Element getSelectSingleNode(String xpath, Document doc) throws Exception {
        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile(xpath, Filters.element());
        return expr.evaluateFirst(doc);
    }

    public static Element getSingleElement(String xpath, Document doc) throws Exception {
        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile(xpath, Filters.element());
        return expr.evaluateFirst(doc);
    } 

    public static boolean isExistsElement(String xpath, Document doc) throws Exception {
        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile(xpath, Filters.element());
        return expr.evaluate(doc).size() > 0 ? true : false;
    } 

    public static List getMultiElements(String xpath, Document doc) throws Exception {
        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile(xpath, Filters.element());
        return expr.evaluate(doc);
    }
    
    public static String getAttrStr(String attrNm, Element elm) throws Exception {
        String rtn = "";
        if (elm.getAttributeValue(attrNm) != null)
            rtn = elm.getAttributeValue(attrNm);
        return rtn;
    }
    
    public static String getChildText(String childElmNm, Element elm) throws Exception {
        String rtn = "";
        Element childElm = elm.getChild(childElmNm);
        if (childElm != null && childElm.getText() != null) {
            rtn = childElm.getText();
        }
        return rtn;
    }
    
    public static String getChildAttrStr(String childElmNm, String attrNm, Element elm) throws Exception {
        String rtn = "";
        Element childElm = elm.getChild(childElmNm);
        if (childElm != null && childElm.getText() != null) {
            if (childElm.getAttributeValue(attrNm) != null)
            rtn = childElm.getAttributeValue(attrNm);
        }
        return rtn;
    }
    
}

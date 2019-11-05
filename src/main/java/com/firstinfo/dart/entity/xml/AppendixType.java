//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appendixType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="appendixType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}COMMENT"/>
 *         &lt;element ref="{}DESCRIPTION" minOccurs="0"/>
 *         &lt;element name="FILENAME" type="{}filenameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ATYPE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appendixType", propOrder = {
    "comment",
    "description",
    "filename"
})
public class AppendixType {

    @XmlElement(name = "COMMENT", required = true)
    protected String comment;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "FILENAME")
    protected FilenameType filename;
    @XmlAttribute(name = "ATYPE")
    protected String atype;

    /**
     * comment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENT() {
        return comment;
    }

    /**
     * comment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENT(String value) {
        this.comment = value;
    }

    /**
     * description 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * description 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * filename 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FilenameType }
     *     
     */
    public FilenameType getFILENAME() {
        return filename;
    }

    /**
     * filename 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FilenameType }
     *     
     */
    public void setFILENAME(FilenameType value) {
        this.filename = value;
    }

    /**
     * atype 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getATYPE() {
        return atype;
    }

    /**
     * atype 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setATYPE(String value) {
        this.atype = value;
    }

}

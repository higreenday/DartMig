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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>titleType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="titleType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="ACLASS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ATOC" type="{}ayesnoType" />
 *       &lt;attribute name="AASSOCNOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AUNIT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AUNITVALUE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "titleType", propOrder = {
    "value"
})
public class TitleType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "ACLASS")
    protected String aclass;
    @XmlAttribute(name = "ATOC")
    protected AyesnoType atoc;
    @XmlAttribute(name = "AASSOCNOTE")
    protected String aassocnote;
    @XmlAttribute(name = "AUNIT")
    protected String aunit;
    @XmlAttribute(name = "AUNITVALUE")
    protected String aunitvalue;

    /**
     * value 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * value 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * aclass 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACLASS() {
        return aclass;
    }

    /**
     * aclass 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACLASS(String value) {
        this.aclass = value;
    }

    /**
     * atoc 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getATOC() {
        return atoc;
    }

    /**
     * atoc 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setATOC(AyesnoType value) {
        this.atoc = value;
    }

    /**
     * aassocnote 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAASSOCNOTE() {
        return aassocnote;
    }

    /**
     * aassocnote 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAASSOCNOTE(String value) {
        this.aassocnote = value;
    }

    /**
     * aunit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUNIT() {
        return aunit;
    }

    /**
     * aunit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUNIT(String value) {
        this.aunit = value;
    }

    /**
     * aunitvalue 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUNITVALUE() {
        return aunitvalue;
    }

    /**
     * aunitvalue 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUNITVALUE(String value) {
        this.aunitvalue = value;
    }

}

//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>table-groupType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="table-groupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element ref="{}EMPHASIS" minOccurs="0"/>
 *             &lt;element name="TITLE" type="{}titleType" minOccurs="0"/>
 *             &lt;element ref="{}SUBTITLE" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="TABLE" type="{}tableType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ACLASS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ADELETETABLE" type="{}ayesnoType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table-groupType", propOrder = {
    "emphasis",
    "title",
    "subtitle",
    "table"
})
public class TableGroupType {

    @XmlElement(name = "EMPHASIS")
    protected String emphasis;
    @XmlElement(name = "TITLE")
    protected TitleType title;
    @XmlElement(name = "SUBTITLE")
    protected String subtitle;
    @XmlElement(name = "TABLE")
    protected List<TableType> table;
    @XmlAttribute(name = "ACLASS")
    protected String aclass;
    @XmlAttribute(name = "ADELETETABLE")
    protected AyesnoType adeletetable;

    /**
     * emphasis 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMPHASIS() {
        return emphasis;
    }

    /**
     * emphasis 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMPHASIS(String value) {
        this.emphasis = value;
    }

    /**
     * title 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TitleType }
     *     
     */
    public TitleType getTITLE() {
        return title;
    }

    /**
     * title 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleType }
     *     
     */
    public void setTITLE(TitleType value) {
        this.title = value;
    }

    /**
     * subtitle 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBTITLE() {
        return subtitle;
    }

    /**
     * subtitle 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBTITLE(String value) {
        this.subtitle = value;
    }

    /**
     * Gets the value of the table property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the table property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTABLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TableType }
     * 
     * 
     */
    public List<TableType> getTABLE() {
        if (table == null) {
            table = new ArrayList<TableType>();
        }
        return this.table;
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
     * adeletetable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getADELETETABLE() {
        return adeletetable;
    }

    /**
     * adeletetable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setADELETETABLE(AyesnoType value) {
        this.adeletetable = value;
    }

}

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
 * <p>insertionType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="insertionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}COMMENT"/>
 *         &lt;element ref="{}LIBRARYLIST"/>
 *         &lt;element name="LIBRARY" type="{}libraryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ABASISNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AFREQUENCY" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ADUPLICATION" type="{}ayesnoType" default="N" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertionType", propOrder = {
    "comment",
    "librarylist",
    "library"
})
public class InsertionType {

    @XmlElement(name = "COMMENT", required = true)
    protected String comment;
    @XmlElement(name = "LIBRARYLIST", required = true)
    protected String librarylist;
    @XmlElement(name = "LIBRARY")
    protected List<LibraryType> library;
    @XmlAttribute(name = "ABASISNUMBER")
    protected String abasisnumber;
    @XmlAttribute(name = "AFREQUENCY")
    protected String afrequency;
    @XmlAttribute(name = "ADUPLICATION")
    protected AyesnoType aduplication;

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
     * librarylist 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIBRARYLIST() {
        return librarylist;
    }

    /**
     * librarylist 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIBRARYLIST(String value) {
        this.librarylist = value;
    }

    /**
     * Gets the value of the library property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the library property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLIBRARY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LibraryType }
     * 
     * 
     */
    public List<LibraryType> getLIBRARY() {
        if (library == null) {
            library = new ArrayList<LibraryType>();
        }
        return this.library;
    }

    /**
     * abasisnumber 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getABASISNUMBER() {
        return abasisnumber;
    }

    /**
     * abasisnumber 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setABASISNUMBER(String value) {
        this.abasisnumber = value;
    }

    /**
     * afrequency 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAFREQUENCY() {
        return afrequency;
    }

    /**
     * afrequency 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAFREQUENCY(String value) {
        this.afrequency = value;
    }

    /**
     * aduplication 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getADUPLICATION() {
        if (aduplication == null) {
            return AyesnoType.N;
        } else {
            return aduplication;
        }
    }

    /**
     * aduplication 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setADUPLICATION(AyesnoType value) {
        this.aduplication = value;
    }

}

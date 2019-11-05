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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>tableType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="COL" type="{}colType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="COLGROUP" type="{}colgroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="THEAD" type="{}theadType" minOccurs="0"/>
 *         &lt;element name="TFOOT" type="{}tfootType" minOccurs="0"/>
 *         &lt;element name="TBODY" type="{}tbodyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CLASS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ACLASS" default="NORMAL">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="FINANCE"/>
 *             &lt;enumeration value="EXTRACTION"/>
 *             &lt;enumeration value="NORMAL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="AFIXTABLE" type="{}ayesnoType" />
 *       &lt;attribute name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BORDER" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FRAME">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="VOID"/>
 *             &lt;enumeration value="ABOVE"/>
 *             &lt;enumeration value="BELOW"/>
 *             &lt;enumeration value="HSIDES"/>
 *             &lt;enumeration value="LHS"/>
 *             &lt;enumeration value="RHS"/>
 *             &lt;enumeration value="VSIDES"/>
 *             &lt;enumeration value="BOX"/>
 *             &lt;enumeration value="BORDER"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="RULES">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="NONE"/>
 *             &lt;enumeration value="GROUPS"/>
 *             &lt;enumeration value="ROWS"/>
 *             &lt;enumeration value="COLS"/>
 *             &lt;enumeration value="ALL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ALIGN">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="LEFT"/>
 *             &lt;enumeration value="CENTER"/>
 *             &lt;enumeration value="RIGHT"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableType", propOrder = {
    "col",
    "colgroup",
    "thead",
    "tfoot",
    "tbody"
})
public class TableType {

    @XmlElement(name = "COL")
    protected List<ColType> col;
    @XmlElement(name = "COLGROUP")
    protected List<ColgroupType> colgroup;
    @XmlElement(name = "THEAD")
    protected TheadType thead;
    @XmlElement(name = "TFOOT")
    protected TfootType tfoot;
    @XmlElement(name = "TBODY", required = true)
    protected List<TbodyType> tbody;
    @XmlAttribute(name = "CLASS")
    protected String _class;
    @XmlAttribute(name = "ACLASS")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String aclass;
    @XmlAttribute(name = "AFIXTABLE")
    protected AyesnoType afixtable;
    @XmlAttribute(name = "WIDTH")
    protected String width;
    @XmlAttribute(name = "BORDER")
    protected String border;
    @XmlAttribute(name = "FRAME")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String frame;
    @XmlAttribute(name = "RULES")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rules;
    @XmlAttribute(name = "ALIGN")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String align;

    /**
     * Gets the value of the col property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the col property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColType }
     * 
     * 
     */
    public List<ColType> getCOL() {
        if (col == null) {
            col = new ArrayList<ColType>();
        }
        return this.col;
    }

    /**
     * Gets the value of the colgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOLGROUP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColgroupType }
     * 
     * 
     */
    public List<ColgroupType> getCOLGROUP() {
        if (colgroup == null) {
            colgroup = new ArrayList<ColgroupType>();
        }
        return this.colgroup;
    }

    /**
     * thead 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TheadType }
     *     
     */
    public TheadType getTHEAD() {
        return thead;
    }

    /**
     * thead 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TheadType }
     *     
     */
    public void setTHEAD(TheadType value) {
        this.thead = value;
    }

    /**
     * tfoot 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TfootType }
     *     
     */
    public TfootType getTFOOT() {
        return tfoot;
    }

    /**
     * tfoot 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TfootType }
     *     
     */
    public void setTFOOT(TfootType value) {
        this.tfoot = value;
    }

    /**
     * Gets the value of the tbody property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tbody property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTBODY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TbodyType }
     * 
     * 
     */
    public List<TbodyType> getTBODY() {
        if (tbody == null) {
            tbody = new ArrayList<TbodyType>();
        }
        return this.tbody;
    }

    /**
     * class 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLASS() {
        return _class;
    }

    /**
     * class 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLASS(String value) {
        this._class = value;
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
        if (aclass == null) {
            return "NORMAL";
        } else {
            return aclass;
        }
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
     * afixtable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getAFIXTABLE() {
        return afixtable;
    }

    /**
     * afixtable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setAFIXTABLE(AyesnoType value) {
        this.afixtable = value;
    }

    /**
     * width 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWIDTH() {
        return width;
    }

    /**
     * width 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWIDTH(String value) {
        this.width = value;
    }

    /**
     * border 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBORDER() {
        return border;
    }

    /**
     * border 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBORDER(String value) {
        this.border = value;
    }

    /**
     * frame 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFRAME() {
        return frame;
    }

    /**
     * frame 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFRAME(String value) {
        this.frame = value;
    }

    /**
     * rules 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRULES() {
        return rules;
    }

    /**
     * rules 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRULES(String value) {
        this.rules = value;
    }

    /**
     * align 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALIGN() {
        return align;
    }

    /**
     * align 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALIGN(String value) {
        this.align = value;
    }

}

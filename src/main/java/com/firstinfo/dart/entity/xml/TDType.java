//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>TDType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="TDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="P" type="{}pType"/>
 *         &lt;element name="SPAN" type="{}spanType"/>
 *         &lt;element name="A" type="{}aType"/>
 *         &lt;element name="TABLE" type="{}tableType"/>
 *         &lt;element name="IMAGE" type="{}imageType"/>
 *       &lt;/choice>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="CLASS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ROWSPAN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="COLSPAN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ALIGN" type="{}alignType" />
 *       &lt;attribute name="VALIGN" type="{}valignType" />
 *       &lt;attribute name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ACODE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ADELIM" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AUNIT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ALEVEL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AUNITVALUE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AUPDATECONT" type="{}ayesnoType" />
 *       &lt;attribute name="AUTOSUM" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="USERMARK" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDType", propOrder = {
    "content"
})
public class TDType {

    @XmlElementRefs({
        @XmlElementRef(name = "P", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "A", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TABLE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IMAGE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SPAN", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "CLASS")
    protected String _class;
    @XmlAttribute(name = "ROWSPAN")
    protected String rowspan;
    @XmlAttribute(name = "COLSPAN")
    protected String colspan;
    @XmlAttribute(name = "ALIGN")
    protected AlignType align;
    @XmlAttribute(name = "VALIGN")
    protected ValignType valign;
    @XmlAttribute(name = "WIDTH")
    protected String width;
    @XmlAttribute(name = "HEIGHT")
    protected String height;
    @XmlAttribute(name = "ACODE")
    protected String acode;
    @XmlAttribute(name = "ADELIM")
    protected String adelim;
    @XmlAttribute(name = "AUNIT")
    protected String aunit;
    @XmlAttribute(name = "ALEVEL")
    protected String alevel;
    @XmlAttribute(name = "AUNITVALUE")
    protected String aunitvalue;
    @XmlAttribute(name = "AUPDATECONT")
    protected AyesnoType aupdatecont;
    @XmlAttribute(name = "AUTOSUM")
    protected String autosum;
    @XmlAttribute(name = "USERMARK")
    protected String usermark;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TableType }{@code >}
     * {@link JAXBElement }{@code <}{@link PType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AType }{@code >}
     * {@link JAXBElement }{@code <}{@link SpanType }{@code >}
     * {@link String }
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
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
     * rowspan 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROWSPAN() {
        return rowspan;
    }

    /**
     * rowspan 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROWSPAN(String value) {
        this.rowspan = value;
    }

    /**
     * colspan 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLSPAN() {
        return colspan;
    }

    /**
     * colspan 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLSPAN(String value) {
        this.colspan = value;
    }

    /**
     * align 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AlignType }
     *     
     */
    public AlignType getALIGN() {
        return align;
    }

    /**
     * align 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AlignType }
     *     
     */
    public void setALIGN(AlignType value) {
        this.align = value;
    }

    /**
     * valign 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ValignType }
     *     
     */
    public ValignType getVALIGN() {
        return valign;
    }

    /**
     * valign 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ValignType }
     *     
     */
    public void setVALIGN(ValignType value) {
        this.valign = value;
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
     * height 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHEIGHT() {
        return height;
    }

    /**
     * height 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHEIGHT(String value) {
        this.height = value;
    }

    /**
     * acode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACODE() {
        return acode;
    }

    /**
     * acode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACODE(String value) {
        this.acode = value;
    }

    /**
     * adelim 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADELIM() {
        return adelim;
    }

    /**
     * adelim 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADELIM(String value) {
        this.adelim = value;
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
     * alevel 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALEVEL() {
        return alevel;
    }

    /**
     * alevel 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALEVEL(String value) {
        this.alevel = value;
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

    /**
     * aupdatecont 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getAUPDATECONT() {
        return aupdatecont;
    }

    /**
     * aupdatecont 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setAUPDATECONT(AyesnoType value) {
        this.aupdatecont = value;
    }

    /**
     * autosum 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTOSUM() {
        return autosum;
    }

    /**
     * autosum 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTOSUM(String value) {
        this.autosum = value;
    }

    /**
     * usermark 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERMARK() {
        return usermark;
    }

    /**
     * usermark 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERMARK(String value) {
        this.usermark = value;
    }

}

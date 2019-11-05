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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TRType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="TRType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="TH" type="{}THType"/>
 *         &lt;element name="TD" type="{}TDType"/>
 *         &lt;element name="TE" type="{}TEType"/>
 *         &lt;element name="TU" type="{}TUType"/>
 *       &lt;/choice>
 *       &lt;attribute name="ACOPY" type="{}ayesnoType" />
 *       &lt;attribute name="ADELETE" type="{}ayesnoType" />
 *       &lt;attribute name="HEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ALIGN" type="{}alignType" />
 *       &lt;attribute name="VALIGN" type="{}valignType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRType", propOrder = {
    "thOrTDOrTE"
})
public class TRType {

    @XmlElements({
        @XmlElement(name = "TH", type = THType.class),
        @XmlElement(name = "TD", type = TDType.class),
        @XmlElement(name = "TE", type = TEType.class),
        @XmlElement(name = "TU", type = TUType.class)
    })
    protected List<Object> thOrTDOrTE;
    @XmlAttribute(name = "ACOPY")
    protected AyesnoType acopy;
    @XmlAttribute(name = "ADELETE")
    protected AyesnoType adelete;
    @XmlAttribute(name = "HEIGHT")
    protected String height;
    @XmlAttribute(name = "ALIGN")
    protected AlignType align;
    @XmlAttribute(name = "VALIGN")
    protected ValignType valign;

    /**
     * Gets the value of the thOrTDOrTE property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thOrTDOrTE property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTHOrTDOrTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link THType }
     * {@link TDType }
     * {@link TEType }
     * {@link TUType }
     * 
     * 
     */
    public List<Object> getTHOrTDOrTE() {
        if (thOrTDOrTE == null) {
            thOrTDOrTE = new ArrayList<Object>();
        }
        return this.thOrTDOrTE;
    }

    /**
     * acopy 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getACOPY() {
        return acopy;
    }

    /**
     * acopy 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setACOPY(AyesnoType value) {
        this.acopy = value;
    }

    /**
     * adelete 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getADELETE() {
        return adelete;
    }

    /**
     * adelete 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setADELETE(AyesnoType value) {
        this.adelete = value;
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

}

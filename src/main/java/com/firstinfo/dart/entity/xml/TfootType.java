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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>tfootType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tfootType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TR" type="{}TRType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="CLASS" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "tfootType", propOrder = {
    "tr"
})
public class TfootType {

    @XmlElement(name = "TR", required = true)
    protected List<TRType> tr;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "CLASS")
    protected String _class;
    @XmlAttribute(name = "ALIGN")
    protected AlignType align;
    @XmlAttribute(name = "VALIGN")
    protected ValignType valign;

    /**
     * Gets the value of the tr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRType }
     * 
     * 
     */
    public List<TRType> getTR() {
        if (tr == null) {
            tr = new ArrayList<TRType>();
        }
        return this.tr;
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

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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>partType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="partType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="TITLE" type="{}titleType"/>
 *             &lt;element ref="{}SUBTITLE" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}DESCRIPTION"/>
 *           &lt;choice maxOccurs="unbounded" minOccurs="0">
 *             &lt;choice>
 *               &lt;element name="CAUTION" type="{}cautionType"/>
 *               &lt;element ref="{}WARNING" minOccurs="0"/>
 *               &lt;element name="P" type="{}pType"/>
 *               &lt;element name="TABLE-GROUP" type="{}table-groupType"/>
 *               &lt;element name="TABLE" type="{}tableType"/>
 *               &lt;element name="IMAGE" type="{}imageType"/>
 *               &lt;element name="APPENDIX" type="{}appendixType"/>
 *             &lt;/choice>
 *             &lt;element name="SECTION-1" type="{}section-1Type"/>
 *             &lt;choice>
 *               &lt;element name="PGBRK" type="{}pgbrkType"/>
 *               &lt;element name="INSERTION" type="{}insertionType"/>
 *             &lt;/choice>
 *           &lt;/choice>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="AID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="ACLASS" type="{}aclassType" default="MANDATORY" />
 *       &lt;attribute name="APARTSOURCE" default="SOURCE">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="SOURCE"/>
 *             &lt;enumeration value="TARGET"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="APARTINFO" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partType", propOrder = {
    "title",
    "subtitle",
    "description",
    "cautionOrWARNINGOrP"
})
public class PartType {

    @XmlElement(name = "TITLE")
    protected TitleType title;
    @XmlElement(name = "SUBTITLE")
    protected String subtitle;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElements({
        @XmlElement(name = "CAUTION", type = CautionType.class),
        @XmlElement(name = "WARNING", type = String.class),
        @XmlElement(name = "P", type = PType.class),
        @XmlElement(name = "TABLE-GROUP", type = TableGroupType.class),
        @XmlElement(name = "TABLE", type = TableType.class),
        @XmlElement(name = "IMAGE", type = ImageType.class),
        @XmlElement(name = "APPENDIX", type = AppendixType.class),
        @XmlElement(name = "SECTION-1", type = Section1Type.class),
        @XmlElement(name = "PGBRK", type = PgbrkType.class),
        @XmlElement(name = "INSERTION", type = InsertionType.class)
    })
    protected List<Object> cautionOrWARNINGOrP;
    @XmlAttribute(name = "AID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String aid;
    @XmlAttribute(name = "ACLASS")
    protected AclassType aclass;
    @XmlAttribute(name = "APARTSOURCE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String apartsource;
    @XmlAttribute(name = "APARTINFO")
    protected String apartinfo;

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
     * Gets the value of the cautionOrWARNINGOrP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cautionOrWARNINGOrP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCAUTIONOrWARNINGOrP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CautionType }
     * {@link String }
     * {@link PType }
     * {@link TableGroupType }
     * {@link TableType }
     * {@link ImageType }
     * {@link AppendixType }
     * {@link Section1Type }
     * {@link PgbrkType }
     * {@link InsertionType }
     * 
     * 
     */
    public List<Object> getCAUTIONOrWARNINGOrP() {
        if (cautionOrWARNINGOrP == null) {
            cautionOrWARNINGOrP = new ArrayList<Object>();
        }
        return this.cautionOrWARNINGOrP;
    }

    /**
     * aid 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAID() {
        return aid;
    }

    /**
     * aid 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAID(String value) {
        this.aid = value;
    }

    /**
     * aclass 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AclassType }
     *     
     */
    public AclassType getACLASS() {
        if (aclass == null) {
            return AclassType.MANDATORY;
        } else {
            return aclass;
        }
    }

    /**
     * aclass 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AclassType }
     *     
     */
    public void setACLASS(AclassType value) {
        this.aclass = value;
    }

    /**
     * apartsource 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPARTSOURCE() {
        if (apartsource == null) {
            return "SOURCE";
        } else {
            return apartsource;
        }
    }

    /**
     * apartsource 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPARTSOURCE(String value) {
        this.apartsource = value;
    }

    /**
     * apartinfo 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPARTINFO() {
        return apartinfo;
    }

    /**
     * apartinfo 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPARTINFO(String value) {
        this.apartinfo = value;
    }

}

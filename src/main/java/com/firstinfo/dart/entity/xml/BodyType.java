//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bodyType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="bodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="CORRECTION" type="{}correctionType"/>
 *           &lt;element name="PGBRK" type="{}pgbrkType"/>
 *           &lt;element name="INSERTION" type="{}insertionType"/>
 *           &lt;element name="COVER" type="{}coverType"/>
 *           &lt;element name="TOC" type="{}tocType"/>
 *           &lt;element name="PART" type="{}partType"/>
 *           &lt;element name="SECTION-1" type="{}section-1Type"/>
 *           &lt;element name="TITLE" type="{}titleType"/>
 *           &lt;element ref="{}SUBTITLE" minOccurs="0"/>
 *           &lt;choice>
 *             &lt;element name="CAUTION" type="{}cautionType"/>
 *             &lt;element ref="{}WARNING" minOccurs="0"/>
 *             &lt;element name="P" type="{}pType"/>
 *             &lt;element name="TABLE-GROUP" type="{}table-groupType"/>
 *             &lt;element name="TABLE" type="{}tableType"/>
 *             &lt;element name="IMAGE" type="{}imageType"/>
 *             &lt;element name="APPENDIX" type="{}appendixType"/>
 *           &lt;/choice>
 *           &lt;element name="LIBRARY" type="{}libraryType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bodyType", propOrder = {
    "cover",
    "correctionOrPGBRKOrINSERTION"
})
public class BodyType {

    @XmlElement(name = "COVER")
    protected CoverType cover;
    
    @XmlElementRefs({
        @XmlElementRef(name = "P", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SECTION-1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TITLE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PGBRK", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SUBTITLE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TOC", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CORRECTION", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PART", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "INSERTION", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WARNING", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APPENDIX", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LIBRARY", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TABLE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TABLE-GROUP", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IMAGE", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "COVER", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CAUTION", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> correctionOrPGBRKOrINSERTION;


    public CoverType getCover() {
        return cover;
    }
    
    /**
     * Gets the value of the correctionOrPGBRKOrINSERTION property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the correctionOrPGBRKOrINSERTION property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCORRECTIONOrPGBRKOrINSERTION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link PType }{@code >}
     * {@link JAXBElement }{@code <}{@link Section1Type }{@code >}
     * {@link JAXBElement }{@code <}{@link TitleType }{@code >}
     * {@link JAXBElement }{@code <}{@link PgbrkType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TocType }{@code >}
     * {@link JAXBElement }{@code <}{@link CorrectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link PartType }{@code >}
     * {@link JAXBElement }{@code <}{@link InsertionType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link AppendixType }{@code >}
     * {@link JAXBElement }{@code <}{@link LibraryType }{@code >}
     * {@link JAXBElement }{@code <}{@link TableType }{@code >}
     * {@link JAXBElement }{@code <}{@link TableGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * {@link JAXBElement }{@code <}{@link CoverType }{@code >}
     * {@link JAXBElement }{@code <}{@link CautionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCORRECTIONOrPGBRKOrINSERTION() {
        if (correctionOrPGBRKOrINSERTION == null) {
            correctionOrPGBRKOrINSERTION = new ArrayList<JAXBElement<?>>();
        }
        return this.correctionOrPGBRKOrINSERTION;
    }

}

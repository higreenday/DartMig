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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>libraryType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="libraryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FILENAME" type="{}filenameType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="PART" type="{}partType"/>
 *           &lt;element name="SECTION-1" type="{}section-1Type"/>
 *           &lt;element name="SECTION-2" type="{}section-2Type"/>
 *           &lt;element name="SECTION-3" type="{}section-3Type"/>
 *           &lt;element name="SECTION-4" type="{}section-4Type"/>
 *           &lt;element name="SECTION-5" type="{}section-5Type"/>
 *           &lt;element name="SECTION-6" type="{}section-6Type"/>
 *           &lt;choice>
 *             &lt;element name="CAUTION" type="{}cautionType"/>
 *             &lt;element name="P" type="{}pType"/>
 *             &lt;element name="TABLE-GROUP" type="{}table-groupType"/>
 *             &lt;element name="TABLE" type="{}tableType"/>
 *             &lt;element name="IMAGE" type="{}imageType"/>
 *             &lt;element name="APPENDIX" type="{}appendixType"/>
 *           &lt;/choice>
 *           &lt;element name="CORRECTION" type="{}correctionType"/>
 *           &lt;group ref="{}anyInsGroup"/>
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
@XmlType(name = "libraryType", propOrder = {
    "filename",
    "partOrSECTION1OrSECTION2"
})
public class LibraryType {

    @XmlElement(name = "FILENAME")
    protected FilenameType filename;
    @XmlElements({
        @XmlElement(name = "PART", type = PartType.class),
        @XmlElement(name = "SECTION-1", type = Section1Type.class),
        @XmlElement(name = "SECTION-2", type = Section2Type.class),
        @XmlElement(name = "SECTION-3", type = Section3Type.class),
        @XmlElement(name = "SECTION-4", type = Section4Type.class),
        @XmlElement(name = "SECTION-5", type = Section5Type.class),
        @XmlElement(name = "SECTION-6", type = Section6Type.class),
        @XmlElement(name = "CAUTION", type = CautionType.class),
        @XmlElement(name = "P", type = PType.class),
        @XmlElement(name = "TABLE-GROUP", type = TableGroupType.class),
        @XmlElement(name = "TABLE", type = TableType.class),
        @XmlElement(name = "IMAGE", type = ImageType.class),
        @XmlElement(name = "APPENDIX", type = AppendixType.class),
        @XmlElement(name = "CORRECTION", type = CorrectionType.class),
        @XmlElement(name = "PGBRK", type = PgbrkType.class),
        @XmlElement(name = "INSERTION", type = InsertionType.class)
    })
    protected List<Object> partOrSECTION1OrSECTION2;

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
     * Gets the value of the partOrSECTION1OrSECTION2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partOrSECTION1OrSECTION2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARTOrSECTION1OrSECTION2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartType }
     * {@link Section1Type }
     * {@link Section2Type }
     * {@link Section3Type }
     * {@link Section4Type }
     * {@link Section5Type }
     * {@link Section6Type }
     * {@link CautionType }
     * {@link PType }
     * {@link TableGroupType }
     * {@link TableType }
     * {@link ImageType }
     * {@link AppendixType }
     * {@link CorrectionType }
     * {@link PgbrkType }
     * {@link InsertionType }
     * 
     * 
     */
    public List<Object> getPARTOrSECTION1OrSECTION2() {
        if (partOrSECTION1OrSECTION2 == null) {
            partOrSECTION1OrSECTION2 = new ArrayList<Object>();
        }
        return this.partOrSECTION1OrSECTION2;
    }

}

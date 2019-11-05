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
 * <p>correctionType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="correctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TITLE" type="{}titleType"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="TABLE" type="{}tableType"/>
 *           &lt;element name="TABLE-GROUP" type="{}table-groupType"/>
 *           &lt;element name="P" type="{}pType"/>
 *           &lt;element name="IMAGE" type="{}imageType"/>
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
@XmlType(name = "correctionType", propOrder = {
    "title",
    "tableOrTABLEGROUPOrP"
})
public class CorrectionType {

    @XmlElement(name = "TITLE", required = true)
    protected TitleType title;
    @XmlElements({
        @XmlElement(name = "TABLE", type = TableType.class),
        @XmlElement(name = "TABLE-GROUP", type = TableGroupType.class),
        @XmlElement(name = "P", type = PType.class),
        @XmlElement(name = "IMAGE", type = ImageType.class),
        @XmlElement(name = "PGBRK", type = PgbrkType.class),
        @XmlElement(name = "INSERTION", type = InsertionType.class)
    })
    protected List<Object> tableOrTABLEGROUPOrP;

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
     * Gets the value of the tableOrTABLEGROUPOrP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableOrTABLEGROUPOrP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTABLEOrTABLEGROUPOrP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TableType }
     * {@link TableGroupType }
     * {@link PType }
     * {@link ImageType }
     * {@link PgbrkType }
     * {@link InsertionType }
     * 
     * 
     */
    public List<Object> getTABLEOrTABLEGROUPOrP() {
        if (tableOrTABLEGROUPOrP == null) {
            tableOrTABLEGROUPOrP = new ArrayList<Object>();
        }
        return this.tableOrTABLEGROUPOrP;
    }

}

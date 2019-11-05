//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOCUMENT-HEADER" type="{}document-headerType"/>
 *         &lt;element name="BODY" type="{}bodyType"/>
 *         &lt;element name="NOTE-GROUP" type="{}note-groupType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentheader",
    "body",
    "notegroup"
})
@XmlRootElement(name = "DOCUMENT")
public class DOCUMENT {

    @XmlElement(name = "DOCUMENT-HEADER", required = true)
    protected DocumentHeaderType documentheader;
    @XmlElement(name = "BODY", required = true)
    protected BodyType body;
    @XmlElement(name = "NOTE-GROUP")
    protected NoteGroupType notegroup;

    /**
     * documentheader 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DocumentHeaderType }
     *     
     */
    public DocumentHeaderType getDOCUMENTHEADER() {
        return documentheader;
    }

    /**
     * documentheader 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentHeaderType }
     *     
     */
    public void setDOCUMENTHEADER(DocumentHeaderType value) {
        this.documentheader = value;
    }

    /**
     * body 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BodyType }
     *     
     */
    public BodyType getBODY() {
        return body;
    }

    /**
     * body 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyType }
     *     
     */
    public void setBODY(BodyType value) {
        this.body = value;
    }

    /**
     * notegroup 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link NoteGroupType }
     *     
     */
    public NoteGroupType getNOTEGROUP() {
        return notegroup;
    }

    /**
     * notegroup 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteGroupType }
     *     
     */
    public void setNOTEGROUP(NoteGroupType value) {
        this.notegroup = value;
    }

}

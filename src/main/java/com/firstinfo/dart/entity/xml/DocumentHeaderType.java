//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>document-headerType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="document-headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOCUMENT-NAME" type="{}document-nameType"/>
 *         &lt;element name="FORMULA-VERSION" type="{}formula-versionType"/>
 *         &lt;element name="COMPANY-NAME" type="{}company-nameType"/>
 *         &lt;element name="SUMMARY" type="{}summaryType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AEXT-CLASS" type="{}ayesnoType" default="N" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "document-headerType", propOrder = {
    "documentname",
    "formulaversion",
    "companyname",
    "summary"
})
public class DocumentHeaderType {

    @XmlElement(name = "DOCUMENT-NAME", required = true)
    protected DocumentNameType documentname;
    @XmlElement(name = "FORMULA-VERSION", required = true)
    protected FormulaVersionType formulaversion;
    @XmlElement(name = "COMPANY-NAME", required = true)
    protected CompanyNameType companyname;
    @XmlElement(name = "SUMMARY")
    protected SummaryType summary;
    @XmlAttribute(name = "AEXT-CLASS")
    protected AyesnoType aextclass;

    /**
     * documentname 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DocumentNameType }
     *     
     */
    public DocumentNameType getDOCUMENTNAME() {
        return documentname;
    }

    /**
     * documentname 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentNameType }
     *     
     */
    public void setDOCUMENTNAME(DocumentNameType value) {
        this.documentname = value;
    }

    /**
     * formulaversion 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FormulaVersionType }
     *     
     */
    public FormulaVersionType getFORMULAVERSION() {
        return formulaversion;
    }

    /**
     * formulaversion 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FormulaVersionType }
     *     
     */
    public void setFORMULAVERSION(FormulaVersionType value) {
        this.formulaversion = value;
    }

    /**
     * companyname 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CompanyNameType }
     *     
     */
    public CompanyNameType getCOMPANYNAME() {
        return companyname;
    }

    /**
     * companyname 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyNameType }
     *     
     */
    public void setCOMPANYNAME(CompanyNameType value) {
        this.companyname = value;
    }

    /**
     * summary 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SummaryType }
     *     
     */
    public SummaryType getSUMMARY() {
        return summary;
    }

    /**
     * summary 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryType }
     *     
     */
    public void setSUMMARY(SummaryType value) {
        this.summary = value;
    }

    /**
     * aextclass 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AyesnoType }
     *     
     */
    public AyesnoType getAEXTCLASS() {
        if (aextclass == null) {
            return AyesnoType.N;
        } else {
            return aextclass;
        }
    }

    /**
     * aextclass 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AyesnoType }
     *     
     */
    public void setAEXTCLASS(AyesnoType value) {
        this.aextclass = value;
    }

}

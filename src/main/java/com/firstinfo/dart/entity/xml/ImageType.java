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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>imageType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="imageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMG" type="{}imgType"/>
 *         &lt;element name="IMG-CAPTION" type="{}img-captionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageType", propOrder = {
    "img",
    "imgcaption"
})
public class ImageType {

    @XmlElement(name = "IMG", required = true)
    protected ImgType img;
    @XmlElement(name = "IMG-CAPTION")
    protected ImgCaptionType imgcaption;

    /**
     * img 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ImgType }
     *     
     */
    public ImgType getIMG() {
        return img;
    }

    /**
     * img 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ImgType }
     *     
     */
    public void setIMG(ImgType value) {
        this.img = value;
    }

    /**
     * imgcaption 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ImgCaptionType }
     *     
     */
    public ImgCaptionType getIMGCAPTION() {
        return imgcaption;
    }

    /**
     * imgcaption 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ImgCaptionType }
     *     
     */
    public void setIMGCAPTION(ImgCaptionType value) {
        this.imgcaption = value;
    }

}

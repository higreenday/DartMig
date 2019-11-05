//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.09.14 시간 01:44:21 PM KST 
//


package com.firstinfo.dart.entity.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.firstinfo.dart.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DESCRIPTION_QNAME = new QName("", "DESCRIPTION");
    private final static QName _EMPHASIS_QNAME = new QName("", "EMPHASIS");
    private final static QName _SUBTITLE_QNAME = new QName("", "SUBTITLE");
    private final static QName _WARNING_QNAME = new QName("", "WARNING");
    private final static QName _COMMENT_QNAME = new QName("", "COMMENT");
    private final static QName _LIBRARYLIST_QNAME = new QName("", "LIBRARYLIST");
    private final static QName _ATypeSPAN_QNAME = new QName("", "SPAN");
    private final static QName _TDTypeP_QNAME = new QName("", "P");
    private final static QName _TDTypeTABLE_QNAME = new QName("", "TABLE");
    private final static QName _TDTypeA_QNAME = new QName("", "A");
    private final static QName _TDTypeIMAGE_QNAME = new QName("", "IMAGE");
    private final static QName _BodyTypeINSERTION_QNAME = new QName("", "INSERTION");
    private final static QName _BodyTypeCOVER_QNAME = new QName("", "COVER");
    private final static QName _BodyTypeLIBRARY_QNAME = new QName("", "LIBRARY");
    private final static QName _BodyTypeTOC_QNAME = new QName("", "TOC");
    private final static QName _BodyTypeSECTION1_QNAME = new QName("", "SECTION-1");
    private final static QName _BodyTypeCAUTION_QNAME = new QName("", "CAUTION");
    private final static QName _BodyTypePGBRK_QNAME = new QName("", "PGBRK");
    private final static QName _BodyTypeCORRECTION_QNAME = new QName("", "CORRECTION");
    private final static QName _BodyTypeTABLEGROUP_QNAME = new QName("", "TABLE-GROUP");
    private final static QName _BodyTypePART_QNAME = new QName("", "PART");
    private final static QName _BodyTypeTITLE_QNAME = new QName("", "TITLE");
    private final static QName _BodyTypeAPPENDIX_QNAME = new QName("", "APPENDIX");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.firstinfo.dart.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DOCUMENT }
     * 
     */
    public DOCUMENT createDOCUMENT() {
        return new DOCUMENT();
    }

    /**
     * Create an instance of {@link DocumentHeaderType }
     * 
     */
    public DocumentHeaderType createDocumentHeaderType() {
        return new DocumentHeaderType();
    }

    /**
     * Create an instance of {@link BodyType }
     * 
     */
    public BodyType createBodyType() {
        return new BodyType();
    }

    /**
     * Create an instance of {@link NoteGroupType }
     * 
     */
    public NoteGroupType createNoteGroupType() {
        return new NoteGroupType();
    }

    /**
     * Create an instance of {@link TEType }
     * 
     */
    public TEType createTEType() {
        return new TEType();
    }

    /**
     * Create an instance of {@link TitleType }
     * 
     */
    public TitleType createTitleType() {
        return new TitleType();
    }

    /**
     * Create an instance of {@link TbodyType }
     * 
     */
    public TbodyType createTbodyType() {
        return new TbodyType();
    }

    /**
     * Create an instance of {@link Section5Type }
     * 
     */
    public Section5Type createSection5Type() {
        return new Section5Type();
    }

    /**
     * Create an instance of {@link CoverType }
     * 
     */
    public CoverType createCoverType() {
        return new CoverType();
    }

    /**
     * Create an instance of {@link PType }
     * 
     */
    public PType createPType() {
        return new PType();
    }

    /**
     * Create an instance of {@link ImageType }
     * 
     */
    public ImageType createImageType() {
        return new ImageType();
    }

    /**
     * Create an instance of {@link ImgCaptionType }
     * 
     */
    public ImgCaptionType createImgCaptionType() {
        return new ImgCaptionType();
    }

    /**
     * Create an instance of {@link PartType }
     * 
     */
    public PartType createPartType() {
        return new PartType();
    }

    /**
     * Create an instance of {@link Section6Type }
     * 
     */
    public Section6Type createSection6Type() {
        return new Section6Type();
    }

    /**
     * Create an instance of {@link FilenameType }
     * 
     */
    public FilenameType createFilenameType() {
        return new FilenameType();
    }

    /**
     * Create an instance of {@link Section3Type }
     * 
     */
    public Section3Type createSection3Type() {
        return new Section3Type();
    }

    /**
     * Create an instance of {@link ColgroupType }
     * 
     */
    public ColgroupType createColgroupType() {
        return new ColgroupType();
    }

    /**
     * Create an instance of {@link DocumentNameType }
     * 
     */
    public DocumentNameType createDocumentNameType() {
        return new DocumentNameType();
    }

    /**
     * Create an instance of {@link TheadType }
     * 
     */
    public TheadType createTheadType() {
        return new TheadType();
    }

    /**
     * Create an instance of {@link CorrectionType }
     * 
     */
    public CorrectionType createCorrectionType() {
        return new CorrectionType();
    }

    /**
     * Create an instance of {@link SpanType }
     * 
     */
    public SpanType createSpanType() {
        return new SpanType();
    }

    /**
     * Create an instance of {@link THType }
     * 
     */
    public THType createTHType() {
        return new THType();
    }

    /**
     * Create an instance of {@link Section4Type }
     * 
     */
    public Section4Type createSection4Type() {
        return new Section4Type();
    }

    /**
     * Create an instance of {@link LibraryType }
     * 
     */
    public LibraryType createLibraryType() {
        return new LibraryType();
    }

    /**
     * Create an instance of {@link AppendixType }
     * 
     */
    public AppendixType createAppendixType() {
        return new AppendixType();
    }

    /**
     * Create an instance of {@link TfootType }
     * 
     */
    public TfootType createTfootType() {
        return new TfootType();
    }

    /**
     * Create an instance of {@link NOTEType }
     * 
     */
    public NOTEType createNOTEType() {
        return new NOTEType();
    }

    /**
     * Create an instance of {@link AType }
     * 
     */
    public AType createAType() {
        return new AType();
    }

    /**
     * Create an instance of {@link InsertionType }
     * 
     */
    public InsertionType createInsertionType() {
        return new InsertionType();
    }

    /**
     * Create an instance of {@link TableType }
     * 
     */
    public TableType createTableType() {
        return new TableType();
    }

    /**
     * Create an instance of {@link Section1Type }
     * 
     */
    public Section1Type createSection1Type() {
        return new Section1Type();
    }

    /**
     * Create an instance of {@link TableGroupType }
     * 
     */
    public TableGroupType createTableGroupType() {
        return new TableGroupType();
    }

    /**
     * Create an instance of {@link ColType }
     * 
     */
    public ColType createColType() {
        return new ColType();
    }

    /**
     * Create an instance of {@link Section2Type }
     * 
     */
    public Section2Type createSection2Type() {
        return new Section2Type();
    }

    /**
     * Create an instance of {@link TRType }
     * 
     */
    public TRType createTRType() {
        return new TRType();
    }

    /**
     * Create an instance of {@link PgbrkType }
     * 
     */
    public PgbrkType createPgbrkType() {
        return new PgbrkType();
    }

    /**
     * Create an instance of {@link ImgType }
     * 
     */
    public ImgType createImgType() {
        return new ImgType();
    }

    /**
     * Create an instance of {@link CompanyNameType }
     * 
     */
    public CompanyNameType createCompanyNameType() {
        return new CompanyNameType();
    }

    /**
     * Create an instance of {@link ExtractionType }
     * 
     */
    public ExtractionType createExtractionType() {
        return new ExtractionType();
    }

    /**
     * Create an instance of {@link FormulaVersionType }
     * 
     */
    public FormulaVersionType createFormulaVersionType() {
        return new FormulaVersionType();
    }

    /**
     * Create an instance of {@link SummaryType }
     * 
     */
    public SummaryType createSummaryType() {
        return new SummaryType();
    }

    /**
     * Create an instance of {@link CautionType }
     * 
     */
    public CautionType createCautionType() {
        return new CautionType();
    }

    /**
     * Create an instance of {@link Section7Type }
     * 
     */
    public Section7Type createSection7Type() {
        return new Section7Type();
    }

    /**
     * Create an instance of {@link CoverTitleType }
     * 
     */
    public CoverTitleType createCoverTitleType() {
        return new CoverTitleType();
    }

    /**
     * Create an instance of {@link TocType }
     * 
     */
    public TocType createTocType() {
        return new TocType();
    }

    /**
     * Create an instance of {@link TDType }
     * 
     */
    public TDType createTDType() {
        return new TDType();
    }

    /**
     * Create an instance of {@link TUType }
     * 
     */
    public TUType createTUType() {
        return new TUType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DESCRIPTION")
    public JAXBElement<String> createDESCRIPTION(String value) {
        return new JAXBElement<String>(_DESCRIPTION_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EMPHASIS")
    public JAXBElement<String> createEMPHASIS(String value) {
        return new JAXBElement<String>(_EMPHASIS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SUBTITLE")
    public JAXBElement<String> createSUBTITLE(String value) {
        return new JAXBElement<String>(_SUBTITLE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "WARNING")
    public JAXBElement<String> createWARNING(String value) {
        return new JAXBElement<String>(_WARNING_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "COMMENT")
    public JAXBElement<String> createCOMMENT(String value) {
        return new JAXBElement<String>(_COMMENT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LIBRARYLIST")
    public JAXBElement<String> createLIBRARYLIST(String value) {
        return new JAXBElement<String>(_LIBRARYLIST_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = AType.class)
    public JAXBElement<SpanType> createATypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, AType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "P", scope = TDType.class)
    public JAXBElement<PType> createTDTypeP(PType value) {
        return new JAXBElement<PType>(_TDTypeP_QNAME, PType.class, TDType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TABLE", scope = TDType.class)
    public JAXBElement<TableType> createTDTypeTABLE(TableType value) {
        return new JAXBElement<TableType>(_TDTypeTABLE_QNAME, TableType.class, TDType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "A", scope = TDType.class)
    public JAXBElement<AType> createTDTypeA(AType value) {
        return new JAXBElement<AType>(_TDTypeA_QNAME, AType.class, TDType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMAGE", scope = TDType.class)
    public JAXBElement<ImageType> createTDTypeIMAGE(ImageType value) {
        return new JAXBElement<ImageType>(_TDTypeIMAGE_QNAME, ImageType.class, TDType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = TDType.class)
    public JAXBElement<SpanType> createTDTypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, TDType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "A", scope = SpanType.class)
    public JAXBElement<AType> createSpanTypeA(AType value) {
        return new JAXBElement<AType>(_TDTypeA_QNAME, AType.class, SpanType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = SpanType.class)
    public JAXBElement<SpanType> createSpanTypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, SpanType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TABLE", scope = PType.class)
    public JAXBElement<TableType> createPTypeTABLE(TableType value) {
        return new JAXBElement<TableType>(_TDTypeTABLE_QNAME, TableType.class, PType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "A", scope = PType.class)
    public JAXBElement<AType> createPTypeA(AType value) {
        return new JAXBElement<AType>(_TDTypeA_QNAME, AType.class, PType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMAGE", scope = PType.class)
    public JAXBElement<ImageType> createPTypeIMAGE(ImageType value) {
        return new JAXBElement<ImageType>(_TDTypeIMAGE_QNAME, ImageType.class, PType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = PType.class)
    public JAXBElement<SpanType> createPTypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, PType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "P", scope = THType.class)
    public JAXBElement<PType> createTHTypeP(PType value) {
        return new JAXBElement<PType>(_TDTypeP_QNAME, PType.class, THType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "A", scope = THType.class)
    public JAXBElement<AType> createTHTypeA(AType value) {
        return new JAXBElement<AType>(_TDTypeA_QNAME, AType.class, THType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = THType.class)
    public JAXBElement<SpanType> createTHTypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, THType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "P", scope = TEType.class)
    public JAXBElement<PType> createTETypeP(PType value) {
        return new JAXBElement<PType>(_TDTypeP_QNAME, PType.class, TEType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "A", scope = TEType.class)
    public JAXBElement<AType> createTETypeA(AType value) {
        return new JAXBElement<AType>(_TDTypeA_QNAME, AType.class, TEType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpanType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPAN", scope = TEType.class)
    public JAXBElement<SpanType> createTETypeSPAN(SpanType value) {
        return new JAXBElement<SpanType>(_ATypeSPAN_QNAME, SpanType.class, TEType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "INSERTION", scope = BodyType.class)
    public JAXBElement<InsertionType> createBodyTypeINSERTION(InsertionType value) {
        return new JAXBElement<InsertionType>(_BodyTypeINSERTION_QNAME, InsertionType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoverType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "COVER", scope = BodyType.class)
    public JAXBElement<CoverType> createBodyTypeCOVER(CoverType value) {
        return new JAXBElement<CoverType>(_BodyTypeCOVER_QNAME, CoverType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LibraryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LIBRARY", scope = BodyType.class)
    public JAXBElement<LibraryType> createBodyTypeLIBRARY(LibraryType value) {
        return new JAXBElement<LibraryType>(_BodyTypeLIBRARY_QNAME, LibraryType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TocType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TOC", scope = BodyType.class)
    public JAXBElement<TocType> createBodyTypeTOC(TocType value) {
        return new JAXBElement<TocType>(_BodyTypeTOC_QNAME, TocType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Section1Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SECTION-1", scope = BodyType.class)
    public JAXBElement<Section1Type> createBodyTypeSECTION1(Section1Type value) {
        return new JAXBElement<Section1Type>(_BodyTypeSECTION1_QNAME, Section1Type.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CautionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CAUTION", scope = BodyType.class)
    public JAXBElement<CautionType> createBodyTypeCAUTION(CautionType value) {
        return new JAXBElement<CautionType>(_BodyTypeCAUTION_QNAME, CautionType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PgbrkType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PGBRK", scope = BodyType.class)
    public JAXBElement<PgbrkType> createBodyTypePGBRK(PgbrkType value) {
        return new JAXBElement<PgbrkType>(_BodyTypePGBRK_QNAME, PgbrkType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "P", scope = BodyType.class)
    public JAXBElement<PType> createBodyTypeP(PType value) {
        return new JAXBElement<PType>(_TDTypeP_QNAME, PType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TABLE", scope = BodyType.class)
    public JAXBElement<TableType> createBodyTypeTABLE(TableType value) {
        return new JAXBElement<TableType>(_TDTypeTABLE_QNAME, TableType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorrectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CORRECTION", scope = BodyType.class)
    public JAXBElement<CorrectionType> createBodyTypeCORRECTION(CorrectionType value) {
        return new JAXBElement<CorrectionType>(_BodyTypeCORRECTION_QNAME, CorrectionType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMAGE", scope = BodyType.class)
    public JAXBElement<ImageType> createBodyTypeIMAGE(ImageType value) {
        return new JAXBElement<ImageType>(_TDTypeIMAGE_QNAME, ImageType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableGroupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TABLE-GROUP", scope = BodyType.class)
    public JAXBElement<TableGroupType> createBodyTypeTABLEGROUP(TableGroupType value) {
        return new JAXBElement<TableGroupType>(_BodyTypeTABLEGROUP_QNAME, TableGroupType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PART", scope = BodyType.class)
    public JAXBElement<PartType> createBodyTypePART(PartType value) {
        return new JAXBElement<PartType>(_BodyTypePART_QNAME, PartType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TitleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TITLE", scope = BodyType.class)
    public JAXBElement<TitleType> createBodyTypeTITLE(TitleType value) {
        return new JAXBElement<TitleType>(_BodyTypeTITLE_QNAME, TitleType.class, BodyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppendixType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "APPENDIX", scope = BodyType.class)
    public JAXBElement<AppendixType> createBodyTypeAPPENDIX(AppendixType value) {
        return new JAXBElement<AppendixType>(_BodyTypeAPPENDIX_QNAME, AppendixType.class, BodyType.class, value);
    }

}

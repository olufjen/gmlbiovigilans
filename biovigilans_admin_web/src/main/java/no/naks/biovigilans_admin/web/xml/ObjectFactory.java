//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 10:43:47 AM CEST 
//


package no.naks.biovigilans_admin.web.xml;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _Seecat_QNAME = new QName("", "seecat");
    private final static QName _Nemod_QNAME = new QName("", "nemod");
    private final static QName _See_QNAME = new QName("", "see");
    private final static QName _Subcat_QNAME = new QName("", "subcat");
    private final static QName _SeeAlso_QNAME = new QName("", "seeAlso");
    private final static QName _Code_QNAME = new QName("", "code");
    private final static QName _Version_QNAME = new QName("", "version");
    private final static QName _Manif_QNAME = new QName("", "manif");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Letter }
     * 
     */
    public Letter createLetter() {
        return new Letter();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link MainTerm }
     * 
     */
    public MainTerm createMainTerm() {
        return new MainTerm();
    }

    /**
     * Create an instance of {@link Term }
     * 
     */
    public Term createTerm() {
        return new Term();
    }

    /**
     * Create an instance of {@link ICD10CMIndex }
     * 
     */
    public ICD10CMIndex createICD10CMIndex() {
        return new ICD10CMIndex();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seecat")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSeecat(String value) {
        return new JAXBElement<String>(_Seecat_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nemod")
    public JAXBElement<String> createNemod(String value) {
        return new JAXBElement<String>(_Nemod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "see")
    public JAXBElement<String> createSee(String value) {
        return new JAXBElement<String>(_See_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subcat")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSubcat(String value) {
        return new JAXBElement<String>(_Subcat_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seeAlso")
    public JAXBElement<String> createSeeAlso(String value) {
        return new JAXBElement<String>(_SeeAlso_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "version")
    public JAXBElement<BigInteger> createVersion(BigInteger value) {
        return new JAXBElement<BigInteger>(_Version_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "manif")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createManif(String value) {
        return new JAXBElement<String>(_Manif_QNAME, String.class, null, value);
    }

}

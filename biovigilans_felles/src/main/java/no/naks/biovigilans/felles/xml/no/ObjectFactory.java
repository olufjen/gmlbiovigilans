//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.11 at 10:28:47 AM CET 
//


package no.naks.biovigilans.felles.xml.no;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
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

    private final static QName _Tittel_QNAME = new QName("", "tittel");
    private final static QName _Kode_QNAME = new QName("", "kode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KodeNivaa1 }
     * 
     */
    public KodeNivaa1 createKodeNivaa1() {
        return new KodeNivaa1();
    }

    /**
     * Create an instance of {@link KodeNivaa2 }
     * 
     */
    public KodeNivaa2 createKodeNivaa2() {
        return new KodeNivaa2();
    }

    /**
     * Create an instance of {@link TematiskGruppeNivaa1 }
     * 
     */
    public TematiskGruppeNivaa1 createTematiskGruppeNivaa1() {
        return new TematiskGruppeNivaa1();
    }

    /**
     * Create an instance of {@link TematiskGruppeNivaa2 }
     * 
     */
    public TematiskGruppeNivaa2 createTematiskGruppeNivaa2() {
        return new TematiskGruppeNivaa2();
    }

    /**
     * Create an instance of {@link ICD10 }
     * 
     */
    public ICD10 createICD10() {
        return new ICD10();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tittel")
    public JAXBElement<String> createTittel(String value) {
        return new JAXBElement<String>(_Tittel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "kode")
    public JAXBElement<String> createKode(String value) {
        return new JAXBElement<String>(_Kode_QNAME, String.class, null, value);
    }

}

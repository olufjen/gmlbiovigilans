//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.11 at 10:28:47 AM CET 
//


package no.naks.biovigilans.felles.xml.no;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}kode"/>
 *         &lt;element ref="{}tittel"/>
 *         &lt;element ref="{}tematisk_gruppe_nivaa_2" maxOccurs="unbounded"/>
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
    "kode",
    "tittel",
    "tematiskGruppeNivaa2"
})
@XmlRootElement(name = "tematisk_gruppe_nivaa_1")
public class TematiskGruppeNivaa1 {

    @XmlElement(required = true)
    protected String kode;
    @XmlElement(required = true)
    protected String tittel;
    @XmlElement(name = "tematisk_gruppe_nivaa_2", required = true)
    protected List<TematiskGruppeNivaa2> tematiskGruppeNivaa2;

    /**
     * Gets the value of the kode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKode() {
        return kode;
    }

    /**
     * Sets the value of the kode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKode(String value) {
        this.kode = value;
    }

    /**
     * Gets the value of the tittel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTittel() {
        return tittel;
    }

    /**
     * Sets the value of the tittel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTittel(String value) {
        this.tittel = value;
    }

    /**
     * Gets the value of the tematiskGruppeNivaa2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tematiskGruppeNivaa2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTematiskGruppeNivaa2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TematiskGruppeNivaa2 }
     * 
     * 
     */
    public List<TematiskGruppeNivaa2> getTematiskGruppeNivaa2() {
        if (tematiskGruppeNivaa2 == null) {
            tematiskGruppeNivaa2 = new ArrayList<TematiskGruppeNivaa2>();
        }
        return this.tematiskGruppeNivaa2;
    }

}

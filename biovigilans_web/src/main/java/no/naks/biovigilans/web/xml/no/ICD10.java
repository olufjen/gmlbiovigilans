//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.11 at 10:28:47 AM CET 
//


package no.naks.biovigilans.web.xml.no;

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
 *         &lt;element ref="{}tematisk_gruppe_nivaa_1" maxOccurs="unbounded"/>
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
    "tematiskGruppeNivaa1"
})
@XmlRootElement(name = "ICD-10")
public class ICD10 {

    @XmlElement(name = "tematisk_gruppe_nivaa_1", required = true)
    protected List<TematiskGruppeNivaa1> tematiskGruppeNivaa1;

    /**
     * Gets the value of the tematiskGruppeNivaa1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tematiskGruppeNivaa1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTematiskGruppeNivaa1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TematiskGruppeNivaa1 }
     * 
     * 
     */
    public List<TematiskGruppeNivaa1> getTematiskGruppeNivaa1() {
        if (tematiskGruppeNivaa1 == null) {
            tematiskGruppeNivaa1 = new ArrayList<TematiskGruppeNivaa1>();
        }
        return this.tematiskGruppeNivaa1;
    }

}

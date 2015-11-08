
package uy.edu.fing.middleware.generated.amazonia;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reservaProductos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reservaProductos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://interfaces.obligatorio2.middleware.fing.edu.uy/}datoReserva" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservaProductos", propOrder = {
    "arg0"
})
public class ReservaProductos {

    protected List<DatoReserva> arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg0 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg0().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatoReserva }
     * 
     * 
     */
    public List<DatoReserva> getArg0() {
        if (arg0 == null) {
            arg0 = new ArrayList<DatoReserva>();
        }
        return this.arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param arg0
     *     allowed object is
     *     {@link DatoReserva }
     *     
     */
    public void setArg0(List<DatoReserva> arg0) {
        this.arg0 = arg0;
    }

}

package xyz.lnews.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cargo {

    public Cargo(){}

    public Cargo(String carrierCode, int flightNumber, String org, String dest) {
        this.carrierCode = carrierCode;
        this.flightNumber = flightNumber;
        this.org = org;
        this.dest = dest;
    }

    @XmlElement
    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }
    @XmlElement
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    @XmlElement
    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
    @XmlElement
    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    private String carrierCode;
    private int flightNumber;
    private String org;
    private String dest;
}

package models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientsData extends RecursiveTreeObject<PatientsData> {
    private final StringProperty ID;
    private final StringProperty fname;
    private final StringProperty mname;
    private final StringProperty lname;
//    private final StringProperty ssn;
    private final StringProperty hcarename;
    private final StringProperty dob;
//    private final StringProperty email;
    private final StringProperty maritalstatus;
    private final StringProperty address;
    private final StringProperty citytown;
    private final StringProperty state;
    private final StringProperty gender;
    private final StringProperty mnum1;
    private final StringProperty mnum2;
    private final StringProperty pocs;
    private final StringProperty otherinfo;

    public PatientsData(String ID, String fname, String mname, String lname, String hcarename, String dob, String maritalstatus, String address, String citytown, String state, String mnum1, String mnum2, String pocs, String otherinfo, String gender) {
        this.ID = new SimpleStringProperty(ID);
        this.fname = new SimpleStringProperty(fname);;
        this.mname = new SimpleStringProperty(mname);;
        this.lname = new SimpleStringProperty(lname);;
//        this.ssn = new SimpleStringProperty(ssn);;
        this.hcarename = new SimpleStringProperty(hcarename);;
        this.dob = new SimpleStringProperty(dob);;
        this.maritalstatus = new SimpleStringProperty(maritalstatus);;
        this.address = new SimpleStringProperty(address);;
        this.citytown = new SimpleStringProperty(citytown);;
        this.state = new SimpleStringProperty(state);;
//        this.email = new SimpleStringProperty(email);
        this.mnum1 = new SimpleStringProperty(mnum1);;
        this.mnum2 = new SimpleStringProperty(mnum2);;
        this.gender = new SimpleStringProperty(gender);;
        this.pocs = new SimpleStringProperty(pocs);;
        this.otherinfo = new SimpleStringProperty(otherinfo);;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getFname() {
        return fname.get();
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getMname() {
        return mname.get();
    }

    public StringProperty mnameProperty() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname.set(mname);
    }

    public String getLname() {
        return lname.get();
    }

    public StringProperty lnameProperty() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname.set(lname);
    }

//    public String getSsn() {
//        return ssn.get();
//    }
//
//    public StringProperty ssnProperty() {
//        return ssn;
//    }
//
//    public void setSsn(String ssn) {
//        this.ssn.set(ssn);
//    }

    public String getHcarename() {
        return hcarename.get();
    }

    public StringProperty hcarenameProperty() {
        return hcarename;
    }

    public void setHcarename(String hcarename) {
        this.hcarename.set(hcarename);
    }

    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public String getMaritalstatus() {
        return maritalstatus.get();
    }

    public StringProperty maritalstatusProperty() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus.set(maritalstatus);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCitytown() {
        return citytown.get();
    }

    public StringProperty citytownProperty() {
        return citytown;
    }

    public void setCitytown(String citytown) {
        this.citytown.set(citytown);
    }

    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getMnum1() {
        return mnum1.get();
    }

    public StringProperty mnum1Property() {
        return mnum1;
    }

    public void setMnum1(String mnum1) {
        this.mnum1.set(mnum1);
    }

    public String getMnum2() {
        return mnum2.get();
    }

    public StringProperty mnum2Property() {
        return mnum2;
    }

    public void setMnum2(String mnum2) {
        this.mnum2.set(mnum2);
    }

    public String getPocs() {
        return pocs.get();
    }

    public StringProperty pocsProperty() {
        return pocs;
    }

    public void setPocs(String pocs) {
        this.pocs.set(pocs);
    }

    public String getOtherinfo() {
        return otherinfo.get();
    }

    public StringProperty otherinfoProperty() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo.set(otherinfo);
    }
}

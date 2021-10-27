package com.codegym.model;

public class MedicalDeclaration {
    private int idForm;
    private String fullName;
    private String birth;
    private String gender;
    private String nationality;
    private String idCardNumber;
    private String travelInfo;
    private String vehicleNumber;
    private String seatNumber;
    private String departureDay;
    private String endDay;
    private String cityIn14day;
    private String address;
    private String phone;
    private String email;
    private Boolean fever;
    private Boolean cough;
    private Boolean stuffy;
    private Boolean soreThroat;
    private Boolean nausea;
    private Boolean diarrhea;
    private Boolean skinHemorrhage;
    private Boolean skinRash;
    private Boolean market;
    private Boolean nCoVPeople;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int idForm, String fullName, String birth, String gender, String nationality,
                              String idCardNumber, String travelInfo, String vehicleNumber, String seatNumber,
                              String departureDay, String endDay, String cityIn14day, String address, String phone,
                              String email, Boolean fever, Boolean cough, Boolean stuffy, Boolean soreThroat,
                              Boolean nausea, Boolean diarrhea, Boolean skinHemorrhage, Boolean skinRash, Boolean market,
                              Boolean nCoVPeople) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCardNumber = idCardNumber;
        this.travelInfo = travelInfo;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.departureDay = departureDay;
        this.endDay = endDay;
        this.cityIn14day = cityIn14day;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.stuffy = stuffy;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.market = market;
        this.nCoVPeople = nCoVPeople;
    }

    public MedicalDeclaration(int idForm, String fullName, String birth, String gender, String nationality,
                              String idCardNumber, String travelInfo, String departureDay, String endDay, String cityIn14day,
                              String address, String phone, Boolean fever, Boolean cough, Boolean stuffy, Boolean soreThroat,
                              Boolean nausea, Boolean diarrhea, Boolean skinHemorrhage, Boolean skinRash, Boolean market,
                              Boolean nCoVPeople) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCardNumber = idCardNumber;
        this.travelInfo = travelInfo;
        this.departureDay = departureDay;
        this.endDay = endDay;
        this.cityIn14day = cityIn14day;
        this.address = address;
        this.phone = phone;
        this.fever = fever;
        this.cough = cough;
        this.stuffy = stuffy;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.market = market;
        this.nCoVPeople = nCoVPeople;
    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCityIn14day() {
        return cityIn14day;
    }

    public void setCityIn14day(String cityIn14day) {
        this.cityIn14day = cityIn14day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getStuffy() {
        return stuffy;
    }

    public void setStuffy(Boolean stuffy) {
        this.stuffy = stuffy;
    }

    public Boolean getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(Boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public Boolean getSkinRash() {
        return skinRash;
    }

    public void setSkinRash(Boolean skinRash) {
        this.skinRash = skinRash;
    }

    public Boolean getMarket() {
        return market;
    }

    public void setMarket(Boolean market) {
        this.market = market;
    }

    public Boolean getnCoVPeople() {
        return nCoVPeople;
    }

    public void setnCoVPeople(Boolean nCoVPeople) {
        this.nCoVPeople = nCoVPeople;
    }
}

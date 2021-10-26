package com.codegym.model;

public class MedicalDeclaration {
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
    private boolean fever;
    private boolean cough;
    private boolean stuffy;
    private boolean soreThroat;
    private boolean nausea;
    private boolean diarrhea;
    private boolean skinHemorrhage;
    private boolean skinRash;
    private boolean market;
    private boolean nCoVPeople;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName, String birth, String gender, String nationality, String idCardNumber,
                              String travelInfo, String vehicleNumber, String seatNumber, String departureDay, String endDay,
                              String cityIn14day, String address, String phone, String email,
                              boolean fever, boolean cough, boolean stuffy, boolean soreThroat, boolean nausea,
                              boolean diarrhea, boolean skinHemorrhage, boolean skinRash, boolean market, boolean nCoVPeople) {
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

    public MedicalDeclaration(String fullName, String birth, String gender, String nationality, String idCardNumber,
                              String travelInfo, String departureDay, String endDay, String cityIn14day, String address,
                              String phone, String email, boolean fever, boolean cough, boolean stuffy, boolean soreThroat,
                              boolean nausea, boolean diarrhea, boolean skinHemorrhage, boolean skinRash, boolean market,
                              boolean nCoVPeople) {
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

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isStuffy() {
        return stuffy;
    }

    public void setStuffy(boolean stuffy) {
        this.stuffy = stuffy;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isMarket() {
        return market;
    }

    public void setMarket(boolean market) {
        this.market = market;
    }

    public boolean isnCoVPeople() {
        return nCoVPeople;
    }

    public void setnCoVPeople(boolean nCoVPeople) {
        this.nCoVPeople = nCoVPeople;
    }
}

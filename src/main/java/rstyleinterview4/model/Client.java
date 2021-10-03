package rstyleinterview4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;
import java.util.Date;

public class Client {

    private int id;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("documenttype")
    private int documentType;

    @JsonProperty("documentnumber")
    private String documentNumber;

    @JsonProperty("birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @JsonProperty("birthplace")
    private String birthPlace;

    @JsonProperty("arrests")
    private Integer[] arrests;



    public Client() {
    }

    public Client(int id, String lastName, String firstName, int documentType, String documentNumber, Date birthDate, String birthPlace, Integer[] arrests) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.arrests = arrests;
    }

    public Client(String lastName, String firstName, int documentType, String documentNumber, Date birthDate, String birthPlace, Integer[] arrests) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.arrests = arrests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer[] getArrests() {
        return arrests;
    }

    public void setArrests(Integer[] arrests) {
        this.arrests = arrests;
    }
}

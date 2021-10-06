package rstyleinterview4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Integer[] getArrests() {
        return arrests;
    }

}

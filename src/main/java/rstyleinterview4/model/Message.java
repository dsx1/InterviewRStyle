package rstyleinterview4.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Message {
    @JsonProperty("requestid")
    private int requestId;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("documenttype")
    private int documentType;

    @JsonProperty("documentnumber")
    private String documentNumber;

    @JsonProperty("birthdate")
    private Date birthDate;

    @JsonProperty("birthplace")
    private String birthPlace;

    @JsonProperty("issuedate")
    private Date issueDate;

    @JsonProperty("organcode")
    private int organCode;

    @JsonProperty("arrestdocdate")
    private Date arrestDocDate;

    @JsonProperty("arrestdocnumber")
    private String arrestDocNumber;

    @JsonProperty("purpose")
    private String purpose;

    @JsonProperty("amount")
    private long amount;

    @JsonProperty("arrestrefdocnumber")
    private String arrestRefDocNumber;

    @JsonProperty("operation")
    private int operation;

    public Message() {
    }

    public Message(int requestId, String lastName, String firstName, int documentType, String documentNumber, Date birthDate, String birthPlace, Date issueDate, int organCode, Date arrestDocDate, String arrestDocNumber, String purpose, long amount, String arrestRefDocNumber, int operation) {
        this.requestId = requestId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.issueDate = issueDate;
        this.organCode = organCode;
        this.arrestDocDate = arrestDocDate;
        this.arrestDocNumber = arrestDocNumber;
        this.purpose = purpose;
        this.amount = amount;
        this.arrestRefDocNumber = arrestRefDocNumber;
        this.operation = operation;
    }

    public int getRequestId() {
        return requestId;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public int getOrganCode() {
        return organCode;
    }

    public Date getArrestDocDate() {
        return arrestDocDate;
    }

    public String getArrestDocNumber() {
        return arrestDocNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public long getAmount() {
        return amount;
    }

    public String getArrestRefDocNumber() {
        return arrestRefDocNumber;
    }

    public int getOperation() {
        return operation;
    }

}

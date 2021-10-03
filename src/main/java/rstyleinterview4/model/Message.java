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

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public int getOrganCode() {
        return organCode;
    }

    public void setOrganCode(int organCode) {
        this.organCode = organCode;
    }

    public Date getArrestDocDate() {
        return arrestDocDate;
    }

    public void setArrestDocDate(Date arrestDocDate) {
        this.arrestDocDate = arrestDocDate;
    }

    public String getArrestDocNumber() {
        return arrestDocNumber;
    }

    public void setArrestDocNumber(String arrestDocNumber) {
        this.arrestDocNumber = arrestDocNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getArrestRefDocNumber() {
        return arrestRefDocNumber;
    }

    public void setArrestRefDocNumber(String arrestRefDocNumber) {
        this.arrestRefDocNumber = arrestRefDocNumber;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}

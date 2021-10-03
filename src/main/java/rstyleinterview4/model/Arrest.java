package rstyleinterview4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Arrest {
    private int id;

    @JsonProperty("organcode")
    @NotNull
    private int organCode;


    @JsonProperty("documentdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date docDate;

    @JsonProperty("docnumber")
    private String docNumber;

    @Size(max = 1000)
    @NotNull
    @JsonProperty("purpose")
    private String purpose;

    @NotNull
    @JsonProperty("amount")
    private long amount;

    @JsonProperty("refdocnumber")
    private String refDocNumber;

    @NotNull
    @JsonProperty("status")
    private int status;

    public Arrest(){

    }

    public Arrest(int id, int organCode, Date docDate, String docNumber, String purpose, long amount, String refDocNumber, int status) {
        this.id = id;
        this.organCode = organCode;
        this.docDate = docDate;
        this.docNumber = docNumber;
        this.purpose = purpose;
        this.amount = amount;
        this.refDocNumber = refDocNumber;
        this.status = status;
    }

    public Arrest(int organCode, Date docDate, String docNumber, String purpose, long amount, String refDocNumber, int status) {
        this.organCode = organCode;
        this.docDate = docDate;
        this.docNumber = docNumber;
        this.purpose = purpose;
        this.amount = amount;
        this.refDocNumber = refDocNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrganCode() {
        return organCode;
    }

    public void setOrganCode(int organCode) {
        this.organCode = organCode;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
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

    public String getRefDocNumber() {
        return refDocNumber;
    }

    public void setRefDocNumber(String refDocNumber) {
        this.refDocNumber = refDocNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

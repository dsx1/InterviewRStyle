package rstyleinterview4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public int getOrganCode() {
        return organCode;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public long getAmount() {
        return amount;
    }

    public String getRefDocNumber() {
        return refDocNumber;
    }

    public int getStatus() {
        return status;
    }


}

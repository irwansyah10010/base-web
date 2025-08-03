package io.irwansyahdev96.backoffice.data.model.view;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="V_JALIN_TRX")
@Data
public class VJalinTrx {
    @Id
    @Column(name="ID")
    private String id;
        
    @Column(name="RRN")
    private String rrn;
    
    @Column(name="CARD_NO")
    private String cardNo;
    
    @Column(name="TERMINAL_ID")
    private String terminalId;
    
    @Column(name="PROCESSING_CODE")
    private String processingCode;
    
    @Column(name="CREATED_DATE")
    private Date createdDate;
    
    @Column(name="RESPONSE_CODE")
    private String responseCode;
    
    @Column(name="RESPONSE_MESSAGE")
    private String responseMessage;
    
    @Column(name="MERCHANT_TYPE")
    private String merchantType;
    
    @Column(name="AMOUNT")
    private String amount;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="SOF_NO")
    private String sofNo;
    
    @Column(name="MTI")
    private String mti;
    
    @Column(name="BILLER_CODE")
    private String billerCode;
    
}

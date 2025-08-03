package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "V_JALIN_REPLACE_RC_SWITCHER")
@Data
public class VJalinReplaceRcSwitcher {
    @Column(name="SWCODE")
    private String swcode;
    @Column(name="PROCODE")
    private String procode;
    @Column(name="RC_BEFORE")
    private String rcBefore;
    @Column(name="RC_AFTER")
    private String rcAfter;

    @Id
    @Column(name="ID")
    private String id;
    
    @Column(name="CREATED_DATE")
    private String createdDate;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="LAST_MODIFIED_DATE")
    private String lastModifiedDate;
    @Column(name="LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @Column(name="SWNAME")
    private String swname;
}

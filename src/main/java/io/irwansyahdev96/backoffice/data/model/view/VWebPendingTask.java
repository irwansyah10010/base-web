package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="V_WEB_PENDING_TASK")
@Data
public class VWebPendingTask {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "MENU_MODULE")
    private String menuModule;
    @Column(name = "CREATED_DATE")
    private String createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "LAST_MODIFIED_DATE")
    private String lastModifiedDate;
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PRIMARY_KEYS")
    private String primaryKeys;
    @Column(name = "OPR_TYPE")
    private String oprType;
    @Column(name = "OLD_DATA")
    private String oldData;
    @Column(name = "NEW_DATA")
    private String newData;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "MODULE_NAME")
    private String moduleName;
}

package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "V_WEB_USER_REPORT")
@Data
public class VWebUserReport {
    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="FULL_NAME")
    private String fullName;
    @Column(name="NIP")
    private String nip;
    @Column(name="EMAIL")
    private String email;
    @Column(name="UNIT_KERJA")
    private String unitKerja;
    @Column(name="CREATED_DATE")
    private String createdDate;
    @Column(name="ENABLED")
    private String enabled;
    @Column(name="LAST_LOGIN_WEB")
    private String lastLoginWeb;
    @Column(name="ROLE_NAME")
    private String roleName;
}

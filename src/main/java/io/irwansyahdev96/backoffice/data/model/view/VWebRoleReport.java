package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "V_WEB_ROLE_REPORT")
@Data
public class VWebRoleReport {
    @Id
    @Column(name ="ROLE_NAME")
    private String roleName;

    @Column(name ="DESCRIPTION")
    private String description;
}

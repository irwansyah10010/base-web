package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="V_USER_MODULE")
@Data
public class VUserModule {
    @Id
    @Column(name = "UUID")
    private String uuid;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "MODULE")
    private String module;
}

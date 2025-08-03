package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "V_USER_ROLE")
@Data
public class VUserRole {
    @Id
    @Column(name="UUID")
    private String uuid;
    @Column(name="USERNAME")
    private String username;
    @Column(name="id")
    private String id;
    @Column(name="NAME")
    private String name;
}

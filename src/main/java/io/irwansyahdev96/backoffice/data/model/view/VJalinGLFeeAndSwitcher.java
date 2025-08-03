package io.irwansyahdev96.backoffice.data.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "V_JALIN_GL_FEE_SWITCHER")
@Data
public class VJalinGLFeeAndSwitcher {
    
    @Id
    private String id;

    @Column(name="SWNAME")
    private String swname;

    @Column(name="DESTINATION_ID")
    private String destinationId;

    @Column(name="GL_ACCOUNT_1")
    private String glAccount1;

    @Column(name="GL_ACCOUNT_2")
    private String glAccount2;

    @Column(name="GL_ACCOUNT_3")
    private String glAccount3;

    @Column(name="DESCRIPTION")
    private String description;

}

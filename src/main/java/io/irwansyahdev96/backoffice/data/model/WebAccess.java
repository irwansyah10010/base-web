

 package io.irwansyahdev96.backoffice.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "WEB_ACCESS")
public class WebAccess {
    public WebAccess(String username, String description, String source, Date accessDate, String data) {
        this.username = username;
        this.description = description;
        this.source = source;
        this.accessDate = accessDate;
        this.data = data;
    }

    @Id
    @Column(name = "ID", unique = true)
    // @GenericGenerator(name = "seqWebAccess", strategy = "id.co.bankmandiri.portaldigit.data.UniqueSequenceGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqWebAccess")
    private String id;

    @Column(name = "USERNAME")
    String username;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "SOURCE")
    String source;

    @Column(name = "ACCESS_DATE")
    @CreationTimestamp
    Date accessDate;

    @Column(name = "DATA")
    String data;

    public WebAccess() {

    }
}

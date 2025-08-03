

package io.irwansyahdev96.backoffice.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "WEB_ROLE")
public class Role {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    String name;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    Date createdDate;

    @Column(name = "CREATED_BY")
    String createdBy;

    @CreationTimestamp
    @Column(name = "LAST_MODIFIED_DATE")
    Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    String lastModifiedBy;

    @Column(name = "VERSION")
    long version;
}

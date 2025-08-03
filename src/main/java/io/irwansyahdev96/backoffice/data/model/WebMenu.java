

package io.irwansyahdev96.backoffice.data.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "WEB_MENU")
@SequenceGenerator(name = "seqWebMenu", sequenceName = "SEQ_WEB_MENU", allocationSize = 1)
public class WebMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqWebMenu")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODULE")
    private String module;

    @Column(name = "PARENT_ID")
    private long parentId;
}

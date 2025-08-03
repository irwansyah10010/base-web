

package io.irwansyahdev96.backoffice.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "WEB_USER")
@SequenceGenerator(name = "seqWebUser", sequenceName = "SEQ_WEB_USER", allocationSize = 1)
public class User implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqWebUser")
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_LOGIN_WEB")
    private long isLoginWeb;

    @CreationTimestamp
    @Column(name = "LAST_LOGIN_WEB")
    private Date lastLoginWeb;

    @Column(name = "LAST_LOGIN_SRC")
    private String lastLoginSrc;

    @CreationTimestamp
    @Column(name = "LAST_LOGOUT_WEB")
    private Date lastLogoutWeb;

    @Column(name = "LAST_IP_WEB")
    private String lastIpWeb;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENABLED")
    private long enabled;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "NIP")
    private String nip;

    @CreationTimestamp
    @Column(name = "LAST_RESET_DATE")
    private Date lastResetDate;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "INVALID_LOGIN_COUNTER")
    private long invalidLoginCounter;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "VERSION")
    private long version;

    @Column(name = "LAST_ACCESS")
    private long lastAccess;

    @Column(name = "SESSION_ID")
    private String sessionId;


    @Transient
    private long roleId;

    @Transient
    private String password2;
}

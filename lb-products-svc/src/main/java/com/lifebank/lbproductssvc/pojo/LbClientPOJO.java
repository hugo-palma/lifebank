package com.lifebank.lbproductssvc.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_client", schema = "lb_bank", catalog = "postgres")
public class LbClientPOJO {
    private Integer cliId;
    private String cliMail;
    private String cliPassword;
    private String cliDocument;
    private String cliUsername;
    private Collection<LbBankAccountPOJO> lbBankAccountsByCliId;
    private Collection<LbCreditCardsPOJO> lbCreditCardsByCliId;
    private Collection<LbLoansPOJO> lbLoansByCliId;

    @Id
    @Column(name = "cli_id", nullable = false)
    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    @Basic
    @Column(name = "cli_mail", nullable = false, length = 50)
    public String getCliMail() {
        return cliMail;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    @Basic
    @Column(name = "cli_password", nullable = false, length = 50)
    public String getCliPassword() {
        return cliPassword;
    }

    public void setCliPassword(String cliPassword) {
        this.cliPassword = cliPassword;
    }

    @Basic
    @Column(name = "cli_document", nullable = false, length = 50)
    public String getCliDocument() {
        return cliDocument;
    }

    public void setCliDocument(String cliDocument) {
        this.cliDocument = cliDocument;
    }

    @Basic
    @Column(name = "cli_username", nullable = false, length = 50)
    public String getCliUsername() {
        return cliUsername;
    }

    public void setCliUsername(String cliUsername) {
        this.cliUsername = cliUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbClientPOJO that = (LbClientPOJO) o;
        return Objects.equals(cliId, that.cliId) &&
                Objects.equals(cliMail, that.cliMail) &&
                Objects.equals(cliPassword, that.cliPassword) &&
                Objects.equals(cliDocument, that.cliDocument) &&
                Objects.equals(cliUsername, that.cliUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliId, cliMail, cliPassword, cliDocument, cliUsername);
    }

    @OneToMany(mappedBy = "lbClientByAccCliId")
    public Collection<LbBankAccountPOJO> getLbBankAccountsByCliId() {
        return lbBankAccountsByCliId;
    }

    public void setLbBankAccountsByCliId(Collection<LbBankAccountPOJO> lbBankAccountsByCliId) {
        this.lbBankAccountsByCliId = lbBankAccountsByCliId;
    }

    @OneToMany(mappedBy = "lbClientByCreCliId")
    public Collection<LbCreditCardsPOJO> getLbCreditCardsByCliId() {
        return lbCreditCardsByCliId;
    }

    public void setLbCreditCardsByCliId(Collection<LbCreditCardsPOJO> lbCreditCardsByCliId) {
        this.lbCreditCardsByCliId = lbCreditCardsByCliId;
    }

    @OneToMany(mappedBy = "lbClientByLoaCliId")
    public Collection<LbLoansPOJO> getLbLoansByCliId() {
        return lbLoansByCliId;
    }

    public void setLbLoansByCliId(Collection<LbLoansPOJO> lbLoansByCliId) {
        this.lbLoansByCliId = lbLoansByCliId;
    }
}

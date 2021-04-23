package fr.ul.dm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PasswordDTO {
    private String password;
    private String sel;
    private Long id;

    public PasswordDTO(String password, String sel) {
        this.password = password;
        this.sel = sel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}

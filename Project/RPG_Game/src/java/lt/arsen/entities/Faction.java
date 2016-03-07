/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.arsen.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aron
 */
@Entity
@Table(name = "FACTION")
@NamedQueries({
    @NamedQuery(name = "Faction.findAll", query = "SELECT f FROM Faction f"),
    @NamedQuery(name = "Faction.findById", query = "SELECT f FROM Faction f WHERE f.id = :id"),
    @NamedQuery(name = "Faction.findByName", query = "SELECT f FROM Faction f WHERE f.name = :name"),
    @NamedQuery(name = "Faction.findByMemberLimit", query = "SELECT f FROM Faction f WHERE f.memberLimit = :memberLimit")})
public class Faction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_LIMIT")
    private int memberLimit;
    @ManyToMany(mappedBy = "factionList")
    private List<Player> playerList;

    public Faction() {
    }

    public Faction(Integer id) {
        this.id = id;
    }

    public Faction(Integer id, String name, int memberLimit) {
        this.id = id;
        this.name = name;
        this.memberLimit = memberLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(int memberLimit) {
        this.memberLimit = memberLimit;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faction)) {
            return false;
        }
        Faction other = (Faction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.arsen.entities.Faction[ id=" + id + " ]";
    }
    
}

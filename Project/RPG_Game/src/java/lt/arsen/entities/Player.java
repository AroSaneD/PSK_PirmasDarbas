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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aron
 */
@Entity
@Table(name = "PLAYER")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByHealth", query = "SELECT p FROM Player p WHERE p.health = :health")})
public class Player implements Serializable {

    @Size(max = 255)
    @Column(name = "PLAYER_UID")
    private String playerUid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEALTH")
    private double health;
    @JoinTable(name = "PLAYER_TO_FACTION", joinColumns = {
        @JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FACTION_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Faction> factionList;
    @JoinColumn(name = "ITEM", referencedColumnName = "ID")
    @ManyToOne
    private Weapon item;
    @OneToMany(mappedBy = "playerId")
    private List<Weapon> weaponList;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Player(Integer id, double health) {
        this.id = id;
        this.health = health;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public List<Faction> getFactionList() {
        return factionList;
    }

    public void setFactionList(List<Faction> factionList) {
        this.factionList = factionList;
    }

    public Weapon getItem() {
        return item;
    }

    public void setItem(Weapon item) {
        this.item = item;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerUid != null ? playerUid.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(object == null || !(object instanceof Player)){
            return false;
        }
        Player otherPlayer = (Player)object;
        return this.playerUid.equals(otherPlayer.getPlayerUid());
    }

    @Override
    public String toString() {
        return "lt.arsen.entities.Player[ id=" + id + " ]";
    }

    public String getPlayerUid() {
        return playerUid;
    }

    public void setPlayerUid(String playerUid) {
        this.playerUid = playerUid;
    }
    
}

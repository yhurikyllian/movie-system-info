/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataBase;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sora
 */
@Entity
@Table(name = "list", catalog = "anime", schema = "")
@NamedQueries({
    @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l"),
    @NamedQuery(name = "List.findByCode", query = "SELECT l FROM List l WHERE l.code = :code"),
    @NamedQuery(name = "List.findByTitle", query = "SELECT l FROM List l WHERE l.title = :title"),
    @NamedQuery(name = "List.findByEpisodes", query = "SELECT l FROM List l WHERE l.episodes = :episodes"),
    @NamedQuery(name = "List.findByYear", query = "SELECT l FROM List l WHERE l.year = :year"),
    @NamedQuery(name = "List.findByProducers", query = "SELECT l FROM List l WHERE l.producers = :producers"),
    @NamedQuery(name = "List.findByGenre", query = "SELECT l FROM List l WHERE l.genre = :genre"),
    @NamedQuery(name = "List.findByRating", query = "SELECT l FROM List l WHERE l.rating = :rating")})
public class List implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "episodes")
    private Integer episodes;
    @Basic(optional = false)
    @Column(name = "year")
    private Integer year;
    @Basic(optional = false)
    @Column(name = "producers")
    private String producers;
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "rating")
    private Integer rating;

    public List() {
    }

    public List(Integer code) {
        this.code = code;
    }

    public List(Integer code, String title, Integer episodes, Integer year, String producers, String genre, Integer rating) {
        this.code = code;
        this.title = title;
        this.episodes = episodes;
        this.year = year;
        this.producers = producers;
        this.genre = genre;
        this.rating = rating;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        Integer oldCode = this.code;
        this.code = code;
        changeSupport.firePropertyChange("code", oldCode, code);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        Integer oldEpisodes = this.episodes;
        this.episodes = episodes;
        changeSupport.firePropertyChange("episodes", oldEpisodes, episodes);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        Integer oldYear = this.year;
        this.year = year;
        changeSupport.firePropertyChange("year", oldYear, year);
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        String oldProducers = this.producers;
        this.producers = producers;
        changeSupport.firePropertyChange("producers", oldProducers, producers);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        Integer oldRating = this.rating;
        this.rating = rating;
        changeSupport.firePropertyChange("rating", oldRating, rating);
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof List)) {
            return false;
        }
        List other = (List) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface.List[ code=" + code + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

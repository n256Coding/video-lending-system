/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemPackage;

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
 * @author NishanV
 */
@Entity
@Table(name = "videos", catalog = "vlendingsystemdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v"),
    @NamedQuery(name = "Videos.findByVideoId", query = "SELECT v FROM Videos v WHERE v.videoId = :videoId"),
    @NamedQuery(name = "Videos.findByTitle", query = "SELECT v FROM Videos v WHERE v.title = :title"),
    @NamedQuery(name = "Videos.findByType", query = "SELECT v FROM Videos v WHERE v.type = :type"),
    @NamedQuery(name = "Videos.findByQty", query = "SELECT v FROM Videos v WHERE v.qty = :qty"),
    @NamedQuery(name = "Videos.findByDirector", query = "SELECT v FROM Videos v WHERE v.director = :director"),
    @NamedQuery(name = "Videos.findByProducer", query = "SELECT v FROM Videos v WHERE v.producer = :producer"),
    @NamedQuery(name = "Videos.findByActor1", query = "SELECT v FROM Videos v WHERE v.actor1 = :actor1"),
    @NamedQuery(name = "Videos.findByActor2", query = "SELECT v FROM Videos v WHERE v.actor2 = :actor2"),
    @NamedQuery(name = "Videos.findByPricePer7d", query = "SELECT v FROM Videos v WHERE v.pricePer7d = :pricePer7d"),
    @NamedQuery(name = "Videos.findByAddPricePerD", query = "SELECT v FROM Videos v WHERE v.addPricePerD = :addPricePerD"),
    @NamedQuery(name = "Videos.findByArtUrl", query = "SELECT v FROM Videos v WHERE v.artUrl = :artUrl")})
public class Videos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "videoId")
    private Integer videoId;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "director")
    private String director;
    @Column(name = "producer")
    private String producer;
    @Column(name = "actor1")
    private String actor1;
    @Column(name = "actor2")
    private String actor2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pricePer7d")
    private Double pricePer7d;
    @Column(name = "addPricePerD")
    private Double addPricePerD;
    @Column(name = "artUrl")
    private String artUrl;

    public Videos() {
    }

    public Videos(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        Integer oldVideoId = this.videoId;
        this.videoId = videoId;
        changeSupport.firePropertyChange("videoId", oldVideoId, videoId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        Integer oldQty = this.qty;
        this.qty = qty;
        changeSupport.firePropertyChange("qty", oldQty, qty);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        String oldDirector = this.director;
        this.director = director;
        changeSupport.firePropertyChange("director", oldDirector, director);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        String oldProducer = this.producer;
        this.producer = producer;
        changeSupport.firePropertyChange("producer", oldProducer, producer);
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        String oldActor1 = this.actor1;
        this.actor1 = actor1;
        changeSupport.firePropertyChange("actor1", oldActor1, actor1);
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        String oldActor2 = this.actor2;
        this.actor2 = actor2;
        changeSupport.firePropertyChange("actor2", oldActor2, actor2);
    }

    public Double getPricePer7d() {
        return pricePer7d;
    }

    public void setPricePer7d(Double pricePer7d) {
        Double oldPricePer7d = this.pricePer7d;
        this.pricePer7d = pricePer7d;
        changeSupport.firePropertyChange("pricePer7d", oldPricePer7d, pricePer7d);
    }

    public Double getAddPricePerD() {
        return addPricePerD;
    }

    public void setAddPricePerD(Double addPricePerD) {
        Double oldAddPricePerD = this.addPricePerD;
        this.addPricePerD = addPricePerD;
        changeSupport.firePropertyChange("addPricePerD", oldAddPricePerD, addPricePerD);
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        String oldArtUrl = this.artUrl;
        this.artUrl = artUrl;
        changeSupport.firePropertyChange("artUrl", oldArtUrl, artUrl);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (videoId != null ? videoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        if ((this.videoId == null && other.videoId != null) || (this.videoId != null && !this.videoId.equals(other.videoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "systemPackage.Videos[ videoId=" + videoId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

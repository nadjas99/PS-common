/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nadja
 */
public class ReservationDetail implements GenericEntity{
    
    private Long id;
    private Reservation reservation;
    private double cost;
    private PhotographyServices service;

    public ReservationDetail(Long id, Reservation reservation, double cost, PhotographyServices service) {
        this.id = id;
        this.reservation = reservation;
        this.cost = cost;
        this.service = service;
    }

    public ReservationDetail() {
    }
    
    
    

    @Override
    public String getTableName() {
        return "reservationdetail"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,idReservation,idPhotographyService,cost"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
       StringBuilder sb = new StringBuilder();
       
       sb.append(id).append(", ")
                .append(reservation.getId()).append(", ")
                .append(service.getId()).append(", ").append(cost);
       
       return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.id=id;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
          List<GenericEntity> details = new ArrayList<>();
        while(rs.next()){
            ReservationDetail t = new ReservationDetail();
                    t.setId(rs.getLong("id"));
                    Reservation r = new Reservation();
                    r.setId(rs.getLong("idReservation"));
                    t.setReservation(r);
                   PhotographyServices phs=new PhotographyServices();
                   phs.setId(rs.getLong("idPhotographyService"));
                   t.setService(phs);
                   t.setCost(rs.getDouble("cost"));
                    details.add(t);
        }
        return details;
    }

    @Override
    public String getJoinCondition() {
        return ""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateValues() {
       StringBuilder sb = new StringBuilder();
      
       
        sb.append("cost=").append(cost);
        
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObjectCase() {
         System.out.println(reservation.getId());
        return "id="+id+" and idReservation="+reservation.getId();
    }

    @Override
    public String getSearchCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public PhotographyServices getService() {
        return service;
    }

    public void setService(PhotographyServices service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.reservation);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.service);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservationDetail other = (ReservationDetail) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.reservation, other.reservation)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        return true;
    }
    
    
}

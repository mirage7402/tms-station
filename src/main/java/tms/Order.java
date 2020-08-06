package tms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String stationname;
    private String oiltype;
    private String description;

    @PostPersist
    public void onPostPersist(){
        OrderRegistered orderRegistered = new OrderRegistered();
        BeanUtils.copyProperties(this, orderRegistered);
        orderRegistered.publishAfterCommit();


    }




    //@PostRemove
    //public void onPostRemove(){
    //    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    //    OrderCanceled orderCanceled = new OrderCanceled();
    //    BeanUtils.copyProperties(this, orderCanceled);
    //    orderCanceled.publishAfterCommit();
    //}

    @PrePersist
    public void onPrePersist(){
        OilTypeChanged oilTypeChanged = new OilTypeChanged();
        BeanUtils.copyProperties(this, oilTypeChanged);
        oilTypeChanged.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        tms.external.Allocation allocation = new tms.external.Allocation();
        // mappings goes here

        //StationApplication.applicationContext.getBean(tms.external.AllocationService.class).changeOilType(allocation);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }
    public String getOiltype() {
        return oiltype;
    }

    public void setOiltype(String oiltype) {
        this.oiltype = oiltype;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}

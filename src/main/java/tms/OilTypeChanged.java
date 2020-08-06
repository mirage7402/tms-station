package tms;

public class OilTypeChanged extends AbstractEvent {

    private Long id;
    private String oiltype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOiltype() {
        return oiltype;
    }

    public void setOiltype(String oiltype) {
        this.oiltype = oiltype;
    }
}
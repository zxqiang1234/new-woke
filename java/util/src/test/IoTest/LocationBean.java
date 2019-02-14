package test.IoTest;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-09 09:57
 **/
public class LocationBean {
    /**
     * lng : 116.43212999999994
     * lat : 38.766230098491626
     */

    private double lng;
    private double lat;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "LocationBean{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}

package test.OtherTest;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-18 10:22
 **/
public class Test {
    public static final double EARTH_RADIUS = 6378137.0; // 单位M

    private static double getRad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 两坐标（经纬度）之间距离计算
     * GD/BD地图采用此算法
     * @param startLng 起点坐标经度
     * @param startLat 起点坐标纬度
     * @param endLng 终点坐标经度
     * @param endLat 终点坐标纬度
     * @return 起点坐标与终点坐标的距离 单位:m
     */
    public static double getGreatCircleDistance(double startLng, double startLat, double endLng, double endLat) {
        double radLat1 = getRad(startLat);
        double radLat2 = getRad(endLat);
        double dy = radLat1 - radLat2; // a
        double dx = getRad(startLng) - getRad(endLng); // b
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(dy / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(dx / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000.0;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(getGreatCircleDistance(108.891897,34.232185,108.892167,34.230935));
        // 东经106.486654度 北纬23.490295度 向东移动4000米 向北移动3000米
        double lng = getMoveLng(23.490295, 4000) + 106.486654;
        double lat = getMoveLat(3000) + 23.490295;
        System.out.println(lat);
        System.out.println(lng);
        System.out.println("移动后两点距离（米）："+getGreatCircleDistance(106.486654, 23.490295,lng,lat));
    }

    /**
     * 获取纬度移动latMovement米，纬度移动的度数
     * @param latMovement 单位：米
     * @return 纬度移动的度数
     */
    public static double getMoveLat(double latMovement) {
        return (180/(Math.PI * EARTH_RADIUS))*latMovement;
    }

    /**
     * 获取经度移动lngMovement米，经度移动的度数
     * @param lat 纬度
     * @param lngMovement 单位：米
     * @return 经度移动的度数
     */
    public static double getMoveLng(double lat, double lngMovement) {
        return (180/(Math.PI * EARTH_RADIUS*Math.cos(Math.toRadians(lat))))*lngMovement;
    }
}

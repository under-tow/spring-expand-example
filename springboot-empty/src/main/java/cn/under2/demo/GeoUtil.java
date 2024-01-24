package cn.under2.demo;

import org.postgis.PGgeometry;
import org.springframework.boot.autoconfigure.cache.CacheProperties;

import java.math.BigDecimal;
import java.sql.SQLException;

public class GeoUtil {

    public static void main(String[] args) throws SQLException {
//         new PGpoint("POINT(109.2944153,28.67499864)");
//        PGgeometry pGgeometry1 = new PGgeometry("POINT(109.2944153 28.67499864)");
//        System.out.println("pGgeometry1 = " + pGgeometry1);

//        System.out.println(Math.pow(1.01, 85));
//        System.out.println(Math.pow(1.02, 85));
//        System.out.println(Math.pow(1.03, 85));
//        System.out.println(Math.pow(1.04, 85));
//        System.out.println(Math.pow(1.05, 85));
//        System.out.println(Math.pow(1.06, 85));
//
//        System.out.println(Math.pow(1.01, 50));
//        System.out.println(Math.pow(1.02, 50));
//        System.out.println(Math.pow(1.03, 50));
//        System.out.println(Math.pow(1.04, 50));
//        System.out.println(Math.pow(1.05, 50));
//        System.out.println(Math.pow(1.05, 50));
//        System.out.println(Math.pow(1.06, 50));

        System.out.println(Math.pow(1.01, 100));
        System.out.println(Math.pow(1.015, 100));
        System.out.println(Math.pow(1.02, 100));
        System.out.println(Math.pow(1.03, 100));

        System.out.println(Math.pow(2, 3));
//        System.out.println("calc = " + calc("2", 3));
    }

    private static BigDecimal calc(String x , int n){

        return new BigDecimal(x).scaleByPowerOfTen(n);

    }

    /**
     * wkt 转化 PGgeometry
     */
    public static PGgeometry toPGgeometry(String wkt) throws SQLException {

            return new PGgeometry(wkt);

    }

    /**
     * PGgeometry 转化 wkt
     */
    public static String toWkt(PGgeometry pGgeometry) {
        if (pGgeometry != null) {
            return pGgeometry.getGeometry().toString();
        }
        return "";
    }


}

package com.cityeyelab.dt.config.util;


import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import java.util.ArrayList;
import java.util.List;

public class GeomUtil {
  public static GeomUtil geomUtil = new GeomUtil();

  public static Point createPoint(double lon, double lat) {
    GeometryFactory gf = new GeometryFactory();
    Point point = gf.createPoint(new Coordinate(lon, lat));
    point.setSRID(4326);
    return point;
  }

  public static LineString createLineString(String stringGeometry) {

    String[] splitLeft = stringGeometry.split("\\(");
    String[] splitRight = splitLeft[1].split("\\)");
    String[] splitCoordinates = splitRight[0].split(",");
    Coordinate[] coordinates = new Coordinate[splitCoordinates.length];

    for (int i = 0; i < coordinates.length; i++) {
      String[] coordinate = splitCoordinates[i].split(" ");
      coordinates[i] = new Coordinate(Double.valueOf(coordinate[0]), Double.valueOf(coordinate[1]));
    }

    return new GeometryFactory().createLineString(coordinates);
  }

  public static LineString createLineString(List<List<Double>> coordinates) {

    if (coordinates.isEmpty()) return null;

    Coordinate[] coordinateArr = new Coordinate[coordinates.size()];

    for (int i = 0; i < coordinates.size(); i++) {
      List<Double> coordinate = coordinates.get(i);
      coordinateArr[i] = new Coordinate(coordinate.get(0),coordinate.get(1));
    }

    GeometryFactory gf = new GeometryFactory();
    LineString lineString = gf.createLineString(coordinateArr);
    lineString.setSRID(4326);
    return lineString;
  }

  public static List<List<Double>> reverseLineString(Coordinate[] coordinateArr) {

    List<List<Double>> coordinates = new ArrayList<>();

    for (int i = 0; i < coordinateArr.length; i++) {
      Coordinate coordinate = coordinateArr[i];
      coordinates.add(List.of(coordinate.x, coordinate.y));
    }

    return coordinates;
  }
}

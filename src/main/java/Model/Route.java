package Model;

import java.sql.Date;
import java.util.Objects;

public class Route {

    private int routeID;
    private String routeTitle;
    private String cityOfDeparture;
    private String cityOfArrival;
    private int routeDuration;
    private String driverID;
    private String busID;
    private String departureTime;
    private String arrivalTime;


    public int getRouteID() {
        return routeID;
    }

    public String getRouteTitle() {
        return routeTitle;
    }

    public String getRouteBegin() {
        return cityOfDeparture;
    }

    public String getRouteEnd() {
        return cityOfArrival;
    }

    public int getRouteDuration() {
        return routeDuration;
    }

    public String getRouteStartTime() {
        return departureTime;
    }

    public String getRouteEndTime() {
        return arrivalTime;
    }

    public String getBusID() {
        return busID;
    }

    public String getDriverID() {
        return driverID;
    }


    public static Route.Builder newBuilder() {
        return new Route().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return routeID == route.routeID &&
                routeDuration == route.routeDuration &&
                Objects.equals(routeTitle, route.routeTitle) &&
                Objects.equals(cityOfDeparture, route.cityOfDeparture) &&
                Objects.equals(cityOfArrival, route.cityOfArrival) &&
                Objects.equals(departureTime, route.departureTime) &&
                Objects.equals(arrivalTime, route.arrivalTime) &&
                Objects.equals(driverID, route.driverID) &&
                Objects.equals(busID, route.busID);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((busID == null) ? 0 : busID.hashCode());
        result = prime * result + ((driverID == null) ? 0 :  driverID.hashCode());
        result = prime * result + ((routeTitle == null) ? 0 : routeTitle.hashCode());
        result = prime * result + routeID;
        result = prime * result + ((cityOfDeparture == null) ? 0 : cityOfDeparture.hashCode());
        result = prime * result + ((cityOfArrival == null) ? 0 : cityOfArrival.hashCode());
        result = prime * result + routeDuration;
        result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
        result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeID = " + routeID +
                ", routeTitle = '" + routeTitle + '\'' +
                ", cityOfDeparture = '" + cityOfDeparture + '\'' +
                ", cityOfArrival = '" + cityOfArrival + '\'' +
                ", routeDuration = " + routeDuration +
                ", theDriver = " + driverID +
                ", busID = " + busID +
                ", departureTime = " + departureTime +
                ", arrivalTime = " + arrivalTime +
                '}';
    }

    public class Builder {

        private Builder() {
        }

        public Builder setRouteID(int aRouteID) {
            routeID = aRouteID;
            return this;
        }

        public Builder setRouteTitle(String aRouteTitle) {
            routeTitle = aRouteTitle;
            return this;
        }

        public Builder setRouteBegin(String aRouteBegin) {
            cityOfDeparture = aRouteBegin;
            return this;
        }

        public Builder setRouteEnd(String aRouteEnd) {
            cityOfArrival = aRouteEnd;
            return this;
        }

        public Builder setRouteDuration(int aRouteDuration) {
            routeDuration = aRouteDuration;
            return this;
        }

        public Builder setRouteStartTime(String aRouteStartTime) {
            departureTime = aRouteStartTime;
            return this;
        }

        public Builder setRouteEndTime(String aRouteEndTime) {
            arrivalTime = aRouteEndTime;
            return this;
        }

        public Builder setDriver(String aDriverID) {
            driverID = aDriverID;
            return this;
        }

        public Builder setBusID(String aBusID) {
            busID = aBusID;
            return this;
        }

        public Route build() {
            return Route.this;
        }
    }
}

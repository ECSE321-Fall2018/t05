package ca.mcgill.ecse321.android_passenger;

public class ListItem {

    private double distance;
    private double price;
    private String vehicleModel;



    public ListItem(double distance, double price, String vehicleModel) {
        this.distance = distance;
        this.price = price;
        this.vehicleModel = vehicleModel;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public String getVehicleModel(){
        return vehicleModel;
    }
}

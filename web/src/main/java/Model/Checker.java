package Model;

public class Checker {
    private String name;
    private String bodyMeasurements;
    private String img;

    public Checker() {
    }

    public Checker(String name, String bodyMeasurements, String img) {
        this.name = name;
        this.bodyMeasurements = bodyMeasurements;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyMeasurements() {
        return bodyMeasurements;
    }

    public void setBodyMeasurements(String bodyMeasurements) {
        this.bodyMeasurements = bodyMeasurements;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

package src;

public class Count {
    private double allHeight;

    public double getAllHeight() {
        return allHeight;
    }

    public void setAllHeight(double allHeight) {
        this.allHeight = allHeight;
    }

    public void count(String heigth) {
        setAllHeight(getAllHeight() + Double.parseDouble(heigth));
    }

}

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    public abstract double getBaseArea();
    public abstract double getVolume();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);
    }

    public static class VolumeComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s2.getVolume(), s1.getVolume());
        }
    }

    public static class BaseAreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s2.getBaseArea(), s1.getBaseArea());
        }
    }
}

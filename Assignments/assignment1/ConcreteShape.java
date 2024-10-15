public class Cylinder extends Shape {
    private double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder (h: %.2f, r: %.2f)", height, radius);
    }
}

public class Cone extends Shape {
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("Cone (h: %.2f, r: %.2f)", height, radius);
    }
}

public class Pyramid extends Shape {
    private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format("Pyramid (h: %.2f, e: %.2f)", height, edgeLength);
    }
}

public abstract class Prism extends Shape {
    protected double edgeLength;

    public Prism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}

public class SquarePrism extends Prism {
    public SquarePrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public String toString() {
        return String.format("SquarePrism (h: %.2f, e: %.2f)", height, edgeLength);
    }
}

public class TriangularPrism extends Prism {
    public TriangularPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }

    @Override
    public String toString() {
        return String.format("TriangularPrism (h: %.2f, e: %.2f)", height, edgeLength);
    }
}

public class PentagonalPrism extends Prism {
    public PentagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return (5 * edgeLength * edgeLength * Math.tan(Math.toRadians(54))) / 4;
    }

    @Override
    public String toString() {
        return String.format("PentagonalPrism (h: %.2f, e: %.2f)", height, edgeLength);
    }
}

public class OctagonalPrism extends Prism {
    public OctagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
    }

    @Override
    public String toString() {
        return String.format("OctagonalPrism (h: %.2f, e: %.2f)", height, edgeLength);
    }
}

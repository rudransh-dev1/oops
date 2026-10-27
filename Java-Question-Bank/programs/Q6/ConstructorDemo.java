class Box {
    double width, height, depth;
    Box() {                                   // default constructor
        width = height = depth = -1;
    }
    Box(double len) {                         // cube
        width = height = depth = len;
    }
    Box(double w, double h, double d) {       // parameterized constructor
        width = w; height = h; depth = d;
    }
    Box(Box ob) {                             // copy constructor
        width = ob.width; height = ob.height; depth = ob.depth;
    }
    double volume() { return width * height * depth; }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 15);
        Box b2 = new Box();
        Box cube = new Box(7);
        Box clone = new Box(b1);
        System.out.println("Volume of b1 is " + b1.volume());
        System.out.println("Volume of b2 is " + b2.volume());
        System.out.println("Volume of cube is " + cube.volume());
        System.out.println("Volume of clone is " + clone.volume());
    }
}

class OuterClass {
    static  int age = 30;
    String name = "Beni Amin Sk";
    double grade = 0.5;

    InnerClass ic = new InnerClass();


    static void welcomeMessage (String msg) {
        System.out.println(msg);
    }

    void anotherMessage () {
        System.out.println("Either Do or Die!");
    }
    //public modifier is added to the inner class
    public class InnerClass {
        /*Nested non-static class have the access for static and non-static
         *members of its enclosing class*/
        double pi = 3.14;
        double radius = 5.0;

        public double circleArea () {
            return (pi * radius * radius);
        }

        void printMessage () {
            System.out.println("Name is : " + name);
            System.out.println("Age : " + age);
            welcomeMessage("There are many things to do in this life");
            anotherMessage();
        }
    }
    static class StaticNestedClass {
        void printMessage(){
            System.out.println("You are inside static class");
            System.out.println("Your age : " + age);
            /*Non static field 'name' can not be referenced from a static context.
             * Can be accessed the non-static member of it's enclosing class thorugh the object of the
             * enclosing class from a static context.*/
            // System.out.println("Your name : " + name);
            OuterClass outerClass = new OuterClass();
            System.out.println("Your name : " + outerClass.name);
        }
    }
}
public class NetsedClassDemonstration {
    public static void main(String[] args) {
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        System.out.println("Called from Main : " + outerObject.ic.circleArea());
        innerObject.printMessage();

        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        /*As if the static nested class behaves as a top-level class*/
        staticNestedClass.printMessage();
    }
}

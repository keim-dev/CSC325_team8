/* JavaDoc:
    - make 3 interfaces to mimic methods in shape
      - Area
      - Draw
      - Describe
    - implement interfaces in concrete classes

    - make a main class to test all

    write reflection:
      -what worked better
      - what was more reusable
      - which design is more scalable
      - which would you use in future projects and why
      - any ai prompts used
      - general ai use
      - ai critique

*/
package sms_abstract;
public abstract class ShapeAbstract {
    protected String color;
    protected String name;

    public ShapeAbstract(String c, String n) {
        color = c;
        name = n;
    }

    public abstract double area();
    public abstract void draw();
    public abstract void describe();
}

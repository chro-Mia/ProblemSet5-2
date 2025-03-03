public class MonsterTruck extends Truck{
    public MonsterTruck(){
        super();
    }

    public void m1(){
        System.out.print("monster 1");
    }

    public void m2(){
        super.m1();
        super.m2();
    }

    public String toString(){
        return "monster vroomvroom";
    }
}

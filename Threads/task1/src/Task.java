public class Task {
    public static void main(String[] args){
        Car c1 = new Car("Kona",250);
        Car c2 = new Car("Ioniq",220);

        Runnable racer1 = /* TODO
Create a racer with c1 */ new Racer(c1);
        Racer racer2 = /* TODO
Create a Racer with c2*/ new Racer(c2);
      /* TODO:
Create two threads using "new Thread" and pass  one Runnable
to each thread.  It is your job to figure out which are the Runnables.*/
        Thread t1 = new Thread(racer1);
        Thread t2 = new Thread(racer2);

        t1.start();
        t2.start();
    }
}
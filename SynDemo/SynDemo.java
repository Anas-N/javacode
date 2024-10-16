import java.io.*;

class First extends Thread {
    void display(String msg) {
        System.out.print("[" + msg);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("]");
    }
}

class Second extends Thread {
    First ob;
    String str1;

    Second(First obj, String str) {
        ob = obj;
        str1 = str;
        start();
    }

    public void run() {
        synchronized (ob) {
            ob.display(str1);
        }
    }
}

class SynDemo {
    public static void main(String args[]) {
        First f = new First();
        Second s1 = new Second(f, "Ridhu");
        Second s2 = new Second(f, "Midhu");
        Second s3 = new Second(f, "Yedhu");
    }
}
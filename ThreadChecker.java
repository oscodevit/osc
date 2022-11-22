import java.util.*;

class ThreadChecker {

    synchronized public void ballmotion(int n) {

        int speed=0;
        if(n==1) {
            speed = 500;
        } else if(n==2) {
            speed = 750;
        } else if(n == 3) {
            speed = 1000;
        }

        for (int i = 1; i < 5; i++) {

            try {
                Thread.sleep(speed);

            } catch (InterruptedException e) {

                System.out.println(e);
            }

            System.out.println("Ball " + n + " moving forward...");
        }

        System.out.println("Ball " + n + " reached final destination\n");
    }
}

class FirstBall extends Thread {
    ThreadChecker tc = new ThreadChecker();

    FirstBall(ThreadChecker tc1) {
        tc = tc1;
    }

    public void run(){
        tc.ballmotion(1);
    }    
}

class SecondBall extends Thread {
    ThreadChecker tc = new ThreadChecker();

    SecondBall(ThreadChecker tc1) {
        tc = tc1;
    }

    public void run(){
        tc.ballmotion(2);
    }    
}

class ThirdBall extends Thread {
    ThreadChecker tc = new ThreadChecker();

    ThirdBall(ThreadChecker tc1) {
        tc = tc1;
    }

    public void run(){
        tc.ballmotion(3);
    }    
}


class ThreadTest {
    public static void main(String[] args) {
        ThreadChecker tc = new ThreadChecker();

        FirstBall f1 = new FirstBall(tc);
        SecondBall f2 = new SecondBall(tc);
        ThirdBall f3 = new ThirdBall(tc); 

        f1.setPriority(3);
        f2.setPriority(3);
        f3.setPriority(3);

        f1.start();
        f2.start();
        f3.start();
      
    }
}
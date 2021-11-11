import java.awt.*;

public class Main {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(600,600);

        StdDraw.setXscale(-1.0,1.0);
        StdDraw.setYscale(-1.0,1.0);

        pong();
    }



    public static void pong(){
        java.awt.Color ballColor=StdDraw.GREEN,paddleColor=StdDraw.BOOK_RED;
        Ball ball = new Ball();
        Paddle paddle = new Paddle();

        int score=0;
        while (true){
            if (ball.getRy() + ball.getRy() >1.0 - ball.getRadius()) ball.setVy(-ball.getVy());
            if (Math.abs(ball.getRx() + ball.getVx())>1.0-ball.getRadius()) ball.setVx(-ball.getVx());

            if (ball.getRy() + ball.getVy() - ball.getRadius() < Paddle.PaddleY + Paddle.PaddleHeight){
                if (ballHitsPaddle(ball.getRx(),ball.getVx(),paddle.getPaddleX(),Paddle.PaddleWidht)){
                    score++;
                    ball.setVy(-ball.getVy());

                    ball.setVy(ball.getVy() * (1.5 + score/100.0));
                    ball.setVx(ball.getVx()*(1.2+score/100.0));

                }
                else {
                    StdDraw.text(0,0,"Your score is "+score);
                    StdDraw.show();
                    break;
                }
            }

            ball.setRx(ball.getRx()+ball.getVx());
            ball.setRy(ball.getRy()+ball.getVy());

            paddle.setPaddleX(StdDraw.mouseX());

            paddle.setPaddleX(Math.min(1.0-Paddle.PaddleWidht,Math.max( -1 +Paddle.PaddleWidht,paddle.getPaddleX())));
            clear();
            renderBall(ball.getRx(),ball.getRy(),ball.getRadius(),ballColor);
            renderPaddle(paddle.getPaddleX(),Paddle.PaddleWidht,Paddle.PaddleHeight,paddleColor);

            StdDraw.show(50);
        }

    }
    public static boolean ballHitsPaddle(double rx,double vx, double px,double pw){
        return (rx +vx>px-pw) && (rx+vx<px+pw);
    }

    public static void renderBall(double x,double y,double radius,java.awt.Color color){
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x,y,radius);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(x,y,radius);
    }

    public static void renderPaddle(double x,double width,double height,java.awt.Color color){
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x,Paddle.PaddleY,width,height);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(x,Paddle.PaddleY,width,height);
    }


    public static void clear(){
        StdDraw.clear(StdDraw.LIGHT_GRAY);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.square(0,0,1);
    }

}
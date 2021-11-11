import java.awt.*;

public class Paddle {
    private double paddleX;
    public static final double PaddleHeight=.04;
    public static final double PaddleWidht=PaddleHeight*5;
    public static final double PaddleY=-.94;
    Paddle(){paddleX=StdDraw.mouseX();}

    public double getPaddleX() {
        return paddleX;
    }

    public void setPaddleX(double paddleX) {
        this.paddleX = paddleX;
    }
}

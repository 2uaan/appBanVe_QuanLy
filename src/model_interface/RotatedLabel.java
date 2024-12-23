package model_interface;

import javax.swing.*;
import java.awt.*;

public class RotatedLabel extends JLabel {
    private double angle; // Góc xoay (tính bằng radian)

    public RotatedLabel(String text, double angle) {
        super(text);
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Lấy chiều rộng và chiều cao của JLabel
        int width = getWidth();
        int height = getHeight();

        // Tính tọa độ trung tâm của JLabel
        int x = width / 2;
        int y = height / 2;

        // Xoay Graphics2D quanh tâm JLabel
        g2d.rotate(angle, x, y);

        // Vẽ text với góc xoay
        super.paintComponent(g2d);

        // Giải phóng tài nguyên Graphics2D
        g2d.dispose();
    }

    // Đặt góc xoay (tính bằng radian)
    public void setAngle(double angle) {
        this.angle = angle;
        repaint(); // Cập nhật lại giao diện
    }

    public double getAngle() {
        return angle;
    }
}

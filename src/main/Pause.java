package main;

import java.awt.*;

public class Pause {

    int gameWidth;
    int gameHeight;

    GamePanel gp;
    Graphics2D g2;

    Color greyT = new Color(17, 17, 17, 71);

    public Pause(GamePanel gp) {
        this.gp = gp;

        gameWidth = GamePanel.screenWidth;
        gameHeight = GamePanel.screenHeight;
    }

    public void draw(Graphics2D g) {
        this.g2 = g;

        if (gp.gameState == GamePanel.pauseState) {
            String text = "PAUSED";
            int x = getXFontCenter(text);
            int y = GamePanel.screenHeight/2;

            g.setColor(greyT);
            g.fillRect(0,0, gameWidth, gameHeight);

            g2.setFont(new Font(Main.pixelType.getName(), Font.PLAIN, Main.isFullScreen ? 150 : 100));
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);
        }

    }

    public int getXFontCenter(String text) {

        int x;
        int length = 0;

        length = (int)g2.getFontMetrics(new Font(Main.pixelType.getName(), Font.PLAIN, Main.isFullScreen ? 150 : 100)).getStringBounds(text, g2).getWidth();

        x = GamePanel.screenWidth/2 - length/2;

        return x;
    }
}

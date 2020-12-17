package apps.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;

public class BlockPanel extends JPanel implements BlockDisplay{
    private static final int SIZE = 100;
    private Block block;

    //Vamos a usar el método paint para dibujar el panel
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.BLACK);
        int size = Block.MAX * SIZE;
        for (int i = 0; i < size; i+=SIZE) {
            g.drawLine(0, i, size, i);
            g.drawLine(i, 0, i, size);
        }
        
        if(block == null)return;
        g.setColor(Color.red);
        g.fillRect((block.x()-1)*SIZE, (block.MAX-block.y())*SIZE, SIZE, SIZE);
    }

    @Override
    public void display(Block block) {
        this.block = block;
        this.block.register(this);
        repaint();
    }

    @Override
    public Block block() {
        return block;
    }

    @Override
    public void changed() {
        repaint();
    }
    
}

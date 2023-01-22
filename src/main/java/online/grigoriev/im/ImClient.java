package online.grigoriev.im;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.FontUIResource;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class ImClient {

    public static void main(String[] args) {
        FlatJetBrainsMonoFont.install();
        FlatLaf.setPreferredMonospacedFontFamily(FlatJetBrainsMonoFont.FAMILY);
        setUIFont(new FontUIResource(FlatJetBrainsMonoFont.FAMILY, Font.PLAIN, 14));
        FlatMacLightLaf.setup();

        ImClient app = new ImClient();
        app.buildAndDisplayGui();
    }

    private void buildAndDisplayGui() {
        JFrame frame = new JFrame("Test Frame");
        buildContent(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void buildContent(JFrame aFrame) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Hello"));
        JButton ok = new JButton("OK");
        ok.addActionListener(new ShowDialog(aFrame));
        panel.add(ok);
        aFrame.getContentPane().add(panel);
    }

    private static final class ShowDialog implements ActionListener {
        ShowDialog(JFrame aFrame) {
            fFrame = aFrame;
        }

        @Override
        public void actionPerformed(ActionEvent aEvent) {
            JOptionPane.showMessageDialog(fFrame, "This is a dialog");
        }

        private final JFrame fFrame;
    }

    private static void setUIFont(FontUIResource fontUIResource) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontUIResource);
            }
        }
    }
}


package webbrowser;

import javax.swing.JFrame;

/**
 *
 * @author hudson.sales
 */
public class WebBrowser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       FrBrowser browser = new FrBrowser();
       browser.setExtendedState(JFrame.MAXIMIZED_BOTH);
       browser.setVisible(true);
    }
}

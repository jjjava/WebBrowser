package webbrowser.core;

import java.io.IOException;
import javax.swing.JOptionPane;
import webbrowser.FrBrowser;

/**
 *
 * @author hudson.sales
 */
public class CoreFrBrowser implements Runnable {

    private Thread t;
    private FrBrowser view;

    public CoreFrBrowser(FrBrowser view) {
        this.view = view;
        view.setPath("http://localhost");
        ctrURLs("http://localhost");
    }

    public void start() {
        t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    @Override
    public void run() {
        getHome(view.getPath());
    }

    public void getThePage(final String location) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    view.contentsArea.setPage(location);
                    view.url.setText(location);
                    ctrURLs(location);
                } catch (IOException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Error retrieving specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
                }
            }
        }).start();
        System.out.println("GetThePage: " + location);
    }

    public void getHome(String location) {
        System.out.println("GetHome: " + location);

        for (String s : view.urls) {
            System.out.println(s);
        }
        try {
            view.contentsArea.setPage(location);
            view.url.setText(location);
            ctrURLs(location);
        } catch (IOException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error retrieving specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setAdress(final String path) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    view.contentsArea.setPage(path);
                    view.url.setText(path);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }).start();
        System.out.println("SetAdress: " + path);
    }

    private void ctrURLs(String url) {
        view.urls.add(url);
        view.crt++;
    }

    public void go() {
        setAdress(view.url.getText());
    }

    public void backPage() {
        if (view.crt > 0) {
            view.crt--;
        }
        System.out.println("back page: " + view.urls.get(view.crt));
        setAdress(view.urls.get(view.crt));
    }

    public void fowardPage() {
        if (view.crt >= view.urls.size()) {
        } else {
            view.crt++;
        }
        setAdress(view.urls.get(view.crt));
        System.out.println("Forward");
    }

    public void reload() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    view.contentsArea.setPage(view.url.getText());
                } catch (IOException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Error retrieving specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
                }
            }
        }).start();
        System.out.println("Reload");

    }

    public void close() {
        t = null;
        view.dispose();
    }
}
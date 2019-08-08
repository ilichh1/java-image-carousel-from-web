/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecarousel;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ilichh1
 */
public class Utils {
    
    public static ListaLigadaDobleCircular<ImageIcon> urlsArrayToLinkedList(String[] urls) {
        ListaLigadaDobleCircular<ImageIcon> list = new ListaLigadaDobleCircular();
        for (String url : urls) {
            list.insertarAlFinal(imageURLToImageIcon(url));
        }
        return list;
    }
    
    public static ImageIcon imageURLToImageIcon(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (IOException e) {
            return null;
        }
        String fileName = url.getFile();
        return new ImageIcon(url, fileName);
    }
    
    public static void showMessage(String msg, boolean isError) {
        if (isError) {
            JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, msg, "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

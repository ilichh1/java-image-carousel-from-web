/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecarousel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author ilichh1
 */
public class CarouselController {
    private CarouselView view;
    private ArrayList<String> stringUrls = new ArrayList<>();
    private ListaLigadaDobleCircular<ImageIcon> carousel;
    
    public static final String HARDCODED_URLS =
            "https://docs.oracle.com/javase/tutorial/figures/uiswing/components/LabelDemoMetal.png,\n"
            + "http://jarritos.com/wp-content/uploads/2016/07/old-school.jpg,\n"
            + "http://www.alegrofoods.com/images/products/detail/marinelagansitomultiempaque5pza250g.jpg,\n"
            + "https://seeklogo.net/wp-content/uploads/2013/04/marinela-vector-logo-400x400.png,\n"
            + "https://heavyeditorial.files.wordpress.com/2015/09/big-boss-bionic-arm-metal-gear-solid-v-the-phantom-pain-wallpaper-hd-desktop.jpg?quality=65&strip=all&strip=all";

    CarouselController(CarouselView v) {
        view = v;
        onInit();
    }
    
    private void onInit() {
        view.imageLabel.setText(null);
        view.urlsTextArea.setText(HARDCODED_URLS);
        view.downloadButton.addActionListener((ActionEvent e) -> {
            downloadImages();
        });
        view.prevButton.addActionListener((ActionEvent e) -> {
            prev();
        });
        view.nextButton.addActionListener((ActionEvent e) -> {
            next();
        });
    }
    
    private void next() {
        setImage(carousel.getSiguiente());
    }
    
    private void prev() {
        setImage(carousel.getAnterior());
    }
    
    private void downloadImages() {
        convertTextToURLs();
        imageUrlsToLinkedList();
        next();
    }
    
    private void imageUrlsToLinkedList() {
        int length = stringUrls.size();
        carousel = Utils.urlsArrayToLinkedList(stringUrls.toArray(new String[length]));
    }
    
    private void setImage(ImageIcon image) {
        view.imageLabel.setText(null);
        view.imageLabel.setIcon(image);
    }
    
    private void convertTextToURLs() {
        String wholeText = view.urlsTextArea.getText();
        stringUrls.clear();
        stringUrls.addAll(Arrays.asList(wholeText.split(",")));
    }
}

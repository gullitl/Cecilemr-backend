package com.cecilemrbackend.util;

import java.awt.*;

public class CentralizeLocationRelativeToScreen {

    private CentralizeLocationRelativeToScreen() {
        throw new IllegalStateException("Utility class");
    }

    public static double getX(double prefWidth) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        return (dm.width - prefWidth) / 2.0;
    }

    public static double getY(double prefHeight) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        return (dm.height - prefHeight) / 2.0;
    }

}

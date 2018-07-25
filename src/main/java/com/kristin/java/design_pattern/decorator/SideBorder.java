package com.kristin.java.design_pattern.decorator;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/22 13:54
 * @desc
 **/
public class SideBorder extends AbstractBorder {
    private char borderchar;

    public SideBorder(Display display, char ch) {
        super(display);
        this.borderchar = ch;
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderchar + display.getRowText(row) + borderchar;
    }
}

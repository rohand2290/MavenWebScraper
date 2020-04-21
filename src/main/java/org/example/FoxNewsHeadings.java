package org.example;

import java.util.ArrayList;

public class FoxNewsHeadings {


    private ArrayList<String> headings = new ArrayList<String>();

    public ArrayList<String> getHeadings() {
        return headings;
    }


    public void addHeading(String heading) {
        headings.add(heading);
    }

    public void setHeadings(ArrayList<String> headings) {
        this.headings = headings;
    }

}

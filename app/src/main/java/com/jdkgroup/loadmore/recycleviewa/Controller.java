package com.jdkgroup.loadmore.recycleviewa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamlesh on 7/31/2016.
 */
public class Controller {
    public static List<Model> al_loadmore(final int start, final int increment) {
        int total, minus, nextsum;
        total = start + increment;

        final List<Model> al_add = new ArrayList<>();
        List<Model> alsublist;

        al_add.add(new Model("A", "", "", ""));
        al_add.add(new Model("B", "", "", ""));
        al_add.add(new Model("C", "", "", ""));
        al_add.add(new Model("D", "", "", ""));
        al_add.add(new Model("E", "", "", ""));
        al_add.add(new Model("F", "", "", ""));
        al_add.add(new Model("G", "", "", ""));
        al_add.add(new Model("H", "", "", ""));
        al_add.add(new Model("I", "", "", ""));
        al_add.add(new Model("J", "", "", ""));
        al_add.add(new Model("K", "", "", ""));
        al_add.add(new Model("L", "", "", ""));
        al_add.add(new Model("M", "", "", ""));
        al_add.add(new Model("N", "", "", ""));
        al_add.add(new Model("O", "", "", ""));
        al_add.add(new Model("P", "", "", ""));
        al_add.add(new Model("Q", "", "", ""));
        al_add.add(new Model("R", "", "", ""));
        al_add.add(new Model("S", "", "", ""));
        al_add.add(new Model("T", "", "", ""));
        al_add.add(new Model("U", "", "", ""));
        al_add.add(new Model("V", "", "", ""));
        al_add.add(new Model("W", "", "", ""));
        al_add.add(new Model("X", "", "", ""));
        al_add.add(new Model("Y", "", "", ""));
        al_add.add(new Model("Z", "", "", ""));

        if (total < al_add.size()) {
            alsublist = new ArrayList(al_add.subList(start, total));
            return alsublist;
        } else if (start > al_add.size()) {
        } else {
            minus = al_add.size() - start;
            nextsum = start + minus;
            alsublist = new ArrayList(al_add.subList(start, nextsum));
            return alsublist;
        }
        return null;
    }
}

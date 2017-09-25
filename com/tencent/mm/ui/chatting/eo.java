package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class eo {
    private static LinkedList<View> vOH = new LinkedList();
    private static LinkedList<View> vOI = new LinkedList();

    public static View Be(int i) {
        LinkedList linkedList = i == 1 ? vOH : vOI;
        if (linkedList.size() != 0) {
            return (View) linkedList.removeFirst();
        }
        return null;
    }

    public static void J(View view, int i) {
        LinkedList linkedList = i == 1 ? vOH : vOI;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
    }

    public static void clear() {
        vOH.clear();
        vOI.clear();
    }
}

package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.d.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab extends aa {
    private int mType = 0;
    public as mqW;
    public LinkedList<c> mqX;
    private int mqY = 0;

    public ab(a aVar, int i, int i2) {
        if (aVar == null) {
            this.mqW = new as();
            return;
        }
        this.mqW = (as) aVar;
        this.mType = i;
        this.mqY = i2;
        LinkedList linkedList = new LinkedList();
        if (this.mqW.muG != null) {
            int i3 = this.mqY + 1;
            Iterator it = this.mqW.muG.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                c a = aa.a((c) it.next());
                if (a != null) {
                    switch (this.mType) {
                        case 1:
                            a.scene = 16;
                            a.fTL = 1601;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        case 2:
                            a.scene = 15;
                            a.fTL = 1501;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                    linkedList.add(a);
                    i4 = i3;
                }
            }
        }
        this.mqX = linkedList;
        d.U(this.mqX);
    }
}

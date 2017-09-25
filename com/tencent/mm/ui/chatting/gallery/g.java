package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public ArrayList<au> vQg = new ArrayList();
    public boolean vRH = false;
    ArrayList<b> vRI = new ArrayList();

    private static final class a {
        public static final g vRJ = new g();
    }

    public interface b {
        void bWQ();

        void clear();
    }

    public final void bh(au auVar) {
        if (auVar != null) {
            w.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(auVar.field_msgId));
            this.vQg.remove(auVar);
            this.vQg.remove(eR(auVar.field_msgId));
            this.vQg.add(auVar);
            bWR();
        }
    }

    private au eR(long j) {
        Iterator it = this.vQg.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            if (auVar.field_msgId == j) {
                return auVar;
            }
        }
        return null;
    }

    public final void bi(au auVar) {
        if (auVar != null) {
            w.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(auVar.field_msgId));
            this.vQg.remove(auVar);
            this.vQg.remove(eR(auVar.field_msgId));
            bWR();
        }
    }

    public final void clear() {
        w.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.vQg.clear();
        Iterator it = this.vRI.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
    }

    public final void detach() {
        this.vRI.clear();
        clear();
        this.vRH = false;
    }

    public final boolean bj(au auVar) {
        if (auVar == null) {
            return false;
        }
        Iterator it = this.vQg.iterator();
        while (it.hasNext()) {
            if (((au) it.next()).field_msgId == auVar.field_msgId) {
                return true;
            }
        }
        return false;
    }

    private void bWR() {
        Iterator it = this.vRI.iterator();
        while (it.hasNext()) {
            ((b) it.next()).bWQ();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.vRI.remove(bVar);
            this.vRI.add(bVar);
        }
    }
}

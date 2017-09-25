package com.tencent.mm.ah;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class c implements e, f {
    List<b> hEL = new LinkedList();
    private HashSet<b> hEM = new HashSet();
    b hEN = null;
    private j hEO = null;
    public boolean hEP = false;

    public interface a {
        void a(long j, long j2, int i, int i2, Object obj);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar);
    }

    private static class b {
        public long hEQ;
        public long hER;
        public int hES;
        public int hET;
        public List<c> hEU;
        private int hEV = 0;

        public b(long j, long j2, int i) {
            this.hEQ = j;
            this.hER = j2;
            this.hES = i;
            this.hET = 0;
        }

        public final boolean a(a aVar, Object obj) {
            if (this.hEU == null) {
                this.hEU = new LinkedList();
            }
            c cVar = new c(aVar, obj);
            if (this.hEU.contains(cVar)) {
                w.d("ModelImage.DownloadImgService.Task", "task item already exists");
                return false;
            }
            this.hEU.add(cVar);
            return true;
        }

        public final boolean b(a aVar) {
            c cVar = new c(aVar, null);
            if (!this.hEU.contains(cVar)) {
                return false;
            }
            this.hEU.remove(cVar);
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.hEQ == this.hEQ && bVar.hER == this.hER && bVar.hES == this.hES) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.hEV == 0) {
                this.hEV = (this.hEQ + "_" + this.hER + "_" + this.hES).hashCode();
            }
            return this.hEV;
        }
    }

    private static class c {
        public a hEW;
        public Object hEX;

        public c(a aVar, Object obj) {
            this.hEW = aVar;
            this.hEX = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            if (this.hEW == ((c) obj).hEW) {
                return true;
            }
            return false;
        }
    }

    public c() {
        h.vH().gXC.a((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, (e) this);
    }

    public final boolean a(long j, long j2, int i, Object obj, int i2, a aVar) {
        return a(j, j2, i, obj, i2, aVar, -1) >= 0;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3) {
        if (aVar == null) {
            w.e("ModelImage.DownloadImgService", "listener is null");
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.hET = i2;
        if (this.hEM.contains(bVar)) {
            w.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            return -2;
        } else if (this.hEN != null && bVar.equals(this.hEN)) {
            return this.hEN.a(aVar, obj) ? 0 : -3;
        } else {
            int indexOf = this.hEL.indexOf(bVar);
            if (indexOf >= 0 && indexOf < this.hEL.size()) {
                return ((b) this.hEL.get(indexOf)).a(aVar, obj) ? 0 : -4;
            } else {
                w.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ")");
                bVar.a(aVar, obj);
                this.hEL.add(bVar);
                fL(i3);
                return 0;
            }
        }
    }

    public final boolean a(long j, long j2, int i) {
        b bVar = new b(j, j2, i);
        if ((this.hEN == null || !this.hEN.equals(bVar)) && this.hEL.indexOf(bVar) < 0) {
            return false;
        }
        return true;
    }

    public final boolean a(long j, long j2, a aVar) {
        if (aVar == null) {
            w.e("ModelImage.DownloadImgService", "listener is null");
            return false;
        }
        b bVar = new b(j, j2, 1);
        b bVar2 = null;
        if (this.hEN == null || !this.hEN.equals(bVar)) {
            int indexOf = this.hEL.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = (b) this.hEL.get(indexOf);
            }
        } else {
            bVar2 = this.hEN;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            w.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            return true;
        }
        w.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        return false;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            w.e("ModelImage.DownloadImgService", "listener is null");
            return;
        }
        w.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.hEP = true;
        if (this.hEN != null) {
            this.hEN.b(aVar);
            a(this.hEN);
        }
        List<b> linkedList = new LinkedList();
        for (b add : this.hEL) {
            linkedList.add(add);
        }
        for (b add2 : linkedList) {
            add2.b(aVar);
            a(add2);
        }
        Gw();
    }

    private boolean a(b bVar) {
        if (bVar == null || bVar.hEU.size() > 0) {
            return false;
        }
        return b(bVar);
    }

    public final boolean e(long j, long j2) {
        return b(new b(j, j2, 1));
    }

    final boolean b(b bVar) {
        if (bVar == null) {
            w.e("ModelImage.DownloadImgService", "task is null");
            return false;
        }
        w.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.hEQ + ", " + bVar.hER + ", " + bVar.hES + ")");
        if (this.hEN != null && this.hEN.equals(bVar)) {
            h.vH().gXC.c(this.hEO);
            this.hEO = null;
            c(this.hEN);
            this.hEN = null;
            fL(-1);
            return true;
        } else if (!this.hEL.contains(bVar)) {
            return false;
        } else {
            b bVar2 = (b) this.hEL.get(this.hEL.indexOf(bVar));
            if (bVar2 != null) {
                this.hEL.remove(bVar2);
                c(bVar2);
            }
            return true;
        }
    }

    private static void c(b bVar) {
        if (bVar == null) {
            w.e("ModelImage.DownloadImgService", "task is null");
        } else if (bVar.hEU == null) {
            w.e("ModelImage.DownloadImgService", "task callback list is null");
        } else {
            for (c cVar : bVar.hEU) {
                if (cVar.hEW != null) {
                    cVar.hEW.a(bVar.hEQ, bVar.hER, bVar.hES, bVar.hET, cVar.hEX);
                }
            }
        }
    }

    public final void Gw() {
        this.hEP = false;
        fL(-1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hEO != kVar) {
            w.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        this.hEM.add(new b(this.hEN.hEQ, this.hEN.hER, this.hEN.hES));
        w.i("ModelImage.DownloadImgService", "scene end, (" + this.hEN.hEQ + ", " + this.hEN.hER + ", " + this.hEN.hES + ")");
        for (c cVar : this.hEN.hEU) {
            if (cVar.hEW != null) {
                cVar.hEW.a(this.hEN.hEQ, this.hEN.hER, this.hEN.hES, this.hEN.hET, cVar.hEX, i, i2, str, kVar);
            }
        }
        this.hEN = null;
        this.hEO = null;
        fL(-1);
    }

    public final void a(int i, int i2, k kVar) {
        if (this.hEO != kVar) {
            w.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        for (c cVar : this.hEN.hEU) {
            if (cVar.hEW != null) {
                cVar.hEW.a(this.hEN.hEQ, this.hEN.hER, this.hEN.hES, this.hEN.hET, cVar.hEX, i, i2, kVar);
            }
        }
    }

    private void fL(int i) {
        if (this.hEN == null && this.hEL.size() > 0 && true != this.hEP) {
            this.hEN = (b) this.hEL.get(0);
            this.hEL.remove(0);
            this.hEO = new j(this.hEN.hEQ, this.hEN.hER, this.hEN.hES, this, i);
            this.hEO.hGB = this.hEN.hET;
            w.i("ModelImage.DownloadImgService", "do scene, (" + this.hEN.hEQ + ", " + this.hEN.hER + ", " + this.hEN.hES + ")");
            h.vH().gXC.a(this.hEO, 0);
        }
    }
}

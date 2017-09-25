package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.plugin.photoedit.f.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c implements com.tencent.mm.plugin.photoedit.c.c<com.tencent.mm.plugin.photoedit.f.c>, Iterable<com.tencent.mm.plugin.photoedit.f.c> {
    public Stack<com.tencent.mm.plugin.photoedit.f.c> okR;
    private Stack<com.tencent.mm.plugin.photoedit.f.c> okS;

    public final /* synthetic */ Iterator iterator() {
        return aSq();
    }

    public final /* synthetic */ Object pop() {
        return aSn();
    }

    public final void onCreate() {
        w.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.okR = new Stack();
    }

    public final void onDestroy() {
        Iterator it;
        w.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.okR != null) {
            it = this.okR.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.photoedit.f.c) it.next()).clear();
            }
            this.okR.clear();
        }
        if (this.okS != null) {
            it = this.okS.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.photoedit.f.c) it.next()).clear();
            }
            this.okS.clear();
        }
    }

    public final void gf(boolean z) {
        w.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", Integer.valueOf(this.okR.size()), Boolean.valueOf(z));
        if (this.okS != null) {
            this.okS.clear();
        }
        this.okS = new Stack();
        Iterator it = this.okR.iterator();
        while (it.hasNext()) {
            this.okS.push(((com.tencent.mm.plugin.photoedit.f.c) it.next()).aSK());
        }
        w.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", Integer.valueOf(this.okS.size()));
        if (z) {
            this.okR.clear();
            it = this.okS.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.photoedit.f.c cVar = (com.tencent.mm.plugin.photoedit.f.c) it.next();
                w.d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (!(cVar.omi == null || cVar.omi.isRecycled())) {
                    cVar.omi.recycle();
                }
            }
        }
    }

    public final void aSi() {
        w.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", Integer.valueOf(this.okR.size()), Boolean.valueOf(false));
        this.okR.clear();
        if (this.okS != null) {
            w.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", Integer.valueOf(this.okS.size()));
            this.okR.addAll(this.okS);
        }
        w.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", Integer.valueOf(this.okR.size()));
        Iterator it = this.okR.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.plugin.photoedit.f.c) it.next()).aSF();
        }
    }

    public final void a(Canvas canvas, boolean z, Object... objArr) {
        w.i("MicroMsg.EmojiAndTextCache", "[onDrawCache] isOverDraw:%s", Boolean.valueOf(z));
        com.tencent.mm.plugin.photoedit.f.c cVar;
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.okR.iterator();
            while (it.hasNext()) {
                cVar = (com.tencent.mm.plugin.photoedit.f.c) it.next();
                if (!cVar.kuw) {
                    cVar.draw(canvas);
                }
            }
        } else if (objArr != null && objArr.length > 0 && (objArr[0] instanceof com.tencent.mm.plugin.photoedit.f.c)) {
            cVar = (com.tencent.mm.plugin.photoedit.f.c) objArr[0];
            if (!cVar.kuw) {
                cVar.draw(canvas);
            }
        }
    }

    public final void h(Canvas canvas) {
        Iterator it = this.okR.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.photoedit.f.c cVar = (com.tencent.mm.plugin.photoedit.f.c) it.next();
            if (!cVar.kuw) {
                cVar.draw(canvas);
            }
        }
    }

    public final void v(Bitmap bitmap) {
    }

    public final Bitmap aSk() {
        return null;
    }

    public final boolean aSl() {
        return this.okR.size() > 0;
    }

    public final com.tencent.mm.plugin.photoedit.f.c aSn() {
        return (com.tencent.mm.plugin.photoedit.f.c) this.okR.pop();
    }

    public final int gg(boolean z) {
        if (z) {
            if (this.okR != null) {
                return this.okR.size();
            }
            return 0;
        } else if (this.okS != null) {
            return this.okS.size();
        } else {
            return 0;
        }
    }

    public final com.tencent.mm.plugin.photoedit.f.c aSo() {
        if (this.okR == null || this.okR.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.plugin.photoedit.f.c) this.okR.peek();
    }

    public final void a(com.tencent.mm.plugin.photoedit.f.c cVar) {
        if (cVar != null) {
            this.okR.remove(this.okR.indexOf(cVar));
            this.okR.push(cVar);
        }
    }

    public final void b(com.tencent.mm.plugin.photoedit.f.c cVar) {
        if (this.okR != null) {
            this.okR.push(cVar);
        }
    }

    public final int[] aSp() {
        int[] iArr = new int[2];
        if (this.okS != null) {
            Iterator it = this.okS.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.plugin.photoedit.f.c) it.next()) instanceof e) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        return iArr;
    }

    public final ListIterator<com.tencent.mm.plugin.photoedit.f.c> aSq() {
        return this.okR.listIterator(this.okR.size());
    }
}

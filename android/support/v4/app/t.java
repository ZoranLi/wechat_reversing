package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import android.support.v4.content.c.b;
import android.support.v4.e.j;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public final class t extends s {
    public static boolean DEBUG = false;
    boolean ny;
    final String oV;
    public k ph;
    boolean pp;
    final j<a> ru = new j();
    final j<a> rv = new j();
    boolean rw;

    final class a implements android.support.v4.content.c.a<Object>, b<Object> {
        final int dX;
        Object mData;
        boolean ny;
        boolean pp;
        boolean qx;
        boolean rA;
        boolean rB;
        boolean rC;
        boolean rD;
        boolean rE;
        a rF;
        final /* synthetic */ t rG;
        final Bundle rx;
        android.support.v4.app.s.a<Object> ry;
        c<Object> rz;

        public a(t tVar, int i, Bundle bundle, android.support.v4.app.s.a<Object> aVar) {
            this.rG = tVar;
            this.dX = i;
            this.rx = bundle;
            this.ry = aVar;
        }

        final void start() {
            if (this.pp && this.rC) {
                this.ny = true;
            } else if (!this.ny) {
                this.ny = true;
                if (t.DEBUG) {
                    new StringBuilder("  Starting: ").append(this);
                }
                if (this.rz == null && this.ry != null) {
                    this.rz = this.ry.K(this.dX);
                }
                if (this.rz == null) {
                    return;
                }
                if (!this.rz.getClass().isMemberClass() || Modifier.isStatic(this.rz.getClass().getModifiers())) {
                    c cVar;
                    if (!this.rE) {
                        cVar = this.rz;
                        int i = this.dX;
                        if (cVar.ts != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.ts = this;
                        cVar.dX = i;
                        cVar = this.rz;
                        if (cVar.tt != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.tt = this;
                        this.rE = true;
                    }
                    cVar = this.rz;
                    cVar.ny = true;
                    cVar.tv = false;
                    cVar.tu = false;
                    cVar.onStartLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.rz);
            }
        }

        final void stop() {
            if (t.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.ny = false;
            if (!this.pp && this.rz != null && this.rE) {
                this.rE = false;
                this.rz.a((b) this);
                this.rz.a((android.support.v4.content.c.a) this);
                c cVar = this.rz;
                cVar.ny = false;
                cVar.onStopLoading();
            }
        }

        final void destroy() {
            while (true) {
                android.support.v4.content.c.a aVar;
                if (t.DEBUG) {
                    new StringBuilder("  Destroying: ").append(aVar);
                }
                aVar.qx = true;
                boolean z = aVar.rB;
                aVar.rB = false;
                if (aVar.ry != null && aVar.rz != null && aVar.rA && z) {
                    String str;
                    if (t.DEBUG) {
                        new StringBuilder("  Reseting: ").append(aVar);
                    }
                    if (aVar.rG.ph != null) {
                        str = aVar.rG.ph.pg.qy;
                        aVar.rG.ph.pg.qy = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    if (aVar.rG.ph != null) {
                        aVar.rG.ph.pg.qy = str;
                    }
                }
                aVar.ry = null;
                aVar.mData = null;
                aVar.rA = false;
                if (aVar.rz != null) {
                    if (aVar.rE) {
                        aVar.rE = false;
                        aVar.rz.a((b) aVar);
                        aVar.rz.a(aVar);
                    }
                    c cVar = aVar.rz;
                    cVar.onReset();
                    cVar.tv = true;
                    cVar.ny = false;
                    cVar.tu = false;
                    cVar.tw = false;
                    cVar.tx = false;
                }
                if (aVar.rF != null) {
                    aVar = aVar.rF;
                } else {
                    return;
                }
            }
        }

        public final void b(c<Object> cVar, Object obj) {
            if (t.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (!this.qx && this.rG.ru.get(this.dX) == this) {
                a aVar = this.rF;
                if (aVar != null) {
                    if (t.DEBUG) {
                        new StringBuilder("  Switching to pending loader: ").append(aVar);
                    }
                    this.rF = null;
                    this.rG.ru.put(this.dX, null);
                    destroy();
                    this.rG.a(aVar);
                    return;
                }
                if (!(this.mData == obj && this.rA)) {
                    this.mData = obj;
                    this.rA = true;
                    if (this.ny) {
                        c(cVar, obj);
                    }
                }
                aVar = (a) this.rG.rv.get(this.dX);
                if (!(aVar == null || aVar == this)) {
                    aVar.rB = false;
                    aVar.destroy();
                    this.rG.rv.remove(this.dX);
                }
                if (this.rG.ph != null && !this.rG.bc()) {
                    this.rG.ph.pg.aX();
                }
            }
        }

        final void c(c<Object> cVar, Object obj) {
            String str;
            if (this.ry != null) {
                if (this.rG.ph != null) {
                    String str2 = this.rG.ph.pg.qy;
                    this.rG.ph.pg.qy = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (t.DEBUG) {
                        StringBuilder append = new StringBuilder("  onLoadFinished in ").append(cVar).append(": ");
                        StringBuilder stringBuilder = new StringBuilder(64);
                        android.support.v4.e.c.a(obj, stringBuilder);
                        stringBuilder.append("}");
                        append.append(stringBuilder.toString());
                    }
                    this.ry.a(cVar, obj);
                    this.rB = true;
                } finally {
                    if (this.rG.ph != null) {
                        this.rG.ph.pg.qy = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.dX);
            stringBuilder.append(" : ");
            android.support.v4.e.c.a(this.rz, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.dX);
                printWriter.print(" mArgs=");
                printWriter.println(this.rx);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.ry);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.rz);
                if (this.rz != null) {
                    this.rz.dump(str + "  ", fileDescriptor, printWriter, strArr);
                }
                if (this.rA || this.rB) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.rA);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.rB);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.ny);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.rD);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.qx);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.pp);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.rC);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.rE);
                if (this.rF != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.rF);
                    printWriter.println(":");
                    this = this.rF;
                    str = str + "  ";
                } else {
                    return;
                }
            }
        }
    }

    t(String str, k kVar, boolean z) {
        this.oV = str;
        this.ph = kVar;
        this.ny = z;
    }

    private a a(int i, Bundle bundle, android.support.v4.app.s.a<Object> aVar) {
        a aVar2 = new a(this, i, bundle, aVar);
        aVar2.rz = aVar.K(i);
        return aVar2;
    }

    private a b(int i, Bundle bundle, android.support.v4.app.s.a<Object> aVar) {
        try {
            this.rw = true;
            a a = a(i, null, aVar);
            a(a);
            return a;
        } finally {
            this.rw = false;
        }
    }

    final void a(a aVar) {
        this.ru.put(aVar.dX, aVar);
        if (this.ny) {
            aVar.start();
        }
    }

    public final <D> c<D> a(int i, android.support.v4.app.s.a<D> aVar) {
        if (this.rw) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.ru.get(i);
        if (DEBUG) {
            new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 == null) {
            aVar2 = b(i, null, aVar);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(aVar2);
            }
        } else {
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            aVar2.ry = aVar;
        }
        if (aVar2.rA && this.ny) {
            aVar2.c(aVar2.rz, aVar2.mData);
        }
        return aVar2.rz;
    }

    public final <D> c<D> b(int i, android.support.v4.app.s.a<D> aVar) {
        if (this.rw) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.ru.get(i);
        if (DEBUG) {
            new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 != null) {
            a aVar3 = (a) this.rv.get(i);
            if (aVar3 != null) {
                if (aVar2.rA) {
                    if (DEBUG) {
                        new StringBuilder("  Removing last inactive loader: ").append(aVar2);
                    }
                    aVar3.rB = false;
                    aVar3.destroy();
                } else if (aVar2.ny) {
                    if (DEBUG) {
                        new StringBuilder("  Canceling: ").append(aVar2);
                    }
                    if (aVar2.ny && aVar2.rz != null && aVar2.rE) {
                        if (DEBUG) {
                            new StringBuilder("onLoadCanceled: ").append(aVar2);
                        }
                        if (!aVar2.qx && aVar2.rG.ru.get(aVar2.dX) == aVar2) {
                            aVar3 = aVar2.rF;
                            if (aVar3 != null) {
                                if (DEBUG) {
                                    new StringBuilder("  Switching to pending loader: ").append(aVar3);
                                }
                                aVar2.rF = null;
                                aVar2.rG.ru.put(aVar2.dX, null);
                                aVar2.destroy();
                                aVar2.rG.a(aVar3);
                            }
                        }
                    }
                    if (aVar2.rF != null) {
                        if (DEBUG) {
                            new StringBuilder("  Removing pending loader: ").append(aVar2.rF);
                        }
                        aVar2.rF.destroy();
                        aVar2.rF = null;
                    }
                    aVar2.rF = a(i, null, aVar);
                    return aVar2.rF.rz;
                } else {
                    this.ru.put(i, null);
                    aVar2.destroy();
                }
            } else if (DEBUG) {
                new StringBuilder("  Making last loader inactive: ").append(aVar2);
            }
            aVar2.rz.tu = true;
            this.rv.put(i, aVar2);
        }
        return b(i, null, aVar).rz;
    }

    public final void destroyLoader(int i) {
        if (this.rw) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            new StringBuilder("destroyLoader in ").append(this).append(" of ").append(i);
        }
        int indexOfKey = this.ru.indexOfKey(i);
        if (indexOfKey >= 0) {
            a aVar = (a) this.ru.valueAt(indexOfKey);
            this.ru.removeAt(indexOfKey);
            aVar.destroy();
        }
        indexOfKey = this.rv.indexOfKey(i);
        if (indexOfKey >= 0) {
            aVar = (a) this.rv.valueAt(indexOfKey);
            this.rv.removeAt(indexOfKey);
            aVar.destroy();
        }
        if (this.ph != null && !bc()) {
            this.ph.pg.aX();
        }
    }

    public final <D> c<D> J(int i) {
        if (this.rw) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar = (a) this.ru.get(i);
        if (aVar == null) {
            return null;
        }
        if (aVar.rF != null) {
            return aVar.rF.rz;
        }
        return aVar.rz;
    }

    final void bd() {
        if (DEBUG) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.ny) {
            new RuntimeException("here").fillInStackTrace();
            new StringBuilder("Called doStart when already started: ").append(this);
            return;
        }
        this.ny = true;
        for (int size = this.ru.size() - 1; size >= 0; size--) {
            ((a) this.ru.valueAt(size)).start();
        }
    }

    final void be() {
        if (DEBUG) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.ny) {
            for (int size = this.ru.size() - 1; size >= 0; size--) {
                ((a) this.ru.valueAt(size)).stop();
            }
            this.ny = false;
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doStop when not started: ").append(this);
    }

    final void bf() {
        if (DEBUG) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.ny) {
            this.pp = true;
            this.ny = false;
            for (int size = this.ru.size() - 1; size >= 0; size--) {
                a aVar = (a) this.ru.valueAt(size);
                if (DEBUG) {
                    new StringBuilder("  Retaining: ").append(aVar);
                }
                aVar.pp = true;
                aVar.rC = aVar.ny;
                aVar.ny = false;
                aVar.ry = null;
            }
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doRetain when not started: ").append(this);
    }

    final void bg() {
        for (int size = this.ru.size() - 1; size >= 0; size--) {
            ((a) this.ru.valueAt(size)).rD = true;
        }
    }

    final void bh() {
        for (int size = this.ru.size() - 1; size >= 0; size--) {
            a aVar = (a) this.ru.valueAt(size);
            if (aVar.ny && aVar.rD) {
                aVar.rD = false;
                if (aVar.rA) {
                    aVar.c(aVar.rz, aVar.mData);
                }
            }
        }
    }

    final void bi() {
        int size;
        if (!this.pp) {
            if (DEBUG) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (size = this.ru.size() - 1; size >= 0; size--) {
                ((a) this.ru.valueAt(size)).destroy();
            }
            this.ru.clear();
        }
        if (DEBUG) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (size = this.rv.size() - 1; size >= 0; size--) {
            ((a) this.rv.valueAt(size)).destroy();
        }
        this.rv.clear();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        android.support.v4.e.c.a(this.ph, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.ru.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.ru.size(); i2++) {
                a aVar = (a) this.ru.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ru.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.rv.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.rv.size()) {
                aVar = (a) this.rv.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.rv.keyAt(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean bc() {
        int size = this.ru.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            int i2;
            a aVar = (a) this.ru.valueAt(i);
            if (!aVar.ny || aVar.rB) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}

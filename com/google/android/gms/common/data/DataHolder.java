package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final g CREATOR = new g();
    private static final a aoM = new a(new String[0]) {
    };
    public final int alZ;
    final String[] aoE;
    Bundle aoF;
    final CursorWindow[] aoG;
    final Bundle aoH;
    int[] aoI;
    int aoJ;
    Object aoK;
    private boolean aoL;
    boolean mClosed;
    final int mVersionCode;

    public static class a {
        public final String[] aoE;
        public final ArrayList<HashMap<String, Object>> aoN = new ArrayList();
        private final String aoO = null;
        private final HashMap<Object, Integer> aoP = new HashMap();
        private boolean aoQ = false;
        private String aoR = null;

        public a(String[] strArr, String str) {
            this.aoE = (String[]) w.Z(strArr);
        }
    }

    public static class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.aoL = true;
        this.mVersionCode = i;
        this.aoE = strArr;
        this.aoG = cursorWindowArr;
        this.alZ = i2;
        this.aoH = bundle;
    }

    private DataHolder(a aVar, int i, Bundle bundle) {
        this(aVar.aoE, a(aVar), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.aoL = true;
        this.mVersionCode = 1;
        this.aoE = (String[]) w.Z(strArr);
        this.aoG = (CursorWindow[]) w.Z(cursorWindowArr);
        this.alZ = i;
        this.aoH = bundle;
        jN();
    }

    private static CursorWindow[] a(a aVar) {
        int i = 0;
        if (aVar.aoE.length == 0) {
            return new CursorWindow[0];
        }
        List list = aVar.aoN;
        int size = list.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.aoE.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            try {
                int i4;
                int i5;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    new StringBuilder("Allocating additional cursor window for large data set (row ").append(i2).append(")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(aVar.aoE.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) list.get(i2);
                boolean z = true;
                for (int i6 = 0; i6 < aVar.aoE.length && z; i6++) {
                    String str = aVar.aoE[i6];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i2, i6);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i2, i6);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i2, i6);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i2, i6);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i2, i6);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i2, i6);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i2, i6);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i2, i6);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i4 = i2;
                    i5 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i3 != 0) {
                    throw new b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    new StringBuilder("Couldn't populate window data for row ").append(i2).append(" - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i2);
                    cursorWindow3.setNumColumns(aVar.aoE.length);
                    arrayList.add(cursorWindow3);
                    i4 = i2 - 1;
                    cursorWindow2 = cursorWindow3;
                    i5 = 1;
                }
                i3 = i5;
                cursorWindow = cursorWindow2;
                i2 = i4 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                i2 = arrayList.size();
                while (i < i2) {
                    ((CursorWindow) arrayList.get(i)).close();
                    i++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder bW(int i) {
        return new DataHolder(aoM, i, null);
    }

    private boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final String b(String str, int i, int i2) {
        f(str, i);
        return this.aoG[i2].getString(i, this.aoF.getInt(str));
    }

    public final int bV(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.aoJ;
        w.ac(z);
        while (i2 < this.aoI.length) {
            if (i < this.aoI[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.aoI.length ? i2 - 1 : i2;
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.aoG) {
                    close.close();
                }
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    final void f(String str, int i) {
        if (this.aoF == null || !this.aoF.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.aoJ) {
            throw new CursorIndexOutOfBoundsException(i, this.aoJ);
        }
    }

    protected final void finalize() {
        try {
            if (this.aoL && this.aoG.length > 0 && !isClosed()) {
                new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(this.aoK == null ? "internal object: " + toString() : this.aoK.toString()).append(")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void jN() {
        int i;
        int i2 = 0;
        this.aoF = new Bundle();
        for (i = 0; i < this.aoE.length; i++) {
            this.aoF.putInt(this.aoE[i], i);
        }
        this.aoI = new int[this.aoG.length];
        i = 0;
        while (i2 < this.aoG.length) {
            this.aoI[i2] = i;
            i += this.aoG[i2].getNumRows() - (i - this.aoG[i2].getStartPosition());
            i2++;
        }
        this.aoJ = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}

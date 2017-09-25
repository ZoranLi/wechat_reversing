package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class t extends m implements c<Object, Object> {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private long hWY;
    private g hnH;
    private at<Object, Object> uza;
    private at<Object, Object> uzb;
    private BlockingQueue<Integer> uzc = new LinkedBlockingQueue();
    private BlockingQueue<String> uzd = new LinkedBlockingQueue();

    static class a {
        public String hnS = null;
        public int type = -1;

        a() {
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.hnS != null) {
                return this.hnS.equals(aVar.hnS);
            }
            if (aVar.hnS == null) {
                return true;
            }
            return false;
        }
    }

    public t(g gVar) {
        this.hnH = gVar;
        this.uza = new at(this, h.vL().nJF.getLooper(), 100, 20, 60000, 100);
        this.uza.setTag(Integer.valueOf(1));
        this.uzb = new at(this, h.vL().nJF.getLooper(), 100, 20, 60000, 100);
        this.uzb.setTag(Integer.valueOf(3));
    }

    public final Object get(int i, Object obj) {
        Assert.assertTrue("db is null", this.hnH != null);
        Object obj2 = this.uza.get(Integer.valueOf(i));
        if (obj2 == null && !this.uzc.contains(Integer.valueOf(i))) {
            a aVar = new a();
            Cursor a = this.hnH.a("userinfo", null, "id=" + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar.type = a.getInt(1);
                aVar.hnS = a.getString(2);
            }
            a.close();
            obj2 = i(aVar.type, aVar.hnS);
            this.uza.q(Integer.valueOf(i), aVar);
            if (obj2 == null) {
                return obj;
            }
        } else if (obj2 instanceof a) {
            a aVar2 = (a) obj2;
            obj2 = i(aVar2.type, aVar2.hnS);
            if (obj2 == null) {
                return obj;
            }
        }
        return obj2;
    }

    public final Object get(com.tencent.mm.storage.w.a aVar, Object obj) {
        if (aVar == null) {
            return obj;
        }
        String name = aVar.name();
        if (bg.mA(name)) {
            return obj;
        }
        String str;
        String[] split = name.split("_");
        String str2 = split[split.length - 1];
        if (str2.equals("SYNC")) {
            str = split[split.length - 2];
        } else {
            str = str2;
        }
        String substring = name.substring(0, name.lastIndexOf(str) + str.length());
        Assert.assertTrue("db is null", this.hnH != null);
        Object obj2 = this.uzb.get(substring);
        if (obj2 == null && !this.uzd.contains(substring)) {
            a aVar2 = new a();
            Cursor a = this.hnH.a("userinfo2", null, "sid=?", new String[]{substring}, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar2.type = a.getInt(1);
                aVar2.hnS = a.getString(2);
            }
            a.close();
            obj2 = i(aVar2.type, aVar2.hnS);
            this.uzb.q(substring, aVar2);
            if (obj2 == null) {
                obj2 = obj;
            }
        } else if (obj2 instanceof a) {
            a aVar3 = (a) obj2;
            obj2 = i(aVar3.type, aVar3.hnS);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
        if (a(str, obj2, false)) {
            return obj2;
        }
        return obj;
    }

    public final boolean c(com.tencent.mm.storage.w.a aVar, boolean z) {
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            return z;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void set(int i, Object obj) {
        boolean q;
        Assert.assertTrue("db is null", this.hnH != null);
        if (obj == null) {
            q = this.uza.q(Integer.valueOf(i), null);
            if (q && !this.uzc.contains(Integer.valueOf(i))) {
                this.uzc.add(Integer.valueOf(i));
            }
        } else {
            a aVar = new a();
            aVar.type = bz(obj);
            if (aVar.type != -1) {
                aVar.hnS = obj.toString();
                q = this.uza.q(Integer.valueOf(i), aVar);
                if (q && this.uzc.contains(Integer.valueOf(i))) {
                    this.uzc.remove(Integer.valueOf(i));
                }
            } else {
                return;
            }
        }
        if (q) {
            b(obj == null ? 5 : 4, this, Integer.valueOf(i));
        }
    }

    public final void a(com.tencent.mm.storage.w.a aVar, Object obj) {
        if (aVar != null) {
            String name = aVar.name();
            if (!bg.mA(name)) {
                boolean z;
                String[] split = name.split("_");
                String str = split[split.length - 1];
                if (str.equals("SYNC")) {
                    str = split[split.length - 2];
                    z = true;
                } else {
                    z = false;
                }
                if (a(str, obj, true)) {
                    boolean q;
                    String substring = name.substring(0, str.length() + name.lastIndexOf(str));
                    if (obj == null) {
                        q = this.uzb.q(substring, null);
                        if (q && !this.uzd.contains(substring)) {
                            this.uzd.add(substring);
                        }
                    } else {
                        a aVar2 = new a();
                        aVar2.type = bz(obj);
                        if (aVar2.type != -1) {
                            aVar2.hnS = obj.toString();
                            q = this.uzb.q(substring, aVar2);
                            if (q && this.uzd.contains(substring)) {
                                this.uzd.remove(substring);
                            }
                        } else {
                            return;
                        }
                    }
                    if (q) {
                        b(obj == null ? 5 : 4, this, aVar);
                    }
                    if (z) {
                        jY(true);
                    }
                }
            }
        }
    }

    private static boolean a(String str, Object obj, boolean z) {
        if (obj == null && z) {
            return true;
        }
        if (str.equals("INT") && (obj instanceof Integer)) {
            return true;
        }
        if (str.equals("LONG") && (obj instanceof Long)) {
            return true;
        }
        if (str.equals("STRING") && (obj instanceof String)) {
            return true;
        }
        if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            return true;
        }
        if (str.equals("FLOAT") && (obj instanceof Float)) {
            return true;
        }
        if (str.equals("DOUBLE") && (obj instanceof Double)) {
            return true;
        }
        if (obj != null && b.bIu()) {
            Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
        }
        if (z) {
            w.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
        }
        return false;
    }

    private static int bz(Object obj) {
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof String) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 5;
        }
        if (obj instanceof Double) {
            return 6;
        }
        w.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
        return -1;
    }

    private static Object i(int i, String str) {
        switch (i) {
            case 1:
                try {
                    return Integer.valueOf(str);
                } catch (Throwable e) {
                    w.e("MicroMsg.ConfigStorage", "exception:%s", bg.g(e));
                    break;
                }
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                return Double.valueOf(str);
        }
        return null;
    }

    protected final boolean Fc() {
        if (this.hnH != null && !this.hnH.bKn()) {
            return true;
        }
        String str = "MicroMsg.ConfigStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hnH == null ? "null" : Boolean.valueOf(this.hnH.bKn());
        w.w(str, str2, objArr);
        return false;
    }

    public final boolean Kc() {
        if (this.hnH.inTransaction()) {
            w.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
            return false;
        }
        this.hWY = this.hnH.cs(Thread.currentThread().getId());
        if (this.hWY > 0) {
            return true;
        }
        w.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.hWY + " return false");
        return false;
    }

    public final void a(at<Object, Object> atVar, at.b<Object, Object> bVar) {
        Object obj = bVar.sWq;
        Object obj2 = bVar.values;
        int i = bVar.uvg;
        ContentValues contentValues;
        switch (((Integer) atVar.getTag()).intValue()) {
            case 1:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar = (a) obj2;
                        if (aVar.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, (Integer) bVar.sWq);
                            contentValues.put(Columns.TYPE, Integer.valueOf(aVar.type));
                            contentValues.put(Columns.VALUE, aVar.hnS.toString());
                            this.hnH.replace("userinfo", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.hnH.delete("userinfo", "id=" + obj, null);
                    return;
                } else {
                    return;
                }
            case 3:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar2 = (a) obj2;
                        if (aVar2.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("sid", (String) bVar.sWq);
                            contentValues.put(Columns.TYPE, Integer.valueOf(aVar2.type));
                            contentValues.put(Columns.VALUE, aVar2.hnS.toString());
                            this.hnH.replace("userinfo2", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.hnH.delete("userinfo2", "sid=" + obj, null);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void Kd() {
        if (this.hWY > 0) {
            this.hnH.aD(this.hWY);
        }
    }

    public final void jY(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.uza.jV(z);
        this.uzb.jV(z);
        w.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk force[%b] end takes[%d]ms ", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final int getInt(int i, int i2) {
        Integer num = (Integer) get(i, null);
        return num == null ? i2 : num.intValue();
    }

    public final void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public final long yB(int i) {
        Long l = (Long) get(i, null);
        return l == null ? 0 : l.longValue();
    }
}

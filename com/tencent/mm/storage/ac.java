package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.re;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ac extends i<z> implements com.tencent.mm.bj.f.a {
    public static final String[] gUx = new String[]{i.a(z.gTP, "ContactLabel")};
    private e gUz;
    private HashMap<String, int[]> uIH;
    public HashMap<Integer, ArrayList<String>> uII;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] uIJ = new int[a.bLp().length];

        static {
            try {
                uIJ[a.uIK - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                uIJ[a.uIL - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                uIJ[a.uIM - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bLp() {
            return (int[]) uIN.clone();
        }

        static {
            uIK = 1;
            uIL = 2;
            uIM = 3;
            uIN = new int[]{uIK, uIL, uIM};
        }
    }

    public final /* synthetic */ boolean a(c cVar) {
        z zVar = (z) cVar;
        boolean a = super.a(zVar);
        if (a) {
            Qr(a("replace", zVar));
        }
        aFA();
        return a;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a(true, (z) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b(true, (z) cVar, strArr);
    }

    public ac(e eVar) {
        this(eVar, z.gTP, "ContactLabel");
    }

    private ac(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.uIH = null;
        this.uII = null;
        this.gUz = eVar;
        eVar.eE("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final ArrayList<String> bLl() {
        ArrayList<String> arrayList = null;
        long Nz = bg.Nz();
        Cursor a = this.gUz.a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            w.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[]{Long.valueOf(bg.aA(Nz)), Integer.valueOf(arrayList.size()), bg.bJZ()});
        }
        return arrayList;
    }

    public final ArrayList<z> bLm() {
        ArrayList<z> arrayList = null;
        long Nz = bg.Nz();
        Cursor a = this.gUz.a("select * from ContactLabel order by createTime ASC ", null, 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                z zVar = new z();
                zVar.b(a);
                arrayList.add(zVar);
            }
            a.close();
            w.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[]{Long.valueOf(bg.aA(Nz)), Integer.valueOf(arrayList.size()), bg.bJZ()});
        }
        return arrayList;
    }

    public final void aFA() {
        w.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[]{bg.bJZ()});
        this.uIH = null;
        this.uII = null;
    }

    public final void bLn() {
        if (this.uIH == null || this.uII == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long Nz = bg.Nz();
            Cursor a = this.gUz.a("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.j.a.tt() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (a == null) {
                this.uIH = hashMap;
                this.uII = hashMap2;
                return;
            }
            while (a.moveToNext()) {
                String string = a.getString(0);
                if (!bg.mA(string)) {
                    String[] split = bg.mz(a.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        Object obj = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            obj[i] = bg.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(obj[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(obj[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(obj[i]), arrayList);
                            }
                        }
                        hashMap.put(string, obj);
                    }
                }
            }
            a.close();
            w.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[]{Long.valueOf(bg.aA(Nz)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), bg.bJZ()});
            this.uIH = hashMap;
            this.uII = hashMap2;
        }
    }

    public final ArrayList<String> QS(String str) {
        int i = -1;
        long Nz = bg.Nz();
        int i2 = bg.getInt(str, -1);
        if (i2 == -1) {
            w.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[]{str});
            return null;
        }
        bLn();
        ArrayList<String> arrayList = (ArrayList) this.uII.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bg.aA(Nz));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bg.bJZ();
        w.i(str2, str3, objArr);
        return arrayList;
    }

    public final ArrayList<String> l(String str, List<String> list) {
        Cursor a;
        Exception e;
        Throwable th;
        w.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC "});
        try {
            a = this.gUz.a("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
            try {
                int columnIndex = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        String string = a.getString(columnIndex);
                        if (list == null || list.size() <= 0 || !list.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (a.moveToNext());
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    w.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", new Object[]{e.toString()});
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> E(String[] strArr) {
        Cursor a;
        Exception e;
        Throwable th;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'" + strArr[i] + "'");
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", new Object[]{stringBuilder.toString()});
        try {
            a = this.gUz.a(stringBuilder.toString(), null, 2);
            try {
                length = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(a.getString(length));
                    } while (a.moveToNext());
                    w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", new Object[]{Integer.valueOf(arrayList.size())});
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", new Object[]{e.toString()});
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> af(ArrayList<String> arrayList) {
        Exception e;
        Throwable th;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i)) + "\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor a;
        try {
            a = this.gUz.a(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = a.getColumnIndex("labelID");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(a.getString(columnIndex));
                    } while (a.moveToNext());
                    w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                    if (a == null) {
                        return arrayList2;
                    }
                    a.close();
                    return arrayList2;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", new Object[]{e.toString()});
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private boolean a(boolean z, z zVar) {
        boolean b = super.b(zVar);
        if (b && z) {
            Qr(a("insert", zVar));
        }
        return b;
    }

    public final boolean gR(String str) {
        int delete;
        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[]{str});
        w.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"labelID =? "});
        try {
            delete = this.gUz.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[]{e.toString()});
            delete = -1;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public boolean a(boolean z, z zVar, String... strArr) {
        boolean a = super.a(zVar, strArr);
        if (a && z) {
            Qr(a("delete", zVar));
            bLo();
        }
        aFA();
        return a;
    }

    public boolean b(boolean z, z zVar, String... strArr) {
        boolean c = super.c(zVar, strArr);
        if (c && z) {
            Qr(a("update", zVar));
        }
        aFA();
        return c;
    }

    public final boolean bY(List<z> list) {
        if (list.size() <= 0) {
            w.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
        } else {
            long cs;
            g gVar;
            if (this.gUz instanceof g) {
                g gVar2 = (g) this.gUz;
                cs = gVar2.cs(Thread.currentThread().getId());
                w.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(cs)});
                gVar = gVar2;
            } else {
                gVar = null;
                cs = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((z) list.get(i));
                if (!bg.mA(c)) {
                    gR(c);
                }
            }
            if (gVar != null) {
                gVar.aD(cs);
                w.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            aFA();
        }
        return false;
    }

    public final boolean bZ(List<z> list) {
        if (list.size() <= 0) {
            w.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            return false;
        }
        long cs;
        g gVar;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(cs)});
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                switch (AnonymousClass1.uIJ[b(zVar) - 1]) {
                    case 1:
                        break;
                    case 2:
                        b(false, zVar, "labelID");
                        arrayList2.add(zVar);
                        break;
                    case 3:
                        zVar.field_createTime = System.currentTimeMillis();
                        a(false, zVar);
                        arrayList.add(zVar);
                        break;
                    default:
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                        break;
                }
            }
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        if (arrayList.size() > 0) {
            Qr(m("insert", arrayList));
        }
        if (arrayList2.size() > 0) {
            Qr(m("update", arrayList2));
        }
        aFA();
        return false;
    }

    public final String zd(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.gUz.a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelName"));
                        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", new Object[]{string});
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final String ze(String str) {
        Cursor a;
        Exception e;
        Throwable th;
        try {
            a = this.gUz.a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelID"));
                        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", new Object[]{string});
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final z QT(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.gUz.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public final z QU(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.gUz.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private int b(z zVar) {
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select * from ContactLabel where labelID=?", new String[]{zVar.field_labelID}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return a.uIM;
            }
            int i;
            if (zVar.field_labelName.equalsIgnoreCase(bg.ap(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                i = a.uIK;
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            i = a.uIL;
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String c(z zVar) {
        Cursor a;
        Exception e;
        Throwable th;
        String str = null;
        try {
            a = this.gUz.a("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{zVar.field_labelName, "1"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        boolean equalsIgnoreCase = zVar.field_labelName.equalsIgnoreCase(bg.ap(a.getString(a.getColumnIndex("labelName")), ""));
                        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", new Object[]{zVar.field_labelName, r1});
                        if (equalsIgnoreCase) {
                            str = a.getString(a.getColumnIndex("labelID"));
                            if (a != null) {
                                a.close();
                            }
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return str;
        } catch (Throwable th3) {
            a = null;
            th = th3;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return str;
    }

    private static String a(String str, z zVar) {
        if (zVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(zVar);
        return m(str, arrayList);
    }

    private static String m(String str, List<z> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                stringBuilder.append(zVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    private static void bLo() {
        w.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        b reVar = new re();
        reVar.fYh.fYi = 3000;
        com.tencent.mm.sdk.b.a.urY.m(reVar);
    }

    public final boolean ca(List<z> list) {
        if (list == null || list.size() <= 0) {
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            return false;
        }
        long cs;
        g gVar;
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[]{Long.valueOf(cs)});
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (z) list.get(i), "labelID");
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        Qr(m("delete", list));
        bLo();
        return true;
    }

    public final ArrayList<z> cb(List<z> list) {
        Exception e;
        Throwable th;
        if (list.size() <= 0) {
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((z) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor a;
        try {
            a = this.gUz.a(stringBuilder.toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    ArrayList<z> arrayList = new ArrayList();
                    do {
                        z zVar = new z();
                        zVar.b(a);
                        arrayList.add(zVar);
                    } while (a.moveToNext());
                    w.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", new Object[]{Integer.valueOf(arrayList.size())});
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", new Object[]{e.toString()});
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", new Object[]{e.toString()});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }
}

package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.g;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class a {
    public boolean kJl = false;
    String kJm;
    int kJn = 2;
    int kJo = 32;
    HashMap<String, String> kJp = new HashMap();
    HashMap<String, ArrayList<String>> kJq = new HashMap();
    HashMap<String, String> kJr = new HashMap();
    HashMap<String, ArrayList<a>> kJs = new HashMap();
    Comparator kJt = new Comparator<a>(this) {
        final /* synthetic */ a kJu;

        {
            this.kJu = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.index == aVar2.index) {
                    return 0;
                }
                if (aVar.index > aVar2.index) {
                    return 1;
                }
            }
            return -1;
        }
    };

    class a {
        String fFW;
        int index;
        final /* synthetic */ a kJu;

        a(a aVar, String str, int i) {
            this.kJu = aVar;
            this.fFW = str;
            this.index = i;
        }
    }

    public final void clear() {
        if (this.kJp != null) {
            this.kJp.clear();
        }
        if (this.kJq != null) {
            this.kJq.clear();
        }
        if (this.kJr != null) {
            this.kJr.clear();
        }
        if (this.kJs != null) {
            this.kJs.clear();
        }
    }

    public final void alv() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ a kJu;

            {
                this.kJu = r1;
            }

            public final void run() {
                int i;
                String str;
                ArrayList arrayList;
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = this.kJu;
                aVar.clear();
                Cursor cursor = null;
                try {
                    cursor = h.amc().kLk.Kk();
                    if (cursor != null && cursor.moveToFirst()) {
                        int count = cursor.getCount();
                        for (i = 0; i < count; i++) {
                            g gVar = new g();
                            gVar.b(cursor);
                            str = gVar.field_desc;
                            if (!bg.mA(str)) {
                                aVar.kJr.put(str.toLowerCase(), gVar.field_groupID);
                                arrayList = (ArrayList) aVar.kJq.get(gVar.field_groupID);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(gVar.field_desc);
                                aVar.kJq.put(gVar.field_groupID, arrayList);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmojiDescNewMgr", bg.g(e));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                String toLowerCase = v.bIN().toLowerCase();
                String str2 = "default";
                aVar.kJm = toLowerCase;
                cursor = null;
                str = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    cursor = h.amc().kLc.rawQuery(str, new String[0]);
                    w.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis2)});
                    if (cursor != null && cursor.moveToFirst()) {
                        cursor.moveToFirst();
                        int count2 = cursor.getCount();
                        for (i = 0; i < count2; i++) {
                            str = cursor.getString(cursor.getColumnIndex("desc"));
                            String string = cursor.getString(cursor.getColumnIndex("md5"));
                            String string2 = cursor.getString(cursor.getColumnIndex("lang"));
                            int i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                            if (!(bg.mA(str) || bg.mA(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                                string2 = str.toLowerCase();
                                if (aVar.kJs.containsKey(string2)) {
                                    arrayList = (ArrayList) aVar.kJs.get(string2);
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(new a(aVar, string, i2));
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(new a(aVar, string, i2));
                                    aVar.kJs.put(string2, arrayList);
                                }
                                aVar.kJp.put(string, string2);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    w.w("MicroMsg.emoji.EmojiDescNewMgr", bg.g(e2));
                    this.kJu.kJl = true;
                    w.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                this.kJu.kJl = true;
                w.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
            }

            public final String toString() {
                return super.toString() + "|newinit";
            }
        });
    }
}

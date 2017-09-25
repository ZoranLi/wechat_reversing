package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static a mMA = null;
    public long endTime = -1;
    ae handler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ a mMB;

        public final void handleMessage(Message message) {
            long currentTimeMillis = System.currentTimeMillis();
            d aEn = i.aEn();
            ArrayList<c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long cs = aEn.cs(Thread.currentThread().getId());
                w.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor a = aEn.gUz.a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
                Map hashMap = new HashMap();
                if (a == null || !a.moveToFirst()) {
                    if (a != null) {
                        a.close();
                    }
                    w.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar : arrayList) {
                        if (!hashMap.containsKey(cVar.field_contactId)) {
                            aEn.b(cVar);
                        }
                    }
                    aEn.ct(cs);
                } else {
                    do {
                        String string = a.getString(0);
                        if (!hashMap.containsKey(string)) {
                            hashMap.put(string, Boolean.valueOf(true));
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    w.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar2 : arrayList) {
                        if (!hashMap.containsKey(cVar2.field_contactId)) {
                            aEn.b(cVar2);
                        }
                    }
                    aEn.ct(cs);
                }
            }
            w.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.mMB.endTime = System.currentTimeMillis();
            w.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[]{Long.valueOf(this.mMB.endTime - this.mMB.startTime)});
            this.mMB.kxr = false;
            this.mMB.endTime = -1;
            this.mMB.startTime = -1;
            Iterator it = this.mMB.mMz.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.azD();
                }
            }
            this.mMB.mMz.clear();
        }
    };
    public boolean kxr = false;
    public ArrayList<a> mMz = new ArrayList();
    public long startTime = -1;

    public interface a {
        void azD();
    }

    private a() {
    }

    public static a aDR() {
        if (mMA == null) {
            mMA = new a();
        }
        return mMA;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.mMz.add(aVar);
        }
        if (this.kxr) {
            w.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.aEN().size() == 0 || !z) {
            w.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList aEM = b.aEM();
            w.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = aEM;
            this.handler.sendMessage(obtainMessage);
            this.kxr = true;
        }
    }
}

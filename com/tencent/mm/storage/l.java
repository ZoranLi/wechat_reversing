package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;

public final class l extends i<k> {
    public static final String[] gUx = new String[]{i.a(k.gTP, "BackupRecoverMsgListDataId")};
    private e gUz;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        return super.a(j, (k) cVar);
    }

    public l(g gVar) {
        super(gVar, k.gTP, "BackupRecoverMsgListDataId", null);
        this.gUz = gVar;
    }

    public final String QG(String str) {
        String str2 = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + str + "\" ";
        w.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:" + str2);
        Cursor rawQuery = this.gUz.rawQuery(str2, null);
        if (rawQuery == null) {
            w.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", str);
            return null;
        } else if (rawQuery.moveToFirst()) {
            k kVar = new k();
            kVar.b(rawQuery);
            rawQuery.close();
            return kVar.field_sessionName;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final HashMap<String, String> bKN() {
        HashMap<String, String> hashMap = new HashMap();
        Cursor Kk = Kk();
        if (Kk == null) {
            w.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
        } else {
            while (Kk.moveToNext()) {
                k kVar = new k();
                kVar.b(Kk);
                hashMap.put(kVar.field_msgListDataId, kVar.field_sessionName);
            }
            Kk.close();
        }
        return hashMap;
    }

    public final boolean bKO() {
        String str = "SELECT * FROM BackupRecoverMsgListDataId";
        w.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:" + str);
        Cursor rawQuery = this.gUz.rawQuery(str, null);
        if (rawQuery == null) {
            w.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
            return false;
        } else if (rawQuery.getCount() <= 0) {
            w.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
            rawQuery.close();
            return false;
        } else {
            rawQuery.close();
            return true;
        }
    }

    public final HashSet<String> bKP() {
        HashSet<String> hashSet = new HashSet();
        Cursor Kk = Kk();
        if (Kk == null) {
            w.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
        } else {
            while (Kk.moveToNext()) {
                k kVar = new k();
                kVar.b(Kk);
                hashSet.add(kVar.field_sessionName);
            }
            Kk.close();
        }
        return hashSet;
    }

    public final boolean bKQ() {
        w.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", Boolean.valueOf(this.gUz.eE("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId")));
        return this.gUz.eE("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    }
}

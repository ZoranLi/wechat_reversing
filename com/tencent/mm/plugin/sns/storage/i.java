package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.da;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class i extends da {
    protected static a gTP;
    public int qno;

    static {
        a aVar = new a();
        aVar.hXH = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsID";
        aVar.uxd.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "parentID";
        aVar.uxd.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.uxd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.uxd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "talker";
        aVar.uxd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSend";
        aVar.uxd.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "curActionBuf";
        aVar.uxd.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "refActionBuf";
        aVar.uxd.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "commentSvrID";
        aVar.uxd.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = ClientInfoTable.Columns.CLIENTID;
        aVar.uxd.put(ClientInfoTable.Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "commentflag";
        aVar.uxd.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "isSilence";
        aVar.uxd.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        aVar.columns[13] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.qno = (int) this.uxb;
        } catch (Exception e) {
            String message = e.getMessage();
            w.e("MicroMsg.SnsComment", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.beP().bhl();
            }
            throw e;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
        }
    }

    public final void bhh() {
        this.field_commentflag |= 1;
    }
}

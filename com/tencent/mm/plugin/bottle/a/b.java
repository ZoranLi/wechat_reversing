package com.tencent.mm.plugin.bottle.a;

import android.content.ContentValues;
import com.tencent.mm.bj.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.wcdb.FileUtils;

public final class b extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public g hnH;

    public b(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(a aVar) {
        aVar.fRW = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.fRW & 1) != 0) {
            contentValues.put("parentclientid", aVar.jUW == null ? "" : aVar.jUW);
        }
        if ((aVar.fRW & 2) != 0) {
            contentValues.put("childcount", Integer.valueOf(aVar.jUX));
        }
        if ((aVar.fRW & 4) != 0) {
            contentValues.put("bottleid", aVar.adn());
        }
        if ((aVar.fRW & 8) != 0) {
            contentValues.put("bottletype", Integer.valueOf(aVar.jUZ));
        }
        if ((aVar.fRW & 16) != 0) {
            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
        }
        if ((aVar.fRW & 32) != 0) {
            contentValues.put("voicelen", Integer.valueOf(aVar.jVa));
        }
        if ((aVar.fRW & 64) != 0) {
            contentValues.put("content", aVar.pM());
        }
        if ((aVar.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("createtime", Long.valueOf(aVar.jVb));
        }
        if ((aVar.fRW & 256) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.hnD));
        }
        if ((aVar.fRW & 512) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.hBy));
        }
        if ((aVar.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", aVar.hnF == null ? "" : aVar.hnF);
        }
        if ((aVar.fRW & 2048) != 0) {
            contentValues.put("reserved4", aVar.hnG == null ? "" : aVar.hnG);
        }
        if (((int) this.hnH.insert("bottleinfo1", "bottleid", contentValues)) != -1) {
            return true;
        }
        return false;
    }
}

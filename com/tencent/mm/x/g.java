package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;

public final class g extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    com.tencent.mm.bj.g hnH;

    public g(com.tencent.mm.bj.g gVar) {
        this.hnH = gVar;
    }

    public final int a(String str, f fVar) {
        return this.hnH.update("hdheadimginfo", fVar.pv(), "username=?", new String[]{str});
    }

    public final f hr(String str) {
        f fVar = null;
        Cursor a = this.hnH.a("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.username = a.getString(0);
                fVar.hrp = a.getInt(1);
                fVar.hrq = a.getInt(2);
                fVar.hrr = a.getString(3);
                fVar.hrs = a.getInt(4);
                fVar.hrt = a.getInt(5);
                fVar.hru = a.getInt(6);
                fVar.hrv = a.getString(7);
                fVar.hrw = a.getString(8);
                fVar.hrx = a.getInt(9);
                fVar.hry = a.getInt(10);
            }
            a.close();
        }
        return fVar;
    }
}

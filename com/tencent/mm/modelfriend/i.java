package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public g hnH;

    public i(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(h hVar) {
        Assert.assertTrue("Func Set always conv_flag == flag_all", hVar.fRW == -1);
        Cursor a = this.hnH.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bg.my(String.valueOf(hVar.gkt)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            int update = this.hnH.update("facebookfriend", hVar.pv(), "fbid=?", new String[]{hVar.gkt});
            if (update > 0) {
                doNotify();
            }
            if (update <= 0) {
                return false;
            }
            return true;
        }
        hVar.fRW = -1;
        return ((int) this.hnH.insert("facebookfriend", "fbid", hVar.pv())) != -1;
    }

    public final boolean Fe() {
        return this.hnH.eE("facebookfriend", "delete from facebookfriend");
    }
}

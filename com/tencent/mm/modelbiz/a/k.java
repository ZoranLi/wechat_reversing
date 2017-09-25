package com.tencent.mm.modelbiz.a;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k extends i<j> {
    public static final String[] gUx = new String[]{i.a(j.gTP, "BizChatUserInfo")};
    public e gUz;
    final com.tencent.mm.sdk.e.k<a, b> hug = new com.tencent.mm.sdk.e.k<a, b>(this) {
        final /* synthetic */ k hxn;

        {
            this.hxn = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };
    Map<String, String> hwI = new HashMap();

    public interface a {

        public enum a {
            ;

            static {
                hxo = 1;
                hxp = 2;
                hxq = 3;
                hxr = new int[]{hxo, hxp, hxq};
            }
        }

        public static class b {
            public int hxs;
            public j hxt;
            public String userId;
        }
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(e eVar) {
        super(eVar, j.gTP, "BizChatUserInfo", null);
        this.gUz = eVar;
        eVar.eE("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.hwI.clear();
    }

    public final j iD(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            return null;
        }
        c jVar = new j();
        jVar.field_userId = str;
        super.b(jVar, new String[0]);
        return jVar;
    }

    public final boolean a(j jVar) {
        w.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (jVar == null) {
            w.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b((c) jVar);
        if (!b) {
            return b;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.hxs = a.hxo;
        bVar.hxt = jVar;
        this.hug.by(bVar);
        this.hug.doNotify();
        return b;
    }

    public final boolean b(j jVar) {
        w.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (jVar == null) {
            w.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            return false;
        }
        if (jVar == null || bg.mA(jVar.field_userName)) {
            w.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            jVar.field_userNamePY = com.tencent.mm.platformtools.c.mp(jVar.field_userName);
        }
        boolean a = super.a(jVar);
        if (!a) {
            return a;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.hxs = a.hxq;
        bVar.hxt = jVar;
        this.hug.by(bVar);
        this.hug.doNotify();
        return a;
    }

    public final j iE(String str) {
        if (str == null) {
            w.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            return null;
        }
        String iF = iF(str);
        if (iF != null) {
            return iD(iF);
        }
        w.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
        return null;
    }

    public final String iF(String str) {
        if (str == null) {
            w.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            return null;
        }
        w.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        if (this.hwI.containsKey(str) && this.hwI.get(str) != null) {
            return (String) this.hwI.get(str);
        }
        f iB = com.tencent.mm.modelbiz.w.DM().iB(str);
        if (iB != null) {
            w.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, iB.field_userId);
            this.hwI.put(str, iB.field_userId);
            return iB.field_userId;
        }
        w.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
        return null;
    }

    public final void c(j jVar) {
        w.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        j iD = iD(jVar.field_userId);
        if (iD == null) {
            a(jVar);
        } else if (!bg.mA(jVar.field_userName) && !jVar.field_userName.equals(iD.field_userName)) {
            iD.field_userName = jVar.field_userName;
            b(iD);
        }
    }

    public static String a(String[] strArr, List<String> list) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(" 1=1 ");
        String str = "";
        if (list != null && list.size() > 0) {
            String str2 = str;
            for (String str3 : list) {
                str2 = str2 + " and userId != '" + str3 + "'";
            }
            str3 = str2;
        }
        stringBuilder.append(str3);
        stringBuilder.append(" and ");
        stringBuilder.append("userId in(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(" '").append(strArr[i]).append("' ");
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}

package com.tencent.mm.modelbiz;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends i<BizInfo> {
    public static final String[] gUx = new String[]{i.a(BizInfo.gTP, "bizinfo")};
    public static final String[] gaK = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static Map<String, String> hvy = new HashMap();
    private final k<a, b> hug = new k<a, b>(this) {
        final /* synthetic */ d hvz;

        {
            this.hvz = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };

    public interface a {

        public enum a {
            ;

            static {
                hvA = 1;
                hvB = 2;
                hvC = 3;
                hvD = new int[]{hvA, hvB, hvC};
            }
        }

        public static class b {
            public boolean huJ;
            public String huj;
            public int hvE;
            public BizInfo hvF;
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return e((BizInfo) cVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return d((BizInfo) cVar);
    }

    public d(e eVar) {
        super(eVar, BizInfo.gTP, "bizinfo", gaK);
    }

    public final void a(a aVar, Looper looper) {
        this.hug.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hug != null) {
            this.hug.remove(aVar);
        }
    }

    public final BizInfo hO(String str) {
        c bizInfo = new BizInfo();
        bizInfo.field_username = str;
        super.b(bizInfo, new String[0]);
        return bizInfo;
    }

    public final void hP(String str) {
        c bizInfo = new BizInfo();
        bizInfo.field_username = str;
        String[] strArr = new String[]{"username"};
        w.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a(bizInfo, strArr)), str);
        b bVar = new b();
        bVar.huj = str;
        bVar.hvE = a.hvB;
        bVar.hvF = bizInfo;
        this.hug.by(bVar);
        this.hug.doNotify();
    }

    public final void c(BizInfo bizInfo) {
        String[] strArr = new String[]{"username"};
        w.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a((c) bizInfo, strArr)), bizInfo.field_username);
        b bVar = new b();
        bVar.huj = bizInfo.field_username;
        bVar.hvE = a.hvB;
        bVar.hvF = bizInfo;
        this.hug.by(bVar);
        this.hug.doNotify();
    }

    public final boolean d(BizInfo bizInfo) {
        bizInfo.field_updateTime = System.currentTimeMillis();
        bizInfo.CC();
        w.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", bizInfo.field_username, bizInfo.field_brandList, Integer.valueOf(bizInfo.field_brandFlag), bizInfo.field_brandInfo, bizInfo.field_extInfo, bizInfo.field_brandIconURL, Long.valueOf(bizInfo.field_updateTime));
        ExtInfo bd = bizInfo.bd(false);
        if (bd != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a Da = bd.Da();
            if (Da != null) {
                bizInfo.field_specialType = Da.hvd;
            }
        }
        boolean b = super.b((c) bizInfo);
        if (b && !o.dH(bizInfo.field_username)) {
            b bVar = new b();
            bVar.huj = bizInfo.field_username;
            bVar.huJ = bizInfo.CD();
            bVar.hvE = a.hvA;
            bVar.hvF = bizInfo;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return b;
    }

    public final boolean e(BizInfo bizInfo) {
        bizInfo.field_updateTime = System.currentTimeMillis();
        bizInfo.CC();
        ExtInfo bd = bizInfo.bd(false);
        if (bd != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a Da = bd.Da();
            if (Da != null) {
                bizInfo.field_specialType = Da.hvd;
            }
        }
        boolean a = super.a(bizInfo);
        if (a && !o.dH(bizInfo.field_username)) {
            b bVar = new b();
            bVar.huj = bizInfo.field_username;
            bVar.huJ = bizInfo.CD();
            bVar.hvE = a.hvC;
            bVar.hvF = bizInfo;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return a;
    }

    public final List<String> fw(int i) {
        w.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)}));
        long NA = bg.NA();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            w.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bg.aB(NA)));
            return ((h) com.tencent.mm.kernel.h.h(h.class)).wR().ck(linkedList);
        }
        w.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bg.aB(NA)));
        return linkedList;
    }

    public final int fx(int i) {
        List fw = fw(i);
        if (bg.bV(fw)) {
            return 0;
        }
        return fw.size();
    }

    public static String Dk() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static String Dl() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & ").append(2048).append(" desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.username").append(" ");
    }

    public static void b(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type").append(" ");
    }

    public static void c(StringBuilder stringBuilder) {
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.bLg()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
    }

    public static void d(StringBuilder stringBuilder) {
        stringBuilder.append(" and bizinfo.type").append(" = 3 ");
    }

    public static void a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(" and bizinfo.type").append(" = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather").append(" = '").append(str).append("' ");
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.bitFlag").append(" & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
    }

    public static void b(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
    }

    public static Cursor v(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType").append(" & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(Dk());
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", stringBuilder.toString());
        return com.tencent.mm.kernel.h.vI().gYg.a(stringBuilder.toString(), null, 0);
    }

    public final Cursor hQ(String str) {
        List<String> hR = hR(str);
        List arrayList = new ArrayList();
        for (String str2 : hR) {
            String str22;
            if (!bg.mA(hO(str22).CN())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(Dl());
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", stringBuilder.toString());
        return com.tencent.mm.kernel.h.vI().gYg.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> Dm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag").append(" & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag").append(" & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType").append(" & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) == 0) ");
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", stringBuilder.toString());
        Cursor a = com.tencent.mm.kernel.h.vI().gYg.a(r0, null, 2);
        List<String> arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            int i;
            if (a.getInt(2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 1;
            }
            arrayList.add(a.getString(i));
        }
        a.close();
        return ((h) com.tencent.mm.kernel.h.h(h.class)).wR().ck(arrayList);
    }

    public static Cursor t(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(Dl());
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", stringBuilder.toString());
        return com.tencent.mm.kernel.h.vI().gYg.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> hR(String str) {
        List<String> list = null;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", stringBuilder.toString());
        Cursor a = com.tencent.mm.kernel.h.vI().gYg.a(r1, null, 2);
        if (a != null) {
            list = new ArrayList();
            while (a.moveToNext()) {
                list.add(a.getString(0));
            }
            a.close();
        }
        return list;
    }

    public static String hS(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            return null;
        } else if (hvy == null || !hvy.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            w.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", stringBuilder.toString());
            Cursor a = com.tencent.mm.kernel.h.vI().gYg.a(r0, null, 2);
            if (a == null) {
                return null;
            }
            if (a.moveToFirst()) {
                r0 = a.getString(0);
                hvy.put(str, r0);
            } else {
                r0 = null;
            }
            a.close();
            return r0;
        } else {
            r0 = (String) hvy.get(str);
            if (bg.mA(r0) || !o.eU(r0)) {
                return null;
            }
            return r0;
        }
    }

    public static List<String> fy(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType").append(" = 1");
        stringBuilder.append(" and rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.bLg()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        w.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", stringBuilder.toString());
        List<String> arrayList = new ArrayList();
        Cursor a = com.tencent.mm.kernel.h.vI().gYg.a(r0, null, 2);
        int columnIndex = a.getColumnIndex("username");
        while (a.moveToNext()) {
            arrayList.add(a.getString(columnIndex));
        }
        a.close();
        return arrayList;
    }

    public static boolean hT(String str) {
        boolean z = false;
        if (!bg.mA(str) && e.ic(str)) {
            BizInfo hW = e.hW(str);
            if (!(hW.bd(false) == null || hW.bd(false).Di() == null || bg.mA(hW.CO()))) {
                aj Ry = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Ry(hW.CO());
                if (Ry != null && Ry.field_username.equals(str) && Ry.field_unReadCount > 0) {
                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Ro(hW.CO());
                }
            }
            Cursor As = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().As(str);
            As.moveToFirst();
            while (!As.isAfterLast()) {
                ce auVar = new au();
                auVar.b(As);
                auVar.dv(4);
                w.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                As.moveToNext();
                z = true;
            }
            As.close();
            if (z) {
                ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Ro(str);
                ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Aq(str);
            }
        }
        return z;
    }

    public static void hU(String str) {
        if (!bg.mA(str) && e.ic(str)) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().db(str);
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ox();
        }
    }

    public static void hV(String str) {
        if (!bg.mA(str) && e.ic(str)) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().db("");
        }
    }
}

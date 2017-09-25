package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public List<j> kdw = new ArrayList();
    private List<a> ofK = new ArrayList();

    public c() {
        loadFromDB();
        aRC();
        aRB();
        aRD();
    }

    public final void a(j jVar, String str, String str2) {
        if (jVar != null && !TextUtils.isEmpty(str)) {
            a aVar = new a();
            aVar.field_msgId = jVar.fSm;
            aVar.field_msgContentXml = str;
            aVar.field_isRead = str2;
            b.aRw();
            if (!b.aRy().a(aVar)) {
                w.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.fSm);
            }
            this.ofK.add(aVar);
        }
    }

    private void loadFromDB() {
        b.aRw();
        Cursor Kk = b.aRy().Kk();
        if (Kk != null && Kk.getCount() > 0) {
            Kk.moveToFirst();
            int columnIndex = Kk.getColumnIndex("msgId");
            int columnIndex2 = Kk.getColumnIndex("msgContentXml");
            int columnIndex3 = Kk.getColumnIndex("isRead");
            while (!Kk.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = Kk.getString(columnIndex);
                aVar.field_msgContentXml = Kk.getString(columnIndex2);
                aVar.field_isRead = Kk.getString(columnIndex3);
                Kk.moveToNext();
                this.ofK.add(aVar);
            }
        }
        if (Kk != null) {
            Kk.close();
        }
    }

    private void aRB() {
        if (this.kdw != null && this.kdw.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kdw);
            for (int i = 0; i < arrayList.size(); i++) {
                j jVar = (j) arrayList.get(i);
                if (jVar.ohd != null && com.tencent.mm.plugin.order.c.c.tb(jVar.ohd)) {
                    int intValue = Integer.valueOf(jVar.ohd).intValue();
                    if (!(intValue == 2 || intValue == 1)) {
                        Co(jVar.fSm);
                    }
                }
            }
        }
    }

    public static j Cn(String str) {
        Map q = bh.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        j jVar = new j();
        jVar.ohd = (String) q.get(".sysmsg.paymsg.PayMsgType");
        jVar.ohe = (String) q.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.ohf = (String) q.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.ohg = (String) q.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.ohh = (String) q.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.fSs = (String) q.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.ohi = (String) q.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.ohj = (String) q.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.ogT = (String) q.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.ohk = (String) q.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                Object obj = (String) q.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str2 = (String) q.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                String str3 = (String) q.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
                str2 = (String) q.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                break;
            }
            j.a aVar = new j.a();
            aVar.name = obj;
            aVar.jumpUrl = str2;
            if (jVar.ohl == null) {
                jVar.ohl = new ArrayList();
            }
            jVar.ohl.add(aVar);
            i++;
        }
        i = 0;
        while (true) {
            String str4;
            if (i == 0) {
                obj = (String) q.get(".sysmsg.paymsg.NormalSection.Name");
                str2 = (String) q.get(".sysmsg.paymsg.NormalSection.Value");
                str4 = (String) q.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                str3 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
                str2 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
                str4 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                return jVar;
            }
            j.b bVar = new j.b();
            bVar.name = obj;
            bVar.value = str2;
            bVar.jumpUrl = str4;
            if (jVar.ohm == null) {
                jVar.ohm = new ArrayList();
            }
            jVar.ohm.add(bVar);
            i++;
        }
    }

    public final boolean Co(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        j Cq = Cq(str);
        if (Cq == null) {
            return false;
        }
        this.kdw.remove(Cq);
        if (Cq != null) {
            for (int i = 0; i < this.ofK.size(); i++) {
                a aVar = (a) this.ofK.get(i);
                if (Cq.fSm.equals(aVar.field_msgId)) {
                    this.ofK.remove(aVar);
                    b.aRw();
                    b.aRy().a(aVar, new String[0]);
                    break;
                }
            }
        }
        return true;
    }

    private void aRC() {
        for (int i = 0; i < this.ofK.size(); i++) {
            a aVar = (a) this.ofK.get(i);
            String str = aVar.field_msgContentXml;
            j Cn = Cn(str);
            Cn.fSm = aVar.field_msgId;
            this.kdw.add(Cn);
            w.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:" + str);
        }
    }

    public final boolean Cp(String str) {
        if (this.kdw == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.kdw.size(); i++) {
            j jVar = (j) this.kdw.get(i);
            if (jVar != null && jVar.fSm.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final j Cq(String str) {
        if (this.kdw == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.kdw.size(); i++) {
            j jVar = (j) this.kdw.get(i);
            if (str.equals(jVar.fSm)) {
                return jVar;
            }
        }
        return null;
    }

    public final a Cr(String str) {
        if (this.ofK == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.ofK.size(); i++) {
            a aVar = (a) this.ofK.get(i);
            if (str.equals(aVar.field_msgId)) {
                return aVar;
            }
        }
        return null;
    }

    public final void aRD() {
        int aRE = aRE();
        ap.yY();
        com.tencent.mm.u.c.vr().set(204820, Integer.valueOf(aRE));
        w.v("MicroMsg.MallPayMsgManager", "save unread msg is :" + aRE);
    }

    public final int aRE() {
        if (this.ofK == null || this.ofK.size() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.ofK.size(); i2++) {
            a aVar = (a) this.ofK.get(i2);
            if (aVar != null && "0".equals(aVar.field_isRead)) {
                i++;
            }
        }
        w.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:" + i);
        return i;
    }

    public static MallOrderDetailObject a(j jVar) {
        if (jVar == null) {
            return null;
        }
        int i;
        MallOrderDetailObject mallOrderDetailObject = new MallOrderDetailObject();
        MallOrderDetailObject.b bVar = new MallOrderDetailObject.b();
        bVar.ofF = jVar.ohh;
        if (TextUtils.isEmpty(jVar.ohf) || !com.tencent.mm.plugin.order.c.c.tb(jVar.ohf)) {
            bVar.cIm = (int) (System.currentTimeMillis() / 1000);
        } else {
            bVar.cIm = Integer.valueOf(jVar.ohf).intValue();
        }
        bVar.thumbUrl = jVar.ohg;
        bVar.msF = jVar.ohi;
        bVar.ofG = jVar.fSs;
        mallOrderDetailObject.ofx = bVar;
        List list = jVar.ohl;
        if (list != null && list.size() > 0) {
            mallOrderDetailObject.ofz = new ArrayList();
            for (i = 0; i < list.size(); i++) {
                j.a aVar = (j.a) list.get(i);
                MallOrderDetailObject.a aVar2 = new MallOrderDetailObject.a();
                aVar2.name = aVar.name;
                aVar2.value = "";
                aVar2.jumpUrl = aVar.jumpUrl;
                aVar2.kdT = false;
                mallOrderDetailObject.ofz.add(aVar2);
            }
        }
        list = jVar.ohm;
        if (list != null && list.size() > 0) {
            if (mallOrderDetailObject.ofz == null) {
                mallOrderDetailObject.ofz = new ArrayList();
            }
            for (i = 0; i < list.size(); i++) {
                j.b bVar2 = (j.b) list.get(i);
                aVar2 = new MallOrderDetailObject.a();
                aVar2.name = bVar2.name;
                aVar2.value = bVar2.value;
                aVar2.jumpUrl = bVar2.jumpUrl;
                aVar2.kdT = false;
                if (i == 0) {
                    aVar2.kdT = true;
                }
                mallOrderDetailObject.ofz.add(aVar2);
            }
        }
        mallOrderDetailObject.ofD = jVar.ohk;
        mallOrderDetailObject.fKK = jVar.ohj;
        if (TextUtils.isEmpty(jVar.ohf) || !com.tencent.mm.plugin.order.c.c.tb(jVar.ohf)) {
            mallOrderDetailObject.ofE = (int) (System.currentTimeMillis() / 1000);
        } else {
            mallOrderDetailObject.ofE = Integer.valueOf(jVar.ohf).intValue();
        }
        return mallOrderDetailObject;
    }
}

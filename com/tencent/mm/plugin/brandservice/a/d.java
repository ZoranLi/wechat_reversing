package com.tencent.mm.plugin.brandservice.a;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public LinkedList<a> jZe = new LinkedList();
    public boolean jZf = false;
    public List<b> jZg = new LinkedList();
    public List<b> jZh = new LinkedList();

    public interface a {
        void adZ();
    }

    public d() {
        ap.vd().a(387, this);
        ap.vd().a(new f(), 0);
    }

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.jZg.clear();
        this.jZh.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.bLg()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        w.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[]{stringBuilder.toString()});
        ap.yY();
        Cursor a = c.wO().a(r0, null, 2);
        Map hashMap = new HashMap();
        if (a != null) {
            int i = 0;
            while (a.moveToNext()) {
                i++;
                af xVar = new x();
                xVar.b(a);
                BizInfo bizInfo = new BizInfo();
                bizInfo.b(a);
                if (!xVar.field_username.equals("gh_43f2581f6fd6")) {
                    b bVar = new b();
                    bVar.userName = xVar.field_username;
                    bVar.jiL = xVar;
                    bVar.jZc = bizInfo;
                    if (!o.fh(bVar.userName)) {
                        hashMap.put(bVar.userName, bVar);
                        if (bVar.jZc.field_type != 3) {
                            if (bVar.jZc.field_type == 2) {
                                this.jZg.add(bVar);
                            } else if (bVar.jZc.field_type == 1 || bVar.jZc.field_type == 0) {
                                this.jZh.add(bVar);
                            }
                        }
                    }
                }
            }
            w.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[]{Integer.valueOf(i)});
            a.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(x.bLg()).append(") != 0 ");
        stringBuilder.append(" and (type & 1").append(") != 0 ");
        w.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[]{stringBuilder.toString()});
        ap.yY();
        Cursor a2 = c.wO().a(r0, null, 0);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                String string = a2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            a2.close();
            w.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[]{Integer.valueOf(arrayList.size()), arrayList});
            if (!arrayList.isEmpty()) {
                ap.yY();
                long cs = c.wO().cs(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.u.ag.a.hlS.J((String) it.next(), "");
                }
                ap.yY();
                c.wO().aD(cs);
            }
        }
        w.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        w.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[]{Integer.valueOf(this.jZh.size()), Integer.valueOf(this.jZg.size())});
        w.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        w.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0 && kVar.getType() == 387) {
            LinkedList linkedList = ((f) kVar).jZi;
            if (linkedList == null) {
                w.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
            } else if (this.jZg == null || this.jZh == null) {
                w.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
            } else {
                int i4;
                if (linkedList.size() != this.jZg.size() + this.jZh.size()) {
                    i4 = 1;
                } else {
                    for (b bVar : this.jZg) {
                        if (bVar != null) {
                            if (!linkedList.contains(bVar.userName)) {
                            }
                        }
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        for (b bVar2 : this.jZh) {
                            if (bVar2 != null) {
                                if (!linkedList.contains(bVar2.userName)) {
                                }
                            }
                            i4 = 1;
                        }
                    }
                    i4 = i3;
                }
                if (i4 != 0) {
                    init();
                    Iterator it = this.jZe.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).adZ();
                    }
                }
            }
        }
    }
}

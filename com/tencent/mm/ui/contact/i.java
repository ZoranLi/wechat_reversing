package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.d.a.b;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements com.tencent.mm.modelbiz.d.a {
    private Context context;
    private LinearLayout lJu = null;
    private List<String> vXB;
    private Map<String, View> vXC;
    private a vXD;

    public interface a {
        void BK(int i);
    }

    public i(Context context, a aVar) {
        super(context);
        this.context = context;
        this.vXD = aVar;
        init();
    }

    public final int bXV() {
        if (this.vXB == null) {
            return 0;
        }
        return this.vXB.size();
    }

    private void init() {
        int i = 0;
        d DH = w.DH();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        d.a(stringBuilder);
        d.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type").append(" = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(d.Dk());
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = DH.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.vXB = arrayList;
        if (this.vXB == null || this.vXB.size() <= 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseBizView", "bizList is null");
            return;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.vXB.size()));
        this.vXC = new HashMap();
        if (this.lJu == null) {
            View.inflate(getContext(), R.i.daZ, this);
            this.lJu = (LinearLayout) findViewById(R.h.bGr);
        }
        while (i < this.vXB.size()) {
            String str = (String) this.vXB.get(i);
            View jVar = new j(getContext(), str);
            this.lJu.addView(jVar);
            this.vXC.put(str, jVar);
            if (i == this.vXB.size() - 1) {
                jVar.findViewById(R.h.bMj).setBackgroundResource(R.g.bhc);
            }
            i++;
        }
    }

    public final void a(final b bVar) {
        if (bVar.hvF != null) {
            if (bVar.hvF.CH()) {
                af.v(new Runnable(this) {
                    final /* synthetic */ i vXE;

                    public final void run() {
                        ap.yY();
                        com.tencent.mm.e.b.af Rc = c.wR().Rc(bVar.huj);
                        if (this.vXE.vXB == null || this.vXE.vXB.size() <= 0 || !this.vXE.vXB.contains(bVar.huj)) {
                            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                                if (this.vXE.vXB != null) {
                                    this.vXE.vXB.clear();
                                }
                                if (this.vXE.vXC != null) {
                                    this.vXE.vXC.clear();
                                }
                                if (this.vXE.lJu != null) {
                                    this.vXE.lJu.removeAllViews();
                                }
                                this.vXE.init();
                                if (this.vXE.vXD != null) {
                                    this.vXE.vXD.BK(this.vXE.vXB.size());
                                }
                            }
                        } else if (Rc == null || ((int) Rc.gTQ) <= 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", bVar.huj);
                            this.vXE.vXB.remove(bVar.huj);
                            if (this.vXE.vXB.size() > 0) {
                                View view = (View) this.vXE.vXC.get(bVar.huj);
                                if (view != null && this.vXE.lJu != null) {
                                    this.vXE.lJu.removeView(view);
                                    this.vXE.vXC.remove(view);
                                }
                            } else if (this.vXE.vXD != null) {
                                if (this.vXE.vXC != null) {
                                    this.vXE.vXC.clear();
                                }
                                if (this.vXE.lJu != null) {
                                    this.vXE.lJu.removeAllViews();
                                }
                                this.vXE.vXD.BK(this.vXE.vXB.size());
                            }
                        }
                    }
                });
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            }
        }
    }
}

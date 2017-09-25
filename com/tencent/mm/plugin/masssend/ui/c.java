package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c extends k<com.tencent.mm.plugin.masssend.a.a> {
    private static short nxp = (short) 1;
    private static short nxq = (short) 2;
    private static short nxr = (short) 3;
    private static short nxs = (short) 4;
    private MMActivity fCi;
    int hOI;
    int kor;
    private LayoutInflater myo;
    private short[] nxt;
    private List<String> nxu;
    String nxv = "";
    e nxw;

    class a implements OnClickListener {
        private String fyF;
        private int nwW;
        final /* synthetic */ c nxx;

        public a(c cVar, String str, int i) {
            this.nxx = cVar;
            this.fyF = str;
            this.nwW = i;
        }

        public final void onClick(View view) {
            w.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fyF);
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xb()).append(this.fyF).toString();
                if (stringBuilder2 == null || stringBuilder2.equals("") || !com.tencent.mm.a.e.aO(stringBuilder2)) {
                    w.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_compress_type", this.nwW);
                intent.putExtra("key_favorite", false);
                intent.putExtra("key_image_path", stringBuilder2);
                com.tencent.mm.plugin.masssend.a.imv.c(this.nxx.fCi, intent);
                return;
            }
            s.eP(this.nxx.fCi);
        }
    }

    class b implements OnClickListener {
        private String id;
        final /* synthetic */ c nxx;

        public b(c cVar, String str) {
            this.nxx = cVar;
            this.id = str;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.masssend.a.a zT = h.aJt().zT(this.id);
            Intent intent = new Intent(this.nxx.fCi, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", zT.aJo());
            intent.putExtra("mass_send_again", true);
            this.nxx.fCi.startActivity(intent);
        }
    }

    class c implements OnClickListener {
        private String fyF;
        private int length;
        private int nwV;
        final /* synthetic */ c nxx;
        private int size;

        public c(c cVar, String str, int i, int i2, int i3) {
            this.nxx = cVar;
            this.fyF = str;
            this.nwV = i;
            this.length = i3;
            this.size = i2;
        }

        public final void onClick(View view) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                boolean z = this.nwV == 2;
                o.KV();
                w.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[]{this.fyF, Boolean.valueOf(z), Boolean.valueOf(q.lo(com.tencent.mm.modelvideo.s.lv(this.fyF)))});
                com.tencent.mm.plugin.masssend.a.imv.a(z, r2, this.nxx.fCi, this.fyF, this.length, this.size);
                return;
            }
            s.eP(this.nxx.fCi);
        }
    }

    class d implements OnClickListener {
        private String id;
        final /* synthetic */ c nxx;

        public d(c cVar, String str) {
            this.nxx = cVar;
            this.id = str;
        }

        public final void onClick(View view) {
            w.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
            if (this.nxx.nxw != null) {
                this.nxx.nxv = this.nxx.nxw.zX(this.id);
                this.nxx.notifyDataSetChanged();
            }
        }
    }

    interface e {
        String zX(String str);
    }

    static class f {
        ImageView lHs;
        TextView mzk;
        TextView nxA;
        TextView nxB;
        TextView nxC;
        AnimImageView nxD;
        View nxE;
        short nxF;
        TextView nxy;
        TextView nxz;

        f() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.plugin.masssend.a.a) obj;
        if (obj == null) {
            obj = new com.tencent.mm.plugin.masssend.a.a();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context) {
        super(context, new com.tencent.mm.plugin.masssend.a.a());
        this.fCi = (MMActivity) context;
        this.nxu = new LinkedList();
        this.kor = 10;
        this.hOI = this.kor;
        this.myo = r.eC(context);
    }

    protected final void OL() {
        OK();
    }

    public final boolean ahI() {
        return this.kor >= this.hOI;
    }

    public final void OK() {
        int i;
        Cursor a = h.aJt().hnH.a("SELECT count(*) FROM massendinfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        this.hOI = i;
        com.tencent.mm.plugin.masssend.a.b aJt = h.aJt();
        int i2 = this.kor;
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        w.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
        setCursor(aJt.hnH.a(str, null, 0));
        i = getCount();
        if (i > 0) {
            this.nxt = new short[i];
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        com.tencent.mm.plugin.masssend.a.a aVar;
        CharSequence charSequence;
        com.tencent.mm.plugin.masssend.a.a aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
        if (i != 0) {
            long j = ((com.tencent.mm.plugin.masssend.a.a) getItem(i - 1)).iam;
            aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
            long j2 = aVar2.iam;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.nxt[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.nxt[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.nxt[i] = (short) 1;
            aVar = aVar2;
        }
        obj = (this.nxt[i] != (short) 1 || aVar.iam <= 1000) ? null : 1;
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).nxF != nxp) {
                    view = this.myo.inflate(R.i.dij, null);
                    fVar.nxy = (TextView) view.findViewById(R.h.ciY);
                    fVar.nxz = (TextView) view.findViewById(R.h.cja);
                    fVar.nxA = (TextView) view.findViewById(R.h.cjb);
                    fVar.nxC = (TextView) view.findViewById(R.h.ciW);
                    fVar.mzk = (TextView) view.findViewById(R.h.cjg);
                    fVar.nxE = view.findViewById(R.h.ciX);
                    fVar.nxF = nxp;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).nxF != nxq) {
                    view = this.myo.inflate(R.i.dii, null);
                    fVar.nxy = (TextView) view.findViewById(R.h.ciY);
                    fVar.nxz = (TextView) view.findViewById(R.h.cja);
                    fVar.lHs = (ImageView) view.findViewById(R.h.cjc);
                    fVar.nxC = (TextView) view.findViewById(R.h.ciW);
                    fVar.mzk = (TextView) view.findViewById(R.h.cjg);
                    fVar.nxE = view.findViewById(R.h.ciX);
                    fVar.nxF = nxq;
                    view.setTag(fVar);
                    break;
                }
            case 34:
                fVar = new f();
                if (view == null || ((f) view.getTag()).nxF != nxs) {
                    view = this.myo.inflate(R.i.dil, null);
                    fVar.nxy = (TextView) view.findViewById(R.h.ciY);
                    fVar.nxz = (TextView) view.findViewById(R.h.cja);
                    fVar.nxB = (TextView) view.findViewById(R.h.ciZ);
                    fVar.nxA = (TextView) view.findViewById(R.h.cjf);
                    fVar.nxD = (AnimImageView) view.findViewById(R.h.cje);
                    fVar.nxC = (TextView) view.findViewById(R.h.ciW);
                    fVar.mzk = (TextView) view.findViewById(R.h.cjg);
                    fVar.nxE = view.findViewById(R.h.ciX);
                    fVar.nxF = nxs;
                    view.setTag(fVar);
                    break;
                }
            case 43:
                fVar = new f();
                if (view == null || ((f) view.getTag()).nxF != nxr) {
                    view = this.myo.inflate(R.i.dik, null);
                    fVar.nxy = (TextView) view.findViewById(R.h.ciY);
                    fVar.nxz = (TextView) view.findViewById(R.h.cja);
                    fVar.lHs = (ImageView) view.findViewById(R.h.cjc);
                    fVar.nxB = (TextView) view.findViewById(R.h.cjd);
                    fVar.nxC = (TextView) view.findViewById(R.h.ciW);
                    fVar.mzk = (TextView) view.findViewById(R.h.cjg);
                    fVar.nxE = view.findViewById(R.h.ciX);
                    fVar.nxF = nxr;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.mzk.setVisibility(0);
            fVar2.mzk.setText(com.tencent.mm.pluginsdk.j.o.c(this.fCi, aVar.iam, false));
        } else {
            fVar2.mzk.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.nxA.setText(aVar.aJm());
                com.tencent.mm.pluginsdk.ui.d.h.d(fVar2.nxA, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                ap.yY();
                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                    h.aJt();
                    Bitmap zS = com.tencent.mm.plugin.masssend.a.b.zS(aVar.aJm());
                    if (zS != null) {
                        fVar2.lHs.setImageBitmap(zS);
                    } else {
                        h.aJt();
                        fVar2.lHs.setImageBitmap(com.tencent.mm.plugin.masssend.a.b.b(aVar.aJn(), com.tencent.mm.bg.a.getDensity(fVar2.lHs.getContext())));
                    }
                } else {
                    fVar2.lHs.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.g.bhP));
                }
                fVar2.lHs.setOnClickListener(new a(this, aVar.aJm(), aVar.nwW));
                break;
            case 34:
                fVar2 = (f) view.getTag();
                float aw = com.tencent.mm.modelvoice.q.aw((long) aVar.nwS);
                if (aVar.aJl().equals(this.nxv)) {
                    fVar2.nxD.setVisibility(0);
                    fVar2.nxD.bRB();
                    fVar2.nxA.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.nxD.setVisibility(8);
                    fVar2.nxD.aWX();
                    fVar2.nxA.setCompoundDrawablesWithIntrinsicBounds(null, null, this.fCi.getResources().getDrawable(R.k.dvJ), null);
                }
                fVar2.nxB.setText(this.fCi.getString(R.l.ema, new Object[]{Integer.valueOf((int) aw)}));
                fVar2.nxA.setWidth(com.tencent.mm.bg.a.fromDPToPix(fVar2.nxA.getContext(), jZ((int) aw)));
                fVar2.nxD.setWidth(com.tencent.mm.bg.a.fromDPToPix(fVar2.nxA.getContext(), jZ((int) aw)));
                fVar2.nxA.setOnClickListener(new d(this, aVar.aJl()));
                break;
            case 43:
                f fVar3 = (f) view.getTag();
                o.KV();
                Bitmap a = n.GS().a(com.tencent.mm.modelvideo.s.lw(aVar.aJm()), com.tencent.mm.bg.a.getDensity(fVar3.lHs.getContext()), this.fCi);
                if (a == null) {
                    ap.yY();
                    if (com.tencent.mm.u.c.isSDCardAvailable()) {
                        fVar3.lHs.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.e.aUi));
                    } else {
                        fVar3.lHs.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.dAr));
                    }
                } else {
                    fVar3.lHs.setImageBitmap(a);
                }
                fVar3.lHs.setOnClickListener(new c(this, aVar.aJm(), aVar.nwV, aVar.fuU, aVar.nwS));
                if (aVar.nwV != 2) {
                    fVar3.nxB.setVisibility(0);
                    fVar3.nxB.setText(bg.hb(aVar.nwS));
                    break;
                }
                fVar3.nxB.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.nxy.setText(this.fCi.getResources().getQuantityString(R.j.dst, aVar.nwR, new Object[]{Integer.valueOf(aVar.nwR)}));
        if (this.nxu.contains(aVar.aJl())) {
            fVar2.nxz.setSingleLine(false);
            fVar2.nxz.setEllipsize(null);
        } else {
            fVar2.nxz.setSingleLine(true);
            fVar2.nxz.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.nxz;
        Context context = this.fCi;
        ArrayList arrayList = new ArrayList();
        if (aVar.aJo() == null || aVar.aJo().equals("")) {
            charSequence = "";
        } else {
            List f;
            String[] split = aVar.aJo().split(";");
            if (split == null || split.length <= 0) {
                Object obj3 = arrayList;
            } else {
                f = bg.f(split);
            }
            if (f == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < f.size(); i2++) {
                    String eK = com.tencent.mm.u.n.eK((String) f.get(i2));
                    if (i2 == f.size() - 1) {
                        stringBuilder.append(eK);
                    } else {
                        stringBuilder.append(eK + ", ");
                    }
                }
                charSequence = stringBuilder.toString();
            }
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(context, charSequence, fVar2.nxz.getTextSize()));
        int textSize = (int) fVar2.nxz.getTextSize();
        String charSequence2 = fVar2.nxz.getText().toString();
        com.tencent.mm.bg.a.fromDPToPix(this.fCi, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) textSize);
        paint.measureText(charSequence2);
        fVar2.nxC.setOnClickListener(new b(this, aVar.aJl()));
        return view;
    }

    public final void zW(String str) {
        this.nxv = str;
        notifyDataSetChanged();
    }

    private static int jZ(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return ao.CTRL_INDEX;
    }
}

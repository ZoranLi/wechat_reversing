package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.k;
import java.util.HashMap;
import java.util.Map;

public final class c extends k<au> implements OnClickListener {
    private static Map<String, Integer> suf;
    private static Map<String, Integer> vQI;
    private LayoutInflater Du;
    public boolean hQa = false;
    String kwJ;
    protected com.tencent.mm.ah.a.a.c kwq = null;
    Context mContext;
    boolean sMK;
    private boolean sXW;
    long vPu;
    private final ImageGalleryGridUI vQG;
    boolean vQH = false;

    protected static class a {
        public CheckBox mfD;
        public View mfE;
        public ImageView pqE;
        public View vPC;
        public TextView vPD;
        public ImageView vPE;
        public View vPF;
        public ImageView vQL;
        public TextView vQM;
        public View vQN;

        protected a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        au auVar = new au();
        auVar.b(cursor);
        return auVar;
    }

    public c(Context context, au auVar, String str) {
        super(context, auVar);
        this.vQG = (ImageGalleryGridUI) context;
        this.kwJ = str;
        this.sMK = e.dr(this.kwJ);
        if (this.sMK) {
            this.vPu = auVar.field_bizChatId;
        }
        ap.yY();
        this.sXW = com.tencent.mm.u.c.isSDCardAvailable();
        this.Du = LayoutInflater.from(context);
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIQ = 1;
        aVar.hJk = true;
        aVar.hIS = com.tencent.mm.bg.a.dO(context) / 3;
        aVar.hIR = com.tencent.mm.bg.a.dO(context) / 3;
        aVar.hJe = R.e.aVr;
        this.kwq = aVar.Hg();
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void OK() {
        if (this.sMK) {
            ap.yY();
            setCursor(com.tencent.mm.u.c.wU().ad(this.kwJ, this.vPu));
            return;
        }
        ap.yY();
        setCursor(com.tencent.mm.u.c.wT().Am(this.kwJ));
    }

    protected final void OL() {
        if (this.sMK) {
            ap.yY();
            setCursor(com.tencent.mm.u.c.wU().ad(this.kwJ, this.vPu));
            return;
        }
        ap.yY();
        setCursor(com.tencent.mm.u.c.wT().Am(this.kwJ));
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Du.inflate(R.i.dfF, viewGroup, false);
            aVar = new a();
            aVar.pqE = (ImageView) view.findViewById(R.h.bVz);
            aVar.vPC = view.findViewById(R.h.cMm);
            aVar.vQM = (TextView) view.findViewById(R.h.bPE);
            aVar.vQM.setVisibility(8);
            aVar.vQL = (ImageView) view.findViewById(R.h.bPx);
            aVar.vPD = (TextView) view.findViewById(R.h.cMk);
            aVar.vPC.setVisibility(8);
            aVar.vPF = view.findViewById(R.h.cFs);
            aVar.vPF.setVisibility(8);
            aVar.vQN = view.findViewById(R.h.bPI);
            aVar.vQN.setVisibility(8);
            aVar.vPE = (ImageView) view.findViewById(R.h.bVC);
            aVar.mfD = (CheckBox) view.findViewById(R.h.cjp);
            aVar.mfE = view.findViewById(R.h.cjq);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.vPF.setVisibility(8);
        aVar.vPC.setVisibility(8);
        aVar.vQN.setVisibility(8);
        aVar.vQM.setVisibility(8);
        au auVar = (au) getItem(i);
        if (auVar != null) {
            if (!this.sXW) {
                aVar.pqE.setImageResource(R.g.bhP);
            } else if (this.vQG instanceof ImageGalleryGridUI) {
                String str = auVar.field_content;
                com.tencent.mm.t.f.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.B(str, auVar.field_reserved);
                }
                if (this.vQG.vQO == i) {
                    aVar.vPE.setVisibility(0);
                    if (!b.aU(auVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.vQL.setImageDrawable(this.vQG.getResources().getDrawable(f(aVar2)));
                        }
                        n.GW().a(bc(auVar), aVar.pqE, this.kwq, new i(this) {
                            final /* synthetic */ c vQJ;

                            {
                                this.vQJ = r1;
                            }

                            public final void a(String str, Bitmap bitmap, Object... objArr) {
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 vQK;

                                    {
                                        this.vQK = r1;
                                    }

                                    public final void run() {
                                    }
                                });
                            }
                        });
                    } else {
                        aVar.vQL.setImageDrawable(this.vQG.getResources().getDrawable(f(aVar2)));
                        aVar.pqE.setImageResource(g(aVar2));
                    }
                } else {
                    aVar.vPE.setVisibility(0);
                    aVar.vPE.setBackgroundResource(R.g.bfR);
                    if (!b.aU(auVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.vQL.setImageDrawable(this.vQG.getResources().getDrawable(f(aVar2)));
                        }
                        n.GW().a(bc(auVar), aVar.pqE, this.kwq);
                    } else {
                        aVar.vQL.setImageDrawable(this.vQG.getResources().getDrawable(f(aVar2)));
                        aVar.pqE.setImageResource(g(aVar2));
                    }
                }
                aVar.pqE.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.pqE.getMeasuredWidth();
                int measuredHeight = aVar.pqE.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.vPE.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.vPE.setLayoutParams(layoutParams);
                }
                if (b.aS(auVar)) {
                    if (aVar != null) {
                        aVar.vPC.setVisibility(0);
                        r bl = i.bl(auVar);
                        if (bl != null) {
                            aVar.vPD.setText(u.hb(bl.iap));
                        }
                    }
                } else if (b.aT(auVar)) {
                    aVar.vPF.setVisibility(0);
                } else if (b.aU(auVar) && aVar != null) {
                    aVar.vQN.setVisibility(0);
                    aVar.vQM.setVisibility(0);
                    if (aVar2 != null) {
                        w.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", u.mz(aVar2.title));
                        if (aVar2.type != 24) {
                            aVar.vQM.setText(h.b(this.mContext, u.mz(aVar2.title), aVar.vQM.getTextSize()));
                        } else {
                            aVar.vQM.setText(h.b(aVar.vQM.getContext(), aVar.vQM.getContext().getString(R.l.ejP), aVar.vQM.getTextSize()));
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
            }
            aVar.mfD.setChecked(a.vRJ.bj(auVar));
            aVar.mfD.setTag(auVar);
            aVar.mfE.setTag(aVar);
            aVar.mfE.setOnClickListener(this);
            if (a.vRJ.vRH) {
                aVar.mfD.setVisibility(0);
                aVar.mfE.setVisibility(0);
                aVar.vPE.setVisibility(0);
            } else {
                aVar.mfD.setVisibility(8);
                aVar.mfE.setVisibility(8);
                aVar.vPE.setVisibility(8);
            }
        }
        return view;
    }

    private static int f(com.tencent.mm.t.f.a aVar) {
        if (aVar == null) {
            w.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.dto);
            return R.k.dtp;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return R.k.dtq;
        } else {
            if (aVar.type == 3) {
                return R.k.dth;
            }
            if (aVar.type != 6 || !suf.containsKey(u.mz(aVar.hhr))) {
                return R.k.dtp;
            }
            w.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + suf.get(u.mz(aVar.hhr)));
            return ((Integer) suf.get(u.mz(aVar.hhr))).intValue();
        }
    }

    private static int g(com.tencent.mm.t.f.a aVar) {
        if (aVar == null) {
            w.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.aSO);
            return R.e.aSO;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return R.e.aSP;
        } else {
            if (aVar.type != 6 || !vQI.containsKey(u.mz(aVar.hhr))) {
                return R.e.aSO;
            }
            w.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + vQI.get(u.mz(aVar.hhr)));
            return ((Integer) vQI.get(u.mz(aVar.hhr))).intValue();
        }
    }

    private static String bc(au auVar) {
        String lw;
        if (auVar.bMl() || auVar.bMm()) {
            o.KV();
            lw = s.lw(auVar.field_imgPath);
        } else {
            lw = n.GS().b(auVar.field_imgPath, false, false);
            if (!(u.mA(lw) || lw.endsWith("hd") || !FileOp.aO(lw + "hd"))) {
                lw = lw + "hd";
            }
        }
        w.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", lw);
        if (!auVar.bMp()) {
            return lw;
        }
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
        String str = null;
        if (!(ek == null || ek.fCW == null || ek.fCW.length() <= 0)) {
            b LW = an.abL().LW(ek.fCW);
            if (LW != null) {
                str = LW.field_fileFullPath;
            }
        }
        if (str != null) {
            return str;
        }
        return lw;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.vQH = false;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.mfD != null) {
            au auVar = (au) aVar.mfD.getTag();
            if (auVar != null) {
                g gVar = a.vRJ;
                if (gVar.bj(auVar)) {
                    gVar.bi(auVar);
                } else {
                    gVar.bh(auVar);
                }
                if (a.vRJ.bj(auVar)) {
                    aVar.mfD.setChecked(true);
                    aVar.vPE.setBackgroundResource(R.e.aUk);
                } else {
                    aVar.mfD.setChecked(false);
                    aVar.vPE.setBackgroundResource(R.g.bfR);
                }
                if (!this.hQa && a.vRJ.vQg.size() > 1) {
                    g.oUh.a(219, 20, 1, true);
                    this.hQa = true;
                }
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        suf = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dts));
        suf.put("m4v", Integer.valueOf(R.k.dts));
        suf.put("vob", Integer.valueOf(R.k.dts));
        suf.put("mpeg", Integer.valueOf(R.k.dts));
        suf.put("mpe", Integer.valueOf(R.k.dts));
        suf.put("asx", Integer.valueOf(R.k.dts));
        suf.put("asf", Integer.valueOf(R.k.dts));
        suf.put("f4v", Integer.valueOf(R.k.dts));
        suf.put("flv", Integer.valueOf(R.k.dts));
        suf.put("mkv", Integer.valueOf(R.k.dts));
        suf.put("wmv", Integer.valueOf(R.k.dts));
        suf.put("wm", Integer.valueOf(R.k.dts));
        suf.put("3gp", Integer.valueOf(R.k.dts));
        suf.put("mp4", Integer.valueOf(R.k.dts));
        suf.put("rmvb", Integer.valueOf(R.k.dts));
        suf.put("rm", Integer.valueOf(R.k.dts));
        suf.put("ra", Integer.valueOf(R.k.dts));
        suf.put("ram", Integer.valueOf(R.k.dts));
        suf.put("mp3pro", Integer.valueOf(R.k.dth));
        suf.put("vqf", Integer.valueOf(R.k.dth));
        suf.put("cd", Integer.valueOf(R.k.dth));
        suf.put("md", Integer.valueOf(R.k.dth));
        suf.put("mod", Integer.valueOf(R.k.dth));
        suf.put("vorbis", Integer.valueOf(R.k.dth));
        suf.put("au", Integer.valueOf(R.k.dth));
        suf.put("amr", Integer.valueOf(R.k.dth));
        suf.put("silk", Integer.valueOf(R.k.dth));
        suf.put("wma", Integer.valueOf(R.k.dth));
        suf.put("mmf", Integer.valueOf(R.k.dth));
        suf.put("mid", Integer.valueOf(R.k.dth));
        suf.put("midi", Integer.valueOf(R.k.dth));
        suf.put("mp3", Integer.valueOf(R.k.dth));
        suf.put("aac", Integer.valueOf(R.k.dth));
        suf.put("ape", Integer.valueOf(R.k.dth));
        suf.put("aiff", Integer.valueOf(R.k.dth));
        suf.put("aif", Integer.valueOf(R.k.dth));
        suf.put("doc", Integer.valueOf(R.k.dtw));
        suf.put("docx", Integer.valueOf(R.k.dtw));
        suf.put("ppt", Integer.valueOf(R.k.dtl));
        suf.put("pptx", Integer.valueOf(R.k.dtl));
        suf.put("xls", Integer.valueOf(R.k.dtd));
        suf.put("xlsx", Integer.valueOf(R.k.dtd));
        suf.put("pdf", Integer.valueOf(R.k.dtj));
        suf.put("unknown", Integer.valueOf(R.k.dtp));
        hashMap = new HashMap();
        vQI = hashMap;
        hashMap.put("doc", Integer.valueOf(R.e.aSK));
        vQI.put("docx", Integer.valueOf(R.e.aSK));
        vQI.put("ppt", Integer.valueOf(R.e.aSN));
        vQI.put("pptx", Integer.valueOf(R.e.aSN));
        vQI.put("xls", Integer.valueOf(R.e.aSQ));
        vQI.put("xlsx", Integer.valueOf(R.e.aSQ));
        vQI.put("pdf", Integer.valueOf(R.e.aSM));
        vQI.put("unknown", Integer.valueOf(R.e.aSO));
        vQI.put("mp3pro", Integer.valueOf(R.e.aSL));
        vQI.put("vqf", Integer.valueOf(R.e.aSL));
        vQI.put("cd", Integer.valueOf(R.e.aSL));
        vQI.put("md", Integer.valueOf(R.e.aSL));
        vQI.put("mod", Integer.valueOf(R.e.aSL));
        vQI.put("vorbis", Integer.valueOf(R.e.aSL));
        vQI.put("au", Integer.valueOf(R.e.aSL));
        vQI.put("amr", Integer.valueOf(R.e.aSL));
        vQI.put("silk", Integer.valueOf(R.e.aSL));
        vQI.put("wma", Integer.valueOf(R.e.aSL));
        vQI.put("mmf", Integer.valueOf(R.e.aSL));
        vQI.put("mid", Integer.valueOf(R.e.aSL));
        vQI.put("midi", Integer.valueOf(R.e.aSL));
        vQI.put("mp3", Integer.valueOf(R.e.aSL));
        vQI.put("aac", Integer.valueOf(R.e.aSL));
        vQI.put("ape", Integer.valueOf(R.e.aSL));
        vQI.put("aiff", Integer.valueOf(R.e.aSL));
        vQI.put("aif", Integer.valueOf(R.e.aSL));
    }
}

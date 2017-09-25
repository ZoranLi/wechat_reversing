package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Date;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a {
    public List<c> jkZ = null;
    private String kwJ;
    private com.tencent.mm.ah.a.a.c kwq = null;
    Context mContext;
    boolean sMK = false;
    private boolean sXW = true;
    long vPu;
    public boolean vPv;
    public b vPw;
    public boolean vPx = false;

    public interface b {
        void a(boolean z, c cVar, int i);
    }

    public static class c {
        public au fTk;
        public long hTv;
        public String imagePath;
        boolean nAt;
        public int type = 0;
        public a vPz = new a(this);

        class a {
            public com.tencent.mm.t.f.a fSU;
            public String vPA;
            final /* synthetic */ c vPB;

            a(c cVar) {
                this.vPB = cVar;
            }
        }

        public final boolean equals(Object obj) {
            if (this.fTk == null || !(obj instanceof au) || obj == null) {
                return super.equals(obj);
            }
            return this.fTk.field_msgId == ((au) obj).field_msgId;
        }

        public c(au auVar) {
            String lw;
            this.fTk = auVar;
            if (auVar.bMl() || auVar.bMm()) {
                this.nAt = true;
                o.KV();
                lw = s.lw(auVar.field_imgPath);
                r lH = t.lH(auVar.field_imgPath);
                if (lH != null) {
                    this.vPz.vPA = bg.hb(lH.iap);
                }
                this.vPz.fSU = com.tencent.mm.t.f.a.B(auVar.field_content, auVar.field_reserved);
            } else {
                lw = n.GS().b(auVar.field_imgPath, false, false);
                if (!(bg.mA(lw) || lw.endsWith("hd") || !FileOp.aO(lw + "hd"))) {
                    lw = lw + "hd";
                }
            }
            if (auVar.bMp()) {
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
                String str = null;
                if (!(ek == null || ek.fCW == null || ek.fCW.length() <= 0)) {
                    com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                    if (LW != null) {
                        str = LW.field_fileFullPath;
                    }
                }
                if (str != null) {
                    lw = str;
                }
            }
            this.imagePath = lw;
            this.hTv = auVar.field_createTime;
        }

        public c(long j) {
            this.hTv = j;
            this.type = Integer.MAX_VALUE;
        }
    }

    public class a extends RecyclerView.t {
        TextView ioY;
        ProgressBar jKM;
        final /* synthetic */ a vPy;

        public a(a aVar, View view) {
            this.vPy = aVar;
            super(view);
            this.ioY = (TextView) view.findViewById(R.h.bHK);
            this.jKM = (ProgressBar) view.findViewById(R.h.cbI);
        }
    }

    public class d extends RecyclerView.t {
        CheckBox mfD;
        View mfE;
        ImageView pqE;
        View vPC;
        TextView vPD;
        ImageView vPE;
        View vPF;
        final /* synthetic */ a vPy;

        public d(final a aVar, View view) {
            this.vPy = aVar;
            super(view);
            this.pqE = (ImageView) view.findViewById(R.h.bVz);
            this.vPC = view.findViewById(R.h.cMm);
            this.vPF = view.findViewById(R.h.cFs);
            this.vPD = (TextView) view.findViewById(R.h.cMk);
            this.vPE = (ImageView) view.findViewById(R.h.bVC);
            this.mfD = (CheckBox) view.findViewById(R.h.cjp);
            this.mfE = view.findViewById(R.h.cjq);
            this.mfE.setVisibility(8);
            this.mfD.setVisibility(8);
            this.vPC.setVisibility(8);
            this.vPD.setVisibility(8);
            this.vPF.setVisibility(8);
            this.pqE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d vPH;

                public final void onClick(View view) {
                    c Bf = this.vPH.vPy.Bf(((Integer) view.getTag()).intValue());
                    if (Bf != null) {
                        a aVar = this.vPH.vPy;
                        Intent intent = new Intent();
                        intent.putExtra("key_biz_chat_id", aVar.vPu);
                        intent.putExtra("key_is_biz_chat", aVar.sMK);
                        if (Bf == null) {
                            w.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                            return;
                        }
                        ce ceVar = Bf.fTk;
                        if (ceVar == null) {
                            w.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                            return;
                        }
                        int width;
                        int height;
                        int i = aVar.mContext.getResources().getConfiguration().orientation;
                        int[] iArr = new int[2];
                        if (view != null) {
                            width = view.getWidth();
                            height = view.getHeight();
                            view.getLocationInWindow(iArr);
                        } else {
                            height = 0;
                            width = 0;
                        }
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.putExtra("img_gallery_msg_id", ceVar.field_msgId).putExtra("img_gallery_msg_svr_id", ceVar.field_msgSvrId).putExtra("img_gallery_talker", ceVar.field_talker).putExtra("img_gallery_chatroom_name", ceVar.field_talker).putExtra("img_gallery_orientation", i);
                        if (view != null) {
                            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                        } else {
                            intent.putExtra("img_gallery_back_from_grid", true);
                        }
                        com.tencent.mm.bb.d.a(aVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
                        ((Activity) aVar.mContext).overridePendingTransition(0, 0);
                    }
                }
            });
            this.mfE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d vPH;

                public final void onClick(View view) {
                    boolean z = !this.vPH.mfD.isChecked();
                    if (a.vRJ.vQg.size() < 9) {
                        this.vPH.mfD.setChecked(z);
                        if (z) {
                            this.vPH.vPE.setVisibility(0);
                        } else {
                            this.vPH.vPE.setVisibility(8);
                        }
                    } else if (!z) {
                        this.vPH.mfD.setChecked(false);
                    }
                    if (this.vPH.vPy.vPw != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        this.vPH.vPy.vPw.a(z, this.vPH.vPy.Bf(intValue), intValue);
                    }
                }
            });
        }
    }

    public a(Context context, List<c> list, String str) {
        this.jkZ = list;
        this.kwJ = str;
        ap.yY();
        this.sXW = com.tencent.mm.u.c.isSDCardAvailable();
        this.mContext = context;
        ad(context, 4);
    }

    public a(Context context, List<c> list, String str, long j) {
        this.jkZ = list;
        this.vPu = j;
        this.kwJ = str;
        ap.yY();
        this.sXW = com.tencent.mm.u.c.isSDCardAvailable();
        this.sMK = true;
        this.mContext = context;
        ad(context, 4);
    }

    private void ad(Context context, int i) {
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIQ = 1;
        aVar.hJk = true;
        aVar.hIS = com.tencent.mm.bg.a.dO(context) / 4;
        aVar.hIR = com.tencent.mm.bg.a.dO(context) / 4;
        aVar.hJe = R.e.aVr;
        this.kwq = aVar.Hg();
    }

    public final int getItemViewType(int i) {
        return Bf(i).type;
    }

    public final RecyclerView.t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dea, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dfF, viewGroup, false));
    }

    public final void a(RecyclerView.t tVar, int i, List list) {
        if (list == null || list.size() <= 0 || !(tVar instanceof d)) {
            super.a(tVar, i, list);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) tVar).mfD.setVisibility(0);
            ((d) tVar).mfE.setVisibility(0);
        } else {
            ((d) tVar).mfD.setChecked(false);
            ((d) tVar).mfD.setVisibility(8);
            ((d) tVar).mfE.setVisibility(8);
        }
    }

    public final void a(RecyclerView.t tVar, int i) {
        if (this.sXW) {
            c Bf = Bf(i);
            if (tVar.abi != Integer.MAX_VALUE) {
                ((d) tVar).pqE.setTag(Integer.valueOf(i));
                ((d) tVar).mfE.setTag(Integer.valueOf(i));
                n.GW().a(Bf.imagePath, ((d) tVar).pqE, this.kwq);
                if (Bf.nAt) {
                    ((d) tVar).vPC.setVisibility(0);
                    ((d) tVar).vPD.setVisibility(0);
                    ((d) tVar).vPD.setText(bg.ap(Bf.vPz.vPA, ""));
                } else {
                    ((d) tVar).vPD.setVisibility(8);
                    ((d) tVar).vPC.setVisibility(8);
                }
                if (this.vPx) {
                    ((d) tVar).mfE.setVisibility(0);
                    ((d) tVar).mfD.setVisibility(0);
                    if (a.vRJ.bj(Bf.fTk)) {
                        ((d) tVar).vPE.setVisibility(0);
                        ((d) tVar).mfD.setChecked(true);
                        return;
                    }
                    ((d) tVar).vPE.setVisibility(8);
                    ((d) tVar).mfD.setChecked(false);
                    return;
                }
                ((d) tVar).mfE.setVisibility(8);
                ((d) tVar).mfD.setVisibility(8);
                return;
            } else if (i == getItemCount() - 1 || eP(Bf(i + 1).hTv) != eP(Bf.hTv)) {
                ((a) tVar).ioY.setVisibility(8);
                return;
            } else {
                ((a) tVar).ioY.setVisibility(0);
                ((a) tVar).ioY.setText(eO(Bf.hTv));
                if (this.vPv) {
                    ((a) tVar).jKM.setVisibility(0);
                    return;
                } else {
                    ((a) tVar).jKM.setVisibility(8);
                    return;
                }
            }
        }
        w.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.sXW));
    }

    public final String eO(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(j), this.mContext);
    }

    private static long eP(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(j));
    }

    public final int getItemCount() {
        return this.jkZ.size();
    }

    public final c Bf(int i) {
        return (c) this.jkZ.get(i);
    }
}

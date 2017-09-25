package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    Context context;
    boolean fJm = false;
    String gKJ;
    private Dialog mnu;
    b qBB;
    a qBC;
    private boolean qBD = false;
    private Map<Integer, View> qBE = new HashMap();
    private String qBF = "";
    Bitmap qBG = null;
    int type;
    String userName;

    public interface a {
        boolean bkm();

        boolean dK(long j);
    }

    class b {
        ImageView ioV;
        TextView jML;
        final /* synthetic */ SnsHeader qBH;
        ImageView qBL;
        LinearLayout qBM;
        LinearLayout qBN;
        TextView qpz;

        b(SnsHeader snsHeader) {
            this.qBH = snsHeader;
        }
    }

    class c implements Comparator<m> {
        final /* synthetic */ SnsHeader qBH;

        c(SnsHeader snsHeader) {
            this.qBH = snsHeader;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            m mVar = (m) obj;
            m mVar2 = (m) obj2;
            if (mVar.field_createTime == mVar2.field_createTime) {
                return 0;
            }
            return mVar.field_createTime > mVar2.field_createTime ? -1 : 1;
        }
    }

    static /* synthetic */ boolean a(SnsHeader snsHeader, long j) {
        if (snsHeader.qBC != null) {
            snsHeader.qBC.dK(j);
        }
        return true;
    }

    public SnsHeader(Context context) {
        super(context);
        init(context);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(final Context context) {
        this.context = context;
        View inflate = r.eC(context).inflate(g.pHC, this, true);
        this.qBB = new b(this);
        this.qBB.jML = (TextView) inflate.findViewById(f.cof);
        this.qBB.ioV = (ImageView) inflate.findViewById(f.bqM);
        this.qBB.qpz = (TextView) inflate.findViewById(f.pDQ);
        this.qBB.qBL = (ImageView) inflate.findViewById(f.pEv);
        this.qBB.qBM = (LinearLayout) inflate.findViewById(f.pDO);
        this.qBB.qBN = (LinearLayout) inflate.findViewById(f.pEM);
        this.qBB.qBL.setContentDescription(context.getString(j.pKv));
        this.qBB.qBL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsHeader qBH;

            public final void onClick(View view) {
                w.d("MicroMsg.SnsHeader", "change backGround");
                if (this.qBH.mnu == null || !this.qBH.mnu.isShowing()) {
                    String d;
                    if (this.qBH.qBC != null) {
                        this.qBH.qBC.bkm();
                    }
                    if (this.qBH.type == 1) {
                        d = this.qBH.gKJ;
                    } else {
                        d = this.qBH.userName;
                    }
                    k Gk = ae.beO().Gk(d);
                    final long j = Gk.field_snsBgId;
                    if (this.qBH.fJm || j != 0) {
                        String[] strArr;
                        this.qBH.qBD = Gk.bhn();
                        if (this.qBH.type == 1 || this.qBH.gKJ.trim().equals(this.qBH.userName.trim())) {
                            strArr = new String[]{context.getString(j.pMS)};
                            this.qBH.qBD = false;
                        } else {
                            strArr = this.qBH.qBD ? new String[0] : new String[]{context.getString(j.pLL)};
                        }
                        String string = this.qBH.qBD ? context.getString(j.pMo) : "";
                        if (this.qBH.qBD) {
                            context.getString(j.dHT);
                        } else {
                            context.getString(j.dGs);
                        }
                        this.qBH.mnu = com.tencent.mm.ui.base.g.a(this.qBH.getContext(), string, strArr, new com.tencent.mm.ui.base.g.c(this) {
                            final /* synthetic */ AnonymousClass1 qBJ;

                            public final void hq(int i) {
                                switch (i) {
                                    case 0:
                                        if (!this.qBJ.qBH.qBD) {
                                            SnsHeader.a(this.qBJ.qBH, j);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                }
            }
        });
        this.qBB.ioV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsHeader qBH;

            public final void onClick(View view) {
                af Rc = ae.bez().Rc(this.qBH.userName);
                if (Rc == null || !(com.tencent.mm.j.a.ez(Rc.field_type) || this.qBH.fJm)) {
                    Intent intent = ((Activity) context).getIntent();
                    intent.putExtra("Contact_User", this.qBH.userName);
                    com.tencent.mm.plugin.sns.c.a.imv.d(intent, context);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", this.qBH.userName);
                if (this.qBH.userName != null && this.qBH.userName.length() > 0) {
                    com.tencent.mm.plugin.sns.c.a.imv.d(intent, context);
                }
            }
        });
    }

    public final void bkk() {
        Bitmap a;
        String str = this.userName;
        if (this.type == 1) {
            str = this.gKJ;
        }
        String accSnsPath = ae.getAccSnsPath();
        w.d("MicroMsg.SnsHeader", "MagicAsyncTask " + str);
        k Gk = ae.beO().Gk(str);
        String str2 = Gk.field_bgId;
        w.d("MicroMsg.SnsHeader", "showName " + str + " get bgId : " + str2 + "  olderBgId：　" + Gk.field_older_bgId);
        String ED = i.ED(str2);
        String str3 = str + "bg_";
        String str4 = str + "tbg_";
        String du = am.du(accSnsPath, str);
        FileOp.kl(du);
        if ((Gk.field_local_flag & 1) > 0) {
            w.d("MicroMsg.SnsHeader", "bg is change");
            ae.beO().Gj(str);
            if (FileOp.aO(am.du(accSnsPath, str) + str3)) {
                FileOp.deleteFile(am.du(accSnsPath, str) + str4);
                FileOp.h(am.du(accSnsPath, str), str3, str4);
            }
            Gk.field_local_flag &= -2;
            ae.beO().c(Gk);
        }
        if (FileOp.aO(am.du(ae.getAccSnsPath(), str2) + ED) && !FileOp.aO(am.du(accSnsPath, str) + str3)) {
            FileOp.p(am.du(accSnsPath, str2) + ED, am.du(accSnsPath, str) + str3);
            w.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        accSnsPath = Gk.field_bgUrl;
        if (str2 != null) {
            ae.beI();
            String str5 = du + str3;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str5, accSnsPath, str2, true, an.uJM);
            w.d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                FileOp.deleteFile(du + str3);
            }
        } else {
            a = null;
        }
        if (a == null && str2 != null) {
            ae.beI();
            str5 = du + str4;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str5, accSnsPath, str2, false, an.uJM);
        }
        if (this.qBB.qBL != null) {
            this.qBB.qBL.setImageBitmap(a);
            if (a != null) {
                this.qBB.qBL.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.qBG == null || this.qBG.isRecycled()) {
                        w.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.qBG = d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.qBB.qBL.setBackgroundDrawable(new BitmapDrawable(this.qBG));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.qBB.qBM.setVisibility(8);
        if (a == null && (this.type == 1 || this.gKJ.equals(str))) {
            this.qBB.qBM.setVisibility(0);
        }
        this.qBD = Gk.bhn();
    }

    public final boolean bkl() {
        if (this.qBB.qBN == null) {
            return false;
        }
        int i;
        List bfe = ai.bfe();
        List linkedList = new LinkedList();
        for (i = 0; i < bfe.size(); i++) {
            m mVar = (m) bfe.get(i);
            try {
                if (((ali) new ali().aD(mVar.field_postBuf)).tPW) {
                }
            } catch (Exception e) {
            }
            linkedList.add(mVar);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((ali) new ali().aD(((m) linkedList.get(i)).field_postBuf)).tPW) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((m) linkedList.get(i)).bhy() + " ";
            i++;
            str = str2;
        }
        w.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[]{Integer.valueOf(linkedList.size()), str, this.qBF});
        if (!str.equals(this.qBF)) {
            this.qBF = str;
            this.qBB.qBN.removeAllViews();
            this.qBB.qBN.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new c(this));
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View view;
                int i3 = ((m) linkedList.get(i2)).qnk;
                i = linkedList.size();
                if (!this.qBE.containsKey(Integer.valueOf(i3)) || this.qBE.get(Integer.valueOf(i3)) == null) {
                    linearLayout = (LinearLayout) r.eC(this.context).inflate(g.pGH, null);
                    linearLayout.getChildAt(0).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsHeader qBH;

                        public final void onClick(View view) {
                            if (view.getTag() instanceof String) {
                                String str = (String) view.getTag();
                                w.i("MicroMsg.SnsHeader", "sns Header localId " + str);
                                m Gg = ae.beL().Gg(str);
                                if (this.qBH.context != null && Gg != null) {
                                    Intent intent = new Intent();
                                    intent.setClass(this.qBH.context, SnsCommentDetailUI.class);
                                    if (Gg == null || Gg.field_userName == null || Gg.field_userName.equals("")) {
                                        w.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                                        return;
                                    }
                                    intent.putExtra("INTENT_TALKER", Gg.field_userName);
                                    intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                                    intent.putExtra("INTENT_FROMGALLERY", true);
                                    com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(726);
                                    gz.gC(i).gC(i2).gC(Gg.field_createTime);
                                    gz.JE();
                                    this.qBH.context.startActivity(intent);
                                    try {
                                        ali com_tencent_mm_protocal_c_ali = (ali) new ali().aD(Gg.field_postBuf);
                                        if (com_tencent_mm_protocal_c_ali.tPN == bh.CTRL_INDEX || com_tencent_mm_protocal_c_ali.tPN == h.CTRL_INDEX || com_tencent_mm_protocal_c_ali.tPN != com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX) {
                                            com_tencent_mm_protocal_c_ali.tPW = true;
                                            Gg.field_postBuf = com_tencent_mm_protocal_c_ali.toByteArray();
                                            ae.beL().b(Gg.qnk, Gg);
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        }
                    });
                    this.qBE.put(Integer.valueOf(i3), linearLayout);
                } else {
                    view = (View) this.qBE.get(Integer.valueOf(i3));
                }
                linearLayout = (LinearLayout) view;
                linearLayout.getChildAt(0).setTag(((m) linkedList.get(i2)).bhy());
                TextView textView = (TextView) linearLayout.findViewById(f.pFx);
                if (((m) linkedList.get(i2)).field_type == 15) {
                    textView.setText(j.pMg);
                } else {
                    textView.setTag(Integer.valueOf(j.pMb));
                }
                this.qBB.qBN.addView(linearLayout);
            }
            if (linkedList.size() > 0) {
                return true;
            }
            return false;
        } else if (linkedList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}

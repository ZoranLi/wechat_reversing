package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.d;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;

public final class h extends a implements a, aj.a, d.a {
    private d iXd;
    private HashMap<String, i.a> vRK;
    private boolean vRL;

    public h(b bVar) {
        super(bVar);
        this.vRL = false;
        this.vRL = false;
        this.vRK = new HashMap();
        o.KV().a(this, Looper.getMainLooper());
        this.iXd = new d();
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        o.KV();
        Bitmap c = b.c(s.lw(auVar.field_imgPath), 1.0f);
        if (this.vRK != null) {
            this.vRK.put(auVar.field_imgPath, new i.a(auVar, i));
        }
        a(jVar, false);
        ((View) jVar.bXw().vTd).setVisibility(8);
        jVar.bXw().vTe.setImageBitmap(c);
        jVar.bXw().vTe.setVisibility(0);
        jVar.bXw().vTh.setVisibility(8);
        r lH = t.lH(auVar.field_imgPath);
        jVar.vTh.setTag(lH);
        bdu com_tencent_mm_protocal_c_bdu = lH == null ? null : lH.iay;
        if (com_tencent_mm_protocal_c_bdu == null) {
            jVar.lKS.setVisibility(8);
        } else if (u.mA(com_tencent_mm_protocal_c_bdu.hjD)) {
            w.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            CharSequence charSequence = com_tencent_mm_protocal_c_bdu.hjG;
            String str = com_tencent_mm_protocal_c_bdu.hjH;
            if (bg.mA(charSequence) || bg.mA(str)) {
                jVar.lKS.setVisibility(8);
            } else {
                jVar.lKS.setText(charSequence);
                jVar.lKS.setVisibility(0);
                jVar.lKS.setTag(auVar);
            }
        } else {
            jVar.lKS.setVisibility(0);
            jVar.lKS.setText(this.vPU.vPV.getString(R.l.eWK, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdu.tyZ)}));
            String string = this.vPU.vPV.getString(R.l.eWK);
            if (com_tencent_mm_protocal_c_bdu.tyZ / 60 > 0) {
                string = string + this.vPU.vPV.getString(R.l.eWM, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdu.tyZ / 60)});
            }
            if (com_tencent_mm_protocal_c_bdu.tyZ % 60 > 0) {
                string = string + this.vPU.vPV.getString(R.l.eWN, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdu.tyZ % 60)});
            }
            jVar.lKS.setText(string + this.vPU.vPV.getString(R.l.eWL));
            jVar.lKS.setTag(auVar);
        }
        if (jVar.bXw().vTd instanceof VideoSightView) {
            m.a(jVar.lKS, (VideoSightView) jVar.bXw().vTd);
        }
        return true;
    }

    public final void bWS() {
        SparseArray sparseArray = this.vPU.vnM;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.vTc != null && jVar.bXw().vTc.getVisibility() == 0) {
                    jVar.bXw().vTd.a(null);
                    if (((View) jVar.bXw().vTd).getVisibility() == 0 && jVar != null) {
                        a(jVar, false);
                        if (jVar.bXw().vTd != null) {
                            jVar.bXw().vTd.stop();
                        }
                        w.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.iXd.aS(false);
                        this.vPU.vPV.uSU.uTo.getWindow().clearFlags(FileUtils.S_IWUSR);
                    }
                }
            }
        }
    }

    public final void BB(int i) {
        au Bm = this.vPU.Bm(i);
        j Bk = Bk(i);
        if (Bm != null && Bk != null) {
            r lH = t.lH(Bm.field_imgPath);
            if (lH != null) {
                if (Bm.field_isSend == 0) {
                    if (lH.status == 113 || lH.status == 111 || lH.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        a(lH, Bk);
                        return;
                    } else if (lH.status == 198) {
                        a(lH, Bk);
                        return;
                    }
                }
                a(Bm, Bk);
            }
        }
    }

    private void a(r rVar, j jVar) {
        if (rVar != null) {
            t.lF(rVar.getFileName());
            jVar.bXw().vTg.setVisibility(0);
            jVar.bXw().vTg.setProgress(t.f(rVar));
            o.KV().a(this, Looper.getMainLooper());
        }
    }

    private void a(au auVar, final j jVar) {
        if (!this.vRL) {
            jVar.bXw().vTh.setVisibility(8);
            o.KV();
            String lv = s.lv(auVar.field_imgPath);
            if (auVar.bMt()) {
                Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
            } else if (lv == null || !e.aO(lv)) {
                Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
            } else {
                this.vPU.vPV.uSU.uTo.getWindow().addFlags(FileUtils.S_IWUSR);
                Boolean bool = (Boolean) jVar.vTb.get(lv);
                if (bool == null || !bool.booleanValue()) {
                    ((View) jVar.bXw().vTd).setTag(lv);
                    jVar.bXw().vTf.setVisibility(8);
                    jVar.bXw().vTd.stop();
                    if (this.vPU.vPV.eS(auVar.field_msgId) == 3) {
                        jVar.bXw().vTd.bQ(true);
                    } else {
                        jVar.bXw().vTd.bQ(false);
                    }
                    jVar.bXw().vTd.setVideoPath(lv);
                    if (jVar.bXw().vTd.i(this.vPU.vPV.uSU.uTo, false)) {
                        ((View) jVar.bXw().vTd).setVisibility(0);
                        jVar.bXw().vTe.setVisibility(8);
                    } else {
                        jVar.bXw().vTf.setVisibility(0);
                        jVar.bXw().vTf.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ h vRM;

                            public final void onClick(View view) {
                                jVar.bXw().vTd.i(this.vRM.vPU.vPV.uSU.uTo, true);
                            }
                        });
                        ((View) jVar.bXw().vTd).setVisibility(8);
                        jVar.bXw().vTe.setVisibility(0);
                    }
                    w.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                    this.iXd.a(this);
                }
                ((View) jVar.bXw().vTd).setVisibility(0);
            }
        }
    }

    private static void a(j jVar, boolean z) {
        if (jVar != null) {
            jVar.bXw().vTg.setVisibility(8);
            if (z) {
                jVar.bXw().vTe.setVisibility(8);
                ((View) jVar.bXw().vTd).setVisibility(0);
                return;
            }
            jVar.bXw().vTe.setVisibility(0);
            ((View) jVar.bXw().vTd).setVisibility(8);
        }
    }

    public final boolean oQ() {
        if (this.vPU != null) {
            j bWL = this.vPU.bWL();
            if (!(bWL == null || bWL.vTc == null || bWL.bXw().vTc.getVisibility() != 0)) {
                a(bWL, true);
            }
        }
        return false;
    }

    private boolean a(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        o.KV().a((a) this);
        if (this.vPU.vPV.bXf() == aVar.pos) {
            j Bk = Bk(aVar.pos);
            if (Bk != null) {
                Bk.bXw().vTg.setVisibility(8);
            }
            return true;
        }
        this.vPU.Bt(aVar.pos);
        return false;
    }

    public final void detach() {
        bWS();
        this.vPU.vPV.uSU.uTo.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.vRL = true;
        super.detach();
        this.vRK.clear();
        this.vRK = null;
        o.KV().a((a) this);
        w.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.iXd.aS(true);
    }

    public final void a(a.a aVar) {
        String str = aVar.fyF;
        if (!u.mA(str) && this.vRK != null) {
            i.a aVar2 = (i.a) this.vRK.get(str);
            if (aVar2 != null) {
                au auVar = aVar2.fCZ;
                if (auVar != null && auVar.field_imgPath != null && auVar.field_imgPath.equals(str)) {
                    r lH = t.lH(auVar.field_imgPath);
                    if (lH == null) {
                        return;
                    }
                    if (!auVar.bMt() && lH.status != 198) {
                        int f = t.f(lH);
                        j Bk = Bk(aVar2.pos);
                        if (this.vPU.vPV.bXf() == aVar2.pos && Bk != null) {
                            Bk.bXw().vTg.setVisibility(0);
                            Bk.bXw().vTg.setProgress(f);
                        } else if (Bk == null) {
                            return;
                        }
                        if (f >= Bk.bXx().vTg.wvs && a(aVar2)) {
                            a(auVar, Bk);
                        }
                    } else if (a(aVar2)) {
                        Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
                    }
                }
            }
        }
    }
}

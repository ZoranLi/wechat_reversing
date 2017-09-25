package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.m;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int qzd = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        KC();
    }

    public void onDestroy() {
        int max;
        if (this.qzb != null) {
            this.qzb.bkp();
            this.qzb.onDestroy();
        }
        getWindow().clearFlags(FileUtils.S_IWUSR);
        al.a beB = ae.beB();
        String str = this.userName;
        if (beB.pXi.containsKey(str)) {
            max = Math.max(((Integer) beB.pXi.get(str)).intValue() - 1, 0);
            beB.pXi.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            beB.pXh.remove(str);
        }
        ae.beI().Q(this);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected final int getLayoutId() {
        return g.pHz;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.qyY.qtQ);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void KC() {
        List arrayList;
        an bLT;
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.qzd = getIntent().getIntExtra("sns_gallery_position", 0);
        bO(u.T("sns_table_", (long) intExtra), this.qzd);
        o(booleanExtra, 1);
        this.qzb = new SnsInfoFlip(this);
        this.qzb.qti = true;
        al.a beB = ae.beB();
        String str = this.userName;
        if (beB.pXi.containsKey(str)) {
            beB.pXi.put(str, Integer.valueOf(((Integer) beB.pXi.get(str)).intValue() + 1));
        } else {
            beB.pXi.put(str, Integer.valueOf(0));
        }
        ArrayList arrayList2 = (ArrayList) beB.pXh.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            Object obj = arrayList2;
        }
        this.qzb.qBW = true;
        this.qzb.qBY = true;
        this.qzb.qBZ = false;
        this.qzb.a(arrayList, this.userName, this.qzd, this.qyW, this);
        this.qzb.qCe = new Runnable(this) {
            final /* synthetic */ SnsGalleryUI qBz;

            {
                this.qBz = r1;
            }

            public final void run() {
                this.qBz.qyY.biT();
            }
        };
        h.vJ();
        af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.userName);
        if (Rc == null || ((int) Rc.gTQ) <= 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
            if (this.userName.equals(m.xL())) {
                bLT = an.bLT();
            } else {
                bLT = an.bLU();
            }
        } else {
            bLT = an.bLS();
        }
        this.qzb.pQT = bLT;
        this.qzb.username = this.userName;
        addView(this.qzb);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsGalleryUI qBz;

            {
                this.qBz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qBz.qyY.biT();
                return true;
            }
        });
        a(0, e.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsGalleryUI qBz;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String str;
                String str2;
                SnsInfoFlip snsInfoFlip = this.qBz.qzb;
                if (snsInfoFlip.qBQ == null) {
                    str = "";
                } else {
                    b bVar = (b) snsInfoFlip.qBQ.getSelectedItem();
                    str = bVar == null ? "" : bVar.qaD;
                }
                snsInfoFlip = this.qBz.qzb;
                if (snsInfoFlip.qBQ == null) {
                    str2 = null;
                } else {
                    bVar = (b) snsInfoFlip.qBQ.getSelectedItem();
                    str2 = bVar == null ? null : bVar.fVV.mQY;
                }
                b bkn = this.qBz.qzb.bkn();
                w.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + str);
                w.d("MicroMsg.SnsGalleryUI", "click position " + str2);
                com.tencent.mm.plugin.sns.storage.m Gg = ae.beL().Gg(str);
                try {
                    int i;
                    int i2 = this.qBz.qzb.qCh;
                    int size = Gg.bhd().ufB.tsO.size();
                    if (size <= 1 || i2 <= 1 || i2 > size) {
                        i = 0;
                    } else {
                        i = i2 - 1;
                    }
                    this.qBz.qyY.a(booleanExtra, Gg, bkn.fVV, true, i);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
                }
                return true;
            }
        });
    }

    public final void bN(String str, int i) {
        if (this.qzb != null) {
            if (!(bg.mA(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.qzb;
                if (snsInfoFlip.hoO != null) {
                    int i2;
                    for (int i3 = 0; i3 >= 0; i3 = i2) {
                        i2 = i3;
                        while (i2 < snsInfoFlip.hoO.size()) {
                            b bVar = (b) snsInfoFlip.hoO.get(i2);
                            if (!bg.mA(bVar.qaD) && bVar.qaD.equals(str)) {
                                snsInfoFlip.hoO.remove(i2);
                                break;
                            }
                            i2++;
                        }
                        i2 = -1;
                    }
                    snsInfoFlip.qBP.notifyDataSetChanged();
                }
            }
            this.qzb.asx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String str;
            if (2 == i) {
                if (-1 == i2) {
                    alh com_tencent_mm_protocal_c_alh;
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (this.qzb != null) {
                        b bkn = this.qzb.bkn();
                        if (bkn.fVV.jOc == 6) {
                            com_tencent_mm_protocal_c_alh = bkn.fVV;
                        } else {
                            return;
                        }
                    }
                    com_tencent_mm_protocal_c_alh = null;
                    if (com_tencent_mm_protocal_c_alh != null) {
                        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                        str = "";
                        String str2 = "";
                        String j = i.j(com_tencent_mm_protocal_c_alh);
                        if (FileOp.aO(du + j)) {
                            str2 = du + j;
                            str = du + i.e(com_tencent_mm_protocal_c_alh);
                        }
                        if (FileOp.aO(du + i.p(com_tencent_mm_protocal_c_alh))) {
                            j = du + i.p(com_tencent_mm_protocal_c_alh);
                            du = du + i.n(com_tencent_mm_protocal_c_alh);
                        } else {
                            j = str2;
                            du = str;
                        }
                        List<String> f = bg.f(stringExtra.split(","));
                        int ER = i.ER(j);
                        for (String str3 : f) {
                            w.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[]{str3, j, du, Integer.valueOf(ER)});
                            d.aJW().a(this, str3, j, du, 62, ER, "");
                            d.aJW().cM(stringExtra2, str3);
                        }
                        com.tencent.mm.ui.snackbar.a.e(this, getString(j.esl));
                    }
                }
            } else if (1 == i) {
                int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
                str = u.T("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
                this.qyY.tK(intExtra);
                bN(str, 1);
                if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_cmd_list", this.qyY.qtQ);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
    }
}

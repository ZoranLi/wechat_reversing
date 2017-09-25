package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.m;

public class ArtistUI extends MMActivity implements e {
    private SharedPreferences hgx;
    private p irJ = null;
    private ListView kaM;
    private String naR = "";
    private f qpA;
    private ArtistHeader qpB;
    private k qpC = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String d = v.d(getSharedPreferences(ab.bIX(), 0));
        w.d("MicroMsg.ArtistUI", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.naR = d;
        w.d("MicroMsg.ArtistUI", "lan " + this.naR);
        h.vJ();
        h.vH().gXC.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        this.hgx = getSharedPreferences(ab.bIX(), 0);
        KC();
        ae.beG().a(this.qpB);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.irJ != null) {
            this.irJ = null;
        }
        if (this.qpB != null) {
            ae.beG().b(this.qpB);
        }
        ae.beI().Q(this);
        h.vJ();
        h.vH().gXC.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void KC() {
        zi(j.pKa);
        getString(j.dIO);
        this.irJ = g.a(this, getString(j.dHA), true, new OnCancelListener(this) {
            final /* synthetic */ ArtistUI qpD;

            {
                this.qpD = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.kaM = (ListView) findViewById(f.pEu);
        a.imw.am(false);
        this.qpA = new f(this, this.naR, new b(this) {
            final /* synthetic */ ArtistUI qpD;

            {
                this.qpD = r1;
            }

            public final void tJ(int i) {
                Intent intent = new Intent();
                intent.putExtra("sns_gallery_is_artist", true);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_artist_lan", this.qpD.naR);
                intent.putExtra("sns_gallery_showtype", 2);
                intent.setClass(this.qpD, ArtistBrowseUI.class);
                this.qpD.startActivity(intent);
            }
        }, new f.a(this) {
            final /* synthetic */ ArtistUI qpD;

            {
                this.qpD = r1;
            }

            public final void a(dl dlVar) {
                if (this.qpD.qpB != null) {
                    this.qpD.qpB.setVisibility(0);
                    ArtistHeader b = this.qpD.qpB;
                    if (dlVar == null) {
                        w.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
                    } else {
                        b.qpo = dlVar;
                        ae.beI().b(dlVar.tgU.tgV, b.qpt.ioV, b.context.hashCode(), an.uJM);
                        b.qpt.qpy.setText(dlVar.msj);
                        b.qpt.mVG.setText(dlVar.tgT);
                        b.qpt.ioX.setText(dlVar.fDC);
                        b.qpt.qpz.setText(dlVar.tgS);
                    }
                    String str = dlVar.msj;
                    if (!(str == null || str.equals(""))) {
                        this.qpD.hgx.edit().putString("artist_name", str).commit();
                    }
                    if (this.qpD.qpA != null) {
                        this.qpD.qpA.notifyDataSetChanged();
                    }
                }
                this.qpD.irJ.dismiss();
            }

            public final void bic() {
                if (this.qpD.qpC == null && this.qpD.irJ != null) {
                    w.d("MicroMsg.ArtistUI", "onNothingBgGet");
                    a.imw.am(true);
                }
            }
        });
        this.qpB = new ArtistHeader(this);
        this.kaM.addHeaderView(this.qpB);
        this.kaM.setAdapter(this.qpA);
        this.qpA.notifyDataSetChanged();
        this.qpB.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ArtistUI qpD;

            {
                this.qpD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qpD.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return i.g.pHo;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BQ() == 4) {
            w.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                        if (this.qpA != null) {
                            this.qpA.OK();
                        }
                        this.qpC = null;
                        return;
                    default:
                        return;
                }
            } else if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX && this.irJ != null) {
                this.irJ.dismiss();
                return;
            } else {
                return;
            }
        }
        w.d("MicroMsg.ArtistUI", "another scene");
    }
}

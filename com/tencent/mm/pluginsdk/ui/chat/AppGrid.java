package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.List;
import java.util.Map;

public class AppGrid extends GridView {
    Context context;
    private SharedPreferences hgx;
    OnItemClickListener kbd = new OnItemClickListener(this) {
        final /* synthetic */ AppGrid sNJ;

        {
            this.sNJ = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.sNJ.sNC.a(this.sNJ.sNC.xx((this.sNJ.sNG * this.sNJ.sNE) + i), this.sNJ.sNI.uw(i));
        }
    };
    OnItemLongClickListener lID = new OnItemLongClickListener(this) {
        final /* synthetic */ AppGrid sNJ;

        {
            this.sNJ = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b c = this.sNJ.sNC;
            int xx = this.sNJ.sNC.xx((this.sNJ.sNG * this.sNJ.sNE) + i);
            this.sNJ.sNI.uw(i);
            c.xy(xx);
            return true;
        }
    };
    b sNC;
    int sND;
    int sNE = 0;
    int sNF = 0;
    int sNG;
    int sNH;
    a sNI;

    class a extends BaseAdapter {
        final /* synthetic */ AppGrid sNJ;
        List<f> sNK;
        private int sNL;
        private int sNM;
        private Map<String, f> sNN = null;

        class a {
            ImageView jki;
            TextView jkj;
            TextView sNO;
            View sNP;
            View sNQ;
            final /* synthetic */ a sNR;

            a(a aVar) {
                this.sNR = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return uw(i);
        }

        public a(AppGrid appGrid, Context context, List<f> list, Map<String, f> map) {
            this.sNJ = appGrid;
            this.sNK = list;
            this.sNN = map;
            this.sNL = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 56.0f);
            this.sNM = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 53.3f);
        }

        public final int getCount() {
            if (this.sNJ.sNG == this.sNJ.sNF - 1) {
                return this.sNJ.sND - (this.sNJ.sNG * this.sNJ.sNE);
            }
            return this.sNJ.sNE;
        }

        public final f uw(int i) {
            if ((i < this.sNJ.sNH && this.sNJ.sNG == 0) || (this.sNJ.sNG * this.sNJ.sNE) + i < this.sNJ.sNH || (i - this.sNJ.sNH) + (this.sNJ.sNG * this.sNJ.sNE) >= this.sNK.size()) {
                return null;
            }
            w.v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf((i - this.sNJ.sNH) + (this.sNJ.sNG * this.sNJ.sNE)));
            return (f) this.sNK.get((i - this.sNJ.sNH) + (this.sNJ.sNG * this.sNJ.sNE));
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.sNJ.context, R.i.cUF, null);
                aVar.jki = (ImageView) view.findViewById(R.h.bpy);
                aVar.sNP = view.findViewById(R.h.bpz);
                aVar.jkj = (TextView) view.findViewById(R.h.bpA);
                aVar.sNO = (TextView) view.findViewById(R.h.bpB);
                aVar.sNQ = view.findViewById(R.h.bpC);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            w.v("MicroMsg.AppGrid", "pos:" + i + " page:" + this.sNJ.sNG);
            aVar.jkj.setVisibility(0);
            aVar.sNQ.setVisibility(8);
            aVar.sNO.setVisibility(8);
            aVar.sNP.setVisibility(0);
            LayoutParams layoutParams = aVar.jki.getLayoutParams();
            layoutParams.width = this.sNL;
            layoutParams.height = this.sNL;
            aVar.jki.setLayoutParams(layoutParams);
            int a = (this.sNJ.sNG * this.sNJ.sNE) + i;
            int xx = this.sNJ.sNC.xx(a);
            if (a < this.sNJ.sNH) {
                switch (xx) {
                    case 0:
                        aVar.jki.setImageResource(R.k.dyJ);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHc));
                        break;
                    case 1:
                        if (!r.ijS) {
                            aVar.jki.setImageResource(R.k.dyD);
                            aVar.jkj.setText(this.sNJ.context.getString(R.l.dHa));
                            break;
                        }
                        aVar.jki.setImageResource(R.k.dyL);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHg));
                        break;
                    case 2:
                        aVar.jki.setImageResource(R.k.dtW);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHk));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(54, Boolean.valueOf(false))).booleanValue()) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 3:
                        aVar.jki.setImageResource(R.k.dyI);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHl));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(81, Boolean.valueOf(true))).booleanValue()) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    case 4:
                        aVar.jki.setImageResource(R.k.dyN);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHl));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(62, Boolean.valueOf(false))).booleanValue()) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            break;
                        } catch (Exception e3) {
                            break;
                        }
                    case 5:
                        aVar.jki.setImageResource(R.k.dyO);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHh));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(67, Boolean.valueOf(false))).booleanValue()) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                    case 6:
                        aVar.jki.setImageResource(R.k.dyH);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dGZ));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(290817, Boolean.valueOf(false))).booleanValue()) {
                                aVar.sNQ.setVisibility(8);
                                break;
                            }
                            aVar.sNQ.setVisibility(0);
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    case 7:
                        a(aVar, f.sDf);
                        break;
                    case 8:
                        a(aVar, f.sDd);
                        break;
                    case 9:
                        a(aVar, f.sDg);
                        break;
                    case 10:
                        aVar.jki.setImageResource(R.k.dyM);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.esb));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(73, Boolean.valueOf(false))).booleanValue()) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    case 11:
                        aVar.jki.setImageResource(R.k.dyG);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dGV));
                        break;
                    case 12:
                        aVar.jki.setImageResource(R.k.dyF);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dGY));
                        break;
                    case 13:
                        aVar.jki.setImageResource(R.k.dtU);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.edO));
                        try {
                            ap.yY();
                            boolean booleanValue = ((Boolean) c.vr().get(208899, Boolean.valueOf(false))).booleanValue();
                            ap.yY();
                            boolean booleanValue2 = ((Boolean) c.vr().get(208913, Boolean.valueOf(false))).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                aVar.sNO.setVisibility(8);
                                break;
                            }
                            aVar.sNO.setVisibility(0);
                            if (!booleanValue2) {
                                aVar.sNO.setText(R.l.dHO);
                                break;
                            }
                            aVar.sNO.setText(R.l.dHq);
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                        break;
                    case 14:
                        aVar.jki.setImageResource(R.k.dyK);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dHf));
                        try {
                            ap.yY();
                            if (!((Boolean) c.vr().get(327744, Boolean.valueOf(true))).booleanValue()) {
                                aVar.sNQ.setVisibility(8);
                                break;
                            }
                            aVar.sNQ.setVisibility(0);
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    case 15:
                        aVar.jki.setImageResource(R.k.dyE);
                        aVar.jkj.setText(this.sNJ.context.getString(R.l.dGX));
                        try {
                            aVar.sNQ.setVisibility(8);
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                }
            }
            layoutParams.width = this.sNM;
            layoutParams.height = this.sNM;
            aVar.jki.setLayoutParams(layoutParams);
            f uw = uw(i);
            if (uw != null) {
                ap.yY();
                if (c.isSDCardAvailable()) {
                    Bitmap b;
                    if (uw.field_status == 5) {
                        b = g.b(uw.field_appId, 3, com.tencent.mm.bg.a.getDensity(this.sNJ.context));
                    } else if (uw.bCV()) {
                        b = g.b(uw.field_appId, 4, com.tencent.mm.bg.a.getDensity(this.sNJ.context));
                    } else {
                        b = g.b(uw.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.sNJ.context));
                    }
                    if (b != null) {
                        aVar.jki.setBackgroundDrawable(new BitmapDrawable(b));
                    } else if (f.sDd.equals(uw.field_appId)) {
                        aVar.jki.setImageResource(R.g.big);
                    } else if (f.sDf.equals(uw.field_appId)) {
                        aVar.jki.setImageResource(R.g.bif);
                    } else if (f.sDe.equals(uw.field_appId)) {
                        aVar.jki.setImageResource(R.g.bie);
                    } else if (f.sDg.equals(uw.field_appId)) {
                        aVar.jki.setImageResource(R.k.dyC);
                    } else {
                        aVar.jki.setBackgroundResource(R.g.bce);
                    }
                } else {
                    aVar.jki.setBackgroundResource(R.g.bjQ);
                }
                aVar.jkj.setText(g.a(this.sNJ.context, uw, null));
                if ((uw.bCV() && uw.bCW()) || uw.bCX()) {
                    if (this.sNJ.hgx == null) {
                        this.sNJ.hgx = this.sNJ.context.getSharedPreferences(ab.bIX(), 0);
                    }
                    if (this.sNJ.hgx.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + uw.field_appId, true)) {
                        aVar.sNO.setVisibility(0);
                    }
                }
            }
            f uw2 = uw(i);
            if (uw2 != null && g.j(uw2)) {
                aVar.sNO.setVisibility(0);
            }
            return view;
        }

        private void a(a aVar, String str) {
            if (this.sNN == null) {
                w.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                return;
            }
            f fVar = (f) this.sNN.get(str);
            if (fVar == null) {
                w.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                return;
            }
            ap.yY();
            if (c.isSDCardAvailable()) {
                Bitmap b;
                if (fVar.bCV()) {
                    b = g.b(fVar.field_appId, 4, com.tencent.mm.bg.a.getDensity(this.sNJ.context));
                } else {
                    b = null;
                }
                if (b != null) {
                    aVar.jki.setBackgroundDrawable(new BitmapDrawable(b));
                } else if (f.sDd.equals(fVar.field_appId)) {
                    aVar.jki.setImageResource(R.g.big);
                } else if (f.sDf.equals(fVar.field_appId)) {
                    aVar.jki.setImageResource(R.g.bif);
                } else if (f.sDe.equals(fVar.field_appId)) {
                    aVar.jki.setImageResource(R.g.bie);
                } else if (f.sDg.equals(fVar.field_appId)) {
                    aVar.jki.setImageResource(R.k.dyC);
                } else {
                    aVar.jki.setImageResource(R.g.bce);
                }
            } else {
                aVar.jki.setImageResource(R.g.bjQ);
            }
            aVar.jkj.setText(g.a(this.sNJ.context, fVar, null));
            if (fVar.bCV() && fVar.bCW()) {
                if (this.sNJ.hgx == null) {
                    this.sNJ.hgx = this.sNJ.context.getSharedPreferences(ab.bIX(), 0);
                }
                if (this.sNJ.hgx.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                    aVar.sNO.setVisibility(0);
                }
            }
            int intValue;
            if (f.sDd.equals(fVar.field_appId)) {
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue > 1) {
                    ap.yY();
                    if (!bg.f(((String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                        aVar.sNO.setVisibility(0);
                    }
                }
            } else if (f.sDf.equals(fVar.field_appId)) {
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue > 1) {
                    ap.yY();
                    if (!bg.f(((String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                        aVar.sNO.setVisibility(0);
                    }
                }
            }
        }
    }

    public interface b {
        void a(int i, f fVar);

        int xx(int i);

        void xy(int i);
    }

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public int getCount() {
        return this.sNI.getCount();
    }
}

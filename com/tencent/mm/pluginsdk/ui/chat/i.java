package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

public final class i {
    Bitmap bitmap = null;
    Context context;
    ImageView fMY = null;
    SharedPreferences hgx;
    private View ipu = null;
    View nfI;
    View qlS;
    private h sQo;
    public g sQp;
    public o sQq;
    boolean sQr = true;
    com.tencent.mm.pluginsdk.ui.chat.h.a sQs;
    public a sQt;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ i sQu;
        final /* synthetic */ ae sQv;

        AnonymousClass3(i iVar, ae aeVar) {
            this.sQu = iVar;
            this.sQv = aeVar;
        }

        public final void run() {
            boolean z = true;
            i iVar = this.sQu;
            String bGc = iVar.bGc();
            if (bGc == null) {
                z = false;
            } else {
                int xI = (int) iVar.xI(70);
                int xI2 = (int) iVar.xI(120);
                int Pc = ExifHelper.Pc(bGc);
                if (Pc == 90 || Pc == 270) {
                    int i = xI;
                    xI = xI2;
                    xI2 = i;
                }
                int xI3 = (int) iVar.xI(4);
                Bitmap a = d.a(bGc, xI2, xI, true, null, 0);
                if (a != null) {
                    iVar.bitmap = d.a(d.b(a, (float) Pc), true, (float) xI3);
                    iVar.hgx.edit().putString("chattingui_recent_shown_image_path", iVar.sQp.sQn).commit();
                    w.d("MicroMsg.RecentImageBubble", "check ok");
                } else {
                    w.e("MicroMsg.RecentImageBubble", "image hits hole.");
                    z = false;
                }
            }
            if (z) {
                this.sQv.sendEmptyMessage(0);
            } else {
                w.d("MicroMsg.RecentImageBubble", "check false");
            }
        }

        public final String toString() {
            return super.toString() + "|checkIfShow";
        }
    }

    public interface a {
        void Nb(String str);
    }

    class AnonymousClass2 extends ae {
        final /* synthetic */ i sQu;

        AnonymousClass2(i iVar, Looper looper) {
            this.sQu = iVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            i iVar = this.sQu;
            if (iVar.fMY != null && iVar.sQp != null && iVar.bitmap != null && iVar.sQq != null && iVar.qlS != null && iVar.nfI != null) {
                iVar.fMY.setImageBitmap(iVar.bitmap);
                int i = iVar.sQr ? 83 : 85;
                int i2 = iVar.sQr ? 0 : 10;
                int bFY = iVar.sQs != null ? iVar.sQs.bFY() : iVar.nfI.getHeight();
                if (VERSION.SDK_INT >= 21) {
                    Rect bQF = x.bQF();
                    i2 = iVar.sQr ? 0 : i2 + bQF.right;
                    bFY += bQF.bottom;
                    w.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(bQF.right), Integer.valueOf(bQF.bottom));
                }
                iVar.sQq.showAtLocation(iVar.qlS, i, i2, bFY);
                new aj(new com.tencent.mm.sdk.platformtools.aj.a(iVar) {
                    final /* synthetic */ i sQu;

                    {
                        this.sQu = r1;
                    }

                    public final boolean oQ() {
                        i iVar = this.sQu;
                        if (iVar.sQq != null) {
                            iVar.sQq.dismiss();
                        }
                        return false;
                    }
                }, false).v(10000, 10000);
            }
        }
    }

    public i(Context context, View view, View view2, a aVar) {
        this.context = context;
        this.qlS = view;
        this.nfI = view2;
        this.sQo = new h(this.context);
        this.hgx = context.getSharedPreferences(ab.bIX(), 0);
        this.sQt = aVar;
        this.ipu = View.inflate(this.context, R.i.cXv, null);
        this.fMY = (ImageView) this.ipu.findViewById(R.h.cwg);
        this.sQq = new o(this.ipu, -2, -2, true);
        this.sQq.setBackgroundDrawable(new ColorDrawable(0));
        this.sQq.setOutsideTouchable(true);
        this.ipu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ i sQu;

            {
                this.sQu = r1;
            }

            public final void onClick(View view) {
                if (!(this.sQu.sQt == null || this.sQu.sQp == null)) {
                    this.sQu.sQt.Nb(this.sQu.sQp.sQn);
                }
                this.sQu.sQq.dismiss();
            }
        });
    }

    public final synchronized String bGc() {
        String str;
        g gVar;
        if (this.sQo == null) {
            w.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList bGb = this.sQo.bGb();
            if (bGb == null || bGb.size() == 0) {
                w.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                gVar = (g) bGb.get(0);
                if (gVar != null) {
                    if ((bg.az(gVar.meH) < 0 ? 1 : null) != null) {
                        w.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", gVar.sQn);
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.sQn == null || !gVar.sQn.contains(e.hgt)) {
                    if (gVar != null) {
                        if ((bg.az(gVar.meH) <= 30 ? 1 : null) != null) {
                            if (this.hgx.getString("chattingui_recent_shown_image_path", "").equals(gVar.sQn)) {
                                w.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(addDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(gVar == null);
                    w.d(str2, str3, objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.sQp = gVar;
        if (this.sQp == null) {
            str = null;
        } else {
            str = this.sQp.fKz;
            if (this.sQp.fKz == null) {
                str = this.sQp.sQn;
            }
        }
        return str;
    }

    final float xI(int i) {
        return TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
    }
}

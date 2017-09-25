package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public ArrayList<a> rPg = new ArrayList();
    private c rPh = new c<ac>(this) {
        final /* synthetic */ a rPk;

        {
            this.rPk = r2;
            this.usg = ac.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            while (this.rPk.rPg != null && this.rPk.rPg.size() > 0) {
                a aVar = (a) this.rPk.rPg.remove(0);
                if (aVar == null) {
                    break;
                }
                Bankcard bankcard = aVar.ruU;
                ImageView imageView = (ImageView) aVar.rPp.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(R.h.cQi);
                    if (!bg.mA(str) && ((!m.xY() && str.equals(bankcard.field_bankcardType)) || (m.xY() && str.equals(bankcard.field_bankName)))) {
                        e h = bankcard.rEp == null ? m.xY() ? com.tencent.mm.plugin.wallet_core.c.b.h(imageView.getContext(), bankcard.field_bankName, false) : com.tencent.mm.plugin.wallet_core.c.b.h(imageView.getContext(), bankcard.field_bankcardType, bankcard.btz()) : bankcard.rEp;
                        a aVar2 = this.rPk;
                        if (h == null || aVar == null || aVar.rPp == null || aVar.rPp.get() == null) {
                            w.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            w.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + h.nXm);
                            imageView = (ImageView) aVar.rPp.get();
                            if (!bg.mA(h.nXm)) {
                                imageView.post(new AnonymousClass2(aVar2, imageView, j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(h.nXm))));
                                aVar.rNB = h.nXm;
                                j.a(aVar);
                            } else if (h.rEt > 0) {
                                imageView.post(new AnonymousClass3(aVar2, imageView, h));
                            } else {
                                w.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar2 = this.rPk;
                        if (!(h == null || aVar == null || aVar.rPq == null || aVar.rPq.get() == null)) {
                            View view = (View) aVar.rPq.get();
                            view.post(new AnonymousClass4(aVar2, view, h, aVar));
                        }
                        aVar2 = this.rPk;
                        if (!(h == null || aVar == null || aVar.rPq == null || aVar.rPq.get() == null)) {
                            imageView = (ImageView) aVar.rPr.get();
                            if (imageView != null) {
                                imageView.post(new AnonymousClass5(aVar2, h, imageView, aVar));
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    public LinkedList<String> rPi;
    public LinkedList<Bankcard> rPj;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView lfq;
        final /* synthetic */ a rPk;
        final /* synthetic */ Bitmap rPl;

        AnonymousClass2(a aVar, ImageView imageView, Bitmap bitmap) {
            this.rPk = aVar;
            this.lfq = imageView;
            this.rPl = bitmap;
        }

        public final void run() {
            this.lfq.setImageBitmap(this.rPl);
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView lfq;
        final /* synthetic */ a rPk;
        final /* synthetic */ e rPm;

        AnonymousClass3(a aVar, ImageView imageView, e eVar) {
            this.rPk = aVar;
            this.lfq = imageView;
            this.rPm = eVar;
        }

        public final void run() {
            this.lfq.setImageResource(this.rPm.rEt);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a rPk;
        final /* synthetic */ e rPm;
        final /* synthetic */ View rPn;
        final /* synthetic */ a rPo;

        AnonymousClass4(a aVar, View view, e eVar, a aVar2) {
            this.rPk = aVar;
            this.rPn = view;
            this.rPm = eVar;
            this.rPo = aVar2;
        }

        public final void run() {
            this.rPn.invalidate();
            String str = this.rPm.rEr;
            int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? R.g.blH : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? R.g.blJ : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? R.g.blK : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? R.g.blL : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? R.g.blM : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? R.g.blQ : -1;
            if (i != -1) {
                this.rPn.setBackgroundResource(i);
            } else if (!bg.mA(this.rPm.rEr)) {
                Object cVar = new com.tencent.mm.plugin.wallet_core.ui.view.c(this.rPm.rEr);
                Bitmap a = j.a(cVar);
                j.a(this.rPo);
                if (a != null) {
                    try {
                        byte[] ninePatchChunk = a.getNinePatchChunk();
                        if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                            FileOp.deleteFile(cVar.Nm());
                        }
                    } catch (Exception e) {
                    }
                }
                if (a != null) {
                    this.rPn.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.c(this.rPn.getContext(), a));
                }
            } else if (this.rPm.rEu > 0) {
                this.rPn.setBackgroundResource(this.rPm.rEu);
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ ImageView lfq;
        final /* synthetic */ a rPk;
        final /* synthetic */ e rPm;
        final /* synthetic */ a rPo;

        AnonymousClass5(a aVar, e eVar, ImageView imageView, a aVar2) {
            this.rPk = aVar;
            this.rPm = eVar;
            this.lfq = imageView;
            this.rPo = aVar2;
        }

        public final void run() {
            if (!bg.mA(this.rPm.rEs)) {
                this.lfq.setImageBitmap(j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(this.rPm.rEs)));
                j.a(this.rPo);
            } else if (this.rPm.rEv > 0) {
                this.lfq.setImageResource(this.rPm.rEv);
            }
        }
    }

    static class a implements com.tencent.mm.platformtools.j.a {
        String rNB;
        WeakReference<ImageView> rPp;
        WeakReference<View> rPq = null;
        WeakReference<ImageView> rPr = null;
        Bankcard ruU;

        a() {
        }

        public final void k(String str, final Bitmap bitmap) {
            boolean z = true;
            w.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.rNB)) {
                w.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
            } else if (this.rPp != null) {
                final ImageView imageView = (ImageView) this.rPp.get();
                String str2 = "MicroMsg.BankcardLogoHelper";
                String str3 = "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap == null);
                if (imageView != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                objArr[3] = imageView == null ? "" : imageView.getTag();
                objArr[4] = this.rNB;
                w.d(str2, str3, objArr);
                if (imageView != null && str != null && str.equals(this.rNB)) {
                    imageView.post(new Runnable(this) {
                        final /* synthetic */ a rPs;

                        public final void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                    imageView.setTag(R.h.cQi, null);
                }
            }
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.urY.b(this.rPh);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        a(context, bankcard, imageView, null, null);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        com.tencent.mm.platformtools.j.a aVar = new a();
        aVar.ruU = bankcard;
        if (imageView != null) {
            imageView.setTag(R.h.cQi, bankcard.field_bankcardType);
            aVar.rPp = new WeakReference(imageView);
        }
        final e eVar = bankcard.rEp;
        if (eVar == null || aVar.rPp == null || aVar.rPp.get() == null) {
            w.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            return;
        }
        w.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.nXm);
        final ImageView imageView2 = (ImageView) aVar.rPp.get();
        if (!bg.mA(eVar.nXm)) {
            Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.nXm));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            j.a(aVar);
        } else if (eVar.rEt > 0) {
            imageView2.post(new Runnable(this) {
                final /* synthetic */ a rPk;

                public final void run() {
                    imageView2.setImageResource(eVar.rEt);
                }
            });
        } else {
            w.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2) {
        a aVar = new a();
        aVar.ruU = bankcard;
        if (imageView != null) {
            imageView.setTag(R.h.cQi, bankcard.field_bankcardType);
            aVar.rPp = new WeakReference(imageView);
        }
        if (view != null) {
            aVar.rPq = new WeakReference(view);
        }
        if (imageView2 != null) {
            aVar.rPr = new WeakReference(imageView2);
        }
        this.rPg.add(aVar);
        String str = m.xY() ? bankcard.field_bankName : bankcard.field_bankcardType;
        if (this.rPi != null && this.rPi.contains(str)) {
            w.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + str);
        } else if (a(context, bankcard)) {
            com.tencent.mm.sdk.b.a.urY.m(new ac());
        } else {
            if (this.rPj == null) {
                this.rPj = new LinkedList();
            }
            this.rPj.add(bankcard);
            if (this.rPi == null) {
                b(context, this.rPj);
            }
        }
    }

    public final void destory() {
        com.tencent.mm.sdk.b.a.urY.c(this.rPh);
        if (this.rPg != null) {
            this.rPg.clear();
            this.rPg = null;
        }
    }

    private static boolean a(Context context, Bankcard bankcard) {
        e h;
        if (m.xY()) {
            h = com.tencent.mm.plugin.wallet_core.c.b.h(context, bankcard.field_bankName, false);
        } else {
            h = com.tencent.mm.plugin.wallet_core.c.b.h(context, bankcard.field_bankcardType, bankcard.btz());
        }
        if (h == null || h.rEw) {
            return false;
        }
        return true;
    }

    public final void b(final Context context, List<Bankcard> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.rPi = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (!a(context, bankcard)) {
                    w.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.rPi.add(bankcard.field_bankcardType);
                }
            }
            if (this.rPi.size() > 0) {
                w.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                k bVar = new com.tencent.mm.plugin.wallet_core.b.b(this.rPi);
                ap.vd().a(1650, new com.tencent.mm.y.e(this) {
                    final /* synthetic */ a rPk;

                    public final void a(int i, int i2, String str, k kVar) {
                        ap.vd().b(1650, this);
                        this.rPk.rPi = null;
                        if (this.rPk.rPj != null) {
                            this.rPk.b(context, this.rPk.rPj);
                            this.rPk.rPj = null;
                        }
                    }
                });
                ap.vd().a(bVar, 0);
                return;
            }
            w.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.b.a.urY.m(new ac());
        }
    }
}

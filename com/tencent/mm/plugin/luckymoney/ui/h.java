package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static final Drawable num = new ColorDrawable();
    public Activity activity;
    public String imagePath;
    private o nul;
    private GetHdHeadImageGalleryView nun;
    private int nuo;
    public int nup;
    private String username;

    public enum a {
        ;

        static {
            nur = 1;
            nus = 2;
            nut = 3;
            nuu = new int[]{nur, nus, nut};
        }
    }

    public h(Activity activity, String str, String str2) {
        this(activity, str, str2, a.nur);
    }

    private h(Activity activity, String str, String str2, int i) {
        this.nup = 1;
        this.activity = activity;
        this.username = str;
        this.imagePath = str2;
        this.nuo = i;
    }

    public final void l(boolean z, int i) {
        w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + z + ", sceneFromUI:" + i);
        View inflate = LayoutInflater.from(this.activity).inflate(R.i.dfx, null);
        this.nul = new o(inflate, -1, -1);
        this.nul.setFocusable(true);
        this.nul.setOutsideTouchable(true);
        this.nul.setBackgroundDrawable(num);
        this.nul.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.nun = (GetHdHeadImageGalleryView) inflate.findViewById(R.h.bSr);
        this.nun.sIE = this.nul;
        this.nun.username = this.username;
        this.nun.piV = this.imagePath;
        this.nup = i;
        ap.yY();
        Bitmap aa;
        if (c.isSDCardAvailable()) {
            aa = n.aa(this.imagePath, z);
            if (aa == null || aa.isRecycled()) {
                w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", new Object[]{this.username});
                this.nun.H(aa);
            }
            this.nun.wmS = new MMGestureGallery.c(this) {
                final /* synthetic */ h nuq;

                {
                    this.nuq = r1;
                }

                public final void auf() {
                    h hVar = this.nuq;
                    List arrayList = new ArrayList();
                    arrayList.add(hVar.activity.getString(R.l.eLL));
                    arrayList.add(hVar.activity.getString(R.l.eOm));
                    arrayList.add(hVar.activity.getString(R.l.eGa));
                    g.a(hVar.activity, null, (String[]) arrayList.toArray(new String[arrayList.size()]), "", new g.c(hVar) {
                        final /* synthetic */ h nuq;

                        {
                            this.nuq = r1;
                        }

                        public final void hq(int i) {
                            String str;
                            switch (i) {
                                case 0:
                                    w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
                                    str = this.nuq.imagePath;
                                    Context context = this.nuq.activity;
                                    if (bg.mA(str)) {
                                        w.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("Retr_File_Name", str);
                                        intent.putExtra("Retr_Compress_Type", 0);
                                        intent.putExtra("Retr_Msg_Type", 0);
                                        com.tencent.mm.plugin.luckymoney.a.imv.l(intent, context);
                                    }
                                    if (this.nuq.nup == 1) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(2)});
                                    return;
                                case 1:
                                    w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
                                    str = this.nuq.imagePath;
                                    CharSequence string = this.nuq.activity.getString(R.l.eyi);
                                    Context context2 = this.nuq.activity;
                                    if (bg.mA(str)) {
                                        w.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
                                    } else if (!d.a(str, context2, R.l.eaX)) {
                                        Toast.makeText(context2, string, 1).show();
                                    }
                                    if (this.nuq.nup == 1) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(2)});
                                    return;
                                case 2:
                                    w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
                                    h hVar = this.nuq;
                                    b cbVar = new cb();
                                    rv rvVar = new rv();
                                    rm rmVar = new rm();
                                    rmVar.yb(2);
                                    rmVar.NZ(hVar.imagePath);
                                    LinkedList linkedList = new LinkedList();
                                    linkedList.add(rmVar);
                                    rvVar.av(linkedList);
                                    cbVar.fFA.fFC = rvVar;
                                    cbVar.fFA.type = 2;
                                    cbVar.fFA.activity = hVar.activity;
                                    cbVar.fFA.fFH = 2;
                                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                                    if (this.nuq.nup == 1) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(2)});
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
            };
            return;
        }
        w.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
        s.eP(this.activity);
        aa = BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        try {
            Bitmap createBitmap;
            if (aa.getWidth() < 480) {
                float width = (float) (480 / aa.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(aa, 0, 0, aa.getWidth(), aa.getHeight(), matrix, true);
            } else {
                createBitmap = aa;
            }
            w.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(aa.getWidth()), Integer.valueOf(aa.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.nun.H(createBitmap);
            this.nun.piV = null;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LuckyMoneyPreviewImgGallaryView", e, "", new Object[0]);
        }
    }
}

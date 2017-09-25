package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import java.util.HashMap;
import java.util.Map;

public final class a implements b {
    private ListView Fg;
    public l iLX;
    public Map<String, ly> lHk = new HashMap();
    private c lHl = new c<ly>(this) {
        final /* synthetic */ a oPN;

        {
            this.oPN = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ly lyVar = (ly) bVar;
            this.oPN.lHk.put(lyVar.fTe.filePath, lyVar);
            if (this.oPN.iLX != null && this.oPN.iLX.qJe.isShowing()) {
                this.oPN.lLy.onLongClick(null);
            }
            return true;
        }
    };
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ a oPN;

        {
            this.oPN = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            switch (bVar.aMw) {
                case 0:
                    intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", bVar.fGM);
                    intent.putExtra("record_data_id", bVar.fKe.lKv);
                    intent.putExtra("record_xml", bVar.fTh);
                    if ((view.getContext() instanceof Activity) && ((Activity) view.getContext()).getIntent() != null) {
                        Bundle bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj");
                        if (bundleExtra != null) {
                            intent.putExtra("_stat_obj", bundleExtra);
                        }
                    }
                    view.getContext().startActivity(intent);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                    intent.putExtra("key_detail_data_id", bVar.fKe.lKv);
                    d.b(view.getContext(), "favorite", ".ui.FavImgGalleryUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    public OnLongClickListener lLy = new OnLongClickListener(this) {
        public Context context;
        final /* synthetic */ a oPN;
        private com.tencent.mm.plugin.record.ui.a.b oPO;
        public com.tencent.mm.plugin.record.a.c oPP;
        public rm oPQ;
        public String path;

        {
            this.oPN = r1;
        }

        public final boolean onLongClick(View view) {
            if (view != null) {
                this.context = view.getContext();
                this.oPO = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                this.oPP = this.oPO.oOR;
                this.oPQ = this.oPO.fKe;
            }
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 2;
            fpVar.fKp.fKr = this.oPO.fKe;
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
            this.path = fpVar.fKq.path;
            if (e.aO(this.path)) {
                if (this.oPN.iLX == null) {
                    this.oPN.iLX = new l(this.context);
                }
                this.oPN.iLX.qJf = new n.c(this) {
                    final /* synthetic */ AnonymousClass2 oPR;

                    {
                        this.oPR = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        int i = 0;
                        if (this.oPR.oPQ.tyq == 0) {
                            if (((this.oPR.oPP.field_favProto.tyH & 1) != 0 ? 1 : 0) != 0) {
                                lVar.e(2, this.oPR.context.getString(R.l.ejs));
                            }
                            if ((this.oPR.oPP.field_favProto.tyH & 2) != 0) {
                                i = 1;
                            }
                            if (i != 0) {
                                lVar.e(1, this.oPR.context.getString(R.l.eiU));
                            }
                            lVar.e(3, this.oPR.context.getString(R.l.ejn));
                            ly lyVar = (ly) this.oPR.oPN.lHk.get(this.oPR.path);
                            if (lyVar == null) {
                                com.tencent.mm.sdk.b.b lwVar = new lw();
                                lwVar.fTb.filePath = this.oPR.path;
                                com.tencent.mm.sdk.b.a.urY.m(lwVar);
                            } else if (!bg.mA(lyVar.fTe.result)) {
                                lVar.e(4, this.oPR.context.getString(com.tencent.mm.plugin.scanner.a.ak(lyVar.fTe.fFo, lyVar.fTe.result) ? R.l.eIB : R.l.eIA));
                            }
                        }
                    }
                };
                this.oPN.iLX.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass2 oPR;

                    {
                        this.oPR = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 1:
                                intent = new Intent();
                                intent.putExtra("Ksnsupload_type", 0);
                                intent.putExtra("sns_kemdia_path", this.oPR.path);
                                String fQ = q.fQ("fav_");
                                q.yC().n(fQ, true).l("prePublishId", "fav_");
                                intent.putExtra("reportSessionId", fQ);
                                d.b(this.oPR.context, "sns", ".ui.En_c4f742e5", intent);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Retr_File_Name", this.oPR.path);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                d.a(this.oPR.context, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 3:
                                if (!com.tencent.mm.platformtools.d.a(this.oPR.path, this.oPR.context, R.l.eaX)) {
                                    Toast.makeText(this.oPR.context, this.oPR.context.getString(R.l.ejm), 1).show();
                                    return;
                                }
                                return;
                            case 4:
                                ly lyVar = (ly) this.oPR.oPN.lHk.get(this.oPR.path);
                                if (lyVar != null) {
                                    com.tencent.mm.sdk.b.b bxVar = new bx();
                                    bxVar.fFn.activity = (Activity) this.oPR.context;
                                    bxVar.fFn.fDK = lyVar.fTe.result;
                                    bxVar.fFn.fFo = lyVar.fTe.fFo;
                                    bxVar.fFn.fFp = lyVar.fTe.fFp;
                                    com.tencent.mm.sdk.b.a.urY.m(bxVar);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.oPN.iLX.blb();
            } else {
                w.w("MicroMsg.ImageViewWrapper", "file not exists");
            }
            return true;
        }
    };
    public int oPM;
    public com.tencent.mm.plugin.record.ui.h.a oPj;

    public a(com.tencent.mm.plugin.record.ui.h.a aVar, ListView listView) {
        this.oPj = aVar;
        this.Fg = listView;
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
    }

    public final View cJ(Context context) {
        View inflate = View.inflate(context, R.i.dmn, null);
        this.oPM = com.tencent.mm.bg.a.fromDPToPix(context, m.CTRL_INDEX);
        return inflate;
    }

    public final void a(View view, int i, final com.tencent.mm.plugin.record.ui.a.b bVar) {
        final ImageView imageView = (ImageView) view.findViewById(R.h.cxe);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.lJz);
        if (bVar.aMw == 1) {
            imageView.setOnLongClickListener(this.lLy);
        }
        com.tencent.mm.plugin.record.ui.h.a.b bVar2 = new com.tencent.mm.plugin.record.ui.h.a.b();
        if (bVar.aMw == 0) {
            bVar2.oPl = bVar.fGM;
        } else if (bVar.aMw == 1) {
            bVar2.oPl = bVar.oOR.field_localId;
        }
        bVar2.fKe = bVar.fKe;
        bVar2.fKh = true;
        bVar2.maxWidth = this.oPM;
        Bitmap a = this.oPj.a(bVar2);
        if (a != null) {
            w.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[]{bVar2.fKe.lKv, a});
            a(imageView, a, R.k.dwW, bVar.fKe.lKv);
            return;
        }
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ a oPN;

            public final void run() {
                int i;
                int i2;
                Bitmap a;
                com.tencent.mm.plugin.record.ui.a.a aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                if (aVar.aMw == 0) {
                    if (com.tencent.mm.plugin.record.a.m.g(aVar.fKe, aVar.fGM)) {
                        i = R.k.dzg;
                    }
                    i = -1;
                } else {
                    if (aVar.aMw == 1 && bg.mA(aVar.fKe.txi)) {
                        i = R.k.dzg;
                    }
                    i = -1;
                }
                if (i == -1) {
                    i2 = R.k.dwW;
                } else {
                    i2 = i;
                }
                aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                com.tencent.mm.plugin.record.ui.h.a aVar2 = this.oPN.oPj;
                int i3 = this.oPN.oPM;
                com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
                bVar.fKe = aVar.fKe;
                bVar.fKh = false;
                bVar.maxWidth = i3;
                com.tencent.mm.plugin.record.ui.h.a.c cVar = new com.tencent.mm.plugin.record.ui.h.a.c();
                cVar.fKe = aVar.fKe;
                Bitmap a2;
                if (aVar.aMw == 0) {
                    if (!com.tencent.mm.plugin.record.a.m.g(aVar.fKe, aVar.fGM)) {
                        bVar.oPl = aVar.fGM;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.oPl = aVar.fGM;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                } else {
                    if (aVar.aMw == 1) {
                        bVar.oPl = aVar.oOR.field_localId;
                        bVar.fKi = false;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.oPl = aVar.oOR.field_localId;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 oPV;

                    public final void run() {
                        this.oPV.oPN.a(imageView, a, i2, bVar.fKe.lKv);
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|fillView";
            }
        });
    }

    public final void a(ImageView imageView, Bitmap bitmap, int i, String str) {
        if (!((com.tencent.mm.plugin.record.ui.a.b) imageView.getTag()).fKe.lKv.equals(str)) {
            w.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[]{str, imageView.getTag()});
        } else if (bitmap == null) {
            LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = m.CTRL_INDEX;
            layoutParams.width = 280;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(R.e.aUx);
        } else {
            Bitmap createBitmap;
            int i2;
            w.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight())});
            LayoutParams layoutParams2 = imageView.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f;
            float f2;
            if (height >= width) {
                f = ((float) height) / ((float) width);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    width = com.tencent.mm.bg.a.U(imageView.getContext(), R.f.aWH);
                    i2 = (int) (((float) width) / f2);
                } else {
                    i2 = com.tencent.mm.bg.a.U(imageView.getContext(), R.f.aWI);
                    width = (int) (((float) i2) * f2);
                }
            } else {
                f = ((float) width) / ((float) height);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    i2 = com.tencent.mm.bg.a.U(imageView.getContext(), R.f.aWH);
                    width = (int) (((float) i2) / f2);
                } else {
                    width = com.tencent.mm.bg.a.U(imageView.getContext(), R.f.aWI);
                    i2 = (int) (((float) width) * f2);
                }
            }
            layoutParams2.width = i2;
            layoutParams2.height = width;
            imageView.setScaleType(ScaleType.FIT_XY);
            k.i(imageView, i2, width);
            if (imageView.getLayerType() == 1) {
                this.Fg.setLayerType(1, null);
            }
            imageView.setImageBitmap(createBitmap);
            imageView.setBackgroundResource(0);
        }
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
    }

    public final void pause() {
    }
}

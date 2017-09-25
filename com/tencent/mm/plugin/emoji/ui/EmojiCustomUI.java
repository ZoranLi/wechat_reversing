package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.me;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EmojiCustomUI extends MMActivity implements OnItemClickListener, e {
    private ProgressDialog kIa;
    private int kPG = c.kQo;
    private b kPH;
    private HeaderGridView kPI;
    private View kPJ;
    private Button kPK;
    private Button kPL;
    private com.tencent.mm.plugin.emoji.sync.a.a kPM = com.tencent.mm.plugin.emoji.sync.a.a.Default;
    private View kPN;
    private TextView kPO;
    private Button kPP;
    private boolean kPQ = false;
    private boolean kPR = false;
    private boolean kPS = false;
    private a kPT = a.EMPTY;
    private ArrayList<String> kPU = new ArrayList();
    private OnClickListener kPV = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void onClick(View view) {
            switch (this.kQc.kPT) {
                case START:
                    g.a(this.kQc.uSU.uTo, this.kQc.getResources().getString(R.l.eef), "", this.kQc.getResources().getString(R.l.eed), this.kQc.getResources().getString(R.l.dGs), new DialogInterface.OnClickListener(this.kQc) {
                        final /* synthetic */ EmojiCustomUI kQc;

                        {
                            this.kQc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BKGLoaderManager bKGLoaderManager = h.alZ().kNA;
                            bKGLoaderManager.kNN = true;
                            bKGLoaderManager.amx();
                            com.tencent.mm.plugin.report.service.g.oUh.i(11595, new Object[]{Integer.valueOf(1)});
                        }
                    }, null);
                    return;
                case PAUSE:
                    h.alZ().kNA.amy();
                    return;
                default:
                    return;
            }
        }
    };
    private OnClickListener kPW = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void onClick(View view) {
            g.a(this.kQc.uSU.uTo, this.kQc.getResources().getString(R.l.ecy), "", this.kQc.getResources().getString(R.l.dGB), this.kQc.getResources().getString(R.l.dGs), new DialogInterface.OnClickListener(this.kQc) {
                final /* synthetic */ EmojiCustomUI kQc;

                {
                    this.kQc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    EmojiCustomUI.j(this.kQc);
                }
            }, null, R.e.aVF);
        }
    };
    private OnClickListener kPX = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void onClick(View view) {
            EmojiCustomUI.d(this.kQc);
        }
    };
    private final com.tencent.mm.sdk.e.j.a kPY = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void a(String str, l lVar) {
            if (!bg.mA(str)) {
                if ((str.length() == 32 || str.equals("event_update_emoji")) && this.kQc.kPH != null) {
                    this.kQc.kPH.anp();
                    this.kQc.kPH.notifyDataSetChanged();
                }
            }
        }
    };
    private final com.tencent.mm.plugin.emoji.sync.c kPZ = new com.tencent.mm.plugin.emoji.sync.c.a(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void amB() {
            this.kQc.kPM = h.alZ().amw();
            if (this.kQc.mHandler != null) {
                this.kQc.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
            }
        }

        public final void amC() {
            if (this.kQc.mHandler != null) {
                this.kQc.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
            }
        }
    };
    private com.tencent.mm.ah.a.c.d kQa = new com.tencent.mm.ah.a.c.d(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final byte[] e(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    return com.tencent.mm.plugin.emoji.e.e.alz().a((com.tencent.mm.storage.a.c) obj);
                }
            }
            return null;
        }
    };
    private com.tencent.mm.storage.a.c kQb;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiCustomUI kQc;

        {
            this.kQc = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    EmojiCustomUI.g(this.kQc);
                    return;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    h.alZ();
                    if (!BKGLoaderManager.alx()) {
                        return;
                    }
                    if (h.alZ().amw() == com.tencent.mm.plugin.emoji.sync.a.a.Syncing) {
                        this.kQc.dt(true);
                        return;
                    } else {
                        this.kQc.dt(false);
                        return;
                    }
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    this.kQc.kPN.setVisibility(8);
                    this.kQc.kPH.notifyDataSetChanged();
                    return;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    if (this.kQc.kPH != null) {
                        this.kQc.kPH.anp();
                        this.kQc.kPH.notifyDataSetChanged();
                    }
                    com.tencent.mm.sdk.b.a.urY.m(new me());
                    return;
                default:
                    w.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                    return;
            }
        }
    };

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] kQf = new int[c.anq().length];

        static {
            try {
                kQf[c.kQo - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kQf[c.kQp - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kQf[c.kQq - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kQf[c.kQr - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            kQe = new int[com.tencent.mm.plugin.emoji.sync.a.a.values().length];
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.Default.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.Syncing.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.PauseSync.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.PauseSyncOffline.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.PauseSyncSDCardFull.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                kQe[com.tencent.mm.plugin.emoji.sync.a.a.FinishSync.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            kQd = new int[a.values().length];
            try {
                kQd[a.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                kQd[a.START.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                kQd[a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    private enum a {
        START,
        PAUSE,
        EMPTY
    }

    class b extends BaseAdapter {
        final /* synthetic */ EmojiCustomUI kQc;
        private ArrayList<com.tencent.mm.storage.a.c> kQm;
        private Animation kQn;

        public final /* synthetic */ Object getItem(int i) {
            return ls(i);
        }

        public b(EmojiCustomUI emojiCustomUI) {
            this.kQc = emojiCustomUI;
            this.kQn = AnimationUtils.loadAnimation(emojiCustomUI, R.a.aRB);
            this.kQn.setInterpolator(new LinearInterpolator());
        }

        public final int getCount() {
            return ano() + ann();
        }

        private int ann() {
            if (ano() <= 0 || (ano() + 1) % 5 != 0) {
                return 2;
            }
            return 1;
        }

        public final int ano() {
            return this.kQm == null ? 0 : this.kQm.size();
        }

        public final com.tencent.mm.storage.a.c ls(int i) {
            if (i < ano() && this.kQm != null) {
                return (com.tencent.mm.storage.a.c) this.kQm.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
            r7 = this;
            r6 = 8;
            r5 = 0;
            r4 = 0;
            if (r9 == 0) goto L_0x000c;
        L_0x0006:
            r0 = r9.getTag();
            if (r0 != 0) goto L_0x0067;
        L_0x000c:
            r0 = r7.kQc;
            r0 = r0.uSU;
            r0 = r0.uTo;
            r0 = android.view.LayoutInflater.from(r0);
            r1 = com.tencent.mm.R.i.dar;
            r9 = r0.inflate(r1, r4);
            r9.setVisibility(r5);
            r0 = new com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$d;
            r0.<init>(r9);
            r9.setTag(r0);
            r1 = r0;
        L_0x0028:
            r0 = r7.kQc;
            r0 = r0.kPG;
            r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.kQr;
            if (r0 == r2) goto L_0x003c;
        L_0x0032:
            r0 = r7.kQc;
            r0 = r0.kPG;
            r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.kQp;
            if (r0 != r2) goto L_0x0072;
        L_0x003c:
            r0 = r7.ann();
        L_0x0040:
            r2 = r7.getCount();
            r2 = r2 - r0;
            if (r8 >= r2) goto L_0x0081;
        L_0x0047:
            r0 = r8 % 5;
            if (r0 != 0) goto L_0x0079;
        L_0x004b:
            r0 = r1.kQt;
            r2 = com.tencent.mm.R.g.beM;
            r0.setBackgroundResource(r2);
        L_0x0052:
            r0 = r1.kQu;
            r0.clearAnimation();
            r0 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass9.kQf;
            r2 = r7.kQc;
            r2 = r2.kPG;
            r2 = r2 + -1;
            r0 = r0[r2];
            switch(r0) {
                case 1: goto L_0x0097;
                case 2: goto L_0x0137;
                case 3: goto L_0x00e3;
                case 4: goto L_0x01a1;
                default: goto L_0x0066;
            };
        L_0x0066:
            return r9;
        L_0x0067:
            r9.setVisibility(r5);
            r0 = r9.getTag();
            r0 = (com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d) r0;
            r1 = r0;
            goto L_0x0028;
        L_0x0072:
            r0 = r7.ann();
            r0 = r0 + -1;
            goto L_0x0040;
        L_0x0079:
            r0 = r1.kQt;
            r2 = com.tencent.mm.R.g.beP;
            r0.setBackgroundResource(r2);
            goto L_0x0052;
        L_0x0081:
            r2 = r7.getCount();
            r0 = r2 - r0;
            if (r8 != r0) goto L_0x0091;
        L_0x0089:
            r0 = r1.kQt;
            r2 = com.tencent.mm.R.g.beO;
            r0.setBackgroundResource(r2);
            goto L_0x0052;
        L_0x0091:
            r0 = r1.kQt;
            r0.setBackgroundColor(r5);
            goto L_0x0052;
        L_0x0097:
            r0 = r7.getCount();
            r2 = r7.ann();
            r0 = r0 - r2;
            r0 = r0 + 1;
            if (r8 != r0) goto L_0x00bb;
        L_0x00a4:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
        L_0x00b5:
            r0 = r1.kQv;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x00bb:
            r0 = r7.ano();
            if (r8 != r0) goto L_0x00d5;
        L_0x00c1:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r2 = com.tencent.mm.R.k.dwE;
            r0.setImageResource(r2);
            goto L_0x00b5;
        L_0x00d5:
            r0 = r7.kQm;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.kQu;
            r7.a(r2, r0);
            goto L_0x00b5;
        L_0x00e3:
            r0 = r7.getCount();
            r2 = r7.ann();
            r0 = r0 - r2;
            r0 = r0 + 1;
            if (r8 != r0) goto L_0x0108;
        L_0x00f0:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
        L_0x0101:
            r0 = r1.kQv;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x0108:
            r0 = r7.ano();
            if (r8 != r0) goto L_0x0129;
        L_0x010e:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r2 = com.tencent.mm.R.g.biC;
            r0.setImageResource(r2);
            r0 = r1.kQu;
            r2 = r7.kQn;
            r0.startAnimation(r2);
            goto L_0x0101;
        L_0x0129:
            r0 = r7.kQm;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.kQu;
            r7.a(r2, r0);
            goto L_0x0101;
        L_0x0137:
            r0 = r7.getCount();
            r2 = r7.ann();
            r0 = r0 - r2;
            r0 = r0 + 1;
            if (r8 != r0) goto L_0x015c;
        L_0x0144:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
        L_0x0155:
            r0 = r1.kQv;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x015c:
            r0 = r7.ano();
            if (r8 != r0) goto L_0x0174;
        L_0x0162:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
            goto L_0x0155;
        L_0x0174:
            r0 = r7.kQm;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.kQu;
            r7.a(r2, r0);
            r2 = r0.field_catalog;
            r3 = com.tencent.mm.storage.a.a.uKR;
            if (r2 == r3) goto L_0x0155;
        L_0x0187:
            r2 = r1.kQv;
            r2.setVisibility(r5);
            r1 = r1.kQv;
            r2 = r7.kQc;
            r2 = r2.kPU;
            r0 = r0.EP();
            r0 = r2.contains(r0);
            r1.setChecked(r0);
            goto L_0x0066;
        L_0x01a1:
            r0 = r7.getCount();
            r2 = r7.ann();
            r0 = r0 - r2;
            r0 = r0 + 1;
            if (r8 != r0) goto L_0x01c0;
        L_0x01ae:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
            goto L_0x0155;
        L_0x01c0:
            r0 = r7.ano();
            if (r8 != r0) goto L_0x01d9;
        L_0x01c6:
            r0 = com.tencent.mm.ah.n.GW();
            r2 = "";
            r3 = r1.kQu;
            r0.a(r2, r3);
            r0 = r1.kQu;
            r0.setImageBitmap(r4);
            goto L_0x0155;
        L_0x01d9:
            r0 = r7.kQm;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.kQu;
            r7.a(r2, r0);
            goto L_0x0155;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public final boolean anp() {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                f fVar = h.amc().kLa;
                List arrayList = new ArrayList();
                Cursor a = fVar.gUz.a("select * from EmojiInfo where catalog=? order by reserved3 asc", new String[]{com.tencent.mm.storage.a.a.uKS}, 2);
                if (a.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.emoji.d.akT();
                        com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c(com.tencent.mm.plugin.emoji.d.akU());
                        cVar.b(a);
                        arrayList.add(cVar);
                    } while (a.moveToNext());
                }
                a.close();
                this.kQm = (ArrayList) arrayList;
            } else {
                this.kQm = new ArrayList();
            }
            if (this.kQc.kPG == c.kQp) {
                int size = this.kQc.kPU == null ? 0 : this.kQc.kPU.size();
                this.kQc.qP(this.kQc.getString(R.l.ecU, new Object[]{Integer.valueOf(size)}));
            } else {
                this.kQc.qP(this.kQc.getString(R.l.ecx, new Object[]{Integer.valueOf(this.kQm.size())}));
            }
            return true;
        }

        private void a(ImageView imageView, com.tencent.mm.storage.a.c cVar) {
            imageView.setImageBitmap(null);
            String eN = cVar.eN(cVar.field_groupId, cVar.EP());
            String str = eN + "_cover";
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIQ = 1;
            aVar.hIX = true;
            aVar.fKz = str;
            aVar.hIN = eN;
            aVar.hJm = new Object[]{cVar};
            com.tencent.mm.ah.a.a.c Hg = aVar.Hg();
            n.GW().a(eN, imageView, Hg, null, this.kQc.kQa);
        }
    }

    private enum c {
        ;

        public static int[] anq() {
            return (int[]) kQs.clone();
        }

        static {
            kQo = 1;
            kQp = 2;
            kQq = 3;
            kQr = 4;
            kQs = new int[]{kQo, kQp, kQq, kQr};
        }
    }

    static class d {
        View kQt;
        ImageView kQu;
        CheckBox kQv;

        public d(View view) {
            this.kQt = view.findViewById(R.h.bZb);
            this.kQu = (ImageView) view.findViewById(R.h.Kd);
            this.kQv = (CheckBox) view.findViewById(R.h.checked);
        }
    }

    static /* synthetic */ void d(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.kPU == null ? 0 : emojiCustomUI.kPU.size());
        w.i(str, str2, objArr);
        if (emojiCustomUI.kPU == null || emojiCustomUI.kPU.size() <= 0) {
            w.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.uE(emojiCustomUI.getString(R.l.eem));
        ArrayList arrayList = emojiCustomUI.kPU;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        w.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            w.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.c(3, emojiCustomUI.kPU), 0);
        }
    }

    static /* synthetic */ void g(EmojiCustomUI emojiCustomUI) {
        w.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", new Object[]{emojiCustomUI.kPM.toString()});
        if (emojiCustomUI.kPG != c.kQp && !emojiCustomUI.kPR) {
            switch (emojiCustomUI.kPM) {
                case Default:
                    emojiCustomUI.kPS = false;
                    emojiCustomUI.ae(0, true);
                    emojiCustomUI.ank();
                    emojiCustomUI.lr(c.kQo);
                    return;
                case Syncing:
                    emojiCustomUI.ae(0, false);
                    h.alZ();
                    if (BKGLoaderManager.alx()) {
                        emojiCustomUI.kPS = false;
                        emojiCustomUI.kPN.setVisibility(0);
                        emojiCustomUI.a(a.PAUSE);
                        emojiCustomUI.dt(true);
                    } else {
                        h.alZ();
                        if (BKGLoaderManager.amA() && !emojiCustomUI.kPS) {
                            emojiCustomUI.kPS = true;
                            emojiCustomUI.ank();
                            emojiCustomUI.a(a.EMPTY);
                        }
                    }
                    if (emojiCustomUI.kPG != c.kQq) {
                        emojiCustomUI.lr(c.kQq);
                        return;
                    }
                    return;
                case PauseSync:
                    emojiCustomUI.kPS = false;
                    emojiCustomUI.ae(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                    }
                    emojiCustomUI.kPN.setVisibility(0);
                    emojiCustomUI.dt(false);
                    emojiCustomUI.a(a.START);
                    emojiCustomUI.lr(c.kQr);
                    return;
                case PauseSyncOffline:
                    emojiCustomUI.kPS = false;
                    emojiCustomUI.ae(0, false);
                    emojiCustomUI.ank();
                    emojiCustomUI.lr(c.kQr);
                    return;
                case PauseSyncSDCardFull:
                    emojiCustomUI.kPS = false;
                    emojiCustomUI.ae(0, true);
                    emojiCustomUI.kPN.setVisibility(0);
                    int bNC = h.amc().kLa.bNC();
                    int i = h.alZ().kNA.kNL;
                    emojiCustomUI.kPO.setText(R.l.eec);
                    emojiCustomUI.kPO.setText(String.format(emojiCustomUI.getString(R.l.eec), new Object[]{Integer.valueOf(i - bNC), Integer.valueOf(i)}));
                    emojiCustomUI.kPP.setVisibility(4);
                    emojiCustomUI.lr(c.kQr);
                    return;
                case FinishSync:
                    emojiCustomUI.kPS = false;
                    emojiCustomUI.ae(0, true);
                    emojiCustomUI.ank();
                    emojiCustomUI.lr(c.kQo);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void j(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.kPU == null ? 0 : emojiCustomUI.kPU.size());
        w.i(str, str2, objArr);
        if (emojiCustomUI.kPU == null || emojiCustomUI.kPU.size() <= 0) {
            w.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.uE(emojiCustomUI.getString(R.l.ecA));
        ArrayList arrayList = emojiCustomUI.kPU;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        w.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            w.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.c(2, emojiCustomUI.kPU), 0);
        }
        w.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", new Object[]{Boolean.valueOf(emojiCustomUI.kPQ)});
        if (emojiCustomUI.kPQ) {
            emojiCustomUI.kPQ = false;
            ap.yY();
            com.tencent.mm.u.c.vr().set(348162, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.alu();
        }
        emojiCustomUI.anl();
    }

    private void a(a aVar) {
        w.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[]{aVar.toString()});
        this.kPT = aVar;
        switch (aVar) {
            case EMPTY:
                this.kPP.setVisibility(4);
                return;
            case START:
                this.kPP.setVisibility(0);
                this.kPP.setText(R.l.eed);
                return;
            case PAUSE:
                this.kPP.setVisibility(0);
                this.kPP.setText(R.l.eee);
                return;
            default:
                return;
        }
    }

    private void dt(boolean z) {
        int bNC = h.amc().kLa.bNC();
        int i = h.alZ().kNA.kNL;
        if (bNC != i || z) {
            int i2;
            if (i == 0) {
                i2 = bNC;
            } else {
                i2 = 0;
            }
            i += i2;
            this.kPO.setText(String.format(getString(z ? R.l.eei : R.l.eeb), new Object[]{Integer.valueOf(i - bNC), Integer.valueOf(i)}));
            return;
        }
        this.kPO.setText(R.l.eeg);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.kPH = new b(this);
        this.kPH.anp();
        KC();
        h.alZ().ds(true);
        lr(c.kQo);
        ap.yY();
        w.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(true))).booleanValue())});
        if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(true))).booleanValue()) {
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
        }
        h.amc().kLa.c(this.kPY);
        com.tencent.mm.plugin.report.service.g.oUh.a(406, 9, 1, false);
        com.tencent.mm.plugin.report.service.g.oUh.a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.emoji.sync.a alZ = h.alZ();
        com.tencent.mm.plugin.emoji.sync.c cVar = this.kPZ;
        BKGLoaderManager bKGLoaderManager = alZ.kNA;
        if (bKGLoaderManager.kOa == null) {
            bKGLoaderManager.kOa = new HashSet();
        }
        if (!bKGLoaderManager.kOa.contains(cVar)) {
            bKGLoaderManager.kOa.add(cVar);
        }
        anl();
        ap.vd().a(698, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.emoji.sync.a alZ = h.alZ();
        com.tencent.mm.plugin.emoji.sync.c cVar = this.kPZ;
        BKGLoaderManager bKGLoaderManager = alZ.kNA;
        if (bKGLoaderManager.kOa == null) {
            bKGLoaderManager.kOa = new HashSet();
        }
        if (bKGLoaderManager.kOa.contains(cVar)) {
            bKGLoaderManager.kOa.remove(cVar);
        }
        ap.vd().b(698, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        h.amc().kLa.f(this.kPY);
        h.alZ().ds(false);
        BKGLoaderManager bKGLoaderManager = h.alZ().kNA;
        if (bKGLoaderManager.kNR) {
            bKGLoaderManager.kNR = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.daq;
    }

    protected final int Ol() {
        return 1;
    }

    protected final void KC() {
        this.kPN = getLayoutInflater().inflate(R.i.das, null);
        this.kPO = (TextView) this.kPN.findViewById(R.h.cHb);
        this.kPP = (Button) this.kPN.findViewById(R.h.cHa);
        this.kPP.setOnClickListener(this.kPV);
        this.kPI = (HeaderGridView) findViewById(R.h.cDf);
        HeaderGridView headerGridView = this.kPI;
        View view = this.kPN;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof c)) {
            a aVar = new a();
            ViewGroup bVar = new b(headerGridView, headerGridView.getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.vgM = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            headerGridView.vgL.add(aVar);
            if (adapter != null) {
                ((c) adapter).mDataSetObservable.notifyChanged();
            }
            this.kPI.a(this.kPH);
            this.kPI.setOnItemClickListener(this);
            this.kPI.setFocusableInTouchMode(false);
            this.kPJ = findViewById(R.h.cDe);
            this.kPK = (Button) findViewById(R.h.cDg);
            this.kPK.setOnClickListener(this.kPW);
            this.kPL = (Button) findViewById(R.h.cDh);
            this.kPL.setOnClickListener(this.kPX);
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kPH != null) {
            int size = i - (this.kPI.vgL.size() * 5);
            if (this.kPG == c.kQo && size == this.kPH.ano()) {
                ap.yY();
                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                    if (this.kPH.ano() >= com.tencent.mm.plugin.emoji.e.n.alO()) {
                        g.a(this, getString(R.l.eep), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ EmojiCustomUI kQc;

                            {
                                this.kQc = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        k.W(this);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(11596, new Object[]{Integer.valueOf(0)});
                } else {
                    s.eP(this);
                    return;
                }
            }
            if (this.kPG == c.kQp && size < this.kPH.ano()) {
                com.tencent.mm.storage.a.c ls = this.kPH.ls(size);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                if (ls.field_catalog == com.tencent.mm.storage.a.a.uKR) {
                    g.h(this.uSU.uTo, R.l.dTk, R.l.dTk).show();
                } else if (this.kPU.contains(ls.EP())) {
                    r2 = ls.EP();
                    if (this.kPU != null) {
                        this.kPU.remove(r2);
                    }
                    if (dVar != null) {
                        dVar.kQv.setChecked(false);
                        this.kPH.notifyDataSetChanged();
                    }
                    w.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[]{ls.EP()});
                } else {
                    r2 = ls.EP();
                    if (this.kPU != null) {
                        this.kPU.add(r2);
                    }
                    if (dVar != null) {
                        dVar.kQv.setChecked(true);
                    }
                    w.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[]{ls.EP()});
                }
                anj();
                if (dVar == null) {
                    this.kPH.notifyDataSetChanged();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case cf.CTRL_INDEX /*205*/:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 3);
                        ap.yY();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.u.c.xi());
                        com.tencent.mm.plugin.emoji.b.imv.a(intent2, v.CTRL_INDEX, this, intent);
                        return;
                    }
                    return;
                case v.CTRL_INDEX /*206*/:
                    if (intent == null) {
                        w.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra != null && stringExtra.length() > 0) {
                        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                        StringBuilder stringBuilder = new StringBuilder();
                        ap.yY();
                        String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xi()).append(stringExtra).toString();
                        this.kQb = h.amc().kLa.Si(stringExtra);
                        com.tencent.mm.ui.tools.a.b Ur = com.tencent.mm.ui.tools.a.b.Ur(stringBuilder2);
                        Ur.hP = com.tencent.mm.i.b.sA();
                        Ur.Cg(com.tencent.mm.i.b.sB()).a(new com.tencent.mm.ui.tools.a.b.a(this) {
                            final /* synthetic */ EmojiCustomUI kQc;

                            public final void a(com.tencent.mm.ui.tools.a.b bVar) {
                                if (this.kQc.kQb == null) {
                                    if (intExtra == 0) {
                                        this.kQc.kQb = h.amc().kLa.c(stringExtra, "", com.tencent.mm.storage.a.a.uKT, com.tencent.mm.storage.a.c.uKZ, bVar.wpl, "");
                                    } else {
                                        this.kQc.kQb = h.amc().kLa.c(stringExtra, "", com.tencent.mm.storage.a.a.uKT, com.tencent.mm.storage.a.c.uLa, bVar.wpl, "");
                                    }
                                }
                                h.alY().a(this.kQc.uSU.uTo, this.kQc.kQb, 1, m.xL());
                                if (this.kQc.kPH != null) {
                                    this.kQc.kPH.anp();
                                    this.kQc.kPH.notifyDataSetChanged();
                                }
                            }

                            public final void anf() {
                                g.a(this.kQc.uSU.uTo, this.kQc.uSU.uTo.getString(R.l.ecv), "", this.kQc.uSU.uTo.getString(R.l.esq), false, null);
                            }
                        });
                        return;
                    }
                    return;
                case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                    if (this.kPH != null) {
                        this.kPH.anp();
                        this.kPH.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    w.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (this.kPG == c.kQp) {
            lr(c.kQo);
        } else {
            super.onBackPressed();
        }
    }

    private void lr(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.kPG = i;
        switch (AnonymousClass9.kQf[i - 1]) {
            case 1:
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI kQc;

                    {
                        this.kQc = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kQc.finish();
                        return true;
                    }
                });
                kq(true);
                a(0, getString(R.l.edg), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI kQc;

                    {
                        this.kQc = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kQc.lr(c.kQp);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11596, new Object[]{Integer.valueOf(1)});
                        return true;
                    }
                });
                this.kPJ.setVisibility(8);
                anl();
                anh();
                break;
            case 2:
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI kQc;

                    {
                        this.kQc = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kQc.lr(c.kQo);
                        return true;
                    }
                });
                a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI kQc;

                    {
                        this.kQc = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kQc.lr(c.kQo);
                        return true;
                    }
                });
                this.kPJ.setVisibility(0);
                ank();
                anj();
                break;
            case 3:
                ani();
                break;
            case 4:
                break;
        }
        ani();
        if (this.kPH != null) {
            this.kPH.anp();
            this.kPH.notifyDataSetChanged();
        }
        w.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void anh() {
        if (this.kPU != null) {
            this.kPU.clear();
        }
        w.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    }

    private void ani() {
        this.kPJ.setVisibility(this.kPG == c.kQp ? 0 : 8);
    }

    private void anj() {
        if (this.kPG == c.kQp) {
            if ((this.kPU == null ? 0 : this.kPU.size()) > 0) {
                this.kPK.setText(getResources().getString(R.l.dGB));
                this.kPK.setEnabled(true);
                this.kPL.setEnabled(true);
            } else {
                this.kPK.setText(getResources().getString(R.l.dGB));
                this.kPK.setEnabled(false);
                this.kPL.setEnabled(false);
            }
            qP(getResources().getString(R.l.ecU, new Object[]{Integer.valueOf(r0)}));
        }
    }

    private boolean uD(String str) {
        String str2 = str;
        g.a(this.uSU.uTo, str2, "", "", getString(R.l.esq), null, null);
        return true;
    }

    private void ank() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, 0);
        }
    }

    private void anl() {
        boolean z = true;
        h.alZ();
        if (am.isConnected(ab.getContext())) {
            if (this.kPH == null || this.kPH.ano() <= com.tencent.mm.plugin.emoji.e.n.alO()) {
                z = false;
            } else {
                this.kPQ = true;
                this.kPN.setVisibility(0);
                int i = R.l.eea;
                this.kPO.setTextColor(getResources().getColor(R.e.aVD));
                this.kPO.setText(getString(i, new Object[]{Integer.valueOf(com.tencent.mm.plugin.emoji.e.n.alO())}));
                this.kPP.setVisibility(8);
                this.kPH.notifyDataSetChanged();
                ae(0, true);
                this.kPR = true;
            }
            if (!z) {
                this.kPR = false;
                return;
            }
            return;
        }
        ank();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof com.tencent.mm.plugin.emoji.f.c) {
            switch (((com.tencent.mm.plugin.emoji.f.c) kVar).hEc) {
                case 2:
                    amV();
                    if (i == 0 && i2 == 0) {
                        for (int i3 = 0; i3 < this.kPU.size(); i3++) {
                            w.i("MicroMsg.emoji.EmojiCustomUI", "mSelectedList md5:%s", new Object[]{this.kPU.get(i3)});
                            com.tencent.mm.plugin.report.service.g.oUh.A(10613, (String) this.kPU.get(i3));
                        }
                        com.tencent.mm.plugin.emoji.sync.a alZ = h.alZ();
                        ArrayList arrayList = this.kPU;
                        BKGLoaderManager bKGLoaderManager = alZ.kNA;
                        String str2 = "MicroMsg.BKGLoader.BKGLoaderManager";
                        String str3 = "cleanUploadTasks size%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
                        w.i(str2, str3, objArr);
                        if (bKGLoaderManager.kNY != null && arrayList != null && bKGLoaderManager.kNY.size() > 0 && arrayList.size() > 0) {
                            com.tencent.mm.plugin.emoji.sync.d dVar;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str4 = (String) it.next();
                                if (!bg.mA(str4)) {
                                    Iterator it2 = bKGLoaderManager.kNY.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.emoji.sync.d) it2.next();
                                        if (!bg.mA(dVar.getKey()) && dVar.getKey().equalsIgnoreCase(str4)) {
                                            arrayList2.add(dVar);
                                        }
                                    }
                                }
                            }
                            if (bKGLoaderManager.kNY != null && bKGLoaderManager.kNY.size() > 0 && arrayList2.size() > 0) {
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    bKGLoaderManager.kNY.remove((com.tencent.mm.plugin.emoji.sync.d) it3.next());
                                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "clean upload task :%s", new Object[]{dVar.getKey()});
                                }
                            }
                            arrayList2.clear();
                        }
                        h.amc().kLa.co(this.kPU);
                        anh();
                        anj();
                        this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, 100);
                        return;
                    }
                    w.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    uD(getString(R.l.eel));
                    return;
                case 3:
                    amV();
                    if (i == 0 && i2 == 0) {
                        h.amc().kLa.cp(this.kPU);
                        anh();
                        anj();
                        this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, 100);
                        return;
                    }
                    uD(getString(R.l.eel));
                    return;
                default:
                    return;
            }
        }
        w.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    }

    private void uE(String str) {
        getString(R.l.dIO);
        this.kIa = g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ EmojiCustomUI kQc;

            {
                this.kQc = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    private void amV() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }
}

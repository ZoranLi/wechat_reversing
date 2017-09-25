package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.co;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileySubGrid;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, com.tencent.mm.sdk.e.j.a, e {
    private View jAA;
    private ProgressBar kHL;
    private ProgressDialog kIa;
    private String kMS;
    private String kMT;
    private String kMU;
    private long kMa = 0;
    private String kMb = "";
    private com.tencent.mm.plugin.emoji.h.b kMe;
    private int kOU;
    private com.tencent.mm.sdk.b.c kOY = new com.tencent.mm.sdk.b.c<co>(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r2;
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            if (!(this.kRV.kMS == null || coVar.fFZ.fGa == null || !coVar.fFZ.fGa.equals(this.kRV.kMS))) {
                this.kRV.e(coVar.fFZ.fGa, coVar.fFZ.status, coVar.fFZ.progress, coVar.fFZ.fGb);
            }
            return false;
        }
    };
    private pj kPm = new pj();
    private String kPn = "";
    private int kQN;
    private String kQO;
    private boolean kQP;
    private boolean kQQ = false;
    private int kQR = -1;
    private l kQS;
    private g kQT;
    private o kQU;
    private a kQV;
    private ya kQW = null;
    private boolean kQX;
    private TextView kQY;
    private View kQZ;
    private int kRA;
    private String kRB;
    private boolean kRC;
    private int kRD;
    private int kRE = -1;
    private String kRF;
    private String[] kRG = new String[1];
    private boolean kRH = false;
    private View kRI;
    private boolean kRJ = true;
    private xs kRK;
    private boolean kRL = false;
    private boolean kRM = true;
    private OnClickListener kRN = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void onClick(View view) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + v.bIN());
            String str = this.kRV.getString(R.l.ecP) + v.bIN();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(this.kRV, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private OnClickListener kRO = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void onClick(View view) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + v.bIN());
            String str = this.kRV.getString(R.l.ecu) + v.bIN();
            Intent intent = new Intent();
            intent.putExtra("title", this.kRV.getString(R.l.ede));
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(this.kRV, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private OnClickListener kRP = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.kRV, EmojiStoreV2RewardUI.class);
            intent.putExtra("extra_id", this.kRV.kMS);
            intent.putExtra("extra_name", this.kRV.kPm.tuV);
            if (!(this.kRV.kPm == null || this.kRV.kPm.tvq == null)) {
                intent.putExtra("name", this.kRV.kPm.tvq.msj);
            }
            intent.putExtra("scene", this.kRV.kRA);
            intent.putExtra("pageType", 1);
            intent.putExtra("searchID", this.kRV.kMa);
            this.kRV.startActivity(intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(12738, new Object[]{this.kRV.kMS, Integer.valueOf(1), Integer.valueOf(this.kRV.kRA), Integer.valueOf(0)});
        }
    };
    private OnClickListener kRQ = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.kRV, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", this.kRV.kMS);
            intent.putExtra("extra_iconurl", this.kRV.kPm.muU);
            intent.putExtra("extra_name", this.kRV.kPm.tuV);
            if (this.kRV.kPm.tvq != null) {
                intent.putExtra("name", this.kRV.kPm.tvq.msj);
            }
            this.kRV.startActivity(intent);
        }
    };
    private i kRR = new i(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[]{str});
            if (bitmap != null) {
                this.kRV.lt(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT);
            }
        }
    };
    private i kRS = new i(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && this.kRV.mHandler != null) {
                Object obj;
                int intValue = ((Integer) objArr[0]).intValue();
                ap.yY();
                String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), this.kRV.kMS, str);
                String a = this.kRV.kMS;
                String str2 = ((apa) this.kRV.kPm.tvl.get(intValue)).tUa;
                com.tencent.mm.bg.a.getDensity(this.kRV.mContext);
                com.tencent.mm.storage.a.c a2 = EmojiLogic.a(a, 8, str2, true);
                com.tencent.mm.plugin.emoji.e.e alz = com.tencent.mm.plugin.emoji.e.e.alz();
                if (com.tencent.mm.a.e.aO(C)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int aN = com.tencent.mm.a.e.aN(C);
                    int i = aN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT ? WXMediaMessage.DESCRIPTION_LENGTH_LIMIT : aN;
                    Object c = com.tencent.mm.a.e.c(C, 0, aN);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.c(C, 0, i), alz.alA().getBytes(), true, false);
                    if (bg.bm(aesCryptEcb) || bg.bm(c)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, c, 0, i);
                        i = com.tencent.mm.a.e.b(C, c, aN);
                    }
                    if (i == 0) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        com.tencent.mm.plugin.report.service.g.oUh.a(252, 6, 1, false);
                        w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c.length), Long.valueOf(r10)});
                        obj = 1;
                    } else {
                        w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                        com.tencent.mm.plugin.report.service.g.oUh.a(252, 3, 1, false);
                        obj = null;
                    }
                } else {
                    w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file do no exsit.");
                    obj = null;
                }
                if (a2 != null) {
                    if (obj != null) {
                        a2.field_reserved4 = com.tencent.mm.storage.a.c.uLn;
                    } else {
                        a2.field_reserved4 = 0;
                    }
                    final com.tencent.mm.storage.a.c cVar = a2;
                    final int i2 = intValue;
                    this.kRV.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass21 kRW;

                        public final void run() {
                            SmileySubGrid q = this.kRW.kRV.kRh;
                            com.tencent.mm.storage.a.c cVar = cVar;
                            if (q.kVY == i2 && q.kVZ) {
                                q.m(cVar);
                                return;
                            }
                            w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "not show:%d, needData: %B, so do not refresh", new Object[]{Integer.valueOf(r2), Boolean.valueOf(q.kVZ)});
                        }
                    });
                    return;
                }
                w.i("MicroMsg.emoji.EmojiStoreDetailUI", "ignore no call back preview loader. ");
            }
        }
    };
    private j kRT = new j(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void ao(long j) {
            com.tencent.mm.plugin.report.service.g.oUh.A(10930, this.kRV.kMS + "," + j);
        }
    };
    private com.tencent.mm.pluginsdk.model.h.a kRU = new com.tencent.mm.pluginsdk.model.h.a(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void x(ArrayList<p> arrayList) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
            this.kRV.kRD = 12;
            if (arrayList != null && arrayList.size() > 0) {
                p pVar = (p) arrayList.get(0);
                if (pVar.sCE == 10232) {
                    this.kRV.kQR = 4;
                    this.kRV.kRF = pVar.sCB;
                } else {
                    this.kRV.kQR = 10;
                    this.kRV.kRE = pVar.sCE;
                }
                this.kRV.lt(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
            }
        }
    };
    private EmojiDetailScrollView kRa;
    private BannerEmojiView kRb;
    private TextView kRc;
    private MMAutoSizeTextView kRd;
    private TextView kRe;
    private TextView kRf;
    private TextView kRg;
    private EmojiDetailGridView kRh;
    private ImageView kRi;
    private View kRj;
    private TextView kRk;
    private TextView kRl;
    private int kRm;
    private View kRn;
    private ProgressBar kRo;
    private View kRp;
    private ImageView kRq;
    private TextView kRr;
    private View kRs;
    private View kRt;
    private MMCopiableTextView kRu;
    private Button kRv;
    private DonorsAvatarView kRw;
    private TextView kRx;
    private int kRy;
    private int kRz;
    private int kxD;
    private Context mContext;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        {
            this.kRV = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    EmojiStoreDetailUI.e(this.kRV);
                    return;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    this.kRV.anx();
                    return;
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    this.kRV.anA();
                    return;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    if (this.kRV.kRf.getVisibility() == 0) {
                        this.kRV.kRf.setVisibility(8);
                        this.kRV.kRj.setVisibility(0);
                        this.kRV.kRi.setVisibility(0);
                    }
                    this.kRV.kHL.setProgress(this.kRV.sd);
                    return;
                case MMBitmapFactory.ERROR_IO_FAILED /*1005*/:
                    this.kRV.kRa.scrollTo(0, 0);
                    return;
                case MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT /*1006*/:
                    this.kRV.dv(false);
                    return;
                case MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE /*1007*/:
                    this.kRV.any();
                    return;
                default:
                    w.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    private int mNumColumns;
    private int sd;

    class a extends BaseAdapter {
        final /* synthetic */ EmojiStoreDetailUI kRV;

        public a(EmojiStoreDetailUI emojiStoreDetailUI) {
            this.kRV = emojiStoreDetailUI;
        }

        public int getCount() {
            return this.kRV.kPm == null ? 0 : this.kRV.kPm.tvb;
        }

        public Object getItem(int i) {
            if (this.kRV.kPm == null || this.kRV.kPm.tvl == null || this.kRV.kPm.tvl.size() <= 0 || this.kRV.kPm.tvl.get(i) == null || ((apa) this.kRV.kPm.tvl.get(i)).tUa == null) {
                return null;
            }
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[]{Integer.valueOf(i)});
            String a = this.kRV.kMS;
            String str = ((apa) this.kRV.kPm.tvl.get(i)).tUa;
            com.tencent.mm.bg.a.getDensity(this.kRV.mContext);
            com.tencent.mm.storage.a.c a2 = EmojiLogic.a(a, 8, str, false);
            if (a2 == null) {
                w.d("MicroMsg.emoji.EmojiStoreDetailUI", "detail preview emoji is null.");
                n.GW().a(((apa) this.kRV.kPm.tvl.get(i)).tUa, null, f.a(this.kRV.kMS, ((apa) this.kRV.kPm.tvl.get(i)).tUa, Integer.valueOf(i)), this.kRV.kRS, this.kRV.kRT, null, null, null);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.A(10930, this.kRV.kMS + ",0");
                if (com.tencent.mm.plugin.emoji.e.e.alz().isEnable()) {
                    a2.field_reserved4 = com.tencent.mm.storage.a.c.uLn;
                }
            }
            lu(i);
            return a2;
        }

        private void lu(int i) {
            int[] iArr = new int[]{i - 1, i + 1, i - 4, i + 4};
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = iArr[i2];
                if (this.kRV.kPm != null && i3 >= 0 && i3 < this.kRV.kPm.tvk) {
                    ap.yY();
                    if (!com.tencent.mm.a.e.aO(EmojiLogic.C(com.tencent.mm.u.c.xi(), this.kRV.kMS, ((apa) this.kRV.kPm.tvl.get(i3)).tUa))) {
                        n.GW().a(((apa) this.kRV.kPm.tvl.get(i3)).tUa, null, f.a(this.kRV.kMS, ((apa) this.kRV.kPm.tvl.get(i3)).tUa, Integer.valueOf(i3)), this.kRV.kRS, this.kRV.kRT, null, null, null);
                    }
                }
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.kRV.mContext).inflate(R.i.day, null);
                c cVar2 = new c(this.kRV, view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (this.kRV.kRh.kWa) {
                cVar.kRY.setBackgroundResource(R.g.bkd);
            } else {
                cVar.kRY.setBackgroundDrawable(null);
            }
            String str = "";
            if (this.kRV.kPm.tvc != null) {
                str = com.tencent.mm.platformtools.n.a((avx) this.kRV.kPm.tvc.get(i));
            }
            n.GW().a(str, cVar.kRY, f.bL(this.kRV.kMS, str));
            return view;
        }
    }

    class c {
        final /* synthetic */ EmojiStoreDetailUI kRV;
        SquareImageView kRY;

        public c(EmojiStoreDetailUI emojiStoreDetailUI, View view) {
            this.kRV = emojiStoreDetailUI;
            this.kRY = (SquareImageView) view.findViewById(R.h.bIC);
            this.kRY.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    class b extends a {
        final /* synthetic */ EmojiStoreDetailUI kRV;
        private ArrayList<com.tencent.mm.storage.a.c> kRX;

        public final /* synthetic */ Object getItem(int i) {
            return ls(i);
        }

        public b(EmojiStoreDetailUI emojiStoreDetailUI) {
            this.kRV = emojiStoreDetailUI;
            super(emojiStoreDetailUI);
            this.kRX = new ArrayList();
            this.kRX = (ArrayList) h.amc().kLa.ud(com.tencent.mm.plugin.emoji.h.a.aoK());
        }

        public final int getCount() {
            return this.kRX == null ? 0 : this.kRX.size();
        }

        private com.tencent.mm.storage.a.c ls(int i) {
            return this.kRX == null ? null : (com.tencent.mm.storage.a.c) this.kRX.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.kRV.mContext).inflate(R.i.day, null);
                cVar = new c(this.kRV, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kRY.setBackgroundResource(R.g.bkd);
            com.tencent.mm.storage.a.c ls = ls(i);
            n.GW().a((bg.mA(ls.pM()) ? ls.getName() : ls.pM()).split("\\.")[0], cVar.kRY, f.alB());
            return view;
        }
    }

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        if (!com.tencent.mm.plugin.emoji.h.a.uR(emojiStoreDetailUI.kMS)) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable() && h.amc().kLb.Sc(emojiStoreDetailUI.kMS)) {
                if (h.amc().kLa.Se(emojiStoreDetailUI.kMS) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    File file = new File(stringBuilder.append(com.tencent.mm.u.c.xi()).append(emojiStoreDetailUI.kMS).toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            h.amc().kLb.Sd(emojiStoreDetailUI.kMS);
                            h.amc().kLa.Sk(emojiStoreDetailUI.kMS);
                        } else {
                            emojiStoreDetailUI.kQX = true;
                            emojiStoreDetailUI.kQR = 7;
                            emojiStoreDetailUI.anA();
                            return;
                        }
                    }
                }
                h.amc().kLa.Sk(emojiStoreDetailUI.kMS);
            }
            emojiStoreDetailUI.kQX = false;
        }
    }

    static /* synthetic */ void u(EmojiStoreDetailUI emojiStoreDetailUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(emojiStoreDetailUI.mContext, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new com.tencent.mm.ui.base.n.c(emojiStoreDetailUI) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.a(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kRV.getString(R.l.fnw), R.k.duZ);
                lVar.a(1000, this.kRV.getString(R.l.fnv), R.k.duP);
            }
        };
        eVar.qJg = new com.tencent.mm.ui.base.n.d(emojiStoreDetailUI) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        k.a(this.kRV.uSU.uTo, this.kRV.kPm.tuV + this.kRV.getString(R.l.edK), this.kRV.kPm.tuW, this.kRV.kPm.muU, this.kRV.kPm.tvo, EmojiLogic.um(this.kRV.kMS), 4);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(1), this.kRV.kMS, ""});
                        return;
                    case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                        k.bQ(this.kRV.uSU.uTo);
                        this.kRV.uSU.uTo.overridePendingTransition(R.a.aRq, R.a.aQY);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(2), this.kRV.kMS, ""});
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
        com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", ""});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kRC = m.xX();
        this.kMe = new com.tencent.mm.plugin.emoji.h.b(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
        Intent intent = getIntent();
        this.kMS = getIntent().getStringExtra("extra_id");
        this.kOU = getIntent().getIntExtra("preceding_scence", -1);
        this.kMT = getIntent().getStringExtra("extra_name");
        this.kQN = getIntent().getIntExtra("call_by", -1);
        Object stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kMS = EmojiLogic.ui(stringExtra);
            this.kOU = 0;
            this.kOU = 10;
            com.tencent.mm.plugin.report.service.g.oUh.i(10993, new Object[]{Integer.valueOf(3), this.kMS});
        }
        if (TextUtils.isEmpty(this.kMS)) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.kOU == -1) {
            w.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.kRJ = intent.getBooleanExtra("check_clickflag", true);
        this.kRB = intent.getStringExtra("cdn_client_id");
        this.kRA = intent.getIntExtra("download_entrance_scene", 0);
        this.kMa = intent.getLongExtra("searchID", 0);
        this.kMb = bg.ap(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tvf = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tvd = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tuW = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tuY = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.kPm.tuZ = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.kPm.tva = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tvh = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kPm.tvg = stringExtra;
        }
        if (this.kRC) {
            this.kRF = intent.getStringExtra("google_price");
            if (TextUtils.isEmpty(this.kRF)) {
                this.kRD = 11;
                com.tencent.mm.pluginsdk.model.h.a(this, this.kRG, this.kRU);
            }
        }
        this.kQP = intent.getBooleanExtra("reward_tip", false);
        this.kRG[0] = this.kMS;
        this.kPm.tgW = this.kMS;
        this.kPm.tuV = this.kMT;
        this.kPm.tvn = this.kQO;
        this.kPm.jOb = -1;
        this.mContext = this;
        KC();
        if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS)) {
            Context context = this.uSU.uTo;
            pj pjVar = new pj();
            pjVar.tgW = com.tencent.mm.storage.a.a.uKQ;
            pjVar.tuV = context.getString(R.l.edU);
            pjVar.tuW = context.getString(R.l.edS);
            pjVar.tuX = context.getString(R.l.edQ);
            pjVar.tuY = "";
            pjVar.tuZ = 0;
            pjVar.tva = 1;
            pjVar.tvd = "";
            pjVar.tve = 0;
            pjVar.tvf = context.getString(R.l.edR);
            pjVar.tvi = "";
            pjVar.tvg = "";
            pjVar.tvh = "";
            pjVar.tvm = context.getString(R.l.edT);
            this.kPm = pjVar;
            this.kRL = true;
            this.kRK = EmojiLogic.alQ();
            anw();
        } else {
            com.tencent.mm.storage.a.k Sn = h.amc().kLe.Sn(this.kMS);
            if (!(Sn == null || Sn.field_content == null)) {
                xu xuVar = new xu();
                try {
                    xuVar.aD(Sn.field_content);
                    this.kPm = xuVar.tEk;
                    this.kPn = Sn.field_lan;
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmojiStoreDetailUI", "exception:%s", new Object[]{bg.g(e)});
                }
            }
            if (this.kPm == null) {
                this.kQS = new l(this.kMS, this.kOU);
            } else if (bg.mA(this.kPn) || !this.kPn.equalsIgnoreCase(v.ea(this.mContext))) {
                this.kQS = new l(this.kMS, this.kOU);
            } else {
                this.kQS = new l(this.kMS, this.kOU, this.kPm.jOb);
            }
            ap.vd().a(this.kQS, 0);
            if (this.kQN == -1 || this.kQN == 3) {
                this.kQZ.setVisibility(8);
                this.jAA.setVisibility(8);
                getString(R.l.dIO);
                this.kIa = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ EmojiStoreDetailUI kRV;

                    {
                        this.kRV = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(this.kRV.kQS);
                        this.kRV.kQY.setText(R.l.edo);
                        this.kRV.ant();
                    }
                });
            }
            anu();
            if (this.kRJ) {
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.k(this.kMS), 0);
            } else {
                this.kRL = true;
                this.kRK = EmojiLogic.alQ();
            }
        }
        anx();
        h.amc().kLb.c(this);
        com.tencent.mm.sdk.b.a.urY.b(this.kOY);
        ap.vd().a(423, this);
        ap.vd().a(822, this);
        e(this.kMS, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.kRB);
        this.kRM = true;
        com.tencent.mm.plugin.report.service.g.oUh.i(12740, new Object[]{Integer.valueOf(1), "", this.kMS, "", Integer.valueOf(this.kRA)});
        if (this.kQP && this.kRa != null) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ EmojiStoreDetailUI kRV;

                {
                    this.kRV = r1;
                }

                public final void run() {
                    this.kRV.kRa.fullScroll(130);
                }
            }, 0);
        }
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.bLx;
    }

    protected final void KC() {
        if (!bg.mA(this.kMT)) {
            qP(this.kMT);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kRV.finish();
                return true;
            }
        });
        this.kxD = com.tencent.mm.bg.a.T(this.mContext, R.f.aZA);
        this.kRy = getResources().getDimensionPixelSize(R.f.aZz);
        this.kRy = com.tencent.mm.bg.a.T(this.mContext, R.f.aZz);
        this.mNumColumns = 4;
        this.kRa = (EmojiDetailScrollView) findViewById(R.h.cAf);
        this.jAA = findViewById(R.h.empty);
        this.kQY = (TextView) this.jAA.findViewById(R.h.bLN);
        this.kQZ = findViewById(R.h.bLx);
        this.kRb = (BannerEmojiView) findViewById(R.h.bLi);
        this.kRb.setMinimumHeight((int) (((float) (((this.kRb.getRight() - this.kRb.getLeft()) - this.kRb.getPaddingRight()) - this.kRb.getPaddingLeft())) * 0.56f));
        this.kRc = (TextView) findViewById(R.h.bLG);
        this.kRd = (MMAutoSizeTextView) findViewById(R.h.bLH);
        this.kRe = (TextView) findViewById(R.h.bKY);
        this.kRf = (TextView) findViewById(R.h.bLI);
        this.kRg = (TextView) findViewById(R.h.bLb);
        this.kRm = com.tencent.mm.bg.a.dO(this.uSU.uTo);
        this.kRn = findViewById(R.h.bKT);
        this.kRh = (EmojiDetailGridView) findViewById(R.h.bLf);
        if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS)) {
            this.kQV = new b(this);
        } else {
            this.kQV = new a(this);
        }
        this.kRj = findViewById(R.h.bLo);
        this.kHL = (ProgressBar) findViewById(R.h.bLd);
        this.kRi = (ImageView) findViewById(R.h.bKW);
        this.kRi.setOnClickListener(this);
        this.kRj.setVisibility(8);
        this.kRi.setVisibility(8);
        this.kHL.setProgress(0);
        this.kRh.setAdapter(this.kQV);
        this.kRh.setColumnWidth(this.kRy);
        this.kRh.setNumColumns(this.mNumColumns);
        this.kRh.setHorizontalSpacing(this.kxD);
        this.kRh.setVerticalSpacing(this.kxD);
        this.kRh.kQw = this.kRa;
        this.kRh.kVX = true;
        this.kRf.setOnClickListener(this);
        this.kRk = (TextView) findViewById(R.h.bLr);
        this.kRl = (TextView) findViewById(R.h.bKX);
        this.kRk.setOnClickListener(this.kRN);
        this.kRl.setOnClickListener(this.kRO);
        this.kRo = (ProgressBar) findViewById(R.h.bLe);
        this.kRo.setVisibility(this.kRC ? 0 : 8);
        this.kRI = findViewById(R.h.bLl);
        this.kRs = findViewById(R.h.bLa);
        this.kRp = findViewById(R.h.bId);
        this.kRq = (ImageView) findViewById(R.h.bIi);
        this.kRr = (TextView) findViewById(R.h.bIr);
        this.kRt = findViewById(R.h.bLp);
        this.kRu = (MMCopiableTextView) findViewById(R.h.cyK);
        this.kRv = (Button) findViewById(R.h.cyL);
        this.kRx = (TextView) findViewById(R.h.cyP);
        this.kRw = (DonorsAvatarView) findViewById(R.h.cyJ);
        this.kRv.setOnClickListener(this.kRP);
        this.kRx.setOnClickListener(this.kRQ);
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(412, this);
        ap.vd().a(521, this);
        this.kRH = false;
        if (!this.kRM) {
            anu();
            lt(MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
        }
        anv();
        this.kRM = false;
        lt(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(412, this);
        ap.vd().b(521, this);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        h.amc().kLb.f(this);
        com.tencent.mm.sdk.b.a.urY.c(this.kOY);
        ap.vd().b(423, this);
        ap.vd().b(822, this);
        if (this.kRh != null) {
            this.kRh.release();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(DownloadInfo.STATUS, this.kQR);
        bundle.putInt("progress", this.sd);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.kQR = bundle.getInt(DownloadInfo.STATUS);
        this.sd = bundle.getInt("progress");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.bLI) {
            String stringExtra;
            if (this.kQR == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (bg.mA(stringExtra) || !this.kQQ) {
                    this.kMe.u(this);
                    com.tencent.mm.plugin.report.service.g.oUh.i(12069, new Object[]{Integer.valueOf(2), this.kMS});
                } else {
                    com.tencent.mm.plugin.emoji.h.b.a(stringExtra, this.kMS, (Activity) this);
                }
                w.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                com.tencent.mm.plugin.report.service.g.oUh.A(11076, "0, ");
                return;
            }
            switch (this.kQR) {
                case -1:
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                case 0:
                case 3:
                    anD();
                    this.kQR = 6;
                    anA();
                    com.tencent.mm.plugin.report.service.g.oUh.i(12066, new Object[]{Integer.valueOf(1), Integer.valueOf(this.kRA), "", this.kMS, Long.valueOf(this.kMa), this.kMb});
                    return;
                case 4:
                    if (!this.kRH) {
                        w.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[]{this.kMS, this.kPm.tuY, this.kPm.tvh});
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.kMS);
                        if (this.kRC) {
                            intent.putExtra("key_currency_type", "");
                            intent.putExtra("key_price", this.kRF);
                        } else {
                            intent.putExtra("key_currency_type", this.kPm.tvh);
                            intent.putExtra("key_price", this.kPm.tvg);
                        }
                        d.b(this, "wallet_index", ".ui.WalletIapUI", intent, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
                        com.tencent.mm.plugin.report.service.g.oUh.i(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.kRA), "", this.kMS, Long.valueOf(this.kMa), this.kMb});
                        this.kRH = true;
                        return;
                    }
                    return;
                case 5:
                    this.kQR = 3;
                    anA();
                    return;
                case 10:
                case 12:
                    switch (this.kRE) {
                        case 10233:
                            stringExtra = getString(R.l.ecK);
                            break;
                        case 10234:
                            stringExtra = getString(R.l.ecE);
                            break;
                        case 10235:
                            stringExtra = getString(R.l.eek);
                            break;
                        default:
                            stringExtra = getString(R.l.eeo);
                            break;
                    }
                    com.tencent.mm.ui.base.g.b(this, stringExtra, null, true);
                    return;
                case 11:
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                default:
                    w.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[]{Integer.valueOf(this.kQR)});
                    return;
            }
        } else if (id == R.h.bLd) {
            anC();
        } else if (id == R.h.bKW) {
            anC();
        } else {
            w.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
        switch (kVar.getType()) {
            case 412:
                w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                l lVar = (l) kVar;
                if (lVar == null || bg.mA(lVar.kMS) || !lVar.kMS.equalsIgnoreCase(this.kMS)) {
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0) {
                    if (i2 == 0) {
                        this.kPm = lVar.amq();
                        lt(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                        return;
                    } else if (i2 == 1) {
                        ans();
                        return;
                    } else {
                        this.kQY.setText(R.l.edn);
                        ant();
                        return;
                    }
                } else if (i2 == 5) {
                    if (!(lVar == null || lVar.amq() == null)) {
                        this.kPm.tva = lVar.amq().tva;
                    }
                    lt(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                    return;
                } else if (i2 == 1) {
                    ans();
                    return;
                } else {
                    this.kRa.setVisibility(8);
                    this.jAA.setVisibility(0);
                    this.kQY.setText(R.l.edo);
                    ant();
                    return;
                }
            case 423:
                w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                g gVar = (g) kVar;
                if (gVar == null || bg.mA(gVar.kMS) || !gVar.kMS.equalsIgnoreCase(this.kMS)) {
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.kRB = gVar.hGx;
                    this.kQR = 6;
                    anA();
                    return;
                } else {
                    this.kQR = -1;
                    anA();
                    String str2 = this.kMT;
                    com.tencent.mm.ui.base.g.a(this, String.format(getString(R.l.edj), new Object[]{str2}), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ EmojiStoreDetailUI kRV;

                        {
                            this.kRV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kRV.kQT = new g(this.kRV.kMS, this.kRV.kMU, this.kRV.kMT);
                            this.kRV.anD();
                            this.kRV.kQR = 6;
                            this.kRV.anA();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ EmojiStoreDetailUI kRV;

                        {
                            this.kRV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            case 521:
                w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                com.tencent.mm.plugin.emoji.f.k kVar2 = (com.tencent.mm.plugin.emoji.f.k) kVar;
                if (kVar2 == null || bg.mA(kVar2.kMI) || !kVar2.kMI.equalsIgnoreCase(this.kMS)) {
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.kRK = (xs) kVar2.gUA.hsk.hsr;
                    } else {
                        this.kRK = null;
                    }
                    this.kRL = true;
                    anB();
                }
                this.kRL = true;
                anB();
                return;
            case 822:
                w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                if (i == 0 && i2 == 0) {
                    this.kQW = ((o) kVar).amu();
                    lt(MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void ans() {
        this.jAA.setVisibility(0);
        this.kQZ.setVisibility(8);
        this.kRa.setVisibility(8);
        this.kQY.setText(R.l.ecJ);
    }

    private void ant() {
        w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.kPm == null || this.kPm.tva == 0) {
            this.jAA.setVisibility(0);
            this.kQZ.setVisibility(8);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String str;
        String stringExtra;
        if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            str = "";
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                w.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + intExtra);
                stringExtra = intent.getStringExtra("key_err_msg");
                w.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + stringExtra);
            } else {
                stringExtra = str;
                intExtra = 0;
            }
            this.kRH = false;
            if (i2 != -1) {
                this.kQR = -1;
                anA();
                if (m.xX()) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 2, 1, false);
                }
            } else if (intent != null && r0 == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.kMS)) {
                    this.kQR = -1;
                    anA();
                    uw(stringExtra);
                    return;
                }
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    if (this.kMS.equals(stringArrayListExtra.get(i3))) {
                        this.kMU = (String) stringArrayListExtra2.get(i3);
                    }
                }
                this.kPm.tva = 1;
                anD();
                this.kQR = 6;
                com.tencent.mm.ui.base.g.bl(this, stringExtra);
                if (m.xX()) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 4, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 0, 1, false);
                }
            } else if (intent != null && r0 == 103) {
                anD();
                this.kQR = 6;
                this.kQV.notifyDataSetChanged();
                if (m.xX()) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 7, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 3, 1, false);
                }
            } else if (intent == null || r0 != 100000000) {
                this.kQR = -1;
                anA();
                uw(stringExtra);
                if (m.xX()) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 5, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 1, 1, false);
                }
            } else {
                this.kQR = -1;
                anA();
                if (m.xX()) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(166, 2, 1, false);
                }
            }
        } else if (i == MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                if (!bg.mA(stringExtra)) {
                    w.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + stringExtra);
                    String str2 = this.kMS;
                    String str3 = this.kPm.tuV;
                    String str4 = this.kPm.tuW;
                    String str5 = this.kPm.muU;
                    String str6 = this.kPm.tvo;
                    int i4 = this.kPm.tva;
                    str = new StringBuffer(getResources().getString(R.l.dGN)).append(str3).toString();
                    com.tencent.mm.pluginsdk.ui.applet.d.a aVar = new com.tencent.mm.pluginsdk.ui.applet.d.a(this);
                    aVar.bs(stringExtra).MP(str).xp(R.l.dIA);
                    aVar.MQ(str5).bEV();
                    aVar.MS(getString(R.l.dXj)).a(new com.tencent.mm.plugin.emoji.e.k.AnonymousClass1(stringExtra, str2, str3, str4, str5, str6, i4, this)).oHT.show();
                }
            }
        } else if (i == this.kMe.jiv && i2 == -1) {
            w.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[]{intent.getStringExtra("Select_Conv_User")});
            com.tencent.mm.plugin.emoji.h.b.a(intent, this.kMS, (Activity) this);
            com.tencent.mm.plugin.report.service.g.oUh.i(12069, new Object[]{Integer.valueOf(3), this.kMS});
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        lt(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    private void uw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.ecO);
        }
        com.tencent.mm.ui.base.g.a(this, str, "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void anu() {
        this.kQW = h.amc().kLf.So(this.kMS);
    }

    private void anv() {
        if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tva, 64) && com.tencent.mm.plugin.emoji.e.n.alN()) {
            this.kQU = new o(this.kMS, o.kNp);
            ap.vd().a(this.kQU, 0);
        }
    }

    private boolean anw() {
        boolean anw = com.tencent.mm.plugin.emoji.h.a.anw();
        this.kQX = anw;
        this.kQR = anw ? 7 : 3;
        return anw;
    }

    private void anx() {
        if (!bg.mA(this.kPm.tuV)) {
            qP(this.kPm.tuV);
        }
        w.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[]{this.kPm.tvi});
        this.kQZ.setVisibility(0);
        this.jAA.setVisibility(8);
        dv(true);
        this.kRd.setText(this.kPm.tuV);
        this.kRe.setText(this.kPm.tvf);
        this.kRg.setText(this.kPm.tuW);
        if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tuZ, 1)) {
            this.kRc.setVisibility(8);
        } else {
            this.kRc.setVisibility(0);
            this.kRc.setText(R.l.een);
        }
        anz();
        anA();
        anB();
        if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS) || !(this.kPm.tvl == null || this.kPm.tvl.size() <= 0 || ((apa) this.kPm.tvl.get(0)).tUa == null)) {
            this.kRh.kWa = true;
            this.kRI.setVisibility(0);
        } else {
            this.kRI.setVisibility(8);
            this.kRh.kWa = false;
        }
        this.kRh.kMS = this.kMS;
        if (this.kQV != null) {
            this.kQV.notifyDataSetInvalidated();
        }
        w.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[]{this.kPm.tva});
        if ((this.kPm.tva & 16) == 16) {
            a(0, R.k.dyx, new OnMenuItemClickListener(this) {
                final /* synthetic */ EmojiStoreDetailUI kRV;

                {
                    this.kRV = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    w.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
                    EmojiStoreDetailUI.u(this.kRV);
                    return true;
                }
            });
        }
        this.kRd.setMaxWidth((((this.kRm - this.kRn.getWidth()) - (com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXH) * 2)) - this.kRc.getWidth()) - (com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXw) * 2));
        this.kRd.setVisibility(8);
        this.kRd.setVisibility(0);
        if (this.kPm.tvq == null || this.kPm.tvq.tDV == 0 || this.kRA == 6) {
            this.kRs.setVisibility(8);
            this.kRp.setVisibility(8);
        } else {
            this.kRs.setVisibility(0);
            this.kRp.setVisibility(0);
            n.GW().a(this.kPm.tvq.tvr, this.kRq, f.bM(this.kMS, this.kPm.tvq.tvr));
            this.kRr.setText(this.kPm.tvq.msj);
            this.kRp.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EmojiStoreDetailUI kRV;

                {
                    this.kRV = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(this.kRV.uSU.uTo, EmojiStoreV2DesignerUI.class);
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, this.kRV.kPm.tvq.tDV);
                    intent.putExtra("name", this.kRV.kPm.tvq.msj);
                    intent.putExtra("headurl", this.kRV.kPm.tvq.tvr);
                    intent.putExtra("rediret_url", this.kRV.kPm.tvo);
                    intent.putExtra("searchID", this.kRV.kMa);
                    intent.putExtra("extra_scence", 26);
                    this.kRV.uSU.uTo.startActivity(intent);
                }
            });
        }
        LayoutParams layoutParams;
        if ((this.kPm.tva & 32) == 32) {
            layoutParams = (LayoutParams) this.kRl.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.kRk.getLayoutParams();
            this.kRl.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXH);
            this.kRl.setLayoutParams(layoutParams);
            this.kRl.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXH);
            this.kRk.setLayoutParams(layoutParams2);
            this.kRk.setGravity(5);
        } else {
            layoutParams = (LayoutParams) this.kRk.getLayoutParams();
            layoutParams.gravity = 17;
            this.kRk.setLayoutParams(layoutParams);
            this.kRk.setGravity(17);
            this.kRl.setVisibility(8);
        }
        any();
    }

    private void dv(boolean z) {
        com.tencent.mm.storage.a.c cVar;
        if (bg.mA(this.kPm.tvd)) {
            cVar = null;
        } else if (z) {
            r0 = this.kMS;
            String str = this.kPm.tvd;
            com.tencent.mm.bg.a.getDensity(this.mContext);
            cVar = EmojiLogic.a(r0, str, this.kRR);
        } else {
            r0 = this.kMS;
            String str2 = this.kPm.tvd;
            com.tencent.mm.bg.a.getDensity(this.mContext);
            cVar = EmojiLogic.a(r0, 4, str2, true);
        }
        if (!(cVar == null || this.kRb == null)) {
            this.kRb.ct(cVar.eN(cVar.field_groupId, cVar.EP()), null);
        }
        if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS)) {
            this.kRb.setImageResource(R.g.bkT);
        }
    }

    public final void any() {
        if (!com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tva, 64) || !com.tencent.mm.plugin.emoji.e.n.alN()) {
            this.kRt.setVisibility(8);
        } else if (this.kQW != null) {
            this.kRt.setVisibility(0);
            this.kRv.setText(R.l.edz);
            this.kRu.setText(this.kQW.tEC.tvv);
            this.kRu.setLongClickable(false);
            if (this.kQW.tEl > 0) {
                this.kRx.setVisibility(0);
                String valueOf = String.valueOf(this.kQW.tEl);
                Object format = String.format(getString(R.l.edB), new Object[]{Integer.valueOf(this.kQW.tEl)});
                CharSequence spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.aTG)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.kRx.setText(spannableString);
            } else {
                this.kRx.setVisibility(8);
            }
            if (this.kQW.tEm == null || this.kQW.tEm.size() <= 0) {
                this.kRw.setVisibility(8);
                return;
            }
            this.kRw.setVisibility(0);
            this.kRw.b(this.kMS, this.kQW.tEm);
        } else {
            this.kRt.setVisibility(8);
            anv();
        }
    }

    private void anz() {
        if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tuZ, 8)) {
            this.kRz = 0;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tuZ, 4)) {
            this.kRz = 0;
        } else if (this.kRC || !TextUtils.isEmpty(this.kPm.tuY)) {
            this.kRz = 1;
        } else {
            this.kRz = 0;
        }
        w.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[]{Integer.valueOf(this.kPm.tva)});
        if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tva, 8) && com.tencent.mm.plugin.emoji.a.a.e.lo(this.kPm.tuZ)) {
            this.kQR = 8;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tva, 1) || com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tuZ, 8)) {
            this.kQR = 3;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.lo(this.kPm.tuZ)) {
            this.kQR = 0;
        } else if (!this.kRC && (TextUtils.isEmpty(this.kPm.tvg) || this.kPm.tvg.equals("0"))) {
            this.kQR = 0;
        } else if (!this.kRC) {
            this.kQR = 4;
        } else if (TextUtils.isEmpty(this.kRF)) {
            this.kQR = this.kRD;
        } else {
            this.kQR = 4;
        }
        if (this.kQX) {
            this.kQR = 7;
        }
    }

    private void anA() {
        while (true) {
            if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS)) {
                anw();
            }
            switch (this.kQR) {
                case -1:
                    anz();
                case 0:
                    this.kRo.setVisibility(8);
                    this.kRf.setTextColor(getResources().getColorStateList(R.e.aWx));
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setText(R.l.edi);
                    this.kRf.setEnabled(true);
                    return;
                case 3:
                    this.kRo.setVisibility(8);
                    this.kRf.setTextColor(getResources().getColorStateList(R.e.aWx));
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setText(R.l.edi);
                    this.kRf.setEnabled(true);
                    return;
                case 4:
                    this.kRo.setVisibility(8);
                    this.kRf.setTextColor(getResources().getColorStateList(R.e.aWx));
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setEnabled(true);
                    if (!this.kRC) {
                        this.kRf.setText(this.kPm.tuY);
                        this.kQR = 4;
                        return;
                    } else if (bg.mA(this.kRF)) {
                        this.kRf.setText("");
                        return;
                    } else {
                        this.kRf.setText(this.kRF);
                        return;
                    }
                case 5:
                    this.kRo.setVisibility(8);
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setText(R.l.edi);
                    this.kRf.setEnabled(true);
                    break;
                case 6:
                    this.kRo.setVisibility(8);
                    this.kRf.setEnabled(false);
                    this.kRj.setVisibility(0);
                    this.kRi.setVisibility(0);
                    this.kRf.setVisibility(4);
                    if (this.kQN == 3) {
                        return;
                    }
                    return;
                case 7:
                    this.kRo.setVisibility(8);
                    this.kRf.setEnabled(true);
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setText(R.l.edX);
                    this.kRj.setVisibility(8);
                    this.kHL.setProgress(0);
                    this.kRi.setVisibility(4);
                    this.kRf.setVisibility(0);
                    if (this.kQN == 3) {
                        return;
                    }
                    return;
                case 8:
                    this.kRo.setVisibility(8);
                    this.kRf.setTextColor(getResources().getColorStateList(R.e.aTF));
                    this.kRf.setBackgroundResource(R.g.bdd);
                    this.kRf.setText(R.l.edl);
                    this.kRf.setEnabled(false);
                    return;
                case 10:
                case 12:
                    this.kRo.setVisibility(8);
                    this.kRf.setVisibility(0);
                    this.kRf.setBackgroundResource(R.g.bda);
                    this.kRf.setText(R.l.edu);
                    this.kRf.setEnabled(true);
                    this.kRj.setVisibility(8);
                    this.kHL.setProgress(0);
                    this.kRi.setVisibility(4);
                    return;
                case 11:
                    break;
                default:
                    w.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[]{Integer.valueOf(this.kQR)});
                    return;
            }
            this.kRo.setVisibility(0);
            this.kRf.setVisibility(0);
            this.kRf.setBackgroundResource(R.g.bmi);
            this.kRf.setText("");
            this.kRf.setEnabled(false);
            this.kRj.setVisibility(8);
            this.kHL.setProgress(0);
            this.kRi.setVisibility(4);
            return;
        }
    }

    private void anB() {
        if (!this.kRL) {
            return;
        }
        if (this.kRK != null && (this.kRK.tEj & 1) == 1) {
            return;
        }
        if ((this.kPm == null || !com.tencent.mm.plugin.emoji.a.a.e.bO(this.kPm.tva, 1)) && this.kRK != null && !TextUtils.isEmpty(this.kRK.tEi)) {
            this.kRf.setText(this.kRK.tEi);
            this.kRf.setTextColor(this.uSU.uTo.getResources().getColor(R.e.aUk));
            this.kRf.setBackgroundDrawable(null);
            this.kRf.setEnabled(false);
        }
    }

    private void anC() {
        com.tencent.mm.ui.base.g.a(this, R.l.edd, 0, R.l.edL, R.l.edf, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (com.tencent.mm.plugin.emoji.h.a.uR(this.kRV.kMS)) {
                    w.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                    com.tencent.mm.plugin.emoji.f.a.amh().amj();
                } else {
                    ap.vd().c(this.kRV.kQT);
                }
                if (!TextUtils.isEmpty(this.kRV.kRB)) {
                    com.tencent.mm.modelcdntran.g.El().iP(this.kRV.kRB);
                    w.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[]{this.kRV.kRB});
                }
                if (com.tencent.mm.plugin.emoji.a.a.e.bO(this.kRV.kPm.tva, 1) || com.tencent.mm.plugin.emoji.a.a.e.lo(this.kRV.kPm.tuZ)) {
                    this.kRV.kQR = 3;
                } else {
                    this.kRV.kQR = -1;
                }
                h.ame().d(this.kRV.kMS, this.kRV.kQR, 0, this.kRV.kRB);
                this.kRV.kRj.setVisibility(8);
                this.kRV.kHL.setProgress(0);
                this.kRV.kRi.setVisibility(4);
                this.kRV.kRf.setVisibility(0);
                this.kRV.anA();
                ap.vd().a(new q(this.kRV.kMS, 2), 0);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI kRV;

            {
                this.kRV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void e(String str, int i, int i2, String str2) {
        w.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (!bg.mA(str) && str.equals(this.kMS)) {
            if (!TextUtils.isEmpty(str2)) {
                this.kRB = str2;
            }
            if (i == -1) {
                if (this.kQR != -1) {
                    this.kQR = -1;
                    lt(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                }
            } else if (i == 7) {
                this.kQR = 7;
                lt(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
            } else if (i != 6) {
                w.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
            } else if (!TextUtils.isEmpty(str) && str.equals(this.kMS)) {
                this.kQR = 6;
                this.sd = i2;
                lt(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
            }
        }
    }

    private void anD() {
        if (com.tencent.mm.plugin.emoji.h.a.uR(this.kMS)) {
            com.tencent.mm.plugin.emoji.f.a.amh();
            com.tencent.mm.plugin.emoji.f.a.ami();
            return;
        }
        this.kQT = new g(this.kMS, this.kMU, this.kMT);
        ap.vd().a(this.kQT, 0);
        switch (this.kOU) {
            case 9:
                com.tencent.mm.plugin.report.service.g.oUh.i(11598, new Object[]{Integer.valueOf(2), this.kMS});
                return;
            case 10:
                com.tencent.mm.plugin.report.service.g.oUh.i(11598, new Object[]{Integer.valueOf(1), this.kMS});
                return;
            case 11:
                com.tencent.mm.plugin.report.service.g.oUh.i(11598, new Object[]{Integer.valueOf(3), this.kMS});
                return;
            default:
                return;
        }
    }

    public final void lt(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
    }
}

package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Collection;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, e {
    private ProgressDialog kIa;
    private int kLZ;
    private String kMI;
    private String kMf;
    private ya kQW;
    private Button kRv;
    private AnimationDrawable kXF;
    private int kXI;
    private EmojiStoreV2RewardBannerView kXJ;
    private GridInScrollView kXK;
    private View kXL;
    private View kXM;
    private MMFormInputView kXN;
    private TextView kXO;
    private TextView kXP;
    private b kXQ;
    private com.tencent.mm.plugin.emoji.f.b kXR;
    private int kXS = a.kXZ;
    private boolean kXT = false;
    private OnClickListener kXU = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;

        {
            this.kXX = r1;
        }

        public final void onClick(View view) {
            if (this.kXX.kXQ != null) {
                pl lH = this.kXX.kXQ.lH(0);
                if (this.kXX.kXN.getText() != null) {
                    lH.tvs = this.kXX.kXN.getText().toString();
                    this.kXX.a(this.kXX.kMI, lH);
                    return;
                }
                w.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
                return;
            }
            w.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
    };
    private OnClickListener kXV = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;

        {
            this.kXX = r1;
        }

        public final void onClick(View view) {
            if (this.kXX.kXS == a.kXZ) {
                this.kXX.lG(a.kYa);
            }
        }
    };
    private TextWatcher kXW = new TextWatcher(this) {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;

        {
            this.kXX = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.kXX.kRv != null) {
                if (editable != null && editable.length() > 0) {
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                        editable.delete(indexOf + 3, indexOf + 4);
                    }
                    float f = 0.0f;
                    try {
                        f = Float.valueOf(editable.toString()).floatValue();
                    } catch (NumberFormatException e) {
                    }
                    if (f > 200.0f || f < 1.0f) {
                        this.kXX.kXN.oBT.setTextColor(this.kXX.uSU.uTo.getResources().getColor(R.e.aVD));
                    } else {
                        this.kXX.kXN.oBT.setTextColor(this.kXX.uSU.uTo.getResources().getColor(R.e.aVo));
                        this.kXX.kRv.setEnabled(true);
                        return;
                    }
                }
                this.kXX.kRv.setEnabled(false);
            }
        }
    };
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;

        {
            this.kXX = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    String str = (String) message.obj;
                    if (bg.mA(str) || !com.tencent.mm.a.e.aO(str)) {
                        w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                        return;
                    }
                    this.kXX.kXJ.ct(str, null);
                    this.kXX.kXJ.setScaleType(ScaleType.FIT_XY);
                    if (this.kXX.kXF != null && this.kXX.kXF.isRunning()) {
                        this.kXX.kXF.stop();
                        return;
                    }
                    return;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    this.kXX.ar();
                    return;
                default:
                    return;
            }
        }
    };

    private enum a {
        ;

        static {
            kXZ = 1;
            kYa = 2;
            kYb = new int[]{kXZ, kYa};
        }
    }

    class b extends BaseAdapter {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;
        LinkedList<pl> kXy;

        b(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
            this.kXX = emojiStoreV2RewardUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return lH(i);
        }

        public final int getCount() {
            return this.kXy == null ? 0 : this.kXy.size();
        }

        public final pl lH(int i) {
            if (i < 0 || i > getCount() || this.kXy == null) {
                return null;
            }
            return (pl) this.kXy.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = r.eC(this.kXX.uSU.uTo).inflate(R.i.daN, null);
                cVar = new c(this.kXX, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            pl lH = lH(i);
            if (lH != null) {
                cVar.kYc.setVisibility(0);
                cVar.kYc.setText(lH.tvs + lH.mvE);
            } else {
                cVar.kYc.setVisibility(8);
            }
            return view;
        }
    }

    class c {
        final /* synthetic */ EmojiStoreV2RewardUI kXX;
        TextView kYc;

        public c(EmojiStoreV2RewardUI emojiStoreV2RewardUI, View view) {
            this.kXX = emojiStoreV2RewardUI;
            this.kYc = (TextView) view.findViewById(R.h.cst);
        }
    }

    static /* synthetic */ void i(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        emojiStoreV2RewardUI.kXS = a.kXZ;
        if (emojiStoreV2RewardUI.kXM != null) {
            emojiStoreV2RewardUI.kXM.setVisibility(8);
            emojiStoreV2RewardUI.kXL.setVisibility(0);
            emojiStoreV2RewardUI.kXM.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.uSU.uTo, R.a.aRn));
        }
    }

    protected final int getLayoutId() {
        return R.i.daP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kMI = getIntent().getStringExtra("extra_id");
        this.kMf = getIntent().getStringExtra("name");
        this.kLZ = getIntent().getIntExtra("scene", 0);
        this.kXI = getIntent().getIntExtra("pageType", 0);
        KC();
        this.kQW = h.amc().kLf.So(this.kMI);
        if (this.kQW == null || this.kQW.tEC == null) {
            dF(false);
        } else {
            n.GW().a(this.kQW.tEC.tvx, null, f.c(this.kMI, this.kQW.tEC.tvx, new Object[0]));
            n.GW().a(this.kQW.tEC.tvy, null, f.c(this.kMI, this.kQW.tEC.tvy, new Object[0]));
        }
        ar();
        ap.vd().a(830, this);
        ap.vd().a(822, this);
        g.oUh.a(408, 0, 1, false);
    }

    protected void onDestroy() {
        ap.vd().b(830, this);
        ap.vd().b(822, this);
        if (this.kXF != null && this.kXF.isRunning()) {
            this.kXF.stop();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.uSU.uTG);
        if (this.kXS == a.kXZ) {
            if (this.kXT) {
                g.oUh.a(408, 2, 1, false);
            } else {
                g.oUh.a(408, 1, 1, false);
                g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(4)});
            }
            super.onBackPressed();
            return;
        }
        lG(a.kXZ);
    }

    private void lG(int i) {
        if (i == a.kYa) {
            this.kXS = a.kYa;
            if (this.kXM != null) {
                this.kXM.setVisibility(0);
                this.kXM.startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRm));
                this.kXN.oBT.requestFocus();
                aHj();
                this.kXL.setVisibility(8);
                return;
            }
            return;
        }
        aHf();
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2RewardUI kXX;

            {
                this.kXX = r1;
            }

            public final void run() {
                EmojiStoreV2RewardUI.i(this.kXX);
            }
        }, 300);
    }

    protected final void KC() {
        if (bg.mA(this.kMf)) {
            zi(R.l.edz);
        } else {
            qP(getString(R.l.edH, new Object[]{this.kMf}));
        }
        zj(R.l.fmW);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI kXX;

            {
                this.kXX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kXX.onBackPressed();
                return true;
            }
        });
        this.kXL = findViewById(R.h.cyQ);
        this.kXM = findViewById(R.h.cyR);
        this.kXN = (MMFormInputView) findViewById(R.h.cyS);
        this.kRv = (Button) findViewById(R.h.cyT);
        this.kRv.setOnClickListener(this.kXU);
        this.kRv.setEnabled(false);
        this.kXN.setInputType(8194);
        this.kXN.addTextChangedListener(this.kXW);
        this.kXN.oBT.setFilters(new InputFilter[]{new LengthFilter(12)});
        this.kXO = (TextView) findViewById(R.h.cyO);
        this.kXO.setOnClickListener(this.kXV);
        this.kXP = (TextView) findViewById(R.h.cyM);
        this.kXJ = (EmojiStoreV2RewardBannerView) findViewById(R.h.bsz);
        this.kXK = (GridInScrollView) findViewById(16908298);
        this.kXQ = new b(this);
        this.kXK.setAdapter(this.kXQ);
        this.kXK.setOnItemClickListener(this);
        this.kXF = (AnimationDrawable) getResources().getDrawable(R.g.beI);
    }

    private void ar() {
        if (this.kQW != null) {
            this.kXO.setVisibility(0);
            this.kXP.setVisibility(0);
            if (this.kQW.tEC == null || bg.mA(this.kQW.tEC.tvw)) {
                this.kXJ.setBackgroundDrawable(getResources().getDrawable(R.g.beT));
                this.kXJ.setImageDrawable(this.kXF);
                this.kXJ.setScaleType(ScaleType.CENTER);
                this.kXF.start();
            } else {
                final String str = this.kQW.tEC.tvw;
                ap.yY();
                final String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), this.kMI, str);
                if (com.tencent.mm.a.e.aO(C)) {
                    this.kXJ.ct(C, null);
                    this.kXJ.setScaleType(ScaleType.FIT_XY);
                    if (this.kXF != null && this.kXF.isRunning()) {
                        this.kXF.stop();
                    }
                } else {
                    n.GW().a(str, this.kXJ, f.c(this.kMI, str, new Object[0]), new i(this) {
                        final /* synthetic */ EmojiStoreV2RewardUI kXX;

                        public final void a(String str, Bitmap bitmap, Object... objArr) {
                            if (!bg.mA(str) && str.equalsIgnoreCase(str)) {
                                Message message = new Message();
                                message.what = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                                message.obj = C;
                                this.kXX.mHandler.sendMessage(message);
                            }
                        }
                    });
                    this.kXJ.setBackgroundDrawable(getResources().getDrawable(R.g.beT));
                    this.kXJ.setImageDrawable(this.kXF);
                    this.kXJ.setScaleType(ScaleType.CENTER);
                    this.kXF.start();
                }
            }
        } else {
            this.kXO.setVisibility(8);
            this.kXP.setVisibility(8);
        }
        if (this.kQW == null || this.kQW.tEB == null) {
            this.kXK.setVisibility(8);
            return;
        }
        this.kXK.setVisibility(0);
        b bVar = this.kXQ;
        Collection collection = this.kQW.tEB;
        if (bVar.kXy == null) {
            bVar.kXy = new LinkedList();
        }
        bVar.kXy.clear();
        bVar.kXy.addAll(collection);
        bVar.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kXQ != null) {
            pl lH = this.kXQ.lH(i);
            if (lH != null) {
                w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[]{Integer.valueOf(i)});
                a(this.kMI, lH);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 8001:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                    intent2.putExtra("extra_id", this.kMI);
                    startActivity(intent2);
                    g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(1)});
                    g.oUh.a(408, 9, 1, false);
                    dF(true);
                    finish();
                    return;
                } else if (i2 == 0) {
                    g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(3)});
                    g.oUh.a(408, 3, 1, false);
                    return;
                } else {
                    if (!this.kXT) {
                        this.kXT = true;
                        g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(2)});
                    }
                    g.oUh.a(408, 4, 1, false);
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
        switch (kVar.getType()) {
            case 822:
                o oVar = (o) kVar;
                if (i == 0 && i2 == 0) {
                    w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                    this.kQW = oVar.amu();
                    n.GW().a(this.kQW.tEC.tvx, null, f.c(this.kMI, this.kQW.tEC.tvx, new Object[0]));
                    this.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                    return;
                }
                w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                return;
            case 830:
                com.tencent.mm.plugin.emoji.f.b bVar = (com.tencent.mm.plugin.emoji.f.b) kVar;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    Context context = this.uSU.uTo;
                    String str2 = bVar.aml().tgY;
                    String str3 = bVar.aml().msh;
                    if (!bg.mA(str2)) {
                        PayInfo a = com.tencent.mm.pluginsdk.wallet.e.a(str2, str3, null, null, 5, 0);
                        a.sYe = bundle;
                        com.tencent.mm.pluginsdk.wallet.e.a(context, a, 8001);
                        return;
                    }
                    return;
                } else if (i == 4) {
                    if (!this.kXT) {
                        this.kXT = true;
                        g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(2)});
                    }
                    if (i2 == com.tencent.mm.plugin.emoji.f.b.kMF) {
                        g.oUh.a(408, 6, 1, false);
                        if (bg.mA(str)) {
                            uC(getString(R.l.edC));
                            return;
                        } else {
                            uC(str);
                            return;
                        }
                    } else if (i2 == com.tencent.mm.plugin.emoji.f.b.kMG) {
                        g.oUh.a(408, 7, 1, false);
                        if (bg.mA(str)) {
                            uC(getString(R.l.edE));
                            return;
                        } else {
                            uC(str);
                            return;
                        }
                    } else if (i2 == com.tencent.mm.plugin.emoji.f.b.kMH) {
                        g.oUh.a(408, 5, 1, false);
                        if (bg.mA(str)) {
                            uC(getString(R.l.edD));
                            return;
                        } else {
                            uC(str);
                            return;
                        }
                    } else {
                        g.oUh.a(408, 8, 1, false);
                        Toast.makeText(this, getString(R.l.edc), 0).show();
                        return;
                    }
                } else {
                    if (!this.kXT) {
                        this.kXT = true;
                        g.oUh.i(12738, new Object[]{this.kMI, Integer.valueOf(this.kXI), Integer.valueOf(this.kLZ), Integer.valueOf(2)});
                    }
                    g.oUh.a(408, 8, 1, false);
                    Toast.makeText(this, getString(R.l.edc), 0).show();
                    return;
                }
            default:
                w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[]{Integer.valueOf(kVar.getType())});
                return;
        }
    }

    private void a(String str, pl plVar) {
        amU();
        this.kXR = new com.tencent.mm.plugin.emoji.f.b(str, plVar);
        ap.vd().a(this.kXR, 0);
    }

    private void amU() {
        getString(R.l.dIO);
        this.kIa = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI kXX;

            {
                this.kXX = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(this.kXX.kXR);
            }
        });
    }

    private void uC(String str) {
        com.tencent.mm.ui.base.g.a(this.uSU.uTo, str, null, getString(R.l.ecX), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI kXX;

            {
                this.kXX = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void dF(boolean z) {
        w.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            ap.vd().a(new o(this.kMI, o.kNp), 0);
            return;
        }
        ap.vd().a(new o(this.kMI, o.kNq), 0);
        amU();
    }

    protected final int Ol() {
        return 1;
    }
}

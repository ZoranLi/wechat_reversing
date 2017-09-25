package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.appbrand.jsapi.l.d;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, e {
    private ListView Fg;
    private View QB;
    private ae jsW = new ae(this) {
        final /* synthetic */ EmojiStoreV2RewardDetailUI kXx;

        {
            this.kXx = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    if (this.kXx.kXr != null) {
                        this.kXx.kXr.setVisibility(8);
                        return;
                    }
                    return;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    if (this.kXx.kXr != null) {
                        this.kXx.kXr.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private String kMI;
    private String kMT;
    private int kOG = -1;
    private ya kQW;
    private String kXk;
    private String kXl;
    private ImageView kXm;
    private TextView kXn;
    private TextView kXo;
    private TextView kXp;
    private View kXq;
    private View kXr;
    private a kXs;
    private xw kXt;
    private byte[] kXu;
    private m kXv;
    private com.tencent.mm.plugin.emoji.ui.v2.MMLoadScrollView.a kXw = new com.tencent.mm.plugin.emoji.ui.v2.MMLoadScrollView.a(this) {
        final /* synthetic */ EmojiStoreV2RewardDetailUI kXx;

        {
            this.kXx = r1;
        }

        public final void aoE() {
            w.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
            this.kXx.dE(true);
        }
    };
    private boolean kxr = false;

    class a extends BaseAdapter {
        private Bitmap fvM = null;
        private int kIw;
        int kIx;
        int kWi;
        final /* synthetic */ EmojiStoreV2RewardDetailUI kXx;
        private LinkedList<pk> kXy;
        boolean kXz = false;
        private Context mContext;
        private int mNumColumns = 1;

        public final /* synthetic */ Object getItem(int i) {
            return lF(i);
        }

        public a(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI, Context context) {
            this.kXx = emojiStoreV2RewardDetailUI;
            this.mContext = context;
            this.kWi = com.tencent.mm.bg.a.T(emojiStoreV2RewardDetailUI.uSU.uTo, R.f.aZB);
            int dO = com.tencent.mm.bg.a.dO(emojiStoreV2RewardDetailUI.uSU.uTo) - (com.tencent.mm.bg.a.T(emojiStoreV2RewardDetailUI.uSU.uTo, R.f.aXt) * 2);
            int i = this.kWi;
            int T = com.tencent.mm.bg.a.T(emojiStoreV2RewardDetailUI.uSU.uTo, R.f.aXx);
            int i2 = dO / (i + T);
            if ((dO - (i2 * i)) - (T * (i2 - 1)) > i) {
                i2++;
            }
            this.mNumColumns = i2;
            this.kIw = com.tencent.mm.bg.a.dO(this.mContext);
            this.kIx = (int) (((float) (this.kIw - (this.mNumColumns * this.kWi))) / (((float) this.mNumColumns) + 1.0f));
            try {
                this.fvM = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
            } catch (IOException e) {
                w.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[]{bg.bJZ()});
            }
        }

        public final void I(LinkedList<pk> linkedList) {
            if (this.kXy == null) {
                this.kXy = new LinkedList();
            }
            if (this.kXz) {
                this.kXy.clear();
                this.kXz = false;
            }
            this.kXy.addAll(linkedList);
            notifyDataSetChanged();
        }

        public final int getCount() {
            int size = this.kXy == null ? 0 : this.kXy.size();
            if (size > 0) {
                return (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
            }
            return size;
        }

        private pk lF(int i) {
            if (this.kXy != null) {
                if (i < (this.kXy == null ? 0 : this.kXy.size())) {
                    return (pk) this.kXy.get(i);
                }
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = new LinearLayout(this.mContext);
                LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
                view.setBackgroundResource(R.g.bkS);
                view.setOrientation(0);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, this.kIx);
                bVar = new b(this.kXx);
                bVar.kID = view;
                view.setTag(bVar);
                for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.kWi, this.kWi);
                    layoutParams2.leftMargin = this.kIx;
                    bVar.kID.addView(new SquareImageView(this.mContext), i2, layoutParams2);
                }
            } else {
                bVar = (b) view.getTag();
            }
            for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                SquareImageView squareImageView = (SquareImageView) bVar.kID.getChildAt(i3);
                pk lF = lF((this.mNumColumns * i) + i3);
                if (lF != null) {
                    squareImageView.setVisibility(0);
                    if (bg.mA(lF.tvr)) {
                        squareImageView.setImageBitmap(this.fvM);
                    } else {
                        n.GW().a(lF.tvr, squareImageView, f.o(this.kXx.kMI, lF.tvr, this.kWi));
                    }
                } else {
                    squareImageView.setVisibility(8);
                }
            }
            return view;
        }
    }

    class b {
        LinearLayout kID;
        final /* synthetic */ EmojiStoreV2RewardDetailUI kXx;

        b(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
            this.kXx = emojiStoreV2RewardDetailUI;
        }
    }

    protected final int getLayoutId() {
        return R.i.daL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kMI = getIntent().getStringExtra("extra_id");
        this.kMT = getIntent().getStringExtra("extra_name");
        this.kXk = getIntent().getStringExtra("extra_iconurl");
        this.kXl = getIntent().getStringExtra("name");
        KC();
        this.kQW = h.amc().kLf.So(this.kMI);
        aoD();
        n.GW().a(this.kXk, this.kXm, f.bL(this.kMI, this.kXk));
        this.kXn.setText(this.kMT);
        this.kXo.setText(this.kXl);
        if (this.kXt != null) {
            this.kXs.I(this.kXt.tEm);
            this.kXs.kXz = true;
        }
        if (this.kQW != null) {
            this.kXp.setText(getString(R.l.edB, new Object[]{Integer.valueOf(this.kQW.tEl)}));
        }
        ap.vd().a(d.CTRL_INDEX, this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(d.CTRL_INDEX, this);
        n.GW().bi(0);
    }

    protected final void KC() {
        zi(R.l.edA);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardDetailUI kXx;

            {
                this.kXx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kXx.finish();
                return false;
            }
        });
        this.QB = r.eC(this.uSU.uTo).inflate(R.i.daM, null);
        this.kXm = (ImageView) this.QB.findViewById(R.h.bIi);
        this.kXn = (TextView) this.QB.findViewById(R.h.csN);
        this.kXo = (TextView) this.QB.findViewById(R.h.bIj);
        this.kXp = (TextView) this.QB.findViewById(R.h.cyN);
        this.kXq = findViewById(R.h.czn);
        this.Fg = (ListView) findViewById(R.h.bVZ);
        this.kXr = r.eC(this.uSU.uTo).inflate(R.i.daz, null);
        this.kXr.setVisibility(8);
        this.Fg.addHeaderView(this.QB);
        this.Fg.addFooterView(this.kXr);
        this.kXs = new a(this, this);
        this.Fg.setAdapter(this.kXs);
        this.Fg.setOnScrollListener(this);
    }

    private void aoD() {
        this.kXv = new m(this.kMI, this.kXu);
        ap.vd().a(this.kXv, 0);
    }

    private void dE(boolean z) {
        if (!this.kxr && this.kOG != 0) {
            aoD();
            this.kxr = true;
            if (z) {
                this.jsW.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, 200);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        this.kxr = false;
        if (this.kXr != null) {
            this.kXr.setVisibility(8);
            this.jsW.removeMessages(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
            this.jsW.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, 200);
        }
        switch (kVar.getType()) {
            case d.CTRL_INDEX /*299*/:
                m mVar = (m) kVar;
                if (i == 0 || i == 4) {
                    this.kXu = mVar.kNk;
                    if (i2 == 0) {
                        this.kOG = 0;
                        if (mVar.amr() != null) {
                            this.kXs.I(mVar.amr().tEm);
                            return;
                        }
                        return;
                    } else if (i2 == 2) {
                        this.kOG = 2;
                        if (mVar.amr() != null) {
                            this.kXs.I(mVar.amr().tEm);
                        }
                        if (!(this.kXs == null || this.QB == null)) {
                            a aVar = this.kXs;
                            w.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[]{Integer.valueOf(aVar.kIx + aVar.kWi), Integer.valueOf(this.QB.getHeight()), Integer.valueOf(com.tencent.mm.bg.a.dP(this))});
                            if (com.tencent.mm.bg.a.dP(this) > ((aVar.kIx + aVar.kWi) * this.kXs.getCount()) + this.QB.getHeight()) {
                                z = false;
                            }
                        }
                        if (!z) {
                            dE(false);
                            return;
                        }
                        return;
                    } else if (i2 == 3) {
                        this.kOG = 1;
                        this.kXu = null;
                        this.kXs.kXz = true;
                        dE(false);
                        return;
                    } else {
                        return;
                    }
                }
                w.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[]{Integer.valueOf(i)});
                return;
            default:
                return;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kOG == 0 || this.kxr) {
            w.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
            return;
        }
        dE(true);
        w.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
        n.GW().bi(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final int Ol() {
        return 1;
    }
}

package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.b;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a {
    private String fOa;
    private l iYI;
    private CardGiftInfo klB;
    private ImageView klC;
    private RelativeLayout klD;
    private MMGestureGallery klE;
    private ProgressBar klF;
    private ae klG = new ae(Looper.getMainLooper());
    private Bundle klH;
    private boolean klI = false;
    private g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private a klO;

    private class a extends BaseAdapter {
        final /* synthetic */ CardGiftImageUI klP;

        private a(CardGiftImageUI cardGiftImageUI) {
            this.klP = cardGiftImageUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Bitmap mt = j.mt(this.klP.fOa);
            if (mt == null) {
                w.w("MicroMsg.CardGiftImageUI", "get image fail");
                if (view != null && !(view instanceof MultiTouchImageView)) {
                    return view;
                }
                view = View.inflate(viewGroup.getContext(), R.i.doA, null);
                ((ImageView) view.findViewById(R.h.bWV)).setImageResource(R.k.dwC);
                view.setLayoutParams(new LayoutParams(-1, -1));
                return view;
            }
            Context context = viewGroup.getContext();
            if (view == null || !(view instanceof MultiTouchImageView)) {
                view = new MultiTouchImageView(context, mt.getWidth(), mt.getHeight());
            } else {
                MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                multiTouchImageView.dZ(mt.getWidth(), mt.getHeight());
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(mt);
            view.vol = true;
            return view;
        }
    }

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        cardGiftImageUI.iYI = new l(cardGiftImageUI);
        cardGiftImageUI.iYI.qJf = new c(cardGiftImageUI) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.e(0, this.klP.getString(R.l.eOm));
            }
        };
        cardGiftImageUI.iYI.qJg = new d(cardGiftImageUI) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        k.h(this.klP.fOa, this.klP);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.uSU.bQg();
        this.klH = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.klB = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        String str = "MicroMsg.CardGiftImageUI";
        String str2 = "cardGiftInfo:%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.klB == null ? "null" : this.klB.toString();
        w.d(str, str2, objArr);
        w.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[]{this.fOa});
        KC();
        com.tencent.mm.plugin.card.b.a.a(this);
        if (this.klB == null || bg.mA(this.klB.kdZ)) {
            w.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.f(this.klB.kdZ, this.klB.kec, this.klB.kel, 2);
        }
    }

    protected final void KC() {
        this.klC = (ImageView) findViewById(R.h.bSt);
        this.klC.setLayerType(2, null);
        this.klF = (ProgressBar) findViewById(R.h.bXa);
        this.klD = (RelativeLayout) findViewById(R.h.bXh);
        this.klE = (MMGestureGallery) findViewById(R.h.bSr);
        this.klE.setVerticalFadingEdgeEnabled(false);
        this.klE.setHorizontalFadingEdgeEnabled(false);
        this.klO = new a();
        this.klE.setAdapter(this.klO);
        this.klE.wmR = new f(this) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final void ahA() {
                this.klP.ahz();
            }
        };
        this.klE.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.g.a(this.klP, this.klP.iYI.blb());
                return true;
            }
        });
        this.klJ = new g(this);
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT < 12) {
                w.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.klK = getIntent().getIntExtra("img_top", 0);
                this.klL = getIntent().getIntExtra("img_left", 0);
                this.klM = getIntent().getIntExtra("img_width", 0);
                this.klN = getIntent().getIntExtra("img_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.klD.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ CardGiftImageUI klP;

                        {
                            this.klP = r1;
                        }

                        public final boolean onPreDraw() {
                            this.klP.klD.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.klP.klJ.a(this.klP.klD, this.klP.klC, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.klO != null) {
            this.klO.notifyDataSetChanged();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.card.b.a.b(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
        ahz();
        return true;
    }

    public final void ahz() {
        this.klJ.p(this.klL, this.klK, this.klM, this.klN);
        this.klJ.a(this.klD, this.klC, new b(this) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 klQ;

                    {
                        this.klQ = r1;
                    }

                    public final void run() {
                        this.klQ.klP.finish();
                        this.klQ.klP.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    protected final int getLayoutId() {
        return R.i.cWz;
    }

    public final void aB(String str, int i) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ CardGiftImageUI klP;

            {
                this.klP = r1;
            }

            public final void run() {
                if (this.klP.klF.getVisibility() != 0) {
                    this.klP.klF.setVisibility(0);
                }
            }
        });
    }

    public final void fail(String str) {
    }

    public final void bA(String str, final String str2) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ CardGiftImageUI klP;

            public final void run() {
                if (this.klP.klF.getVisibility() != 8) {
                    this.klP.klF.setVisibility(8);
                }
                this.klP.fOa = str2;
                CardGiftImageUI.g(this.klP);
                this.klP.klO.notifyDataSetChanged();
            }
        });
    }
}

package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.x.h;
import com.tencent.mm.y.k;
import com.tencent.qbar.QbarNative;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements com.tencent.mm.sdk.platformtools.au.a {
    private View QB;
    private SensorManager aJs;
    private aj iUX;
    private DisplayMetrics ihQ;
    private TextView ipw;
    private e jjr;
    private d kBS = new d(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        {
            this.nkL = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    if (this.nkL.njL > 0) {
                        this.nkL.b(new com.tencent.mm.plugin.luckymoney.f2f.a.a(this.nkL.njw), false);
                        return;
                    } else {
                        g.bl(this.nkL, this.nkL.getString(R.l.exr));
                        return;
                    }
                default:
                    return;
            }
        }
    };
    private String lfx;
    private Bitmap mBitmap;
    private String njK;
    private int njL;
    private View njP;
    private View njQ;
    private ImageView njR;
    private TextView njS;
    private TextView njT;
    private ImageView njU;
    private TextView njV;
    private TextView njW;
    private HorizontalListViewV2 njX;
    private List<String> njY;
    private Map<String, String> njZ;
    private String njw;
    private Bitmap nkA;
    private Bitmap nkB;
    private Bitmap nkC;
    private Bitmap nkD;
    private Bitmap nkE;
    private Bitmap nkF;
    private Bitmap nkG;
    private Bitmap nkH;
    private b nkI = new b(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        {
            this.nkL = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 16) {
                if (this.nkL.nkz == null) {
                    this.nkL.nkz = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgD), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkz);
            } else if (nextInt < 33) {
                if (this.nkL.nkA == null) {
                    this.nkL.nkA = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgE), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkA);
            } else if (nextInt < 50) {
                if (this.nkL.nkB == null) {
                    this.nkL.nkB = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgF), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkB);
            } else if (nextInt < 70) {
                if (this.nkL.nkw == null) {
                    this.nkL.nkw = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgy), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkw);
            } else if (nextInt < 90) {
                if (this.nkL.nkx == null) {
                    this.nkL.nkx = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgz), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkx);
            } else {
                if (this.nkL.nky == null) {
                    this.nkL.nky = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgA), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nky);
            }
        }
    };
    private b nkJ = new b(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        {
            this.nkL = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 10) {
                if (this.nkL.nkF == null) {
                    this.nkL.nkF = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgD), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkF);
            } else if (nextInt < 20) {
                if (this.nkL.nkG == null) {
                    this.nkL.nkG = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgE), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkG);
            } else if (nextInt < 30) {
                if (this.nkL.nkH == null) {
                    this.nkL.nkH = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgF), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkH);
            } else if (nextInt < 50) {
                if (this.nkL.nkC == null) {
                    this.nkL.nkC = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgy), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkC);
            } else if (nextInt < 75) {
                if (this.nkL.nkD == null) {
                    this.nkL.nkD = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgz), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkD);
            } else {
                if (this.nkL.nkE == null) {
                    this.nkL.nkE = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nkL.getResources(), R.g.bgA), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.nkL.nkE);
            }
        }
    };
    final SensorEventListener nkK = new SensorEventListener(this) {
        float jWC;
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;
        final int nkP = 3;
        float nkQ = ((float) com.tencent.mm.bg.a.T(ab.getContext(), R.f.aXz));
        int nkR;
        ValueAnimator nkS;

        {
            this.nkL = r3;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = -3.0f;
            if (sensorEvent.sensor.getType() == 1 && this.nkL.njL > 0) {
                if (this.nkR == 0) {
                    this.nkR = com.tencent.mm.pluginsdk.e.bG(this.nkL) + ((int) this.nkQ);
                }
                float f2 = sensorEvent.values[1];
                if (((double) Math.abs(f2 - this.jWC)) >= 0.05d) {
                    this.jWC = f2;
                    w.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[]{Float.valueOf(f2)});
                    if (f2 >= -3.0f) {
                        if (f2 > 0.0f) {
                            f = 0.0f;
                        } else {
                            f = f2;
                        }
                    }
                    f = ((f / 3.0f) * ((float) this.nkR)) + ((float) this.nkR);
                    w.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[]{Float.valueOf(f), Integer.valueOf(this.nkL.njP.getPaddingTop())});
                    if (this.nkS != null) {
                        this.nkS.cancel();
                    }
                    this.nkS = ValueAnimator.ofFloat(new float[]{(float) this.nkL.njP.getPaddingTop(), f}).setDuration(200);
                    this.nkS.addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ AnonymousClass8 nkT;

                        {
                            this.nkT = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            this.nkT.nkL.njP.setPadding(this.nkT.nkL.njP.getPaddingLeft(), (int) floatValue, this.nkT.nkL.njP.getPaddingRight(), this.nkT.nkL.njP.getPaddingBottom());
                            floatValue /= (float) this.nkT.nkR;
                            if (floatValue <= 1.0f) {
                                this.nkT.nkL.njV.setAlpha((1.0f - floatValue) + this.nkT.nkL.nks);
                                this.nkT.nkL.njW.setAlpha(floatValue * this.nkT.nkL.nks);
                                return;
                            }
                            this.nkT.nkL.njV.setAlpha(this.nkT.nkL.nks);
                            this.nkT.nkL.njW.setAlpha(this.nkT.nkL.nks);
                        }
                    });
                    this.nkS.start();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            w.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
        }
    };
    private Queue<Pair<String, Integer>> nka;
    private a nkb;
    private TextView nkc;
    private Button nkd;
    private View nke;
    private View nkf;
    private ShuffleView nkg;
    private c nkh;
    private List<View> nki;
    private ViewGroup nkj;
    private ViewGroup nkk;
    private View nkl;
    private com.tencent.mm.plugin.luckymoney.f2f.a nkm;
    private long nkn;
    private String nko;
    private ValueAnimator nkp;
    private float nkq;
    private float nkr;
    private float nks;
    private int[] nkt;
    private com.tencent.mm.u.bp.a nku = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        {
            this.nkL = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            Map q = bh.q(n.a(aVar.hst.tff), "sysmsg");
            if (q != null) {
                String str = (String) q.get(".sysmsg.sendId");
                final String str2 = (String) q.get(".sysmsg.username");
                final String str3 = (String) q.get(".sysmsg.amount");
                final String str4 = (String) q.get(".sysmsg.receiveId");
                if (bg.getInt((String) q.get(".sysmsg.islucky"), 0) > 0) {
                    this.nkL.nko = str2;
                }
                if (!bg.D(new String[]{str, str2, str3})) {
                    this.nkL.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nkO;

                        public final void run() {
                            if (!this.nkO.nkL.njY.contains(str4)) {
                                this.nkO.nkL.njY.add(0, str4);
                                if (!o.eU(str2)) {
                                    h hVar = new h();
                                    hVar.username = str2;
                                    com.tencent.mm.x.n.Bm().a(hVar);
                                }
                                this.nkO.nkL.njZ.put(str4, str2);
                                ShuffleView c = this.nkO.nkL.nkg;
                                if (c.nle.size() > 0) {
                                    if (c.nlj.isStarted()) {
                                        c.nlj.end();
                                    }
                                    if (c.nli.isStarted()) {
                                        c.nli.end();
                                    }
                                    if (c.nlo != null) {
                                        c.nlm = c.nlo;
                                        c.nle.remove(c.nlm);
                                        if (c.nlg != null) {
                                            c.nlg.start();
                                        }
                                        c.oQ(c.nlp);
                                        if (c.nls > 0) {
                                            c.nlp = c.aHP();
                                            c.nlo = (View) c.nle.get(c.nlp);
                                        } else {
                                            c.nlo = null;
                                            c.nlp = 0;
                                        }
                                    } else {
                                        c.oO(c.aHP());
                                        c.nlm = c.nlo;
                                        c.nlj.addListener(new AnimatorListener(c) {
                                            final /* synthetic */ ShuffleView nlE;

                                            {
                                                this.nlE = r1;
                                            }

                                            public final void onAnimationStart(Animator animator) {
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                this.nlE.nle.remove(this.nlE.nlm);
                                                if (this.nlE.nlg != null) {
                                                    this.nlE.nlg.start();
                                                }
                                                this.nlE.oQ(this.nlE.nlp);
                                                if (this.nlE.nls > 0) {
                                                    this.nlE.nlp = this.nlE.aHP();
                                                    this.nlE.nlo = (View) this.nlE.nle.get(this.nlE.nlp);
                                                    return;
                                                }
                                                this.nlE.nlo = null;
                                                this.nlE.nlp = 0;
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                    }
                                }
                                this.nkO.nkL.nki.remove(this.nkO.nkL.nkg.nlm);
                                this.nkO.nkL.iUX.v(0, 60000);
                                this.nkO.nkL.nka.add(new Pair(str2, Integer.valueOf(bg.getInt(str3, 0))));
                            }
                        }
                    });
                }
            }
        }
    };
    private c nkv = new c(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        {
            this.nkL = r1;
        }

        public final void a(l lVar) {
            lVar.dX(1, R.l.exq);
        }
    };
    private Bitmap nkw;
    private Bitmap nkx;
    private Bitmap nky;
    private Bitmap nkz;

    private class a extends BaseAdapter {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

        class a {
            ImageView iqx;
            ImageView nkU;
            final /* synthetic */ a nkV;

            a(a aVar) {
                this.nkV = aVar;
            }
        }

        private a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
            this.nkL = luckyMoneyF2FQRCodeUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public final int getCount() {
            return this.nkL.njY.size();
        }

        private String hO(int i) {
            return (String) this.nkL.njY.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.nkL).inflate(R.i.dhj, null);
                ImageView imageView = (ImageView) view.findViewById(R.h.cey);
                ImageView imageView2 = (ImageView) view.findViewById(R.h.ces);
                a aVar2 = new a(this);
                aVar2.iqx = imageView;
                aVar2.nkU = imageView2;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            String str = (String) this.nkL.njZ.get(hO(i));
            com.tencent.mm.plugin.luckymoney.b.n.a(aVar.iqx, null, str);
            if (bg.mA(this.nkL.nko) || !this.nkL.nko.equals(str)) {
                aVar.nkU.setVisibility(4);
            } else {
                aVar.nkU.setVisibility(0);
            }
            return view;
        }
    }

    static /* synthetic */ void G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        luckyMoneyF2FQRCodeUI.njR = (ImageView) luckyMoneyF2FQRCodeUI.njQ.findViewById(R.h.cga);
        luckyMoneyF2FQRCodeUI.njS = (TextView) luckyMoneyF2FQRCodeUI.njQ.findViewById(R.h.cgb);
        luckyMoneyF2FQRCodeUI.njT = (TextView) luckyMoneyF2FQRCodeUI.njQ.findViewById(R.h.cfX);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.nka.poll();
        if (pair != null) {
            com.tencent.mm.plugin.luckymoney.b.n.a(luckyMoneyF2FQRCodeUI.njR, null, (String) pair.first);
            com.tencent.mm.plugin.luckymoney.b.n.a((Context) luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.njS, com.tencent.mm.plugin.luckymoney.b.n.eJ((String) pair.first));
            luckyMoneyF2FQRCodeUI.njT.setText(com.tencent.mm.wallet_core.ui.e.n(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!bg.mA(luckyMoneyF2FQRCodeUI.nko) && luckyMoneyF2FQRCodeUI.nko.equals(pair.first)) {
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nkj, luckyMoneyF2FQRCodeUI.nkI).w(800, 100);
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nkk, luckyMoneyF2FQRCodeUI.nkJ).w(800, 100);
                luckyMoneyF2FQRCodeUI.nkm.dj("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.nkm.dj("whistle.m4a");
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        this.ihQ = getResources().getDisplayMetrics();
        this.njY = new ArrayList();
        this.njZ = new HashMap();
        this.nka = new LinkedList();
        this.nki = new ArrayList();
        this.nkt = new int[6];
        int[] iArr = this.nkt;
        iArr[0] = iArr[0] + 1;
        this.iUX = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final boolean oQ() {
                this.nkL.b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), false);
                return true;
            }
        }, true);
        this.ipw = (TextView) findViewById(R.h.cJh);
        this.QB = findViewById(R.h.cez);
        this.njP = findViewById(R.h.cTc);
        this.njW = (TextView) findViewById(R.h.cev);
        this.njV = (TextView) findViewById(R.h.cew);
        this.nks = this.njW.getAlpha();
        this.njU = (ImageView) this.QB.findViewById(R.h.ceu);
        this.njX = (HorizontalListViewV2) findViewById(R.h.cex);
        this.nkb = new a();
        this.njX.setAdapter(this.nkb);
        this.njX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(this.nkL, LuckyMoneyDetailUI.class);
                intent.putExtra("key_sendid", this.nkL.njw);
                this.nkL.startActivity(intent);
            }
        });
        this.njX.vhq = new HorizontalListViewV2.d(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void oL(int i) {
                if (i == com.tencent.mm.ui.base.HorizontalListViewV2.d.a.vhA && this.nkL.njY.size() >= 5 && ((long) this.nkL.njY.size()) < this.nkL.nkn && this.nkL.njX.getLastVisiblePosition() == this.nkL.njY.size() - 1 && !bg.mA(this.nkL.njw)) {
                    this.nkL.k(new u(this.nkL.njw, 5, this.nkL.njY.size(), null, "v1.0"));
                }
            }
        };
        this.nkd = (Button) findViewById(R.h.cet);
        this.nkd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.nkL, LuckyMoneyPrepareUI.class);
                intent.putExtra("key_from", 2);
                this.nkL.startActivity(intent);
            }
        });
        this.nkc = (TextView) findViewById(R.h.ceB);
        this.njQ = findViewById(R.h.ceA);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nkL.finish();
                return true;
            }
        });
        qP(getString(R.l.exB));
        this.nke = findViewById(R.h.bqR);
        this.nke.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void onClick(View view) {
                this.nkL.finish();
            }
        });
        this.nkf = findViewById(R.h.clh);
        this.nkf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void onClick(View view) {
                this.nkL.jjr = new e(this.nkL, e.wuP, false);
                this.nkL.jjr.qJf = this.nkL.nkv;
                this.nkL.jjr.qJg = this.nkL.kBS;
                this.nkL.jjr.bzh();
            }
        });
        this.ipw.setText(R.l.exB);
        this.nkj = (ViewGroup) findViewById(R.h.cep);
        this.nkk = (ViewGroup) findViewById(R.h.ceo);
        this.nkl = findViewById(R.h.cer);
        this.nkl.setAlpha(0.0f);
        this.aJs = (SensorManager) getSystemService("sensor");
        this.aJs.registerListener(this.nkK, this.aJs.getDefaultSensor(1), 3);
        this.nkm = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.nkg = (ShuffleView) findViewById(R.h.ceC);
        this.nkh = new c();
        this.nkh.nlK = 4;
        this.nkh.nlI = 2;
        this.nkh.nlJ = 4;
        this.nkh.nlN = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
        this.nkh.nlM = 0.0f;
        ShuffleView shuffleView = this.nkg;
        c cVar = this.nkh;
        shuffleView.nlf = cVar;
        shuffleView.nli = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.nlN);
        shuffleView.nlj = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.nlO);
        ShuffleView.ihQ = this.ihQ;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        ShuffleView shuffleView2 = this.nkg;
        if (shuffleView2.nlg != null) {
            shuffleView2.nlg.removeAllListeners();
            shuffleView2.nlg.cancel();
        }
        shuffleView2.nlg = duration;
        if (shuffleView2.nlg != null) {
            shuffleView2.nlg.addUpdateListener(new AnimatorUpdateListener(shuffleView2) {
                final /* synthetic */ ShuffleView nlE;

                {
                    this.nlE = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (this.nlE.nlk != null) {
                        this.nlE.nlk.a(valueAnimator, this.nlE.nlm);
                    }
                }
            });
        }
        this.nkg.nlk = new a(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void a(ValueAnimator valueAnimator, View view) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue == 0.0f) {
                    this.nkL.nkq = view.getTranslationX();
                    this.nkL.nkr = view.getTranslationY();
                    view.findViewById(R.h.ceD).setVisibility(0);
                }
                view.setTranslationX((1.0f - floatValue) * this.nkL.nkq);
                view.setTranslationY(((1.0f - floatValue) * this.nkL.nkr) - ((((float) this.nkL.nkg.getHeight()) + (this.nkL.nkr * 8.0f)) * floatValue));
                view.setScaleX((0.5f * floatValue) + 1.0f);
                view.setScaleY((0.5f * floatValue) + 1.0f);
                Pair pair = (Pair) this.nkL.nka.peek();
                if (!(pair == null || bg.mA(this.nkL.nko) || !this.nkL.nko.equals(pair.first))) {
                    this.nkL.nkl.setAlpha(floatValue);
                }
                w.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[]{Float.valueOf(floatValue)});
                if (floatValue >= 0.9f) {
                    view.setAlpha((1.0f - floatValue) * 10.0f);
                    this.nkL.njQ.setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
                    this.nkL.njQ.setScaleX(floatValue);
                    this.nkL.njQ.setScaleY(floatValue);
                    this.nkL.njQ.setVisibility(0);
                }
                if (floatValue == 1.0f) {
                    this.nkL.nkm.dj("packet_received.m4a");
                    this.nkL.nkg.removeView(this.nkL.nkg.nlm);
                    LuckyMoneyF2FQRCodeUI.G(this.nkL);
                    this.nkL.nkp.start();
                }
            }
        };
        this.nkg.nll = new b(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void cl(int i, int i2) {
                if (i2 == 8) {
                    this.nkL.nkm.dj("music" + (i + 1) + ".m4a");
                    int[] I = this.nkL.nkt;
                    I[4] = I[4] + 1;
                    return;
                }
                this.nkL.nkm.dj("touch_card.m4a");
                I = this.nkL.nkt;
                I[2] = I[2] + 1;
            }

            public final void oK(int i) {
                this.nkL.aHK();
                if (i != 8) {
                    this.nkL.nkm.dj("select_card.m4a");
                    int[] I = this.nkL.nkt;
                    I[3] = I[3] + 1;
                    return;
                }
                I = this.nkL.nkt;
                I[5] = I[5] + 1;
            }

            public final void cm(int i, int i2) {
                if (i2 == 8) {
                    this.nkL.nkm.dj("music" + (i + 1) + ".m4a");
                } else {
                    this.nkL.nkm.dj("select_card.m4a");
                }
            }
        };
        aHL();
        this.nkp = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.nkp.setDuration(300);
        this.nkp.setStartDelay(3000);
        this.nkp.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI nkL;

            {
                this.nkL = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.nkL.njQ.setTranslationY((-0.5f * floatValue) * ((float) this.nkL.ihQ.heightPixels));
                this.nkL.nkl.setAlpha(1.0f - floatValue);
                if (floatValue == 1.0f) {
                    this.nkL.njQ.setVisibility(8);
                    this.nkL.njQ.setTranslationY(0.0f);
                    this.nkL.aHM();
                    this.nkL.nkb.notifyDataSetChanged();
                    this.nkL.njX.zO(0);
                }
            }
        });
        aHK();
        getWindow().addFlags(FileUtils.S_IWUSR);
    }

    private void aHK() {
        if (!bg.mA(this.lfx)) {
            Bitmap bitmap;
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            int a = QbarNative.a(bArr, iArr, this.lfx, 0, 1, "UTF-8");
            QbarNative.nativeRelease();
            if (a > 0) {
                int i;
                int i2;
                int i3;
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (i4 >= i5) {
                    i4 = i5;
                }
                int i6 = (int) (((double) iArr[0]) * 0.1d);
                i4 = ((int) (((double) i4) * 0.8d)) / (iArr[0] + (i6 * 2));
                if (i4 == 0) {
                    i = 1;
                } else {
                    i = i4;
                }
                int i7 = i6 * i;
                i5 = i * (iArr[0] + (i6 * 2));
                int i8 = (iArr[1] * i) + ((i * 2) * i6);
                Bitmap createBitmap = Bitmap.createBitmap(i5, i8, Config.ARGB_8888);
                int[] iArr2 = new int[(i5 * i8)];
                int i9 = (i * 2) + (i / 2);
                int i10 = (i * 3) + (i / 2);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                Arrays.fill(iArr2, -1);
                int[] iArr3 = new int[]{(i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[0] - 1) - 3) * i) + (i / 2), (i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[1] - 1) - 3) * i) + (i / 2)};
                i4 = 0;
                while (i4 < iArr[1]) {
                    int i11 = 0;
                    while (i11 < iArr[0]) {
                        if (bArr[(iArr[0] * i4) + i11] == (byte) 1) {
                            int i12;
                            if ((i4 < 0 || i4 > 6 || i11 < 0 || i11 > 6) && ((i4 < 0 || i4 > 6 || i11 < iArr[0] - 7 || i11 > iArr[0] - 1) && (i4 < iArr[1] - 7 || i4 > iArr[1] - 1 || i11 < 0 || i11 > 6))) {
                                boolean[] zArr = new boolean[10];
                                zArr[5] = true;
                                if (zArr[(int) (Math.random() * 10.0d)]) {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -3041484;
                                        }
                                    }
                                } else {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -2598591;
                                        }
                                    }
                                }
                            } else {
                                for (i2 = 0; i2 < i; i2++) {
                                    for (i12 = 0; i12 < i; i12++) {
                                        iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -1;
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    i4++;
                }
                createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i8);
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-2598591);
                    paint.setStyle(Style.FILL);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i10, paint);
                    paint.setColor(-1);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i9, paint);
                }
                for (i2 = 0; i2 < 3; i2++) {
                    paint.setColor(-3041484);
                    paint.setStyle(Style.FILL);
                    Canvas canvas2 = canvas;
                    canvas2.drawRect((float) ((((i * i6) + iArr3[i2 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i2 * 2) + 1]) - i) - ((i * 1) / 4)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[i2 * 2]) + i)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[(i2 * 2) + 1]) + i)), paint);
                }
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-1);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    Path path = new Path();
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) - i), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) - i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) + i), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) + i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                }
                if (createBitmap == null) {
                    w.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), bg.bJZ().toString()});
                } else {
                    w.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
                }
                bitmap = createBitmap;
            } else {
                w.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), bg.bJZ().toString()});
                bitmap = null;
            }
            this.mBitmap = bitmap;
            this.njU.setImageBitmap(this.mBitmap);
        }
        if (this.njL <= 0) {
            this.njU.setPadding(com.tencent.mm.bg.a.fromDPToPix(this, 5), com.tencent.mm.bg.a.fromDPToPix(this, 5), com.tencent.mm.bg.a.fromDPToPix(this, 5), com.tencent.mm.bg.a.fromDPToPix(this, 5));
            this.njU.setImageResource(R.g.bgx);
            this.nkc.setVisibility(8);
            this.nkd.setVisibility(0);
            this.njV.setVisibility(4);
            this.njP.setPadding(this.njP.getPaddingLeft(), com.tencent.mm.pluginsdk.e.bG(this), this.njP.getPaddingRight(), this.njP.getPaddingBottom());
            if (this.njY.size() > 0) {
                this.njW.setText(getString(R.l.exu));
                return;
            } else {
                this.njW.setText(getString(R.l.exv));
                return;
            }
        }
        this.njU.setPadding(0, 0, 0, 0);
        this.njV.setText(getString(R.l.exz));
        this.njV.setVisibility(0);
        this.njW.setText(getString(R.l.exz));
        this.nkc.setText(getString(R.l.exy, new Object[]{Integer.valueOf(this.njL)}));
        this.nkc.setVisibility(0);
        this.nkd.setVisibility(8);
    }

    private void aHL() {
        Set hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + ".m4a");
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nkm;
        ap.vL().D(new com.tencent.mm.plugin.luckymoney.f2f.a.AnonymousClass1(aVar, hashSet, new WeakReference(this)));
        aVar.njl.setOnLoadCompleteListener(new OnLoadCompleteListener(aVar) {
            final /* synthetic */ a njr;

            {
                this.njr = r1;
            }

            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                if (i2 == 0) {
                    this.njr.njn.put(Integer.valueOf(i), Boolean.valueOf(true));
                } else {
                    this.njr.njn.put(Integer.valueOf(i), Boolean.valueOf(false));
                }
            }
        });
    }

    private void aHM() {
        int width = this.njX.getWidth() - (this.njY.size() * getResources().getDimensionPixelSize(R.f.aWB));
        if (width > 0) {
            this.njX.setPadding(width / 2, 0, width / 2, 0);
        } else {
            this.njX.setPadding(0, 0, 0, 0);
        }
    }

    private void aHN() {
        if (this.nki.size() != this.njL) {
            int i;
            w.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[]{Integer.valueOf(this.nki.size()), Integer.valueOf(this.njL)});
            this.nki.clear();
            for (i = 0; i < this.njL; i++) {
                View inflate = LayoutInflater.from(this).inflate(R.i.dhg, this.nkg, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.nki.add(inflate);
            }
            ShuffleView shuffleView = this.nkg;
            Collection collection = this.nki;
            shuffleView.nle.clear();
            shuffleView.nle.addAll(collection);
            shuffleView.nlp = 0;
            shuffleView.nlo = null;
            shuffleView.nlr = -1;
            shuffleView.nlq = null;
            shuffleView.removeAllViews();
            List list = shuffleView.nle;
            if (list.size() > 100) {
                shuffleView.nls = 100;
            } else {
                shuffleView.nls = list.size();
                if (shuffleView.nls == 1) {
                    ((View) list.get(0)).findViewById(R.h.ceD).setVisibility(0);
                }
            }
            for (i = shuffleView.nls - 1; i >= 0; i--) {
                shuffleView.addView((View) list.get(i));
            }
            shuffleView.addOnLayoutChangeListener(new OnLayoutChangeListener(shuffleView) {
                final /* synthetic */ ShuffleView nlE;

                {
                    this.nlE = r1;
                }

                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    this.nlE.aHO();
                    ShuffleView shuffleView = this.nlE;
                    for (int i9 = 0; i9 < shuffleView.nls; i9++) {
                        shuffleView.y((View) shuffleView.nle.get(i9), i9);
                    }
                    this.nlE.removeOnLayoutChangeListener(this);
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), true);
        this.iUX.v(60000, 60000);
        ap.getSysCmdMsgExtension().a("ffopenwxhb", this.nku, true);
        hn(1642);
        hn(1990);
        hn(1987);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        au.a(this);
        if (this.aJs != null) {
            this.aJs.registerListener(this.nkK, this.aJs.getDefaultSensor(1), 3);
        }
    }

    protected void onStop() {
        super.onStop();
        this.iUX.KH();
        ap.getSysCmdMsgExtension().b("ffopenwxhb", this.nku, true);
        ho(1990);
        ho(1642);
        ho(1987);
        au.a(null);
    }

    protected void onPause() {
        super.onPause();
        if (this.aJs != null) {
            this.aJs.unregisterListener(this.nkK);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.report.service.g.oUh.i(14007, new Object[]{Integer.valueOf(this.nkt[0]), Integer.valueOf(this.nkt[1]), Integer.valueOf(this.nkt[2]), Integer.valueOf(this.nkt[3]), Integer.valueOf(this.nkt[4]), Integer.valueOf(this.nkt[5])});
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nkm;
        aVar.njo = true;
        aVar.njl.release();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dhh;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        w.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
                w.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.njw);
                if (!(bg.D(new String[]{this.njw, ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njw}) || this.njw.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njw))) {
                    this.njY.clear();
                    this.njZ.clear();
                    this.nka.clear();
                    this.nkb.notifyDataSetChanged();
                    this.nko = "";
                }
                if (!bg.mA(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njw)) {
                    this.njw = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njw;
                }
                this.lfx = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).lfx;
                this.njL = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njL;
                this.njK = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).njK;
                aHK();
                aHN();
                if (this.njL == 0) {
                    this.iUX.KH();
                }
                if (this.njY.size() == 0 && !bg.mA(this.njw)) {
                    b(new u(this.njw, 5, 0, null, "v1.0"), false);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.njw = "";
                this.lfx = "";
                this.njL = 0;
                this.njY.clear();
                this.nko = "";
                this.nkb.notifyDataSetChanged();
                aHK();
                aHN();
                this.iUX.KH();
                if (!bg.mA(this.njK)) {
                    g.bl(this, this.njK);
                }
            } else if (kVar instanceof u) {
                this.nkn = ((u) kVar).nnk.nmm;
                List list = ((u) kVar).nnk.nmB;
                if (list != null && list.size() > 0) {
                    while (i3 < list.size()) {
                        m mVar = (m) list.get(i3);
                        if (!(bg.mA(mVar.nmp) || this.njY.contains(mVar.nmp))) {
                            this.njY.add(mVar.nmp);
                            String hi = com.tencent.mm.x.n.Bz().hi(mVar.nmY);
                            if (!bg.mA(mVar.nna)) {
                                this.nko = hi;
                            }
                            this.njZ.put(mVar.nmp, hi);
                        }
                        i3++;
                    }
                    aHM();
                    this.nkb.notifyDataSetChanged();
                }
            }
        } else if (!bg.mA(str)) {
            g.b(this, str, getString(R.l.dIO), true);
        }
        return true;
    }

    public final void XF() {
        w.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.njL > 0) {
            aHK();
            int[] iArr = this.nkt;
            iArr[1] = iArr[1] + 1;
            g.b(this, getString(R.l.exA), null, true);
        }
    }
}

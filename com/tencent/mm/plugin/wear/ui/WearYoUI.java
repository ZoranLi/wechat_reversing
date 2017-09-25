package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.sm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends Activity {
    private ImageView ipv;
    private TextView jWd;
    private Vibrator jYD;
    private ImageView rUM;
    private ImageView rUN;
    private ImageView rUO;
    private ObjectAnimator[][] rUP = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private c rUQ = new c<sm>(this) {
        final /* synthetic */ WearYoUI rUW;

        {
            this.rUW = r2;
            this.usg = sm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sm smVar = (sm) bVar;
            if (smVar instanceof sm) {
                switch (smVar.gae.fEG) {
                    case 1:
                        if (!this.rUW.username.equals(smVar.gae.username)) {
                            smVar.gaf.gag = 2;
                            break;
                        }
                        smVar.gaf.gag = 1;
                        break;
                    case 2:
                        if (this.rUW.username.equals(smVar.gae.username)) {
                            WearYoUI.b(this.rUW);
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };
    private boolean rUR;
    private AtomicInteger rUS = new AtomicInteger();
    private Runnable rUT = new Runnable(this) {
        final /* synthetic */ WearYoUI rUW;

        {
            this.rUW = r1;
        }

        public final void run() {
            this.rUW.jYD.vibrate(200);
            this.rUW.ipv.animate().scaleX(1.2f);
            this.rUW.ipv.animate().scaleY(1.2f);
            this.rUW.ipv.animate().setDuration(200);
            this.rUW.ipv.animate().start();
            this.rUW.ipv.animate().setListener(new a(this.rUW, 1));
        }
    };
    private BroadcastReceiver rUU = new BroadcastReceiver(this) {
        final /* synthetic */ WearYoUI rUW;

        {
            this.rUW = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
                this.rUW.finish();
            }
        }
    };
    private c rUV = new c<im>(this) {
        final /* synthetic */ WearYoUI rUW;

        {
            this.rUW = r2;
            this.usg = im.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((im) bVar) instanceof im) {
                this.rUW.finish();
            }
            return false;
        }
    };
    private String username;

    private class a implements AnimatorListener {
        private int kzY = 1;
        final /* synthetic */ WearYoUI rUW;

        public a(WearYoUI wearYoUI, int i) {
            this.rUW = wearYoUI;
            this.kzY = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.kzY == 2) {
                w.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[]{Integer.valueOf(this.rUW.rUS.get())});
                if (this.rUW.rUS.get() > 0) {
                    this.rUW.rUS.decrementAndGet();
                    af.f(this.rUW.rUT, 1000);
                    return;
                }
                this.rUW.ipv.animate().setListener(null);
                this.rUW.rUR = false;
            } else if (this.kzY == 1) {
                this.rUW.ipv.animate().scaleX(1.0f);
                this.rUW.ipv.animate().scaleY(1.0f);
                this.rUW.ipv.animate().setDuration(100);
                this.rUW.ipv.animate().start();
                this.rUW.ipv.animate().setListener(new a(this.rUW, 2));
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.rUW.rUR = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        if (wearYoUI.rUR) {
            wearYoUI.rUS.addAndGet(1);
            w.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", new Object[]{Integer.valueOf(wearYoUI.rUS.get())});
            return;
        }
        wearYoUI.rUR = true;
        af.v(wearYoUI.rUT);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(R.i.drJ);
        this.jYD = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.ipv = (ImageView) findViewById(R.h.bqM);
        this.jWd = (TextView) findViewById(R.h.cof);
        this.rUM = (ImageView) findViewById(R.h.bqO);
        this.rUN = (ImageView) findViewById(R.h.bqP);
        this.rUO = (ImageView) findViewById(R.h.bqQ);
        com.tencent.mm.pluginsdk.ui.a.b.m(this.ipv, this.username);
        this.jWd.setText(n.eK(this.username));
        this.ipv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WearYoUI rUW;

            {
                this.rUW = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wear.model.a.bvG();
                w.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[]{this.rUW.username});
                Intent intent = new Intent();
                intent.putExtra("Main_User", r0);
                intent.putExtra("From_fail_notify", true);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                d.a(ab.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                this.rUW.finish();
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(this.rUQ);
        com.tencent.mm.sdk.b.a.urY.b(this.rUV);
        a(0, this.rUM, 0);
        a(1, this.rUN, 1300);
        a(2, this.rUO, 2600);
        this.jYD.vibrate(200);
        registerReceiver(this.rUU, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(R.a.aQS, R.a.aQT);
    }

    private void a(int i, ImageView imageView, long j) {
        this.rUP[i][0] = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 2.5f});
        this.rUP[i][0].setRepeatCount(-1);
        this.rUP[i][0].setStartDelay(j);
        this.rUP[i][0].setDuration(3900);
        this.rUP[i][0].start();
        this.rUP[i][1] = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 2.5f});
        this.rUP[i][1].setRepeatCount(-1);
        this.rUP[i][1].setStartDelay(j);
        this.rUP[i][1].setDuration(3900);
        this.rUP[i][1].start();
        this.rUP[i][2] = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{1.0f, 0.0f});
        this.rUP[i][2].setRepeatCount(-1);
        this.rUP[i][2].setInterpolator(new AccelerateInterpolator());
        this.rUP[i][2].setStartDelay(j);
        this.rUP[i][2].setDuration(3900);
        this.rUP[i][2].start();
    }

    public void onClickCheck(View view) {
        w.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[]{this.username});
        ap.vd().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
    }

    public void onClickNoCheck(View view) {
        w.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[]{this.username});
        finish();
    }

    protected void onDestroy() {
        for (int i = 0; i < this.rUP.length; i++) {
            for (ObjectAnimator cancel : this.rUP[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.rUU);
        com.tencent.mm.sdk.b.a.urY.c(this.rUV);
        com.tencent.mm.sdk.b.a.urY.c(this.rUQ);
        com.tencent.mm.plugin.wear.model.a.bvG().rTv.bvZ();
        super.onDestroy();
    }
}

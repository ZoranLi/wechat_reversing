package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.g;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String fOI;
    private ProgressBar jKM;
    private ListView kaM;
    private String oVk;
    private TextView vaF;
    private CountDownTimer vaG;
    private int vaH = 30;
    private a vaI;
    private List<Integer> vaJ = new ArrayList();
    String[] vaK = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable vaL;
    private List<Drawable> vaM = new ArrayList();
    private boolean vaN = false;
    private j vad;
    private boolean vae;
    private com.tencent.mm.ui.account.j.a vaf = new com.tencent.mm.ui.account.j.a(this) {
        final /* synthetic */ RegByMobileWaitingSMSUI vaO;

        {
            this.vaO = r1;
        }

        public final void SP(String str) {
            this.vaO.SO(str.trim());
        }

        public final void bQX() {
            this.vaO.SO(null);
        }
    };

    private class a extends ArrayAdapter<String> {
        private final LayoutInflater myo;
        final /* synthetic */ RegByMobileWaitingSMSUI vaO;
        private final ArrayList<String> vaQ;

        public final /* synthetic */ void add(Object obj) {
            Jl((String) obj);
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                View inflate;
                b bVar2 = new b(this.vaO);
                switch (itemViewType) {
                    case 0:
                        inflate = this.myo.inflate(R.i.cTK, null);
                        break;
                    case 1:
                        inflate = this.myo.inflate(R.i.cTL, null);
                        break;
                    default:
                        throw new IllegalArgumentException("UNIMPLEMENT TYPE");
                }
                bVar2.vaR = (TextView) inflate.findViewById(R.h.bAi);
                bVar2.hBi = (ImageView) inflate.findViewById(R.h.bzT);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            int intValue = ((Integer) this.vaO.vaJ.get(i % this.vaO.vaJ.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.hBi.setImageDrawable((Drawable) this.vaO.vaM.get(intValue % this.vaO.vaM.size()));
                    break;
                case 1:
                    bVar.hBi.setImageDrawable(this.vaO.vaL);
                    break;
            }
            bVar.vaR.setText(hO(i));
            return view;
        }

        public final int getCount() {
            return this.vaQ.size();
        }

        private String hO(int i) {
            return (String) this.vaQ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((Integer) this.vaO.vaJ.get(i % this.vaO.vaJ.size())).intValue() % 4 == 0) {
                return 1;
            }
            return 0;
        }

        public final void Jl(String str) {
            this.vaQ.add(str);
            notifyDataSetChanged();
        }
    }

    private class b {
        public ImageView hBi;
        final /* synthetic */ RegByMobileWaitingSMSUI vaO;
        public TextView vaR;

        public b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
            this.vaO = regByMobileWaitingSMSUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vaM.add(getResources().getDrawable(R.g.bfH));
        this.vaM.add(getResources().getDrawable(R.g.bfI));
        this.vaM.add(getResources().getDrawable(R.g.bfJ));
        this.vaM.add(getResources().getDrawable(R.g.bfK));
        this.vaM.add(getResources().getDrawable(R.g.bfL));
        this.vaM.add(getResources().getDrawable(R.g.bfM));
        KC();
        this.vad = new j(this, this.vaf);
        this.vad.bRk();
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
    }

    protected void onDestroy() {
        if (this.vad != null) {
            this.vad.bRl();
            this.vad = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_250," + ap.ec("RE200_250") + ",1");
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.c.b.mM("RE200_250");
        if (this.vaN) {
            com.tencent.mm.plugin.c.b.mN(this.oVk);
        } else {
            com.tencent.mm.plugin.c.b.mN("RE200_300");
        }
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",RE200_250," + ap.ec("RE200_250") + ",2");
    }

    protected final void KC() {
        this.vaF = (TextView) findViewById(R.h.cOZ);
        this.jKM = (ProgressBar) findViewById(R.h.cPb);
        this.kaM = (ListView) findViewById(R.h.cPa);
        this.vae = false;
        String string = getString(R.l.dNS);
        if (d.sYQ) {
            string = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        qP(string);
        this.fOI = getIntent().getExtras().getString("bindmcontact_mobile");
        this.fOI = an.PB(this.fOI);
        this.vaH = getIntent().getIntExtra("mobileverify_countdownsec", this.vaH);
        Random random = new Random();
        for (int i = 0; i < this.vaH; i++) {
            this.vaJ.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.vaM.size();
        this.vaL = (Drawable) this.vaM.get(nextInt);
        this.vaM.remove(nextInt);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI vaO;

            {
                this.vaO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vaO.goBack();
                return true;
            }
        });
        an anVar = new an();
        string = "86";
        if (this.fOI.startsWith("+")) {
            this.fOI = this.fOI.replace("+", "");
            string = an.yU(this.fOI);
            if (string != null) {
                this.fOI = this.fOI.substring(string.length());
            }
        }
        CharSequence formatNumber = an.formatNumber(string, this.fOI);
        if (string == null || string.length() <= 0) {
            this.vaF.setText(formatNumber);
        } else {
            this.vaF.setText("+" + string + " " + formatNumber);
        }
        this.kaM.setVisibility(4);
        if (this.vaG == null) {
            this.vaG = new CountDownTimer(this, (long) (this.vaH * 1000)) {
                final /* synthetic */ RegByMobileWaitingSMSUI vaO;

                public final void onFinish() {
                    this.vaO.SO(null);
                }

                public final void onTick(long j) {
                    int c = (int) (((long) this.vaO.vaH) - (j / 1000));
                    this.vaO.jKM.setProgress(c);
                    if (c % 2 == 0 && this.vaO.vaI != null) {
                        this.vaO.vaI.Jl(this.vaO.vaK[(c / 2) % this.vaO.vaK.length]);
                        this.vaO.kaM.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 vaP;

                            {
                                this.vaP = r1;
                            }

                            public final void run() {
                                if (VERSION.SDK_INT >= 8) {
                                    this.vaP.vaO.kaM.smoothScrollToPosition(this.vaP.vaO.vaI.getCount() - 1);
                                } else {
                                    this.vaP.vaO.kaM.setSelection(this.vaP.vaO.vaI.getCount() - 1);
                                }
                            }
                        });
                    }
                }
            };
            this.jKM.setMax(this.vaH);
            this.vaG.start();
        }
    }

    protected final int getLayoutId() {
        return R.i.djA;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        g.a(this, getString(R.l.eBf), "", getString(R.l.eBg), getString(R.l.eBh), new OnClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI vaO;

            {
                this.vaO = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.vaO.vaN = true;
                this.vaO.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI vaO;

            {
                this.vaO = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private synchronized void SO(String str) {
        if (this.vad != null) {
            this.vad.bRl();
            this.vad = null;
        }
        if (!(this.vaG == null || this.vaG == null)) {
            this.vaG.cancel();
            this.vaG = null;
        }
        if (!this.vae) {
            this.vae = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileWaitingSMSUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.RegByMobileWaitingSMSUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.vad != null) {
                    this.vad.bRm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

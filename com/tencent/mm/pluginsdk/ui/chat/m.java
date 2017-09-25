package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aw.b.b;
import com.tencent.mm.e.a.rl;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class m extends LinearLayout {
    private Context mContext;
    private TelephonyManager mMp;
    PhoneStateListener mMq = new PhoneStateListener(this) {
        final /* synthetic */ m sRt;

        {
            this.sRt = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (this.sRt.sQM != null) {
                i2 = this.sRt.sQM.bEE();
            }
            w.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 2) {
                this.sRt.pause();
            }
        }
    };
    private Button nuQ;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a sLb = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a(this) {
        final /* synthetic */ m sRt;

        {
            this.sRt = r1;
        }

        public final void bEF() {
            m.b(this.sRt, R.l.fax);
        }
    };
    private boolean sLh = false;
    private MMEditText sLn;
    private h sOY;
    private int sOo = com.tencent.mm.bg.a.fromDPToPix(getContext(), cp.CTRL_INDEX);
    private VoiceInputLayout sQM;
    private ImageButton sQN;
    private Button sQO;
    public a sQP;
    private MMEditText sQQ = null;
    private VoiceInputScrollView sQR;
    private TextView sQS;
    private long sQT = 0;
    private boolean sQU = false;
    private float sQV = 0.0f;
    private float sQW = 0.0f;
    private boolean sQX = false;
    private boolean sQY = false;
    private boolean sQZ = false;
    private int sRa = e.CTRL_INDEX;
    private final String sRb = "voiceinput_downdistance_content";
    private boolean sRc = false;
    private boolean sRd = false;
    private long sRe = 0;
    private long sRf = 0;
    private long sRg = 0;
    private boolean sRh = false;
    private boolean sRi = false;
    private final int sRj = 2;
    private boolean sRk = false;
    public String sRl = "";
    private Toast sRm;
    private Set<String> sRn = new HashSet();
    private n sRo;
    private c<rl> sRp;
    private b sRq;
    private VoiceInputLayout.b sRr = new VoiceInputLayout.b(this) {
        final /* synthetic */ m sRt;

        {
            this.sRt = r1;
        }

        public final void bEG() {
            this.sRt.sRe = System.currentTimeMillis();
            w.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(this.sRt.sRe));
            w.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(this.sRt.sRe));
            this.sRt.sRc = false;
            this.sRt.sRd = true;
            this.sRt.sRk = true;
            this.sRt.sRf = 0;
            this.sRt.sRg = 0;
            this.sRt.bGg();
            this.sRt.sQS.setVisibility(8);
            this.sRt.sRd = false;
            this.sRt.sRo.sKV = 3;
            this.sRt.sRo.b(this.sRt.sLn);
            m.bGh();
            if (this.sRt.sLn != null) {
                if (this.sRt.sLn.getText() != null && this.sRt.sLn.getText().length() > 0) {
                    this.sRt.sLn.setCursorVisible(true);
                }
                this.sRt.sLn.requestFocus();
                bg.cX(this.sRt.sQM);
            }
            if (this.sRt.mContext instanceof Activity) {
                ((Activity) this.sRt.mContext).getWindow().addFlags(FileUtils.S_IWUSR);
            }
            this.sRt.nuQ.setVisibility(4);
            this.sRt.sQN.setVisibility(4);
            this.sRt.sQO.setVisibility(8);
            this.sRt.sLn.setHint(this.sRt.getResources().getString(R.l.fav));
            this.sRt.sQP.jn(true);
        }

        public final void bEH() {
            this.sRt.sQP.jn(false);
            this.sRt.sLn.setHint(null);
        }

        public final void bEI() {
            w.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            m.r(this.sRt);
            this.sRt.sRo.a(this.sRt.sLn);
            this.sRt.bGg();
            if (this.sRt.mContext instanceof Activity) {
                ((Activity) this.sRt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            m.xK(2);
            this.sRt.sQP.jn(false);
            this.sRt.sLn.setHint(null);
        }

        public final void bEJ() {
            w.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            this.sRt.sRo.a(this.sRt.sLn);
            this.sRt.bGg();
            if (this.sRt.mContext instanceof Activity) {
                ((Activity) this.sRt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            m.xK(3);
            this.sRt.sQP.jn(false);
            this.sRt.sLn.setHint(null);
        }

        public final void bEK() {
            w.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            m.r(this.sRt);
            this.sRt.sRo.a(this.sRt.sLn);
            this.sRt.bGg();
            if (this.sRt.mContext instanceof Activity) {
                ((Activity) this.sRt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            m.c(this.sRt, 1);
            this.sRt.sQP.jn(false);
            this.sRt.sLn.setHint(null);
        }

        public final void b(String[] strArr, Set<String> set) {
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (this.sRt.sRk) {
                    this.sRt.sRk = false;
                    m.t(this.sRt);
                }
                this.sRt.sRo.a(this.sRt.sLn, strArr[0], true);
                if (this.sRt.sLn.getText().length() != 0) {
                    this.sRt.sLn.setCursorVisible(true);
                    this.sRt.sLn.requestFocus();
                    bg.cX(this.sRt.sQM);
                }
                if (!(this.sRt.sRc || strArr[0].length() == 0)) {
                    this.sRt.sRc = true;
                    this.sRt.sRf = System.currentTimeMillis();
                    w.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.sRt.sRf - this.sRt.sRe));
                }
                this.sRt.sRn.addAll(set);
            }
        }

        public final void T(int i, int i2, int i3) {
            w.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            m.r(this.sRt);
            this.sRt.sRo.a(this.sRt.sLn);
            this.sRt.bGg();
            if (this.sRt.mContext instanceof Activity) {
                ((Activity) this.sRt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            m.c(this.sRt, i);
            if (i == 12) {
                m.b(this.sRt, R.l.faw);
            } else {
                m.b(this.sRt, R.l.dGU);
            }
            this.sRt.sQP.jn(false);
            this.sRt.sLn.setHint(null);
        }
    };
    private boolean sRs = true;

    public interface a {
        void MI(String str);

        void bEy();

        void jn(boolean z);
    }

    static /* synthetic */ void a(m mVar, int i) {
        w.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (mVar.sLn != null && mVar.sLn.getText() != null) {
            String obj = mVar.sLn.getText().toString();
            if (obj.trim().length() == 0 && obj.length() == 0) {
                if (mVar.sOY == null || !mVar.sOY.isShowing()) {
                    mVar.sOY = g.h(mVar.getContext(), R.l.dTq, R.l.dIO);
                }
            } else if (mVar.sQP != null) {
                if (!mVar.sQU) {
                    VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                    voiceInputBehavior.send = 1;
                    if (mVar.sRi) {
                        voiceInputBehavior.send = 2;
                    }
                    if (i != 1) {
                        if (i == 4) {
                            voiceInputBehavior.send = 4;
                        }
                        a(voiceInputBehavior);
                        w.i("MicroMsg.VoiceInputPanel", "cgiReport size = %s", Integer.valueOf(mVar.sRn.size()));
                        if (mVar.sRq == null) {
                            mVar.sRq = new b();
                        }
                        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100235");
                        w.i("MicroMsg.VoiceInputPanel", "cgiReport: abTestFlag = [%s]", Integer.valueOf(dX.isValid() ? bg.getInt((String) dX.bKK().get("MMVoipVadOn"), 0) : 0));
                        b bVar = mVar.sRq;
                        Collection collection = mVar.sRn;
                        String valueOf = String.valueOf(r0);
                        Set hashSet = new HashSet();
                        hashSet.addAll(collection);
                        com.tencent.mm.kernel.h.vL().D(new com.tencent.mm.aw.b.b.AnonymousClass1(bVar, hashSet, obj, valueOf));
                        mVar.sRn.clear();
                    }
                }
                w.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                mVar.sQP.MI(obj);
            }
        } else if (mVar.sOY == null || !mVar.sOY.isShowing()) {
            mVar.sOY = g.h(mVar.getContext(), R.l.dTq, R.l.dIO);
        }
    }

    static /* synthetic */ boolean a(m mVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (mVar.sQR.getScrollY() <= 0) {
                mVar.sQY = true;
                mVar.sQV = motionEvent.getRawY();
            }
            mVar.sQZ = true;
        } else if (motionEvent.getAction() == 2) {
            mVar.sQX = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (mVar.sQX && mVar.sQY) {
                mVar.sQW = motionEvent.getRawY();
                f = mVar.sQW - mVar.sQV;
            } else {
                f = 0.0f;
            }
            mVar.sQZ = false;
            mVar.sQX = false;
            mVar.sQY = false;
            mVar.sQW = 0.0f;
            mVar.sQV = 0.0f;
            if (f > ((float) mVar.sRa)) {
                if (!(mVar.sLn == null || mVar.sLn.getText() == null || mVar.sLn.getText().length() <= 0)) {
                    SharedPreferences bIY = ab.bIY();
                    if (bIY != null) {
                        bIY.edit().putString("voiceinput_downdistance_content", mVar.sLn.getText().toString()).apply();
                        w.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                mVar.bGf();
            } else if (mVar.sLh) {
                mVar.sLh = false;
            } else if ((view instanceof MMEditText) && mVar.sLn != null && mVar.sLn.getText() != null && mVar.sLn.getText().length() > 0) {
                Spannable newSpannable = Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = (((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft()) + mMEditText.getScrollX();
                int y = (((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop()) + mMEditText.getScrollY();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    w.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY())));
                    if (mVar.sQM != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = mVar.sQM.bEE();
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(mVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    if (!(mVar.sLn == null || mVar.sLn.getText() == null)) {
                        intent.putExtra("text", mVar.sLn.getText().toString());
                        if (mVar.sRo != null) {
                            mVar.sRo.b(mVar.sLn);
                        }
                    }
                    if (mVar.sRl.equalsIgnoreCase("。") || mVar.sRl.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", mVar.sRl);
                    }
                    mVar.getContext().startActivity(intent);
                    bg.cX(mVar.sQM);
                    if (mVar.sQM != null) {
                        mVar.sQM.bEB();
                    }
                }
            }
            return view instanceof MMEditText;
        }
        return view instanceof MMEditText;
    }

    static /* synthetic */ void b(m mVar, int i) {
        if (mVar.sRm != null) {
            mVar.sRm.cancel();
        }
        mVar.sRm = Toast.makeText(mVar.mContext, mVar.mContext.getResources().getString(i), 0);
        mVar.sRm.setGravity(17, 0, 0);
        mVar.sRm.show();
    }

    static /* synthetic */ void bGh() {
        w.i("MicroMsg.VoiceInputPanel", "pauseMusic");
        ap.yZ().qP();
    }

    static /* synthetic */ void c(m mVar, int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        xK(i);
    }

    static /* synthetic */ void r(m mVar) {
        if (mVar.sLn != null && mVar.sLn.getText() != null) {
            String obj = mVar.sLn.getText().toString();
            if (obj.length() <= 0) {
                return;
            }
            if (!mVar.sQU || mVar.sLn.getSelectionStart() >= obj.length()) {
                mVar.sRl = obj.substring(obj.length() - 1, obj.length());
                w.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s punctuation = %s", obj, mVar.sRl);
                if (mVar.sRl.equalsIgnoreCase("。") || mVar.sRl.equalsIgnoreCase(".")) {
                    mVar.sLn.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
    }

    static /* synthetic */ void t(m mVar) {
        if (mVar.sLn != null && mVar.sLn.getText() != null && mVar.sLn.getText().length() > 0) {
            if (mVar.sRl.equalsIgnoreCase("。") || mVar.sRl.equalsIgnoreCase(".")) {
                if (!mVar.sQU || mVar.sLn.getSelectionStart() >= mVar.sLn.getText().length()) {
                    mVar.sRo.a(mVar.sLn, mVar.sRl, true);
                    mVar.sRo.b(mVar.sLn);
                }
                mVar.sRl = "";
            }
            w.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s", mVar.sLn.getText().toString());
        }
    }

    public m(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        this.mContext = context;
        this.sQU = z;
        this.sQQ = mMEditText;
        init();
        this.sRo = new n(this.mContext);
        bGe();
    }

    @TargetApi(16)
    private void init() {
        w.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.dpA, this);
        this.sQN = (ImageButton) findViewById(R.h.cMT);
        this.sQO = (Button) findViewById(R.h.cMS);
        this.nuQ = (Button) findViewById(R.h.cMW);
        this.sQS = (TextView) findViewById(R.h.cGy);
        if (this.sQU) {
            this.sQN.setVisibility(4);
        } else {
            this.sQN.setVisibility(0);
        }
        this.nuQ.setVisibility(4);
        this.sQO.setVisibility(8);
        if (!this.sQU || this.sQQ == null) {
            this.sLn = (MMEditText) findViewById(R.h.cMX);
            this.sLn.setHintTextColor(getResources().getColor(R.e.aVl));
            this.sLn.setClickable(true);
            this.sLn.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ m sRt;

                {
                    this.sRt = r1;
                }

                public final boolean onLongClick(View view) {
                    if (this.sRt.sQZ) {
                        this.sRt.sLh = true;
                    }
                    return true;
                }
            });
            this.sLn.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ m sRt;

                {
                    this.sRt = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return m.a(this.sRt, view, motionEvent);
                }
            });
        } else {
            this.sLn = this.sQQ;
        }
        this.sQR = (VoiceInputScrollView) findViewById(R.h.cMV);
        this.sQN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m sRt;

            {
                this.sRt = r1;
            }

            public final void onClick(View view) {
                this.sRt.bGf();
            }
        });
        this.nuQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m sRt;

            {
                this.sRt = r1;
            }

            public final void onClick(View view) {
                m.a(this.sRt, 2);
            }
        });
        this.sQO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m sRt;

            {
                this.sRt = r1;
            }

            public final void onClick(View view) {
                this.sRt.reset();
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.clear = 1;
                m.a(voiceInputBehavior);
            }
        });
        this.sQR.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ m sRt;

            {
                this.sRt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return m.a(this.sRt, view, motionEvent);
            }
        });
    }

    public final void bGe() {
        this.sQT = bg.NA();
        if (this.sRp == null) {
            w.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.sRp = new c<rl>(this) {
                final /* synthetic */ m sRt;

                {
                    this.sRt = r2;
                    this.usg = rl.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    rl rlVar = (rl) bVar;
                    if (!(rlVar instanceof rl)) {
                        w.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        return false;
                    } else if (rlVar == null || rlVar.fYv == null) {
                        w.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        return false;
                    } else if (this.sRt.sQU) {
                        w.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
                        return false;
                    } else {
                        w.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(rlVar.fYv.action), Integer.valueOf(rlVar.fYv.fYw));
                        if (rlVar.fYv.action == 2) {
                            if (rlVar.fYv.fYw == 1) {
                                this.sRt.sRi = true;
                            } else {
                                this.sRt.sRi = false;
                            }
                            this.sRt.sRo.a(this.sRt.sLn, rlVar.fYv.result, false);
                            this.sRt.sRo.a(this.sRt.sLn);
                            this.sRt.sRo.b(this.sRt.sLn);
                            this.sRt.bGg();
                            this.sRt.sQR.fullScroll(130);
                        } else if (rlVar.fYv.action == 3) {
                            if (this.sRt.sQP != null) {
                                this.sRt.sQP.bEy();
                            }
                        } else if (rlVar.fYv.action == 1 || rlVar.fYv.action == 4) {
                            if (rlVar.fYv.fYw == 1) {
                                this.sRt.sRi = true;
                            } else {
                                this.sRt.sRi = false;
                            }
                            this.sRt.sRo.a(this.sRt.sLn, rlVar.fYv.result, false);
                            this.sRt.sRo.a(this.sRt.sLn);
                            this.sRt.sRo.b(this.sRt.sLn);
                            this.sRt.bGg();
                            this.sRt.sQR.fullScroll(130);
                            m.a(this.sRt, rlVar.fYv.action);
                        } else {
                            this.sRt.reset();
                        }
                        return true;
                    }
                }
            };
            com.tencent.mm.sdk.b.a.urY.b(this.sRp);
        }
        if (this.sQM == null) {
            this.sQM = (VoiceInputLayout) findViewById(R.h.cMY);
            this.sQM.sKW = this.sRr;
            this.sQM.a(this.sLb);
            this.sQM.jp(this.sQU);
        }
        if (this.sQS != null) {
            this.sQS.setVisibility(0);
        }
        if (this.sRq == null) {
            this.sRq = new b();
        }
        SharedPreferences bIY = ab.bIY();
        if (bIY != null) {
            String string = bIY.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                w.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", Integer.valueOf(string.length()));
                this.sRo.b(this.sLn);
                this.sRo.a(this.sLn, string, false);
                this.sRo.a(this.sLn);
                this.sRo.b(this.sLn);
                bGg();
                this.sQR.fullScroll(130);
                bIY.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.mMp = (TelephonyManager) ab.getContext().getSystemService("phone");
        this.mMp.listen(this.mMq, 32);
    }

    public final void pause() {
        w.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.sQM != null) {
            this.sQM.bEB();
        }
        this.sQV = 0.0f;
        this.sQW = 0.0f;
        this.sQX = false;
        this.sQY = false;
        this.sLh = false;
        this.sQZ = false;
        this.sRh = false;
        this.sRs = true;
    }

    public final void reset() {
        w.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.sRi = false;
        this.sRn.clear();
        if (this.sLn != null) {
            if (this.sRo != null) {
                this.sRo.b(this.sLn);
                this.sRo.a(this.sLn, "", false);
                this.sRo.a(this.sLn);
                this.sRo.b(this.sLn);
            }
            bGg();
        }
    }

    public final void destory() {
        w.i("MicroMsg.VoiceInputPanel", "destory");
        reset();
        if (this.sRp != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.sRp);
            this.sRp = null;
        }
        if (this.sQM != null) {
            this.sQM.sKW = null;
            this.sQM = null;
        }
        if (this.sRq != null) {
            this.sRq = null;
        }
        if (!(this.mMp == null || this.mMq == null)) {
            this.mMp.listen(this.mMq, 0);
            this.mMq = null;
        }
        this.mMp = null;
        this.sQQ = null;
    }

    private void bGf() {
        w.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.sQP != null) {
            this.sRh = true;
            w.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.sLn == null || this.sLn.getText() == null || this.sLn.getText().length() <= 0) {
                if (this.sRh) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.sRh) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.sQT != 0) {
                voiceInputBehavior.voiceInputTime = bg.aB(this.sQT);
                this.sQT = 0;
            }
            a(voiceInputBehavior);
            this.sQP.bEy();
        }
    }

    public final void xJ(int i) {
        w.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.sOo), Integer.valueOf(i));
        if (this.sOo != i) {
            this.sOo = i;
            this.sRs = true;
        }
    }

    public final void bFk() {
        w.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(this.sOo), Boolean.valueOf(this.sRs));
        if (this.sRs) {
            this.sRs = false;
            View findViewById = findViewById(R.h.cMU);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.sOo;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            requestLayout();
        }
    }

    public final void bGg() {
        w.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.sLn == null || this.sLn.getText() == null || this.sLn.getText().length() != 0) {
            if (this.sLn != null) {
                this.sLn.setCursorVisible(true);
            }
            this.nuQ.setVisibility(0);
            if (!this.sQU) {
                this.sQN.setVisibility(8);
                this.sQO.setVisibility(0);
            }
            this.sQS.setVisibility(8);
        } else {
            this.sLn.setSelection(0);
            this.sLn.setCursorVisible(false);
            this.nuQ.setVisibility(4);
            if (!this.sQU) {
                this.sQN.setVisibility(0);
            }
            this.sQO.setVisibility(8);
            this.sQS.setVisibility(0);
        }
        if (this.sQU) {
            if (this.sQQ == null || this.sQQ.getText() == null || this.sQQ.getText().length() != 0) {
                this.nuQ.setVisibility(0);
            } else {
                this.nuQ.setVisibility(4);
            }
        }
        this.sLn.clearFocus();
        w.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        ap.yZ().qQ();
        if (!this.sRd) {
            this.sRd = true;
            this.sRg = System.currentTimeMillis();
            w.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.sRg), Long.valueOf(this.sRg - this.sRf));
        }
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        w.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.g.oUh.b(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }

    private static void xK(int i) {
        w.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.g.oUh.a(455, (long) i, 1, false);
    }
}

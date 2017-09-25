package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.ah.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.pluginsdk.model.app.ag;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter extends LinearLayout implements OnGlobalLayoutListener, com.tencent.mm.pluginsdk.ui.chat.h.a {
    private static int count = 0;
    private static final int[] jYx = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] jYy = new int[]{R.g.bbG, R.g.bbH, R.g.bbI, R.g.bbJ, R.g.bbK, R.g.bbL, R.g.bbM};
    private Activity activity;
    private Context context;
    public String fOu;
    private ImageView jYG;
    private boolean jYO;
    private final ae jYX;
    private String kVa;
    public View lNG;
    public View lNH;
    public View lNI;
    public View lNJ;
    public View lmQ;
    public final ae mHandler;
    public MMEditText nuP;
    public Button nuQ;
    public ChatFooterPanel nuR;
    public o qZb;
    private TextView qZc;
    private ImageView qZd;
    public View qZe;
    private int sIA;
    public f sIz;
    public m sKE;
    public boolean sKI;
    public AppPanel sOQ;
    public TextView sOR;
    private Button sOS;
    public ImageButton sOT;
    public LinearLayout sOU;
    public ChatFooterBottom sOV;
    public ImageButton sOW;
    public ImageButton sOX;
    private h sOY;
    private i sOZ;
    private final int sPA;
    private final int sPB;
    private final int sPC;
    private final int sPD;
    private final int sPE;
    private final int sPF;
    private final int sPG;
    private final int sPH;
    private int sPI;
    private int sPJ;
    private int sPK;
    private int sPL;
    private boolean sPM;
    private final int sPN;
    private final int sPO;
    private volatile boolean sPP;
    private ae sPQ;
    private int sPR;
    private int sPS;
    private int sPT;
    private View sPU;
    public boolean sPV;
    private int sPW;
    public l sPa;
    public b sPb;
    private d sPc;
    public final a sPd;
    public boolean sPe;
    public boolean sPf;
    private TextView sPg;
    private InputMethodManager sPh;
    public int sPi;
    private boolean sPj;
    private boolean sPk;
    public boolean sPl;
    public b sPm;
    public c sPn;
    private com.tencent.mm.pluginsdk.ui.chat.l.a sPo;
    private boolean sPp;
    public q sPq;
    private boolean sPr;
    private Animation sPs;
    private Animation sPt;
    private com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a sPu;
    private com.tencent.mm.pluginsdk.ui.chat.AppPanel.b sPv;
    public e sPw;
    private int sPx;
    public boolean sPy;
    private int sPz;
    public String toUser;

    class AnonymousClass18 implements Runnable {
        final /* synthetic */ ChatFooter sPX;
        final /* synthetic */ boolean sPY = false;

        AnonymousClass18(ChatFooter chatFooter, boolean z) {
            this.sPX = chatFooter;
        }

        public final void run() {
            this.sPX.jG(this.sPY);
        }
    }

    private static class a {
        public String sQb;
        public String sQc;
        public int sQd;
        public HashMap<String, LinkedList<HashMap<String, String>>> sQe = new HashMap();
    }

    public interface b {
        void a(Boolean bool, Boolean bool2);

        void b(Boolean bool, Boolean bool2);
    }

    public interface c {
        void d(Boolean bool);
    }

    public interface d {
        boolean jH(boolean z);
    }

    public class e implements TextWatcher {
        final /* synthetic */ ChatFooter sPX;
        TextWatcher sQf;
        private boolean sQg = false;
        private boolean sQh = f.ep(11);

        public e(ChatFooter chatFooter, TextWatcher textWatcher) {
            this.sPX = chatFooter;
            this.sQf = textWatcher;
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            if (this.sPX.sPk && this.sQg && editable.length() > 0) {
                this.sQg = false;
                this.sPX.nuP.setText(editable.subSequence(0, editable.length() - 1));
                if (this.sPX.nuP.length() > 0) {
                    this.sPX.nuQ.performClick();
                }
                w.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                return;
            }
            this.sQf.afterTextChanged(editable);
            if (this.sPX.sOR != null) {
                if (this.sPX.nuP.getLineCount() > 1) {
                    this.sPX.sOR.setVisibility(0);
                    this.sPX.sOR.setText(editable.length() + "/140");
                } else {
                    this.sPX.sOR.setVisibility(8);
                }
            }
            if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
                z = false;
            }
            this.sPX.fy(z);
            if (this.sPX.nuR != null) {
                this.sPX.nuR.dz(z);
            }
            w.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.sQf.beforeTextChanged(charSequence, i, i2, i3);
            w.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.sPX.sPk && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == '\n') {
                this.sQg = true;
            } else {
                this.sQf.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    static /* synthetic */ void B(ChatFooter chatFooter) {
        if (com.tencent.mm.n.a.aJ(chatFooter.context) || com.tencent.mm.n.a.aH(chatFooter.context)) {
            w.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            return;
        }
        chatFooter.findViewById(R.h.bAv).setVisibility(8);
        chatFooter.sPi = 1;
        chatFooter.nuP.setVisibility(8);
        chatFooter.sOS.setVisibility(8);
        chatFooter.xA(R.g.beh);
        if (chatFooter.nuR != null) {
            chatFooter.nuR.setVisibility(8);
        }
        chatFooter.sOQ.setVisibility(8);
        chatFooter.sOV.setVisibility(0);
        chatFooter.jB(false);
        if (chatFooter.sKE == null) {
            chatFooter.sKE = new m(chatFooter.getContext(), false, null);
            chatFooter.sOV.addView(chatFooter.sKE, new LayoutParams(-1, -1));
            chatFooter.sKE.sQP = new com.tencent.mm.pluginsdk.ui.chat.m.a(chatFooter) {
                final /* synthetic */ ChatFooter sPX;

                {
                    this.sPX = r1;
                }

                public final void bEy() {
                    this.sPX.bEx();
                }

                public final void MI(String str) {
                    if (this.sPX.sPb != null) {
                        this.sPX.sPb.zV(str);
                    } else {
                        w.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
                    }
                    this.sPX.sKE.reset();
                }

                public final void jn(boolean z) {
                    if (z) {
                        if (this.sPX.sPn != null) {
                            w.d("MicroMsg.ChatFooter", "onVoiceStart start");
                            this.sPX.sPn.d(Boolean.valueOf(true));
                        }
                    } else if (this.sPX.sPn != null) {
                        w.d("MicroMsg.ChatFooter", "onVoiceStart end");
                        this.sPX.sPn.d(Boolean.valueOf(false));
                    }
                }
            };
            chatFooter.sKE.xJ(j.aD(chatFooter.context));
        }
        chatFooter.sKE.bGe();
        chatFooter.sKE.bFk();
        chatFooter.sKE.setVisibility(0);
        chatFooter.sKI = true;
    }

    static /* synthetic */ void L(ChatFooter chatFooter) {
        chatFooter.sPQ.removeMessages(4097);
        chatFooter.sPQ.sendEmptyMessageDelayed(4097, 1);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        if (bg.mA(chatFooter.kVa)) {
            w.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
        } else if (str == null || str.equals("") || !com.tencent.mm.a.e.aO(str)) {
            w.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
        } else {
            ap.vd().a(new k(4, m.xL(), chatFooter.kVa, str, i, null, 0, "", "", true, R.g.bdJ), 0);
        }
    }

    static /* synthetic */ int bGa() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void q(ChatFooter chatFooter) {
        if (chatFooter.sPi == 1) {
            w.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), chatFooter.activity);
            if (com.tencent.mm.pluginsdk.i.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.ab(2, true);
                return;
            }
            return;
        }
        chatFooter.ab(1, true);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lmQ = null;
        this.nuP = null;
        this.nuQ = null;
        this.sOR = null;
        this.sPc = null;
        this.sPd = new a();
        this.sPe = false;
        this.sPf = false;
        this.jYO = false;
        this.sPj = false;
        this.sPk = false;
        this.sPl = false;
        this.sKI = false;
        this.sPo = new com.tencent.mm.pluginsdk.ui.chat.l.a(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void clear() {
                ChatFooter chatFooter = this.sPX;
                if (chatFooter.nuP != null) {
                    chatFooter.nuP.setText("");
                }
            }
        };
        this.mHandler = new ae(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            @SuppressLint({"NewApi"})
            @TargetApi(11)
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                        if (this.sPX.nuP != null && message.obj != null) {
                            boolean booleanValue = ((Boolean) message.obj).booleanValue();
                            if (booleanValue) {
                                this.sPX.nuP.setAlpha(1.0f);
                            } else {
                                this.sPX.nuP.setAlpha(0.5f);
                            }
                            this.sPX.jB(booleanValue);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.sPp = false;
        this.sPr = false;
        this.sPu = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void aIN() {
                this.sPX.sPi = 1;
                this.sPX.sOU.setVisibility(0);
                this.sPX.sOS.setVisibility(8);
                this.sPX.jB(true);
                this.sPX.xA(R.g.beh);
                if (this.sPX.nuQ != null) {
                    this.sPX.nuQ.performClick();
                }
            }

            public final void fz(boolean z) {
                this.sPX.sPi = 1;
                this.sPX.sOU.setVisibility(0);
                this.sPX.sOS.setVisibility(8);
                this.sPX.xA(R.g.beh);
                if (this.sPX.nuP != null) {
                    this.sPX.jF(z);
                }
            }

            public final void Zh() {
                this.sPX.sPi = 1;
                this.sPX.sOU.setVisibility(0);
                this.sPX.sOS.setVisibility(8);
                this.sPX.jB(true);
                this.sPX.xA(R.g.beh);
                this.sPX.nuP.wvn.sendKeyEvent(new KeyEvent(0, 67));
                this.sPX.nuP.wvn.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                this.sPX.sPi = 1;
                this.sPX.sOU.setVisibility(0);
                this.sPX.sOS.setVisibility(8);
                this.sPX.jB(true);
                this.sPX.xA(R.g.beh);
                try {
                    this.sPX.nuP.Uz(str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
                }
            }
        };
        this.sPv = new com.tencent.mm.pluginsdk.ui.chat.AppPanel.b(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void bFn() {
                w.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.sPX.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), this.sPX.activity);
                if (com.tencent.mm.pluginsdk.i.a.a(this.sPX.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                    int BR = ap.vd().BR();
                    if (BR == 4 || BR == 6) {
                        ChatFooter.B(this.sPX);
                    } else if (this.sPX.sOY == null || !this.sPX.sOY.isShowing()) {
                        this.sPX.sOY = g.h(this.sPX.getContext(), R.l.fco, R.l.dIO);
                    }
                }
            }
        };
        this.jYX = new ae(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (this.sPX.qZb != null) {
                    this.sPX.qZb.dismiss();
                    this.sPX.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.sPX.getContext(), R.g.biZ));
                    this.sPX.sOS.setEnabled(true);
                }
            }
        };
        this.sPx = 0;
        this.sPy = false;
        this.sPz = 0;
        this.sPA = 0;
        this.sPB = 1;
        this.sPC = 2;
        this.sPD = 3;
        this.sPE = 20;
        this.sPF = 21;
        this.sPG = 22;
        this.sPH = 23;
        this.sPI = 0;
        this.sPJ = 0;
        this.sPK = -1;
        this.sPL = -1;
        this.sPM = false;
        this.sPN = 4097;
        this.sPO = 4098;
        this.sPQ = new ae(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 4097:
                        this.sPX.sPP = true;
                        ViewGroup.LayoutParams layoutParams = this.sPX.sOV.getLayoutParams();
                        int bottom = this.sPX.sOV.getBottom() - this.sPX.sOV.getTop();
                        if (this.sPX.bFP()) {
                            if (this.sPX.nuR != null) {
                                this.sPX.nuR.setVisibility(8);
                            }
                            this.sPX.sOQ.setVisibility(8);
                            this.sPX.sOV.setVisibility(4);
                        }
                        if (bottom <= 3) {
                            this.sPX.sPP = false;
                            this.sPX.sOV.setVisibility(8);
                            this.sPX.xG(this.sPX.bFT());
                            return;
                        }
                        layoutParams.height = Math.max(bottom - 60, 1);
                        this.sPX.sOV.setLayoutParams(layoutParams);
                        ChatFooter.L(this.sPX);
                        return;
                    default:
                        return;
                }
            }
        };
        this.sPR = -1;
        this.sPS = -1;
        this.sPT = -1;
        this.sPU = null;
        this.sPV = true;
        this.sPW = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.sPh = (InputMethodManager) context.getSystemService("input_method");
        this.lmQ = inflate(context, R.i.cXt, this);
        this.nuP = (MMEditText) this.lmQ.findViewById(R.h.bAh);
        com.tencent.mm.ui.tools.a.c.d(this.nuP).Ch(com.tencent.mm.i.b.sw()).a(null);
        this.nuP.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        com.tencent.mm.sdk.b.b mfVar = new mf();
        mfVar.fTw.fTy = this.nuP;
        mfVar.fTw.fTx = new com.tencent.mm.pluginsdk.ui.a.a(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void MJ(final String str) {
                w.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
                if (bg.mA(this.sPX.kVa) || bg.mA(str)) {
                    w.e("MicroMsg.ChatFooter", "onImageReceived, error args");
                } else {
                    g.a(this.sPX.getContext(), this.sPX.getContext().getString(R.l.egQ), "", new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass21 sQa;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = 1;
                            boolean a = m.a(str, this.sQa.sPX.kVa, true);
                            ChatFooter chatFooter = this.sQa.sPX;
                            if (!a) {
                                i2 = 0;
                            }
                            ChatFooter.a(chatFooter, i2, str);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass21 sQa;

                        {
                            this.sQa = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(mfVar);
        this.sOU = (LinearLayout) this.lmQ.findViewById(R.h.cHJ);
        this.sOV = (ChatFooterBottom) findViewById(R.h.bAc);
        this.sOW = (ImageButton) this.lmQ.findViewById(R.h.bzS);
        this.nuQ = (Button) this.lmQ.findViewById(R.h.bBr);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.nuQ.setTextSize(0, ((float) com.tencent.mm.bg.a.U(context, R.f.aXs)) * com.tencent.mm.bg.a.dK(context));
        this.sOS = (Button) this.lmQ.findViewById(R.h.cNx);
        this.sOT = (ImageButton) findViewById(R.h.bAZ);
        fy(false);
        bFX();
        this.sOZ = new i(getContext(), getRootView(), this, new com.tencent.mm.pluginsdk.ui.chat.i.a(this) {
            final /* synthetic */ ChatFooter sPX;

            public final void Nb(String str) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                if (this.sPX.fOu != null) {
                    intent.putExtra("GalleryUI_FromUser", this.sPX.fOu);
                }
                if (this.sPX.toUser != null) {
                    intent.putExtra("GalleryUI_ToUser", this.sPX.toUser);
                }
                intent.putExtra("query_source_type", 3);
                intent.putExtra("preview_image", true);
                intent.putStringArrayListExtra("preview_image_list", arrayList);
                intent.putExtra("max_select_count", 1);
                intent.addFlags(67108864);
                if (this.sPX.sPq != null) {
                    com.tencent.mm.bb.d.a(this.sPX.sPq, "gallery", ".ui.GalleryEntryUI", intent, (int) com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX);
                } else {
                    com.tencent.mm.bb.d.b(context, "gallery", ".ui.GalleryEntryUI", intent, com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX);
                }
            }
        });
        this.sOZ.sQs = this;
        Context context2 = getContext();
        getRootView();
        this.sPa = new l(context2);
        this.sPa.sPo = this.sPo;
        w.d("MicroMsg.ChatFooter", "send edittext ime option %s", Integer.valueOf(this.nuP.getImeOptions()));
        this.nuP.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (i != 0 || !this.sPX.sPk)) {
                    return false;
                }
                this.sPX.nuQ.performClick();
                return true;
            }
        });
        this.nuP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.sPX.jF(true);
                this.sPX.r(3, -1, true);
                this.sPX.sPb.aJB();
                this.sPX.postDelayed(new AnonymousClass18(this.sPX, false), 10);
                return false;
            }
        });
        this.nuP.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onLongClick(View view) {
                return false;
            }
        });
        this.nuQ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final synchronized void onClick(View view) {
                String obj = this.sPX.nuP.getText().toString();
                w.d("MicroMsg.ChatFooter", "send msg onClick");
                if (obj.trim().length() == 0 && obj.length() != 0) {
                    w.d("MicroMsg.ChatFooter", "empty message cant be sent");
                    if (this.sPX.sOY == null || !this.sPX.sOY.isShowing()) {
                        this.sPX.sOY = g.h(this.sPX.getContext(), R.l.dTq, R.l.dIO);
                    }
                } else if (this.sPX.sPb.zV(obj)) {
                    this.sPX.nuP.clearComposingText();
                    this.sPX.nuP.setText("");
                }
            }
        });
        this.sOS.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == this.sPX.sOS) {
                    w.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
                    switch (motionEvent.getAction()) {
                        case 0:
                            w.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.count));
                            if (this.sPX.context instanceof Activity) {
                                ((Activity) this.sPX.context).getWindow().addFlags(FileUtils.S_IWUSR);
                            }
                            if (!(this.sPX.jYO || this.sPX.sPj)) {
                                this.sPX.jYO = true;
                                this.sPX.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.sPX.getContext(), R.g.bja));
                                this.sPX.sOS.setText(R.l.dSX);
                                this.sPX.sPb.aJy();
                                this.sPX.sOS.setContentDescription(this.sPX.getContext().getString(R.l.dSB));
                                break;
                            }
                        case 1:
                        case 3:
                            if (this.sPX.context instanceof Activity) {
                                ((Activity) this.sPX.context).getWindow().clearFlags(FileUtils.S_IWUSR);
                            }
                            w.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.count));
                            this.sPX.bFV();
                            w.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.bGa()));
                            break;
                        case 2:
                            if (this.sPX.lNI == null || this.sPX.lNJ == null) {
                                w.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", this.sPX.lNI, this.sPX.lNJ);
                            }
                            if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-this.sPX.sPx) / 2)) && motionEvent.getX() < ((float) this.sPX.sOS.getWidth())) {
                                if (this.sPX.lNI != null) {
                                    this.sPX.lNI.setVisibility(0);
                                }
                                if (this.sPX.lNJ != null) {
                                    this.sPX.sOS.setText(R.l.dSX);
                                    this.sPX.lNJ.setVisibility(8);
                                    break;
                                }
                            }
                            w.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(this.sPX.sPx), Integer.valueOf(this.sPX.sOS.getWidth()), Integer.valueOf(this.sPX.sOS.getHeight()));
                            if (this.sPX.lNI != null) {
                                this.sPX.lNI.setVisibility(8);
                            }
                            if (this.sPX.lNJ != null) {
                                this.sPX.sOS.setText(R.l.dSH);
                                this.sPX.lNJ.setVisibility(0);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        this.sOS.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getAction()) {
                    case 0:
                        if (!((i != 23 && i != 66) || this.sPX.sPj || this.sPX.jYO)) {
                            this.sPX.sPj = true;
                            this.sPX.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.sPX.getContext(), R.g.bja));
                            this.sPX.sOS.setText(R.l.dSX);
                            this.sPX.sPb.aJy();
                            this.sPX.sOS.setContentDescription(this.sPX.getContext().getString(R.l.dSB));
                            break;
                        }
                    case 1:
                        if (i == 23 || i == 66) {
                            this.sPX.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.sPX.getContext(), R.g.biZ));
                            this.sPX.sOS.setText(R.l.dSW);
                            this.sPX.sPb.aJv();
                            this.sPX.sPj = false;
                            break;
                        }
                }
                return false;
            }
        });
        this.sOT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void onClick(View view) {
                ChatFooter.q(this.sPX);
            }
        });
        bFr();
        this.sOW.setVisibility(0);
        this.sOW.setContentDescription(getContext().getString(R.l.dSy));
        this.sOW.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void onClick(View view) {
                this.sPX.bFp();
                if (m.yt().booleanValue() && this.sPX.sPm != null) {
                    this.sPX.sPm.a(Boolean.valueOf(true), Boolean.valueOf(true));
                }
            }
        });
        xG(-1);
        findViewById(R.h.bAv).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        w.d("MicroMsg.ChatFooter", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(Context context, Activity activity) {
        this.activity = activity;
        bFX();
        if (this.nuR != null) {
            this.nuR.onResume();
        }
        if (!this.sPp && this.sPk) {
            w.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
            this.sPk = false;
            this.nuP.setImeOptions(0);
            this.nuP.setInputType(this.nuP.getInputType() | 64);
        } else if (this.sPp && !this.sPk) {
            bFM();
        }
        if (this.sOQ != null) {
            this.sOQ.context = context;
        }
        this.context = context;
        this.sOZ.sQr = false;
        if (!this.sKI) {
            this.lmQ.findViewById(R.h.bBt).setVisibility(0);
            this.nuP.setVisibility(0);
        }
        bFJ();
        post(new Runnable(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void run() {
                j.f(this.sPX.activity);
            }
        });
    }

    public final void onPause() {
        this.sPr = true;
        if (this.nuR != null) {
            this.nuR.onPause();
        }
        if (this.sKI && this.sKE != null) {
            this.sKE.pause();
        }
        this.sPb.onPause();
        this.sPV = false;
    }

    public final void destroy() {
        if (this.nuR != null) {
            w.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.nuR.anN();
            this.nuR.destroy();
            this.nuR = null;
        }
        if (this.sKE != null) {
            this.sKE.reset();
            this.sKI = false;
        }
        if (this.sPb != null) {
            this.sPb.release();
        }
        if (this.sPa != null) {
            this.sPa.sPo = null;
            this.sPa.sQC = null;
            this.sPa.hide();
        }
        w.d("MicroMsg.ChatFooter", "jacks destory");
    }

    public final void bFo() {
        if (this.sOQ != null) {
            this.sOQ.bFe();
        }
    }

    private void fy(boolean z) {
        if (this.sPs == null) {
            this.sPs = AnimationUtils.loadAnimation(getContext(), R.a.aRm);
            this.sPs.setDuration(150);
        }
        if (this.sPt == null) {
            this.sPt = AnimationUtils.loadAnimation(getContext(), R.a.aRn);
            this.sPt.setDuration(150);
        }
        if (this.nuQ != null && this.sOW != null) {
            if (this.sPp) {
                if (this.sOW.getVisibility() != 0) {
                    this.sOW.setVisibility(0);
                }
            } else if (this.nuQ.getVisibility() != 0 || !z) {
                if (this.sOW.getVisibility() != 0 || z) {
                    if (z) {
                        this.nuQ.startAnimation(this.sPs);
                        this.nuQ.setVisibility(0);
                        this.sOW.startAnimation(this.sPt);
                        this.sOW.setVisibility(8);
                    } else {
                        this.sOW.startAnimation(this.sPs);
                        if (!this.sPf) {
                            this.sOW.setVisibility(0);
                        }
                        this.nuQ.startAnimation(this.sPt);
                        this.nuQ.setVisibility(8);
                    }
                    w.i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
                    this.nuQ.getParent().requestLayout();
                }
            }
        }
    }

    public final void bFp() {
        this.sPb.aJA();
        if (this.sOQ.getVisibility() != 0 || this.sOV.fXD) {
            r(2, 22, true);
            if (this.sKE != null && this.sKE.getVisibility() == 0 && this.sKI) {
                w.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.sKE.setVisibility(8);
                this.sKI = false;
                this.sKE.reset();
            }
            ao bDn = ao.bDn();
            Context context = ab.getContext();
            if (ap.zb() && context != null) {
                try {
                    String value = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
                    if (bg.mA(value) || Integer.valueOf(value).intValue() != 1) {
                        w.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e.getMessage());
                }
                if (bDn.sEv) {
                    w.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    w.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    bDn.sEv = true;
                    if (System.currentTimeMillis() - bDn.sEy < 43200000) {
                        w.d("MicroMsg.SuggestionAppListLogic", "not now");
                        bDn.sEv = false;
                    } else {
                        ap.yY();
                        bDn.sEy = com.tencent.mm.u.c.vr().yB(352275);
                        if (System.currentTimeMillis() - bDn.sEy < 43200000) {
                            w.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            bDn.sEv = false;
                        } else {
                            if (bDn.lang == null) {
                                bDn.lang = v.d(context.getSharedPreferences(ab.bIX(), 0));
                            }
                            com.tencent.mm.pluginsdk.model.app.w agVar = new ag(bDn.lang, new LinkedList());
                            an.aBG();
                            com.tencent.mm.pluginsdk.model.app.d.a(4, agVar);
                        }
                    }
                }
            }
            ao bDn2 = ao.bDn();
            Context context2 = ab.getContext();
            if (ap.zb() && context2 != null) {
                if (bDn2.sEw) {
                    w.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
                    return;
                }
                bDn2.sEw = true;
                if (System.currentTimeMillis() - bDn2.sEB < 43200000) {
                    w.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                    bDn2.sEw = false;
                    return;
                }
                ap.yY();
                bDn2.sEB = com.tencent.mm.u.c.vr().yB(352276);
                if (System.currentTimeMillis() - bDn2.sEB < 43200000) {
                    w.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                    bDn2.sEw = false;
                    return;
                }
                if (bDn2.lang == null) {
                    bDn2.lang = v.d(context2.getSharedPreferences(ab.bIX(), 0));
                }
                ao.cx(bDn2.lang, bDn2.sEA);
            }
        } else if (this.sPi == 1) {
            r(1, -1, true);
        } else {
            r(0, -1, false);
        }
    }

    public final void jB(boolean z) {
        if (this.nuP != null) {
            if (z) {
                this.nuP.requestFocus();
            } else {
                this.nuP.clearFocus();
            }
        }
    }

    public final void bFq() {
        if (e.sQl == null) {
            this.nuR = new d(this.context);
            return;
        }
        if (this.nuR != null) {
            this.nuR.destroy();
        }
        this.nuR = e.sQl.bR(this.context);
        if (this.nuR != null) {
            this.nuR.lw(ChatFooterPanel.sIC);
            if (this.nuR != null) {
                this.nuR.setVisibility(8);
            }
            if (this.nuR != null) {
                this.nuR.xk(this.sIA);
            }
            if (this.sOV != null) {
                this.sOV.addView(this.nuR, -1, -2);
            }
            if (this.nuR != null) {
                this.nuR.sIy = this.sPu;
            }
            if (this.nuR != null) {
                this.nuR.dz(this.nuP.getText().length() > 0);
            }
            if (this.nuR != null) {
                this.nuR.uF(this.kVa);
                this.nuR.lv(bFT());
                if (!bg.mA(this.nuP.getText().toString())) {
                    this.nuR.anT();
                }
            }
            if (this.sPl) {
                anO();
            }
            b(this.sIz);
        }
    }

    public final void anO() {
        this.sPl = true;
        if (this.nuR != null) {
            this.nuR.anO();
        }
    }

    public final void b(f fVar) {
        this.sIz = fVar;
        if (this.nuR != null) {
            this.nuR.a(fVar);
        }
    }

    public final void a(j jVar) {
        this.sPa.sQC = jVar;
    }

    private void xA(int i) {
        if (this.sOT != null) {
            int i2;
            if (i == R.g.beh) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.sOT != null) {
                if (i2 != 0) {
                    this.sOT.setContentDescription(getContext().getString(R.l.dSA));
                } else {
                    this.sOT.setContentDescription(getContext().getString(R.l.dSz));
                }
            }
            this.sOT.setImageResource(i);
            this.sOT.setPadding(0, 0, 0, 0);
        }
    }

    private void bFr() {
        this.sOQ = (AppPanel) findViewById(R.h.bzn);
        this.sOQ.sNU = this.sPv;
        this.sOQ.xz(bFT());
        if (com.tencent.mm.u.o.fE(this.kVa) || com.tencent.mm.u.o.fx(this.kVa)) {
            this.sOQ.init(0);
        } else if (com.tencent.mm.u.o.eV(this.kVa)) {
            this.sOQ.init(4);
        } else if (com.tencent.mm.u.o.dH(this.kVa)) {
            this.sOQ.init(2);
        } else {
            this.sOQ.init(1);
        }
    }

    public final void bFs() {
        this.sPi = 1;
        this.sOU.setVisibility(0);
        this.sOS.setVisibility(8);
        xA(R.g.beh);
        if (this.sKE != null) {
            this.sKE.setVisibility(8);
            this.sKI = false;
            this.sKE.reset();
        }
        r(2, 21, true);
    }

    public final void bEx() {
        if (this.sKI) {
            View findViewById = findViewById(R.h.bAv);
            this.sKI = false;
            if (this.sKE != null) {
                this.sKE.destory();
                this.sKE.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.nuP.setVisibility(0);
            this.nuP.setText("");
            jB(true);
            bFJ();
            r(0, -1, false);
        }
    }

    public final void MW(String str) {
        this.sPd.sQc = str;
    }

    public final void MX(String str) {
        this.sPd.sQb = str;
    }

    public final void X(String str, String str2, String str3) {
        LinkedList linkedList;
        if (this.sPd.sQe.containsKey(str)) {
            linkedList = (LinkedList) this.sPd.sQe.get(str);
        } else {
            linkedList = new LinkedList();
            this.sPd.sQe.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
    }

    public final void xB(int i) {
        this.sPd.sQd = i;
    }

    public final HashMap<String, String> em(String str, String str2) {
        w.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] :%s :%s", str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (bg.mA(str2)) {
            if (this.sPd.sQe.containsKey(str)) {
                this.sPd.sQe.remove(str);
            }
            return null;
        } else if (!this.sPd.sQe.containsKey(str) || ((LinkedList) this.sPd.sQe.get(str)).size() <= 0) {
            return null;
        } else {
            List<String> linkedList = new LinkedList();
            int i = 0;
            while (i < str2.length()) {
                i = str2.indexOf("@", i);
                if (i == -1) {
                    break;
                }
                int indexOf = str2.indexOf(8197, i);
                if (indexOf == -1 || indexOf - i > 40) {
                    break;
                }
                linkedList.add(str2.substring(i + 1, indexOf));
                i = indexOf + 1;
            }
            w.i("MicroMsg.ChatFooter", "after split @ :%s", linkedList);
            if (linkedList.size() <= 0) {
                ((LinkedList) this.sPd.sQe.get(str)).clear();
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.sPd.sQe.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                w.w("MicroMsg.ChatFooter", "list is null or size 0");
                return null;
            }
            w.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", Integer.valueOf(linkedList2.size()));
            List linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = (HashMap) it.next();
                    if (hashMap.containsKey(str3)) {
                        linkedList3.add(hashMap.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap2 = new HashMap(1);
            w.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", Integer.valueOf(linkedList3.size()));
            hashMap2.put("atuserlist", "<![CDATA[" + bg.c(linkedList3, ",") + "]]>");
            linkedList2.clear();
            w.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return hashMap2;
        }
    }

    public final void MY(String str) {
        p(str, -1, true);
    }

    public final void p(String str, int i, boolean z) {
        if (z && (str == null || str.length() == 0 || this.nuP == null)) {
            this.nuP.setText("");
            return;
        }
        this.sPe = true;
        this.nuP.setText(com.tencent.mm.pluginsdk.ui.d.h.b(getContext(), str, this.nuP.getTextSize()));
        this.sPe = false;
        if (i < 0 || i > this.nuP.getText().length()) {
            this.nuP.setSelection(this.nuP.getText().length());
        } else {
            this.nuP.setSelection(i);
        }
    }

    public final void bFt() {
        this.sOS.setEnabled(false);
        this.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), R.g.biY));
        if (this.qZb != null) {
            this.lNH.setVisibility(0);
            this.lNG.setVisibility(8);
            this.qZe.setVisibility(8);
            this.qZb.update();
        }
        this.jYX.sendEmptyMessageDelayed(0, 500);
    }

    public final String bFu() {
        return this.nuP == null ? "" : this.nuP.getText().toString();
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        this.sPw = new e(this, textWatcher);
        this.nuP.addTextChangedListener(this.sPw);
    }

    public final void xC(int i) {
        this.sPx = 0;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), 180);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 50.0f);
        if (i + a < fromDPToPix) {
            this.sPx = -1;
        } else {
            this.sPx = ((i - fromDPToPix) / 2) + a;
        }
        if (this.qZb == null) {
            this.qZb = new o(View.inflate(getContext(), R.i.dpH, null), -1, -2);
            this.jYG = (ImageView) this.qZb.getContentView().findViewById(R.h.cNm);
            this.lNI = this.qZb.getContentView().findViewById(R.h.cNn);
            this.lNJ = this.qZb.getContentView().findViewById(R.h.cNp);
            this.qZc = (TextView) this.qZb.getContentView().findViewById(R.h.cNr);
            this.qZd = (ImageView) this.qZb.getContentView().findViewById(R.h.cNq);
            this.qZe = this.qZb.getContentView().findViewById(R.h.cNs);
            this.lNG = this.qZb.getContentView().findViewById(R.h.cNt);
            this.lNH = this.qZb.getContentView().findViewById(R.h.cNu);
            this.sPg = (TextView) this.qZb.getContentView().findViewById(R.h.cNw);
        }
        if (this.sPx != -1) {
            this.lNH.setVisibility(8);
            this.lNG.setVisibility(8);
            this.qZe.setVisibility(0);
            this.qZb.showAtLocation(this, 49, 0, this.sPx);
        }
    }

    public final void MZ(String str) {
        if (str != null && this.sPg != null) {
            this.sPg.setText(str);
        }
    }

    public final void bFv() {
        this.qZe.setVisibility(8);
        this.lNG.setVisibility(0);
    }

    public final void auL() {
        post(new Runnable(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void run() {
                if (this.sPX.qZb != null) {
                    this.sPX.qZb.dismiss();
                    this.sPX.lNG.setVisibility(0);
                    this.sPX.qZe.setVisibility(8);
                    this.sPX.lNH.setVisibility(8);
                    this.sPX.lNJ.setVisibility(8);
                    this.sPX.lNI.setVisibility(0);
                }
                this.sPX.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.sPX.getContext(), R.g.biZ));
                this.sPX.sOS.setText(R.l.dSW);
                this.sPX.sPj = false;
                this.sPX.jYO = false;
            }
        });
    }

    public final void xD(int i) {
        int i2 = 0;
        while (i2 < jYy.length) {
            if (i >= jYx[i2] && i < jYx[i2 + 1]) {
                this.jYG.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), jYy[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.qZb != null) {
            this.qZb.dismiss();
            this.qZe.setVisibility(0);
            this.lNG.setVisibility(8);
            this.lNH.setVisibility(8);
        }
    }

    private void xE(int i) {
        this.sPi = i;
        switch (i) {
            case 1:
                this.sOU.setVisibility(0);
                this.sOS.setVisibility(8);
                xA(R.g.beh);
                return;
            case 2:
                this.sOU.setVisibility(8);
                this.sOS.setVisibility(0);
                xA(R.g.beg);
                if (m.yt().booleanValue() && this.sPm != null) {
                    this.sPm.b(Boolean.valueOf(true), Boolean.valueOf(true));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void ab(int i, boolean z) {
        boolean z2 = true;
        xE(i);
        switch (i) {
            case 1:
                jB(true);
                bFU();
                if (z) {
                    r(1, -1, true);
                    if (this.nuP.length() <= 0) {
                        z2 = false;
                    }
                    fy(z2);
                    return;
                }
                fy(false);
                return;
            case 2:
                r(0, -1, false);
                fy(false);
                return;
            default:
                setVisibility(0);
                return;
        }
    }

    public final void jC(boolean z) {
        if (this.nuR != null) {
            this.nuR.k(z, false);
        }
    }

    public final void bFw() {
        this.sOU.setVisibility(0);
        this.sOT.setVisibility(8);
        this.sOS.setVisibility(8);
    }

    public final void bFx() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOr.value = false;
        appPanel.bFg();
    }

    public final void bFy() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOJ.value = false;
        appPanel.bFg();
    }

    public final void bFz() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOs.value = false;
        appPanel.bFg();
    }

    public final void bFA() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOu.value = false;
        appPanel.bFg();
    }

    public final void bFB() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOv.value = false;
        appPanel.bFg();
    }

    public final void bFC() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOI.value = false;
        appPanel.bFg();
    }

    public final void bFD() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOw.value = false;
        appPanel.bFg();
        w.d("MicroMsg.AppPanel", "enable false" + " isVoipPluginEnable " + appPanel.sNX.sOx.value);
        this.sOQ.jw(true);
    }

    public final void jD(boolean z) {
        AppPanel appPanel = this.sOQ;
        boolean z2 = !z;
        appPanel.sNX.sOL.value = z2;
        appPanel.bFg();
        w.d("MicroMsg.AppPanel", "enable " + appPanel.sNX.sOL.value + " isMultiTalkEnable " + z2);
    }

    public final void jE(boolean z) {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOE.value = !z;
        appPanel.bFg();
    }

    public final void bFE() {
        AppPanel appPanel = this.sOQ;
        appPanel.sOf = true;
        appPanel.sNX.jz(false);
        appPanel.bFg();
    }

    public final void bFF() {
        AppPanel appPanel = this.sOQ;
        appPanel.sOg = true;
        appPanel.sNX.jy(false);
        appPanel.bFg();
    }

    public final void bFG() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOB.value = false;
        appPanel.bFg();
        w.d("MicroMsg.AppPanel", new StringBuilder("disableTalkroom enable false").toString());
    }

    public final void bFH() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOG.value = false;
        appPanel.bFg();
    }

    public final void bFI() {
        AppPanel appPanel = this.sOQ;
        appPanel.sNX.sOA.value = false;
        appPanel.bFg();
    }

    public final void bFJ() {
        this.sOX = (ImageButton) this.lmQ.findViewById(R.h.bBv);
        this.sOX.setVisibility(0);
        this.sOX.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter sPX;

            {
                this.sPX = r1;
            }

            public final void onClick(View view) {
                this.sPX.sPb.aJz();
                if (this.sPX.sOV.fXD || this.sPX.nuR == null || this.sPX.nuR.getVisibility() != 0) {
                    if (this.sPX.sPf) {
                        this.sPX.anO();
                    }
                    this.sPX.bFs();
                    if (!bg.mA(this.sPX.nuP.getText().toString())) {
                        this.sPX.nuR.anT();
                        return;
                    }
                    return;
                }
                this.sPX.r(1, -1, true);
            }
        });
        if (this.sPa != null) {
            this.sPa.sQB = this.sOX;
        }
    }

    public final void bFK() {
        if (this.sOX != null) {
            this.sOX.setVisibility(8);
        }
    }

    public final void bFL() {
        AppPanel appPanel = this.sOQ;
        appPanel.sOh = true;
        appPanel.sNX.jA(false);
        appPanel.bFg();
    }

    public final void bFM() {
        w.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.sPk = true;
        this.nuP.setImeOptions(4);
        this.nuP.setInputType(this.nuP.getInputType() & -65);
    }

    public final void bFN() {
        if (this.nuR != null) {
            this.nuR.refresh();
        }
    }

    public final void bFO() {
        this.sOQ.refresh();
    }

    public final boolean bFP() {
        return this.sOV.getVisibility() == 0;
    }

    @TargetApi(11)
    public final void a(OnDragListener onDragListener) {
        this.nuP.setOnDragListener(onDragListener);
    }

    public final void a(com.tencent.mm.pluginsdk.ui.chat.AppPanel.a aVar) {
        this.sOQ.sNT = aVar;
    }

    public static void bFQ() {
    }

    public final void a(d dVar) {
        this.sPc = dVar;
        if (dVar != null) {
            View findViewById = findViewById(R.h.bBa);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ ChatFooter sPX;

                {
                    this.sPX = r1;
                }

                public final void onClick(View view) {
                    if (this.sPX.sPc != null) {
                        this.sPX.sPc.jH(false);
                    }
                }
            });
        }
    }

    public final void xF(int i) {
        if (i != this.sPz) {
            this.sPz = i;
            ImageView imageView = (ImageView) findViewById(R.h.cGS);
            ImageView imageView2 = (ImageView) findViewById(R.h.cpx);
            if (this.sPz == 1) {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                return;
            }
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        }
    }

    @TargetApi(11)
    public final void jF(final boolean z) {
        if (f.eo(11)) {
            com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a(this) {
                final /* synthetic */ ChatFooter sPX;

                public final void run() {
                    Message message = new Message();
                    message.what = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                    message.obj = Boolean.valueOf(z);
                    this.sPX.mHandler.sendMessage(message);
                }
            });
        } else if (z) {
            this.nuP.setTextColor(getResources().getColor(R.e.aUZ));
        } else {
            this.nuP.setTextColor(getResources().getColor(R.e.aUk));
            jB(false);
        }
    }

    public final void bFR() {
        r(2, 20, false);
    }

    public final void r(int i, int i2, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.sOW.setContentDescription(getContext().getString(R.l.dSy));
            switch (i) {
                case 0:
                    bg.cX(this);
                    jB(false);
                    if (!this.sKI) {
                        bFU();
                        break;
                    }
                    break;
                case 1:
                    bg.cX(this);
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    bEx();
                                    bFU();
                                    break;
                                }
                            } else if (this.nuR != null) {
                                this.nuR.setVisibility(8);
                                break;
                            }
                        }
                        this.sOQ.setVisibility(8);
                        break;
                    } else if (!this.sKI) {
                        bFU();
                        break;
                    } else {
                        bg.cX(this);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (m.yt().booleanValue() && this.sPm != null) {
            this.sPm.a(Boolean.valueOf(true), Boolean.valueOf(false));
            this.sPm.b(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        this.sOW.setContentDescription(getContext().getString(R.l.dSx));
        switch (i) {
            case 1:
                this.sOV.fXD = true;
                jB(true);
                jF(true);
                this.sPh.showSoftInput(this.nuP, 0);
                break;
            case 2:
                if (i2 == 22) {
                    if (this.sOQ == null) {
                        bFr();
                    }
                    this.sOQ.bFk();
                    if (this.nuR != null) {
                        this.nuR.setVisibility(8);
                    }
                    this.sOQ.setVisibility(0);
                    i iVar = this.sOZ;
                    ap.vL().D(new com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass3(iVar, new com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass2(iVar, iVar.context.getMainLooper())));
                    jB(false);
                    if (this.sPi == 2) {
                        xE(1);
                    }
                } else if (i2 == 21) {
                    if (this.sOQ != null) {
                        this.sOQ.setVisibility(8);
                    }
                    if (this.nuR == null) {
                        bFq();
                    }
                    if (this.nuR != null) {
                        this.nuR.setVisibility(0);
                    }
                    jG(true);
                    jB(true);
                }
                this.sOV.setVisibility(0);
                if (!(bFS() && j.aF(getContext()))) {
                    ViewGroup.LayoutParams layoutParams = this.sOV.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = j.aD(getContext());
                        this.sOV.setLayoutParams(layoutParams);
                    }
                }
                bg.cX(this);
                break;
            case 3:
                this.sOV.fXD = true;
                jB(true);
                jF(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.sOX == null) && (this.sOX == null || z || (i2 != 21 && i2 != 20)))) {
            jG(false);
        }
        if (i == 0 && !z) {
            jG(false);
        } else if (z && i2 != 22) {
            if (this.nuP.length() <= 0) {
                z2 = false;
            }
            fy(z2);
        }
    }

    private boolean bFS() {
        return this.sPK > 0 && this.sPK < this.sPL;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
        if (getTop() != 0) {
            if (getTop() > this.sPJ) {
                this.sPJ = getTop();
            }
            if (this.sPJ - getTop() > 50) {
                if (this.sPb != null) {
                    this.sPb.fA(true);
                }
            } else if (this.sPb != null) {
                this.sPb.fA(false);
            }
        }
        if (z && this.sPa != null) {
            l lVar = this.sPa;
            if (lVar.sQA.isShowing()) {
                lVar.sQA.dismiss();
                lVar.bGd();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        w.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i, i2);
        w.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
    }

    public final int bFT() {
        return j.c(getContext(), true);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private void jG(boolean z) {
        if (this.sOX != null) {
            if (!this.sPM || !z) {
                if (this.sPM || z) {
                    this.sPM = z;
                    if (z) {
                        this.sOX.setImageDrawable(getContext().getResources().getDrawable(R.g.beg));
                    } else {
                        this.sOX.setImageDrawable(getContext().getResources().getDrawable(R.g.bef));
                    }
                }
            }
        }
    }

    public final void bFU() {
        this.sOV.setVisibility(8);
        this.sOQ.setVisibility(8);
        if (this.nuR != null) {
            this.nuR.setVisibility(8);
        }
        jG(false);
    }

    public final void xG(int i) {
        j.sg();
        int p = j.p(this.context, i);
        this.sPI = p;
        if (p > 0 && this.sOV != null) {
            w.d("MicroMsg.ChatFooter", "set bottom panel height: %d", Integer.valueOf(p));
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.height = p;
            this.sOV.setLayoutParams(layoutParams);
        }
        if (this.sOQ != null) {
            this.sOQ.xz(p);
            AppPanel appPanel = this.sOQ;
            appPanel.bFk();
            appPanel.anM();
        }
        if (this.sKE != null) {
            this.sKE.xJ(p);
            this.sKE.bFk();
        }
        if (this.nuR != null) {
            if (!bFS()) {
                bFN();
            }
            this.nuR.lv(p);
            this.nuR.anS();
        }
    }

    public final void bFV() {
        this.jYO = false;
        this.sOS.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), R.g.biZ));
        this.sOS.setText(R.l.dSW);
        if (this.sPb == null) {
            return;
        }
        if (this.lNJ == null || this.lNJ.getVisibility() != 0) {
            this.sPb.aJv();
        } else {
            this.sPb.aJx();
        }
    }

    public final boolean bFW() {
        return this.sPJ - getTop() > 50;
    }

    public final void Na(String str) {
        this.kVa = str;
        if (this.nuR != null) {
            this.nuR.uF(this.kVa);
        }
        if (this.sOQ == null) {
            return;
        }
        if (com.tencent.mm.u.o.fE(this.kVa) || com.tencent.mm.u.o.fx(this.kVa)) {
            this.sOQ.sOa = 0;
        } else if (com.tencent.mm.u.o.eV(this.kVa)) {
            this.sOQ.sOa = 4;
        } else if (com.tencent.mm.u.o.dH(this.kVa)) {
            this.sOQ.sOa = 2;
        } else {
            this.sOQ.sOa = 1;
        }
    }

    public final void bFX() {
        ap.yY();
        this.sPp = ((Boolean) com.tencent.mm.u.c.vr().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public final void xH(int i) {
        this.sPU = null;
        this.sPT = i;
    }

    public void onGlobalLayout() {
        if (this.activity != null && this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null) {
            if (this.sPT == -1) {
                w.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
                return;
            }
            if (this.sPU == null) {
                this.sPU = this.activity.getWindow().getDecorView().findViewById(this.sPT);
            }
            if (this.sPU == null) {
                w.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", Integer.valueOf(this.sPT));
                return;
            }
            int height = this.sPU.getHeight();
            int width = this.sPU.getWidth();
            w.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", Integer.valueOf(this.sPU.getMeasuredHeight()), Integer.valueOf(height));
            if (this.sPL < height) {
                this.sPL = height;
            }
            this.sPK = height;
            if (this.sPR <= 0) {
                this.sPR = height;
            } else if (this.sPS <= 0) {
                this.sPS = width;
            } else if (this.sPR != height || this.sPS != width) {
                if (bFS() && this.sPr) {
                    this.sPr = false;
                    w.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new Runnable(this) {
                        final /* synthetic */ ChatFooter sPX;

                        {
                            this.sPX = r1;
                        }

                        public final void run() {
                            this.sPX.bFR();
                        }
                    }, 10);
                }
                w.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", Integer.valueOf(this.sPR), Integer.valueOf(height));
                int abs = Math.abs(this.sPR - height);
                this.sPR = height;
                height = Math.abs(this.sPS - width);
                this.sPS = width;
                w.d("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", Integer.valueOf(height));
                if (this.sPV) {
                    if (abs == 0) {
                        if (this.sOQ != null) {
                            this.sOQ.sOn = true;
                            this.sOQ.anM();
                        }
                        if (this.nuR != null) {
                            this.nuR.lv(j.aD(this.context));
                            bFN();
                            this.nuR.anS();
                        }
                    } else if (j.aF(this.context)) {
                        w.d("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d", Integer.valueOf(this.sPI));
                        if (this.sPI != abs || abs == -1) {
                            height = j.aD(this.context);
                            w.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", Integer.valueOf(height));
                            if (abs >= j.aC(this.context) && abs <= j.aB(this.context)) {
                                height = abs;
                            }
                            if (this.sPy) {
                                this.sPy = false;
                                if (height < this.sPI) {
                                    height = this.sPI;
                                }
                                this.sPI = height;
                                xG(height);
                            } else {
                                this.sPI = height;
                                w.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", Integer.valueOf(this.sPI));
                                j.o(getContext(), height);
                                xG(height);
                            }
                        }
                    } else {
                        return;
                    }
                }
                w.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + abs);
            }
        }
    }

    public final int bFY() {
        int aD = j.aD(getContext());
        int height = getHeight();
        return height < aD ? height + aD : height;
    }
}

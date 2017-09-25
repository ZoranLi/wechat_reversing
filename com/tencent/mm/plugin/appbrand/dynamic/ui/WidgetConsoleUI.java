package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WidgetConsoleUI extends MMActivity implements com.tencent.mm.modelappbrand.i.a {
    String appId;
    int fKL;
    EditText iII;
    Button[] iIJ;
    Button iIK;
    Button iIL;
    MRecyclerView iIM;
    a iIN;
    int iIO;
    String iIP;
    final List<LogInfo> iIQ = new LinkedList();
    String id;
    int izW;

    private static class a extends android.support.v7.widget.RecyclerView.a {
        public static final SimpleDateFormat iIU = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        LayoutInflater Du;
        List<LogInfo> iIQ = new LinkedList();

        private static class a extends t {
            TextView iIV;
            TextView iuD;

            public a(View view, int i) {
                super(view);
                this.iIV = (TextView) view.findViewById(R.h.cbb);
                this.iuD = (TextView) view.findViewById(R.h.bGD);
                switch (i) {
                    case 1:
                        this.iIV.setText("L");
                        this.iuD.setTextColor(-7829368);
                        return;
                    case 2:
                        this.iIV.setText("I");
                        this.iuD.setTextColor(WebView.NIGHT_MODE_COLOR);
                        return;
                    case 3:
                        this.iIV.setText("W");
                        this.iuD.setTextColor(Color.rgb(0, 0, ao.CTRL_INDEX));
                        return;
                    case 4:
                        this.iIV.setText("E");
                        this.iuD.setTextColor(-65536);
                        return;
                    default:
                        this.iIV.setText("L");
                        this.iuD.setTextColor(-7829368);
                        return;
                }
            }
        }

        a(Context context) {
            this.Du = LayoutInflater.from(context);
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new a(this.Du.inflate(R.i.cZs, viewGroup, false), i);
        }

        public final void a(t tVar, int i) {
            LogInfo logInfo = (LogInfo) this.iIQ.get(i);
            ((a) tVar).iuD.setText(String.format("[%s] %s", new Object[]{iIU.format(new Date(logInfo.hpU)), logInfo.message}));
        }

        public final int getItemCount() {
            return this.iIQ.size();
        }

        public final int getItemViewType(int i) {
            return ((LogInfo) this.iIQ.get(i)).level;
        }
    }

    static /* synthetic */ void a(WidgetConsoleUI widgetConsoleUI) {
        widgetConsoleUI.iIN.iIQ.clear();
        for (int i = 0; i < widgetConsoleUI.iIQ.size(); i++) {
            LogInfo logInfo = (LogInfo) widgetConsoleUI.iIQ.get(i);
            if ((widgetConsoleUI.iIO <= 0 || logInfo.level == widgetConsoleUI.iIO) && !widgetConsoleUI.oU(logInfo.message)) {
                widgetConsoleUI.iIN.iIQ.add(logInfo);
            }
        }
        widgetConsoleUI.iIN.aab.notifyChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (So()) {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.iIR.finish();
                    return false;
                }
            });
            zi(R.l.fob);
            this.iII = (EditText) findViewById(R.h.bEL);
            this.iII.clearFocus();
            this.iIJ = new Button[5];
            bm(0, R.h.cct);
            bm(1, R.h.ccw);
            bm(2, R.h.ccv);
            bm(3, R.h.ccy);
            bm(4, R.h.ccu);
            this.iIJ[0].setSelected(true);
            this.iIO = 0;
            this.iIK = (Button) findViewById(R.h.bCv);
            this.iIL = (Button) findViewById(R.h.czC);
            this.iIL.setEnabled(false);
            this.iIK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final void onClick(View view) {
                    this.iIR.iIQ.clear();
                    this.iIR.iIN.iIQ.clear();
                    this.iIR.iIN.aab.notifyChanged();
                }
            });
            this.iIL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final void onClick(View view) {
                }
            });
            this.iII.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
            this.iII.setOnKeyListener(new OnKeyListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i != 66) {
                        return false;
                    }
                    this.iIR.iIP = this.iIR.iII.getText().toString();
                    WidgetConsoleUI.a(this.iIR);
                    this.iIR.cY(view);
                    return true;
                }
            });
            this.iII.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (!z) {
                        this.iIR.cY(view);
                    }
                }
            });
            findViewById(R.h.bJU).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final void onClick(View view) {
                    this.iIR.iIP = this.iIR.iII.getText().toString();
                    WidgetConsoleUI.a(this.iIR);
                }
            });
            this.uSU.ipu.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ WidgetConsoleUI iIR;

                {
                    this.iIR = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.iIR.cY(view);
                    return false;
                }
            });
            this.iIM = (MRecyclerView) findViewById(R.h.ccx);
            this.iIN = new a(this);
            this.iIM.a(new LinearLayoutManager());
            this.iIM.a(null);
            this.iIM.a(this.iIN);
            ((e) h.h(e.class)).AN().a(this.id, this);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!So()) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r0 = 1;
        r1 = 0;
        r2 = r9.getAction();
        if (r2 != 0) goto L_0x0052;
    L_0x0008:
        r2 = r8.getCurrentFocus();
        if (r2 == 0) goto L_0x0057;
    L_0x000e:
        r3 = r2 instanceof android.widget.EditText;
        if (r3 == 0) goto L_0x0057;
    L_0x0012:
        r3 = 2;
        r3 = new int[r3];
        r3 = {0, 0};
        r2.getLocationInWindow(r3);
        r4 = r3[r1];
        r3 = r3[r0];
        r5 = r2.getHeight();
        r5 = r5 + r3;
        r6 = r2.getWidth();
        r6 = r6 + r4;
        r7 = r9.getX();
        r4 = (float) r4;
        r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004d;
    L_0x0032:
        r4 = r9.getX();
        r6 = (float) r6;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x004d;
    L_0x003b:
        r4 = r9.getY();
        r3 = (float) r3;
        r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x004d;
    L_0x0044:
        r3 = r9.getY();
        r4 = (float) r5;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 < 0) goto L_0x0057;
    L_0x004d:
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r8.cY(r2);
    L_0x0052:
        r0 = super.dispatchTouchEvent(r9);
        return r0;
    L_0x0057:
        r0 = r1;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean So() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fKL = intent.getIntExtra("pkg_type", 0);
        this.izW = intent.getIntExtra("pkg_version", 0);
        SE(String.format("(%s)", new Object[]{stringExtra}));
        if (bg.mA(stringExtra)) {
            finish();
            return false;
        } else if (stringExtra.equals(this.id)) {
            return true;
        } else {
            this.id = stringExtra;
            ((e) h.h(e.class)).AN().b(this.id, this);
            ((e) h.h(e.class)).AN().a(stringExtra, this);
            return true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ((e) h.h(e.class)).AN().b(this.id, this);
    }

    public void finish() {
        if (!isFinishing() && !this.uSW) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    private void bm(int i, int i2) {
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WidgetConsoleUI iIR;

            {
                this.iIR = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                while (i < this.iIR.iIJ.length) {
                    boolean z;
                    View view2 = this.iIR.iIJ[i];
                    if (view2 == view) {
                        z = true;
                    } else {
                        z = false;
                    }
                    view2.setSelected(z);
                    if (z && this.iIR.iIO != i) {
                        this.iIR.iIO = i;
                        WidgetConsoleUI.a(this.iIR);
                    }
                    i++;
                }
            }
        });
        this.iIJ[i] = button;
    }

    protected final int getLayoutId() {
        return R.i.drZ;
    }

    public final void fq(int i) {
        String str;
        switch (i) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ WidgetConsoleUI iIR;

            public final void run() {
                this.iIR.qP(String.format("%s%s", new Object[]{this.iIR.getString(R.l.fob), str}));
                Toast.makeText(this.iIR, String.format("%s%s", new Object[]{this.iIR.id, str}), 1).show();
            }
        });
    }

    public final void y(List<LogInfo> list) {
        if (list != null) {
            final List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                LogInfo logInfo = (LogInfo) list.get(i);
                this.iIQ.add(logInfo);
                if ((logInfo.level == this.iIO || this.iIO == 0) && !oU(logInfo.message)) {
                    linkedList.add(logInfo);
                }
            }
            if (!linkedList.isEmpty()) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ WidgetConsoleUI iIR;

                    public final void run() {
                        int itemCount = this.iIR.iIN.getItemCount();
                        this.iIR.iIN.iIQ.addAll(linkedList);
                        this.iIR.iIN.R(itemCount, linkedList.size());
                        if (((LinearLayoutManager) this.iIR.iIM.Zf).fb() == itemCount - 1) {
                            this.iIR.iIM.smoothScrollToPosition(this.iIR.iIN.getItemCount() - 1);
                        }
                    }
                });
            }
        }
    }

    private boolean oU(String str) {
        return !bg.mA(this.iIP) && (str == null || !str.toLowerCase().contains(this.iIP.toLowerCase()));
    }
}

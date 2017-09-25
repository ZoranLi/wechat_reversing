package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class a {
    public ListAdapter FA;
    public int FB = -1;
    int FC;
    int FD;
    public int FE;
    public int FF;
    public int FG;
    public int FH;
    int FI = 0;
    final OnClickListener FJ = new OnClickListener(this) {
        final /* synthetic */ a FK;

        {
            this.FK = r1;
        }

        public final void onClick(View view) {
            Message obtain;
            if (view == this.FK.Fn && this.FK.Fp != null) {
                obtain = Message.obtain(this.FK.Fp);
            } else if (view == this.FK.Fq && this.FK.Fs != null) {
                obtain = Message.obtain(this.FK.Fs);
            } else if (view != this.FK.Ft || this.FK.Fv == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.FK.Fv);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.FK.mHandler.obtainMessage(1, this.FK.Fd).sendToTarget();
        }
    };
    public final i Fd;
    final Window Fe;
    public CharSequence Ff;
    public ListView Fg;
    public int Fh;
    public int Fi;
    public int Fj;
    public int Fk;
    public int Fl;
    public boolean Fm = false;
    public Button Fn;
    CharSequence Fo;
    public Message Fp;
    public Button Fq;
    CharSequence Fr;
    public Message Fs;
    public Button Ft;
    CharSequence Fu;
    public Message Fv;
    public NestedScrollView Fw;
    public int Fx = 0;
    TextView Fy;
    public View Fz;
    public Drawable jQ;
    public TextView jq;
    public ImageView kI;
    public final Context mContext;
    public Handler mHandler;
    public View mView;
    CharSequence uI;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a FK;
        final /* synthetic */ View FL;
        final /* synthetic */ View FM;

        AnonymousClass3(a aVar, View view, View view2) {
            this.FK = aVar;
            this.FL = view;
            this.FM = view2;
        }

        public final void run() {
            a.a(this.FK.Fw, this.FL, this.FM);
        }
    }

    class AnonymousClass4 implements OnScrollListener {
        final /* synthetic */ a FK;
        final /* synthetic */ View FL;
        final /* synthetic */ View FM;

        AnonymousClass4(a aVar, View view, View view2) {
            this.FK = aVar;
            this.FL = view;
            this.FM = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            a.a(absListView, this.FL, this.FM);
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ a FK;
        final /* synthetic */ View FL;
        final /* synthetic */ View FM;

        AnonymousClass5(a aVar, View view, View view2) {
            this.FK = aVar;
            this.FL = view;
            this.FM = view2;
        }

        public final void run() {
            a.a(this.FK.Fg, this.FL, this.FM);
        }
    }

    public static class a {
        public Cursor Bo;
        public final LayoutInflater Du;
        public ListAdapter FA;
        public int FB = -1;
        public int FN = 0;
        public CharSequence FO;
        public DialogInterface.OnClickListener FP;
        public CharSequence FQ;
        public DialogInterface.OnClickListener FR;
        public CharSequence FS;
        public DialogInterface.OnClickListener FT;
        public OnCancelListener FU;
        public OnDismissListener FV;
        public OnKeyListener FW;
        public CharSequence[] FX;
        public DialogInterface.OnClickListener FY;
        public boolean[] FZ;
        public CharSequence Ff;
        public int Fh;
        public int Fi;
        public int Fj;
        public int Fk;
        public int Fl;
        public boolean Fm = false;
        public int Fx = 0;
        public View Fz;
        public boolean Ga;
        public boolean Gb;
        public OnMultiChoiceClickListener Gc;
        public String Gd;
        public String Ge;
        public OnItemSelectedListener Gf;
        public boolean Gg = true;
        public Drawable jQ;
        public final Context mContext;
        public View mView;
        public boolean oI;
        public CharSequence uI;

        class AnonymousClass1 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView Gh;
            final /* synthetic */ a Gi;

            public AnonymousClass1(a aVar, Context context, int i, CharSequence[] charSequenceArr, ListView listView) {
                this.Gi = aVar;
                this.Gh = listView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (this.Gi.FZ != null && this.Gi.FZ[i]) {
                    this.Gh.setItemChecked(i, true);
                }
                return view2;
            }
        }

        class AnonymousClass2 extends CursorAdapter {
            final /* synthetic */ ListView Gh;
            final /* synthetic */ a Gi;
            private final int Gj;
            private final int Gk;
            final /* synthetic */ a Gl;

            public AnonymousClass2(a aVar, Context context, Cursor cursor, ListView listView, a aVar2) {
                this.Gi = aVar;
                this.Gh = listView;
                this.Gl = aVar2;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.Gj = cursor2.getColumnIndexOrThrow(this.Gi.Gd);
                this.Gk = cursor2.getColumnIndexOrThrow(this.Gi.Ge);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.Gj));
                this.Gh.setItemChecked(cursor.getPosition(), cursor.getInt(this.Gk) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return this.Gi.Du.inflate(this.Gl.FF, viewGroup, false);
            }
        }

        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ a Gi;
            final /* synthetic */ a Gl;

            public AnonymousClass3(a aVar, a aVar2) {
                this.Gi = aVar;
                this.Gl = aVar2;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.Gi.FY.onClick(this.Gl.Fd, i);
                if (!this.Gi.Gb) {
                    this.Gl.Fd.dismiss();
                }
            }
        }

        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ ListView Gh;
            final /* synthetic */ a Gi;
            final /* synthetic */ a Gl;

            public AnonymousClass4(a aVar, ListView listView, a aVar2) {
                this.Gi = aVar;
                this.Gh = listView;
                this.Gl = aVar2;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.Gi.FZ != null) {
                    this.Gi.FZ[i] = this.Gh.isItemChecked(i);
                }
                this.Gi.Gc.onClick(this.Gl.Fd, i, this.Gh.isItemChecked(i));
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.oI = true;
            this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> Gm;

        public b(DialogInterface dialogInterface) {
            this.Gm = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.Gm.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    class AnonymousClass2 implements android.support.v4.widget.NestedScrollView.b {
        final /* synthetic */ a FK;
        final /* synthetic */ View FL;
        final /* synthetic */ View FM;

        AnonymousClass2(a aVar, View view, View view2) {
            this.FK = aVar;
            this.FL = view;
            this.FM = view2;
        }

        public final void b(NestedScrollView nestedScrollView) {
            a.a(nestedScrollView, this.FL, this.FM);
        }
    }

    public a(Context context, i iVar, Window window) {
        this.mContext = context;
        this.Fd = iVar;
        this.Fe = window;
        this.mHandler = new b(iVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, k.bb, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.FC = obtainStyledAttributes.getResourceId(k.Ly, 0);
        this.FD = obtainStyledAttributes.getResourceId(k.Lz, 0);
        this.FE = obtainStyledAttributes.getResourceId(k.LB, 0);
        this.FF = obtainStyledAttributes.getResourceId(k.LC, 0);
        this.FG = obtainStyledAttributes.getResourceId(k.LD, 0);
        this.FH = obtainStyledAttributes.getResourceId(k.LA, 0);
        obtainStyledAttributes.recycle();
        iVar.cZ();
    }

    static boolean aI(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (aI(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.uI = charSequence;
        if (this.Fy != null) {
            this.Fy.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.Fu = charSequence;
                this.Fv = message;
                return;
            case -2:
                this.Fr = charSequence;
                this.Fs = message;
                return;
            case -1:
                this.Fo = charSequence;
                this.Fp = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.jQ = null;
        this.Fx = i;
        if (this.kI == null) {
            return;
        }
        if (i != 0) {
            this.kI.setVisibility(0);
            this.kI.setImageResource(this.Fx);
            return;
        }
        this.kI.setVisibility(8);
    }

    static ViewGroup b(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    public static void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(z.h(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!z.h(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }
}

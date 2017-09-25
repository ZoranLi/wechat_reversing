package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern oEj = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private ae handler = new ae();
    private boolean iue = false;
    private GestureDetector oDl;
    LinkedList<i> oEd = new LinkedList();
    AutoCompleteTextView oEe;
    private b oEf;
    c oEg;
    private View oEh;
    a oEi = null;
    private SimpleOnGestureListener oEk = new SimpleOnGestureListener(this) {
        final /* synthetic */ MailAddrsViewControl oEl;

        {
            this.oEl = r1;
        }

        private void aVj() {
            i iVar = (i) this.oEl.oEh.getTag();
            if (this.oEl.oEg != null) {
                this.oEl.oEg;
                this.oEl.oEh;
            }
            Intent intent = new Intent(this.oEl.getContext(), MailAddrProfileUI.class);
            intent.putExtra("name", iVar.name);
            intent.putExtra("addr", iVar.naK);
            intent.putExtra("can_compose", !this.oEl.iue);
            this.oEl.getContext().startActivity(intent);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.oEl.iue) {
                aVj();
            }
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (this.oEl.oEg != null && this.oEl.oEh != null) {
                this.oEl.oEg;
                this.oEl.oEh;
                this.oEl.oEh.getTag();
            }
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            aVj();
            return true;
        }
    };

    public interface a {
        void aUQ();

        void b(MailAddrsViewControl mailAddrsViewControl);
    }

    public static class b extends BaseAdapter implements Filterable {
        private Context mContext;
        private final Object mLock = new Object();
        private List<i> oEo;
        private boolean oEp = true;
        private ArrayList<i> oEq;
        private a oEr;

        private class a extends Filter {
            final /* synthetic */ b oEs;

            private a(b bVar) {
                this.oEs = bVar;
            }

            protected final FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (this.oEs.oEq == null) {
                    synchronized (this.oEs.mLock) {
                        this.oEs.oEq = new ArrayList(this.oEs.oEo);
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (this.oEs.mLock) {
                        ArrayList arrayList = new ArrayList(this.oEs.oEq);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                } else {
                    CharSequence toLowerCase = charSequence.toString().toLowerCase();
                    ArrayList b = this.oEs.oEq;
                    int size = b.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        i iVar = (i) b.get(i);
                        if (iVar.name.toLowerCase().contains(toLowerCase) || iVar.naK.toLowerCase().contains(toLowerCase)) {
                            arrayList2.add(iVar);
                        }
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
                return filterResults;
            }

            protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.oEs.oEo = (List) filterResults.values;
                if (filterResults.count > 0) {
                    this.oEs.notifyDataSetChanged();
                    return;
                }
                this.oEs.oEo = new ArrayList(this.oEs.oEq);
                this.oEs.notifyDataSetInvalidated();
            }
        }

        private class b {
            TextView kzl;
            TextView oDZ;
            final /* synthetic */ b oEs;
            CheckBox oEt;

            public b(b bVar) {
                this.oEs = bVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return rF(i);
        }

        public b(Context context, List<i> list) {
            this.mContext = context;
            this.oEo = list;
        }

        public final void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            this.oEp = true;
        }

        public final int getCount() {
            return this.oEo.size();
        }

        public final i rF(int i) {
            return (i) this.oEo.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dlD, null);
                b bVar = new b(this);
                bVar.kzl = (TextView) view.findViewById(R.h.ctQ);
                bVar.oDZ = (TextView) view.findViewById(R.h.ctO);
                bVar.oEt = (CheckBox) view.findViewById(R.h.ctR);
                view.setTag(bVar);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view;
            }
            i rF = rF(i);
            b bVar2 = (b) view.getTag();
            bVar2.kzl.setText(rF.name);
            bVar2.oDZ.setText(rF.naK);
            bVar2.oEt.setVisibility(8);
            view.setBackgroundColor(-789517);
            return view;
        }

        public final Filter getFilter() {
            if (this.oEr == null) {
                this.oEr = new a();
            }
            return this.oEr;
        }
    }

    public static abstract class c {
        public void gq(boolean z) {
        }
    }

    public final boolean aVd() {
        Editable text = this.oEe.getText();
        if (text == null || text.toString().length() <= 0) {
            return true;
        }
        return false;
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oDl = new GestureDetector(context, this.oEk);
    }

    public final void aVe() {
        this.iue = true;
        if (this.oEe == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof AutoCompleteTextView)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            if (childAt2 instanceof AutoCompleteTextView) {
                                this.oEe = (AutoCompleteTextView) childAt2;
                            }
                        }
                    }
                    if (this.oEe != null) {
                        break;
                    }
                    i++;
                } else {
                    this.oEe = (AutoCompleteTextView) childAt;
                    break;
                }
            }
            if (this.oEe != null) {
                this.oEe.setDropDownBackgroundResource(R.g.biI);
                setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final void onClick(View view) {
                        this.oEl.oEe.requestFocus();
                        ((InputMethodManager) this.oEl.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                    }
                });
                this.oEe.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.oEl.e(this.oEl.oEf.rF(i));
                        this.oEl.oEe.setText("");
                    }
                });
                this.oEe.setOnEditorActionListener(new OnEditorActionListener(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == 5) {
                            String obj = this.oEl.oEe.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                this.oEl.af(obj, false);
                                this.oEl.aVi();
                            }
                        }
                        return true;
                    }
                });
                this.oEe.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        String obj;
                        if (i == 67 && keyEvent.getAction() == 0) {
                            obj = this.oEl.oEe.getEditableText().toString();
                            if (obj.length() == 0 && this.oEl.oEh != null && this.oEl.oEh.isSelected()) {
                                this.oEl.f((i) this.oEl.oEh.getTag());
                                this.oEl.oEh = null;
                                this.oEl.aVi();
                            } else if (obj.length() == 0 && this.oEl.oEd.size() > 0) {
                                int size = this.oEl.oEd.size() - 1;
                                View childAt = this.oEl.getChildAt(size);
                                if (childAt.isSelected()) {
                                    this.oEl.f((i) this.oEl.oEd.get(size));
                                    this.oEl.aVi();
                                } else {
                                    childAt.setSelected(true);
                                }
                            }
                        } else if (i == 66 && keyEvent.getAction() == 0) {
                            obj = this.oEl.oEe.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                this.oEl.af(obj, true);
                                this.oEl.aVi();
                            }
                        }
                        return false;
                    }
                });
                this.oEe.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.endsWith("\n") || charSequence2.endsWith(" ")) {
                            this.oEl.af(charSequence2, true);
                        }
                        this.oEl.aVi();
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                this.oEe.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    {
                        this.oEl = r1;
                    }

                    public final void onFocusChange(View view, boolean z) {
                        if (this.oEl.oEg != null) {
                            this.oEl.oEg.gq(z);
                        }
                        String obj = this.oEl.oEe.getEditableText().toString();
                        if (!z && obj.trim().length() > 0) {
                            this.oEl.af(obj, false);
                        }
                        if (this.oEl.oEh != null && this.oEl.oEh.isSelected()) {
                            this.oEl.oEh.setSelected(z);
                            this.oEl.oEh = null;
                        }
                        this.oEl.aVi();
                    }
                });
            }
        }
    }

    public final void a(b bVar) {
        if (this.oEe != null) {
            this.oEf = bVar;
            this.oEe.setAdapter(bVar);
        }
    }

    public final String[] a(boolean z, d dVar) {
        int i = 0;
        String userBindEmail;
        if (dVar == null || !dVar.isConnected()) {
            userBindEmail = m.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(dVar, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                w.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        String[] strArr = new String[this.oEd.size()];
        while (i < this.oEd.size()) {
            i iVar = (i) this.oEd.get(i);
            if (z && iVar.naK.equalsIgnoreCase(r1)) {
                strArr[i] = "";
            } else {
                strArr[i] = iVar.name + " " + iVar.naK;
            }
            i++;
        }
        return strArr;
    }

    public final boolean aVf() {
        String trim = this.oEe.getEditableText().toString().trim();
        return !bg.mA(trim) && CZ(trim);
    }

    public final String aVg() {
        if (aVf()) {
            af(this.oEe.getEditableText().toString(), false);
        }
        String str = "";
        for (int i = 0; i < this.oEd.size(); i++) {
            i iVar = (i) this.oEd.get(i);
            if (i != 0) {
                str = str + ",";
            }
            str = str + iVar.naK;
        }
        return str;
    }

    public final void e(i iVar) {
        if (iVar != null) {
            Object obj;
            Iterator it = this.oEd.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).naK.equalsIgnoreCase(iVar.naK)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.i.dlB, null);
                final Button button = (Button) viewGroup.findViewById(R.h.cuo);
                viewGroup.removeView((View) button.getParent());
                button.setText(iVar.name);
                if (this.iue) {
                    button.setCompoundDrawables(null, null, null, null);
                }
                button.setTag(this.oEd.size());
                View view = (View) button.getParent();
                button.setTag(iVar);
                view.setVisibility(4);
                view.setTag(iVar);
                addView(view, this.oEd.size());
                this.oEd.add(iVar);
                this.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ MailAddrsViewControl oEl;

                    public final void run() {
                        button.invalidate();
                        button.setOnTouchListener(new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass2 oEn;

                            {
                                this.oEn = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                if (!(this.oEn.oEl.oEh == null || this.oEn.oEl.oEh == view || !this.oEn.oEl.oEh.isSelected())) {
                                    this.oEn.oEl.oEh.setSelected(false);
                                    this.oEn.oEl.oEh = null;
                                }
                                this.oEn.oEl.oEh = view;
                                if (this.oEn.oEl.oEe != null && motionEvent.getAction() == 0) {
                                    button.setSelected(!button.isSelected());
                                    this.oEn.oEl.oEe.setVisibility(0);
                                    this.oEn.oEl.oEe.requestFocus();
                                    ((InputMethodManager) this.oEn.oEl.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                                }
                                return this.oEn.oEl.oDl.onTouchEvent(motionEvent);
                            }
                        });
                        this.oEl.aVi();
                        this.oEl.invalidate();
                    }
                }, 100);
            }
        }
    }

    public final void a(String[] strArr, boolean z) {
        if (z) {
            removeAllViews();
            this.oEd.clear();
            aVi();
            invalidate();
        }
        if (strArr != null && strArr.length != 0) {
            for (String CQ : strArr) {
                i CQ2 = j.CQ(CQ);
                if (CQ2 != null) {
                    e(CQ2);
                }
            }
        }
    }

    public final void be(List<i> list) {
        if (list != null) {
            for (i e : list) {
                e(e);
            }
        }
    }

    public final void f(i iVar) {
        for (int i = 0; i < this.oEd.size(); i++) {
            if (iVar.naK.equalsIgnoreCase(((i) this.oEd.get(i)).naK)) {
                removeViewAt(i);
                this.oEd.remove(i);
                aVi();
                invalidate();
                return;
            }
        }
    }

    private static boolean CZ(String str) {
        return oEj.matcher(str).matches();
    }

    public final boolean aVh() {
        Iterator it = this.oEd.iterator();
        while (it.hasNext()) {
            if (!CZ(((i) it.next()).naK)) {
                return false;
            }
        }
        return true;
    }

    final void aVi() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int i4;
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                    width = childAt.getMeasuredWidth();
                }
                if (this.oEe == null || i != childCount - 1 || this.oEe.isFocused()) {
                    i4 = width;
                } else {
                    i4 = 0;
                }
                if (i3 + i4 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i4;
                childAt.setVisibility(0);
            }
            i++;
        }
    }

    private void af(String str, boolean z) {
        Object trim = str.trim();
        if (trim.length() != 0) {
            List CP = com.tencent.mm.plugin.qqmail.b.w.aUz().oAf.CP(trim);
            if (CP.size() > 0) {
                e((i) CP.get(0));
                this.oEe.setText("");
            } else if (CZ(trim)) {
                i iVar = new i();
                iVar.name = trim;
                iVar.naK = trim;
                iVar.ozI = 0;
                e(iVar);
                this.oEe.setText("");
            } else if (z) {
                if (this.oEi != null) {
                    this.oEi.aUQ();
                } else {
                    Toast.makeText(getContext(), R.l.eGB, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
                }
                this.oEe.setText(trim);
                this.oEe.setSelection(trim.length());
            } else if (this.oEi != null) {
                this.oEi.b(this);
            }
        }
    }
}

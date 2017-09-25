package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

public class h extends BaseAdapter implements f {
    private final Context context;
    private final SharedPreferences hgx;
    private a vqt;
    private final j vrD;
    private final LinkedList<String> vrE = new LinkedList();
    private final HashMap<String, Preference> vrF = new HashMap();
    private final HashSet<String> vrG = new HashSet();
    private final LinkedList<String> vrH = new LinkedList();
    private final HashMap<String, Integer> vrI = new HashMap();
    private final HashMap<String, String> vrJ = new HashMap();
    private int[] vrK = new int[0];
    private boolean vrL = false;
    private boolean vrM = false;

    public h(Context context, SharedPreferences sharedPreferences) {
        this.vrD = new j(context);
        this.context = context;
        this.hgx = sharedPreferences;
    }

    private static String d(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + "W" + preference.vsf;
    }

    private static String e(Preference preference) {
        if (preference.igL == null || preference.igL.length() <= 0) {
            return "_anonymous_pref@" + preference.hashCode();
        }
        return preference.igL;
    }

    public final int indexOf(String str) {
        return this.vrE.indexOf(str);
    }

    public final int Tf(String str) {
        if (this.vrH == null) {
            return -1;
        }
        return this.vrH.indexOf(str);
    }

    public final void a(Preference preference) {
        a(preference, -1);
    }

    public final void b(Preference preference) {
        b(preference, -1);
    }

    public final void a(Preference preference, int i) {
        b(preference, i);
        if (!this.vrL) {
            notifyDataSetChanged();
        }
    }

    private void b(Preference preference, int i) {
        String e = e(preference);
        this.vrF.put(e, preference);
        LinkedList linkedList = this.vrE;
        if (i == -1) {
            i = this.vrE.size();
        }
        linkedList.add(i, e);
        if (!(this.vrI.containsKey(d(preference)) || this.vrM)) {
            this.vrI.put(d(preference), Integer.valueOf(this.vrI.size()));
        }
        if (preference.vsa != null) {
            this.vrJ.put(preference.vsa + "|" + preference.igL, preference.igL);
        }
    }

    public final Preference Td(String str) {
        return (Preference) this.vrF.get(str);
    }

    public final void aV(String str, boolean z) {
        if (z) {
            if (!this.vrG.contains(str)) {
                this.vrG.add(str);
            } else {
                return;
            }
        } else if (!this.vrG.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    public final boolean c(Preference preference) {
        if (preference == null) {
            return false;
        }
        String e = e(preference);
        this.vrE.remove(e);
        this.vrF.remove(e);
        this.vrG.remove(preference.igL);
        notifyDataSetChanged();
        return true;
    }

    public final boolean Te(String str) {
        return c(Td(str));
    }

    public final void removeAll() {
        this.vrH.clear();
        this.vrF.clear();
        this.vrE.clear();
        this.vrG.clear();
        notifyDataSetChanged();
    }

    public final void addPreferencesFromResource(int i) {
        InflateException inflateException;
        this.vrL = true;
        j jVar = this.vrD;
        XmlPullParser xml = jVar.mContext.getResources().getXml(i);
        try {
            synchronized (jVar.HD) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                jVar.HD[0] = jVar.mContext;
                try {
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new InflateException(xml.getPositionDescription() + ": No start tag found!");
                    }
                    jVar.a(xml.getName(), asAttributeSet);
                    jVar.a(xml, (f) this, asAttributeSet);
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xml.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            }
            this.vrL = false;
            notifyDataSetChanged();
        } finally {
            xml.close();
        }
    }

    public final void b(a aVar) {
        this.vqt = aVar;
        notifyDataSetChanged();
    }

    private void bSY() {
        Collection hashSet = new HashSet();
        int i = 0;
        while (i < this.vrH.size()) {
            Preference preference = (Preference) this.vrF.get(this.vrH.get(i));
            if ((preference instanceof PreferenceCategory) && bg.mA(preference.igL) && i != 0) {
                Preference preference2 = (Preference) this.vrF.get(this.vrH.get(i - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (bg.mA(preference2.igL) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(e(preference2));
                    } else if (bg.mA(preference.igL) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(e(preference));
                    }
                }
            }
            i++;
        }
        this.vrH.removeAll(hashSet);
    }

    private static boolean AB(int i) {
        return i == com.tencent.mm.s.a.h.diC || i == com.tencent.mm.s.a.h.hez || i == com.tencent.mm.s.a.h.heB;
    }

    public void notifyDataSetChanged() {
        int i = 0;
        this.vrH.clear();
        Iterator it = this.vrE.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.vrG.contains(str)) {
                if (this.vrF.get(str) == null) {
                    w.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
                } else {
                    this.vrH.add(str);
                }
            }
        }
        if (!this.vrH.isEmpty() && AB(((Preference) this.vrF.get(this.vrH.get(0))).getLayoutResource())) {
            b(new PreferenceSmallCategory(this.context), 0);
        }
        bSY();
        this.vrK = new int[this.vrH.size()];
        if (this.vrK.length > 0) {
            Preference preference;
            int[] iArr;
            if (this.vrK.length == 1) {
                preference = (Preference) this.vrF.get(this.vrH.get(0));
                if (!AB(((Preference) this.vrF.get(this.vrH.get(0))).getLayoutResource())) {
                    this.vrK[0] = 4;
                } else if (preference instanceof CheckBoxPreference) {
                    iArr = this.vrK;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.vrK[0] = 3;
                }
                a((Preference) this.vrF.get(this.vrH.get(0)), this.hgx);
                super.notifyDataSetChanged();
                return;
            }
            while (i < this.vrH.size()) {
                a((Preference) this.vrF.get(this.vrH.get(i)), this.hgx);
                preference = (Preference) this.vrF.get(this.vrH.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (AB(layoutResource)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.vrK;
                        iArr[i] = iArr[i] | 8;
                    } else if (i == 0) {
                        iArr = this.vrK;
                        iArr[i] = iArr[i] | 1;
                    } else {
                        if (i == this.vrH.size() - 1) {
                            iArr = this.vrK;
                            iArr[i] = iArr[i] | 2;
                        }
                        layoutResource2 = ((Preference) this.vrF.get(this.vrH.get(i - 1))).getLayoutResource();
                        if (layoutResource2 != com.tencent.mm.s.a.h.diC || layoutResource2 == com.tencent.mm.s.a.h.hez || layoutResource2 == com.tencent.mm.s.a.h.heB) {
                            iArr = this.vrK;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != com.tencent.mm.s.a.h.djf) {
                    iArr = this.vrK;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        layoutResource2 = ((Preference) this.vrF.get(this.vrH.get(i - 1))).getLayoutResource();
                        if (AB(layoutResource2) || layoutResource2 == com.tencent.mm.s.a.h.djf) {
                            iArr = this.vrK;
                            layoutResource = i - 1;
                            iArr[layoutResource] = iArr[layoutResource] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.vrK;
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr = this.vrK;
                    iArr[i] = iArr[i] | 16;
                    layoutResource2 = ((Preference) this.vrF.get(this.vrH.get(i - 1))).getLayoutResource();
                    if (layoutResource2 == com.tencent.mm.s.a.h.diC || layoutResource2 == com.tencent.mm.s.a.h.hez || layoutResource2 == com.tencent.mm.s.a.h.heB) {
                        iArr = this.vrK;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
        }
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.vrZ) {
                checkBoxPreference.vqm = sharedPreferences.getBoolean(preference.igL, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.vrZ) {
                dialogPreference.setValue(sharedPreferences.getString(preference.igL, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.vrZ) {
                editPreference.value = sharedPreferences.getString(preference.igL, null);
                editPreference.setSummary(editPreference.value);
            }
        }
    }

    public int getCount() {
        return this.vrH.size();
    }

    public Object getItem(int i) {
        return this.vrF.get(this.vrH.get(i));
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        if (!this.vrM) {
            this.vrM = true;
        }
        return Math.max(1, this.vrI.size());
    }

    public int getItemViewType(int i) {
        if (i > this.vrH.size()) {
            return -1;
        }
        Integer num = (Integer) this.vrI.get(d((Preference) this.vrF.get(this.vrH.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i <= this.vrH.size()) {
            Preference preference = (Preference) this.vrF.get(this.vrH.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.a(this.vqt);
            }
            if (!this.vrI.containsKey(d(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.vrK[i];
            View findViewById = view.findViewById(g.content);
            if (findViewById == null) {
                w.d("MicroMsg.MMPreferenceAdapter", "find content view error");
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i2 & 4) == 0) {
                    int i3 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int i4 = f.hbR;
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i2 & 8) != 0) {
                        if (i == this.vrH.size() - 1 || (i == this.vrH.size() - 2 && (getItem(this.vrH.size() - 1) instanceof PreferenceCategory))) {
                            i4 = f.bhc;
                        } else if ((i2 & 2) != 0) {
                            i4 = f.bhc;
                        } else {
                            i4 = f.bgh;
                        }
                        i3 = i4;
                        i4 = d.white;
                    } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                        i3 = f.bgh;
                    }
                    findViewById.setBackgroundResource(i3);
                    findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundResource(i3);
                    }
                    view.setBackgroundResource(i4);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            }
        }
        return view;
    }
}

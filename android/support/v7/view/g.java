package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class g extends MenuInflater {
    private static final Class<?>[] OJ;
    private static final Class<?>[] OK;
    private final Object[] OL;
    private final Object[] OM = this.OL;
    private Object OO;
    private Context mContext;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] OP = new Class[]{MenuItem.class};
        private Object OO;
        private Method OQ;

        public a(Object obj, String str) {
            this.OO = obj;
            Class cls = obj.getClass();
            try {
                this.OQ = cls.getMethod(str, OP);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.OQ.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.OQ.invoke(this.OO, new Object[]{menuItem})).booleanValue();
                }
                this.OQ.invoke(this.OO, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        Menu OR;
        int OS;
        int OT;
        int OU;
        int OV;
        boolean OW;
        boolean OX;
        boolean OY;
        int OZ;
        int Pa;
        CharSequence Pb;
        CharSequence Pc;
        int Pd;
        char Pe;
        char Pf;
        int Pg;
        boolean Ph;
        boolean Pi;
        boolean Pj;
        int Pk;
        int Pl;
        String Pm;
        String Pn;
        String Po;
        public d Pp;
        final /* synthetic */ g Pq;

        public b(g gVar, Menu menu) {
            this.Pq = gVar;
            this.OR = menu;
            di();
        }

        public final void di() {
            this.OS = 0;
            this.OT = 0;
            this.OU = 0;
            this.OV = 0;
            this.OW = true;
            this.OX = true;
        }

        static char p(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        final void e(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.Ph).setVisible(this.Pi).setEnabled(this.Pj).setCheckable(this.Pg > 0).setTitleCondensed(this.Pc).setIcon(this.Pd).setAlphabeticShortcut(this.Pe).setNumericShortcut(this.Pf);
            if (this.Pk >= 0) {
                m.a(menuItem, this.Pk);
            }
            if (this.Po != null) {
                if (this.Pq.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.b(this.Pq), this.Po));
            }
            if (this.Pg >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).E(true);
                } else if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    try {
                        if (iVar.Ra == null) {
                            iVar.Ra = ((android.support.v4.c.a.b) iVar.PY).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        iVar.Ra.invoke(iVar.PY, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Pm != null) {
                m.a(menuItem, (View) newInstance(this.Pm, g.OJ, this.Pq.OL));
            } else {
                z = false;
            }
            if (this.Pl > 0 && !r2) {
                m.b(menuItem, this.Pl);
            }
            if (this.Pp != null) {
                m.a(menuItem, this.Pp);
            }
        }

        public final SubMenu dj() {
            this.OY = true;
            SubMenu addSubMenu = this.OR.addSubMenu(this.OS, this.OZ, this.Pa, this.Pb);
            e(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.Pq.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static /* synthetic */ Object b(g gVar) {
        if (gVar.OO == null) {
            Object obj = gVar.mContext;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            gVar.OO = obj;
        }
        return gVar.OO;
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        OJ = clsArr;
        OK = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.OL = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = new android.support.v7.view.g$b;
        r4.<init>(r10, r13);
        r0 = r11.getEventType();
        r3 = 0;
        r2 = 0;
    L_0x000b:
        r1 = 2;
        if (r0 != r1) goto L_0x0048;
    L_0x000e:
        r0 = r11.getName();
        r1 = "menu";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r1 = 0;
    L_0x0020:
        if (r1 != 0) goto L_0x022f;
    L_0x0022:
        switch(r0) {
            case 1: goto L_0x0226;
            case 2: goto L_0x0050;
            case 3: goto L_0x01ba;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0028:
        r3 = r11.next();
        r9 = r0;
        r0 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0020;
    L_0x0032:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0048:
        r0 = r11.next();
        r1 = 1;
        if (r0 != r1) goto L_0x000b;
    L_0x004f:
        goto L_0x001f;
    L_0x0050:
        if (r3 != 0) goto L_0x0025;
    L_0x0052:
        r0 = r11.getName();
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x00a6;
    L_0x005f:
        r0 = r4.Pq;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.cl;
        r0 = r0.obtainStyledAttributes(r12, r5);
        r5 = android.support.v7.a.a.k.Mm;
        r6 = 0;
        r5 = r0.getResourceId(r5, r6);
        r4.OS = r5;
        r5 = android.support.v7.a.a.k.Mn;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.OT = r5;
        r5 = android.support.v7.a.a.k.Mo;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.OU = r5;
        r5 = android.support.v7.a.a.k.Mk;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.OV = r5;
        r5 = android.support.v7.a.a.k.Mp;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.OW = r5;
        r5 = android.support.v7.a.a.k.Ml;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.OX = r5;
        r0.recycle();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x00a6:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x019f;
    L_0x00af:
        r0 = r4.Pq;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.cm;
        r5 = r0.obtainStyledAttributes(r12, r5);
        r0 = android.support.v7.a.a.k.My;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.OZ = r0;
        r0 = android.support.v7.a.a.k.Mz;
        r6 = r4.OT;
        r0 = r5.getInt(r0, r6);
        r6 = android.support.v7.a.a.k.MC;
        r7 = r4.OU;
        r6 = r5.getInt(r6, r7);
        r7 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r7;
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r7;
        r0 = r0 | r6;
        r4.Pa = r0;
        r0 = android.support.v7.a.a.k.MD;
        r0 = r5.getText(r0);
        r4.Pb = r0;
        r0 = android.support.v7.a.a.k.ME;
        r0 = r5.getText(r0);
        r4.Pc = r0;
        r0 = android.support.v7.a.a.k.Mx;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Pd = r0;
        r0 = android.support.v7.a.a.k.Mt;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.p(r0);
        r4.Pe = r0;
        r0 = android.support.v7.a.a.k.MA;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.p(r0);
        r4.Pf = r0;
        r0 = android.support.v7.a.a.k.Mu;
        r0 = r5.hasValue(r0);
        if (r0 == 0) goto L_0x0194;
    L_0x0115:
        r0 = android.support.v7.a.a.k.Mu;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        if (r0 == 0) goto L_0x0192;
    L_0x011e:
        r0 = 1;
    L_0x011f:
        r4.Pg = r0;
    L_0x0121:
        r0 = android.support.v7.a.a.k.Mv;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        r4.Ph = r0;
        r0 = android.support.v7.a.a.k.MF;
        r6 = r4.OW;
        r0 = r5.getBoolean(r0, r6);
        r4.Pi = r0;
        r0 = android.support.v7.a.a.k.Mw;
        r6 = r4.OX;
        r0 = r5.getBoolean(r0, r6);
        r4.Pj = r0;
        r0 = android.support.v7.a.a.k.MG;
        r6 = -1;
        r0 = r5.getInt(r0, r6);
        r4.Pk = r0;
        r0 = android.support.v7.a.a.k.MB;
        r0 = r5.getString(r0);
        r4.Po = r0;
        r0 = android.support.v7.a.a.k.Mq;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Pl = r0;
        r0 = android.support.v7.a.a.k.Ms;
        r0 = r5.getString(r0);
        r4.Pm = r0;
        r0 = android.support.v7.a.a.k.Mr;
        r0 = r5.getString(r0);
        r4.Pn = r0;
        r0 = r4.Pn;
        if (r0 == 0) goto L_0x0199;
    L_0x016c:
        r0 = 1;
    L_0x016d:
        if (r0 == 0) goto L_0x019b;
    L_0x016f:
        r0 = r4.Pl;
        if (r0 != 0) goto L_0x019b;
    L_0x0173:
        r0 = r4.Pm;
        if (r0 != 0) goto L_0x019b;
    L_0x0177:
        r0 = r4.Pn;
        r6 = OK;
        r7 = r4.Pq;
        r7 = r7.OM;
        r0 = r4.newInstance(r0, r6, r7);
        r0 = (android.support.v4.view.d) r0;
        r4.Pp = r0;
    L_0x0187:
        r5.recycle();
        r0 = 0;
        r4.OY = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0192:
        r0 = 0;
        goto L_0x011f;
    L_0x0194:
        r0 = r4.OV;
        r4.Pg = r0;
        goto L_0x0121;
    L_0x0199:
        r0 = 0;
        goto L_0x016d;
    L_0x019b:
        r0 = 0;
        r4.Pp = r0;
        goto L_0x0187;
    L_0x019f:
        r5 = "menu";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01b4;
    L_0x01a8:
        r0 = r4.dj();
        r10.a(r11, r12, r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01b4:
        r2 = 1;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01ba:
        r0 = r11.getName();
        if (r3 == 0) goto L_0x01cd;
    L_0x01c0:
        r5 = r0.equals(r2);
        if (r5 == 0) goto L_0x01cd;
    L_0x01c6:
        r2 = 0;
        r0 = 0;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01cd:
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01de;
    L_0x01d6:
        r4.di();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01de:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0218;
    L_0x01e7:
        r0 = r4.OY;
        if (r0 != 0) goto L_0x0025;
    L_0x01eb:
        r0 = r4.Pp;
        if (r0 == 0) goto L_0x01ff;
    L_0x01ef:
        r0 = r4.Pp;
        r0 = r0.hasSubMenu();
        if (r0 == 0) goto L_0x01ff;
    L_0x01f7:
        r4.dj();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01ff:
        r0 = 1;
        r4.OY = r0;
        r0 = r4.OR;
        r5 = r4.OS;
        r6 = r4.OZ;
        r7 = r4.Pa;
        r8 = r4.Pb;
        r0 = r0.add(r5, r6, r7, r8);
        r4.e(r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0218:
        r5 = "menu";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0025;
    L_0x0221:
        r0 = 1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0226:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x022f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}

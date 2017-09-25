package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.a.sc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class v {
    private static int vzW = 1;
    private static int vzX = 2;
    private static int vzY = 3;

    public static class a {
        public int tbs = 3;
        public int vAa = -1;
        public int vAb = -1;
        public long vAc = -1;
        public int vzZ;

        public a(int i, int i2, int i3) {
            this.vzZ = i;
            this.vAa = i2;
            this.vAb = i3;
        }

        public a(int i, long j) {
            this.vzZ = i;
            this.vAc = j;
        }
    }

    public static a e(com.tencent.mm.t.f.a aVar) {
        String xL = m.xL();
        if (aVar.hjf == 2 || aVar.hjf == 3) {
            String[] split;
            if (!bg.bV(aVar.hjj)) {
                for (String split2 : aVar.hjj) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(xL)) {
                        return new a(bg.getInt(split[1], -1), bg.getInt(split[2], -1), bg.getInt(split[3], -1));
                    }
                }
            }
            if (!bg.bV(aVar.hjl)) {
                for (String split22 : aVar.hjl) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(xL)) {
                        return new a(bg.getInt(split[2], -1), bg.getLong(split[1], -1));
                    }
                }
            }
        }
        return new a();
    }

    public static int a(com.tencent.mm.t.f.a aVar, boolean z) {
        a e = e(aVar);
        switch (aVar.hjf) {
            case 2:
            case 3:
                if (z || e.tbs == 1) {
                    if (e.vzZ > 0 && e.vAa >= 0 && e.vAb >= 0) {
                        switch (e.vzZ) {
                            case 1:
                            case 2:
                                return R.k.dvm;
                            case 3:
                                return R.k.dvk;
                            case 4:
                                return R.k.dvl;
                            default:
                                break;
                        }
                    }
                } else if (e.tbs == 2) {
                    if (e.vzZ > 0 && e.vAc >= 0) {
                        switch (e.vzZ) {
                            case 1:
                                return R.k.dvm;
                            case 2:
                            case 3:
                                return R.k.dvk;
                            case 4:
                                return R.k.dvl;
                            default:
                                break;
                        }
                    }
                } else {
                    return R.k.dvk;
                }
                break;
        }
        return R.k.dvk;
    }

    public static String b(com.tencent.mm.t.f.a aVar, boolean z) {
        try {
            String xL = m.xL();
            if (aVar.hjf > 0) {
                int i;
                Object obj;
                int i2;
                Object obj2;
                Object obj3 = null;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                long j = -1;
                String str = aVar.hje;
                b scVar = new sc();
                scVar.fZA.fZC = str;
                com.tencent.mm.sdk.b.a.urY.m(scVar);
                if (aVar.hjf == 2 || aVar.hjf == 3) {
                    String[] split;
                    if (!bg.bV(aVar.hjj)) {
                        for (String str2 : aVar.hjj) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(xL)) {
                                i3 = bg.getInt(split[1], -1);
                                i4 = bg.getInt(split[2], -1);
                                i5 = bg.getInt(split[3], -1);
                                obj3 = 1;
                                break;
                            }
                        }
                    }
                    if (!bg.bV(aVar.hjl)) {
                        for (String str22 : aVar.hjl) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(xL)) {
                                j = bg.getLong(split[1], -1);
                                i = bg.getInt(split[2], -1);
                                obj = 1;
                                i2 = i5;
                                i5 = i4;
                                i4 = i3;
                                obj2 = obj3;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                obj = null;
                i2 = i5;
                i5 = i4;
                i4 = i3;
                obj2 = obj3;
                if (scVar.fZB.status == vzY) {
                    return ab.getContext().getString(R.l.dBq);
                }
                if (scVar.fZB.status == vzX) {
                    return ab.getContext().getString(R.l.dBj);
                }
                switch (aVar.hjf) {
                    case 1:
                        return z ? aVar.hiR : aVar.hiS;
                    case 2:
                    case 3:
                        if (xL.equals(aVar.hjo) || z || r7 != null) {
                            if (i4 > 0 && i5 >= 0 && i2 >= 0) {
                                switch (i4) {
                                    case 1:
                                        return ab.getContext().getString(R.l.dBr);
                                    case 2:
                                        return ab.getContext().getString(R.l.dBp, new Object[]{Integer.valueOf(i5 - i2)});
                                    case 3:
                                        return ab.getContext().getString(R.l.dBo);
                                    case 4:
                                        return ab.getContext().getString(R.l.dBq);
                                    default:
                                        break;
                                }
                            }
                        } else if (obj != null) {
                            if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        return ab.getContext().getString(R.l.dBl, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 2:
                                        return ab.getContext().getString(R.l.dBk, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 3:
                                        return ab.getContext().getString(R.l.dBn, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 4:
                                        return ab.getContext().getString(R.l.dBm);
                                    default:
                                        break;
                                }
                            }
                        } else {
                            return ab.getContext().getString(R.l.dBm);
                        }
                        break;
                }
                if (z) {
                    return aVar.hiR;
                }
                return aVar.hiS;
            } else if (z) {
                return aVar.hiR;
            } else {
                return aVar.hiS;
            }
        } catch (Exception e) {
            w.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", e.getMessage());
        }
    }

    public static String a(int i, int i2, boolean z, com.tencent.mm.t.f.a aVar) {
        Context context = ab.getContext();
        if (i == 5) {
            return context.getString(R.l.exj);
        }
        if (i == 4) {
            return context.getString(R.l.exi);
        }
        if (i != 3) {
            return z ? aVar.hiR : aVar.hiS;
        } else {
            if (i2 == 2) {
                return context.getString(R.l.exk);
            }
            return z ? context.getString(R.l.exl) : aVar.hiS;
        }
    }

    public static int s(int i, int i2, boolean z) {
        if (i != 5) {
            return i == 4 ? z ? R.g.bdj : R.g.bdh : i == 3 ? i2 == 2 ? z ? R.g.bdj : R.g.bdh : z ? R.g.bdj : R.g.bdg : z ? R.g.bdi : R.g.bdg;
        } else {
            if (z) {
                return R.g.bdj;
            }
            return R.g.bdh;
        }
    }

    public static int t(int i, int i2, boolean z) {
        if (i == 5) {
            return R.g.bgN;
        }
        if (i == 4) {
            return R.g.bgN;
        }
        if (i != 3) {
            return -1;
        }
        if (i2 == 2) {
            return R.g.bgN;
        }
        if (z) {
            return R.g.bgN;
        }
        return -1;
    }

    public static int c(com.tencent.mm.t.f.a aVar, boolean z) {
        if (aVar != null) {
            String str = aVar.hje;
            b scVar = new sc();
            scVar.fZA.fZC = str;
            com.tencent.mm.sdk.b.a.urY.m(scVar);
            if (scVar.fZB.status == vzY || scVar.fZB.status == vzX) {
                return z ? R.g.bbA : R.g.bby;
            } else {
                a e = e(aVar);
                switch (aVar.hjf) {
                    case 2:
                    case 3:
                        if (z || e.tbs == 1) {
                            if (e.vzZ > 0 && e.vAa >= 0 && e.vAb >= 0) {
                                switch (e.vzZ) {
                                    case 1:
                                    case 2:
                                        return z ? R.g.bbz : R.g.bbx;
                                    case 3:
                                    case 4:
                                        return z ? R.g.bbA : R.g.bby;
                                    default:
                                        break;
                                }
                            }
                        } else if (e.tbs == 2) {
                            if (e.vzZ > 0 && e.vAc >= 0) {
                                switch (e.vzZ) {
                                    case 1:
                                        return z ? R.g.bbz : R.g.bbx;
                                    case 2:
                                    case 3:
                                    case 4:
                                        return z ? R.g.bbA : R.g.bby;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            return z ? R.g.bbz : R.g.bbx;
                        }
                        break;
                }
                if (z) {
                    return R.g.bbz;
                }
                return R.g.bbx;
            }
        } else if (z) {
            return R.g.bbz;
        } else {
            return R.g.bbx;
        }
    }
}

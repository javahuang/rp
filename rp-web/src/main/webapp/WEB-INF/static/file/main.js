/*! Moe v0.0.2 - via soulteary build at 2015-01-23 05:01:31 */
define("js/main", ["core"], function (e, t, n) {
	"use strict";
	function o(t) {
		var n = e("./libs/moment"),
		o = window.xdebug;
		o.info("[" + n(o.timeStamp()).format("YYYY-MM-DD hh:mm:ss") + "][module loaded] " + t)
	}
	function r() {
		window.xdebug;
		window.$Loader = o,
		$Loader("Main"),
		$Loader("NiceScroll");
		e("./libs/animo");
		$Loader("Extra > Extend jQuery By Animo");
		var t = e("./libs/extra");
		$Loader("Extra"),
		$Loader("Extra > Extend jQuery By Debounced Resize"),
		t.start({
			restartOnRequestAfter : !1
		}),
		$Loader("Extra > Extend jQuery By Pace"),
		$Loader("Extra > Extend jQuery By History");
		var n = e("./mods/script");
		$Loader("App"),
		n.header(),
		n.mainPost(),
		n.niceScrollPostList(),
		n.postList()
	}
	e("core");
	n.exports = {
		init : r
	}
});
define("js/libs/moment", [], function (e, t, n) {
	"use strict";
	function o(e, t, n) {
		switch (arguments.length) {
		case 2:
			return null != e ? e : t;
		case 3:
			return null != e ? e : null != t ? t : n;
		default:
			throw new Error("Implement me")
		}
	}
	function r() {
		return {
			empty : !1,
			unusedTokens : [],
			unusedInput : [],
			overflow : -2,
			charsLeftOver : 0,
			nullInput : !1,
			invalidMonth : null,
			invalidFormat : !1,
			userInvalidated : !1,
			iso : !1
		}
	}
	function i(e) {
		yt.suppressDeprecationWarnings === !1 && "undefined" != typeof console && console.warn && console.warn("Deprecation warning: " + e)
	}
	function s(e, t) {
		var n = !0;
		return p(function () {
			return n && (i(e), n = !1),
			t.apply(this, arguments)
		}, t)
	}
	function a(e, t) {
		pn[e] || (i(t), pn[e] = !0)
	}
	function l(e, t) {
		return function (n) {
			return g(e.call(this, n), t)
		}
	}
	function c(e, t) {
		return function (n) {
			return this.localeData().ordinal(e.call(this, n), t)
		}
	}
	function u() {}

	function d(e, t) {
		t !== !1 && z(e),
		f(this, e),
		this._d = new Date(+e._d)
	}
	function h(e) {
		var t = C(e),
		n = t.year || 0,
		o = t.quarter || 0,
		r = t.month || 0,
		i = t.week || 0,
		s = t.day || 0,
		a = t.hour || 0,
		l = t.minute || 0,
		c = t.second || 0,
		u = t.millisecond || 0;
		this._milliseconds = +u + 1e3 * c + 6e4 * l + 36e5 * a,
		this._days = +s + 7 * i,
		this._months = +r + 3 * o + 12 * n,
		this._data = {},
		this._locale = yt.localeData(),
		this._bubble()
	}
	function p(e, t) {
		for (var n in t)
			t.hasOwnProperty(n) && (e[n] = t[n]);
		return t.hasOwnProperty("toString") && (e.toString = t.toString),
		t.hasOwnProperty("valueOf") && (e.valueOf = t.valueOf),
		e
	}
	function f(e, t) {
		var n,
		o,
		r;
		if ("undefined" != typeof t._isAMomentObject && (e._isAMomentObject = t._isAMomentObject), "undefined" != typeof t._i && (e._i = t._i), "undefined" != typeof t._f && (e._f = t._f), "undefined" != typeof t._l && (e._l = t._l), "undefined" != typeof t._strict && (e._strict = t._strict), "undefined" != typeof t._tzm && (e._tzm = t._tzm), "undefined" != typeof t._isUTC && (e._isUTC = t._isUTC), "undefined" != typeof t._offset && (e._offset = t._offset), "undefined" != typeof t._pf && (e._pf = t._pf), "undefined" != typeof t._locale && (e._locale = t._locale), Nt.length > 0)
			for (n in Nt)
				o = Nt[n], r = t[o], "undefined" != typeof r && (e[o] = r);
		return e
	}
	function m(e) {
		return 0 > e ? Math.ceil(e) : Math.floor(e)
	}
	function g(e, t, n) {
		for (var o = "" + Math.abs(e), r = e >= 0; o.length < t; )
			o = "0" + o;
		return (r ? n ? "+" : "" : "-") + o
	}
	function v(e, t) {
		var n = {
			milliseconds : 0,
			months : 0
		};
		return n.months = t.month() - e.month() + 12 * (t.year() - e.year()),
		e.clone().add(n.months, "M").isAfter(t) && --n.months,
		n.milliseconds = +t - +e.clone().add(n.months, "M"),
		n
	}
	function y(e, t) {
		var n;
		return t = I(t, e),
		e.isBefore(t) ? n = v(e, t) : (n = v(t, e), n.milliseconds = -n.milliseconds, n.months = -n.months),
		n
	}
	function w(e, t) {
		return function (n, o) {
			var r,
			i;
			return null === o || isNaN(+o) || (a(t, "moment()." + t + "(period, number) is deprecated. Please use moment()." + t + "(number, period)."), i = n, n = o, o = i),
			n = "string" == typeof n ? +n : n,
			r = yt.duration(n, o),
			b(this, r, e),
			this
		}
	}
	function b(e, t, n, o) {
		var r = t._milliseconds,
		i = t._days,
		s = t._months;
		o = null == o ? !0 : o,
		r && e._d.setTime(+e._d + r * n),
		i && pt(e, "Date", ht(e, "Date") + i * n),
		s && dt(e, ht(e, "Month") + s * n),
		o && yt.updateOffset(e, i || s)
	}
	function x(e) {
		return "[object Array]" === Object.prototype.toString.call(e)
	}
	function T(e) {
		return "[object Date]" === Object.prototype.toString.call(e) || e instanceof Date
	}
	function S(e, t, n) {
		var o,
		r = Math.min(e.length, t.length),
		i = Math.abs(e.length - t.length),
		s = 0;
		for (o = 0; r > o; o++)
			(n && e[o] !== t[o] || !n && E(e[o]) !== E(t[o])) && s++;
		return s + i
	}
	function k(e) {
		if (e) {
			var t = e.toLowerCase().replace(/(.)s$/, "$1");
			e = sn[e] || an[t] || t
		}
		return e
	}
	function C(e) {
		var t,
		n,
		o = {};
		for (n in e)
			e.hasOwnProperty(n) && (t = k(n), t && (o[t] = e[n]));
		return o
	}
	function _(e) {
		var t,
		n;
		if (0 === e.indexOf("week"))
			t = 7, n = "day";
		else {
			if (0 !== e.indexOf("month"))
				return;
			t = 12,
			n = "month"
		}
		yt[e] = function (o, r) {
			var i,
			s,
			a = yt._locale[e],
			l = [];
			if ("number" == typeof o && (r = o, o = void 0), s = function (e) {
				var t = yt().utc().set(n, e);
				return a.call(yt._locale, t, o || "")
			}, null != r)
				return s(r);
			for (i = 0; t > i; i++)
				l.push(s(i));
			return l
		}
	}
	function E(e) {
		var t = +e,
		n = 0;
		return 0 !== t && isFinite(t) && (n = t >= 0 ? Math.floor(t) : Math.ceil(t)),
		n
	}
	function M(e, t) {
		return new Date(Date.UTC(e, t + 1, 0)).getUTCDate()
	}
	function D(e, t, n) {
		return at(yt([e, 11, 31 + t - n]), t, n).week
	}
	function N(e) {
		return L(e) ? 366 : 365
	}
	function L(e) {
		return e % 4 === 0 && e % 100 !== 0 || e % 400 === 0
	}
	function z(e) {
		var t;
		e._a && -2 === e._pf.overflow && (t = e._a[St] < 0 || e._a[St] > 11 ? St : e._a[kt] < 1 || e._a[kt] > M(e._a[Tt], e._a[St]) ? kt : e._a[Ct] < 0 || e._a[Ct] > 23 ? Ct : e._a[_t] < 0 || e._a[_t] > 59 ? _t : e._a[Et] < 0 || e._a[Et] > 59 ? Et : e._a[Mt] < 0 || e._a[Mt] > 999 ? Mt : -1, e._pf._overflowDayOfYear && (Tt > t || t > kt) && (t = kt), e._pf.overflow = t)
	}
	function A(e) {
		return null == e._isValid && (e._isValid = !isNaN(e._d.getTime()) && e._pf.overflow < 0 && !e._pf.empty && !e._pf.invalidMonth && !e._pf.nullInput && !e._pf.invalidFormat && !e._pf.userInvalidated, e._strict && (e._isValid = e._isValid && 0 === e._pf.charsLeftOver && 0 === e._pf.unusedTokens.length)),
		e._isValid
	}
	function H(e) {
		return e ? e.toLowerCase().replace("_", "-") : e
	}
	function O(e) {
		for (var t, n, o, r, i = 0; i < e.length; ) {
			for (r = H(e[i]).split("-"), t = r.length, n = H(e[i + 1]), n = n ? n.split("-") : null; t > 0; ) {
				if (o = j(r.slice(0, t).join("-")))
					return o;
				if (n && n.length >= t && S(r, n, !0) >= t - 1)
					break;
				t--
			}
			i++
		}
		return null
	}
	function j(t) {
		var n = null;
		if (!Dt[t] && Lt)
			try {
				n = yt.locale(),
				e("./locale/" + t),
				yt.locale(n)
			} catch (o) {}

		return Dt[t]
	}
	function I(e, t) {
		return t._isUTC ? yt(e).zone(t._offset || 0) : yt(e).local()
	}
	function P(e) {
		return e.match(/\[[\s\S]/) ? e.replace(/^\[|\]$/g, "") : e.replace(/\\/g, "")
	}
	function q(e) {
		var t,
		n,
		o = e.match(Ot);
		for (t = 0, n = o.length; n > t; t++)
			o[t] = hn[o[t]] ? hn[o[t]] : P(o[t]);
		return function (r) {
			var i = "";
			for (t = 0; n > t; t++)
				i += o[t]instanceof Function ? o[t].call(r, e) : o[t];
			return i
		}
	}
	function F(e, t) {
		return e.isValid() ? (t = Y(t, e.localeData()), ln[t] || (ln[t] = q(t)), ln[t](e)) : e.localeData().invalidDate()
	}
	function Y(e, t) {
		function n(e) {
			return t.longDateFormat(e) || e
		}
		var o = 5;
		for (jt.lastIndex = 0; o >= 0 && jt.test(e); )
			e = e.replace(jt, n), jt.lastIndex = 0, o -= 1;
		return e
	}
	function R(e, t) {
		var n,
		o = t._strict;
		switch (e) {
		case "Q":
			return Xt;
		case "DDDD":
			return Vt;
		case "YYYY":
		case "GGGG":
		case "gggg":
			return o ? Zt : qt;
		case "Y":
		case "G":
		case "g":
			return Qt;
		case "YYYYYY":
		case "YYYYY":
		case "GGGGG":
		case "ggggg":
			return o ? Jt : Ft;
		case "S":
			if (o)
				return Xt;
		case "SS":
			if (o)
				return Gt;
		case "SSS":
			if (o)
				return Vt;
		case "DDD":
			return Pt;
		case "MMM":
		case "MMMM":
		case "dd":
		case "ddd":
		case "dddd":
			return Rt;
		case "a":
		case "A":
			return t._locale._meridiemParse;
		case "X":
			return Ut;
		case "Z":
		case "ZZ":
			return Bt;
		case "T":
			return Wt;
		case "SSSS":
			return Yt;
		case "MM":
		case "DD":
		case "YY":
		case "GG":
		case "gg":
		case "HH":
		case "hh":
		case "mm":
		case "ss":
		case "ww":
		case "WW":
			return o ? Gt : It;
		case "M":
		case "D":
		case "d":
		case "H":
		case "h":
		case "m":
		case "s":
		case "w":
		case "W":
		case "e":
		case "E":
			return It;
		case "Do":
			return $t;
		default:
			return n = new RegExp(J(Z(e.replace("\\", "")), "i"))
		}
	}
	function B(e) {
		e = e || "";
		var t = e.match(Bt) || [],
		n = t[t.length - 1] || [],
		o = (n + "").match(on) || ["-", 0, 0],
		r =  + (60 * o[1]) + E(o[2]);
		return "+" === o[0] ? -r : r
	}
	function W(e, t, n) {
		var o,
		r = n._a;
		switch (e) {
		case "Q":
			null != t && (r[St] = 3 * (E(t) - 1));
			break;
		case "M":
		case "MM":
			null != t && (r[St] = E(t) - 1);
			break;
		case "MMM":
		case "MMMM":
			o = n._locale.monthsParse(t),
			null != o ? r[St] = o : n._pf.invalidMonth = t;
			break;
		case "D":
		case "DD":
			null != t && (r[kt] = E(t));
			break;
		case "Do":
			null != t && (r[kt] = E(parseInt(t, 10)));
			break;
		case "DDD":
		case "DDDD":
			null != t && (n._dayOfYear = E(t));
			break;
		case "YY":
			r[Tt] = yt.parseTwoDigitYear(t);
			break;
		case "YYYY":
		case "YYYYY":
		case "YYYYYY":
			r[Tt] = E(t);
			break;
		case "a":
		case "A":
			n._isPm = n._locale.isPM(t);
			break;
		case "H":
		case "HH":
		case "h":
		case "hh":
			r[Ct] = E(t);
			break;
		case "m":
		case "mm":
			r[_t] = E(t);
			break;
		case "s":
		case "ss":
			r[Et] = E(t);
			break;
		case "S":
		case "SS":
		case "SSS":
		case "SSSS":
			r[Mt] = E(1e3 * ("0." + t));
			break;
		case "X":
			n._d = new Date(1e3 * parseFloat(t));
			break;
		case "Z":
		case "ZZ":
			n._useUTC = !0,
			n._tzm = B(t);
			break;
		case "dd":
		case "ddd":
		case "dddd":
			o = n._locale.weekdaysParse(t),
			null != o ? (n._w = n._w || {}, n._w.d = o) : n._pf.invalidWeekday = t;
			break;
		case "w":
		case "ww":
		case "W":
		case "WW":
		case "d":
		case "e":
		case "E":
			e = e.substr(0, 1);
		case "gggg":
		case "GGGG":
		case "GGGGG":
			e = e.substr(0, 2),
			t && (n._w = n._w || {}, n._w[e] = E(t));
			break;
		case "gg":
		case "GG":
			n._w = n._w || {},
			n._w[e] = yt.parseTwoDigitYear(t)
		}
	}
	function U(e) {
		var t,
		n,
		r,
		i,
		s,
		a,
		l;
		t = e._w,
		null != t.GG || null != t.W || null != t.E ? (s = 1, a = 4, n = o(t.GG, e._a[Tt], at(yt(), 1, 4).year), r = o(t.W, 1), i = o(t.E, 1)) : (s = e._locale._week.dow, a = e._locale._week.doy, n = o(t.gg, e._a[Tt], at(yt(), s, a).year), r = o(t.w, 1), null != t.d ? (i = t.d, s > i && ++r) : i = null != t.e ? t.e + s : s),
		l = lt(n, r, i, a, s),
		e._a[Tt] = l.year,
		e._dayOfYear = l.dayOfYear
	}
	function $(e) {
		var t,
		n,
		r,
		i,
		s = [];
		if (!e._d) {
			for (r = G(e), e._w && null == e._a[kt] && null == e._a[St] && U(e), e._dayOfYear && (i = o(e._a[Tt], r[Tt]), e._dayOfYear > N(i) && (e._pf._overflowDayOfYear = !0), n = ot(i, 0, e._dayOfYear), e._a[St] = n.getUTCMonth(), e._a[kt] = n.getUTCDate()), t = 0; 3 > t && null == e._a[t]; ++t)
				e._a[t] = s[t] = r[t];
			for (; 7 > t; t++)
				e._a[t] = s[t] = null == e._a[t] ? 2 === t ? 1 : 0 : e._a[t];
			e._d = (e._useUTC ? ot : nt).apply(null, s),
			null != e._tzm && e._d.setUTCMinutes(e._d.getUTCMinutes() + e._tzm)
		}
	}
	function X(e) {
		var t;
		e._d || (t = C(e._i), e._a = [t.year, t.month, t.day, t.hour, t.minute, t.second, t.millisecond], $(e))
	}
	function G(e) {
		var t = new Date;
		return e._useUTC ? [t.getUTCFullYear(), t.getUTCMonth(), t.getUTCDate()] : [t.getFullYear(), t.getMonth(), t.getDate()]
	}
	function V(e) {
		if (e._f === yt.ISO_8601)
			return void K(e);
		e._a = [],
		e._pf.empty = !0;
		var t,
		n,
		o,
		r,
		i,
		s = "" + e._i,
		a = s.length,
		l = 0;
		for (o = Y(e._f, e._locale).match(Ot) || [], t = 0; t < o.length; t++)
			r = o[t], n = (s.match(R(r, e)) || [])[0], n && (i = s.substr(0, s.indexOf(n)), i.length > 0 && e._pf.unusedInput.push(i), s = s.slice(s.indexOf(n) + n.length), l += n.length), hn[r] ? (n ? e._pf.empty = !1 : e._pf.unusedTokens.push(r), W(r, n, e)) : e._strict && !n && e._pf.unusedTokens.push(r);
		e._pf.charsLeftOver = a - l,
		s.length > 0 && e._pf.unusedInput.push(s),
		e._isPm && e._a[Ct] < 12 && (e._a[Ct] += 12),
		e._isPm === !1 && 12 === e._a[Ct] && (e._a[Ct] = 0),
		$(e),
		z(e)
	}
	function Z(e) {
		return e.replace(/\\(\[)|\\(\])|\[([^\]\[]*)\]|\\(.)/g, function (e, t, n, o, r) {
			return t || n || o || r
		})
	}
	function J(e) {
		return e.replace(/[-\/\\^$*+?.()|[\]{}]/g, "\\$&")
	}
	function Q(e) {
		var t,
		n,
		o,
		i,
		s;
		if (0 === e._f.length)
			return e._pf.invalidFormat = !0, void(e._d = new Date(0 / 0));
		for (i = 0; i < e._f.length; i++)
			s = 0, t = f({}, e), t._pf = r(), t._f = e._f[i], V(t), A(t) && (s += t._pf.charsLeftOver, s += 10 * t._pf.unusedTokens.length, t._pf.score = s, (null == o || o > s) && (o = s, n = t));
		p(e, n || t)
	}
	function K(e) {
		var t,
		n,
		o = e._i,
		r = Kt.exec(o);
		if (r) {
			for (e._pf.iso = !0, t = 0, n = tn.length; n > t; t++)
				if (tn[t][1].exec(o)) {
					e._f = tn[t][0] + (r[6] || " ");
					break
				}
			for (t = 0, n = nn.length; n > t; t++)
				if (nn[t][1].exec(o)) {
					e._f += nn[t][0];
					break
				}
			o.match(Bt) && (e._f += "Z"),
			V(e)
		} else
			e._isValid = !1
	}
	function et(e) {
		K(e),
		e._isValid === !1 && (delete e._isValid, yt.createFromInputFallback(e))
	}
	function tt(e) {
		var t,
		n = e._i;
		void 0 === n ? e._d = new Date : T(n) ? e._d = new Date(+n) : null !== (t = zt.exec(n)) ? e._d = new Date(+t[1]) : "string" == typeof n ? et(e) : x(n) ? (e._a = n.slice(0), $(e)) : "object" == typeof n ? X(e) : "number" == typeof n ? e._d = new Date(n) : yt.createFromInputFallback(e)
	}
	function nt(e, t, n, o, r, i, s) {
		var a = new Date(e, t, n, o, r, i, s);
		return 1970 > e && a.setFullYear(e),
		a
	}
	function ot(e) {
		var t = new Date(Date.UTC.apply(null, arguments));
		return 1970 > e && t.setUTCFullYear(e),
		t
	}
	function rt(e, t) {
		if ("string" == typeof e)
			if (isNaN(e)) {
				if (e = t.weekdaysParse(e), "number" != typeof e)
					return null
			} else
				e = parseInt(e, 10);
		return e
	}
	function it(e, t, n, o, r) {
		return r.relativeTime(t || 1, !!n, e, o)
	}
	function st(e, t, n) {
		var o = yt.duration(e).abs(),
		r = xt(o.as("s")),
		i = xt(o.as("m")),
		s = xt(o.as("h")),
		a = xt(o.as("d")),
		l = xt(o.as("M")),
		c = xt(o.as("y")),
		u = r < cn.s && ["s", r] || 1 === i && ["m"] || i < cn.m && ["mm", i] || 1 === s && ["h"] || s < cn.h && ["hh", s] || 1 === a && ["d"] || a < cn.d && ["dd", a] || 1 === l && ["M"] || l < cn.M && ["MM", l] || 1 === c && ["y"] || ["yy", c];
		return u[2] = t,
		u[3] = +e > 0,
		u[4] = n,
		it.apply({}, u)
	}
	function at(e, t, n) {
		var o,
		r = n - t,
		i = n - e.day();
		return i > r && (i -= 7),
		r - 7 > i && (i += 7),
		o = yt(e).add(i, "d"), {
			week : Math.ceil(o.dayOfYear() / 7),
			year : o.year()
		}
	}
	function lt(e, t, n, o, r) {
		var i,
		s,
		a = ot(e, 0, 1).getUTCDay();
		return a = 0 === a ? 7 : a,
		n = null != n ? n : r,
		i = r - a + (a > o ? 7 : 0) - (r > a ? 7 : 0),
		s = 7 * (t - 1) + (n - r) + i + 1, {
			year : s > 0 ? e : e - 1,
			dayOfYear : s > 0 ? s : N(e - 1) + s
		}
	}
	function ct(e) {
		var t = e._i,
		n = e._f;
		return e._locale = e._locale || yt.localeData(e._l),
		null === t || void 0 === n && "" === t ? yt.invalid({
			nullInput : !0
		}) : ("string" == typeof t && (e._i = t = e._locale.preparse(t)), yt.isMoment(t) ? new d(t, !0) : (n ? x(n) ? Q(e) : V(e) : tt(e), new d(e)))
	}
	function ut(e, t) {
		var n,
		o;
		if (1 === t.length && x(t[0]) && (t = t[0]), !t.length)
			return yt();
		for (n = t[0], o = 1; o < t.length; ++o)
			t[o][e](n) && (n = t[o]);
		return n
	}
	function dt(e, t) {
		var n;
		return "string" == typeof t && (t = e.localeData().monthsParse(t), "number" != typeof t) ? e : (n = Math.min(e.date(), M(e.year(), t)), e._d["set" + (e._isUTC ? "UTC" : "") + "Month"](t, n), e)
	}
	function ht(e, t) {
		return e._d["get" + (e._isUTC ? "UTC" : "") + t]()
	}
	function pt(e, t, n) {
		return "Month" === t ? dt(e, n) : e._d["set" + (e._isUTC ? "UTC" : "") + t](n)
	}
	function ft(e, t) {
		return function (n) {
			return null != n ? (pt(this, e, n), yt.updateOffset(this, t), this) : ht(this, e)
		}
	}
	function mt(e) {
		return 400 * e / 146097
	}
	function gt(e) {
		return 146097 * e / 400
	}
	function vt(e) {
		yt.duration.fn[e] = function () {
			return this._data[e]
		}
	}
	for (var yt, wt, bt = "2.8.1", xt = Math.round, Tt = 0, St = 1, kt = 2, Ct = 3, _t = 4, Et = 5, Mt = 6, Dt = {}, Nt = [], Lt = "undefined" != typeof n && n.exports, zt = /^\/?Date\((\-?\d+)/i, At = /(\-)?(?:(\d*)\.)?(\d+)\:(\d+)(?:\:(\d+)\.?(\d{3})?)?/, Ht = /^(-)?P(?:(?:([0-9,.]*)Y)?(?:([0-9,.]*)M)?(?:([0-9,.]*)D)?(?:T(?:([0-9,.]*)H)?(?:([0-9,.]*)M)?(?:([0-9,.]*)S)?)?|([0-9,.]*)W)$/, Ot = /(\[[^\[]*\])|(\\)?(Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|Q|YYYYYY|YYYYY|YYYY|YY|gg(ggg?)?|GG(GGG?)?|e|E|a|A|hh?|HH?|mm?|ss?|S{1,4}|X|zz?|ZZ?|.)/g, jt = /(\[[^\[]*\])|(\\)?(LT|LL?L?L?|l{1,4})/g, It = /\d\d?/, Pt = /\d{1,3}/, qt = /\d{1,4}/, Ft = /[+\-]?\d{1,6}/, Yt = /\d+/, Rt = /[0-9]*['a-z\u00A0-\u05FF\u0700-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+|[\u0600-\u06FF\/]+(\s*?[\u0600-\u06FF]+){1,2}/i, Bt = /Z|[\+\-]\d\d:?\d\d/gi, Wt = /T/i, Ut = /[\+\-]?\d+(\.\d{1,3})?/, $t = /\d{1,2}/, Xt = /\d/, Gt = /\d\d/, Vt = /\d{3}/, Zt = /\d{4}/, Jt = /[+-]?\d{6}/, Qt = /[+-]?\d+/, Kt = /^\s*(?:[+-]\d{6}|\d{4})-(?:(\d\d-\d\d)|(W\d\d$)|(W\d\d-\d)|(\d\d\d))((T| )(\d\d(:\d\d(:\d\d(\.\d+)?)?)?)?([\+\-]\d\d(?::?\d\d)?|\s*Z)?)?$/, en = "YYYY-MM-DDTHH:mm:ssZ", tn = [["YYYYYY-MM-DD", /[+-]\d{6}-\d{2}-\d{2}/], ["YYYY-MM-DD", /\d{4}-\d{2}-\d{2}/], ["GGGG-[W]WW-E", /\d{4}-W\d{2}-\d/], ["GGGG-[W]WW", /\d{4}-W\d{2}/], ["YYYY-DDD", /\d{4}-\d{3}/]], nn = [["HH:mm:ss.SSSS", /(T| )\d\d:\d\d:\d\d\.\d+/], ["HH:mm:ss", /(T| )\d\d:\d\d:\d\d/], ["HH:mm", /(T| )\d\d:\d\d/], ["HH", /(T| )\d\d/]], on = /([\+\-]|\d\d)/gi, rn = ("Date|Hours|Minutes|Seconds|Milliseconds".split("|"), {
			Milliseconds : 1,
			Seconds : 1e3,
			Minutes : 6e4,
			Hours : 36e5,
			Days : 864e5,
			Months : 2592e6,
			Years : 31536e6
		}), sn = {
			ms : "millisecond",
			s : "second",
			m : "minute",
			h : "hour",
			d : "day",
			D : "date",
			w : "week",
			W : "isoWeek",
			M : "month",
			Q : "quarter",
			y : "year",
			DDD : "dayOfYear",
			e : "weekday",
			E : "isoWeekday",
			gg : "weekYear",
			GG : "isoWeekYear"
		}, an = {
			dayofyear : "dayOfYear",
			isoweekday : "isoWeekday",
			isoweek : "isoWeek",
			weekyear : "weekYear",
			isoweekyear : "isoWeekYear"
		}, ln = {}, cn = {
			s : 45,
			m : 45,
			h : 22,
			d : 26,
			M : 11
		}, un = "DDD w W M D d".split(" "), dn = "M D H h m s w W".split(" "), hn = {
			M : function () {
				return this.month() + 1
			},
			MMM : function (e) {
				return this.localeData().monthsShort(this, e)
			},
			MMMM : function (e) {
				return this.localeData().months(this, e)
			},
			D : function () {
				return this.date()
			},
			DDD : function () {
				return this.dayOfYear()
			},
			d : function () {
				return this.day()
			},
			dd : function (e) {
				return this.localeData().weekdaysMin(this, e)
			},
			ddd : function (e) {
				return this.localeData().weekdaysShort(this, e)
			},
			dddd : function (e) {
				return this.localeData().weekdays(this, e)
			},
			w : function () {
				return this.week()
			},
			W : function () {
				return this.isoWeek()
			},
			YY : function () {
				return g(this.year() % 100, 2)
			},
			YYYY : function () {
				return g(this.year(), 4)
			},
			YYYYY : function () {
				return g(this.year(), 5)
			},
			YYYYYY : function () {
				var e = this.year(),
				t = e >= 0 ? "+" : "-";
				return t + g(Math.abs(e), 6)
			},
			gg : function () {
				return g(this.weekYear() % 100, 2)
			},
			gggg : function () {
				return g(this.weekYear(), 4)
			},
			ggggg : function () {
				return g(this.weekYear(), 5)
			},
			GG : function () {
				return g(this.isoWeekYear() % 100, 2)
			},
			GGGG : function () {
				return g(this.isoWeekYear(), 4)
			},
			GGGGG : function () {
				return g(this.isoWeekYear(), 5)
			},
			e : function () {
				return this.weekday()
			},
			E : function () {
				return this.isoWeekday()
			},
			a : function () {
				return this.localeData().meridiem(this.hours(), this.minutes(), !0)
			},
			A : function () {
				return this.localeData().meridiem(this.hours(), this.minutes(), !1)
			},
			H : function () {
				return this.hours()
			},
			h : function () {
				return this.hours() % 12 || 12
			},
			m : function () {
				return this.minutes()
			},
			s : function () {
				return this.seconds()
			},
			S : function () {
				return E(this.milliseconds() / 100)
			},
			SS : function () {
				return g(E(this.milliseconds() / 10), 2)
			},
			SSS : function () {
				return g(this.milliseconds(), 3)
			},
			SSSS : function () {
				return g(this.milliseconds(), 3)
			},
			Z : function () {
				var e = -this.zone(),
				t = "+";
				return 0 > e && (e = -e, t = "-"),
				t + g(E(e / 60), 2) + ":" + g(E(e) % 60, 2)
			},
			ZZ : function () {
				var e = -this.zone(),
				t = "+";
				return 0 > e && (e = -e, t = "-"),
				t + g(E(e / 60), 2) + g(E(e) % 60, 2)
			},
			z : function () {
				return this.zoneAbbr()
			},
			zz : function () {
				return this.zoneName()
			},
			X : function () {
				return this.unix()
			},
			Q : function () {
				return this.quarter()
			}
		}, pn = {}, fn = ["months", "monthsShort", "weekdays", "weekdaysShort", "weekdaysMin"]; un.length; )
		wt = un.pop(), hn[wt + "o"] = c(hn[wt], wt);
	for (; dn.length; )
		wt = dn.pop(), hn[wt + wt] = l(hn[wt], 2);
	hn.DDDD = l(hn.DDD, 3),
	p(u.prototype, {
		set : function (e) {
			var t,
			n;
			for (n in e)
				t = e[n], "function" == typeof t ? this[n] = t : this["_" + n] = t
		},
		_months : "January_February_March_April_May_June_July_August_September_October_November_December".split("_"),
		months : function (e) {
			return this._months[e.month()]
		},
		_monthsShort : "Jan_Feb_Mar_Apr_May_Jun_Jul_Aug_Sep_Oct_Nov_Dec".split("_"),
		monthsShort : function (e) {
			return this._monthsShort[e.month()]
		},
		monthsParse : function (e) {
			var t,
			n,
			o;
			for (this._monthsParse || (this._monthsParse = []), t = 0; 12 > t; t++)
				if (this._monthsParse[t] || (n = yt.utc([2e3, t]), o = "^" + this.months(n, "") + "|^" + this.monthsShort(n, ""), this._monthsParse[t] = new RegExp(o.replace(".", ""), "i")), this._monthsParse[t].test(e))
					return t
		},
		_weekdays : "Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),
		weekdays : function (e) {
			return this._weekdays[e.day()]
		},
		_weekdaysShort : "Sun_Mon_Tue_Wed_Thu_Fri_Sat".split("_"),
		weekdaysShort : function (e) {
			return this._weekdaysShort[e.day()]
		},
		_weekdaysMin : "Su_Mo_Tu_We_Th_Fr_Sa".split("_"),
		weekdaysMin : function (e) {
			return this._weekdaysMin[e.day()]
		},
		weekdaysParse : function (e) {
			var t,
			n,
			o;
			for (this._weekdaysParse || (this._weekdaysParse = []), t = 0; 7 > t; t++)
				if (this._weekdaysParse[t] || (n = yt([2e3, 1]).day(t), o = "^" + this.weekdays(n, "") + "|^" + this.weekdaysShort(n, "") + "|^" + this.weekdaysMin(n, ""), this._weekdaysParse[t] = new RegExp(o.replace(".", ""), "i")), this._weekdaysParse[t].test(e))
					return t
		},
		_longDateFormat : {
			LT : "h:mm A",
			L : "MM/DD/YYYY",
			LL : "MMMM D, YYYY",
			LLL : "MMMM D, YYYY LT",
			LLLL : "dddd, MMMM D, YYYY LT"
		},
		longDateFormat : function (e) {
			var t = this._longDateFormat[e];
			return !t && this._longDateFormat[e.toUpperCase()] && (t = this._longDateFormat[e.toUpperCase()].replace(/MMMM|MM|DD|dddd/g, function (e) {
						return e.slice(1)
					}), this._longDateFormat[e] = t),
			t
		},
		isPM : function (e) {
			return "p" === (e + "").toLowerCase().charAt(0)
		},
		_meridiemParse : /[ap]\.?m?\.?/i,
		meridiem : function (e, t, n) {
			return e > 11 ? n ? "pm" : "PM" : n ? "am" : "AM"
		},
		_calendar : {
			sameDay : "[Today at] LT",
			nextDay : "[Tomorrow at] LT",
			nextWeek : "dddd [at] LT",
			lastDay : "[Yesterday at] LT",
			lastWeek : "[Last] dddd [at] LT",
			sameElse : "L"
		},
		calendar : function (e, t) {
			var n = this._calendar[e];
			return "function" == typeof n ? n.apply(t) : n
		},
		_relativeTime : {
			future : "in %s",
			past : "%s ago",
			s : "a few seconds",
			m : "a minute",
			mm : "%d minutes",
			h : "an hour",
			hh : "%d hours",
			d : "a day",
			dd : "%d days",
			M : "a month",
			MM : "%d months",
			y : "a year",
			yy : "%d years"
		},
		relativeTime : function (e, t, n, o) {
			var r = this._relativeTime[n];
			return "function" == typeof r ? r(e, t, n, o) : r.replace(/%d/i, e)
		},
		pastFuture : function (e, t) {
			var n = this._relativeTime[e > 0 ? "future" : "past"];
			return "function" == typeof n ? n(t) : n.replace(/%s/i, t)
		},
		ordinal : function (e) {
			return this._ordinal.replace("%d", e)
		},
		_ordinal : "%d",
		preparse : function (e) {
			return e
		},
		postformat : function (e) {
			return e
		},
		week : function (e) {
			return at(e, this._week.dow, this._week.doy).week
		},
		_week : {
			dow : 0,
			doy : 6
		},
		_invalidDate : "Invalid date",
		invalidDate : function () {
			return this._invalidDate
		}
	}),
	yt = function (e, t, n, o) {
		var i;
		return "boolean" == typeof n && (o = n, n = void 0),
		i = {},
		i._isAMomentObject = !0,
		i._i = e,
		i._f = t,
		i._l = n,
		i._strict = o,
		i._isUTC = !1,
		i._pf = r(),
		ct(i)
	},
	yt.suppressDeprecationWarnings = !1,
	yt.createFromInputFallback = s("moment construction falls back to js Date. This is discouraged and will be removed in upcoming major release. Please refer to https://github.com/moment/moment/issues/1407 for more info.", function (e) {
			e._d = new Date(e._i)
		}),
	yt.min = function () {
		var e = [].slice.call(arguments, 0);
		return ut("isBefore", e)
	},
	yt.max = function () {
		var e = [].slice.call(arguments, 0);
		return ut("isAfter", e)
	},
	yt.utc = function (e, t, n, o) {
		var i;
		return "boolean" == typeof n && (o = n, n = void 0),
		i = {},
		i._isAMomentObject = !0,
		i._useUTC = !0,
		i._isUTC = !0,
		i._l = n,
		i._i = e,
		i._f = t,
		i._strict = o,
		i._pf = r(),
		ct(i).utc()
	},
	yt.unix = function (e) {
		return yt(1e3 * e)
	},
	yt.duration = function (e, t) {
		var n,
		o,
		r,
		i,
		s = e,
		a = null;
		return yt.isDuration(e) ? s = {
			ms : e._milliseconds,
			d : e._days,
			M : e._months
		}
		 : "number" == typeof e ? (s = {}, t ? s[t] = e : s.milliseconds = e) : (a = At.exec(e)) ? (n = "-" === a[1] ? -1 : 1, s = {
				y : 0,
				d : E(a[kt]) * n,
				h : E(a[Ct]) * n,
				m : E(a[_t]) * n,
				s : E(a[Et]) * n,
				ms : E(a[Mt]) * n
			}) : (a = Ht.exec(e)) ? (n = "-" === a[1] ? -1 : 1, r = function (e) {
			var t = e && parseFloat(e.replace(",", "."));
			return (isNaN(t) ? 0 : t) * n
		}, s = {
				y : r(a[2]),
				M : r(a[3]),
				d : r(a[4]),
				h : r(a[5]),
				m : r(a[6]),
				s : r(a[7]),
				w : r(a[8])
			}) : "object" == typeof s && ("from" in s || "to" in s) && (i = y(yt(s.from), yt(s.to)), s = {}, s.ms = i.milliseconds, s.M = i.months),
		o = new h(s),
		yt.isDuration(e) && e.hasOwnProperty("_locale") && (o._locale = e._locale),
		o
	},
	yt.version = bt,
	yt.defaultFormat = en,
	yt.ISO_8601 = function () {},
	yt.momentProperties = Nt,
	yt.updateOffset = function () {},
	yt.relativeTimeThreshold = function (e, t) {
		return void 0 === cn[e] ? !1 : void 0 === t ? cn[e] : (cn[e] = t, !0)
	},
	yt.lang = s("moment.lang is deprecated. Use moment.locale instead.", function (e, t) {
			return yt.locale(e, t)
		}),
	yt.locale = function (e, t) {
		var n;
		return e && (n = "undefined" != typeof t ? yt.defineLocale(e, t) : yt.localeData(e), n && (yt.duration._locale = yt._locale = n)),
		yt._locale._abbr
	},
	yt.defineLocale = function (e, t) {
		return null !== t ? (t.abbr = e, Dt[e] || (Dt[e] = new u), Dt[e].set(t), yt.locale(e), Dt[e]) : (delete Dt[e], null)
	},
	yt.langData = s("moment.langData is deprecated. Use moment.localeData instead.", function (e) {
			return yt.localeData(e)
		}),
	yt.localeData = function (e) {
		var t;
		if (e && e._locale && e._locale._abbr && (e = e._locale._abbr), !e)
			return yt._locale;
		if (!x(e)) {
			if (t = j(e))
				return t;
			e = [e]
		}
		return O(e)
	},
	yt.isMoment = function (e) {
		return e instanceof d || null != e && e.hasOwnProperty("_isAMomentObject")
	},
	yt.isDuration = function (e) {
		return e instanceof h
	};
	for (wt = fn.length - 1; wt >= 0; --wt)
		_(fn[wt]);
	yt.normalizeUnits = function (e) {
		return k(e)
	},
	yt.invalid = function (e) {
		var t = yt.utc(0 / 0);
		return null != e ? p(t._pf, e) : t._pf.userInvalidated = !0,
		t
	},
	yt.parseZone = function () {
		return yt.apply(null, arguments).parseZone()
	},
	yt.parseTwoDigitYear = function (e) {
		return E(e) + (E(e) > 68 ? 1900 : 2e3)
	},
	p(yt.fn = d.prototype, {
		clone : function () {
			return yt(this)
		},
		valueOf : function () {
			return +this._d + 6e4 * (this._offset || 0)
		},
		unix : function () {
			return Math.floor(+this / 1e3)
		},
		toString : function () {
			return this.clone().locale("en").format("ddd MMM DD YYYY HH:mm:ss [GMT]ZZ")
		},
		toDate : function () {
			return this._offset ? new Date(+this) : this._d
		},
		toISOString : function () {
			var e = yt(this).utc();
			return 0 < e.year() && e.year() <= 9999 ? F(e, "YYYY-MM-DD[T]HH:mm:ss.SSS[Z]") : F(e, "YYYYYY-MM-DD[T]HH:mm:ss.SSS[Z]")
		},
		toArray : function () {
			var e = this;
			return [e.year(), e.month(), e.date(), e.hours(), e.minutes(), e.seconds(), e.milliseconds()]
		},
		isValid : function () {
			return A(this)
		},
		isDSTShifted : function () {
			return this._a ? this.isValid() && S(this._a, (this._isUTC ? yt.utc(this._a) : yt(this._a)).toArray()) > 0 : !1
		},
		parsingFlags : function () {
			return p({}, this._pf)
		},
		invalidAt : function () {
			return this._pf.overflow
		},
		utc : function (e) {
			return this.zone(0, e)
		},
		local : function (e) {
			return this._isUTC && (this.zone(0, e), this._isUTC = !1, e && this.add(this._d.getTimezoneOffset(), "m")),
			this
		},
		format : function (e) {
			var t = F(this, e || yt.defaultFormat);
			return this.localeData().postformat(t)
		},
		add : w(1, "add"),
		subtract : w(-1, "subtract"),
		diff : function (e, t, n) {
			var o,
			r,
			i = I(e, this),
			s = 6e4 * (this.zone() - i.zone());
			return t = k(t),
			"year" === t || "month" === t ? (o = 432e5 * (this.daysInMonth() + i.daysInMonth()), r = 12 * (this.year() - i.year()) + (this.month() - i.month()), r += (this - yt(this).startOf("month") - (i - yt(i).startOf("month"))) / o, r -= 6e4 * (this.zone() - yt(this).startOf("month").zone() - (i.zone() - yt(i).startOf("month").zone())) / o, "year" === t && (r /= 12)) : (o = this - i, r = "second" === t ? o / 1e3 : "minute" === t ? o / 6e4 : "hour" === t ? o / 36e5 : "day" === t ? (o - s) / 864e5 : "week" === t ? (o - s) / 6048e5 : o),
			n ? r : m(r)
		},
		from : function (e, t) {
			return yt.duration({
				to : this,
				from : e
			}).locale(this.locale()).humanize(!t)
		},
		fromNow : function (e) {
			return this.from(yt(), e)
		},
		calendar : function (e) {
			var t = e || yt(),
			n = I(t, this).startOf("day"),
			o = this.diff(n, "days", !0),
			r = -6 > o ? "sameElse" : -1 > o ? "lastWeek" : 0 > o ? "lastDay" : 1 > o ? "sameDay" : 2 > o ? "nextDay" : 7 > o ? "nextWeek" : "sameElse";
			return this.format(this.localeData().calendar(r, this))
		},
		isLeapYear : function () {
			return L(this.year())
		},
		isDST : function () {
			return this.zone() < this.clone().month(0).zone() || this.zone() < this.clone().month(5).zone()
		},
		day : function (e) {
			var t = this._isUTC ? this._d.getUTCDay() : this._d.getDay();
			return null != e ? (e = rt(e, this.localeData()), this.add(e - t, "d")) : t
		},
		month : ft("Month", !0),
		startOf : function (e) {
			switch (e = k(e)) {
			case "year":
				this.month(0);
			case "quarter":
			case "month":
				this.date(1);
			case "week":
			case "isoWeek":
			case "day":
				this.hours(0);
			case "hour":
				this.minutes(0);
			case "minute":
				this.seconds(0);
			case "second":
				this.milliseconds(0)
			}
			return "week" === e ? this.weekday(0) : "isoWeek" === e && this.isoWeekday(1),
			"quarter" === e && this.month(3 * Math.floor(this.month() / 3)),
			this
		},
		endOf : function (e) {
			return e = k(e),
			this.startOf(e).add(1, "isoWeek" === e ? "week" : e).subtract(1, "ms")
		},
		isAfter : function (e, t) {
			return t = "undefined" != typeof t ? t : "millisecond",
			+this.clone().startOf(t) > +yt(e).startOf(t)
		},
		isBefore : function (e, t) {
			return t = "undefined" != typeof t ? t : "millisecond",
			+this.clone().startOf(t) < +yt(e).startOf(t)
		},
		isSame : function (e, t) {
			return t = t || "ms",
			+this.clone().startOf(t) === +I(e, this).startOf(t)
		},
		min : s("moment().min is deprecated, use moment.min instead. https://github.com/moment/moment/issues/1548", function (e) {
			return e = yt.apply(null, arguments),
			this > e ? this : e
		}),
		max : s("moment().max is deprecated, use moment.max instead. https://github.com/moment/moment/issues/1548", function (e) {
			return e = yt.apply(null, arguments),
			e > this ? this : e
		}),
		zone : function (e, t) {
			var n,
			o = this._offset || 0;
			return null == e ? this._isUTC ? o : this._d.getTimezoneOffset() : ("string" == typeof e && (e = B(e)), Math.abs(e) < 16 && (e = 60 * e), !this._isUTC && t && (n = this._d.getTimezoneOffset()), this._offset = e, this._isUTC = !0, null != n && this.subtract(n, "m"), o !== e && (!t || this._changeInProgress ? b(this, yt.duration(o - e, "m"), 1, !1) : this._changeInProgress || (this._changeInProgress = !0, yt.updateOffset(this, !0), this._changeInProgress = null)), this)
		},
		zoneAbbr : function () {
			return this._isUTC ? "UTC" : ""
		},
		zoneName : function () {
			return this._isUTC ? "Coordinated Universal Time" : ""
		},
		parseZone : function () {
			return this._tzm ? this.zone(this._tzm) : "string" == typeof this._i && this.zone(this._i),
			this
		},
		hasAlignedHourOffset : function (e) {
			return e = e ? yt(e).zone() : 0,
			(this.zone() - e) % 60 === 0
		},
		daysInMonth : function () {
			return M(this.year(), this.month())
		},
		dayOfYear : function (e) {
			var t = xt((yt(this).startOf("day") - yt(this).startOf("year")) / 864e5) + 1;
			return null == e ? t : this.add(e - t, "d")
		},
		quarter : function (e) {
			return null == e ? Math.ceil((this.month() + 1) / 3) : this.month(3 * (e - 1) + this.month() % 3)
		},
		weekYear : function (e) {
			var t = at(this, this.localeData()._week.dow, this.localeData()._week.doy).year;
			return null == e ? t : this.add(e - t, "y")
		},
		isoWeekYear : function (e) {
			var t = at(this, 1, 4).year;
			return null == e ? t : this.add(e - t, "y")
		},
		week : function (e) {
			var t = this.localeData().week(this);
			return null == e ? t : this.add(7 * (e - t), "d")
		},
		isoWeek : function (e) {
			var t = at(this, 1, 4).week;
			return null == e ? t : this.add(7 * (e - t), "d")
		},
		weekday : function (e) {
			var t = (this.day() + 7 - this.localeData()._week.dow) % 7;
			return null == e ? t : this.add(e - t, "d")
		},
		isoWeekday : function (e) {
			return null == e ? this.day() || 7 : this.day(this.day() % 7 ? e : e - 7)
		},
		isoWeeksInYear : function () {
			return D(this.year(), 1, 4)
		},
		weeksInYear : function () {
			var e = this.localeData()._week;
			return D(this.year(), e.dow, e.doy)
		},
		get : function (e) {
			return e = k(e),
			this[e]()
		},
		set : function (e, t) {
			return e = k(e),
			"function" == typeof this[e] && this[e](t),
			this
		},
		locale : function (e) {
			return void 0 === e ? this._locale._abbr : (this._locale = yt.localeData(e), this)
		},
		lang : s("moment().lang() is deprecated. Use moment().localeData() instead.", function (e) {
			return void 0 === e ? this.localeData() : (this._locale = yt.localeData(e), this)
		}),
		localeData : function () {
			return this._locale
		}
	}),
	yt.fn.millisecond = yt.fn.milliseconds = ft("Milliseconds", !1),
	yt.fn.second = yt.fn.seconds = ft("Seconds", !1),
	yt.fn.minute = yt.fn.minutes = ft("Minutes", !1),
	yt.fn.hour = yt.fn.hours = ft("Hours", !0),
	yt.fn.date = ft("Date", !0),
	yt.fn.dates = s("dates accessor is deprecated. Use date instead.", ft("Date", !0)),
	yt.fn.year = ft("FullYear", !0),
	yt.fn.years = s("years accessor is deprecated. Use year instead.", ft("FullYear", !0)),
	yt.fn.days = yt.fn.day,
	yt.fn.months = yt.fn.month,
	yt.fn.weeks = yt.fn.week,
	yt.fn.isoWeeks = yt.fn.isoWeek,
	yt.fn.quarters = yt.fn.quarter,
	yt.fn.toJSON = yt.fn.toISOString,
	p(yt.duration.fn = h.prototype, {
		_bubble : function () {
			var e,
			t,
			n,
			o = this._milliseconds,
			r = this._days,
			i = this._months,
			s = this._data,
			a = 0;
			s.milliseconds = o % 1e3,
			e = m(o / 1e3),
			s.seconds = e % 60,
			t = m(e / 60),
			s.minutes = t % 60,
			n = m(t / 60),
			s.hours = n % 24,
			r += m(n / 24),
			a = m(mt(r)),
			r -= m(gt(a)),
			i += m(r / 30),
			r %= 30,
			a += m(i / 12),
			i %= 12,
			s.days = r,
			s.months = i,
			s.years = a
		},
		abs : function () {
			return this._milliseconds = Math.abs(this._milliseconds),
			this._days = Math.abs(this._days),
			this._months = Math.abs(this._months),
			this._data.milliseconds = Math.abs(this._data.milliseconds),
			this._data.seconds = Math.abs(this._data.seconds),
			this._data.minutes = Math.abs(this._data.minutes),
			this._data.hours = Math.abs(this._data.hours),
			this._data.months = Math.abs(this._data.months),
			this._data.years = Math.abs(this._data.years),
			this
		},
		weeks : function () {
			return m(this.days() / 7)
		},
		valueOf : function () {
			return this._milliseconds + 864e5 * this._days + this._months % 12 * 2592e6 + 31536e6 * E(this._months / 12)
		},
		humanize : function (e) {
			var t = st(this, !e, this.localeData());
			return e && (t = this.localeData().pastFuture(+this, t)),
			this.localeData().postformat(t)
		},
		add : function (e, t) {
			var n = yt.duration(e, t);
			return this._milliseconds += n._milliseconds,
			this._days += n._days,
			this._months += n._months,
			this._bubble(),
			this
		},
		subtract : function (e, t) {
			var n = yt.duration(e, t);
			return this._milliseconds -= n._milliseconds,
			this._days -= n._days,
			this._months -= n._months,
			this._bubble(),
			this
		},
		get : function (e) {
			return e = k(e),
			this[e.toLowerCase() + "s"]()
		},
		as : function (e) {
			var t,
			n;
			if (e = k(e), t = this._days + this._milliseconds / 864e5, "month" === e || "year" === e)
				return n = this._months + 12 * mt(t), "month" === e ? n : n / 12;
			switch (t += gt(this._months / 12), e) {
			case "week":
				return t / 7;
			case "day":
				return t;
			case "hour":
				return 24 * t;
			case "minute":
				return 24 * t * 60;
			case "second":
				return 24 * t * 60 * 60;
			case "millisecond":
				return 24 * t * 60 * 60 * 1e3;
			default:
				throw new Error("Unknown unit " + e)
			}
		},
		lang : yt.fn.lang,
		locale : yt.fn.locale,
		toIsoString : s("toIsoString() is deprecated. Please use toISOString() instead (notice the capitals)", function () {
			return this.toISOString()
		}),
		toISOString : function () {
			var e = Math.abs(this.years()),
			t = Math.abs(this.months()),
			n = Math.abs(this.days()),
			o = Math.abs(this.hours()),
			r = Math.abs(this.minutes()),
			i = Math.abs(this.seconds() + this.milliseconds() / 1e3);
			return this.asSeconds() ? (this.asSeconds() < 0 ? "-" : "") + "P" + (e ? e + "Y" : "") + (t ? t + "M" : "") + (n ? n + "D" : "") + (o || r || i ? "T" : "") + (o ? o + "H" : "") + (r ? r + "M" : "") + (i ? i + "S" : "") : "P0D"
		},
		localeData : function () {
			return this._locale
		}
	});
	for (wt in rn)
		rn.hasOwnProperty(wt) && vt(wt.toLowerCase());
	yt.duration.fn.asMilliseconds = function () {
		return this.as("ms")
	},
	yt.duration.fn.asSeconds = function () {
		return this.as("s")
	},
	yt.duration.fn.asMinutes = function () {
		return this.as("m")
	},
	yt.duration.fn.asHours = function () {
		return this.as("h")
	},
	yt.duration.fn.asDays = function () {
		return this.as("d")
	},
	yt.duration.fn.asWeeks = function () {
		return this.as("weeks")
	},
	yt.duration.fn.asMonths = function () {
		return this.as("M")
	},
	yt.duration.fn.asYears = function () {
		return this.as("y")
	},
	yt.locale("en", {
		ordinal : function (e) {
			var t = e % 10,
			n = 1 === E(e % 100 / 10) ? "th" : 1 === t ? "st" : 2 === t ? "nd" : 3 === t ? "rd" : "th";
			return e + n
		}
	}),
	yt.defineLocale("zh-cn", {
		months : "\u4e00\u6708_\u4e8c\u6708_\u4e09\u6708_\u56db\u6708_\u4e94\u6708_\u516d\u6708_\u4e03\u6708_\u516b\u6708_\u4e5d\u6708_\u5341\u6708_\u5341\u4e00\u6708_\u5341\u4e8c\u6708".split("_"),
		monthsShort : "1\u6708_2\u6708_3\u6708_4\u6708_5\u6708_6\u6708_7\u6708_8\u6708_9\u6708_10\u6708_11\u6708_12\u6708".split("_"),
		weekdays : "\u661f\u671f\u65e5_\u661f\u671f\u4e00_\u661f\u671f\u4e8c_\u661f\u671f\u4e09_\u661f\u671f\u56db_\u661f\u671f\u4e94_\u661f\u671f\u516d".split("_"),
		weekdaysShort : "\u5468\u65e5_\u5468\u4e00_\u5468\u4e8c_\u5468\u4e09_\u5468\u56db_\u5468\u4e94_\u5468\u516d".split("_"),
		weekdaysMin : "\u65e5_\u4e00_\u4e8c_\u4e09_\u56db_\u4e94_\u516d".split("_"),
		longDateFormat : {
			LT : "Ah\u70b9mm",
			L : "YYYY-MM-DD",
			LL : "YYYY\u5e74MMMD\u65e5",
			LLL : "YYYY\u5e74MMMD\u65e5LT",
			LLLL : "YYYY\u5e74MMMD\u65e5ddddLT",
			l : "YYYY-MM-DD",
			ll : "YYYY\u5e74MMMD\u65e5",
			lll : "YYYY\u5e74MMMD\u65e5LT",
			llll : "YYYY\u5e74MMMD\u65e5ddddLT"
		},
		meridiem : function (e, t) {
			var n = 100 * e + t;
			return 600 > n ? "\u51cc\u6668" : 900 > n ? "\u65e9\u4e0a" : 1130 > n ? "\u4e0a\u5348" : 1230 > n ? "\u4e2d\u5348" : 1800 > n ? "\u4e0b\u5348" : "\u665a\u4e0a"
		},
		calendar : {
			sameDay : function () {
				return 0 === this.minutes() ? "[\u4eca\u5929]Ah[\u70b9\u6574]" : "[\u4eca\u5929]LT"
			},
			nextDay : function () {
				return 0 === this.minutes() ? "[\u660e\u5929]Ah[\u70b9\u6574]" : "[\u660e\u5929]LT"
			},
			lastDay : function () {
				return 0 === this.minutes() ? "[\u6628\u5929]Ah[\u70b9\u6574]" : "[\u6628\u5929]LT"
			},
			nextWeek : function () {
				var e,
				t;
				return e = yt().startOf("week"),
				t = this.unix() - e.unix() >= 604800 ? "[\u4e0b]" : "[\u672c]",
				0 === this.minutes() ? t + "dddAh\u70b9\u6574" : t + "dddAh\u70b9mm"
			},
			lastWeek : function () {
				var e,
				t;
				return e = yt().startOf("week"),
				t = this.unix() < e.unix() ? "[\u4e0a]" : "[\u672c]",
				0 === this.minutes() ? t + "dddAh\u70b9\u6574" : t + "dddAh\u70b9mm"
			},
			sameElse : "LL"
		},
		ordinal : function (e, t) {
			switch (t) {
			case "d":
			case "D":
			case "DDD":
				return e + "\u65e5";
			case "M":
				return e + "\u6708";
			case "w":
			case "W":
				return e + "\u5468";
			default:
				return e
			}
		},
		relativeTime : {
			future : "%s\u5185",
			past : "%s\u524d",
			s : "\u51e0\u79d2",
			m : "1\u5206\u949f",
			mm : "%d\u5206\u949f",
			h : "1\u5c0f\u65f6",
			hh : "%d\u5c0f\u65f6",
			d : "1\u5929",
			dd : "%d\u5929",
			M : "1\u4e2a\u6708",
			MM : "%d\u4e2a\u6708",
			y : "1\u5e74",
			yy : "%d\u5e74"
		},
		week : {
			dow : 1,
			doy : 4
		}
	}),
	n.exports = yt
});
define("js/libs/animo", [], function (t) {
	"use strict";
	function e(t, e, s, n) {
		var o = {
			duration : 1,
			animation : null,
			iterate : 1,
			timing : "linear",
			keep : !1
		};
		this.prefixes = ["", "-moz-", "-o-animation-", "-webkit-"],
		this.element = i(t),
		this.bare = t,
		this.queue = [],
		this.listening = !1;
		var a = "function" == typeof s ? s : n;
		switch (e) {
		case "blur":
			o = {
				amount : 3,
				duration : .5,
				focusAfter : null
			},
			this.options = i.extend(o, s),
			this._blur(a);
			break;
		case "focus":
			this._focus();
			break;
		case "rotate":
			o = {
				degrees : 15,
				duration : .5
			},
			this.options = i.extend(o, s),
			this._rotate(a);
			break;
		case "cleanse":
			this.cleanse();
			break;
		default:
			this.options = i.extend(o, e),
			this.init(a)
		}
	}
	var i = t("core");
	e.prototype = {
		init : function (t) {
			var e = this;
			"[object Array]" === Object.prototype.toString.call(e.options.animation) ? i.merge(e.queue, e.options.animation) : e.queue.push(e.options.animation),
			e.cleanse(),
			e.animate(t)
		},
		animate : function (t) {
			this.element.addClass("animated"),
			this.element.addClass(this.queue[0]),
			this.element.data("animo", this.queue[0]);
			for (var e = this.prefixes.length; e--; )
				this.element.css(this.prefixes[e] + "animation-duration", this.options.duration + "s"), this.element.css(this.prefixes[e] + "animation-iteration-count", this.options.iterate), this.element.css(this.prefixes[e] + "animation-timing-function", this.options.timing);
			var i = this,
			s = t;
			i.queue.length > 1 && (s = null),
			this._end("AnimationEnd", function () {
				i.element.hasClass(i.queue[0]) && (i.options.keep || i.cleanse(), i.queue.shift(), i.queue.length && i.animate(t))
			}, s)
		},
		cleanse : function () {
			this.element.removeClass("animated"),
			this.element.removeClass(this.queue[0]),
			this.element.removeClass(this.element.data("animo"));
			for (var t = this.prefixes.length; t--; )
				this.element.css(this.prefixes[t] + "animation-duration", ""), this.element.css(this.prefixes[t] + "animation-iteration-count", ""), this.element.css(this.prefixes[t] + "animation-timing-function", ""), this.element.css(this.prefixes[t] + "transition", ""), this.element.css(this.prefixes[t] + "transform", ""), this.element.css(this.prefixes[t] + "filter", "")
		},
		_blur : function (t) {
			if (this.element.is("img")) {
				var e = "svg_" + (16777216 * (1 + Math.random()) | 0).toString(16).substring(1),
				s = "filter_" + (16777216 * (1 + Math.random()) | 0).toString(16).substring(1);
				i("body").append('<svg version="1.1" xmlns="http://www.w3.org/2000/svg" id="' + e + '" style="height:0;position:absolute;top:-1000px;"><filter id="' + s + '"><feGaussianBlur stdDeviation="' + this.options.amount + '" /></filter></svg>');
				for (var n = this.prefixes.length; n--; )
					this.element.css(this.prefixes[n] + "filter", "blur(" + this.options.amount + "px)"), this.element.css(this.prefixes[n] + "transition", this.options.duration + "s all linear");
				this.element.css("filter", "url(#" + s + ")"),
				this.element.data("svgid", e)
			} else {
				for (var o = this.element.css("color"), n = this.prefixes.length; n--; )
					this.element.css(this.prefixes[n] + "transition", "all " + this.options.duration + "s linear");
				this.element.css("text-shadow", "0 0 " + this.options.amount + "px " + o),
				this.element.css("color", "transparent")
			}
			this._end("TransitionEnd", null, t);
			var a = this;
			if (this.options.focusAfter)
				var r = window.setTimeout(function () {
						a._focus(),
						r = window.clearTimeout(r)
					}, 1e3 * this.options.focusAfter)
		},
		_focus : function () {
			var t = this.prefixes.length;
			if (this.element.is("img")) {
				for (; t--; )
					this.element.css(this.prefixes[t] + "filter", ""), this.element.css(this.prefixes[t] + "transition", "");
				var e = i("#" + this.element.data("svgid"));
				e.remove()
			} else {
				for (; t--; )
					this.element.css(this.prefixes[t] + "transition", "");
				this.element.css("text-shadow", ""),
				this.element.css("color", "")
			}
		},
		_rotate : function (t) {
			for (var e = this.prefixes.length; e--; )
				this.element.css(this.prefixes[e] + "transition", "all " + this.options.duration + "s linear"), this.element.css(this.prefixes[e] + "transform", "rotate(" + this.options.degrees + "deg)");
			this._end("TransitionEnd", null, t)
		},
		_end : function (t, e, i) {
			var s = this,
			n = t.toLowerCase() + " webkit" + t + " o" + t + " MS" + t;
			this.element.bind(n, function () {
				s.element.unbind(n),
				"function" == typeof e && e(),
				"function" == typeof i && i(s)
			})
		}
	},
	i.fn.animo = function (t, i, s) {
		return this.each(function () {
			new e(this, t, i, s)
		})
	}
});
define("js/libs/extra", [], function (require, exports, module) {
	"use strict";
	var jQuery = require("core");
	return function () {
		var e,
		t,
		n,
		o,
		r,
		i,
		s,
		a,
		l,
		c,
		u,
		d,
		p,
		h,
		f,
		m,
		g,
		v,
		y,
		b,
		w,
		x,
		T,
		S,
		k,
		C,
		E,
		N,
		z,
		L,
		M,
		A,
		H,
		D,
		j,
		O,
		I,
		q,
		P,
		R,
		B,
		_,
		F,
		W,
		$,
		U,
		X,
		Y,
		V,
		J = [].slice,
		Z = {}

		.hasOwnProperty,
		Q = function (e, t) {
			function n() {
				this.constructor = e
			}
			for (var o in t)
				Z.call(t, o) && (e[o] = t[o]);
			return n.prototype = t.prototype,
			e.prototype = new n,
			e.__super__ = t.prototype,
			e
		},
		K = [].indexOf || function (e) {
			for (var t = 0, n = this.length; n > t; t++)
				if (t in this && this[t] === e)
					return t;
			return -1
		};
		for (w = {
				catchupTime : 100,
				initialRate : .03,
				minTime : 250,
				ghostTime : 100,
				maxProgressPerFrame : 20,
				easeFactor : 1.25,
				startOnPageLoad : !0,
				restartOnPushState : !0,
				restartOnRequestAfter : 500,
				target : "body",
				elements : {
					checkInterval : 100,
					selectors : ["body"]
				},
				eventLag : {
					minSamples : 10,
					sampleCount : 3,
					lagThreshold : 3
				},
				ajax : {
					trackMethods : ["GET"],
					trackWebSockets : !0,
					ignoreURLs : []
				}
			}, z = function () {
			var e;
			return null != (e = "undefined" != typeof performance && null !== performance && "function" == typeof performance.now ? performance.now() : void 0) ? e : +new Date
		}, M = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame, b = window.cancelAnimationFrame || window.mozCancelAnimationFrame, null == M && (M = function (e) {
				return setTimeout(e, 50)
			}, b = function (e) {
				return clearTimeout(e)
			}), H = function (e) {
			var t,
			n;
			return t = z(),
			(n = function () {
				var o;
				return o = z() - t,
				o >= 33 ? (t = z(), e(o, function () {
						return M(n)
					})) : setTimeout(n, 33 - o)
			})()
		}, A = function () {
			var e,
			t,
			n;
			return n = arguments[0],
			t = arguments[1],
			e = 3 <= arguments.length ? J.call(arguments, 2) : [],
			"function" == typeof n[t] ? n[t].apply(n, e) : n[t]
		}, x = function () {
			var e,
			t,
			n,
			o,
			r,
			i,
			s;
			for (t = arguments[0], o = 2 <= arguments.length ? J.call(arguments, 1) : [], i = 0, s = o.length; s > i; i++)
				if (n = o[i])
					for (e in n)
						Z.call(n, e)
							 && (r = n[e], null != t[e] && "object" == typeof t[e] && null != r && "object" == typeof r ? x(t[e], r) : t[e] = r);
				return t
			}, g = function (e) {
				var t,
				n,
				o,
				r,
				i;
				for (n = t = 0, r = 0, i = e.length; i > r; r++)
					o = e[r], n += Math.abs(o), t++;
				return n / t
			}, S = function (e, t) {
				var n,
				o,
				r;
				if (null == e && (e = "options"), null == t && (t = !0), r = document.querySelector("[data-pace-" + e + "]")) {
					if (n = r.getAttribute("data-pace-" + e), !t)
						return n;
					try {
						return JSON.parse(n)
					} catch (i) {
						return o = i,
						"undefined" != typeof console && null !== console ? console.error("Error parsing inline pace options", o) : void 0
					}
				}
			}, s = function () {
				function e() {}

				return e.prototype.on = function (e, t, n, o) {
					var r;
					return null == o && (o = !1),
					null == this.bindings && (this.bindings = {}),
					null == (r = this.bindings)[e] && (r[e] = []),
					this.bindings[e].push({
						handler : t,
						ctx : n,
						once : o
					})
				},
				e.prototype.once = function (e, t, n) {
					return this.on(e, t, n, !0)
				},
				e.prototype.off = function (e, t) {
					var n,
					o,
					r;
					if (null != (null != (o = this.bindings) ? o[e] : void 0)) {
						if (null == t)
							return delete this.bindings[e];
						for (n = 0, r = []; n < this.bindings[e].length; )
							r.push(this.bindings[e][n].handler === t ? this.bindings[e].splice(n, 1) : n++);
						return r
					}
				},
				e.prototype.trigger = function () {
					var e,
					t,
					n,
					o,
					r,
					i,
					s,
					a,
					l;
					if (n = arguments[0], e = 2 <= arguments.length ? J.call(arguments, 1) : [], null != (s = this.bindings) ? s[n] : void 0) {
						for (r = 0, l = []; r < this.bindings[n].length; )
							a = this.bindings[n][r], o = a.handler, t = a.ctx, i = a.once, o.apply(null != t ? t : this, e), l.push(i ? this.bindings[n].splice(r, 1) : r++);
						return l
					}
				},
				e
			}
				(), c = window.Pace || {}, window.Pace = c, x(c, s.prototype), L = c.options = x({}, w, window.paceOptions, S()), X = ["ajax", "document", "eventLag", "elements"], F = 0, $ = X.length; $ > F; F++)I = X[F], L[I] === !0 && (L[I] = w[I]);
		l = function (e) {
			function t() {
				return Y = t.__super__.constructor.apply(this, arguments)
			}
			return Q(t, e),
			t
		}
		(Error),
		t = function () {
			function e() {
				this.progress = 0
			}
			return e.prototype.getElement = function () {
				var e;
				if (null == this.el) {
					if (e = document.querySelector(L.target), !e)
						throw new l;
					this.el = document.createElement("div"),
					this.el.className = "pace pace-active",
					document.body.className = document.body.className.replace(/pace-done/g, ""),
					document.body.className += " pace-running",
					this.el.innerHTML = '<div class="pace-progress">\n  <div class="pace-progress-inner"></div>\n</div>\n<div class="pace-activity"></div>',
					null != e.firstChild ? e.insertBefore(this.el, e.firstChild) : e.appendChild(this.el)
				}
				return this.el
			},
			e.prototype.finish = function () {
				var e;
				return e = this.getElement(),
				e.className = e.className.replace("pace-active", ""),
				e.className += " pace-inactive",
				document.body.className = document.body.className.replace("pace-running", ""),
				document.body.className += " pace-done"
			},
			e.prototype.update = function (e) {
				return this.progress = e,
				this.render()
			},
			e.prototype.destroy = function () {
				try {
					this.getElement().parentNode.removeChild(this.getElement())
				} catch (e) {
					l = e
				}
				return this.el = void 0
			},
			e.prototype.render = function () {
				var e,
				t,
				n,
				o,
				r,
				i,
				s;
				if (null == document.querySelector(L.target))
					return !1;
				for (e = this.getElement(), o = "translate3d(" + this.progress + "%, 0, 0)", s = ["webkitTransform", "msTransform", "transform"], r = 0, i = s.length; i > r; r++)
					t = s[r], e.children[0].style[t] = o;
				return (!this.lastRenderedProgress || this.lastRenderedProgress | 0 !== this.progress | 0) && (e.children[0].setAttribute("data-progress-text", "" + (0 | this.progress) + "%"), this.progress >= 100 ? n = "99" : (n = this.progress < 10 ? "0" : "", n += 0 | this.progress), e.children[0].setAttribute("data-progress", "" + n)),
				this.lastRenderedProgress = this.progress
			},
			e.prototype.done = function () {
				return this.progress >= 100
			},
			e
		}
		(),
		a = function () {
			function e() {
				this.bindings = {}

			}
			return e.prototype.trigger = function (e, t) {
				var n,
				o,
				r,
				i,
				s;
				if (null != this.bindings[e]) {
					for (i = this.bindings[e], s = [], o = 0, r = i.length; r > o; o++)
						n = i[o], s.push(n.call(this, t));
					return s
				}
			},
			e.prototype.on = function (e, t) {
				var n;
				return null == (n = this.bindings)[e] && (n[e] = []),
				this.bindings[e].push(t)
			},
			e
		}
		(),
		_ = window.XMLHttpRequest,
		B = window.XDomainRequest,
		R = window.WebSocket,
		T = function (e, t) {
			var n,
			o,
			r;
			r = [];
			for (o in t.prototype)
				try {
					r.push(null == e[o] && "function" != typeof t[o] ? "function" == typeof Object.defineProperty ? Object.defineProperty(e, o, {
							get : function () {
								return t.prototype[o]
							},
							configurable : !0,
							enumerable : !0
						}) : e[o] = t.prototype[o] : void 0)
				} catch (i) {
					n = i
				}
			return r
		},
		E = [],
		c.ignore = function () {
			var e,
			t,
			n;
			return t = arguments[0],
			e = 2 <= arguments.length ? J.call(arguments, 1) : [],
			E.unshift("ignore"),
			n = t.apply(null, e),
			E.shift(),
			n
		},
		c.track = function () {
			var e,
			t,
			n;
			return t = arguments[0],
			e = 2 <= arguments.length ? J.call(arguments, 1) : [],
			E.unshift("track"),
			n = t.apply(null, e),
			E.shift(),
			n
		},
		O = function (e) {
			var t;
			if (null == e && (e = "GET"), "track" === E[0])
				return "force";
			if (!E.length && L.ajax) {
				if ("socket" === e && L.ajax.trackWebSockets)
					return !0;
				if (t = e.toUpperCase(), K.call(L.ajax.trackMethods, t) >= 0)
					return !0
			}
			return !1
		},
		u = function (e) {
			function t() {
				var e,
				n = this;
				t.__super__.constructor.apply(this, arguments),
				e = function (e) {
					var t;
					return t = e.open,
					e.open = function (o, r) {
						return O(o) && n.trigger("request", {
							type : o,
							url : r,
							request : e
						}),
						t.apply(e, arguments)
					}
				},
				window.XMLHttpRequest = function (t) {
					var n;
					return n = new _(t),
					e(n),
					n
				};
				try {
					T(window.XMLHttpRequest, _)
				} catch (o) {}

				if (null != B) {
					window.XDomainRequest = function () {
						var t;
						return t = new B,
						e(t),
						t
					};
					try {
						T(window.XDomainRequest, B)
					} catch (o) {}

				}
				if (null != R && L.ajax.trackWebSockets) {
					window.WebSocket = function (e, t) {
						var o;
						return o = null != t ? new R(e, t) : new R(e),
						O("socket") && n.trigger("request", {
							type : "socket",
							url : e,
							protocols : t,
							request : o
						}),
						o
					};
					try {
						T(window.WebSocket, R)
					} catch (o) {}

				}
			}
			return Q(t, e),
			t
		}
		(a),
		W = null,
		k = function () {
			return null == W && (W = new u),
			W
		},
		j = function (e) {
			var t,
			n,
			o,
			r;
			for (r = L.ajax.ignoreURLs, n = 0, o = r.length; o > n; n++)
				if (t = r[n], "string" == typeof t) {
					if (-1 !== e.indexOf(t))
						return !0
				} else if (t.test(e))
					return !0;
			return !1
		},
		k().on("request", function (t) {
			var n,
			o,
			r,
			i,
			s;
			return i = t.type,
			r = t.request,
			s = t.url,
			j(s) ? void 0 : c.running || L.restartOnRequestAfter === !1 && "force" !== O(i) ? void 0 : (o = arguments, n = L.restartOnRequestAfter || 0, "boolean" == typeof n && (n = 0), setTimeout(function () {
					var t,
					n,
					s,
					a,
					l,
					u;
					if (t = "socket" === i ? r.readyState < 2 : 0 < (a = r.readyState) && 4 > a) {
						for (c.restart(), l = c.sources, u = [], n = 0, s = l.length; s > n; n++) {
							if (I = l[n], I instanceof e) {
								I.watch.apply(I, o);
								break
							}
							u.push(void 0)
						}
						return u
					}
				}, n))
		}),
		e = function () {
			function e() {
				var e = this;
				this.elements = [],
				k().on("request", function () {
					return e.watch.apply(e, arguments)
				})
			}
			return e.prototype.watch = function (e) {
				var t,
				n,
				o,
				r;
				return o = e.type,
				t = e.request,
				r = e.url,
				j(r) ? void 0 : (n = "socket" === o ? new h(t) : new f(t), this.elements.push(n))
			},
			e
		}
		(),
		f = function () {
			function e(e) {
				var t,
				n,
				o,
				r,
				i,
				s,
				a = this;
				if (this.progress = 0, null != window.ProgressEvent)
					for (n = null, e.addEventListener("progress", function (e) {
							return a.progress = e.lengthComputable ? 100 * e.loaded / e.total : a.progress + (100 - a.progress) / 2
						}, !1), s = ["load", "abort", "timeout", "error"], o = 0, r = s.length; r > o; o++)
						t = s[o], e.addEventListener(t, function () {
							return a.progress = 100
						}, !1);
				else
					i = e.onreadystatechange, e.onreadystatechange = function () {
						var t;
						return 0 === (t = e.readyState) || 4 === t ? a.progress = 100 : 3 === e.readyState && (a.progress = 50),
						"function" == typeof i ? i.apply(null, arguments) : void 0
					}
			}
			return e
		}
		(),
		h = function () {
			function e(e) {
				var t,
				n,
				o,
				r,
				i = this;
				for (this.progress = 0, r = ["error", "open"], n = 0, o = r.length; o > n; n++)
					t = r[n], e.addEventListener(t, function () {
						return i.progress = 100
					}, !1)
			}
			return e
		}
		(),
		o = function () {
			function e(e) {
				var t,
				n,
				o,
				i;
				for (null == e && (e = {}), this.elements = [], null == e.selectors && (e.selectors = []), i = e.selectors, n = 0, o = i.length; o > n; n++)
					t = i[n], this.elements.push(new r(t))
			}
			return e
		}
		(),
		r = function () {
			function e(e) {
				this.selector = e,
				this.progress = 0,
				this.check()
			}
			return e.prototype.check = function () {
				var e = this;
				return document.querySelector(this.selector) ? this.done() : setTimeout(function () {
					return e.check()
				}, L.elements.checkInterval)
			},
			e.prototype.done = function () {
				return this.progress = 100
			},
			e
		}
		(),
		n = function () {
			function e() {
				var e,
				t,
				n = this;
				this.progress = null != (t = this.states[document.readyState]) ? t : 100,
				e = document.onreadystatechange,
				document.onreadystatechange = function () {
					return null != n.states[document.readyState] && (n.progress = n.states[document.readyState]),
					"function" == typeof e ? e.apply(null, arguments) : void 0
				}
			}
			return e.prototype.states = {
				loading : 0,
				interactive : 50,
				complete : 100
			},
			e
		}
		(),
		i = function () {
			function e() {
				var e,
				t,
				n,
				o,
				r,
				i = this;
				this.progress = 0,
				e = 0,
				r = [],
				o = 0,
				n = z(),
				t = setInterval(function () {
						var s;
						return s = z() - n - 50,
						n = z(),
						r.push(s),
						r.length > L.eventLag.sampleCount && r.shift(),
						e = g(r),
						++o >= L.eventLag.minSamples && e < L.eventLag.lagThreshold ? (i.progress = 100, clearInterval(t)) : i.progress = 100 * (3 / (e + 3))
					}, 50)
			}
			return e
		}
		(),
		p = function () {
			function e(e) {
				this.source = e,
				this.last = this.sinceLastUpdate = 0,
				this.rate = L.initialRate,
				this.catchup = 0,
				this.progress = this.lastProgress = 0,
				null != this.source && (this.progress = A(this.source, "progress"))
			}
			return e.prototype.tick = function (e, t) {
				var n;
				return null == t && (t = A(this.source, "progress")),
				t >= 100 && (this.done = !0),
				t === this.last ? this.sinceLastUpdate += e : (this.sinceLastUpdate && (this.rate = (t - this.last) / this.sinceLastUpdate), this.catchup = (t - this.progress) / L.catchupTime, this.sinceLastUpdate = 0, this.last = t),
				t > this.progress && (this.progress += this.catchup * e),
				n = 1 - Math.pow(this.progress / 100, L.easeFactor),
				this.progress += n * this.rate * e,
				this.progress = Math.min(this.lastProgress + L.maxProgressPerFrame, this.progress),
				this.progress = Math.max(0, this.progress),
				this.progress = Math.min(100, this.progress),
				this.lastProgress = this.progress,
				this.progress
			},
			e
		}
		(),
		q = null,
		D = null,
		v = null,
		P = null,
		m = null,
		y = null,
		c.running = !1,
		C = function () {
			return L.restartOnPushState ? c.restart() : void 0
		},
		null != window.history.pushState && (U = window.history.pushState, window.history.pushState = function () {
			return C(),
			U.apply(window.history, arguments)
		}),
		null != window.history.replaceState && (V = window.history.replaceState, window.history.replaceState = function () {
			return C(),
			V.apply(window.history, arguments)
		}),
		d = {
			ajax : e,
			elements : o,
			document : n,
			eventLag : i
		},
		(N = function () {
			var e,
			n,
			o,
			r,
			i,
			s,
			a,
			l;
			for (c.sources = q = [], s = ["ajax", "elements", "document", "eventLag"], n = 0, r = s.length; r > n; n++)
				e = s[n], L[e] !== !1 && q.push(new d[e](L[e]));
			for (l = null != (a = L.extraSources) ? a : [], o = 0, i = l.length; i > o; o++)
				I = l[o], q.push(new I(L));
			return c.bar = v = new t,
			D = [],
			P = new p
		})(),
		c.stop = function () {
			return c.trigger("stop"),
			c.running = !1,
			v.destroy(),
			y = !0,
			null != m && ("function" == typeof b && b(m), m = null),
			N()
		},
		c.restart = function () {
			return c.trigger("restart"),
			c.stop(),
			c.start()
		},
		c.go = function () {
			var e;
			return c.running = !0,
			v.render(),
			e = z(),
			y = !1,
			m = H(function (t, n) {
					var o,
					r,
					i,
					s,
					a,
					l,
					u,
					d,
					h,
					f,
					m,
					g,
					b,
					w,
					x,
					T;
					for (d = 100 - v.progress, r = m = 0, i = !0, l = g = 0, w = q.length; w > g; l = ++g)
						for (I = q[l], f = null != D[l] ? D[l] : D[l] = [], a = null != (T = I.elements) ? T : [I], u = b = 0, x = a.length; x > b; u = ++b)
							s = a[u], h = null != f[u] ? f[u] : f[u] = new p(s), i &= h.done, h.done || (r++, m += h.tick(t));
					return o = m / r,
					v.update(P.tick(t, o)),
					v.done() || i || y ? (v.update(100), c.trigger("done"), setTimeout(function () {
							return v.finish(),
							c.running = !1,
							c.trigger("hide")
						}, Math.max(L.ghostTime, Math.max(L.minTime - (z() - e), 0)))) : n()
				})
		},
		c.start = function (e) {
			x(L, e),
			c.running = !0;
			try {
				v.render()
			} catch (t) {
				l = t
			}
			return document.querySelector(".pace") ? (c.trigger("start"), c.go()) : setTimeout(c.start, 50)
		},
		"function" == typeof define && define.amd ? define(["pace"], function () {
			return c
		}) : "object" == typeof exports ? module.exports = c : L.startOnPageLoad && c.start()
	}
	.call(this),
	function (e) {
		var t,
		n,
		o = e.event;
		t = o.special.debouncedresize = {
			setup : function () {
				e(this).on("resize", t.handler)
			},
			teardown : function () {
				e(this).off("resize", t.handler)
			},
			handler : function (e, r) {
				var i = this,
				s = arguments,
				a = function () {
					e.type = "debouncedresize",
					o.dispatch.apply(i, s)
				};
				n && clearTimeout(n),
				r ? a() : n = setTimeout(a, t.threshold)
			},
			threshold : 150
		}
	}
	(jQuery),
	"object" != typeof JSON && (JSON = {}),
	function () {
		function f(e) {
			return 10 > e ? "0" + e : e
		}
		function quote(e) {
			return escapable.lastIndex = 0,
			escapable.test(e) ? '"' + e.replace(escapable, function (e) {
				var t = meta[e];
				return "string" == typeof t ? t : "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4)
			}) + '"' : '"' + e + '"'
		}
		function str(e, t) {
			var n,
			o,
			r,
			i,
			s,
			a = gap,
			l = t[e];
			switch (l && "object" == typeof l && "function" == typeof l.toJSON && (l = l.toJSON(e)), "function" == typeof rep && (l = rep.call(t, e, l)), typeof l) {
			case "string":
				return quote(l);
			case "number":
				return isFinite(l) ? String(l) : "null";
			case "boolean":
			case "null":
				return String(l);
			case "object":
				if (!l)
					return "null";
				if (gap += indent, s = [], "[object Array]" === Object.prototype.toString.apply(l)) {
					for (i = l.length, n = 0; i > n; n += 1)
						s[n] = str(n, l) || "null";
					return r = 0 === s.length ? "[]" : gap ? "[\n" + gap + s.join(",\n" + gap) + "\n" + a + "]" : "[" + s.join(",") + "]",
					gap = a,
					r
				}
				if (rep && "object" == typeof rep)
					for (i = rep.length, n = 0; i > n; n += 1)
						"string" == typeof rep[n] && (o = rep[n], r = str(o, l), r && s.push(quote(o) + (gap ? ": " : ":") + r));
				else
					for (o in l)
						Object.prototype.hasOwnProperty.call(l, o) && (r = str(o, l), r && s.push(quote(o) + (gap ? ": " : ":") + r));
				return r = 0 === s.length ? "{}" : gap ? "{\n" + gap + s.join(",\n" + gap) + "\n" + a + "}" : "{" + s.join(",") + "}",
				gap = a,
				r
			}
		}
		"function" != typeof Date.prototype.toJSON && (Date.prototype.toJSON = function () {
			return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + f(this.getUTCMonth() + 1) + "-" + f(this.getUTCDate()) + "T" + f(this.getUTCHours()) + ":" + f(this.getUTCMinutes()) + ":" + f(this.getUTCSeconds()) + "Z" : null
		}, String.prototype.toJSON = Number.prototype.toJSON = Boolean.prototype.toJSON = function () {
			return this.valueOf()
		});
		var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
		escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
		gap,
		indent,
		meta = {
			"\b" : "\\b",
			"	" : "\\t",
			"\n" : "\\n",
			"\f" : "\\f",
			"\r" : "\\r",
			'"' : '\\"',
			"\\" : "\\\\"
		},
		rep;
		"function" != typeof JSON.stringify && (JSON.stringify = function (e, t, n) {
			var o;
			if (gap = "", indent = "", "number" == typeof n)
				for (o = 0; n > o; o += 1)
					indent += " ";
			else
				"string" == typeof n && (indent = n);
			if (rep = t, !t || "function" == typeof t || "object" == typeof t && "number" == typeof t.length)
				return str("", {
					"" : e
				});
			throw new Error("JSON.stringify")
		}),
		"function" != typeof JSON.parse && (JSON.parse = function (text, reviver) {
			function walk(e, t) {
				var n,
				o,
				r = e[t];
				if (r && "object" == typeof r)
					for (n in r)
						Object.prototype.hasOwnProperty.call(r, n) && (o = walk(r, n), void 0 !== o ? r[n] = o : delete r[n]);
				return reviver.call(e, t, r)
			}
			var j;
			if (text = String(text), cx.lastIndex = 0, cx.test(text) && (text = text.replace(cx, function (e) {
							return "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4)
						})), /^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "")))
				return j = eval("(" + text + ")"), "function" == typeof reviver ? walk({
					"" : j
				}, "") : j;
			throw new SyntaxError("JSON.parse")
		})
	}
	(),
	function (e, t) {
		var n = e.History = e.History || {},
		o = e.jQuery;
		if ("undefined" != typeof n.Adapter)
			throw new Error("History.js Adapter has already been loaded...");
		n.Adapter = {
			bind : function (e, t, n) {
				o(e).bind(t, n)
			},
			trigger : function (e, t, n) {
				o(e).trigger(t, n)
			},
			extractEventData : function (e, n, o) {
				var r = n && n.originalEvent && n.originalEvent[e] || o && o[e] || t;
				return r
			},
			onDomLoad : function (e) {
				o(e)
			}
		},
		"undefined" != typeof n.init && n.init()
	}
	(window),
	function (e) {
		var t = e.document,
		n = e.setTimeout || n,
		o = e.clearTimeout || o,
		r = e.setInterval || r,
		i = e.History = e.History || {};
		if ("undefined" != typeof i.initHtml4)
			throw new Error("History.js HTML4 Support has already been loaded...");
		i.initHtml4 = function () {
			return "undefined" != typeof i.initHtml4.initialized ? !1 : (i.initHtml4.initialized = !0, i.enabled = !0, i.savedHashes = [], i.isLastHash = function (e) {
				var t,
				n = i.getHashByIndex();
				return t = e === n
			}, i.isHashEqual = function (e, t) {
				return e = encodeURIComponent(e).replace(/%25/g, "%"),
				t = encodeURIComponent(t).replace(/%25/g, "%"),
				e === t
			}, i.saveHash = function (e) {
				return i.isLastHash(e) ? !1 : (i.savedHashes.push(e), !0)
			}, i.getHashByIndex = function (e) {
				var t = null;
				return t = "undefined" == typeof e ? i.savedHashes[i.savedHashes.length - 1] : 0 > e ? i.savedHashes[i.savedHashes.length + e] : i.savedHashes[e]
			}, i.discardedHashes = {}, i.discardedStates = {}, i.discardState = function (e, t, n) {
				var o,
				r = i.getHashByState(e);
				return o = {
					discardedState : e,
					backState : n,
					forwardState : t
				},
				i.discardedStates[r] = o,
				!0
			}, i.discardHash = function (e, t, n) {
				var o = {
					discardedHash : e,
					backState : n,
					forwardState : t
				};
				return i.discardedHashes[e] = o,
				!0
			}, i.discardedState = function (e) {
				var t,
				n = i.getHashByState(e);
				return t = i.discardedStates[n] || !1
			}, i.discardedHash = function (e) {
				var t = i.discardedHashes[e] || !1;
				return t
			}, i.recycleState = function (e) {
				var t = i.getHashByState(e);
				return i.discardedState(e) && delete i.discardedStates[t],
				!0
			}, i.emulated.hashChange && (i.hashChangeInit = function () {
					i.checkerFunction = null;
					var n,
					o,
					s,
					a,
					l = "",
					c = Boolean(i.getHash());
					return i.isInternetExplorer() ? (n = "historyjs-iframe", o = t.createElement("iframe"), o.setAttribute("id", n), o.setAttribute("src", "#"), o.style.display = "none", t.body.appendChild(o), o.contentWindow.document.open(), o.contentWindow.document.close(), s = "", a = !1, i.checkerFunction = function () {
						if (a)
							return !1;
						a = !0;
						var t = i.getHash(),
						n = i.getHash(o.contentWindow.document);
						return t !== l ? (l = t, n !== t && (s = n = t, o.contentWindow.document.open(), o.contentWindow.document.close(), o.contentWindow.document.location.hash = i.escapeHash(t)), i.Adapter.trigger(e, "hashchange")) : n !== s && (s = n, c && "" === n ? i.back() : i.setHash(n, !1)),
						a = !1,
						!0
					}) : i.checkerFunction = function () {
						var t = i.getHash() || "";
						return t !== l && (l = t, i.Adapter.trigger(e, "hashchange")),
						!0
					},
					i.intervalList.push(r(i.checkerFunction, i.options.hashChangeInterval)),
					!0
				}, i.Adapter.onDomLoad(i.hashChangeInit)), i.emulated.pushState && (i.onHashChange = function (t) {
					var n,
					o = t && t.newURL || i.getLocationHref(),
					r = i.getHashByUrl(o),
					s = null,
					a = null;
					return i.isLastHash(r) ? (i.busy(!1), !1) : (i.doubleCheckComplete(), i.saveHash(r), r && i.isTraditionalAnchor(r) ? (i.Adapter.trigger(e, "anchorchange"), i.busy(!1), !1) : (s = i.extractState(i.getFullUrl(r || i.getLocationHref()), !0), i.isLastSavedState(s) ? (i.busy(!1), !1) : (a = i.getHashByState(s), n = i.discardedState(s), n ? (i.getHashByIndex(-2) === i.getHashByState(n.forwardState) ? i.back(!1) : i.forward(!1), !1) : (i.pushState(s.data, s.title, encodeURI(s.url), !1), !0))))
				}, i.Adapter.bind(e, "hashchange", i.onHashChange), i.pushState = function (t, n, o, r) {
					if (o = encodeURI(o).replace(/%25/g, "%"), i.getHashByUrl(o))
						throw new Error("History.js does not support states with fragment-identifiers (hashes/anchors).");
					if (r !== !1 && i.busy())
						return i.pushQueue({
							scope : i,
							callback : i.pushState,
							args : arguments,
							queue : r
						}), !1;
					i.busy(!0);
					var s = i.createStateObject(t, n, o),
					a = i.getHashByState(s),
					l = i.getState(!1),
					c = i.getHashByState(l),
					u = i.getHash(),
					d = i.expectedStateId == s.id;
					return i.storeState(s),
					i.expectedStateId = s.id,
					i.recycleState(s),
					i.setTitle(s),
					a === c ? (i.busy(!1), !1) : (i.saveState(s), d || i.Adapter.trigger(e, "statechange"), !i.isHashEqual(a, u) && !i.isHashEqual(a, i.getShortUrl(i.getLocationHref())) && i.setHash(a, !1), i.busy(!1), !0)
				}, i.replaceState = function (t, n, o, r) {
					if (o = encodeURI(o).replace(/%25/g, "%"), i.getHashByUrl(o))
						throw new Error("History.js does not support states with fragment-identifiers (hashes/anchors).");
					if (r !== !1 && i.busy())
						return i.pushQueue({
							scope : i,
							callback : i.replaceState,
							args : arguments,
							queue : r
						}), !1;
					i.busy(!0);
					var s = i.createStateObject(t, n, o),
					a = i.getHashByState(s),
					l = i.getState(!1),
					c = i.getHashByState(l),
					u = i.getStateByIndex(-2);
					return i.discardState(l, s, u),
					a === c ? (i.storeState(s), i.expectedStateId = s.id, i.recycleState(s), i.setTitle(s), i.saveState(s), i.Adapter.trigger(e, "statechange"), i.busy(!1)) : i.pushState(s.data, s.title, s.url, !1),
					!0
				}), i.emulated.pushState && i.getHash() && !i.emulated.hashChange && i.Adapter.onDomLoad(function () {
					i.Adapter.trigger(e, "hashchange")
				}), void 0)
		},
		"undefined" != typeof i.init && i.init()
	}
	(window),
	function (e, t) {
		var n = e.console || t,
		o = e.document,
		r = e.navigator,
		i = !1,
		s = e.setTimeout,
		a = e.clearTimeout,
		l = e.setInterval,
		c = e.clearInterval,
		u = e.JSON,
		d = e.alert,
		p = e.History = e.History || {},
		h = e.history;
		try {
			i = e.sessionStorage,
			i.setItem("TEST", "1"),
			i.removeItem("TEST")
		} catch (f) {
			i = !1
		}
		if (u.stringify = u.stringify || u.encode, u.parse = u.parse || u.decode, "undefined" != typeof p.init)
			throw new Error("History.js Core has already been loaded...");
		p.init = function () {
			return "undefined" == typeof p.Adapter ? !1 : ("undefined" != typeof p.initCore && p.initCore(), "undefined" != typeof p.initHtml4 && p.initHtml4(), !0)
		},
		p.initCore = function () {
			if ("undefined" != typeof p.initCore.initialized)
				return !1;
			if (p.initCore.initialized = !0, p.options = p.options || {}, p.options.hashChangeInterval = p.options.hashChangeInterval || 100, p.options.safariPollInterval = p.options.safariPollInterval || 500, p.options.doubleCheckInterval = p.options.doubleCheckInterval || 500, p.options.disableSuid = p.options.disableSuid || !1, p.options.storeInterval = p.options.storeInterval || 1e3, p.options.busyDelay = p.options.busyDelay || 250, p.options.debug = p.options.debug || !1, p.options.initialTitle = p.options.initialTitle || o.title, p.options.html4Mode = p.options.html4Mode || !1, p.options.delayInit = p.options.delayInit || !1, p.intervalList = [], p.clearAllIntervals = function () {
				var e,
				t = p.intervalList;
				if ("undefined" != typeof t && null !== t) {
					for (e = 0; e < t.length; e++)
						c(t[e]);
						p.intervalList = null
					}
				}, p.debug = function () {
					(p.options.debug || !1) && p.log.apply(p, arguments)
				}, p.log = function () {
					var e,
					t,
					r,
					i,
					s,
					a = "undefined" != typeof n && "undefined" != typeof n.log && "undefined" != typeof n.log.apply,
					l = o.getElementById("log");
					for (a ? (i = Array.prototype.slice.call(arguments), e = i.shift(), "undefined" != typeof n.debug ? n.debug.apply(n, [e, i]) : n.log.apply(n, [e, i])) : e = "\n" + arguments[0] + "\n", t = 1, r = arguments.length; r > t; ++t) {
						if (s = arguments[t], "object" == typeof s && "undefined" != typeof u)
							try {
								s = u.stringify(s)
							} catch (c) {}

						e += "\n" + s + "\n"
					}
					return l ? (l.value += e + "\n-----\n", l.scrollTop = l.scrollHeight - l.clientHeight) : a || d(e),
					!0
				}, p.getInternetExplorerMajorVersion = function () {
					var e = p.getInternetExplorerMajorVersion.cached = "undefined" != typeof p.getInternetExplorerMajorVersion.cached ? p.getInternetExplorerMajorVersion.cached : function () {
						for (var e = 3, t = o.createElement("div"), n = t.getElementsByTagName("i"); (t.innerHTML = "<!--[if gt IE " + ++e + "]><i></i><![endif]-->") && n[0]; );
						return e > 4 ? e : !1
					}
					();
					return e
				}, p.isInternetExplorer = function () {
					var e = p.isInternetExplorer.cached = "undefined" != typeof p.isInternetExplorer.cached ? p.isInternetExplorer.cached : Boolean(p.getInternetExplorerMajorVersion());
					return e
				}, p.emulated = p.options.html4Mode ? {
						pushState : !0,
						hashChange : !0
					}
					 : {
					pushState : !Boolean(e.history && e.history.pushState && e.history.replaceState && !/ Mobile\/([1-7][a-z]|(8([abcde]|f(1[0-8]))))/i.test(r.userAgent) && !/AppleWebKit\/5([0-2]|3[0-2])/i.test(r.userAgent)),
					hashChange : Boolean(!("onhashchange" in e || "onhashchange" in o) || p.isInternetExplorer() && p.getInternetExplorerMajorVersion() < 8)
				}, p.enabled = !p.emulated.pushState, p.bugs = {
						setHash : Boolean(!p.emulated.pushState && "Apple Computer, Inc." === r.vendor && /AppleWebKit\/5([0-2]|3[0-3])/.test(r.userAgent)),
						safariPoll : Boolean(!p.emulated.pushState && "Apple Computer, Inc." === r.vendor && /AppleWebKit\/5([0-2]|3[0-3])/.test(r.userAgent)),
						ieDoubleCheck : Boolean(p.isInternetExplorer() && p.getInternetExplorerMajorVersion() < 8),
						hashEscape : Boolean(p.isInternetExplorer() && p.getInternetExplorerMajorVersion() < 7)
					}, p.isEmptyObject = function (e) {
					for (var t in e)
						if (e.hasOwnProperty(t))
							return !1;
					return !0
				}, p.cloneObject = function (e) {
					var t,
					n;
					return e ? (t = u.stringify(e), n = u.parse(t)) : n = {},
					n
				}, p.getRootUrl = function () {
					var e = o.location.protocol + "//" + (o.location.hostname || o.location.host);
					return o.location.port && (e += ":" + o.location.port),
					e += "/"
				}, p.getBaseHref = function () {
					var e = o.getElementsByTagName("base"),
					t = null,
					n = "";
					return 1 === e.length && (t = e[0], n = t.href.replace(/[^\/]+$/, "")),
					n = n.replace(/\/+$/, ""),
					n && (n += "/"),
					n
				}, p.getBaseUrl = function () {
					var e = p.getBaseHref() || p.getBasePageUrl() || p.getRootUrl();
					return e
				}, p.getPageUrl = function () {
					var e,
					t = p.getState(!1, !1),
					n = (t || {}).url || p.getLocationHref();
					return e = n.replace(/\/+$/, "").replace(/[^\/]+$/, function (e) {
							return /\./.test(e) ? e : e + "/"
						})
				}, p.getBasePageUrl = function () {
					var e = p.getLocationHref().replace(/[#\?].*/, "").replace(/[^\/]+$/, function (e) {
							return /[^\/]$/.test(e) ? "" : e
						}).replace(/\/+$/, "") + "/";
					return e
				}, p.getFullUrl = function (e, t) {
					var n = e,
					o = e.substring(0, 1);
					return t = "undefined" == typeof t ? !0 : t,
					/[a-z]+\:\/\//.test(e) || (n = "/" === o ? p.getRootUrl() + e.replace(/^\/+/, "") : "#" === o ? p.getPageUrl().replace(/#.*/, "") + e : "?" === o ? p.getPageUrl().replace(/[\?#].*/, "") + e : t ? p.getBaseUrl() + e.replace(/^(\.\/)+/, "") : p.getBasePageUrl() + e.replace(/^(\.\/)+/, "")),
					n.replace(/\#$/, "")
				}, p.getShortUrl = function (e) {
					var t = e,
					n = p.getBaseUrl(),
					o = p.getRootUrl();
					return p.emulated.pushState && (t = t.replace(n, "")),
					t = t.replace(o, "/"),
					p.isTraditionalAnchor(t) && (t = "./" + t),
					t = t.replace(/^(\.\/)+/g, "./").replace(/\#$/, "")
				}, p.getLocationHref = function (e) {
					return e = e || o,
					e.URL === e.location.href ? e.location.href : e.location.href === decodeURIComponent(e.URL) ? e.URL : e.location.hash && decodeURIComponent(e.location.href.replace(/^[^#]+/, "")) === e.location.hash ? e.location.href : -1 == e.URL.indexOf("#") && -1 != e.location.href.indexOf("#") ? e.location.href : e.URL || e.location.href
				}, p.store = {}, p.idToState = p.idToState || {}, p.stateToId = p.stateToId || {}, p.urlToId = p.urlToId || {}, p.storedStates = p.storedStates || [], p.savedStates = p.savedStates || [], p.normalizeStore = function () {
					p.store.idToState = p.store.idToState || {},
					p.store.urlToId = p.store.urlToId || {},
					p.store.stateToId = p.store.stateToId || {}

				}, p.getState = function (e, t) {
					"undefined" == typeof e && (e = !0),
					"undefined" == typeof t && (t = !0);
					var n = p.getLastSavedState();
					return !n && t && (n = p.createStateObject()),
					e && (n = p.cloneObject(n), n.url = n.cleanUrl || n.url),
					n
				}, p.getIdByState = function (e) {
					var t,
					n = p.extractId(e.url);
					if (!n)
						if (t = p.getStateString(e), "undefined" != typeof p.stateToId[t])
							n = p.stateToId[t];
						else if ("undefined" != typeof p.store.stateToId[t])
							n = p.store.stateToId[t];
						else {
							for (; n = (new Date).getTime() + String(Math.random()).replace(/\D/g, ""), "undefined" != typeof p.idToState[n] || "undefined" != typeof p.store.idToState[n]; );
							p.stateToId[t] = n,
							p.idToState[n] = e
						}
					return n
				}, p.normalizeState = function (e) {
					var t,
					n;
					return e && "object" == typeof e || (e = {}),
					"undefined" != typeof e.normalized ? e : (e.data && "object" == typeof e.data || (e.data = {}), t = {}, t.normalized = !0, t.title = e.title || "", t.url = p.getFullUrl(e.url ? e.url : p.getLocationHref()), t.hash = p.getShortUrl(t.url), t.data = p.cloneObject(e.data), t.id = p.getIdByState(t), t.cleanUrl = t.url.replace(/\??\&_suid.*/, ""), t.url = t.cleanUrl, n = !p.isEmptyObject(t.data), (t.title || n) && p.options.disableSuid !== !0 && (t.hash = p.getShortUrl(t.url).replace(/\??\&_suid.*/, ""), /\?/.test(t.hash) || (t.hash += "?"), t.hash += "&_suid=" + t.id), t.hashedUrl = p.getFullUrl(t.hash), (p.emulated.pushState || p.bugs.safariPoll) && p.hasUrlDuplicate(t) && (t.url = t.hashedUrl), t)
				}, p.createStateObject = function (e, t, n) {
					var o = {
						data : e,
						title : t,
						url : n
					};
					return o = p.normalizeState(o)
				}, p.getStateById = function (e) {
					e = String(e);
					var n = p.idToState[e] || p.store.idToState[e] || t;
					return n
				}, p.getStateString = function (e) {
					var t,
					n,
					o;
					return t = p.normalizeState(e),
					n = {
						data : t.data,
						title : e.title,
						url : e.url
					},
					o = u.stringify(n)
				}, p.getStateId = function (e) {
					var t,
					n;
					return t = p.normalizeState(e),
					n = t.id
				}, p.getHashByState = function (e) {
					var t,
					n;
					return t = p.normalizeState(e),
					n = t.hash
				}, p.extractId = function (e) {
					var t,
					n,
					o,
					r;
					return r = -1 != e.indexOf("#") ? e.split("#")[0] : e,
					n = /(.*)\&_suid=([0-9]+)$/.exec(r),
					o = n ? n[1] || e : e,
					t = n ? String(n[2] || "") : "",
					t || !1
				}, p.isTraditionalAnchor = function (e) {
					var t = !/[\/\?\.]/.test(e);
					return t
				}, p.extractState = function (e, t) {
					var n,
					o,
					r = null;
					return t = t || !1,
					n = p.extractId(e),
					n && (r = p.getStateById(n)),
					r || (o = p.getFullUrl(e), n = p.getIdByUrl(o) || !1, n && (r = p.getStateById(n)), !r && t && !p.isTraditionalAnchor(e) && (r = p.createStateObject(null, null, o))),
					r
				}, p.getIdByUrl = function (e) {
					var n = p.urlToId[e] || p.store.urlToId[e] || t;
					return n
				}, p.getLastSavedState = function () {
					return p.savedStates[p.savedStates.length - 1] || t
				}, p.getLastStoredState = function () {
					return p.storedStates[p.storedStates.length - 1] || t
				}, p.hasUrlDuplicate = function (e) {
					var t,
					n = !1;
					return t = p.extractState(e.url),
					n = t && t.id !== e.id
				}, p.storeState = function (e) {
					return p.urlToId[e.url] = e.id,
					p.storedStates.push(p.cloneObject(e)),
					e
				}, p.isLastSavedState = function (e) {
					var t,
					n,
					o,
					r = !1;
					return p.savedStates.length && (t = e.id, n = p.getLastSavedState(), o = n.id, r = t === o),
					r
				}, p.saveState = function (e) {
					return p.isLastSavedState(e) ? !1 : (p.savedStates.push(p.cloneObject(e)), !0)
				}, p.getStateByIndex = function (e) {
					var t = null;
					return t = "undefined" == typeof e ? p.savedStates[p.savedStates.length - 1] : 0 > e ? p.savedStates[p.savedStates.length + e] : p.savedStates[e]
				}, p.getCurrentIndex = function () {
					var e = null;
					return e = p.savedStates.length < 1 ? 0 : p.savedStates.length - 1
				}, p.getHash = function (e) {
					var t,
					n = p.getLocationHref(e);
					return t = p.getHashByUrl(n)
				}, p.unescapeHash = function (e) {
					var t = p.normalizeHash(e);
					return t = decodeURIComponent(t)
				}, p.normalizeHash = function (e) {
					var t = e.replace(/[^#]*#/, "").replace(/#.*/, "");
					return t
				}, p.setHash = function (e, t) {
					var n,
					r;
					return t !== !1 && p.busy() ? (p.pushQueue({
							scope : p,
							callback : p.setHash,
							args : arguments,
							queue : t
						}), !1) : (p.busy(!0), n = p.extractState(e, !0), n && !p.emulated.pushState ? p.pushState(n.data, n.title, n.url, !1) : p.getHash() !== e && (p.bugs.setHash ? (r = p.getPageUrl(), p.pushState(null, null, r + "#" + e, !1)) : o.location.hash = e), p)
				}, p.escapeHash = function (t) {
					var n = p.normalizeHash(t);
					return n = e.encodeURIComponent(n),
					p.bugs.hashEscape || (n = n.replace(/\%21/g, "!").replace(/\%26/g, "&").replace(/\%3D/g, "=").replace(/\%3F/g, "?")),
					n
				}, p.getHashByUrl = function (e) {
					var t = String(e).replace(/([^#]*)#?([^#]*)#?(.*)/, "$2");
					return t = p.unescapeHash(t)
				}, p.setTitle = function (e) {
					var t,
					n = e.title;
					n || (t = p.getStateByIndex(0), t && t.url === e.url && (n = t.title || p.options.initialTitle));
					try {
						o.getElementsByTagName("title")[0].innerHTML = n.replace("<", "&lt;").replace(">", "&gt;").replace(" & ", " &amp; ")
					} catch (r) {}

					return o.title = n,
					p
				}, p.queues = [], p.busy = function (e) {
					if ("undefined" != typeof e ? p.busy.flag = e : "undefined" == typeof p.busy.flag && (p.busy.flag = !1), !p.busy.flag) {
						a(p.busy.timeout);
						var t = function () {
							var e,
							n,
							o;
							if (!p.busy.flag)
								for (e = p.queues.length - 1; e >= 0; --e)
									n = p.queues[e], 0 !== n.length && (o = n.shift(), p.fireQueueItem(o), p.busy.timeout = s(t, p.options.busyDelay))
						};
						p.busy.timeout = s(t, p.options.busyDelay)
					}
					return p.busy.flag
				}, p.busy.flag = !1, p.fireQueueItem = function (e) {
					return e.callback.apply(e.scope || p, e.args || [])
				}, p.pushQueue = function (e) {
					return p.queues[e.queue || 0] = p.queues[e.queue || 0] || [],
					p.queues[e.queue || 0].push(e),
					p
				}, p.queue = function (e, t) {
					return "function" == typeof e && (e = {
							callback : e
						}),
					"undefined" != typeof t && (e.queue = t),
					p.busy() ? p.pushQueue(e) : p.fireQueueItem(e),
					p
				}, p.clearQueue = function () {
					return p.busy.flag = !1,
					p.queues = [],
					p
				}, p.stateChanged = !1, p.doubleChecker = !1, p.doubleCheckComplete = function () {
					return p.stateChanged = !0,
					p.doubleCheckClear(),
					p
				}, p.doubleCheckClear = function () {
					return p.doubleChecker && (a(p.doubleChecker), p.doubleChecker = !1),
					p
				}, p.doubleCheck = function (e) {
					return p.stateChanged = !1,
					p.doubleCheckClear(),
					p.bugs.ieDoubleCheck && (p.doubleChecker = s(function () {
								return p.doubleCheckClear(),
								p.stateChanged || e(),
								!0
							}, p.options.doubleCheckInterval)),
					p
				}, p.safariStatePoll = function () {
					var t,
					n = p.extractState(p.getLocationHref());
					return p.isLastSavedState(n) ? void 0 : (t = n, t || (t = p.createStateObject()), p.Adapter.trigger(e, "popstate"), p)
				}, p.back = function (e) {
					return e !== !1 && p.busy() ? (p.pushQueue({
							scope : p,
							callback : p.back,
							args : arguments,
							queue : e
						}), !1) : (p.busy(!0), p.doubleCheck(function () {
							p.back(!1)
						}), h.go(-1), !0)
				}, p.forward = function (e) {
					return e !== !1 && p.busy() ? (p.pushQueue({
							scope : p,
							callback : p.forward,
							args : arguments,
							queue : e
						}), !1) : (p.busy(!0), p.doubleCheck(function () {
							p.forward(!1)
						}), h.go(1), !0)
				}, p.go = function (e, t) {
					var n;
					if (e > 0)
						for (n = 1; e >= n; ++n)
							p.forward(t);
					else {
						if (!(0 > e))
							throw new Error("History.go: History.go requires a positive or negative integer passed.");
						for (n = -1; n >= e; --n)
							p.back(t)
					}
					return p
				}, p.emulated.pushState) {
					var f = function () {};
					p.pushState = p.pushState || f,
					p.replaceState = p.replaceState || f
				}
			else
				p.onPopState = function (t, n) {
					var o,
					r,
					i = !1,
					s = !1;
					return p.doubleCheckComplete(),
					o = p.getHash(),
					o ? (r = p.extractState(o || p.getLocationHref(), !0), r ? p.replaceState(r.data, r.title, r.url, !1) : (p.Adapter.trigger(e, "anchorchange"), p.busy(!1)), p.expectedStateId = !1, !1) : (i = p.Adapter.extractEventData("state", t, n) || !1, s = i ? p.getStateById(i) : p.expectedStateId ? p.getStateById(p.expectedStateId) : p.extractState(p.getLocationHref()), s || (s = p.createStateObject(null, null, p.getLocationHref())), p.expectedStateId = !1, p.isLastSavedState(s) ? (p.busy(!1), !1) : (p.storeState(s), p.saveState(s), p.setTitle(s), p.Adapter.trigger(e, "statechange"), p.busy(!1), !0))
				},
			p.Adapter.bind(e, "popstate", p.onPopState),
			p.pushState = function (t, n, o, r) {
				if (p.getHashByUrl(o) && p.emulated.pushState)
					throw new Error("History.js does not support states with fragement-identifiers (hashes/anchors).");
				if (r !== !1 && p.busy())
					return p.pushQueue({
						scope : p,
						callback : p.pushState,
						args : arguments,
						queue : r
					}), !1;
				p.busy(!0);
				var i = p.createStateObject(t, n, o);
				return p.isLastSavedState(i) ? p.busy(!1) : (p.storeState(i), p.expectedStateId = i.id, h.pushState(i.id, i.title, i.url), p.Adapter.trigger(e, "popstate")),
				!0
			},
			p.replaceState = function (t, n, o, r) {
				if (p.getHashByUrl(o) && p.emulated.pushState)
					throw new Error("History.js does not support states with fragement-identifiers (hashes/anchors).");
				if (r !== !1 && p.busy())
					return p.pushQueue({
						scope : p,
						callback : p.replaceState,
						args : arguments,
						queue : r
					}), !1;
				p.busy(!0);
				var i = p.createStateObject(t, n, o);
				return p.isLastSavedState(i) ? p.busy(!1) : (p.storeState(i), p.expectedStateId = i.id, h.replaceState(i.id, i.title, i.url), p.Adapter.trigger(e, "popstate")),
				!0
			};
			if (i) {
				try {
					p.store = u.parse(i.getItem("History.store")) || {}

				} catch (m) {
					p.store = {}

				}
				p.normalizeStore()
			} else
				p.store = {},
			p.normalizeStore();
			p.Adapter.bind(e, "unload", p.clearAllIntervals),
			p.saveState(p.storeState(p.extractState(p.getLocationHref(), !0))),
			i && (p.onUnload = function () {
				var e,
				t,
				n;
				try {
					e = u.parse(i.getItem("History.store")) || {}

				} catch (o) {
					e = {}

				}
				e.idToState = e.idToState || {},
				e.urlToId = e.urlToId || {},
				e.stateToId = e.stateToId || {};
				for (t in p.idToState)
					p.idToState.hasOwnProperty(t) && (e.idToState[t] = p.idToState[t]);
				for (t in p.urlToId)
					p.urlToId.hasOwnProperty(t) && (e.urlToId[t] = p.urlToId[t]);
				for (t in p.stateToId)
					p.stateToId.hasOwnProperty(t) && (e.stateToId[t] = p.stateToId[t]);
				p.store = e,
				p.normalizeStore(),
				n = u.stringify(e);
				try {
					i.setItem("History.store", n)
				} catch (r) {
					if (r.code !== DOMException.QUOTA_EXCEEDED_ERR)
						throw r;
					i.length && (i.removeItem("History.store"), i.setItem("History.store", n))
				}
			}, p.intervalList.push(l(p.onUnload, p.options.storeInterval)), p.Adapter.bind(e, "beforeunload", p.onUnload), p.Adapter.bind(e, "unload", p.onUnload)),
			p.emulated.pushState || (p.bugs.safariPoll && p.intervalList.push(l(p.safariStatePoll, p.options.safariPollInterval)), ("Apple Computer, Inc." === r.vendor || "Mozilla" === (r.appCodeName || "")) && (p.Adapter.bind(e, "hashchange", function () {
						p.Adapter.trigger(e, "popstate")
					}), p.getHash() && p.Adapter.onDomLoad(function () {
						p.Adapter.trigger(e, "hashchange")
					})))
		},
		(!p.options || !p.options.delayInit) && p.init()
	}
	(window),
	this
});
define("js/mods/script", [], function (require, exports, module) {
	"use strict";
	var debug = window.xdebug,
	$ = require("core"),
	win = $(window),
	body = $("body"),
	moment = require("../libs/moment.js"),
	resizeHandle = null,
	momentHandle = {},
	sClass = {
		CUR_POST : "current-selected-post"
	},
	mClass = {
		SIDE_BAR : "#m-sidebar",
		POST_MOD : "#m-post",
		POST_LIST : "#m-post-list",
		POST_CONTAINER : ".m-post-container"
	},
	api = {
		niceScrollPostList : function () {
			$(function () {
				$(mClass.POST_LIST).niceScroll({
					touchbehavior : !0,
					cursoropacitymax : 0,
					bouncescroll : !0,
					cursorcolor : "#000",
					railpadding : {
						top : 0,
						right : 2,
						left : 0,
						bottom : 0
					},
					grabcursorenabled : !1,
					autohidemode : !0
				})
			})
		},
		header : function () {
			$(function () {
				$(mClass.SIDE_BAR).animo({
					animation : "fadeIn",
					duration : .7,
					keep : !0,
					timing : "ease-in-out"
				}, function () {
					api.postList();
					var e = 700;
					(body.hasClass("author-template") || body.hasClass("page-template")) && (e = 0),
					setTimeout(function () {
						api.mainPost()
					}, e)
				})
			})
		},
		postList : function () {
			$(function () {
				var e = $(mClass.POST_LIST),
				t = e.find(".post");
				t.each(function (n, o) {
					e.css("border-right-color", "#eee"),
					setTimeout(function () {
						$(o).animo({
							animation : "fadeInLeft",
							duration : .4,
							keep : !0,
							timing : "ease-in-out"
						}),
						t.length == n + 1 && api.niceScrollPostList()
					}, 200 * n)
				})
			})
		},
		mainPost : function () {
			$(function () {
				$(mClass.POST_MOD + " article").animo({
					animation : "fadeInUp",
					duration : .6,
					keep : !0,
					timing : "ease-in-out"
				}, function () {
					$(mClass.POST_MOD + " .ds-share, #comment").fadeIn(),
					$(mClass.POST_LIST + " .pagination").fadeIn(),
					$(mClass.POST_CONTAINER).find(".go-top").length || $(mClass.POST_CONTAINER).append('<p class="clearfix"><span class="pull-right go-top"><i class="fa fa-arrow-circle-o-up"></i>\u8fd4\u56de\u9876\u90e8</span></p>'),
					win.trigger("debouncedresize")
				})
			})
		},
		calcDate : function (e) {
			return moment(e).fromNow()
		},
		diffDate : function () {
			$(mClass.POST_MOD + " .meta-date span").each(function (e, t) {
				var n = $(t).text(),
				o = api.calcDate(n),
				r = 0;
				o.indexOf("\u79d2") > -1 ? r = 300 : o.indexOf("\u5206\u949f") > -1 ? r = 600 : $(t).html(o),
				r && !function (t, n, o) {
					momentHandle[e] = setInterval(function () {
							t.html(api.calcDate(n))
						}, o)
				}
				($(t), n, r)
			})
		},
		clearDiff : function () {
			for (var e in momentHandle)
				clearInterval(momentHandle[e])
		}
	};
	return $(function ($) {
		function loadPagination() {
			State = History.getState(),
			$.get(State.url, function (e) {
				$(mClass.POST_LIST).replaceWith($(e).find(mClass.POST_LIST)),
				api.niceScrollPostList(),
				api.postList()
			})
		}
		function highlight_post() {
			var e = $(mClass.POST_CONTAINER + " .post").attr("id");
			$(mClass.POST_LIST + " .post").removeClass(sClass.CUR_POST),
			$("#m-list-" + e).addClass(sClass.CUR_POST)
		}
		var History = window.History,
		State = History.getState(),
		$container = $(mClass.POST_MOD + " > .row");
		if (body.on("click", mClass.POST_LIST + " .post-title a, " + mClass.POST_LIST + " .post-thumbnail-link", function (e) {
				e.preventDefault();
				var t = $(this).attr("href"),
				n = $(this).text();
				History.pushState({
					state : "ajax"
				}, n, t)
			}), body.on("click", mClass.POST_LIST + " .pagination a", function (e) {
				e.preventDefault();
				var t = $(this).attr("href"),
				n = document.title;
				History.pushState({
					state : "pagination"
				}, n, t)
			}), body.on("click", mClass.POST_MOD + " .go-top", function () {
				$("html, body").animate({
					scrollTop : 0
				}, 600)
			}), body.find(".meta-comments a").on("click", function (e) {
				e.preventDefault(),
				$("html, body").animate({
					scrollTop : $("#comment").offset().top
				}, 600)
			}), History.Adapter.bind(window, "statechange", function () {
				State = History.getState(),
				"pagination" == State.data.state ? loadPagination() : $(mClass.POST_MOD + " article").animo({
					animation : "fadeOutDown",
					duration : .3,
					keep : !0,
					timing : "ease-in-out"
				}, function () {
					State = History.getState(),
					$(mClass.POST_CONTAINER).prepend('<div class="preloader fadeIn post-preloader"><i class="fa fa-cog fa-spin"></i></div>'),
					$container.load(State.url + " " + mClass.POST_CONTAINER, function (data) {
						$(mClass.POST_CONTAINER).find(".post-preloader").css("opacity", 0).delay(900).fadeOut();
						var html = $(data),
						newPostContainer = $(mClass.POST_CONTAINER, html),
						inlineScript = newPostContainer.find("script");
						if (0 != inlineScript.length)
							for (var ix = 0; ix < inlineScript.length; ix++)
								eval(inlineScript[ix].text);
							body.scrollTop() > 0 && $("html, body").animate({
								scrollTop : $(mClass.POST_CONTAINER).offset().top
							}, 600),
							api.mainPost();
							var articles = $(mClass.POST_CONTAINER + " article", html),
							articleList = $(mClass.POST_LIST + " article"),
							firstId = $(articles[0]).attr("id");
							articleList.removeClass(sClass.CUR_POST).filter("#m-list-" + firstId).addClass(sClass.CUR_POST),
							api.clearDiff(),
							api.diffDate(),
							$(mClass.POST_LIST + " .pagination").fadeIn(),
							$(mClass.POST_MOD + " .ds-share, #comment").fadeIn()
						})
					})
				}), 0 == $(mClass.POST_LIST + " article").length && $.get(self.location.protocol.toString() + "//" + self.location.host.toString(), function (e) {
					$(mClass.POST_LIST).replaceWith($(e).find(mClass.POST_LIST)),
					highlight_post()
				}), highlight_post(), win.on("debouncedresize", function () {
					clearTimeout(resizeHandle),
					resizeHandle = setTimeout(function () {
							var e = $(mClass.POST_CONTAINER).parent(".row").height(),
							t = $(window).width(),
							n = $(window).height(),
							o = $(mClass.POST_CONTAINER + ", #sidebar");
							t > 992 && n >= e ? o.css("height", n) : o.css("height", "auto"),
							debug.log("> Debounced Resize :")
						}, 200)
				}).trigger("debouncedresize"), $(mClass.SIDE_BAR).niceScroll({
					touchbehavior : !0,
					cursoropacitymax : .2,
					bouncescroll : !0,
					cursorcolor : "#000",
					railpadding : {
						top : 0,
						right : 2,
						left : 0,
						bottom : 0
					},
					grabcursorenabled : !1
				}), $('[data-toggle="tooltip"]').tooltip(), $CONFIG.data["background-image"]) {
				var img = $CONFIG.data["background-image"];
				$CONFIG.static_cdn && (img = $CONFIG.static_cdn + img),
				body.css({
					"background-position" : "center center",
					"background-image" : "url(" + img + ")"
				})
			}
		api.diffDate()
	}),
	win.load(function () {
		api.header()
	}),
	api
});
undefined;

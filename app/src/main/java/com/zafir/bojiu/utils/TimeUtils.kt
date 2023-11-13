package com.zafir.bojiu.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.roundToInt

//https://blog.csdn.net/weixin_43887257/article/details/118462621
object TimeUtils {

    const val TAG = "TimeUtils"
    const val UNIT_YEAR = "年"
    const val UNIT_MONTH = "月"
    const val UNIT_DAY = "日"
    const val UNIT_HOUR = "时"
    const val UNIT_MINUTE = "分"
    const val MONTH_END = 12
    const val DAY_END = 23
    const val MINUTE_END = 59
    const val YEAR_DAYS = 365
    const val TIME_LIMIT_YEAR_START = 1930
    const val TIME_LIMIT_YEAR_END = 2050
    const val TIME_LIMIT_MONTH_START = 1
    const val TIME_LIMIT_MONTH_END = 11
    const val TIME_LIMIT_DAY_START = 30
    const val TIME_LIMIT_DAY_END = 18

    private val CURREN_TIME_ZONE: TimeZone by lazy {
        TimeZone.getTimeZone(GregorianCalendar().timeZone.id)
    }

    class DataTime {
        var year: Int = 0
        var month: Int = 0
        var day: Int = 0
        var hour: Int = 0
        var minute: Int = 0
        var second: Int = 0

        constructor(
            year: Int?, month: Int?, day: Int?
        ) {
            this.year = year ?: getCurrentYear()
            this.month = month ?: getCurrentMonth()
            this.day = day ?: getCurrentDay()
        }

        constructor(
            year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int
        ) {
            this.year = year
            this.month = month
            this.day = day
            this.hour = hour
            this.minute = minute
            this.second = second
        }

        override fun toString(): String {
            return "DataTime(year=$year, month=$month, day=$day, hour=$hour, minute=$minute, second=$second)"
        }

        fun toFormatYMD(): String {
            return year.toString() + "-" + formatTime(month) + "-" + formatTime(day)
        }

        fun toFormatYMDH(): String {
            return year.toString() + "-" + formatTime(month) + "-" + formatTime(day) + " " + formatTime(
                hour
            )
        }

        fun toFormatYMDHM(): String {
            return year.toString() + "-" + formatTime(month) + "-" + formatTime(day) + " " + formatTime(hour) + " " + formatTime(minute)
        }
    }

    fun getCurrentYMD(): String {
        return "${getCurrentYear()}-${getCurrentMonth()}-${getCurrentDay()}"
    }

    fun getCurrentDayJD(): Int {
        val date = Date(System.currentTimeMillis())
        return getJulianDay(
            date.year + 1900, date.month + 1, date.date, 0, 0, 0
        )
    }

    fun getCurrentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    fun getCurrentMonth(): Int {
        return Calendar.getInstance().get(Calendar.MONTH) + 1
    }

    fun getCurrentDay(): Int {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }

    fun getCurrentDayOfWeek(): Int {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    }

    fun getCurrentHourOfDay(): Int {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }

    fun getCurrentMinute(): Int {
        return Calendar.getInstance().get(Calendar.MINUTE)
    }

    fun getMonthMaxDays(year: Int, month: Int): Int {
        val strDate = "$year-$month"
        val sdf = SimpleDateFormat("yyyy-MM", Locale.getDefault())
        val calendar: Calendar = GregorianCalendar()
        calendar.time = sdf.parse(strDate) as Date
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    //获取时间毫秒数
    fun data2TimeMillis(year: Int, month: Int, day: Int): Long {
        return data2TimeMillis(year, month, day, 0, 0, 0)
    }

    fun data2TimeMillis(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
        return data2TimeMillis(year, month, day, hour, minute, 0)
    }

    private fun data2TimeMillis(
        year: Int,
        month: Int,
        day: Int,
        hour: Int,
        minute: Int,
        second: Int
    ): Long {
        var y = year
        var m = month
        var d = day

        if (y == 0) {
            y = getCurrentYear()
        }
        if (m == 0) {
            m = getCurrentMonth()
        }
        if (d == 0) {
            d = getCurrentDay()
        }
        val str = "$y-$m-$d $hour:$minute:$second"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = dateFormat.parse(str)
        return date?.time ?: 0
    }

    fun dateAndHourMinute2TimeMillis(
        ymd: String, time: String?
    ): Long {
        var t = time
        if (TextUtils.isEmpty(time)) {
            t = "00:00"
        }
        val str = "$ymd $t:00"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = dateFormat.parse(str)
        return date?.time ?: 0
    }

    @JvmStatic
    fun getDateHourMinuteFromTimeMillis(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        return format.format(date)
    }

    @JvmStatic
    fun getDateFromTimeMillis(millisecond: Long): DataTime {
        if (millisecond == 0L) return DataTime(null, null, null)
        val date = Date(millisecond)
        return DataTime(
            date.year + 1900, date.month + 1, date.date, date.hours, date.minutes, date.seconds
        )
    }

    fun getJdFromTimeMillis(millisecond: Long): Int {
        val date = Date(millisecond)
        return getJulianDay(
            date.year + 1900, date.month + 1, date.date, date.hours, date.minutes, date.seconds
        )
    }

    fun getJdFromYMD(ymd: String): Int {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(ymd)
        return getJulianDay(
            date.year + 1900, date.month + 1, date.date, date.hours, date.minutes, date.seconds
        )
    }

    fun getDataTimeFromYMD(ymd: String): DataTime {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(ymd)
        return DataTime(
            date.year + 1900, date.month + 1, date.date, date.hours, date.minutes, date.seconds
        )
    }

    //获取儒略历，可用于日期换算
    fun getJdFromYMD(y: Int, m: Int, d: Int): Int {
        return getJulianDay(y, m, d, 0, 0, 0)
    }

    fun getJdToday(): Int {
        return getJulianDay(getCurrentYear(), getCurrentMonth(), getCurrentDay(), 0, 0, 0)
    }

    fun getMinuteOfDay(timestamp: Long): Int {
        //时间戳是从 1970-1-1 8：00 开始算的
        val ts = timestamp + DateUtils.DAY_IN_MILLIS
        //当天秒数
        val sec = floor(((ts % DateUtils.DAY_IN_MILLIS) / 1000).toDouble())
        // 分钟
        val min = floor(sec / 60).toInt()
        // 小时
        val hr = min / 60
        return min
    }

    @JvmStatic
    fun getHourFromTimeMillis(timestamp: Long): Int {
        val date = Date(timestamp)
        return date.hours
    }


    /**
     * 获取日历事件结束日期
     *
     * @param time time in ms
     */
    private fun getEndDate(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        return format.format(date)
    }

    /**
     * 获取最终日历事件重复规则
     *
     * @param time time in ms
     */
    @JvmStatic
    fun getFinalRRuleMode(time: Long): String {
        return getEndDate(time) + "T235959Z"
    }

    fun getDayOfWeek(time: Long): Int {
        val date = Date(time)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.DAY_OF_WEEK]
    }

    fun getDayOfMonth(time: Long): Int {
        val date = Date(time)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.DAY_OF_MONTH]
    }

    fun getMonthOfYear(time: Long): Int {
        val date = Date(time)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.MONTH]
    }

    //儒略历转公历，可用于日期换算
    fun toDataTimeFromJulian(jd: Double): DataTime {
        val Z = floor(jd + 0.5).toInt()
        val F = jd + 0.5 - Z
        val A = if (Z < 2299161) {
            Z
        } else {
            val a = floor((Z - 1867216.25) / 36524.25).toInt()
            Z + 1 + a - a / 4
        }
        val B = A + 1524
        val C = ((B - 122.1) / 365.25).toInt()
        val D = (365.25 * C).toInt()
        val E = floor((B - D) / 30.6001).toInt()
        val d = B - D - floor(30.6001 * E).toInt() + F
        val m = if (E < 14) E - 1 else E - 13
        val y = if (m > 2) C - 4716 else C - 4715
        return DataTime(y, m, d.toInt(), 0, 0, 0)
    }

    fun toMillisFromJulian(jd: Double): Long {
        val dateTime = toDataTimeFromJulian(jd)
        return data2TimeMillis(
            dateTime.year,
            dateTime.month,
            dateTime.day,
            dateTime.hour,
            dateTime.minute,
            dateTime.second
        )
    }

    @JvmStatic
    fun toMillisFromJulian(jd: Double, hour: Int): Long {
        val dateTime = toDataTimeFromJulian(jd)
        return data2TimeMillis(
            dateTime.year, dateTime.month, dateTime.day, hour, dateTime.minute, dateTime.second
        )
    }

    @JvmStatic
    fun getYMDFromJulian(jd: Int): String {
        val dateTime = toDataTimeFromJulian(jd.toDouble())
        return dateTime.toFormatYMD()
    }

    fun toDataTimeFromJulian(jd: Int): DataTime {
        return toDataTimeFromJulian(jd.toDouble())
    }

    /**
     * 获取儒略日
     *
     * @return 儒略日
     *
     * 2460024.5 -- 2460025.5 代表 2023年3月21日 00:00:00  ,如果向下取整数，则是2460024 到了2023年3月20日 12:00:00
     * 所以采用四舍五入
     */
    fun getJulianDay(year: Int, month: Int, day: Int, hours: Int, minutes: Int, sec: Int): Int {
        var y: Int = year
        var m: Int = month
        val d: Double = day + ((sec * 1.0 / 60 + minutes) / 60 + hours) / 24

        var n = 0
        val g = y * 372 + m * 31 + d.toInt() >= 588829
        if (m <= 2) {
            m += 12
            y--
        }
        if (g) {
            n = (y * 1.0 / 100).toInt()
            n = 2 - n + (n * 1.0 / 4).toInt()
        }
        val r = (365.25 * (y + 4716)).toInt() + (30.6001 * (m + 1)).toInt() + d + n - 1524.5
        return r.roundToInt()
    }

    /**
     * 判断指定时间和当前时间是否是同一天
     */
    fun isSameDay(lastDay: Long): Boolean {
        val today: Long = getCurrentDayLong()
        return today == lastDay
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDayLong(): Long {
        return SimpleDateFormat("yyyyMMdd").format(Date()).toLong()
    }

    fun isGregorianRepeatMonth(list: MutableList<Long>): Boolean {
        var month = 0
        var day = 0
        list.forEach {
            val curMonth = getMonthOfYear(it)
            val curDay = getDayOfMonth(it)
            if (day == 0) {
                month = curMonth
                day = curDay
            } else if (day != curDay || curMonth != (month + 1) % 12) {
                return false
            } else {
                month = curMonth
            }
        }
        return true
    }

    fun isGregorianRepeatYear(list: MutableList<Long>): Boolean {
        var month = 0
        var day = 0
        list.forEach {
            val curMonth = getMonthOfYear(it)
            val curDay = getDayOfMonth(it)
            if (day == 0) {
                month = curMonth
                day = curDay
            } else if (day != curDay || month != curMonth) {
                return false
            }
        }
        return true
    }

    fun formatTimeByTimeZone(
        y: Int, m: Int, d: Int,
        h: Int,
        min: Int,
        sec: Int
    ): DataTime {
        return getDateFromTimeMillis(
            data2TimeMillis(
                y,
                m,
                d,
                h,
                min,
                sec
            ) - CURREN_TIME_ZONE.rawOffset
        )
    }

    fun formatTime(timeInfo: Int): String {
        return if (timeInfo < 10) "0$timeInfo" else timeInfo.toString()
    }

    @JvmStatic
    fun long2String(time: Long, format: String?): String {
        return try {
            val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
            simpleDateFormat.format(Date(time))
        } catch (e: Exception) {
            ""
        }
    }

    @JvmStatic
    fun isWeekend(year: Int, month: Int, day: Int): Boolean {
        val calendar = Calendar.getInstance()
        calendar[year, month - 1] = day
        val dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY
    }

}
package com.cimcitech.epaydemo;

/**
 * Created by qianghe on 2018/9/28.
 */

public class Config {
    public static final String IP = "https://szykcz.com/"; //IP
    public static final String POST_LOGIN = IP + "andrLg/lg"; //1.2、登录
    public static String token ;
            //"eyJhbGciOiJIUzI1NiJ9.eyJwUm9vbUlkIjo0OSwiY2hlY2tTdGF0dXMiOjEsInJlc2lkZW50aWFsVXNlciI6eyJ1c2VySWQiOjE2LCJ1c2VySWNvbiI6Ii9lenNoL3VwbG9hZC9pbWFnZXMvdXNlckljb25JbWcvMTYvMjAxNzA4MTIxNjMzMzguanBnIiwidXNlckxpbmtwaG9uZSI6IjE1NzY4NjE2MDAyIiwidXNlckFjY291bnQiOiIxNTc2ODYxNjAwMiIsInVzZXJQYXNzd29yZCI6bnVsbCwidXNlck5hbWUiOiLlpKflj6QiLCJ1c2VyU2V4Ijoi55S3IiwidXNlck5pY2tuYW1lIjoi5aSn5Y-kIiwidXNlclNlcmlhbE51bWJlciI6IjE1MTUxNTE1MSIsInVzZXJJZGVudGl0eUNhcmQiOiI0NDIwMjAwMjAyMDIwMjMwMyIsInVzZXJUZWFjaGVyRmVlU3RhdHVzIjowLCJ1c2VyVGVhY2hlckZlZVZhbGlkIjoiMjAxODAxIiwidXJvb21MaXN0IjpudWxsLCJ1bXNJZHNJbmZvIjp7InVNc0lkIjo0NywicFVzZXJJZCI6MTYsInBNYW5hZ2VySWQiOjEsInBCdWlsZElkIjozMCwicFJvb21JZCI6NDksInBPd25lcklkIjpudWxsLCJyZWdpc3Rlck5hbWUiOm51bGwsInJlZ2lzdGVyVGVsZXBob25lIjpudWxsLCJpZGVudGlmeUNsYXNzaWZ5IjoxLCJhcHBseVRpbWUiOiIyMDE4LTA2LTE2IiwiY2hlY2tTdGF0dXMiOjEsImZhaWx1cmVJbmZvIjpudWxsLCJwcml2aWxlZ2UiOm51bGwsIm1hbmFnZXJOYW1lIjoi5oOg5bee5a2m6ZmiIiwid2VsZmFyZUZ1bmQiOm51bGwsIm1hbmFnZXJJbmZvIjpudWxsLCJidWlsZEluZm8iOm51bGwsInJvb21JbmZvIjpudWxsfSwidXNlckludGVncmFsIjo4MzUzLjQ0fSwibG9ja0xpc3QiOlt7ImxvY2tJZCI6MSwiZGV2aWNlSWQiOiI1OEEzOUYzQyIsImRldmljZVBhc3MiOiIxMjM0NTY3OCIsInB0QnVpbGRJZCI6MTMsImJ1aWxkTmFtZSI6IjHmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabpmaIiLCJwdFVzZXJJZCI6bnVsbH0seyJsb2NrSWQiOjQsImRldmljZUlkIjoiNThBM0I5MDgiLCJkZXZpY2VQYXNzIjoiMTIzNDU2MDAiLCJwdEJ1aWxkSWQiOjI1LCJidWlsZE5hbWUiOiIxMDDmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabpmaIiLCJwdFVzZXJJZCI6bnVsbH0seyJsb2NrSWQiOjUsImRldmljZUlkIjoiMTNERDgzRkQiLCJkZXZpY2VQYXNzIjoiMTIzNDU2NzgiLCJwdEJ1aWxkSWQiOjI3LCJidWlsZE5hbWUiOiIxMeagiyIsInB0TWFuYWdlcklkIjoxLCJtYW5hZ2VyTmFtZSI6IuaDoOW3nuWtpumZoiIsInB0VXNlcklkIjpudWxsfSx7ImxvY2tJZCI6NiwiZGV2aWNlSWQiOiIxM0U1RjczQyIsImRldmljZVBhc3MiOiIxMjM0NTY3OCIsInB0QnVpbGRJZCI6MjgsImJ1aWxkTmFtZSI6IjEy5qCLIiwicHRNYW5hZ2VySWQiOjEsIm1hbmFnZXJOYW1lIjoi5oOg5bee5a2m6ZmiIiwicHRVc2VySWQiOm51bGx9LHsibG9ja0lkIjo3LCJkZXZpY2VJZCI6IjEzRTVGNDFEIiwiZGV2aWNlUGFzcyI6IjEyMzQ1Njc4IiwicHRCdWlsZElkIjoyOSwiYnVpbGROYW1lIjoiMTPmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabpmaIiLCJwdFVzZXJJZCI6bnVsbH1dLCJwQnVpbGRJZCI6MzAsIm1hbmFnZXJJZCI6MSwiZXhwIjoxNTM4NDE3ODA0LCJ1c2VySWQiOjE2LCJpZGVudGlmeUNsYXNzaWZ5IjoxfQ.TNsKPqJ5gVFEpJGdQ-IqobXWkdHDz2aUAjw5fcbgQUo";
    /*public static final String token =
            "eyJhbGciOiJIUzI1NiJ9.eyJwUm9vbUlkIjo0OSwiY2hlY2tTdGF0dXMiOjEsInJlc" +
            "2lkZW50aWFsVXNlciI6eyJ1c2VySWQiOjE2LCJ1c2VySWNvbiI6Ii9lenNoL3VwbG9hZC9pbWFnZXMvdXNlckljb25JbW" +
            "cvMTYvMjAxNzA4MTIxNjMzMzguanBnIiwidXNlckxpbmtwaG9uZSI6IjE1NzY4NjE2MDAyIiwidXNlckFjY291bnQiOiI" +
            "xNTc2ODYxNjAwMiIsInVzZXJQYXNzd29yZCI6bnVsbCwidXNlck5hbWUiOiLlpKflj6QiLCJ1c2VyU2V4Ijoi55S3Iiwi" +
            "dXNlck5pY2tuYW1lIjoi5aSn5Y-kIiwidXNlclNlcmlhbE51bWJlciI6IjE1MTUxNTE1MSIsInVzZXJJZGVudGl0eUNhc" +
            "mQiOiI0NDIwMjAwMjAyMDIwMjMwMyIsInVzZXJUZWFjaGVyRmVlU3RhdHVzIjowLCJ1c2VyVGVhY2hlckZlZVZhbGlkIj" +
            "oiMjAxODAxIiwidXJvb21MaXN0IjpudWxsLCJ1bXNJZHNJbmZvIjp7InVNc0lkIjo0NywicFVzZXJJZCI6MTYsInBNYW5" +
            "hZ2VySWQiOjEsInBCdWlsZElkIjozMCwicFJvb21JZCI6NDksInBPd25lcklkIjpudWxsLCJyZWdpc3Rlck5hbWUiOm51" +
            "bGwsInJlZ2lzdGVyVGVsZXBob25lIjpudWxsLCJpZGVudGlmeUNsYXNzaWZ5IjoxLCJhcHBseVRpbWUiOiIyMDE4LTA2L" +
            "TE2IiwiY2hlY2tTdGF0dXMiOjEsImZhaWx1cmVJbmZvIjpudWxsLCJwcml2aWxlZ2UiOm51bGwsIm1hbmFnZXJOYW1lI" +
            "joi5oOg5bee5a2m6ZmiIiwid2VsZmFyZUZ1bmQiOm51bGwsIm1hbmFnZXJJbmZvIjpudWxsLCJidWlsZEluZm8iOm51b" +
            "GwsInJvb21JbmZvIjpudWxsfSwidXNlckludGVncmFsIjo4MzUzLjQ0fSwibG9ja0xpc3QiOlt7ImxvY2tJZCI6MSwi" +
            "ZGV2aWNlSWQiOiI1OEEzOUYzQyIsImRldmljZVBhc3MiOiIxMjM0NTY3OCIsInB0QnVpbGRJZCI6MTMsImJ1aWxkTmFt" +
            "ZSI6IjHmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabpmaIiLCJwdFVzZXJJZCI6bnVs" +
            "bH0seyJsb2NrSWQiOjQsImRldmljZUlkIjoiNThBM0I5MDgiLCJkZXZpY2VQYXNzIjoiMTIzNDU2MDAiLCJwdEJ1aWxk" +
            "SWQiOjI1LCJidWlsZE5hbWUiOiIxMDDmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabp" +
            "maIiLCJwdFVzZXJJZCI6bnVsbH0seyJsb2NrSWQiOjUsImRldmljZUlkIjoiMTNERDgzRkQiLCJkZXZpY2VQYXNzIjoi" +
            "MTIzNDU2NzgiLCJwdEJ1aWxkSWQiOjI3LCJidWlsZE5hbWUiOiIxMeagiyIsInB0TWFuYWdlcklkIjoxLCJtYW5hZ2Vy" +
            "TmFtZSI6IuaDoOW3nuWtpumZoiIsInB0VXNlcklkIjpudWxsfSx7ImxvY2tJZCI6NiwiZGV2aWNlSWQiOiIxM0U1Rjcz" +
            "QyIsImRldmljZVBhc3MiOiIxMjM0NTY3OCIsInB0QnVpbGRJZCI6MjgsImJ1aWxkTmFtZSI6IjEy5qCLIiwicHRNYW5hZ" +
            "2VySWQiOjEsIm1hbmFnZXJOYW1lIjoi5oOg5bee5a2m6ZmiIiwicHRVc2VySWQiOm51bGx9LHsibG9ja0lkIjo3LCJkZX" +
            "ZpY2VJZCI6IjEzRTVGNDFEIiwiZGV2aWNlUGFzcyI6IjEyMzQ1Njc4IiwicHRCdWlsZElkIjoyOSwiYnVpbGROYW1lIjo" +
            "iMTPmoIsiLCJwdE1hbmFnZXJJZCI6MSwibWFuYWdlck5hbWUiOiLmg6Dlt57lrabpmaIiLCJwdFVzZXJJZCI6bnVsbH1d" +
            "LCJwQnVpbGRJZCI6MzAsIm1hbmFnZXJJZCI6MSwiZXhwIjoxNTM4MzQzMjA3LCJ1c2VySWQiOjE2LCJpZGVudGlmeUNsY" +
            "XNzaWZ5IjoxfQ.mb2BZ5fPqpy4ycdnd4xA0x6iCTiJepZ6PUd5YZf81OU";*/
    public static final String imageIp = "https://szykcz.com"; //IP
    public static final String wxAPPID = "wx9cfaa6b78e58ef15"; //微信支付APPID
    public static final String aliAPPID = "2017082208323037";//支付宝APPID

    public static final String propertyPay = IP + "chargeMobileT/propertyPay";//6.3、提交物业费支付
}

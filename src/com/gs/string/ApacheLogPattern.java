package com.gs.string;

/**
 * Problem Statement-
 * Given an Apache log file, return IP address(es) which accesses the site most often.
 * our log is in this format (Common Log Format). One entry per line.
 * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
 * Log file entries are passsed as an array.
 * NOTE: In case of tie, this returns a comma-separated list of the IP addresses. Tie is not mentioned explicitly in the exercise on purpose.
 *
 * Signature:
 *                 String findTopIpaddress(String[] lines){
 *                 }
 *
 * Test Cases:
 * Input:
 * String lines[] = new String[]{
 *                 "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
 * Output : 10.0.0.1
 *
 * Input:
 * String  lines[] = new String[]{
 *                 "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
 *                 "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
 * Output - 10.0.0.1,10.0.0.2
 */
public class ApacheLogPattern {
    public static void main(String[] args) {

    }
}

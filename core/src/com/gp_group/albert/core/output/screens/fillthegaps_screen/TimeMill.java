package com.gp_group.albert.core.output.screens.fillthegaps_screen;

/**
 * Created by ac4r_g0 on 08/05/2015.
 */
public class TimeMill {
    public static void main(String[] arg) throws InterruptedException {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        Thread.sleep(10000); // llamamos a la tarea
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
    }
}

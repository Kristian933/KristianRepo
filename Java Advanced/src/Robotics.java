import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Robotics {
    public static void main(String[] args) throws IOException {


        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] robots = sc.readLine().split(";");
        String[] time = sc.readLine().split(":");
        Clock clock = new Clock(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
        ArrayList<Robot> list = new ArrayList<Robot>();
        for(int i=0; i<robots.length; i++){
            String[] robotSpecs = robots[i].split("-");
            int procTime = Integer.parseInt(robotSpecs[1]);
            String name = robotSpecs[0];
            Robot robot = new Robot(procTime,name,true);
            list.add(robot);
        }
        Deque<String> queue = new ArrayDeque<String>();
        while(true){
            String input = sc.readLine();
            if(input.equals("End")){
                break;
            }
            queue.add(input);
        }
        clock.addSecond();
        while(queue.peek() !=null) {
            String product = queue.poll();
            boolean allBusy = true;
            for(int i=0; i<list.size();i++){
                if(!list.get(i).isFree()){
                    list.get(i).pushSecond();
                }
                if(list.get(i).isFree()){
                    allBusy = false;
                }
            }
            if(!allBusy) {
                for (Robot robot : list) {
                    if (robot.isFree()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(robot.getName());
                        sb.append(" - ");
                        sb.append(product);
                        sb.append(" ");
                        sb.append(clock.getTime());
                        System.out.println(sb.toString());
                        robot.setBusy();
                        break;
                    }
                }
            }
            if(allBusy){
                queue.addLast(product);
            }
            clock.addSecond();
        }

    }
}
class Clock{
    int hour;
    int minutes;
    int seconds;

    public Clock(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getTime(){
        return String.format("[%02d:%02d:%02d]", hour,minutes,seconds);
    }
    public void addSecond(){
        seconds++;
        if(seconds==60){
            seconds=0;
            addMinute();
        }
    }

    public void addMinute(){
        minutes++;
        if(minutes==60){
            minutes=0;
            addHour();
        }
    }
    public void addHour(){
        hour++;
        if(hour==24){
            hour = 0;
        }
    }
}

class Robot{
    private int processingTime;
    private String name;
    boolean free;
    private int countTillFree;

    public Robot(int processingTime, String name, boolean free) {
        this.processingTime = processingTime;
        this.name = name;
        this.free = free;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(){
        this.free = true;
    }
    public void setBusy(){
        this.free=false;
        this.countTillFree=this.processingTime;
    }
    public void pushSecond(){
        if(countTillFree!=0) {
            countTillFree--;
        }
        if(countTillFree==0){
            setFree();
        }
    }
}

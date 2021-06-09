package thinking.chapter10;

import java.util.ArrayList;
import java.util.List;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-20 14:43
 */

public class Controller {
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {
        eventList.add(c);
        print("add:" + c);
//        for (Event event : eventList) {
//            print("addEvent delayTime:" + event.delayTime+":"+event);
//        }

    }
    public void run() {
        while(eventList.size() > 0) {
            for(Event e : new ArrayList<Event> (eventList)) {
                if(e.ready()) {
                    print("run delayTime:" + e.delayTime + ":" + e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }

    }
}

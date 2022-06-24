/*
* Nome: José Miguel Pinto de Sousa
* Número: 8200689
* Turma: LEI
*
* Nome: Ricardo Moreira da Fonte
* Número: 8200520
* Turma: LSIRC
 */
package api;

import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.EventManager;
import estgconstroi.Notifier;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.EventManagerException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author phrea
 */
public class WorkerEventManager implements EventManager {

    private static final int MAX = 100;

    private Notifier notifiers[] = new Notifier[MAX];
    private Event events[] = new Event[MAX];

    private int count = 0;

    @Override
    public void addNotifier(Notifier ntfr) throws EventManagerException {
        if (notifiers.length == MAX) {
            increaseArraySize();
        }

        this.notifiers[count] = ntfr;
        this.count++;
    }

    @Override
    public void removeNotifier(Notifier ntfr) throws EventManagerException {
        if (findNotify(ntfr) != -1) {
            for (int i = findNotify(ntfr); i < count - 1; i++) {
                notifiers[i] = notifiers[i + 1];
            }
            notifiers[count - 1] = null;
            count--;
        }
    }

    @Override
    public void reportEvent(Event event) throws EventManagerException {
        if (events.length == MAX) {
            increaseArraySize();
        }
        
        this.events[count] = event;
        this.count++;
    }

    @Override
    public void removeAllEvents() {
        
    }

    @Override
    public void removeEvent(Event event) throws EventManagerException {
        if (findEvent(event) != -1 ) {
            // for (int i = findEvent(event)) {
                
            //}
        }
    }

    @Override
    public Event[] getEvent(EventPriority ep) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Event[] getEvent(Class type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Event[] getEvent(LocalDate ld) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Event[] getEvent(LocalDate ld, LocalDate ld1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void increaseArraySize() {
        Notifier[] temp = new Notifier[notifiers.length * 2];

        for (int i = 0; i < notifiers.length; i++) {
            temp[i] = notifiers[i];
        }
        notifiers = temp;
    }

    private int findNotify(Notifier notify) {

        if (notify == null) {
            return -1;
        }

        if (notify instanceof NotifierCollection) {

            for (int i = 0; i < count; i++) {
                if (notifiers[i].equals(notify)) {
                    return i;
                }
            }
        } else {
            return -1;
        }

        return -1;
    }

    private int findEvent(Event event) {
        count = 0;

        if (event == null) {
            return -1;
        }

        if (event instanceof WorkEvent) {
            for (int i = 0; i < count; i++) {
                if (events[i].equals(event)) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }
}

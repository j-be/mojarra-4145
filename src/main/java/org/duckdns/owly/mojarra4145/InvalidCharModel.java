package org.duckdns.owly.mojarra4145;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;

@ApplicationScoped
@Named("invalidCharModel")
public class InvalidCharModel {
    private Map<Integer, String> entries = new TreeMap<>();
    private String newEntry = null;
    private Integer nextKey = 0;

    @PostConstruct
    public void addEntries() {
        insert("First Entry");
        insert("Second Entry");
    }

    private void insert(String value) {
        if (value != null && !value.isEmpty()) {
            entries.put(nextKey, value);
            nextKey++;
        }
    }

    public List<Map.Entry<Integer, String>> getEntries() {
        return new ArrayList<>(entries.entrySet());
    }

    public void addInvalidEntry() {
        insert("Printing invalid character: \u000c");
    }

    public void setNewEntry(String newEntry) {
        this.newEntry = newEntry;
    }

    public String getNewEntry() {
        return newEntry;
    }

    public void addNewEntry() {
        insert(newEntry);
        newEntry = "";
    }

    public void removeInvalidEntries() {
        Set<Integer> keySetCopy = new HashSet<>(entries.keySet());

        for (Integer i : keySetCopy)
            if (entries.get(i).contains("" + '\u000c'))
                entries.remove(i);
    }
}

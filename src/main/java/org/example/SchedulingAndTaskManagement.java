package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchedulingAndTaskManagement {

    private Map<String, List<String>> chefTasks = new HashMap<>();
    private Map<String, List<String>> notifications = new HashMap<>();

    public void assignTaskToChef(String task, String chefName) {
        chefTasks.putIfAbsent(chefName, new ArrayList<>());
        chefTasks.get(chefName).add(task);

        notifications.putIfAbsent(chefName, new ArrayList<>());
        notifications.get(chefName).add("New task assigned: " + task);
    }

    public List<String> getTasksForChef(String chefName) {
        return chefTasks.getOrDefault(chefName, new ArrayList<>());
    }

    public List<String> getNotificationsForChef(String chefName) {
        return notifications.getOrDefault(chefName, new ArrayList<>());
    }

    public Map<String, Integer> getWorkloadPerChef() {
        Map<String, Integer> workload = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : chefTasks.entrySet()) {
            workload.put(entry.getKey(), entry.getValue().size());
        }
        return workload;
    }

    public List<String> getOverworkedChefs(int threshold) {
        List<String> overworked = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : chefTasks.entrySet()) {
            if (entry.getValue().size() > threshold) {
                overworked.add(entry.getKey());
            }
        }
        return overworked;
    }
}


/*
    My approach is to store data in the HashMap, where 'key' would be the String provided, and the 'value' would be a List of Value objects.
    To set a new Value object we just prepend it to the existing ArrayList or create a brand new one if the value for the provided key was empty.
    To retreive String for the provided key with the timestamp, we use Binary Search to maximize the value of the Value object and keeping it 
    less than provided timestamp.
    
    set(): 
        Time Complexity: O(1)
    get(): 
        Time Complexity: O(log(n))
    Space Complexity: O(k * n)
*/

class TimeMap {
    Map<String, ArrayList<Value>> values;

    public TimeMap() {
        this.values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Value newValue = new Value(value, timestamp);
        ArrayList<Value> values = this.values.getOrDefault(key, new ArrayList<>());
        values.addLast(newValue);
        this.values.put(key, values);
    }

    public String get(String key, int timestamp) {
        ArrayList<Value> values = this.values.getOrDefault(key, new ArrayList<>());
        
        int left = 0;
        int right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int middle = left + ((right - left) / 2);

            Value temp = values.get(middle);
            if (temp.getTimestamp() <= timestamp) {
                result = temp.getValue();
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return result;
    }
}

class Value {
    private final String value;
    private final int timestamp;

    public Value(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return this.value;
    }

    public int getTimestamp() {
        return this.timestamp;
    }
}
